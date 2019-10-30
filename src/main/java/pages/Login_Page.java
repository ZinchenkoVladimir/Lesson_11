package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Config;

import java.util.Properties;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Login_Page {

    private final Properties config = Config.loadProperties("src/main/resources/test.properties");

    private String salesforce_login_page = config.getProperty("salesforce_login_page");
    private String username = config.getProperty("username");
    private String pass = config.getProperty("pass");
//    private String oce_engage = "Home";

    @FindBy(id = "username")
    public static WebElement username_field;
    @FindBy(id = "password")
    public static WebElement password_field;
    @FindBy(id = "Login")
    public WebElement login_bttn;
    @FindBy(xpath = "//a[@title = 'Home']")
    public WebElement oce_engage_title;

    public Login_Page(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

    public Login_Page open_login_page() throws Exception {
        open(salesforce_login_page);
        return this;
    }

    public Login_Page username_field_fill() throws Exception {
        $(username_field).waitUntil(enabled,10000).setValue(username);
        return this;
    }

    public Login_Page password_field_fill() throws Exception {
        $(password_field).waitUntil(enabled,10000).setValue(pass);
        return this;
    }

    public Login_Page login_bttn_click() throws Exception {
        $(login_bttn).waitUntil(enabled,10000).click();
        return this;
    }

    public void verify_home_page() throws Exception {
        $(oce_engage_title).waitUntil(enabled,10000).is(visible);
    }
}
