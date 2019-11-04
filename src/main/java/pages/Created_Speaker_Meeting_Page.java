package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static pages.Meeting_Creation_Rewiev_Modal.end_date_formatted_1;
import static pages.Meeting_Creation_Rewiev_Modal.start_date_formatted_1;
import static pages.Meeting_Creation_Details_Modal.meeting_name;
import static pages.Meeting_Creation_Select_Record_Type_Modal.speaker_meeting_text;

public class Created_Speaker_Meeting_Page {

    String created_meeting_status = "Draft";
    @FindBy(xpath = "//a[contains(text(),'Details')]")
    public static WebElement details_in_sidebar;
    @FindBy(xpath = "//h1[(text() = 'Test_Meeting' or . = 'Test_Meeting')]")
    public WebElement h1_created_meeting_name_text;
    @FindBy(xpath = "//h3[(text() = 'Speaker Meeting' or . = 'Speaker Meeting')]")
    public WebElement h3_record_type_text;
    @FindBy(xpath = "(.//*[(.)='Change Record Type'])[1]/preceding::span[1]")
    public WebElement record_type_text;
    @FindBy(xpath = "(.//*[(.)='Comments'])[1]/preceding::span[1]")
    public WebElement span_meeting_name_text;
    @FindBy(xpath = "(.//*[(.)='Add Member'])[1]/preceding::span[1]")
    public WebElement span2_meeting_name_text;
    @FindBy(xpath = "(.//*[(.)='End Date/Time'])[4]/preceding::span[3]")
    public WebElement span_start_date_text;
    @FindBy(xpath = "(.//*[(.)='Status'])[2]/preceding::span[3]")
    public WebElement span_end_date_text;
    @FindBy(xpath = "(.//*[(.)='F&B Served by'])[1]/preceding::span[3]")
    public WebElement status_text;

    public Created_Speaker_Meeting_Page(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

    public Created_Speaker_Meeting_Page details_in_sidebar_click() throws Exception {
        $(details_in_sidebar).waitUntil(visible,10000).click();
        return this;
    }

    public void verify_created_speaker_meeting() throws Exception {
        $(h1_created_meeting_name_text).waitUntil(visible,10000).shouldHave(text(meeting_name));
        $(h3_record_type_text).waitUntil(visible,10000).shouldHave(text(speaker_meeting_text));
        $(record_type_text).waitUntil(visible,10000).shouldHave(text(speaker_meeting_text));
        $(span_meeting_name_text).waitUntil(visible,10000).shouldHave(text(meeting_name));
        $(span2_meeting_name_text).waitUntil(visible,10000).shouldHave(text(meeting_name));
        $(span_start_date_text).waitUntil(visible,10000).shouldHave(text(start_date_formatted_1));
        $(span_end_date_text).waitUntil(visible,10000).shouldHave(text(end_date_formatted_1));
        $(status_text).waitUntil(visible,10000).shouldHave(text(created_meeting_status));

    }
}
