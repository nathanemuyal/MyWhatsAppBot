import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {
    private ImageIcon logo;
    private ImageIcon onSignal;

    public Screen(int x, int y, int WHIDTH, int HIGHET,Color color) {
        this.setBounds(x, y, WHIDTH, HIGHET);
        this.logo =new ImageIcon("src/main/image/WhatsApp logo.png");



    }

    protected  void paintComponent(Graphics g){
        super.paintComponent(g);
        //main color + logo
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(),getHeight());
        g.drawImage(this.logo.getImage(),0,0,100,20,null);



    }

}
