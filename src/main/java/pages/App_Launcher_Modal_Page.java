package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class App_Launcher_Modal_Page {

    @FindBy(xpath = "//span[@class = 'label slds-truncate slds-text-link' and (text() = 'Meeting Members' or . = 'Meeting Members')]")
    public WebElement meeting_members_link;

    public App_Launcher_Modal_Page(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

    public void meeting_members_link_click() throws Exception {
        $(meeting_members_link).waitUntil(visible,10000).click();
    }
}
