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

public class HomePage {

    public static final Properties config = Config.loadProperties("src/main/resources/test.properties");

    private String gigapartsHomePage = config.getProperty("gigapartsHomePage");

    @FindBy(xpath = "//a[@class = \"logo\"]")
    public static WebElement logoHome;
    @FindBy(xpath = "//div[@class = \"panel header\"]//a[text() = \"Create an Account\"]")
    public static WebElement createAnAccountLink;

    public HomePage(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

    public HomePage openHomePage() throws Exception {
        open(gigapartsHomePage);
        return this;
    }

    public void createAnAccountLinkClick() throws Exception {
        $(createAnAccountLink).waitUntil(enabled,10000).waitUntil(visible,10000).click();
    }

    public void verifyHomePage() throws Exception {
        $(logoHome).waitUntil(enabled,10000).is(visible);
    }
}
