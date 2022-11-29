package _05_POM;

import _08_Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _03_Dialog_Content_Elements_EG extends _01_Base_POM_EG {
    public _03_Dialog_Content_Elements_EG() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath ="(//span[text()='Country'])[3]")
    private WebElement clickCountry;


    @FindBy(xpath = "//*[contains(text(),' Europe Test1111  ')]")

    private WebElement clickEuropeTest1111;




    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'STATE.TITLE.ADD')]//button")
    private WebElement addButton;



    @FindBy(xpath = "(//input[@data-placeholder='Name'])[2]")
    private WebElement nameInput;
    @FindBy(xpath = "(//*[contains(text(),'Save')])[2]")
    private WebElement  saveButton;
    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successMessage;
    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    private WebElement alreadyExist;
    @FindBy(css = "[class='mat-form-field-infix ng-tns-c77-80']")
    private WebElement searchCountryInput;
    @FindBy(xpath = "//ms-text-field[@placeholder='GENERAL.FIELD.NAME']//input")
    private WebElement searchNameInput;  //(//div[contains(@class,'mat-form-field-infix ng-tns')]//input)[1]
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

    public WebElement getClickEuropeTest1111() {return clickEuropeTest1111;}
    public WebElement getClickCountry() {return clickCountry;}

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

    public WebElement getSearchCountryInput() {
      return searchCountryInput;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSearchNameInput() {
        return searchNameInput;
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

    public List<WebElement> getNameList() {
        return nameList;
    }










}
