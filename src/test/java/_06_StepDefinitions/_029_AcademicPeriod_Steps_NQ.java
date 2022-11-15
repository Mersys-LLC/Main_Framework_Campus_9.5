package _06_StepDefinitions;

import _05_POM._17_Dialog_Content_Elements_NQ;
import _05_POM._17_Navigation_Bar_Elements_NQ;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class _029_AcademicPeriod_Steps_NQ {


   _17_Navigation_Bar_Elements_NQ nb = new _17_Navigation_Bar_Elements_NQ();
   _17_Dialog_Content_Elements_NQ dc = new _17_Dialog_Content_Elements_NQ();


    @Given("User add Academic Period {string}, {string}, {string}")
    public void userAddAcademicPeriod(String name, String startDate, String endDate) throws InterruptedException {
        nb.sleep();
        nb.clickFunction(nb.getSetupPage());
        nb.clickFunction(nb.getSchoolSetupPage());
        nb.clickFunction(nb.getSchoolsAdminPage());
        dc.waitUntilVisibleAndClickable(dc.getNameInputAcPer());
        dc.clickFunction(dc.getNameInputAcPer());
        dc.sendKeysFunction(dc.getNameInputAcPer(), "YASIN YOLDAS");
        dc.clickFunction(dc.getSearchButton());
        Thread.sleep(2000);
        dc.waitUntilVisibleAndClickable(dc.getAcademicPeriodButton());
        dc.clickFunction(dc.getAcademicPeriodButton());
        Thread.sleep(2000);
        dc.waitUntilVisibleAndClickable(dc.getAddButtonAcPer());
        dc.clickFunction(dc.getAddButtonAcPer());
        dc.clickFunction(dc.getAcPerNameInput());
        dc.sendKeysFunction(dc.getAcPerNameInput(), name);
        dc.clickFunction(dc.getStartDateInput());
        dc.sendKeysFunction(dc.getStartDateInput(), startDate);
        dc.clickFunction(dc.getEndDateInput());
        dc.sendKeysFunction(dc.getEndDateInput(), endDate);
        dc.clickFunction(dc.getSaveButton());
    }


    @Given("User add same Academic Period name {string}, {string}, {string}")
    public void userAddSameAcademicPeriodName(String sameName, String sameStartDate, String sameEndDate) throws InterruptedException {
        nb.sleep();
        nb.clickFunction(nb.getSetupPage());
        nb.clickFunction(nb.getSchoolSetupPage());
        nb.clickFunction(nb.getSchoolsAdminPage());
        dc.waitUntilVisibleAndClickable(dc.getNameInputAcPer());
        dc.clickFunction(dc.getNameInputAcPer());
        dc.sendKeysFunction(dc.getNameInputAcPer(), "YASIN YOLDAS");
        dc.clickFunction(dc.getSearchButton());
        Thread.sleep(2000);
        dc.waitUntilVisibleAndClickable(dc.getAcademicPeriodButton());
        dc.clickFunction(dc.getAcademicPeriodButton());
        dc.waitUntilVisibleAndClickable(dc.getAddButtonAcPer());
        dc.clickFunction(dc.getAddButtonAcPer());
        dc.clickFunction(dc.getAcPerNameInput());
        dc.sendKeysFunction(dc.getAcPerNameInput(), sameName);
        dc.clickFunction(dc.getStartDateInput());
        dc.sendKeysFunction(dc.getStartDateInput(), sameStartDate);
        dc.clickFunction(dc.getEndDateInput());
        dc.sendKeysFunction(dc.getEndDateInput(), sameEndDate);
        dc.clickFunction(dc.getSaveButton());
    }


    @Given("User add same Academic Period name {string}, different date range {string}, {string}")
    public void userAddSameAcademicPeriodNameDifferentDateRange(String sameName, String differentStartDate, String differentEndDate) throws InterruptedException {
        nb.sleep();
        nb.clickFunction(nb.getSetupPage());
        nb.clickFunction(nb.getSchoolSetupPage());
        nb.clickFunction(nb.getSchoolsAdminPage());
        dc.waitUntilVisibleAndClickable(dc.getNameInputAcPer());
        dc.clickFunction(dc.getNameInputAcPer());
        dc.sendKeysFunction(dc.getNameInputAcPer(), "YASIN YOLDAS");
        dc.clickFunction(dc.getSearchButton());
        Thread.sleep(2000);
        dc.waitUntilVisibleAndClickable(dc.getAcademicPeriodButton());
        dc.clickFunction(dc.getAcademicPeriodButton());
        Thread.sleep(2000);
        dc.waitUntilVisibleAndClickable(dc.getAddButtonAcPer());
        dc.clickFunction(dc.getAddButtonAcPer());
        Thread.sleep(2000);
        dc.clickFunction(dc.getAcPerNameInput());
        dc.sendKeysFunction(dc.getAcPerNameInput(), sameName);
        dc.clickFunction(dc.getStartDateInput());
        dc.sendKeysFunction(dc.getStartDateInput(), differentStartDate);
        dc.clickFunction(dc.getEndDateInput());
        dc.sendKeysFunction(dc.getEndDateInput(), differentEndDate);
        dc.clickFunction(dc.getSaveButton());
    }



    @Given("User add different Academic Period name {string}, {string}, {string}")
    public void userAddDifferentAcademicPeriodName(String differentName, String sameStartDate, String sameEndDate) throws InterruptedException {
        nb.sleep();
        nb.clickFunction(nb.getSetupPage());
        nb.clickFunction(nb.getSchoolSetupPage());
        nb.clickFunction(nb.getSchoolsAdminPage());
        dc.waitUntilVisibleAndClickable(dc.getNameInputAcPer());
        dc.clickFunction(dc.getNameInputAcPer());
        dc.sendKeysFunction(dc.getNameInputAcPer(), "YASIN YOLDAS");
        dc.clickFunction(dc.getSearchButton());
        Thread.sleep(2000);
        dc.waitUntilVisibleAndClickable(dc.getAcademicPeriodButton());
        dc.clickFunction(dc.getAcademicPeriodButton());
        Thread.sleep(2000);
        dc.waitUntilVisibleAndClickable(dc.getAddButtonAcPer());
        dc.clickFunction(dc.getAddButtonAcPer());
        Thread.sleep(2000);
        dc.clickFunction(dc.getAcPerNameInput());
        dc.sendKeysFunction(dc.getAcPerNameInput(), differentName);
        dc.clickFunction(dc.getStartDateInput());
        dc.sendKeysFunction(dc.getStartDateInput(), sameStartDate);
        dc.clickFunction(dc.getEndDateInput());
        dc.sendKeysFunction(dc.getEndDateInput(), sameEndDate);
        dc.clickFunction(dc.getSaveButton());
    }

    @Given("User edit Academic Period name {string}, date range {string}, {string}")
    public void userEditAcademicPeriodNameDateRange(String newName, String newStartDate, String newEndDate) throws InterruptedException {
        nb.sleep();
        nb.clickFunction(nb.getSetupPage());
        nb.clickFunction(nb.getSchoolSetupPage());
        nb.clickFunction(nb.getSchoolsAdminPage());
        dc.waitUntilVisibleAndClickable(dc.getNameInputAcPer());
        dc.clickFunction(dc.getNameInputAcPer());
        dc.sendKeysFunction(dc.getNameInputAcPer(), "YASIN YOLDAS");
        dc.clickFunction(dc.getSearchButton());
        Thread.sleep(2000);
        dc.waitUntilVisibleAndClickable(dc.getAcademicPeriodButton());
        dc.clickFunction(dc.getAcademicPeriodButton());
        Thread.sleep(2000);
        dc.waitUntilVisibleAndClickable(dc.getSeasonOneText());
        dc.clickFunction(dc.getSeasonOneText());
        dc.clickFunction(dc.getAcPerNameInput());
        dc.clearFunction(dc.getAcPerNameInput());
        dc.sendKeysFunction(dc.getAcPerNameInput(),newName);
        dc.clickFunction(dc.getStartDateInput());
        dc.clearFunction(dc.getStartDateInput());
        dc.sendKeysFunction(dc.getStartDateInput(), newStartDate);
        dc.clickFunction(dc.getEndDateInput());
        dc.clearFunction(dc.getEndDateInput());
        dc.sendKeysFunction(dc.getEndDateInput(),newEndDate);
        dc.clickFunction(dc.getSaveButton());
    }



    @Given("User delete Academic Period")
    public void userDeleteAcademicPeriod() throws InterruptedException {
        nb.sleep();
        nb.clickFunction(nb.getSetupPage());
        nb.clickFunction(nb.getSchoolSetupPage());
        nb.clickFunction(nb.getSchoolsAdminPage());
        dc.waitUntilVisibleAndClickable(dc.getNameInputAcPer());
        dc.clickFunction(dc.getNameInputAcPer());
        dc.sendKeysFunction(dc.getNameInputAcPer(), "YASIN YOLDAS");
        dc.clickFunction(dc.getSearchButton());
        Thread.sleep(2000);
        dc.waitUntilVisibleAndClickable(dc.getAcademicPeriodButton());
        dc.clickFunction(dc.getAcademicPeriodButton());
        Thread.sleep(2000);
        dc.waitUntilVisibleAndClickable(dc.getSeasonThreeText());
        dc.clickFunction(dc.getSeasonThreeText());
        dc.clickFunction(dc.getDeleteAcPerButton());
        dc.clickFunction(dc.getConfirmDeleteButton());
    }



    @Then("User should see successfully added message")
    public void userShouldSeeSuccessfullyAddedMessage() {
        dc.validationText(dc.getSuccessMessages(), "successfully");
    }

    @Then("User should see already exists message")
    public void userShouldSeeAlreadyExistsMessage() {
        dc.validationText(dc.getAlreadyExistMessage(),"exist");
    }

    @Then("User should see date range conflicts message")
    public void userShouldSeeDateRangeConflictsMessage() {
        dc.validationText(dc.getConflictsMessage(),"conflicts");
    }

    @Then("User should see successfully updated messages")
    public void userShouldSeeSuccessfullyUpdatedMessages() {
        dc.validationText(dc.getSuccessMessages(),"success");
    }

    @Then("User should see successfully deleted messages")
    public void userShouldSeeSuccessfullyDeletedMessages() {
        dc.validationText(dc.getSuccessMessages(),"success");
    }
}