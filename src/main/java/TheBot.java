import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TheBot  {
    ChromeDriver driver;
    public boolean activateQR = false;

    public void start() throws InterruptedException {
        System.setProperty(
                "webdriver.chrome.driver", "C:\\Nouveau dossier\\Applicasion_zip\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://web.whatsapp.com/");

        while (!activateQR) {
            if (driver.getPageSource().contains("default-user")) {
                activateQR = true;
            }
        }
        driver.manage().window().minimize();

    }

        public boolean getActivateQR () {
            return activateQR;
        }


    }

