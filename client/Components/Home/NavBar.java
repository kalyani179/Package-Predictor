package Components.Home;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

import Constants.Constants;

class Hamburger extends JButton {
    Hamburger() {
        ImageIcon hamburgerIcon = new ImageIcon("./Assets/Menu.png");
        ImageIcon disabledIcon = new ImageIcon("./Assets/close.webp");
        Image img = hamburgerIcon.getImage();
        Image img2 = disabledIcon.getImage();
        Image closeResize = img2.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        Image resizedImg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        disabledIcon = new ImageIcon(closeResize);
        hamburgerIcon = new ImageIcon(resizedImg);

        this.setBackground(Color.black);
        this.setForeground(Color.black);
        this.setIcon(hamburgerIcon);
        this.setOpaque(true);
        this.setText("");
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setDisabledIcon(disabledIcon);
    }
}

public class NavBar extends JPanel {
    public static boolean isMenuActive = false;
    private JDialog menuDialog;

    public NavBar() {
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setBounds(0, 0, Constants.width, 55);
        getLogo();
    }

    private void showMenuDialog() {
        if (menuDialog == null) {
            menuDialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Menu", false);
            menuDialog.setUndecorated(false);
            menuDialog.setBackground(Color.black);
            menuDialog.setSize(200, 200);
            menuDialog.setLayout(new GridLayout(3, 1));

            JButton homeButton = new JButton("Home");
            homeButton.setBackground(Color.black);
            homeButton.setForeground(Color.black);

            JButton aboutButton = new JButton("About");
            aboutButton.setBackground(Color.black);
            aboutButton.setForeground(Color.black);

            JButton feedbackButton = new JButton("Feedback");
            feedbackButton.setBackground(Color.black);
            feedbackButton.setForeground(Color.black);

            menuDialog.add(homeButton);
            menuDialog.add(aboutButton);
            menuDialog.add(feedbackButton);

            homeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Home button clicked");
                }
            });

            aboutButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("About button clicked");
                }
            });

            feedbackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Feedback button clicked");
                }
            });

            // Position the dialog at the top right corner
            Dimension screenSize = getToolkit().getScreenSize();
            int x = screenSize.width - menuDialog.getWidth();
            int y = 100;
            menuDialog.setLocation(new Point(x, y));

            // Disable window dragging
            menuDialog.addWindowListener(new WindowAdapter() {
                @Override
                public void windowDeactivated(WindowEvent e) {
                    menuDialog.setVisible(false);
                    NavBar.isMenuActive = false;
                }
            });

            menuDialog.setVisible(true);
        } else {
            menuDialog.setVisible(true);
        }
    }

    public void getLogo() {
        JLabel logo = new JLabel("SatKal");
        Hamburger menu = new Hamburger();
        menu.setBounds(Constants.width - 80, 10, 50, 50);
        menu.setEnabled(!NavBar.isMenuActive);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!NavBar.isMenuActive) {
                    showMenuDialog();
                } else {
                    menuDialog.setVisible(false);
                }
                NavBar.isMenuActive = !NavBar.isMenuActive;
                menu.setEnabled(!NavBar.isMenuActive);
            }
        });
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