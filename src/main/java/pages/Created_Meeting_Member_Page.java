package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class Created_Meeting_Member_Page {

    private String meeting_member_text = "Meeting Member";
    @FindBy(xpath = "(.//*[(.)='Change Record Type'])[1]/preceding::span[1]")
    public WebElement m_m_record_type_text;
    @FindBy(xpath = "(.//*[(.)='Edit Full Name'])[1]/preceding::span[1]")
    public WebElement full_name_text;
    @FindBy(xpath = "(.//*[(.)='Manage Services'])[1]/preceding::div[2]")
    public WebElement m_m_text;
    @FindBy(xpath = "(.//*[(.)='Manage Services'])[1]/preceding::div[1]")
    public WebElement full_name_header_text;
    @FindBy(xpath = "(.//*[(.)='Record Type'])[1]/preceding::a[1]")
    public WebElement meeting_name_1_text;
    @FindBy(xpath = "(.//*[(.)='Edit Invitation Status'])[1]/preceding::span[1]")
    public WebElement invitation_status_text;

    public Created_Meeting_Member_Page(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

    public void verify_created_meeting_member() throws Exception {
        $(m_m_record_type_text).waitUntil(visible,10000).shouldHave(text(Meeting_Member_Creation_Modal.meeting_member_record_type_text));
        $(full_name_text).waitUntil(visible,10000).shouldHave(text(Meeting_Member_Creation_Modal.meeting_member_name));
        $(m_m_text).waitUntil(visible,10000).shouldHave(text(meeting_member_text));
        $(full_name_header_text).waitUntil(visible,10000).shouldHave(text(Meeting_Member_Creation_Modal.meeting_member_name));
        $(meeting_name_1_text).waitUntil(visible,10000).shouldHave(text(Meeting_Member_Creation_Modal.meeting_list_item_text));
        $(invitation_status_text).waitUntil(visible,10000).shouldHave(text(Meeting_Member_Creation_Modal.invited_item_text));
    }
}
