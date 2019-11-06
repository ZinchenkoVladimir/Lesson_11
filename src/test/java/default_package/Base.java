package default_package;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import pages.*;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;

public class Base {

    private WebDriver driver;

    protected Login_Page login_page;
    protected Home_Page home_page;
    protected App_Launcher_Modal_Page app_launcher_modal_page;
    protected Meetings_Member_Page meetings_member_page;
    protected Meetings_Page meetings_page;
    protected Meeting_Member_Select_record_type_Modal_Page meeting_member_select_record_type_modal_page;
    protected Meeting_Creation_Select_Record_Type_Modal meeting_creation_select_record_type_modal;
    protected Meeting_Member_Creation_Modal meeting_member_creation_modal;
    protected Created_Meeting_Member_Page created_meeting_member_page;
    protected Meeting_Creation_Organization_Info_Modal meeting_creation_organization_info_modal;
    protected Meeting_Creation_Details_Modal meeting_creation_details_modal;
    protected Meeting_Creation_Review_Modal meeting_creation_review_modal;
    protected Created_Speaker_Meeting_Page created_speaker_meeting_page;
    protected SoftAssert asserts = new SoftAssert();

    protected Base() {
    }

    @BeforeTest
    public void setUp() throws Exception {

//        ChromeDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
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

        login_page = new Login_Page(driver);
        home_page = new Home_Page(driver);
        app_launcher_modal_page = new App_Launcher_Modal_Page(driver);
        meetings_member_page = new Meetings_Member_Page(driver);
        meetings_page = new Meetings_Page(driver);
        meeting_member_select_record_type_modal_page = new Meeting_Member_Select_record_type_Modal_Page(driver);
        meeting_creation_select_record_type_modal = new Meeting_Creation_Select_Record_Type_Modal(driver);
        meeting_member_creation_modal = new Meeting_Member_Creation_Modal(driver);
        created_meeting_member_page = new Created_Meeting_Member_Page(driver);
        meeting_creation_organization_info_modal = new Meeting_Creation_Organization_Info_Modal(driver);
        meeting_creation_details_modal = new Meeting_Creation_Details_Modal(driver);
        meeting_creation_review_modal = new Meeting_Creation_Review_Modal(driver);
        created_speaker_meeting_page = new Created_Speaker_Meeting_Page(driver);
    }

    @AfterTest
    public void tearDown() throws Exception {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        driver.quit();
    }
}
