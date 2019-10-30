package pages;

import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static java.time.LocalDate.now;

public class Meeting_Creation_Details_Modal {

    private static String meeting_name_starts = Login_Page.config.getProperty("name_starts");
    public static String meeting_name;
    @FindBy(xpath = "//input[@name = 'Name']")
    public WebElement meeting_name_field;
    @FindBy(xpath = "//input[@name = 'OCE__StartDateTime__c' and @class = 'slds-input']")
    public WebElement start_date_field;
    @FindBy(xpath = "//input[@name = 'OCE__EndDateTime__c' and @class = 'slds-input']")
    public WebElement end_date_field;
//    @FindBy(xpath = "//span[(text() = 'Speaker Meeting' or . = 'Speaker Meeting')]")
//    public WebElement meeting_type_text;

    static Date current_date = new Date();
    static DateTime dt_org = new DateTime(current_date);
    public static Date start_date = dt_org.plusDays(Integer.parseInt(Login_Page.config.getProperty("start_date"))).toDate();
    public static Date end_date = dt_org.plusDays(Integer.parseInt(Login_Page.config.getProperty("end_date"))).toDate();
    SimpleDateFormat date_format = new SimpleDateFormat(Login_Page.config.getProperty("date_format_1"), Locale.ENGLISH);
    String start_date_formatted = date_format.format(start_date);
    String end_date_formatted = date_format.format(end_date);

    static int a = (int) (Math.random() * 1000000000);

    public Meeting_Creation_Details_Modal(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

    public Meeting_Creation_Details_Modal meeting_name_field_fill() throws Exception {
        meeting_name = (meeting_name_starts + Meeting_Creation_Select_Record_Type_Modal.speaker_meeting_text + " " + a);
        $(meeting_name_field).waitUntil(enabled,10000).setValue(meeting_name);
        return this;
    }

    public Meeting_Creation_Details_Modal start_date_field_fill() throws Exception {
        $(start_date_field).waitUntil(enabled,10000).setValue(start_date_formatted);
        return this;
    }

    public void end_date_field_fill() throws Exception {
        $(end_date_field).waitUntil(enabled,10000).setValue(end_date_formatted);
    }
}
