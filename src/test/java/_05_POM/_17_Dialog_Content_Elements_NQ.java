package _05_POM;

import _08_Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _17_Dialog_Content_Elements_NQ extends _17_Base_POM_NQ {


    public _17_Dialog_Content_Elements_NQ() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    //Grade Levels functionality elements
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

    @FindBy(xpath = "//span[text()= ' 100 ']")
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




    //Academic Period functionality elements
    @FindBy(xpath = "//ms-text-field[@placeholder='GENERAL.FIELD.NAME']//input")
    private WebElement nameInputAcPer;

    @FindBy(xpath = "//button//span[text()='Search']")
    private WebElement searchButton;

    @FindBy(css = "ms-standard-button[tooltip='GENERAL.FIELD.ACADEMIC_PERIOD']")
    private WebElement academicPeriodButton;

    @FindBy(css = "ms-add-button[fab='true'] div button")
    private WebElement addButtonAcPer;

    @FindBy(css = "input[data-placeholder='Academic Period Name']")
    private WebElement AcPerNameInput;

    @FindBy(xpath = "(//ms-date//div//input[@aria-required='true'])[1]")
    private WebElement startDateInput;

    @FindBy(xpath = "(//ms-date//div//input[@aria-required='true'])[2]")
    private WebElement endDateInput;

    @FindBy(xpath = "//div[contains(text(), 'conflicts')]")
    private WebElement conflictsMessage;

    @FindBy(xpath = "//span[text()='season1']")
    private WebElement seasonOneText;

    @FindBy(xpath = "//span[text()='season3']")
    private WebElement seasonThreeText;

    @FindBy(xpath = "//ms-delete-button[@buttonbar='true']//button")
    private WebElement deleteAcPerButton;

    @FindBy(xpath = "//div[contains(text(), 'success')]")
    private WebElement successMessages;


    //  Grade Levels getters
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


    //Academic Period getters
    public WebElement getNameInputAcPer() {
        return nameInputAcPer;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getAcademicPeriodButton() {
        return academicPeriodButton;
    }

    public WebElement getAddButtonAcPer() {
        return addButtonAcPer;
    }

    public WebElement getAcPerNameInput() {
        return AcPerNameInput;
    }

    public WebElement getStartDateInput() {
        return startDateInput;
    }

    public WebElement getEndDateInput() {
        return endDateInput;
    }

    public WebElement getConflictsMessage() {
        return conflictsMessage;
    }

    public WebElement getSeasonOneText() {
        return seasonOneText;
    }

    public WebElement getSeasonThreeText() {
        return seasonThreeText;
    }

    public WebElement getDeleteAcPerButton() {
        return deleteAcPerButton;
    }

    public WebElement getSuccessMessages() {
        return successMessages;
    }
}