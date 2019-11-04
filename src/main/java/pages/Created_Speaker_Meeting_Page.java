package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class Created_Speaker_Meeting_Page {

    public static String speaker_meeting_text;
    @FindBy(xpath = "//span[@class = 'slds-form-element__label' and (text() = 'Speaker Meeting')]")
    public static WebElement speaker_meeting_radio;
    @FindBy(xpath = "//button[(text() = 'Next' or . = 'Next')]")
    public WebElement next_button;

    public Created_Speaker_Meeting_Page(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

    public Created_Speaker_Meeting_Page speaker_meeting_selection() throws Exception {
        speaker_meeting_text = $(speaker_meeting_radio).getText();
        $(speaker_meeting_radio).waitUntil(enabled,10000).click();
        return this;
    }

    public Created_Speaker_Meeting_Page next_bttn_click() throws Exception {
        executeJavaScript("arguments[0].click()", next_button);
        return this;
    }
}
