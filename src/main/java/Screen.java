import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {


    TheBot theBot = new TheBot();
    private ImageIcon logo;
    private final JButton start = new JButton("start :");

    public Screen(int x, int y, int WHIDTH, int HIGHET, Color color) {
        this.setBounds(x, y, WHIDTH, HIGHET);
        this.logo = new ImageIcon("src/main/image/WhatsApp logo.png");

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //main color + logo
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(this.logo.getImage(), 0, 0, 100, 20, null);

        start.setBounds(getWidth() / 2 - 50, getHeight() / 2, 100, 30);
        add(start);
        start.addActionListener((event) -> {
            start.setVisible(false);
            theBot.start();
        });

    }

}
