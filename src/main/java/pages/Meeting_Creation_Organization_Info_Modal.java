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
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Meeting_Creation_Organization_Info_Modal {

    @FindBy(xpath = "(.//*[normalize-space(.)='Organizing Business Unit'])[1]/following::input[1]")
    public WebElement organizing_business_unit_field;
    @FindBy(xpath = "(.//*[(.)='Recent Parties'])[1]/following::span[5]")
    public WebElement business_unit_item;

    public Meeting_Creation_Organization_Info_Modal(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

    public Meeting_Creation_Organization_Info_Modal organizing_business_unit_click() throws Exception {
        $(organizing_business_unit_field).waitUntil(visible,10000).click();
        return this;
    }

    public void business_unit_item_selection() throws Exception {
        $(business_unit_item).waitUntil(visible,10000).click();
    }
}
