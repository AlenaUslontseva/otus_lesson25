package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;

    public static WebDriver getChromeDriver() {
        if (driver == null || hasDriverQuit()) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(7, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }

    private static boolean hasDriverQuit() {
        return ((RemoteWebDriver)driver).getSessionId() == null;
    }
}

