import javax.swing.*;
import java.awt.*;

public class Window {

    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 400;

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        Screen screen = new Screen(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, Color.cyan);

        frame.add(screen);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setTitle("My what's app bot ");
    }
}
