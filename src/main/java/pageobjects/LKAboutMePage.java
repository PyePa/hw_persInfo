package pageobjects;

import data.TextFieldData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LKAboutMePage extends AbsBasePage {

    private static final String PATH = "/";

    public LKAboutMePage(WebDriver driver, String path){

        super(driver, path);
    }

    public void fillTextField (TextFieldData textFieldData, String text){
        String selector = textFieldData.getName();
        driver.findElement(By.name(selector)).clear();
        driver.findElement(By.name(selector)).sendKeys(text);

    }


}