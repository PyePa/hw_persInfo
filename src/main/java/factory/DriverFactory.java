package factory;

import exceptions.DriverNotSupported;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private final static String browserName = System.getProperty("browser", "chrome");
    public WebDriver create() throws DriverNotSupported {
        switch (browserName) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--start-fullscreen");
                return new ChromeDriver(options);
            }
            default:
                throw new DriverNotSupported(browserName);

        }
    }
}