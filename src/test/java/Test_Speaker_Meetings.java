import default_package.Base;
import org.testng.annotations.Test;

public class Test_Speaker_Meetings extends Base {

    public Test_Speaker_Meetings(){
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
    public void redirect_to_meetings() throws Exception{

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
    }

    @Test(priority = 2)
    public void open_meeting_modal() throws Exception{

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
    }

    @Test(priority = 3)
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

        meeting_creation_select_record_type_modal
                .next_bttn_click();

        meeting_creation_details_modal
                .meeting_name_field_fill()
                .start_date_field_fill()
                .end_date_field_fill();

        meeting_creation_select_record_type_modal
                .next_bttn_click()
                .next_bttn_click();

        meeting_creation_review_modal
                .verify_meeting_type()
                .verify_meeting_name();
        asserts.assertTrue(meeting_creation_review_modal.verify_start_date(), "start_date_1");
        asserts.assertTrue(meeting_creation_review_modal.verify_end_date(), "end_date_1");
        asserts.assertAll();
        meeting_creation_review_modal
                .create_engagement_bttn_click();

        created_speaker_meeting_page
                .details_in_sidebar_click()
                .verify_created_speaker_meeting()
                .details_in_sidebar_click();
        asserts.assertTrue(created_speaker_meeting_page.verify_start_date_in_created_meeting(), "start_date_2");
        asserts.assertTrue(created_speaker_meeting_page.verify_end_date_in_created_meeting(), "end_date_2");
        asserts.assertAll();
    }
}
