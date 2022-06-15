
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {


    TheBot theBot = new TheBot();
    private final ImageIcon logo;
    JButton start = new JButton("start");
    public boolean wait = false;
    String numPhone;
    String SMS;


    JButton send = new JButton("send");


    public Screen(int x, int y, int WHIDTH, int HIGHET, Color color) {
        this.setBounds(x, y, WHIDTH, HIGHET);
        this.logo = new ImageIcon("src/main/image/WhatsApp logo.png");


    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //main color + logo
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.drawImage(this.logo.getImage(), 0, 0, 100, 20, null);

        if (!this.theBot.getActivateQR()) {

            start.setBounds(getWidth() / 2 - 50, getHeight() / 2, 100, 30);
            add(start);
            start.addActionListener((event) -> {
                start.setVisible(false);
                try {
                    this.theBot.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
        if (this.theBot.getActivateQR() && !wait) {

            g.setColor(Color.green);
            g.setFont(new Font("serif", Font.BOLD, 50));
            g.drawString("welcome", getWidth() / 2 - 100, 270);

            repaint();
            wait5s();


        }
        if (this.theBot.getActivateQR() && wait) {

            send.setBounds(getWidth() / 2 - 50, getHeight() -50, 100, 30);
            add(send);
            send.addActionListener((event) -> {
                send.setVisible(false);

            });
            repaint();

        }


    }

    public void wait5s() {
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            wait = true;

        }).start();


    }


}
