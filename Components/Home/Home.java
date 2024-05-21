package Components.Home;

import javax.swing.*;

import Constants.Constants;

import java.awt.*;

public class Home extends JPanel {

    public Home() {
        this.setBackground(Color.BLACK);
        this.setForeground(Color.white);
        this.setBounds(0,100,Constants.width,Constants.height - 100);
        setLayout(new BorderLayout());
        // Top panel with buttons
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JButton button1 = createRoundedButton("Button 1");
        JButton button2 = createRoundedButton("Button 2");
        
        topPanel.add(button1);
        topPanel.add(button2);
        
        // Main form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(20, 2, 10, 10));  // 20 rows for each form field
        
        // Stream dropdown
        formPanel.add(new JLabel("Stream:"));
        JComboBox<String> streamDropdown = new JComboBox<>(new String[]{"CSE", "ECE", "IT", "ME", "EEE", "Civil", "Chemical"});
        formPanel.add(streamDropdown);
        
        // Gender radio buttons
        formPanel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        formPanel.add(genderPanel);
        
        // Age in years
        formPanel.add(new JLabel("Age in years:"));
        JTextField ageField = new JTextField();
        formPanel.add(ageField);
        
        // 10th result in %
        formPanel.add(new JLabel("10th result in %:"));
        JTextField tenthResultField = new JTextField();
        formPanel.add(tenthResultField);
        
        // 12th result in %
        formPanel.add(new JLabel("12th result in %:"));
        JTextField twelfthResultField = new JTextField();
        formPanel.add(twelfthResultField);
        
        // BTech CGPA
        formPanel.add(new JLabel("BTech CGPA:"));
        JTextField btechCgpaField = new JTextField();
        formPanel.add(btechCgpaField);
        
        // Number of backlogs
        formPanel.add(new JLabel("Number of backlogs:"));
        JTextField backlogsField = new JTextField();
        formPanel.add(backlogsField);
        
        // Codechef stars radio buttons
        formPanel.add(new JLabel("Codechef stars:"));
        JPanel codechefStarsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup codechefStarsGroup = new ButtonGroup();
        for (int i = 0; i <= 5; i++) {
            JRadioButton starButton = new JRadioButton(String.valueOf(i));
            codechefStarsGroup.add(starButton);
            codechefStarsPanel.add(starButton);
        }
        formPanel.add(codechefStarsPanel);
        
        // CodeForces title dropdown
        formPanel.add(new JLabel("CodeForces title:"));
        JComboBox<String> codeforcesDropdown = new JComboBox<>(new String[]{
            "Account not created", "Newbie", "Pupil", "Apprentice", "Specialist",
            "Expert", "Candidate master", "Master", "International master", "Grandmaster"
        });
        formPanel.add(codeforcesDropdown);
        
        // Hackerrank number of questions solved
        formPanel.add(new JLabel("Hackerrank number of questions solved:"));
        JTextField hackerrankSolvedField = new JTextField();
        formPanel.add(hackerrankSolvedField);
        
        // Leetcode number of questions solved
        formPanel.add(new JLabel("Leetcode number of questions solved:"));
        JTextField leetcodeSolvedField = new JTextField();
        formPanel.add(leetcodeSolvedField);
        
        // Aptitude proficiency radio buttons
        formPanel.add(new JLabel("Aptitude proficiency:"));
        JPanel aptitudePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup aptitudeGroup = new ButtonGroup();
        String[] proficiencyLevels = {"Beginner", "Medium", "Expert"};
        for (String level : proficiencyLevels) {
            JRadioButton proficiencyButton = new JRadioButton(level);
            aptitudeGroup.add(proficiencyButton);
            aptitudePanel.add(proficiencyButton);
        }
        formPanel.add(aptitudePanel);
        
        // Communication proficiency radio buttons
        formPanel.add(new JLabel("Communication proficiency:"));
        JPanel communicationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup communicationGroup = new ButtonGroup();
        for (String level : proficiencyLevels) {
            JRadioButton proficiencyButton = new JRadioButton(level);
            communicationGroup.add(proficiencyButton);
            communicationPanel.add(proficiencyButton);
        }
        formPanel.add(communicationPanel);
        
        // Work experience in months
        formPanel.add(new JLabel("Work experience in months:"));
        JTextField workExperienceField = new JTextField();
        formPanel.add(workExperienceField);
        
        // Number of certifications
        formPanel.add(new JLabel("Number of certifications:"));
        JTextField certificationsField = new JTextField();
        formPanel.add(certificationsField);
        
        // Current package in LPA
        formPanel.add(new JLabel("Current package in LPA:"));
        JTextField packageField = new JTextField();
        formPanel.add(packageField);
        
        // Predict button
        JButton predictButton = new JButton("Predict");
        formPanel.add(new JLabel());  // Empty label to align button
        formPanel.add(predictButton);

        // Add top panel and form panel to main panel
        add(topPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        repaint();
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
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                super.paintComponent(g);
            }
            
            @Override
            protected void paintBorder(Graphics g) {
                g.setColor(getForeground());
                g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
            }
        };
        button.setContentAreaFilled(false);
        return button;
    }
}
