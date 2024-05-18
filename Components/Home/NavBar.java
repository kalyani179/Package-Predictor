package Components.Home;

import Constants.Constants;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;


class CurvyButton extends JButton {
    CurvyButton(String text) {
        this.setBackground(Color.white);
        this.setOpaque(true);
        this.setBorder(new EmptyBorder(10,10,10,10));
        this.setFont(new Font("Serif", Font.BOLD, 24));
        this.setText(text);
    }
}


class SelectionPanel extends JPanel {
    public static int width = Constants.width - 200;
    public static int height = Constants.height / 12;

    SelectionPanel() {
        this.setBackground(Color.black);
        this.setForeground(Color.white);
        this.setLayout(null); // Using null layout for absolute positioning

        CurvyButton ind = new CurvyButton("Individual");
        ind.setBounds(0,0,SelectionPanel.width/3,SelectionPanel.height);
        CurvyButton grp = new CurvyButton("Mass/Group");
        grp.setBounds(SelectionPanel.width/3,0,SelectionPanel.width/2,SelectionPanel.height);
        this.add(ind);
        this.add(grp);
    }
}

class Hamburger extends JLabel {
    Hamburger() {
        ImageIcon hamburgerIcon = new ImageIcon("./Assets/Menu.png");
        
        Image img = hamburgerIcon.getImage();
        Image resizedImg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        hamburgerIcon = new ImageIcon(resizedImg);        
        
        this.setBackground(Color.black);
        this.setForeground(Color.WHITE);
        this.setIcon(hamburgerIcon);
        this.setOpaque(true);
    }
}

public class NavBar extends JPanel {
    public NavBar() {
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(Constants.width, 300));
        getLogo();
    }

    public void getLogo() {
        JLabel logo = new JLabel("SatKal");
        Hamburger menu = new Hamburger();
        menu.setBounds(Constants.width - 80, 10, 50, 50);

        SelectionPanel sp = new SelectionPanel();
        sp.setBounds(50, 50, SelectionPanel.width, SelectionPanel.height); // Adjust position within NavBar

        logo.setForeground(Color.white);
        logo.setBackground(Color.black);
        logo.setBorder(new EmptyBorder(20, 20, 20, 20));
        logo.setFont(new Font("Serif", Font.BOLD, 48));
        logo.setOpaque(true);
        logo.setBounds(5, 5, 250, 50);

        this.add(logo);
        this.add(menu);
        this.add(sp);
    }
}
