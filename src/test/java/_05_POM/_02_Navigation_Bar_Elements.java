package _05_POM;

import _08_Utils.Driver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _02_Navigation_Bar_Elements extends _01_Base_POM {

  public _02_Navigation_Bar_Elements(){
    PageFactory.initElements(Driver.getDriver(),this);
  }

  @FindBy(xpath="(//span[text()='Setup'])[1]")
  private WebElement setupOne;


  @FindBy(xpath = "//span[text()='Parameters']")
  private WebElement parameters;

  @FindBy(xpath = "//span[text()='Nationalities']")
  private WebElement nationalities;

  @FindBy(xpath = "//span[text()='Fields']")
  private WebElement fields;

  public WebElement getSetupOne() {    return setupOne;  }

  public WebElement getParameters() {
    return parameters;
  }

  public WebElement getNationalities() {
    return nationalities;
  }
  public WebElement getFields() { return fields; }



}
