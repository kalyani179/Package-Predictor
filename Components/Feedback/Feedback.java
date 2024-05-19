package Components.Feedback;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Constants.Constants;

public class Feedback extends JPanel implements ActionListener{
    private JTextField name,email;
    JTextArea feedbackMessage;
    private JButton submit; 
    public Feedback(){
        JLabel heading = new JLabel();
        heading.setText("Feedback Form");
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Serif", Font.BOLD, 48));
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setBounds(0, 30, Constants.width - 100, 50);

        // center positions
        int centerX = Constants.width / 2 - 210;
        int centerY = Constants.height / 2;

        name = new JTextField("Enter Your Name");
        name.setFont(new Font("Montserrat", Font.BOLD, 18));
        name.setBounds(centerX, centerY - 180,Constants.width/4,40);

        email = new JTextField("Enter Your Email ID");
        email.setFont(new Font("Montserrat", Font.BOLD, 18));
        email.setBounds(centerX, centerY - 120,Constants.width/4,40);

        feedbackMessage = new JTextArea("Enter your Feedback");
        feedbackMessage.setFont(new Font("Montserrat", Font.BOLD, 18));
        feedbackMessage.setLineWrap(true);
        feedbackMessage.setWrapStyleWord(true);
        feedbackMessage.setBounds(centerX, centerY - 60, Constants.width / 4, 100);


        JScrollPane scrollPane = new JScrollPane(feedbackMessage);
        scrollPane.setBounds(centerX, centerY - 60, Constants.width / 4, 100);

        submit = new JButton("Submit");
        submit.setFont(new Font("Montserrat", Font.BOLD, 18));
        submit.addActionListener(this);
        submit.setBounds(centerX, centerY + 60,Constants.width/4,40);

        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(Constants.width, Constants.height));
        this.setLayout(null);
        this.add(heading);
        this.add(name);
        this.add(email);
        this.add(feedbackMessage);
        this.add(scrollPane);
        this.add(submit);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            System.out.println(name.getText());
            System.out.println(email.getText());
            System.out.println(feedbackMessage.getText());
        }
    }
}
