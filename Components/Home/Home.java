package Components.Home;
import javax.swing.*;

import Constants.Constants;

import java.awt.*;

public class Home extends JPanel {
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Montserrat", Font.BOLD, 18));
        return label;
    }

    public Home() {
        Dimension preferredSize = new Dimension(150,30);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.white);
        this.setBounds(50, 50, Constants.width - 100, Constants.height-100);
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

        topPanel.add(button1);
        topPanel.add(button2);

        // Main form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 10); // Padding
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Stream dropdown
        formPanel.add(createLabel("Stream:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JComboBox<String> streamDropdown = new JComboBox<>(new String[]{"CSE", "ECE", "IT", "ME", "EEE", "Civil", "Chemical"});
        streamDropdown.setFocusable(false); // Disable focus border
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
        JTextField ageField = new JTextField("Age in years");
        ageField.setPreferredSize(preferredSize);
        formPanel.add(ageField, gbc);

        // 10th result in %
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("10th result in %:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JTextField tenthResultField = new JTextField("10th result in %");
        tenthResultField.setColumns(20);
        tenthResultField.setPreferredSize(preferredSize);
        formPanel.add(tenthResultField, gbc);


        // 12th result in %
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("12th result in %:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JTextField twelfthResultField = new JTextField("Inter result in %");
        twelfthResultField.setFocusable(false); // Disable focus border
        twelfthResultField.setPreferredSize(preferredSize);
        formPanel.add(twelfthResultField, gbc);

        // BTech CGPA
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("BTech CGPA:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JTextField btechCgpaField = new JTextField("BTech CGPA");
        btechCgpaField.setFocusable(false); // Disable focus border
        btechCgpaField.setPreferredSize(preferredSize);
        formPanel.add(btechCgpaField, gbc);

        // Number of backlogs
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("Number of backlogs:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JTextField backlogsField = new JTextField("Number of backlogs");
        backlogsField.setFocusable(false); // Disable focus border
        backlogsField.setPreferredSize(preferredSize);
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
                "Account not created", "Newbie", "Pupil", "Apprentice", "Specialist",
                "Expert", "Candidate master", "Master", "International master", "Grandmaster"
        });
        codeforcesDropdown.setFocusable(false); // Disable focus border
        codeforcesDropdown.setPreferredSize(preferredSize);
        formPanel.add(codeforcesDropdown, gbc);

        // Hackerrank number of questions solved
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("Hackerrank number of questions solved:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JTextField hackerrankSolvedField = new JTextField("Number of Hackerrank questions sovled");
        hackerrankSolvedField.setFocusable(false); // Disable focus border
        hackerrankSolvedField.setPreferredSize(preferredSize);
        formPanel.add(hackerrankSolvedField, gbc);

        // Leetcode number of questions solved
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("Leetcode number of questions solved:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JTextField leetcodeSolvedField = new JTextField("Number of Leetcode questions solved");
        leetcodeSolvedField.setFocusable(false); // Disable focus border
        leetcodeSolvedField.setPreferredSize(preferredSize);
        formPanel.add(leetcodeSolvedField, gbc);

        // Aptitude proficiency radio buttons
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("Aptitude proficiency:"), gbc);
        gbc.gridx = 1;
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
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("Communication proficiency:"), gbc);
        gbc.gridx = 1;
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
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("Work experience in months:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JTextField workExperienceField = new JTextField("Enter number of months of work");
        workExperienceField.setFocusable(false); // Disable focus border
        workExperienceField.setPreferredSize(preferredSize);
        formPanel.add(workExperienceField, gbc);

        // Number of certifications
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(createLabel("Number of certifications:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JTextField numberOfCertificates = new JTextField("Enter number of certificates");
        numberOfCertificates.setFocusable(false);
        numberOfCertificates.setPreferredSize(preferredSize);
        formPanel.add(numberOfCertificates,gbc);
        // Predict button
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton predictButton = new JButton("Predict");
        predictButton.setBackground(new Color(0xfacc15));
        predictButton.setSize(new Dimension(200, 50));
        predictButton.setFont(new Font("Montserrat", Font.BOLD, 18));
        predictButton.setMargin(new Insets(0, 20, 0, 20));
        formPanel.add(predictButton, gbc);

        // Add top panel and form panel to main panel
        add(topPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
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
}