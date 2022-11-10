package _05_POM;

import _08_Utils.Driver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _03_Dialog_Content_Elements extends _01_Base_POM {

  public _03_Dialog_Content_Elements() {
    PageFactory.initElements(Driver.getDriver(), this);
  }

  @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
  private WebElement addButton;
  @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
  private WebElement nameInput;
  @FindBy(xpath = "//ms-save-button//button")
  private WebElement  saveButton;
  @FindBy(xpath = "//div[contains(text(),'successfully')]")
  private WebElement successMessage;
  @FindBy(xpath = "//div[contains(text(),'already exists')]")
  private WebElement alreadyExist;
  @FindBy(xpath = "//input[@data-placeholder='Name']")
  private WebElement searchInput;
  @FindBy(xpath = "(//ms-text-field[@placeholder='GENERAL.FIELD.NAME']//input)[2]")
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


  public WebElement getAddButton() {
    return addButton;
  }

  public WebElement getNameInput() {
    return nameInput;
  }

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
  public WebElement getSearchInput2() {
    return searchInput2;
  }

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
