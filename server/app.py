from flask import Flask, request, jsonify
from flask_cors import CORS
import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split, cross_val_score
from sklearn.preprocessing import LabelEncoder
from sklearn.ensemble import RandomForestRegressor
from sklearn.metrics import r2_score
import pickle
import os

app = Flask(__name__)
CORS(app)

def train_model():
    """Train and save the model"""
    try:
        # Read the dataset
        print("Current working directory:", os.getcwd())
        excel_path = os.path.join(os.getcwd(), 'Campus Placement Prediction.xlsx')
        print("Looking for Excel file at:", excel_path)
        
        if not os.path.exists(excel_path):
            print("Error: Excel file not found!")
            return None, None
            
        dataset = pd.read_excel(excel_path)
        print("Excel file loaded successfully")
        print("Number of rows:", len(dataset))
        print("Columns:", dataset.columns.tolist())

        # After loading the dataset
        print("\nOriginal streams in dataset:", dataset['Stream'].unique())
        
        # Before applying the mapping
        if 'Stream' in dataset.columns:
            dataset['Stream'] = dataset['Stream'].map(lambda x: x.strip())  # Remove any whitespace
            print("\nUnique streams after cleaning:", dataset['Stream'].unique())
            
            # Don't map the streams, use them as they are in the dataset
            print("\nFinal streams used for training:", dataset['Stream'].unique())
        
        # Clean the Package column - remove any non-numeric values
        dataset['Current Package in LPA'] = pd.to_numeric(dataset['Current Package in LPA'], errors='coerce')
        # Remove rows where Package is NaN
        dataset = dataset.dropna(subset=['Current Package in LPA'])
        
        # Rename columns for clarity
        dataset.rename(columns={
            'Age (in years)': 'Age',
            '10th Result in % (% = GPA*10)': "Tenth_Grade",
            '12th Result ( in %)': "Inter_Grade",
            'CGPA': "Btech_CGPA",
            'Number of Backlogs': "Backlogs",
            'CodeChef Stars': "CodeChef_Stars",
            'CodeForces Title': "CodeForces_Title",
            'Number of Coding Questions Solved [Hacker rank]': "Hackerrank_Problems",
            'Number of Coding Questions Solved [Leetcode]': "Leetcode_Problems",
            'Number of Coding Questions Solved [GeeksForGeeks]': "GFG_Problems",
            'How do you rate your proficiency in Aptitude': "Aptitude_Level",
            'How do you rate your proficiency in Communication': "Communication_Level",
            'Work Experience (in months) (including internships)': "Experience_Months",
            'Number of Certifications': "Certifications",
            'Current Package in LPA': "Package"
        }, inplace=True)

        print("Columns after renaming:", dataset.columns.tolist())

        # Initialize label encoders
        label_encoders = {}
        categorical_columns = ['Stream', 'Gender', 'CodeForces_Title', 
                             'Hackerrank_Problems', 'Leetcode_Problems', 'GFG_Problems',
                             'Aptitude_Level', 'Communication_Level']

        # Convert all categorical columns to string type and fill NaN values
        for col in categorical_columns:
            # Convert to string and fill NaN values
            dataset[col] = dataset[col].astype(str)
            dataset[col] = dataset[col].replace('nan', 'Unknown')
            dataset[col] = dataset[col].fillna('Unknown')

        # Clean numeric columns
        numeric_columns = ['Age', 'Tenth_Grade', 'Inter_Grade', 'Btech_CGPA', 
                         'Backlogs', 'CodeChef_Stars', 'Experience_Months', 'Certifications']
        
        # Handle numeric columns without inplace operations
        for col in numeric_columns:
            dataset[col] = pd.to_numeric(dataset[col], errors='coerce')
            if col in ['Backlogs', 'CodeChef_Stars', 'Experience_Months', 'Certifications']:
                dataset[col] = dataset[col].fillna(0)
            else:
                dataset[col] = dataset[col].fillna(dataset[col].mean())

        # Encode categorical variables
        for column in categorical_columns:
            if column not in dataset.columns:
                print(f"Error: Column {column} not found in dataset!")
                return None, None
                
            label_encoders[column] = LabelEncoder()
            dataset[column] = label_encoders[column].fit_transform(dataset[column])

        # Prepare features and target
        feature_columns = [
            'Stream', 'Gender', 'Age', 'Tenth_Grade', 'Inter_Grade', 
            'Btech_CGPA', 'Backlogs', 'CodeChef_Stars', 'CodeForces_Title',
            'Hackerrank_Problems', 'Leetcode_Problems', 'GFG_Problems',
            'Aptitude_Level', 'Communication_Level', 'Experience_Months', 
            'Certifications'
        ]
        
        # Verify all feature columns exist
        missing_columns = [col for col in feature_columns if col not in dataset.columns]
        if missing_columns:
            print(f"Error: Missing columns in dataset: {missing_columns}")
            return None, None
            
        X = dataset[feature_columns]
        y = dataset['Package']

        print("Shape of training data:", X.shape)
        print("Number of samples:", len(y))

        # Improve model with better parameters and cross-validation
        model = RandomForestRegressor(
            n_estimators=200,          # Increased from 100
            max_depth=15,              # Control tree depth
            min_samples_split=5,       # Minimum samples required to split
            min_samples_leaf=2,        # Minimum samples required at leaf node
            max_features='sqrt',       # Number of features to consider for best split
            bootstrap=True,            # Use bootstrap samples
            random_state=42,
            n_jobs=-1                  # Use all CPU cores
        )

        # Perform cross-validation
        cv_scores = cross_val_score(model, X, y, cv=5)
        confidence = np.mean(cv_scores) * 100

        # Train the final model on all data
        model.fit(X, y)
        
        # Calculate R-squared score
        y_pred = model.predict(X)
        r2 = r2_score(y, y_pred)
        
        print(f"\nModel Performance:")
        print(f"Cross-validation scores: {cv_scores}")
        print(f"Average CV score (confidence): {confidence:.2f}%")
        print(f"R-squared score: {r2:.4f}")

        # Feature importance analysis
        feature_importance = pd.DataFrame({
            'feature': feature_columns,
            'importance': model.feature_importances_
        })
        feature_importance = feature_importance.sort_values('importance', ascending=False)
        print("\nFeature Importance:")
        print(feature_importance)

        # Save model and encoders
        with open('model.pkl', 'wb') as f:
            pickle.dump(model, f)
        
        with open('label_encoders.pkl', 'wb') as f:
            pickle.dump(label_encoders, f)
        
        # Save confidence score
        with open('model_confidence.txt', 'w') as f:
            f.write(f"{confidence:.2f}")

        print("\nModel trained and saved successfully")
        return model, label_encoders

    except Exception as e:
        print(f"Error training model: {str(e)}")
        import traceback
        traceback.print_exc()
        return None, None

