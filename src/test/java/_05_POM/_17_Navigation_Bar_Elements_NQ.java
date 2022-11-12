package _05_POM;

import _08_Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _17_Navigation_Bar_Elements_NQ extends _17_Base_POM_NQ{


    public _17_Navigation_Bar_Elements_NQ(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='Setup']")
    private WebElement setupPage;

    @FindBy(xpath = "//span[text()='Parameters']")
    private WebElement parametersPage;

    @FindBy(xpath = "//span[text()='Grade Levels']")
    private WebElement gradeLevelsPage;



    public WebElement getSetupPage() {
        return setupPage;
    }

    public WebElement getParametersPage() {
        return parametersPage;
    }

    public WebElement getGradeLevelsPage() {
        return gradeLevelsPage;
    }







}
