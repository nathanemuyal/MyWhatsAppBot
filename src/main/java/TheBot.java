import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TheBot {
    public static void main(String[] args) throws IOException {

        System.setProperty(
                "webdriver.chrome.driver","C:\\Nouveau dossier\\Applicasion_zip\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://web.whatsapp.com/");
////////////////
        WebElement l = driver.findElement(By.className("_25pwu"));
        String v =l.getAttribute("src");
        URL i =new URL(v);
        BufferedImage s = ImageIO.read(i);
        ImageIO.write(s,"png",new File("QRcode.png"));
//////////////

    }
}
