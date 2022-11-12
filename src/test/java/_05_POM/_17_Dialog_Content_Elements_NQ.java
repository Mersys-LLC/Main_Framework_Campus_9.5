package _05_POM;

import _08_Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _17_Dialog_Content_Elements_NQ extends _17_Base_POM_NQ{


    public _17_Dialog_Content_Elements_NQ(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'GRADE_LEVELS.TITLE.ADD')]//button")
    private WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(css = "input[data-placeholder=\"Short Name\"]")
    private WebElement shortNameInput;

    @FindBy(css = "input[data-placeholder=\"Order\"]")
    private WebElement orderInput;

    @FindBy(xpath = "//ms-save-button//button")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(), 'success')]")
    private WebElement successMessage;

    @FindBy(xpath = "//div[contains(text(), 'already exists.')]")
    private WebElement alreadyExistMessage;

    @FindBy(css = "mat-select[aria-label='Size']")
    private WebElement sizeRadioButton;

    @FindBy (xpath = "//span[text()= ' 100 ']")
    private WebElement fiveHundredButton;

    @FindBy(xpath = "(//ms-edit-button[@table='true']//button)[1]")
    private WebElement editButton;

    @FindBy(xpath = "//td[text()='nigar']")
    private WebElement nameFromListForEdit;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> nameList;

    @FindBy(xpath = "//td[text()='melisa']")
    private WebElement nameFromListForDelete;

    @FindBy(xpath = "//td[text()='2ndGradedss']")
    private WebElement nameFromListForDelete1;

    @FindBy(xpath = "(//ms-delete-button//button)[2]")
    private WebElement deleteButton;

    @FindBy(xpath = "(//ms-delete-button//button)[1]")
    private WebElement deleteButton1;

    @FindBy(css = "button[type='submit']")
    private WebElement confirmDeleteButton;
    @FindBy(xpath = "//div[contains(text(), 'not delete')]")
    private WebElement unsuccessfullyDeletedMessage;




    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getNameInput() {
        return nameInput;
    }

    public WebElement getShortNameInput() {
        return shortNameInput;
    }

    public WebElement getOrderInput() {
        return orderInput;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public WebElement getSuccessMessage() {
        return successMessage;
    }

    public WebElement getAlreadyExistMessage() {
        return alreadyExistMessage;
    }

    public WebElement getSizeRadioButton() {
        return sizeRadioButton;
    }

    public WebElement getFiveHundredButton() {
        return fiveHundredButton;
    }

    public WebElement getEditButton() {
        return editButton;
    }

    public WebElement getNameFromListForEdit() {
        return nameFromListForEdit;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public WebElement getConfirmDeleteButton() {
        return confirmDeleteButton;
    }

    public WebElement getNameFromListForDelete() {
        return nameFromListForDelete;
    }

    public WebElement getUnsuccessfullyDeletedMessage() {
        return unsuccessfullyDeletedMessage;
    }

    public List<WebElement> getNameList() {
        return nameList;
    }

    public WebElement getNameFromListForDelete1() {
        return nameFromListForDelete1;
    }

    public WebElement getDeleteButton1() {
        return deleteButton1;
    }

}
