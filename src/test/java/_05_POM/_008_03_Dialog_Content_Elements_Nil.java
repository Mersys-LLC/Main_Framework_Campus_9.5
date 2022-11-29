package _05_POM;

import _08_Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _008_03_Dialog_Content_Elements_Nil extends _008_01_Base_POM_Nil {

    public _008_03_Dialog_Content_Elements_Nil() { PageFactory.initElements(Driver.getDriver(), this); }

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='description']//input")
    private WebElement descriptionInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    private  WebElement ıntegrationCodeInput;

    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']//input")
    private WebElement priorityInput;

    @FindBy(xpath = "//mat-slide-toggle[@formcontrolname='active']")
    private WebElement activeButton;

    @FindBy(xpath = "//ms-save-button//button[1]")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successMessage;

    @FindBy(xpath = "//ms-text-field[@placeholder='DISCOUNT.TITLE.DESCRIPTION']//input")
    private WebElement searchInput1;

    @FindBy(xpath = "//ms-text-field[@placeholder='GENERAL.FIELD.CODE']//input")
    private WebElement searchInput2;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    private WebElement alreadyExist;

    @FindBy(xpath = "//ms-edit-button//button[1]")
    private WebElement editButton;

    @FindBy(xpath = "(//ms-delete-button//button)[1]")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private WebElement deleteSureButton;

    @FindBy(xpath = "//div[contains(@class,'table-loading-s')]")
    private WebElement noDataMessage;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> nameList;

    public WebElement getAddButton() { return addButton; }
    public WebElement getDescriptionInput() { return descriptionInput; }
    public WebElement getIntegrationCodeInput() { return ıntegrationCodeInput; }
    public WebElement getPriorityInput() { return priorityInput; }
    public WebElement getActiveButton() { return activeButton; }
    public WebElement getSaveButton() { return saveButton; }
    public WebElement getSearchInput1() { return  searchInput1; }
    public WebElement getSearchInput2() { return searchInput2; }
    public WebElement getSearchButton() { return searchButton; }
    public WebElement getEditButton() { return editButton; }
    public WebElement getDeleteButton() { return deleteButton; }
    public WebElement getDeleteSureButton() { return deleteSureButton; }

    public WebElement getSuccessMessage() { return successMessage; }
    public WebElement getAlreadyExist() { return alreadyExist; }
    public WebElement getNoDataMessage() { return noDataMessage; }

}
