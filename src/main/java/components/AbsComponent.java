package components;

import commons.AbsPageObject;
import org.openqa.selenium.WebDriver;

public abstract class AbsComponent extends AbsPageObject {
    public AbsComponent(WebDriver driver){

        super(driver);
    }
}