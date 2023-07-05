package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Assert;
import pages.StudymateLoginPage;
import pages.TrashPage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

public class RecoverySteps {
    TrashPage trashPage = new TrashPage();
    int numberOfItmesInTrash;
    int totalNumberOfItems;
    StudymateLoginPage studymateLoginPage= new StudymateLoginPage();

    final static Logger logger = Logger.getLogger(RecoverySteps.class);

    @Given("User on Annoucements page")
    public void user_on_annoucements_page() {
        Driver.getDriver().get(Config.getValue("studymateUrl"));

        studymateLoginPage.studyMateLogIn();
        logger.info("user logged in");
    }
    public int countingItemsSum(){
        int sum=0;
        for (int i = 1; i < trashPage.navBarItems.size()-2; i++) {
            trashPage.navBarItems.get(i).click();
            ApplicationFlow.pause(1500);
            sum+=Integer.parseInt(trashPage.textOfItems.getText().trim().trim().replace("from ",""));
        }
        logger.info("User checked the number of values");
        return sum;

    }
    @Given("User clicks on trash pages")
    public void user_clicks_on_trash_pages() {

        totalNumberOfItems = countingItemsSum();
        trashPage.trashPageLink.click();
        logger.info("user clicks on trash pages");

    }
    @Given("User should be redirected to trash page")
    public void user_should_be_redirected_to_trash_page() {
        ApplicationFlow.pause(1500);
        Assert.assertEquals("Couldn't redirect to the trash page","https://codewise.studymate.us/admin/deleted-items?size=6&page=1", Driver.getDriver().getCurrentUrl());
        logger.info("validated that the user is on login page");

    }
    @Given("User clicks on recover button on some item")
    public void user_clicks_on_recover_button_on_some_item() {

        numberOfItmesInTrash = Integer.parseInt(trashPage.textOfItems.getText().trim().replace("from ",""));
        trashPage.lastPagebutton.click();
        trashPage.lastItemsRecoveryButton.click();
        ApplicationFlow.pause(1500);
        logger.info("user clicks on recover button on some item");

    }
    @Then("Verify that the item was recovered on some other page")
    public void verify_that_the_item_was_recovered_on_some_other_page() {

        Assert.assertEquals("The number of items in trash didn't decrease by 1", Integer.parseInt(trashPage.textOfItems.getText().trim().replace("from ","")),numberOfItmesInTrash-1);
        Assert.assertEquals("The number of items in trash didn't increas by 1", totalNumberOfItems+1,countingItemsSum());
        logger.info("Verified that the item was recovered on some other page");


    }
}
