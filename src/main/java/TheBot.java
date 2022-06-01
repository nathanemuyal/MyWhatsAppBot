import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.chrome.ChromeDriver;

public class TheBot {
    public static void main(String[] args){
        System.setProperty(
                "webdriver.chrome.driver","C:\\Nouveau dossier\\Applicasion_zip\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://web.whatsapp.com/");

    }
}
