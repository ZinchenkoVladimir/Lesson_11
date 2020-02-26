package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Meeting_Creation_Organization_Info_Modal {

    @FindBy(xpath = "(.//*[(.)=\"Organizing Business Unit\"])[1]/following::input[1]")
    public WebElement organizing_business_unit_field;
    @FindBy(xpath = "//lightning-base-combobox-item[(text() = \"engoce_Party__cTesting\" or . = \"engoce_Party__cTesting\")]")
    public WebElement business_unit_item;
    @FindBy(xpath = "(.//*[text()=\"No\"])[2]/preceding::span[1]")
    public WebElement hosting_country_radio_yes;

    public Meeting_Creation_Organization_Info_Modal(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

    public Meeting_Creation_Organization_Info_Modal organizing_business_unit_click() throws Exception {
        $(organizing_business_unit_field).waitUntil(visible,10000).click();
        return this;
    }

    public Meeting_Creation_Organization_Info_Modal hosting_country_radio_yes_click() throws Exception {
        $(hosting_country_radio_yes).waitUntil(visible,10000).click();
        return this;
    }

    public void business_unit_item_selection() throws Exception {
        $(business_unit_item).waitUntil(visible,10000).click();
        sleep(2000);
    }
}
