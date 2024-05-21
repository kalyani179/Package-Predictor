package Components.Home;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import Constants.Constants;

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
        this.setBounds(0,0,Constants.width, 50);
        getLogo();
    }

    public void getLogo() {
        JLabel logo = new JLabel("SatKal");
        Hamburger menu = new Hamburger();
        menu.setBounds(Constants.width - 80, 10, 50, 50);

        logo.setForeground(Color.white);
        logo.setBackground(Color.black);
        logo.setBorder(new EmptyBorder(20, 20, 20, 20));
        logo.setFont(new Font("Serif", Font.BOLD, 48));
        logo.setOpaque(true);
        logo.setBounds(5, 5, 250, 50);

        this.add(logo);
        this.add(menu);
    }
}
