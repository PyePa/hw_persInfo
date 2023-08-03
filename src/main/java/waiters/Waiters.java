package waiters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {
    private WebDriverWait webDriverWait;

    public Waiters(WebDriver driver){

        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }
    public boolean waitForCondition(ExpectedCondition condition){
        try {
            this.webDriverWait.until(condition);
            return true;
        } catch (Exception ignored){
            return false;
        }
    }

}