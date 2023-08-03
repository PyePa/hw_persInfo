package pageobjects;

import org.openqa.selenium.WebDriver;

public class MainPage extends AbsBasePage {

    private static final String PATH = "/";

    public MainPage(WebDriver driver) {

        super(driver, PATH);
    }
}