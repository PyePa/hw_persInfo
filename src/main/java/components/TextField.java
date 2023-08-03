package components;

import data.TextFieldData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TextField extends AbsComponent{
    public TextField(WebDriver driver){
        super (driver);
    }



    public void compareValuesTextField(TextFieldData textFieldData, String name){
        String selector = textFieldData.getName();
        Assertions.assertEquals(name, driver.findElement(By.name(selector)).getAttribute("value"));
    }
}