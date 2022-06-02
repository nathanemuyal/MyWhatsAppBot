import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static final int WINDOW_WHIDTH = 500;
    public static final int WINDOW_HIGHET = 700;

    public Window() {
        Screen screen = new Screen(0, 0, WINDOW_WHIDTH, WINDOW_HIGHET, Color.cyan);
        this.add(screen);
        this.setSize(WINDOW_WHIDTH, WINDOW_HIGHET);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("My what's app bot ");
    }
}
