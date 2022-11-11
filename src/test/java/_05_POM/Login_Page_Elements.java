package _05_POM;

import _08_Utils.Driver;
import _08_Utils.ExcelUtility;
import java.util.ArrayList;
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

  public void loginFunction(String data1, String data2) {
    getAcceptCookiesButton().click();
    getUsernameInput().sendKeys(data1);
    getPasswordInput().sendKeys(data2);
    getLoginButton().click();
  }

  public void loginFunctionCredential() {
    ArrayList<ArrayList<String>> data =
        ExcelUtility.getListData("src/test/java/_02_ApachePOI/Resources/ApacheExcel22.xlsx",
            "Login", 2);
    for (ArrayList<String> row : data) {
      loginFunction(row.get(0), row.get(1));
    }
  }
}
