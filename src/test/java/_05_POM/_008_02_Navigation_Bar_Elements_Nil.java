package _05_POM;

import _08_Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _008_02_Navigation_Bar_Elements_Nil extends _008_01_Base_POM_Nil {

    public _008_02_Navigation_Bar_Elements_Nil() { PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    private WebElement setupOne;

    @FindBy(xpath = "//span[text()='Parameters']")
    private WebElement Parameters;

    @FindBy(xpath = "//span[text()='Discounts'][1]")
    private WebElement Discounts;

    public WebElement getSetupOne() { return setupOne; }

    public WebElement getParameters() {
        return Parameters;
    }

    public WebElement getDiscounts() {
        return Discounts;
    }

}
