package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Meeting_Member_Creation_Modal {

    private static String meeting_member_name_starts = Login_Page.config.getProperty("meeting_member_name_starts");
    static String meeting_member_name;
    static String meeting_member_record_type_text;
    static String meeting_list_item_text;
    static String invited_item_text;
    @FindBy(xpath = "(.//*[(.)='Record Type'])[1]/following::span[2]")
    public WebElement m_m_record_type_field;
    @FindBy(xpath = "//input[@type = 'text' and @placeholder = 'Search Meetings...' and @title = 'Search Meetings']")
    public WebElement meeting_selection_field;
    @FindBy(xpath = "(.//*[(.)='Meeting'])[1]/preceding::input[1]")
    public WebElement full_name_field;
    @FindBy(xpath = "(.//*[(.)='Search Meetings'])[1]/following::a[1]")
    public WebElement meeting_list_item;
    @FindBy(xpath = "(//a[contains(text(),'--None--')])[2]")
    public WebElement invitation_status_field;
    @FindBy(xpath = "//a[contains(text(),'Invited')]")
    public WebElement invitation_status_invited_item;
    @FindBy(xpath = "//button[@title = 'Save']")
    public WebElement save_bttn;

    static int b = (int) (Math.random() * 1000000000);

    public Meeting_Member_Creation_Modal(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

    public Meeting_Member_Creation_Modal m_m_full_name_field_fill() throws Exception {
        meeting_member_record_type_text = $(m_m_record_type_field).getText();
        meeting_member_name = (meeting_member_name_starts + meeting_member_record_type_text + " " + b);
        $(full_name_field).waitUntil(enabled,10000).setValue(meeting_member_name);
        return this;
    }

    public Meeting_Member_Creation_Modal meeting_selection_field_set_value() throws Exception {
        $(meeting_selection_field).waitUntil(visible,10000).setValue(Meeting_Creation_Details_Modal.meeting_name_starts).pressEnter();
        return this;
    }

    public Meeting_Member_Creation_Modal meeting_list_item_selection() throws Exception {
        meeting_list_item_text = $(meeting_list_item).getText();
        $(meeting_list_item).waitUntil(enabled,10000).click();
        return this;
    }

    public Meeting_Member_Creation_Modal invitation_status_field_click() throws Exception {
        $(invitation_status_field).waitUntil(visible,10000).click();
        return this;
    }

    public Meeting_Member_Creation_Modal invited_item_selection() throws Exception {
        invited_item_text = $(invitation_status_invited_item).getText();
        $(invitation_status_invited_item).waitUntil(visible,10000).click();
        return this;
    }

    public void save_bttn_click() throws Exception {
        $(save_bttn).waitUntil(visible,10000).click();
    }
}
