import javax.swing.JFrame;

import java.awt.Color;

import Components.About.About;
import Components.Feedback.Feedback;
import Components.Home.Home;
import Components.Home.NavBar;
import Constants.Constants;

class SatKal{
    public static void main(String[] args) {
        JFrame frame = new JFrame("SatKal");

        NavBar navbar = new NavBar();
        About about = new About();
        Feedback feedback = new Feedback();
        Home home = new Home();
        // frame.add(about);
        // frame.add(feedback);
        frame.setLayout(null);
        frame.add(navbar);
        frame.add(home);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setResizable(false);
        frame.setSize(Constants.width,Constants.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.repaint();
    }
}