package Components.About;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import Constants.Constants;

public class About extends JPanel{
    public About() {
        JLabel heading = new JLabel();
        heading.setText("About");
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Serif", Font.BOLD, 48));
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setBounds(0, 20, Constants.width - 100, 50);

        JLabel content = new JLabel();
        content.setText("<html>Welcome to the Potential Package Predictor! Our application is engineered to anticipate the placement package of college students by analyzing various academic and extracurricular metrics. Through the application of sophisticated machine learning algorithms, we offer students invaluable insights into their potential career trajectories, aiding them in strategic educational and professional planning. By amalgamating regression and classification techniques, our predictor ensures precise and dependable predictions. Essential factors such as CGPA, backlog count, and coding problem-solving proficiency are meticulously considered in determining the anticipated placement package.<br><br>Powered by Java, our user-friendly interface provides a seamless experience for users of all technical proficiencies. Each prediction is uniquely crafted to cater to the individual student's profile, offering tailored insights into their future career prospects. The process is simple: students input their academic data, including CGPA, backlog count, and coding proficiency, after which our system applies machine learning algorithms to analyze the data and generate an estimate of their potential placement package.<br><br>Our ultimate aim is to equip students with the knowledge required to make informed decisions about their educational and career paths. With the Potential Package Predictor, students can gain a realistic understanding of their placement potential, enabling them to navigate their academic and professional journeys with confidence. Thank you for choosing the Potential Package Predictor; we wish you success in your endeavors ahead!</html>");
        content.setForeground(Color.WHITE);
        content.setFont(new Font("Oswald", Font.PLAIN, 21));
        content.setPreferredSize(new Dimension(Constants.width - 100, 700));
        content.setHorizontalAlignment(JLabel.LEFT);
        content.setVerticalAlignment(JLabel.TOP);
        content.setBounds(50, 110, Constants.width - 100, 500);

        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(Constants.width, 600));
        this.setLayout(null);
        this.add(heading);
        this.add(content);
    }
}
