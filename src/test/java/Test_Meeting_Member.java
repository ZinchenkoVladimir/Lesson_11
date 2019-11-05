import default_package.Base;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

public class Test_Meeting_Member extends Base {

    private Login_Page login_page;
    private Home_Page home_page;
    private App_Launcher_Modal_Page app_launcher_modal_page;
    private Meetings_Member_Page meetings_member_page;

    public Test_Meeting_Member(){
    }

    @BeforeTest
    public void setUp_pages() throws Exception {

        login_page = new Login_Page(driver);
        home_page = new Home_Page(driver);
        app_launcher_modal_page = new App_Launcher_Modal_Page(driver);
        meetings_member_page = new Meetings_Member_Page(driver);

    }

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
    @Test(priority = 1)
    public void redirect_to_meetings_member() throws Exception{

        login_page
                .open_login_page()
                .username_field_fill()
                .password_field_fill()
                .login_bttn_click()
                .verify_home_page();

        home_page
                .app_launcher_click();

        app_launcher_modal_page
                .meeting_members_link_click()
                .verify_meeting_members_page();
    }

}
