import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {

    TheBot theBot;
    private final ImageIcon logo;
    JButton start;
    JButton send;
    int control;

    public boolean wait;
    public boolean isSend;
    JTextField numPhoneText;
    JTextField smsText;


    public Screen(int x, int y, int WHIDTH, int HIGHETH, Color color) {
        this.setBounds(x, y, WHIDTH, HIGHETH);
        this.logo = new ImageIcon("src/main/image/WhatsApp logo.png");
        this.theBot = new TheBot();
        this.control = 0;


        numPhoneText = new JTextField();
        smsText = new JTextField();
        isSend = false;
        start = new JButton("start");
        send = new JButton("send");
        wait = false;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //color + logo
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
            g.drawString("welcome", getWidth() / 2 - 100, getHeight() / 2);

            repaint();

            wait3s();


        }
        if (this.theBot.getActivateQR() && wait && !isSend) {


            g.setColor(Color.black);
            g.setFont(new Font("arial", Font.BOLD, 25));
            g.drawString("Number phone only in israel(+972)", 50, 100);

            numPhoneText.setBounds(50, 125, getWidth() - 100, 30);
            add(numPhoneText);

            g.setColor(Color.black);
            g.setFont(new Font("arial", Font.BOLD, 25));
            g.drawString("the message", getWidth() / 2 - 75, 200);

            smsText.setBounds(50, 225, getWidth() - 100, 30);
            add(smsText);


            send.setBounds(getWidth() / 2 - 50, getHeight() - 75, 100, 30);
            add(send);
            send.addActionListener((event) -> {
                if (correctNumber() && correctText()) {
                    isSend = true;
                    this.theBot.setThePhone(numPhoneText.getText(), control);
                    this.theBot.setText(smsText.getText());
                    try {
                        this.theBot.toChat();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }


    }

    public void wait3s() {
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            wait = true;
        }).start();
    }

    public boolean correctNumber() {
        if (numPhoneText.getText().length() == 0) {
            noPhone();
            return false;
        }
//
        if (numPhoneText.getText().length() != 10 && numPhoneText.getText().length() != 13) {
            noCorrectPhone();
            return false;
        }
        String str = "";
        if (numPhoneText.getText().length() == 10) {

            for (int i = 0; i < 2; i++) {
                str += numPhoneText.getText().charAt(i);

            }
            if (str.equals("05")) {
                control = 2;
            } else {
                noCorrectPhone();
                return false;
            }
        } else {

            for (int i = 0; i < 5; i++) {
                str += numPhoneText.getText().charAt(i);
            }
            if (str.equals("+9725")) {
                control = 5;
            } else {
                noCorrectPhone();
                return false;
            }
        }
        for (int i = control; i < numPhoneText.getText().length(); i++) {
            int ascii = (int) numPhoneText.getText().charAt(i);
            if (ascii < 47 && ascii > 58) {
                noCorrectPhone();
                return false;
            }
        }
        return true;
    }

    public boolean correctText() {
        if (smsText.getText().length() == 0) {
            noCorrectText();
            return false;
        }
        return true;
    }

    public void noPhone() {
        JOptionPane.showMessageDialog(this, "No phone");
    }

    public void noCorrectPhone() {
        JOptionPane.showMessageDialog(this, "This number phone not correct");
    }

    public void noCorrectText() {
        JOptionPane.showMessageDialog(this, "No text");
    }

    public void isSend() {
        JOptionPane.showMessageDialog(this, "shipped successfully");
    }


}
