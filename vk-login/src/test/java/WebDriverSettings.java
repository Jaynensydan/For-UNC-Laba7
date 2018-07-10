import com.google.common.io.Files;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WebDriverSettings {

    ChromeDriver driver;
    private String driverType = "webdriver.chrome.driver";
    private String driverPath = "C:\\Tools\\chromedriver.exe";
    String url = "https://vk.com/";
    String login = "Enter your login";
    String password = "Enter your password";

    //Метод для создания скриншотов
    public void giveMeScreen() {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screen = new File("Screen-" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() {
        System.setProperty(driverType, driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @After
    public void close() {
//        driver.quit();
    }
}
