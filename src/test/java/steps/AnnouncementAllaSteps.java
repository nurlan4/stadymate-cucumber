package steps;

import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AnnouncementAllaPage;
import pages.StudymateLoginPage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

public class AnnouncementAllaSteps {

    WebDriver driver = Driver.getDriver();
    StudymateLoginPage studymateLoginPage = new StudymateLoginPage();
    AnnouncementAllaPage announcementAllaPage = new AnnouncementAllaPage();
    final static Logger logger = Logger.getLogger(AnnouncementAllaSteps.class);



    @Given("user go to codewise.studymate.us")
    public void user_go_to_codewise_studymate_us() {
        driver.get(Config.getValue("studymateUrl"));
        Assert.assertEquals("StudyMate",driver.getTitle());
        logger.info("User: " +  Config.getValue("email")+ " is on Login page");
    }
    @Then("user enters valid {string} and valid {string}")
    public void user_enters_valid_and_valid(String username, String password) {
        username = Config.getValue("studymateUsername");
        password = Config.getValue("studymatePassword");
        studymateLoginPage.usernameInput.sendKeys(username);
        studymateLoginPage.passwordInput.sendKeys(password);
        studymateLoginPage.loginBtn.click();
        logger.info("User entered email: " + Config.getValue("studymateUsername"));
        logger.info("User entered password: " + Config.getValue("studymatePassword"));

    }
    @Given("user on Home page")
    public void user_on_home_page() {
        String expectedUrl = "https://codewise.studymate.us/admin/analytics";
        ApplicationFlow.pause(3000);
        Assert.assertEquals(expectedUrl,Driver.getDriver().getCurrentUrl());
        logger.info("Verified the Login page URL");
    }
    @Then("user clicks on Announcements")
    public void user_clicks_on_announcements() {
     studymateLoginPage.menuOptions.get(5).click();
     logger.info("User clicked on 'Announcements'");
    }
    @Then("user located on Announcements page")
    public void user_located_on_announcements_page() {
        String expectedUrl = "https://codewise.studymate.us/admin/announcements?size=4&page=1";
        ApplicationFlow.pause(3000);
        Assert.assertEquals(expectedUrl,Driver.getDriver().getCurrentUrl());
        logger.info("User on Announcements Page");
    }
    @When("user clicks on Add an Announcement button")
    public void user_clicks_on_add_an_announcement_button() {
     announcementAllaPage.btnAddAnnouncement.click();
     logger.info("User clicked on 'Add an Announcement'");
    }
    @When("user enters name of Announcement")
    public void user_enters_name_of_announcement() {
        announcementAllaPage.textInput.sendKeys("New Announcement");
        logger.info("User enters text");

    }
    @Then("user clicks on Group")
    public void user_clicks_on_group() {
        announcementAllaPage.chooseGroup.click();
        ApplicationFlow.pause(4000);
        announcementAllaPage.firstOptionInDropdown.click();
        logger.info("User chose first option in dropdown");

    }
    @Then("user should see the Для всех option instead For all")
    public void user_should_see_the_для_всех_option_instead_for_all() {


    }

    @Then("user clicks on Add button")
    public void user_clicks_on_add_button() {
       announcementAllaPage.addBtn.click();
       logger.info("User clicked on Add button and successfully created announcement");
    }
}
