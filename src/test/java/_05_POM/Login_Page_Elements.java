package _05_POM;

import _08_Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page_Elements extends _01_Base_POM {

  public Login_Page_Elements() {
    PageFactory.initElements(Driver.getDriver(), this);
  }
  @FindBy(css = "input[formcontrolname='username']")
  private WebElement usernameInput;

  @FindBy(css = "input[formcontrolname='password']")
  private WebElement passwordInput;

  @FindBy(css = "button[aria-label='LOGIN']")
  private WebElement loginButton;
  @FindBy(xpath = "//button[text()='Accept all cookies']")
  private WebElement acceptCookiesButton;

  public WebElement getUsernameInput() {
    return usernameInput;
  }

  public WebElement getPasswordInput() {
    return passwordInput;
  }

  public WebElement getLoginButton() {
    return loginButton;
  }

  public WebElement getAcceptCookiesButton() {
    return acceptCookiesButton;
  }

}
