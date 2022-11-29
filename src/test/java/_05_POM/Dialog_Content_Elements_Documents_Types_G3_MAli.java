package _05_POM;


import _08_Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dialog_Content_Elements_Documents_Types_G3_MAli extends Base_POM_MAli {

    public Dialog_Content_Elements_Documents_Types_G3_MAli() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement plusIcon;

    @FindBy(xpath = "(//input[@data-placeholder='Name'])[2]")
    private WebElement addName;

    @FindBy(xpath = "(//*[text()='Stage'])[3]")
    private WebElement addStage;  //[class='mat-select-arrow ng-tns-c94-289']

    @FindBy(xpath = "//*[text()=' Examination ']")
    private WebElement selectExamination;

  //  @FindBy(css = "(//span[@class='mat-slide-toggle-thumb'])[32]")
 //   private WebElement clickWhiteSpace;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement clickSave;
    @FindBy(xpath = "//div[text()='Document successfully created']")
    private WebElement successfullyCreated;


    @FindBy(xpath = "//div[text()='Document successfully created']")
    private WebElement  duplicateSuccessful;

    @FindBy(xpath = "//input[@data-placeholder='Name']")
    private WebElement searchName;

    @FindBy(xpath = "//span[text()='Search']")
    private WebElement clickSearch;

    @FindBy(xpath = "(//fa-icon[@class='ng-fa-icon'])[6]")
    private WebElement editIcon;

    @FindBy(xpath = "//div[@class='mat-form-field-infix ng-tns-c77-137']//ms-text-field")
    private WebElement editName;

    @FindBy(xpath = "//div[text()='Document successfully updated']")
    private WebElement successfullyUpdated;

    @FindBy(xpath = "//ms-delete-button[@class='ng-star-inserted']//button")
    private WebElement clickDelete;

    @FindBy(xpath = "//span[text()=' Delete ']")
    private WebElement confirmDelete;

    @FindBy(xpath = "//div[text()='Document successfully deleted']")
    private WebElement deleteSuccessful;

    @FindBy(xpath = "//div[text()=' There is no data to display ']")
    private WebElement noSuchData;

//********************************************



    public WebElement getPlusIcon() {
        return plusIcon;
    }

    public WebElement getAddName() {
        return addName;
    }

    public WebElement getAddStage() {
        return addStage;
    }

    public WebElement getSelectExamination() {
        return selectExamination;
    }

   // public WebElement getClickWhiteSpace() {
   //     return clickWhiteSpace;
  //  }

    public WebElement getClickSave() {
        return clickSave;
    }

    public WebElement getSuccessfullyCreated() {
        return successfullyCreated;
    }

    public WebElement getDuplicateSuccessful() {
        return duplicateSuccessful;
    }

    public WebElement getSearchName() {
        return searchName;
    }

    public WebElement getClickSearch() {
        return clickSearch;
    }

    public WebElement getEditIcon() {
        return editIcon;
    }

    public WebElement getEditName() {
        return editName;
    }

    public WebElement getSuccessfullyUpdated() {
        return successfullyUpdated;
    }

    public WebElement getClickDelete() {
        return clickDelete;
    }

    public WebElement getConfirmDelete() {
        return confirmDelete;
    }

    public WebElement getDeleteSuccessful() {
        return deleteSuccessful;
    }



    public WebElement getNoSuchData() {
        return noSuchData;
    }
}
