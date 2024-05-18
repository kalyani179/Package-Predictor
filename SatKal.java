import Components.About.About;
import Components.Feedback.Feedback;
import Components.Home.NavBar;
import Constants.Constants;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.concurrent.Flow;

class SatKal{
    public static void main(String[] args) {
        JFrame frame = new JFrame("SatKal");

        NavBar navbar = new NavBar();
        About about = new About();
        Feedback feedback = new Feedback();
        
        // frame.add(navbar);
        // frame.add(about);
        frame.add(feedback);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setResizable(false);
        frame.setSize(Constants.width,Constants.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}