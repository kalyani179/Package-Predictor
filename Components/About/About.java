package Components.About;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Constants.Constants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class About extends JPanel{
    public About() {
        JLabel headingLabel = new JLabel();
        headingLabel.setText("About");
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("Serif", Font.BOLD, 48));
        headingLabel.setHorizontalAlignment(JLabel.CENTER);
        headingLabel.setBounds(50, 20, Constants.width - 100, 50); // Adjust position and size of heading label

        JLabel contentLabel = new JLabel();
        contentLabel.setText("<html>Welcome to the Potential Package Predictor! Our application is engineered to anticipate the placement package of college students by analyzing various academic and extracurricular metrics. Through the application of sophisticated machine learning algorithms, we offer students invaluable insights into their potential career trajectories, aiding them in strategic educational and professional planning. By amalgamating regression and classification techniques, our predictor ensures precise and dependable predictions. Essential factors such as CGPA, backlog count, and coding problem-solving proficiency are meticulously considered in determining the anticipated placement package.<br><br>Powered by Java, our user-friendly interface provides a seamless experience for users of all technical proficiencies. Each prediction is uniquely crafted to cater to the individual student's profile, offering tailored insights into their future career prospects. The process is simple: students input their academic data, including CGPA, backlog count, and coding proficiency, after which our system applies machine learning algorithms to analyze the data and generate an estimate of their potential placement package.<br><br>Our ultimate aim is to equip students with the knowledge required to make informed decisions about their educational and career paths. With the Potential Package Predictor, students can gain a realistic understanding of their placement potential, enabling them to navigate their academic and professional journeys with confidence. Thank you for choosing the Potential Package Predictor; we wish you success in your endeavors ahead!</html>");
        contentLabel.setForeground(Color.WHITE);
        contentLabel.setFont(new Font("Oswald", Font.PLAIN, 21));
        contentLabel.setPreferredSize(new Dimension(Constants.width - 100, 700));
        contentLabel.setHorizontalAlignment(JLabel.LEFT);
        contentLabel.setVerticalAlignment(JLabel.TOP);
        contentLabel.setBounds(50, 110, Constants.width - 100, 500); // Adjust position and size of content label

        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(Constants.width, 600));
        this.add(headingLabel);
        this.add(contentLabel);
        this.setLayout(null);
    }
}
