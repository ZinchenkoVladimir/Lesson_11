package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static pages.Meeting_Creation_Details_Modal.end_date;
import static pages.Meeting_Creation_Details_Modal.start_date;

public class Meeting_Creation_Rewiev_Modal {

    @FindBy(xpath = "//div[@class = 'slds-form-element__static slds-text-body_smalls' and (text() = 'Speaker Meeting' or . = 'Speaker Meeting')]")
    public WebElement rewiev_meeting_type_text;
    @FindBy(xpath = "(.//*[(.)='Start Date/Time'])[1]/following::div[2]")
    public WebElement start_date_text;
    @FindBy(xpath = "(.//*[(.)='Time Zone'])[1]/preceding::div[1]")
    public WebElement end_date_text;
    @FindBy(xpath = "//button[(text() = 'Create Engagement')]")
    public WebElement create_engagement_bttn;
    @FindBy(xpath = "(.//*[(.)='Location Type'])[1]/preceding::div[1]")
    public WebElement meeting_name_text;

    SimpleDateFormat date_format = new SimpleDateFormat(Login_Page.config.getProperty("date_format_2"), Locale.US);
    String start_date_formatted_1 = date_format.format(start_date);
    String end_date_formatted_1 = date_format.format(end_date);

    public Meeting_Creation_Rewiev_Modal(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

    public Meeting_Creation_Rewiev_Modal verify_meeting_type() throws Exception {
        $(rewiev_meeting_type_text).waitUntil(enabled,10000).shouldHave(text(Meeting_Creation_Select_Record_Type_Modal.speaker_meeting_text));
        return this;
    }

    public void verify_meeting_name() throws Exception {
        $(meeting_name_text).waitUntil(enabled,10000).shouldHave(text(Meeting_Creation_Details_Modal.meeting_name));
    }

    public boolean verify_start_date() throws Exception {
        boolean b = $(start_date_text).waitUntil(enabled,15000).waitUntil(visible,15000).getText().contains(start_date_formatted_1);
        return b;
    }

    public boolean verify_end_date() throws Exception {
        boolean c = $(end_date_text).waitUntil(visible,10000).getText().contains(end_date_formatted_1);
        return c;
    }

    public void create_engagement_bttn_click() throws Exception {
        $(create_engagement_bttn).waitUntil(enabled,10000).click();
    }
}
