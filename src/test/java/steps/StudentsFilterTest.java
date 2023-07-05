package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pages.StudentsFilterPage;
import pages.StudymateLoginPage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;



public class StudentsFilterTest {
    WebDriver driver = Driver.getDriver();
    StudentsFilterPage studentsFilterPage = new StudentsFilterPage();
    StudymateLoginPage studymateLoginPage = new StudymateLoginPage();

    final static Logger logger = Logger.getLogger(StudentsFilterTest.class);



    @Given("user go to codewise.studymate.us")
    public void user_go_to_codewise_studymate_us() {
        driver.get(Config.getValue("studymateUrl"));
        Assert.assertEquals("StudyMate",driver.getTitle());
        logger.info("User: " +  Config.getValue("email")+  "is on Login page");


    }
    @Then("user enters valid “email” and valid “password”")
    public void user_enters_valid_email_and_valid_password() {
        studymateLoginPage.studyMateLogIn();
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
    @Then("user clicks on Students")
    public void user_clicks_on_students() {
        studymateLoginPage.menuOptions.get(4).click();
        logger.info("User clicked on ‘Students’");

    }
    @Then("user located on Students page")
    public void user_located_on_students_page() {

        String expectedUrl = "https://codewise.studymate.us/admin/students?size=6&page=1";
        ApplicationFlow.pause(3000);
        Assert.assertEquals(expectedUrl,Driver.getDriver().getCurrentUrl());
        logger.info("User on Students Page");

    }
    @Given("user is on students tab")
    public void user_is_on_students_tab() {

        studentsFilterPage.studentFilterBtn.click();
        logger.info("user is on students tab");


    }
    @When("user clicks on filter button")
    public void user_clicks_on_filter_button() {
        studentsFilterPage.studentFilterBtn.click();
        logger.info("user clicks on filter button");

    }
    @When("user sees a search parameters window popup")
    public void user_sees_a_search_parameters_window_popup() {

        studentsFilterPage.filterBtn.click();
        logger.info("user sees a filter windows");
        ApplicationFlow.pause(3000);

    }

    @Then("user clicks on study format button")
    public void user_clicks_on_study_format_button() {
        studentsFilterPage.studyFormatDropDown.click();
        studentsFilterPage.optionOnline.click();
        logger.info("user clicks on study format button");

    }
    @Then("user clicks on group button")
    public void user_clicks_on_group_button() {
        studentsFilterPage.groupDropDown.click();
        studentsFilterPage.secondOption.click();
        logger.info("user clicks on group button ");

    }
    @Then("user clicks on apply button")
    public void user_clicks_on_apply_button() {
        studentsFilterPage.applyBtn.click();
        logger.info("user clicks on apply button");

    }
    


}