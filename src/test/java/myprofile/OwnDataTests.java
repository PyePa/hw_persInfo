package myprofile;

import components.DropDownList;
import components.TextField;
import data.DropDownListData;
import data.SelectListData;
import data.TextFieldData;
import exceptions.DriverNotSupported;
import factory.DriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.LKAboutMePage;
import pageobjects.MainPage;

import static data.DropDownListData.*;

public class OwnDataTests {
    private static DriverFactory driverFactory;

    @BeforeAll
    public static void init() {
        driverFactory = new DriverFactory();
    }

    private WebDriver driver;

    @BeforeEach
    public void initDriver() throws DriverNotSupported {
        driver = new DriverFactory().create();
    }

    @AfterEach
    public void after() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void addOwnData() throws InterruptedException {
        String path = "/lk/biography/personal/";
        String firstName = "Студент";
        String lastName = "Тестовый";
        String fNameLat = "Student";
        String lNameLat = "Test";
        String blogName = "testik";
        String birthDate = "27.07.1993";
        String contactFirstText = "mejonof1";
        String contactSecondText = "mejonof1";
        String companyName = "OTUS";
        String work = "Autotester";

        new MainPage(driver).open();
        new MainPage(driver).loginLK();
        new LKAboutMePage(driver, path).open();
        new LKAboutMePage(driver, path).fillTextField(TextFieldData.FIRST_NAME, firstName);
        new LKAboutMePage(driver, path).fillTextField(TextFieldData.LAST_NAME, lastName);
        new LKAboutMePage(driver, path).fillTextField(TextFieldData.FNAME_LAT, fNameLat);
        new LKAboutMePage(driver, path).fillTextField(TextFieldData.LNAME_LAT, lNameLat);
        new LKAboutMePage(driver, path).fillTextField(TextFieldData.BLOG_NAME, blogName);
        new LKAboutMePage(driver, path).fillTextField(TextFieldData.BIRTH_DATE, birthDate);
        String country = new DropDownList(driver).clickAndChooseDropDownList(COUNTRY, 4);
        String city = new DropDownList(driver).clickAndChooseDropDownList(CITY, 2);
        String english_level = new DropDownList(driver).clickAndChooseDropDownList(ENGLISH_LEVEL, 3);
        new LKAboutMePage(driver, path).clickButton(By.xpath("//button[contains(text(), 'Добавить')]"));
        //String contactFirst =
        new DropDownList(driver).clickAndChooseDropDownList(CONTACT_FIRST, 6);
        new LKAboutMePage(driver, path).fillTextField(TextFieldData.CONTACT_FIRST, contactFirstText);
        //String contactSecond =
        new DropDownList(driver).clickAndChooseDropDownList(CONTACT_SECOND, 4);
        new LKAboutMePage(driver, path).fillTextField(TextFieldData.CONTACT_SECOND, contactSecondText);
        new DropDownList(driver).chooseFromSelectList(SelectListData.FEMALE);
        new LKAboutMePage(driver, path).fillTextField(TextFieldData.COMPANY, companyName);
        new LKAboutMePage(driver, path).fillTextField(TextFieldData.WORK, work);
        new LKAboutMePage(driver, path).clickButton(By.xpath("//button[contains(text(), 'Сохранить и продолжить')]"));
        driver.manage().deleteAllCookies();
        new MainPage(driver).open();
        new MainPage(driver).loginLK();
        new LKAboutMePage(driver, path).open();

        new TextField(driver).compareValuesTextField(TextFieldData.FIRST_NAME, firstName);
        new TextField(driver).compareValuesTextField(TextFieldData.LAST_NAME, lastName);
        new TextField(driver).compareValuesTextField(TextFieldData.FNAME_LAT, fNameLat);
        new TextField(driver).compareValuesTextField(TextFieldData.LNAME_LAT, lNameLat);
        new TextField(driver).compareValuesTextField(TextFieldData.BLOG_NAME, blogName);
        new TextField(driver).compareValuesTextField(TextFieldData.BIRTH_DATE, birthDate);
        new DropDownList(driver).compareValuesDropDownList(DropDownListData.COUNTRY, country);
        new DropDownList(driver).compareValuesDropDownList(DropDownListData.CITY, city);
        new DropDownList(driver).compareValuesDropDownList(DropDownListData.ENGLISH_LEVEL, english_level);
        //new DropDownList(driver).compareValuesDropDownList(DropDownListData.CONTACT_FIRST, contactFirst);
        new TextField(driver).compareValuesTextField(TextFieldData.CONTACT_FIRST, contactFirstText);
        new TextField(driver).compareValuesTextField(TextFieldData.CONTACT_SECOND, contactSecondText);
        //new DropDownList(driver).compareValuesDropDownList(DropDownListData.CONTACT_SECOND, contactSecond);
        Assertions.assertEquals("f", driver.findElement(By.id("id_gender")).getAttribute("value"));
        new TextField(driver).compareValuesTextField(TextFieldData.COMPANY, companyName);
        new TextField(driver).compareValuesTextField(TextFieldData.WORK, work);
    }
}