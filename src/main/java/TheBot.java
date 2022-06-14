import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TheBot {
    ChromeDriver driver;
    boolean activateQR= false;

    public void start() {
        System.setProperty(
                "webdriver.chrome.driver", "C:\\Nouveau dossier\\Applicasion_zip\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://web.whatsapp.com/");

        while (activateQR==false){
            if (driver.getPageSource().contains("_13NKt copyable-text selectable-text"));
            activateQR=true;
        }

    }


}

