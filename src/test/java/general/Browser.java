package general;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {

    private static WebDriver driver;

    public static WebDriver driver() {

        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }

        return driver;
    }
    public static void close() {
        driver.quit();
    }
}

