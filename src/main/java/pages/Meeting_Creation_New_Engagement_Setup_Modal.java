package pages;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static java.time.LocalDate.now;

public class Meeting_Creation_New_Engagement_Setup_Modal {

    public String meeting_name = "Test ";
    @FindBy(xpath = "//input[@name = 'Name']")
    public WebElement meeting_name_field;
    @FindBy(xpath = "//input[@name = 'OCE__StartDateTime__c' and @class = 'slds-input']")
    public WebElement start_date_field;
    @FindBy(xpath = "//input[@name = 'OCE__EndDateTime__c' and @class = 'slds-input']")
    public WebElement end_date_field;
//    @FindBy(xpath = "//span[(text() = 'Speaker Meeting' or . = 'Speaker Meeting')]")
//    public WebElement meeting_type_text;

    Date current_date = new Date();
    DateTime dt_org = new DateTime(current_date);
    DateTime start_date = dt_org.plusDays(1);
    DateTime end_date = dt_org.plusDays(3);
    SimpleDateFormat date_format = new SimpleDateFormat("MMM d, YYYY", Locale.ENGLISH);
    String start_date_formatted = date_format.format(start_date.toDate());
    String end_date_formatted = date_format.format(end_date.toDate());

    public Meeting_Creation_New_Engagement_Setup_Modal(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

    public Meeting_Creation_New_Engagement_Setup_Modal meeting_name_field_fill() throws Exception {
        int a = (int) (Math.random() * 1000000000);
        $(meeting_name_field).waitUntil(enabled,10000).setValue(meeting_name + Meeting_Creation_Select_Record_Type_Modal.speaker_meeting_text + " " + a);
        return this;
    }

    public Meeting_Creation_New_Engagement_Setup_Modal start_date_field_fill() throws Exception {
        $(start_date_field).waitUntil(enabled,10000).setValue(start_date_formatted);
        return this;
    }

    public void end_date_field_fill() throws Exception {
        $(end_date_field).waitUntil(enabled,10000).setValue(end_date_formatted);
    }
}
