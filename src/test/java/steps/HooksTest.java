package steps;


import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;
public class HooksTest {
    final static Logger logger = Logger.getLogger(HooksTest.class);
    @Before
    public void before(Scenario scenario){
        logger.info(scenario+" is starting");
    }
    @After
    public void after(Scenario scenario){
        if(scenario.isFailed()){
            logger.error( scenario +" failed!");
            byte [] screenshot = ((TakesScreenshot)(Driver.getDriver())).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        else {logger.info(scenario + " passed");}
        Driver.quit();
    }
}






