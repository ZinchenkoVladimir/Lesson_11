import default_package.Base;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

public class Test_Meeting_Member extends Base {

    private Login_Page login_page;
    private Home_Page home_page;
    private App_Launcher_Modal_Page app_launcher_modal_page;
    private Meetings_Member_Page meetings_member_page;
    private Meetings_Page meetings_page;
    private Meeting_Member_Select_record_type_Modal_Page meeting_member_select_record_type_modal_page;
    private Meeting_Creation_Select_Record_Type_Modal meeting_creation_select_record_type_modal;
    private Meeting_Member_Creation_Modal meeting_member_creation_modal;
    private Created_Meeting_Member_Page created_meeting_member_page;

    public Test_Meeting_Member(){
    }

    @BeforeTest
    public void setUp_pages() throws Exception {

        login_page = new Login_Page(driver);
        home_page = new Home_Page(driver);
        app_launcher_modal_page = new App_Launcher_Modal_Page(driver);
        meetings_member_page = new Meetings_Member_Page(driver);
        meetings_page = new Meetings_Page(driver);
        meeting_member_select_record_type_modal_page = new Meeting_Member_Select_record_type_Modal_Page(driver);
        meeting_creation_select_record_type_modal = new Meeting_Creation_Select_Record_Type_Modal(driver);
        meeting_member_creation_modal = new Meeting_Member_Creation_Modal(driver);
        created_meeting_member_page = new Created_Meeting_Member_Page(driver);
    }

    @Test(priority = 0)
    public void login_to_salesforce() throws Exception {

        login_page
                .open_login_page()
                .username_field_fill()
                .password_field_fill()
                .login_bttn_click()
                .verify_home_page();
    }

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
                .meeting_members_link_click();

        meetings_member_page
                .verify_meeting_members_page();
    }

    @Test(priority = 2)
    public void open_meetings_member_modal() throws Exception{

        login_page
                .open_login_page()
                .username_field_fill()
                .password_field_fill()
                .login_bttn_click()
                .verify_home_page();

        home_page
                .app_launcher_click();

        app_launcher_modal_page
                .meeting_members_link_click();

        meetings_member_page
                .verify_meeting_members_page();

        meetings_page
                .new_bttn_click();

        meeting_member_select_record_type_modal_page
                .verify_meeting_member_modal();
    }

    @Test(priority = 3)
    public void speaker_meetings_member_creation() throws Exception{

        login_page
                .open_login_page()
                .username_field_fill()
                .password_field_fill()
                .login_bttn_click()
                .verify_home_page();

        home_page
                .app_launcher_click();

        app_launcher_modal_page
                .meeting_members_link_click();

        meetings_member_page
                .verify_meeting_members_page();

        meetings_page
                .new_bttn_click();

        meeting_member_select_record_type_modal_page
                .speaker_m_m_selection();

        meeting_creation_select_record_type_modal
                .next_bttn_click();

        meeting_member_creation_modal
                .m_m_full_name_field_fill()
                .meeting_selection_field_set_value()
                .meeting_list_item_selection()
                .invitation_status_field_click()
                .invited_item_selection()
                .save_bttn_click();

        created_meeting_member_page
                .verify_created_meeting_member();
    }
}
