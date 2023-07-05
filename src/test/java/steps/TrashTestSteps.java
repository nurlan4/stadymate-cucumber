package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.StudymateLoginPage;
import pages.TrashPage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

import java.time.LocalDate;


public class TrashTestSteps {
    StudymateLoginPage studymateLoginPage = new StudymateLoginPage();
    TrashPage trashPage = new TrashPage();
    final static Logger logger = Logger.getLogger(TrashTestSteps.class);

    @Given("user is in studyMate login page")
    public void user_is_in_study_mate_login_page() {
        Driver.getDriver().get(Config.getValue("studymateUrl"));
        logger.info("user is in the studyMate log in page ");

    }

    @Given("user provides valid a username")
    public void user_provides_valid_a_username() {
        studymateLoginPage.usernameInput.sendKeys(Config.getValue("studymateUsername"));
        logger.info("user provides a valid username ");
    }

    @Given("user provides valid password")
    public void user_provides_valid_password() {
        studymateLoginPage.passwordInput.sendKeys(Config.getValue("studymatePassword"));
        logger.info("user provides a valid password");
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        studymateLoginPage.loginBtn.click();
        logger.info("user clicks on login button");
    }

    @Then("verify the user is on the main page")
    public void verify_the_user_is_on_the_main_page() {
        ApplicationFlow.pause(2000);
        String mainPageUrl = "https://codewise.studymate.us/admin/analytics";
        Assert.assertEquals(mainPageUrl, Driver.getDriver().getCurrentUrl());
        logger.info("verify the user is on the main paige ");
    }

    @When("user clicks on the trash link")
    public void user_clicks_on_the_trash_link() {
        trashPage.trashLink.click();
        logger.info("user clicks on the trash link ");
    }

    @Then("verify the user in on the trash page")
    public void verify_the_user_in_on_the_trash_page() {
        ApplicationFlow.pause(2000);
        String trashPageLink = "https://codewise.studymate.us/admin/deleted-items?size=6&page=1";
        Assert.assertEquals(trashPageLink, Driver.getDriver().getCurrentUrl());
        logger.info("verify the use is on the login paige ");
    }

    @Then("verify the items will be deleted text is displayed")
    public void verify_the_items_will_be_deleted_text_is_displayed() {
        Assert.assertTrue(trashPage.itemsWillBeDeletedText.isDisplayed());
        logger.info("verify the item will be deleted text is displayed");
    }

    @Then("user locates the number of elements, provides it to the elements input and clicks enter")
    public void user_locates_the_number_of_elements_provides_it_to_the_elements_input_and_clicks_enter() {
        String trashFrom = trashPage.numberOfTrash.getText();
        String trashNumber = trashFrom.substring(4).trim();
        trashPage.trashNumberInput.sendKeys(Keys.chord(Keys.CONTROL + "a") + trashNumber + Keys.ENTER);
        logger.info("user locates the number of elements, provides it to the elements input and clicks enter");
    }

    @Then("user verifies if the elements had been deleted")
    public void user_verifies_if_the_elements_had_been_deleted() {
        LocalDate currantDate = LocalDate.now();
        LocalDate dateMinusSevenDays = currantDate.minusDays(7);

        for (WebElement i : trashPage.listOfTrash) {
            int num = Integer.parseInt(i.getText().substring(8));
            if (num < dateMinusSevenDays.getDayOfMonth()) {

            } else {
                System.out.println("TEST PASSED");
            }
        }
        logger.info("user verifies if the elements had been deleted ");
    }
}