def predict_package(input_data, model, label_encoders):
    """Predict package based on input data"""
    try:
        # Create DataFrame with input data
        input_df = pd.DataFrame({
            'Stream': [input_data['stream']],  # Use the stream value directly
            'Gender': [input_data['gender']],
            'Age': [float(input_data['age'])],
            'Tenth_Grade': [float(input_data['tenth_result'])],
            'Inter_Grade': [float(input_data['twelfth_result'])],
            'Btech_CGPA': [float(input_data['btech_cgpa'])],
            'Backlogs': [int(input_data['backlogs'])],
            'CodeChef_Stars': [int(input_data['codechef_stars'])],
            'CodeForces_Title': [input_data['codeforces_title']],
            'Hackerrank_Problems': [input_data.get('hackerrank_problems', input_data.get('hacker_rank_problems', '0'))],
            'Leetcode_Problems': [input_data['leetcode_problems']],
            'GFG_Problems': [input_data['geeksforgeeks_problems']],
            'Aptitude_Level': [input_data['aptitude_level']],
            'Communication_Level': [input_data['communication_level']],
            'Experience_Months': [float(input_data['experience'])],
            'Certifications': [int(input_data['certifications'])]
        })

        print("Input data after preprocessing:", input_df.to_dict('records')[0])
        print("Available streams in model:", label_encoders['Stream'].classes_)

        # Encode categorical variables
        for column, encoder in label_encoders.items():
            if column in input_df.columns:
                try:
                    input_df[column] = encoder.transform(input_df[column])
                except ValueError as e:
                    print(f"\nError encoding {column}!")
                    print(f"Received value: '{input_df[column].iloc[0]}'")
                    print(f"Available values: {sorted(encoder.classes_)}")
                    raise ValueError(f"Invalid {column} value. Must be one of: {sorted(encoder.classes_)}")

        # Make prediction
        predicted_package = model.predict(input_df)[0]
        
        return predicted_package

    except Exception as e:
        print(f"Error making prediction: {str(e)}")
        raise

# Try to load existing model, or train a new one
model = None
label_encoders = None

try:
    if os.path.exists('model.pkl') and os.path.exists('label_encoders.pkl'):
        model = pickle.load(open('model.pkl', 'rb'))
        label_encoders = pickle.load(open('label_encoders.pkl', 'rb'))
        print("Loaded existing model and encoders")
    else:
        print("Model files not found, training new model...")
        model, label_encoders = train_model()
except Exception as e:
    print(f"Error loading model: {str(e)}")
    print("Training new model...")
    model, label_encoders = train_model()

if model is None or label_encoders is None:
    print("Error: Could not initialize model and encoders")
    exit(1)

@app.route("/")
def hello():
    return "Hello"

@app.route("/predict", methods=['POST'])
def predict():
    try:
        data = request.json
        print("Received data:", data)
        
        if not data:
            return jsonify({
                "status": "error",
                "message": "No data received"
            }), 400

        # Print available values for debugging
        print("Available streams in model:", label_encoders['Stream'].classes_)
        print("Received stream:", data['stream'])
        
        required_fields = ['stream', 'gender', 'age', 'tenth_result', 'twelfth_result', 
                         'btech_cgpa', 'backlogs', 'codechef_stars', 'codeforces_title',
                         'leetcode_problems', 'geeksforgeeks_problems',
                         'aptitude_level', 'communication_level', 'experience', 'certifications']
        
        # Check for either hackerrank_problems or hacker_rank_problems
        if 'hackerrank_problems' not in data and 'hacker_rank_problems' not in data:
            required_fields.append('hackerrank_problems')
        
        missing_fields = [field for field in required_fields if field not in data]
        if missing_fields:
            return jsonify({
                "status": "error",
                "message": f"Missing required fields: {', '.join(missing_fields)}"
            }), 400

        # Make prediction using the model
        predicted_package = predict_package(data, model, label_encoders)
        
        # Load confidence from file
        try:
            with open('model_confidence.txt', 'r') as f:
                confidence = float(f.read())
        except:
            confidence = 85.0  # Default if file not found

        # Prepare response
        response = {
            "status": "success",
            "prediction": f"{predicted_package:.2f} LPA",
            "confidence": f"{confidence:.1f}%",
            "received_data": data
        }
        
        return jsonify(response)

    except Exception as e:
        print(f"Error in prediction: {str(e)}")
        import traceback
        traceback.print_exc()
        return jsonify({
            "status": "error",
            "message": str(e),
            "received_data": data
        }), 400

if __name__ == '__main__':
    app.run(debug=True)