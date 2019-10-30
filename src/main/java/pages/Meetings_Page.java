package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Meetings_Page {

    @FindBy(css = "a[title = New]")
    public WebElement new_bttn;
    @FindBy(xpath = "//span[@data-aura-class = 'uiOutputText forceBreadCrumbItem' and (text() = 'Meetings' or . = 'Meetings')]")
    public static WebElement meetings_text;

    public Meetings_Page(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

    public Meetings_Page new_bttn_click() throws Exception {
        $(new_bttn).waitUntil(enabled,10000).click();
        return this;
    }

    public void verify_meeting_modal() throws Exception {
        $(Meeting_Creation_Select_Record_Type_Modal.speaker_meeting_radio).waitUntil(enabled,10000).is(visible);
    }
}
