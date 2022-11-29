package _05_POM;

import _08_Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class _02_Navigation_Bar_Elements_EG extends _01_Base_POM_EG{


    public _02_Navigation_Bar_Elements_EG() {PageFactory.initElements(Driver.getDriver(),this);}




    @FindBy(xpath="(//span[text()='Setup'])[1]")
    public WebElement setupOne;


    @FindBy(xpath = "//span[text()='Parameters']")
    private WebElement parameters;

    @FindBy(xpath = "//*[text()='States']")
    private WebElement states;

    public WebElement getSetupOne() {    return setupOne;  }

    public WebElement getParameters() {
        return parameters;
    }

    public WebElement getStates() {
        return states;
    }







}
