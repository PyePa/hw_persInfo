package components;

import data.DropDownListData;
import data.SelectListData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import waiters.Waiters;

import java.util.List;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class DropDownList extends AbsComponent{
    public DropDownList(WebDriver driver){
        super (driver);
    }
    private String locatorClickDropDownListTemplate = "//input[@name='%s']/ancestor::div[contains(@class, 'select')]";
    private String locatorChooseElementInDropDownListTemplate = "//input[@name='%s']/ancestor::div[contains(@class, 'select')]/descendant::button";
    public String clickAndChooseDropDownList(DropDownListData dropDownListData, int index){
        String locatorForList = String.format(locatorClickDropDownListTemplate, dropDownListData.getName());
        driver.findElement(By.xpath(locatorForList)).click();
        String locatorForItem = String.format(locatorChooseElementInDropDownListTemplate, dropDownListData.getName());
        List<WebElement> elementsInDropDownList = driver.findElements(By.xpath(locatorForItem));
        elementsInDropDownList.get(--index).click();
        new Waiters(driver).waitForCondition(visibilityOf(driver.findElement(By.xpath(locatorForItem))));
        return driver.findElement(By.xpath(locatorForList)).getText();
    }

    public void chooseFromSelectList(SelectListData selectListData){
        String selector = "id_gender";
        Select select = new Select(driver.findElement(By.id(selector)));
        select.selectByVisibleText(selectListData.getName());
    }

    public void compareValuesDropDownList(DropDownListData dropDownListData, String name){
        String locatorForList = String.format(locatorClickDropDownListTemplate, dropDownListData.getName());
        Assertions.assertEquals(name, driver.findElement(By.xpath(locatorForList)).getAttribute("innerText"));
    }

//    public void chooseElementInDropDownList(DropDownListData dropDownListData, int index){
//        String locator = String.format(locatorChooseElementInDropDownListTemplate, dropDownListData.getName());
//        List<WebElement> elementsInDropDownList = driver.findElements(By.xpath(locator));
//        elementsInDropDownList.get(--index).click();
//        new Waiters(driver).waitForCondition(driver->true);
//
//    }
}