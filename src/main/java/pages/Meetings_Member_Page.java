package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Meetings_Member_Page {

    @FindBy(xpath = "//span[@data-aura-class = 'uiOutputText forceBreadCrumbItem' and (text() = 'Meeting Members' or . = 'Meeting Members')]")
    public static WebElement meeting_members_text;

    public Meetings_Member_Page(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

//    public Meetings_Member_Page meeting_members_link_click() throws Exception {
//        $(meeting_members_link).waitUntil(visible,10000).click();
//        return this;
//    }

    public void verify_meetings_page() throws Exception {
        $(Meetings_Page.meetings_text).waitUntil(enabled,10000).is(visible);
    }

}
