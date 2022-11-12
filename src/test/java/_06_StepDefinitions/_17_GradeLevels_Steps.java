package _06_StepDefinitions;

import _05_POM._17_Dialog_Content_Elements_NQ;
import _05_POM._17_Navigation_Bar_Elements_NQ;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;

public class _17_GradeLevels_Steps {

    _17_Navigation_Bar_Elements_NQ nb = new _17_Navigation_Bar_Elements_NQ();
    _17_Dialog_Content_Elements_NQ dc = new _17_Dialog_Content_Elements_NQ();


    @Given("Navigate to Grade Levels page")
    public void navigate_to_grade_levels_page() {
        nb.sleep();
        nb.clickFunction(nb.getSetupPage());
        nb.clickFunction(nb.getParametersPage());
        nb.clickFunction(nb.getGradeLevelsPage());
    }

    @Test(priority = 1)
    @When("User creates new name {string} {string} {string}")
    public void user_creates_new_name(String gradeLevelsName, String shortName, String order) {
        dc.clickFunction(dc.getAddButton());
        dc.sendKeysFunction(dc.getNameInput(), gradeLevelsName);
        dc.sendKeysFunction(dc.getShortNameInput(), shortName);
        dc.sendKeysFunction(dc.getOrderInput(), order);
        dc.clickFunction(dc.getSaveButton());
    }



    @Test(priority = 2)
    @When("User creates same name {string} {string} {string}")
    public void user_creates_same_name(String sameGradeLevelsName, String sameShortName, String sameOrder) {
        dc.clickFunction(dc.getAddButton());
        dc.sendKeysFunction(dc.getNameInput(), sameGradeLevelsName);
        dc.sendKeysFunction(dc.getShortNameInput(), sameShortName);
        dc.sendKeysFunction(dc.getOrderInput(), sameOrder);
        dc.clickFunction(dc.getSaveButton());
    }



    @Test(priority = 3)
    @When("User scroll to find name and click Edit enter {string} and click Save button")
    public void userScrollToFindNameAndClickEditEnterAndClickSaveButton(String newName) {
        dc.waitUntilVisibleAndClickable(dc.getSizeRadioButton());
        dc.clickFunction(dc.getSizeRadioButton());
        dc.clickFunction(dc.getFiveHundredButton());
        dc.waitUntilVisibleAllElement(dc.getNameList());
        dc.scrollToElement(dc.getNameFromListForEdit());
        dc.waitUntilVisibleAndClickable(dc.getNameFromListForEdit());
        dc.clearFunction(dc.getNameInput());
        dc.sendKeysFunction(dc.getNameInput(), newName);
        dc.clickFunction(dc.getSaveButton());
    }



    @Test(priority = 4)
    @When("User click Delete button")
    public void userClickDeleteButton() {
        dc.waitUntilVisibleAndClickable(dc.getNameFromListForDelete());
        dc.clickFunction(dc.getDeleteButton());
        dc.clickFunction(dc.getConfirmDeleteButton());
    }



    @Test(priority = 5)
    @When("User click Grade Level name which is used by another document and click delete button and see this {string}")
    public void userClickGradeLevelNameWhichIsUsedByAnotherDocumentAndClickDeleteButtonAndSeeThis(String message) {
        dc.waitUntilVisibleAndClickable(dc.getNameFromListForDelete1());
        dc.clickFunction(dc.getDeleteButton1());
        dc.clickFunction(dc.getConfirmDeleteButton());
    }




    @Then("User should see successful message")
    public void user_should_see_successful_message() {
        dc.validationText(dc.getSuccessMessage(), "successfully");
    }


    @Then("User should see unsuccessful message")
    public void user_should_see_unsuccessful_message() {
        dc.validationText(dc.getAlreadyExistMessage(), "exists");
    }


    @Then("User should see successfully updated message")
    public void userShouldSeeSuccessfullyUpdatedMessage() {
        dc.validationText(dc.getSuccessMessage(), "success");
    }


    @Then("User should see successfully deleted message")
    public void userShouldSeeSuccessfullyDeletedMessage() {
        dc.validationText(dc.getSuccessMessage(), "success");
    }



    @Then("User should delete unsuccessfully")
    public void userShouldDeleteUnsuccessfully() {
        dc.validationText(dc.getUnsuccessfullyDeletedMessage(),"not delete");
    }





}





