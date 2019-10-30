package pages;

import com.codeborne.selenide.commands.Execute;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Config;

import java.util.Properties;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Home_Page {

    @FindBy(xpath = "//button[(text() = 'App Launcher' or . = 'App Launcher')]")
    public WebElement app_launcher_bttn;
    @FindBy(xpath = "(.//*[normalize-space(text())='Metadata Entities'])[2]/preceding::span[1]")
    public WebElement meetings_link;

    public Home_Page(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

    public Home_Page app_launcher_click() throws Exception {
        $(app_launcher_bttn).waitUntil(visible,10000).click();
        return this;
    }

    public Home_Page meetings_link_click() throws Exception {
        $(meetings_link).waitUntil(enabled,10000).click();
        return this;
    }

    public void verify_meetings_page() throws Exception {
        $(Meetings_Page.meetings_text).waitUntil(enabled,10000).is(visible);
    }

}
