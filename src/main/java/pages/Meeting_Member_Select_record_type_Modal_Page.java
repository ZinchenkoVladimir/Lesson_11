package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Meeting_Member_Select_record_type_Modal_Page {

    @FindBy(xpath = "//h2[(text() = 'New Meeting Member' or . = 'New Meeting Member')]")
    public WebElement new_meeting_member_header;
    @FindBy(xpath = "//span[(text() = 'Speaker' or . = 'Speaker')]")
    public static WebElement speaker_m_m_record_type;

    public Meeting_Member_Select_record_type_Modal_Page(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

    public void verify_meeting_member_modal() throws Exception {
        $(new_meeting_member_header).waitUntil(enabled,10000).isDisplayed();
    }

    public void speaker_m_m_selection() throws Exception {
        $(speaker_m_m_record_type).waitUntil(visible,10000).click();
    }
}
