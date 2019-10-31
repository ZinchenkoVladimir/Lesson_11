import com.codeborne.selenide.WebDriverLogs;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.SoftAsserts;
import com.codeborne.selenide.webdriver.WebDriverFactory;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.*;
import utils.Config;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;

public class Test_Speaker_Meetings {

    private static WebDriver driver;

    private Login_Page login_page;
    private Home_Page home_page;
    private Meetings_Page meetings_page;
    private Meeting_Creation_Select_Record_Type_Modal meeting_creation_select_record_type_modal;
    private Meeting_Creation_Organization_Info_Modal meeting_creation_organization_info_modal;
    private Meeting_Creation_Details_Modal meeting_creation_details_modal;
    private Meeting_Creation_Rewiev_Modal meeting_creation_rewiev_modal;

    public Test_Speaker_Meetings(){
    }

    @BeforeTest
    public void setUp() throws Exception {

//        ChromeDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.operadriver().setup();
//        WebDriverManager.edgedriver().setup();
//        WebDriverManager.iedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebDriverRunner.setWebDriver(driver);
        WebDriverRunner.supportsJavascript();
        WebDriverRunner.supportsModalDialogs();
//        WebDriverRunner.driver().config().headless();

        login_page = new Login_Page(driver);
        home_page = new Home_Page(driver);
        meetings_page = new Meetings_Page(driver);
        meeting_creation_select_record_type_modal = new Meeting_Creation_Select_Record_Type_Modal(driver);
        meeting_creation_organization_info_modal = new Meeting_Creation_Organization_Info_Modal(driver);
        meeting_creation_details_modal = new Meeting_Creation_Details_Modal(driver);
        meeting_creation_rewiev_modal = new Meeting_Creation_Rewiev_Modal(driver);
    }

//    @DataProvider
//    public Object[][] fill_login_page() {
//        return new Object[][]{
//                {username_field},
//                {password_field}
//        };
//    }
//
//    @Test(priority = 0)
//    public void login_to_salesforce() throws Exception {
//
//        login_page
//                .open_login_page()
//                .username_field_fill()
//                .password_field_fill()
//                .login_bttn_click()
//                .verify_home_page();
//    }
//
//    @Test(priority = 0)
//    public void redirect_to_meetings() throws Exception{
//
//        login_page
//                .open_login_page()
//                .username_field_fill()
//                .password_field_fill()
//                .login_bttn_click()
//                .verify_home_page();
//
//        home_page
//                .app_launcher_click()
//                .meetings_link_click()
//                .verify_meetings_page();
//    }
//
//    @Test(priority = 1)
//    public void open_meeting_modal() throws Exception{
//
//        login_page
//                .open_login_page()
//                .username_field_fill()
//                .password_field_fill()
//                .login_bttn_click()
//                .verify_home_page();
//
//        home_page
//                .app_launcher_click()
//                .meetings_link_click()
//                .verify_meetings_page();
//
//        meetings_page
//                .new_bttn_click()
//                .verify_meeting_modal();
//    }
//
    @Test(priority = 2)
    public void meeting_creation() throws Exception{

        login_page
                .open_login_page()
                .username_field_fill()
                .password_field_fill()
                .login_bttn_click()
                .verify_home_page();

        home_page
                .app_launcher_click()
                .meetings_link_click()
                .verify_meetings_page();

        meetings_page
                .new_bttn_click()
                .verify_meeting_modal();

        meeting_creation_select_record_type_modal
                .speaker_meeting_selection()
                .next_bttn_click();

        meeting_creation_organization_info_modal
                .organizing_business_unit_click()
                .business_unit_item_selection();

        meeting_creation_details_modal
                .meeting_name_field_fill()
                .start_date_field_fill()
                .end_date_field_fill();

        meeting_creation_select_record_type_modal
                .next_bttn_click()
                .next_bttn_click();

        meeting_creation_rewiev_modal
                .verify_meeting_type()
                .verify_meeting_name();
        SoftAssert asserts = new SoftAssert();
        asserts.assertTrue(meeting_creation_rewiev_modal.verify_start_date(), "1");
        asserts.assertTrue(meeting_creation_rewiev_modal.verify_end_date(), "2");
//        asserts.assertAll();
        meeting_creation_rewiev_modal
                .create_engagement_bttn_click();
    }

    @AfterTest
    public void tearDown() throws Exception {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        driver.quit();
    }
}
