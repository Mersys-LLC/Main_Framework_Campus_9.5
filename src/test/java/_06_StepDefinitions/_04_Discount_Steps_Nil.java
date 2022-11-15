package _06_StepDefinitions;

import _05_POM._008_02_Navigation_Bar_Elements_Nil;
import _05_POM._008_03_Dialog_Content_Elements_Nil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;

import java.util.List;

public class _04_Discount_Steps_Nil {

    _008_02_Navigation_Bar_Elements_Nil nb = new _008_02_Navigation_Bar_Elements_Nil();
    _008_03_Dialog_Content_Elements_Nil dc = new _008_03_Dialog_Content_Elements_Nil();

    @Test(priority = 1)
    @Given("User add Discount {string} , {string} , {string}")
    public void userAddDiscount(String data1, String data2, String data3) {

        nb.sleep();
        nb.clickFunction(nb.getSetupOne());
        nb.clickFunction(nb.getParameters());
        nb.clickFunction(nb.getDiscounts());
        dc.clickFunction(dc.getAddButton());
        dc.sendKeysFunction(dc.getDescriptionInput(), data1);
        dc.sendKeysFunction(dc.getIntegrationCodeInput(), data2);
        dc.sendKeysFunction(dc.getPriorityInput(), data3);
        dc.clickFunction(dc.getActiveButton());
        dc.clickFunction(dc.getSaveButton());
    }

    @Test(priority = 2)
    @When("User add same Discount name")
    public void userAddSameDiscountName(DataTable dataTable) {

        nb.sleep();
        nb.clickFunction(nb.getSetupOne());
        nb.clickFunction(nb.getParameters());
        nb.clickFunction(nb.getDiscounts());
        dc.clickFunction(dc.getAddButton());
        List<List<String>> testdata = dataTable.asLists();
        for (List<String> data : testdata) {
            dc.sendKeysFunction(dc.getDescriptionInput(),data.get(0));
            dc.sendKeysFunction(dc.getIntegrationCodeInput(),data.get(1));
            dc.sendKeysFunction(dc.getPriorityInput(),data.get(2));
            dc.clickFunction(dc.getActiveButton());
            dc.clickFunction(dc.getSaveButton());
            dc.clearFunction(dc.getDescriptionInput());
            dc.clearFunction(dc.getIntegrationCodeInput());
            dc.clearFunction(dc.getPriorityInput());
        }
    }

    @Test(priority = 3)
    @And("User edit Discount Data  {string} , {string} and change it to {string} , {string}")
    public void userEditDiscountDataAndChangeItTo(String ExistingDescription, String ExistingIntegCode, String newDescription, String newIntegCode) {
        nb.sleep();
        nb.clickFunction(nb.getSetupOne());
        nb.clickFunction(nb.getParameters());
        nb.clickFunction(nb.getDiscounts());
        nb.waitUntilLoading();

        dc.clickFunction(dc.getSearchInput1());
        dc.sendKeysFunction(dc.getSearchInput1(),ExistingDescription);
        dc.clickFunction(dc.getSearchInput2());
        dc.sendKeysFunction(dc.getSearchInput2(),ExistingIntegCode);
        dc.clickFunction(dc.getSearchButton());
        dc.sleep();

        dc.clickFunction(dc.getEditButton());
        dc.clearFunction(dc.getDescriptionInput());
        dc.sendKeysFunction(dc.getDescriptionInput(), newDescription);
        dc.clearFunction(dc.getIntegrationCodeInput());
        dc.sendKeysFunction(dc.getIntegrationCodeInput(), newIntegCode);
        dc.clickFunction(dc.getActiveButton());
        dc.clickFunction(dc.getSaveButton());
    }

    @Test(priority = 4)
    @Given("User delete Discount {string}")
    public void userDeleteDiscount(String updatedDes) {
        nb.sleep();
        nb.clickFunction(nb.getSetupOne());
        nb.clickFunction(nb.getParameters());
        nb.clickFunction(nb.getDiscounts());
        nb.waitUntilLoading();
        dc.clickFunction(dc.getSearchInput1());
        dc.sendKeysFunction(dc.getSearchInput1(), updatedDes);
        dc.clickFunction(dc.getSearchButton());
        dc.waitUntilLoading();
        dc.clickFunction(dc.getDeleteButton());
        dc.clickFunction(dc.getDeleteSureButton());
    }

    @Test(priority = 5)
    @When("User search deleted {string} in search input data")
    public void userSearchDeletedInSearchInputData(String updatedDes) {
        nb.sleep();
        nb.clickFunction(nb.getSetupOne());
        nb.clickFunction(nb.getParameters());
        nb.clickFunction(nb.getDiscounts());
        dc.waitUntilLoading();
        dc.clickFunction(dc.getSearchInput1());
        dc.sendKeysFunction(dc.getSearchInput1(),updatedDes);
        dc.clickFunction(dc.getSearchButton());
        dc.waitUntilLoading();

    }

    @Then("Success message should displayed")
    public void successMessageShouldDisplayed() {
        dc.validationText(dc.getSuccessMessage(),"successfully"); }

    @Then("Exist message should displayed")
    public void existMessageShouldDisplayed() {
        dc.validationText(dc.getAlreadyExist(),"exist");
    }

    @Then("There is no data should displayed")
    public void thereIsNoDataShouldDisplayed() {
        dc.validationText(dc.getNoDataMessage(), "no");
    }
}
