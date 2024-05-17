package Components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NavBar extends JPanel {
    public NavBar(){
        this.setLayout(null);
        this.setBackground(Color.yellow);
        this.setPreferredSize(new Dimension(Constants.width,300));
        JLabel logo = new JLabel("SatKal");
        logo.setForeground(Color.black);
        logo.setFont(new Font("Serif",Font.BOLD,24));
        logo.setOpaque(true);
        this.add(logo);
    }
}
