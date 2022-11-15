package _05_POM;

import _08_Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _03_Dialog_Content_Elements_Joseph extends _01_Base_POM {

  public _03_Dialog_Content_Elements_Joseph() {
    PageFactory.initElements(Driver.getDriver(), this);
  }

  @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
  private WebElement addButton;

  @FindBy(xpath = "//ms-add-button[contains(@tooltip,'GENERAL.BUTTON.ADD')]//button")
  private WebElement addButton2;
  @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
  private WebElement nameInput;
  @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
  private WebElement codeInput;

  @FindBy(xpath = "//ms-text-field[@placeholder='GENERAL.FIELD.NAME']//input")
  private WebElement searchField;
  @FindBy(xpath = "//ms-save-button//button")
  private WebElement  saveButton;
  @FindBy(xpath = "//div[contains(text(),'successfully')]")
  private WebElement successMessage;
  @FindBy(xpath = "//div[contains(text(),'already exists')]")
  private WebElement alreadyExist;
  @FindBy(xpath = "(//div[contains(@class,'mat-form-field-infix ng-tns')])[1]")
  private WebElement searchInput;
  @FindBy(xpath = "(//div[contains(@class,'mat-form-field-infix ng-tns-c74')]//input)[2]")
  private WebElement searchInput2;
  @FindBy(xpath = "//ms-search-button//button")
  private WebElement searchButton;
  @FindBy(xpath = "//ms-edit-button//button")
  private WebElement editButton;
  @FindBy(xpath = "(//ms-delete-button//button)[1]")
  private WebElement deleteButton;
  @FindBy(xpath = "//span[contains(text(),'Delete')]")
  private WebElement deleteDialogBtn;
  @FindBy(xpath = "//div[contains(@class,'table-loading-s')]")
  private WebElement noDataMessage;

  @FindBy(xpath = "//tbody/tr/td[2]")
  public List<WebElement> nameList;


  public WebElement getAddButton() {return addButton; }
  public WebElement getAddButton2(){return addButton2;}

  public WebElement getSearchField(){return searchField;}

  public WebElement getNameInput() { return nameInput; }
  public WebElement getCodeInput() { return codeInput; }

  public WebElement getSaveButton() {
    return saveButton;
  }

  public WebElement getSuccessMessage() {
    return successMessage;
  }

  public WebElement getAlreadyExist() {
    return alreadyExist;
  }

  public WebElement getSearchInput() {
    return searchInput;
  }

  public WebElement getSearchButton() {
    return searchButton;
  }
  public WebElement getSearchInput2() {return searchInput2; }

  public WebElement getEditButton() {
    return editButton;
  }

  public WebElement getDeleteButton() {
    return deleteButton;
  }

  public WebElement getDeleteDialogBtn() {
    return deleteDialogBtn;
  }

  public WebElement getNoDataMessage() {
    return noDataMessage;
  }
}
