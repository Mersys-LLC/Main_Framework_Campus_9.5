package _05_POM;


import _08_Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navigation_Bar_Elements_Document_Types_G3_MAli extends Base_POM_MAli{

    public Navigation_Bar_Elements_Document_Types_G3_MAli() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "(//span[@class='mat-button-wrapper'])[3]")
    private WebElement clickHamburger;

    @FindBy(xpath="(//span[text()='Setup'])[1]")
    private WebElement clickSetup;

    @FindBy(xpath = "//span[text()='Parameters']")
    private WebElement clickParameters;

    @FindBy(xpath = "(//span[text()='Document Types'])[1]")
    private WebElement clickDocumentTypes;




    public WebElement getClickHamburger() {
        return clickHamburger;
    }

    public WebElement getClickSetup() {
        return clickSetup;
    }

    public WebElement getClickParameters() {
        return clickParameters;
    }

    public WebElement getClickDocumentTypes() {
        return clickDocumentTypes;
    }
}
