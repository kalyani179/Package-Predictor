import javax.swing.JFrame;
import java.awt.*;
import Components.*;
class SatKal{
    public static void main(String[] args) {
        JFrame frame = new JFrame("SatKal");

        NavBar navbar = new NavBar();
        navbar.getLogo();
        
        frame.add(navbar);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setResizable(false);
        frame.setSize(Constants.width,Constants.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}