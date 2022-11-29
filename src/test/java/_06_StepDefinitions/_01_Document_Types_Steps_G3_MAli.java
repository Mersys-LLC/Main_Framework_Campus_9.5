package _06_StepDefinitions;


import _05_POM.Dialog_Content_Elements_Documents_Types_G3_MAli;
import _05_POM.Navigation_Bar_Elements_Document_Types_G3_MAli;
import _08_Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class _01_Document_Types_Steps_G3_MAli {
    Navigation_Bar_Elements_Document_Types_G3_MAli nbdt = new Navigation_Bar_Elements_Document_Types_G3_MAli();

    Dialog_Content_Elements_Documents_Types_G3_MAli dcdt = new Dialog_Content_Elements_Documents_Types_G3_MAli();

    @Given("User add Document Types {string}")
    public void userAddDocumentTypes(String name) {
        nbdt.clickFunction(nbdt.getClickHamburger());
        nbdt.clickFunction(nbdt.getClickSetup());
        nbdt.clickFunction(nbdt.getClickParameters());

        nbdt.scrollToElement(nbdt.getClickDocumentTypes());
     //   JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
     //   js.executeScript("window.scrollBy(0,60)", "");

        nbdt.clickFunction(nbdt.getClickDocumentTypes());
        nbdt.clickFunction(dcdt.getPlusIcon());
        nbdt.sendKeysFunction(dcdt.getAddName(), name);
        nbdt.clickFunction(dcdt.getAddStage());
        nbdt.clickFunction(dcdt.getSelectExamination());
        dcdt.actionClass();
        dcdt.clickFunction(dcdt.getClickSave());
    }
    @Given("User create same Document Types {string}")
    public void userCreateSameDocumentTypes(String name) {

        nbdt.clickFunction(nbdt.getClickHamburger());
        nbdt.clickFunction(nbdt.getClickSetup());
        nbdt.clickFunction(nbdt.getClickParameters());

        nbdt.scrollToElement(nbdt.getClickDocumentTypes());
      //  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
     //   js.executeScript("window.scrollBy(0,60)", "");

        nbdt.clickFunction(nbdt.getClickDocumentTypes());
        nbdt.clickFunction(dcdt.getPlusIcon());
        nbdt.sendKeysFunction(dcdt.getAddName(), name);
        nbdt.clickFunction(dcdt.getAddStage());
        nbdt.clickFunction(dcdt.getSelectExamination());
        dcdt.actionClass();
        dcdt.clickFunction(dcdt.getClickSave());

    }

    @When("User search same {string} in search input edit with {string}")
    public void userSearchSameInSearchInputEditWith(String name, String newName) {

           nbdt.clickFunction(nbdt.getClickHamburger());
        nbdt.clickFunction(nbdt.getClickSetup());
        nbdt.clickFunction(nbdt.getClickParameters());

        nbdt.scrollToElement(nbdt.getClickDocumentTypes());
      //  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
      //  js.executeScript("window.scrollBy(0,60)", "");
        nbdt.waitUntilVisibleAndClickable(nbdt.getClickDocumentTypes());
        nbdt.clickFunction(nbdt.getClickDocumentTypes());

        nbdt.sendKeysFunction(dcdt.getSearchName(), name);
        nbdt.clickFunction(dcdt.getClickSearch());
        nbdt.sleep();
       // nbdt.waitUntilVisibleAndClickable(dcdt.getEditIcon());
        nbdt.clickFunction(dcdt.getEditIcon());
      //  nbdt.waitUntilLoading();
        nbdt.sleep();
        nbdt.clearFunction(dcdt.getAddName());
        nbdt.sleep();
        nbdt.sendKeysFunction(dcdt.getAddName(), newName);
       // dcdt.actionClass();
        nbdt.sleep();
        nbdt.clickFunction(dcdt.getClickSave());
    }

    @When("User search newName {string} in  the search input and Delete it")
    public void userSearchNewNameInTheSearchInputAndDeleteIt(String  newName) {

        nbdt.clickFunction(nbdt.getClickHamburger());
        nbdt.clickFunction(nbdt.getClickSetup());
        nbdt.clickFunction(nbdt.getClickParameters());
        nbdt.scrollToElement(nbdt.getClickDocumentTypes());
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,60)", "");
        nbdt.waitUntilVisibleAndClickable(nbdt.getClickDocumentTypes());


        nbdt.clickFunction(nbdt.getClickDocumentTypes());

        nbdt.sendKeysFunction(dcdt.getSearchName(), newName);
        nbdt.clickFunction(dcdt.getClickSearch());
        nbdt.clickFunction(dcdt.getClickDelete());
        nbdt.clickFunction(dcdt.getConfirmDelete());
    }

    @Test
    @When("User search deleted {string} in the search input")
    public void userSearchDeletedInTheSearchInput(String newName) {
        nbdt.clickFunction(nbdt.getClickHamburger());
        nbdt.clickFunction(nbdt.getClickSetup());
        nbdt.clickFunction(nbdt.getClickParameters());
        nbdt.scrollToElement(nbdt.getClickDocumentTypes());
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,60)", "");
        nbdt.waitUntilVisibleAndClickable(nbdt.getClickDocumentTypes());

        nbdt.clickFunction(nbdt.getClickDocumentTypes());

        nbdt.sendKeysFunction(dcdt.getSearchName(), newName);
        nbdt.clickFunction(dcdt.getClickSearch());
    }

    @Test
    @Then("There is no data message should be displayed")
    public void thereIsNoDataMessageShouldBeDisplayed() {
        dcdt.getNoSuchData().isDisplayed();

    }


    @Test
    @Then("Successfully Created message should be displayed")
    public void successfullyCreatedMessageShouldBeDisplayed() {
        nbdt.validationText(dcdt.getSuccessfullyCreated(), "successfully created");
    }

    @Test
    @Then("Successfully updated message should be displayed")
    public void successfullyUpdatedMessageShouldBeDisplayed() {
        nbdt.validationText(dcdt.getSuccessfullyUpdated(), "Successfully updated");
    }

    @Test
    @Then("Successfully Deleted message should be displayed")
    public void successfullyDeletedMessageShouldBeDisplayed() {
        nbdt.validationText(dcdt.getDeleteSuccessful(),"successfully deleted");
    }

    @Then("Already Exist message should display")
    public void alreadyExistMessageShouldDisplay() {
    }
}




