package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TrashPage {
    public TrashPage(){
        PageFactory.initElements(Driver.getDriver(), this );
    }

    @FindBy(xpath = "//table/tbody/tr/td[2]")
    public List<WebElement> listOfTrash;

    @FindBy(xpath = "//li[.='Trash']")
    public WebElement trashLink;

    @FindBy(xpath = "(//p)[13]")
    public WebElement numberOfTrash;

    @FindBy(xpath = "(//input)[2]")
    public WebElement
            trashNumberInput;

    @FindBy(xpath = "//p[.='Items in the cart are automatically deleted after 7 days from the date of adding!']")
    public WebElement itemsWillBeDeletedText;
}
