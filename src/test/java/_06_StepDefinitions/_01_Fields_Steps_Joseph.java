package _06_StepDefinitions;

import _05_POM._02_Navigation_Bar_Elements_Joseph;
import _05_POM._03_Dialog_Content_Elements_Joseph;
import io.cucumber.java.en.*;
import org.testng.annotations.Test;
import java.util.List;

public class _01_Fields_Steps_Joseph {

    _02_Navigation_Bar_Elements_Joseph nb =new _02_Navigation_Bar_Elements_Joseph();
    _03_Dialog_Content_Elements_Joseph dc= new _03_Dialog_Content_Elements_Joseph();

    @Test(priority =1, enabled = true)
    @Given("User add field {string} and {string}")
    public void user_add_field_and(String name, String code) {

        nb.sleep();
        nb.clickFunction(nb.getSetupOne());
        nb.clickFunction(nb.getParameters());
        nb.clickFunction(nb.getFields());
        dc.clickFunction(dc.getAddButton2());
        dc.sendKeysFunction(dc.getNameInput(), name);
        dc.sendKeysFunction(dc.getCodeInput(),code);
        dc.clickFunction(dc.getSaveButton());

    }

    @Test(priority =2,enabled=true)
    @When("User add same field name")
    public void user_add_same_field_name(io.cucumber.datatable.DataTable dataTable) {
        nb.sleep();
        nb.clickFunction(nb.getSetupOne());
        nb.clickFunction(nb.getParameters());
        nb.clickFunction(nb.getFields());
        dc.clickFunction(dc.getAddButton2());
        List<List<String>> testData = dataTable.asLists();
        for (List<String> data : testData) {
            dc.sendKeysFunction(dc.getNameInput(), data.get(0));
            dc.sendKeysFunction(dc.getCodeInput(), data.get(0));
            dc.clickFunction(dc.getSaveButton());
            dc.clearFunction(dc.getNameInput());
            dc.clearFunction(dc.getCodeInput());
        }
    }
    @Test(priority =3,enabled=true)
    @And("User edit field {string} and change it to {string}")
    public void userEditFieldAndChangeItTo(String existingName, String newName) {

        nb.sleep();
        nb.clickFunction(nb.getSetupOne());
        nb.clickFunction(nb.getParameters());
        nb.clickFunction(nb.getFields());
        nb.waitUntilLoading();

        dc.clickFunction(dc.getSearchField());
        dc.sendKeysFunction(dc.getSearchField(),existingName);
        dc.clickFunction(dc.getSearchButton());
        dc.sleep();
        dc.clickFunction(dc.getEditButton());
        dc.clearFunction(dc.getNameInput());
        dc.sendKeysFunction(dc.getNameInput(), newName);
        dc.clickFunction(dc.getSaveButton());

    }

    @Test(priority = 4)
    @Given("User delete field {string}")
    public void user_delete_field(String name) {
        nb.sleep();
        nb.clickFunction(nb.getSetupOne());
        nb.clickFunction(nb.getParameters());
        nb.clickFunction(nb.getFields());
        nb.waitUntilLoading();

        dc.clickFunction(dc.getSearchField());
        dc.sendKeysFunction(dc.getSearchField(),name);
        dc.clickFunction(dc.getSearchButton());
        dc.waitUntilLoading();
        dc.clickFunction(dc.getDeleteButton());
        dc.clickFunction(dc.getDeleteDialogBtn());
    }

    @When("user search deleted {string} in search input")
    public void user_search_deleted_in_search_input(String name) {
        nb.sleep();
        nb.clickFunction(nb.getSetupOne());
        nb.clickFunction(nb.getParameters());
        nb.clickFunction(nb.getFields());
        nb.waitUntilLoading();

        dc.clickFunction(dc.getSearchField());
        dc.sendKeysFunction(dc.getSearchField(),name);
        dc.clickFunction(dc.getSearchButton());
        dc.waitUntilLoading();
    }

    @Then("Success message need to be displayed")
    public void successMessageNeedToBeDisplayed() {
        dc.validationText(dc.getSuccessMessage(), "successfully");
    }

    @Then("Exist message need to be displayed")
    public void existMessageNeedToBeDisplayed() {
        dc.validationText(dc.getAlreadyExist(), "exist");
    }

    @Then("There is no data need to be displayed")
    public void thereIsNoDataNeedToBeDisplayed() {
        dc.validationText(dc.getNoDataMessage(), "no");
    }
}
