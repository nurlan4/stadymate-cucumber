package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.StudymateAnnouncementPage;
import pages.StudymateLoginPage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;



public class AnnouncementsTest {


   StudymateLoginPage studymateLoginPage = new StudymateLoginPage();
    WebDriver driver = Driver.getDriver();

    StudymateAnnouncementPage studymateAnnouncementPage = new StudymateAnnouncementPage();

    final static Logger logger = Logger.getLogger(AnnouncementsTest.class);


    @Given("user is on login page")
    public void user_is_on_login_page() {

        driver.get(Config.getValue("studymateUrl"));
        logger.info("User navigate to "+Config.getValue("studymateUrl"));


    }
    @Then("user provide valid credentials")
    public void user_provide_valid_credentials() {

        studymateLoginPage.studyMateLogIn();
        logger.info("User login to page ");

    }
    @Then("user navigates to announcements tab")
    public void user_navigates_to_announcements_tab() {


        ApplicationFlow.pause(3000);
        studymateLoginPage.menuOptions.get(5).click();
        logger.info("User click announcement page");

    }
    @Then("use check current URL with expected")
    public void use_check_current_url_with_expected() {
        String expectedURL = "https://codewise.studymate.us/admin/announcements";
        String currentURL = driver.getCurrentUrl();
        ApplicationFlow.pause(2000);
        Assert.assertEquals(expectedURL,currentURL);
        logger.info("Verified the Login page URL ");

    }

        @Then("user choose the group name on search dropdown")
        public void user_choose_the_group_name_on_search_dropdown() {

        studymateAnnouncementPage.announcementSearchDropD.click();
        ApplicationFlow.pause(1000);
        logger.info("User click on searchDropdown");

    }

        @Then("user can see chosen group on page")
        public void user_can_see_chosen_group_on_page() {

            studymateAnnouncementPage.studymateTest.click();
            ApplicationFlow.pause(1000);

            Assert.assertTrue(studymateAnnouncementPage.expectedAnnouncement.isDisplayed());
            logger.info("User choose announcement");
            logger.info("Verify expected announcement is displayed");
    }


    @Then("user click on calendar from button and choose from date")
    public void user_click_on_calendar_from_button_and_choose_from_date() {
        studymateAnnouncementPage.fromCalendaryBtn.click();
        ApplicationFlow.pause(1000);
        studymateAnnouncementPage.firstDayInCalendary.click();
        ApplicationFlow.pause(1000);
        logger.info("User choose calendar date from");

    }

    @Then("user click on calendar from button and choose till date")
    public void user_click_on_calendar_from_button_and_choose_till_date() {

        studymateAnnouncementPage.tillCalendaryBtn.click();
        ApplicationFlow.pause(1000);
        studymateAnnouncementPage.lastDayInCalendary.click();
        ApplicationFlow.pause(1000);
        logger.info("User choose calendar date till");

    }

    @Then("user should see announcement related chosen group and date")
    public void user_should_see_announcement_related_chosen_group_and_date() {
        Assert.assertTrue(studymateAnnouncementPage.expectedAnnouncement.isDisplayed());
        logger.info("User check is selected announcement is displayed");
    }


    }





