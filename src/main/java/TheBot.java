import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TheBot {
    ChromeDriver driver;
    public boolean activateQR = false;
    final String httpsToChat = "https://web.whatsapp.com/send?phone=972";
    String thePhone = "";
    String text = "";


    public void setThePhone(String thePhone, int control) {
        for (int i = control - 1; i < thePhone.length(); i++) {
            this.thePhone += thePhone.charAt(i);
        }
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getActivateQR() {
        return activateQR;
    }

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

    public void toChat() throws InterruptedException {

        driver.manage().window().maximize();
        driver.get(httpsToChat + thePhone);
        thePhone = "";

        // is in chat
        boolean find = false;
        while (!find) {
            if (driver.getPageSource().contains("clip"))
                find = true;
        }
        //send
        Thread.sleep(1000);
        driver.findElement(By.className("_1LbR4")).findElement(By.className("_13NKt")).sendKeys(text + Keys.ENTER);

        driver.manage().window().minimize();

    }


}

