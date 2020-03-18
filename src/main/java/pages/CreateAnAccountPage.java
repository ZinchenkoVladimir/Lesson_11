package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Config;

import java.util.Properties;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CreateAnAccountPage {

    @FindBy(xpath = "//input[@id = \"firstname\"]")
    public static WebElement firstNameField;
    @FindBy(xpath = "//div[@class = \"panel header\"]//a[text() = \"Create an Account\"]")
    public static WebElement createAnAccountLink;

    static int a = (int) (Math.random() * 1000000000);
    static int b = (int) (Math.random() * 1000000000);

    static String firstNamePrefix = "First_Name_Test";
    static String firstFullName;
    static String lastNamePrefix = "Last_Name_Test";
    static String lastFullName;

    public CreateAnAccountPage(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

    public CreateAnAccountPage verifyCreateAnAccountPageIsOpen() throws Exception {
        $(firstNameField).waitUntil(enabled,10000).isDisplayed();
        return this;
    }

    public CreateAnAccountPage fillFirstNameField() throws Exception {
        firstFullName = (firstNamePrefix + a);
        $(firstNameField).waitUntil(enabled,10000).waitUntil(visible,10000).setValue(firstFullName);
        return this;
    }

    public CreateAnAccountPage fillLastNameField() throws Exception {
        lastFullName = (lastNamePrefix + b);
        $(firstNameField).waitUntil(enabled,10000).waitUntil(visible,10000).setValue(lastFullName);
        return this;
    }

    public void verifyHomePage() throws Exception {
        $(logoHome).waitUntil(enabled,10000).is(visible);
    }
}
