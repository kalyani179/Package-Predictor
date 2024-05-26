package Constants;
import java.awt.Dimension;
import java.awt.Toolkit;
public class Constants {
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int width = screenSize.width;
    public static int height = screenSize.height;
}
