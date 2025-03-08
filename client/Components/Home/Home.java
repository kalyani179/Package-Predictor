package Components.Home;

import javax.swing.*;
import Constants.Constants;
import java.awt.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.lang.Thread;
import javax.swing.SwingUtilities;
import org.json.JSONObject;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class Home extends JPanel {
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Montserrat", Font.BOLD, 18));
        return label;
    }

    public Home() {
        Dimension preferredSize = new Dimension(150, 35);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.white);
        this.setBounds(50, 50, Constants.width - 100, Constants.height-150);
        setLayout(new BorderLayout());

        // Top panel with buttons
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        topPanel.setBackground(Color.BLACK);

        JButton button1 = createRoundedButton("Individual");
        button1.setFont(new Font("Montserrat", Font.BOLD, 18));
        button1.setMargin(new Insets(5, 20, 5, 20));

        JButton button2 = createRoundedButton("Mass/Group");
        button2.setFont(new Font("Montserrat", Font.BOLD, 18));
        button2.setMargin(new Insets(5, 20, 5, 20));

        // Adding buttons to top panel
        topPanel.add(button1);
        topPanel.add(button2);

        // Main form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10); // Padding
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Stream dropdown
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("Stream:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        String[] streams = {
            "Computer Science and Engineering (CSE)",
            "Electronics and Communication Engineering (ECE)",
            "Information Technology (IT)",
            "Chemical Engineering",
            "Electrical and Electronics Engineering (EEE)",
            "Civil Engineering"
        };
        JComboBox<String> streamDropdown = new JComboBox<>(streams);
        streamDropdown.setPreferredSize(preferredSize);
        formPanel.add(streamDropdown, gbc);

        // Gender radio buttons
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("Gender:"), gbc);
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        maleButton.setFocusable(false); // Disable focus border
        femaleButton.setFocusable(false); // Disable focus border
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        genderPanel.setPreferredSize(preferredSize);
        formPanel.add(genderPanel, gbc);

        // Age in years
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("Age in years:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JTextField ageField = new JTextField();
        ageField.setPreferredSize(preferredSize);
        addPlaceholderBehavior(ageField, "Age in years");
        formPanel.add(ageField, gbc);

        // 10th result in %
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("10th result in %:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JTextField tenthResultField = new JTextField();
        tenthResultField.setPreferredSize(preferredSize);
        addPlaceholderBehavior(tenthResultField, "10th result in %");
        formPanel.add(tenthResultField, gbc);

        // 12th result in %
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("12th result in %:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JTextField twelfthResultField = new JTextField();
        twelfthResultField.setPreferredSize(preferredSize);
        addPlaceholderBehavior(twelfthResultField, "Inter result in %");
        formPanel.add(twelfthResultField, gbc);

        // BTech CGPA
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("BTech CGPA:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JTextField btechCgpaField = new JTextField();
        btechCgpaField.setPreferredSize(preferredSize);
        addPlaceholderBehavior(btechCgpaField, "BTech CGPA");
        formPanel.add(btechCgpaField, gbc);

        // Number of backlogs
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("Number of backlogs:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JTextField backlogsField = new JTextField();
        backlogsField.setPreferredSize(preferredSize);
        addPlaceholderBehavior(backlogsField, "Number of backlogs");
        formPanel.add(backlogsField, gbc);

         // Codechef stars radio buttons
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("Codechef stars:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JPanel codechefStarsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup codechefStarsGroup = new ButtonGroup();
        for (int i = 0; i <= 5; i++) {
            JRadioButton starButton = new JRadioButton(String.valueOf(i));
            starButton.setFocusable(false); // Disable focus border
            codechefStarsGroup.add(starButton);
            codechefStarsPanel.add(starButton);
        }
        codechefStarsPanel.setPreferredSize(preferredSize);
        formPanel.add(codechefStarsPanel, gbc);

        // CodeForces title dropdown
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("CodeForces title:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JComboBox<String> codeforcesDropdown = new JComboBox<>(new String[]{
                "Account Not Created",  
                "Newbie",
                "Pupil",
                "Apprentice",
                "Expert"
                // Removed titles not in training data:
                // "Specialist", "Candidate master", "Master", 
                // "International master", "Grandmaster"
        });
        codeforcesDropdown.setFocusable(false);
        codeforcesDropdown.setPreferredSize(preferredSize);
        formPanel.add(codeforcesDropdown, gbc);

        // empty panel for gap
        gbc.gridx = 2;
        gbc.gridy = 0;
        JPanel gapPanel = new JPanel();
        gapPanel.setPreferredSize(new Dimension(30, 0));
        formPanel.add(gapPanel, gbc);

        // Number of coding questions solved (Hackerrank, leetcode, geeksforgeeks)
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("Number of coding questions solved:"), gbc);
        gbc.gridx = 4;

        String[] platforms = {"Hacker rank", "Leetcode", "GeeksForGeeks"};
        String[] ranges = {"0", "1-50", "50-150", "150-300", "more than 300"};
        Map<String, ButtonGroup> platformGroups = new HashMap<>();
        for (String platform : platforms) {
            gbc.gridx = 3;
            gbc.gridy++;
            gbc.anchor = GridBagConstraints.WEST;
            formPanel.add(createLabel(platform + ":"), gbc);

            JPanel platformPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            ButtonGroup platformGroup = new ButtonGroup();
            for (String range : ranges) {
                JRadioButton rangeButton = new JRadioButton(range);
                rangeButton.setFocusable(false); // Disable focus border
                platformGroup.add(rangeButton);
                platformPanel.add(rangeButton);
            }
            gbc.gridx = 4;
            gbc.anchor = GridBagConstraints.EAST;
            formPanel.add(platformPanel, gbc);
            platformGroups.put(platform, platformGroup);
        }

        // Aptitude proficiency radio buttons
        gbc.gridx = 3;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("Aptitude proficiency:"), gbc);
        gbc.gridx = 4;
        gbc.anchor = GridBagConstraints.EAST;
        JPanel aptitudePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup aptitudeGroup = new ButtonGroup();
        String[] proficiencyLevels = {"Beginner", "Medium", "Expert"};
        for (String level : proficiencyLevels) {
            JRadioButton proficiencyButton = new JRadioButton(level);
            proficiencyButton.setFocusable(false); // Disable focus border
            aptitudeGroup.add(proficiencyButton);
            aptitudePanel.add(proficiencyButton);
        }
        aptitudePanel.setPreferredSize(preferredSize);
        formPanel.add(aptitudePanel, gbc);

        // Communication proficiency radio buttons
        gbc.gridx = 3;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("Communication proficiency:"), gbc);
        gbc.gridx = 4;
        gbc.anchor = GridBagConstraints.EAST;
        JPanel communicationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup communicationGroup = new ButtonGroup();
        for (String level : proficiencyLevels) {
            JRadioButton proficiencyButton = new JRadioButton(level);
            proficiencyButton.setFocusable(false); // Disable focus border
            communicationGroup.add(proficiencyButton);
            communicationPanel.add(proficiencyButton);
        }
        communicationPanel.setPreferredSize(preferredSize);
        formPanel.add(communicationPanel, gbc);

        // Work experience in months
        gbc.gridx = 3;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("Work experience in months:"), gbc);
        gbc.gridx = 4;
        gbc.anchor = GridBagConstraints.EAST;
        JTextField experienceField = new JTextField();
        experienceField.setPreferredSize(preferredSize);
        addPlaceholderBehavior(experienceField, "Work experience in months");
        formPanel.add(experienceField, gbc);

        // Number of certifications
        gbc.gridx = 3;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("Number of certifications:"), gbc);
        gbc.gridx = 4;
        gbc.anchor = GridBagConstraints.EAST;
        JTextField certificationsField = new JTextField();
        certificationsField.setPreferredSize(preferredSize);
        addPlaceholderBehavior(certificationsField, "Number of certifications");
        formPanel.add(certificationsField, gbc);

        // Add the predict button panel
        JPanel predictButtonPanel = new JPanel();
        predictButtonPanel.setBackground(Color.BLACK);
        predictButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton predictButton = new JButton("Predict");
        predictButton.setBackground(new Color(0xfacc15));
        predictButton.setPreferredSize(new Dimension(200, 50));
        predictButton.setFont(new Font("Montserrat", Font.BOLD, 18));
        predictButton.setMargin(new Insets(0, 20, 0, 20));
        predictButtonPanel.add(predictButton);

        add(topPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(predictButtonPanel, BorderLayout.SOUTH);

        // Modify the predict button action listener
        predictButton.addActionListener(e -> {
            // Collect all the form data
            Map<String, String> formData = new HashMap<>();
            formData.put("stream", streamDropdown.getSelectedItem().toString());
            formData.put("gender", maleButton.isSelected() ? "Male" : "Female");
            formData.put("age", ageField.getText());
            formData.put("tenth_result", tenthResultField.getText());
            formData.put("twelfth_result", twelfthResultField.getText());
            formData.put("btech_cgpa", btechCgpaField.getText());
            formData.put("backlogs", backlogsField.getText());
            
            // Get selected codechef stars
            for (Enumeration<AbstractButton> buttons = codechefStarsGroup.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    formData.put("codechef_stars", button.getText());
                    break;
                }
            }
            
            formData.put("codeforces_title", codeforcesDropdown.getSelectedItem().toString());
            
            // Add coding platform problems solved
            for (String platform : platforms) {
                ButtonGroup group = platformGroups.get(platform);
                for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
                    AbstractButton button = buttons.nextElement();
                    if (button.isSelected()) {
                        formData.put(platform.toLowerCase().replace(" ", "_") + "_problems", button.getText());
                        break;
                    }
                }
            }

            // Add proficiency levels
            for (Enumeration<AbstractButton> buttons = aptitudeGroup.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    formData.put("aptitude_level", button.getText());
                    break;
                }
            }

            for (Enumeration<AbstractButton> buttons = communicationGroup.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    formData.put("communication_level", button.getText());
                    break;
                }
            }
            
            formData.put("experience", experienceField.getText());
            formData.put("certifications", certificationsField.getText());
            
            // Send data to backend
            new Thread(() -> {
                try {
                    URL url = new URL("http://localhost:5000/predict");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setRequestProperty("Accept", "application/json");
                    conn.setDoOutput(true);

                    // Convert map to JSON string
                    JSONObject jsonObject = new JSONObject(formData);
                    String jsonInputString = jsonObject.toString();

                    try(OutputStream os = conn.getOutputStream()) {
                        byte[] input = jsonInputString.getBytes("utf-8");
                        os.write(input, 0, input.length);           
                    }

                    try(BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                        StringBuilder response = new StringBuilder();
                        String responseLine = null;
                        while ((responseLine = br.readLine()) != null) {
                            response.append(responseLine.trim());
                        }
                        
                        // Parse response
                        JSONObject jsonResponse = new JSONObject(response.toString());
                        String prediction = jsonResponse.getString("prediction");
                        String confidence = jsonResponse.getString("confidence");
                        
                        // Update UI with prediction
                        SwingUtilities.invokeLater(() -> {
                            JOptionPane.showMessageDialog(this, 
                                "Predicted Package: " + prediction + "\nConfidence: " + confidence,
                                "Prediction Result",
                                JOptionPane.INFORMATION_MESSAGE);
                        });
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(this,
                            "Error connecting to server: " + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    });
                }
            }).start();
        });
    }

    private JButton createRoundedButton(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isArmed()) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(new Color(0xfacc15));
                }
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
                super.paintComponent(g);
            }

            @Override
            protected void paintBorder(Graphics g) {
                g.setColor(getForeground());
                g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
            }
        };
        button.setContentAreaFilled(false);
        button.setFocusPainted(false); // Disable focus border
        return button;
    }

    private void addPlaceholderBehavior(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                }
            }
        });
    }
}
