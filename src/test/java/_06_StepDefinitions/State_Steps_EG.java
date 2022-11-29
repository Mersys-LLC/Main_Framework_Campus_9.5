package _06_StepDefinitions;

import _05_POM._02_Navigation_Bar_Elements_EG;
import _05_POM._03_Dialog_Content_Elements_EG;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;

import java.util.List;


public class State_Steps_EG {
    _02_Navigation_Bar_Elements_EG nb = new _02_Navigation_Bar_Elements_EG();
    _03_Dialog_Content_Elements_EG dc = new _03_Dialog_Content_Elements_EG();

    private org.openqa.selenium.WebElement WebElement;



    @Test(priority =1, enabled = true)
    @Given("User add state {string}")
    public void userAddState(String name) {
        nb.sleep();
        nb.clickFunction(nb.getSetupOne());
        nb.clickFunction(nb.getParameters());

        nb.clickFunction(nb.getStates());

        dc.getAddButton().click();
        dc.clickFunction(dc.getClickCountry());
        dc.clickFunction(dc.getClickEuropeTest1111());
        dc.sendKeysFunction(dc.getNameInput(), name);
        dc.getSaveButton().click();

    }
    @Test(priority =2,enabled=true)
    @When("User add same state name")
    public void userAddSameStateName(DataTable dataTable) {

        nb.sleep();
        nb.clickFunction(nb.getSetupOne());
        nb.clickFunction(nb.getParameters());
        nb.clickFunction(nb.getStates());
        dc.clickFunction(dc.getAddButton());
        List<List<String>> testData = dataTable.asLists();

        for (List<String> data : testData) {
            dc.clickFunction(dc.getClickCountry());
            dc.clickFunction(dc.getClickEuropeTest1111());
            dc.sendKeysFunction(dc.getNameInput(),data.get(0));
            dc.clickFunction(dc.getSaveButton());

        }
    }
    @Test(priority =3,enabled=true)
    @Given("User edit State {string} {string}")
    public void userEditState(String name, String updatedName) {

        nb.sleep();
        nb.clickFunction(nb.getSetupOne());
        nb.clickFunction(nb.getParameters());
        nb.clickFunction(nb.getStates());
        nb.waitUntilLoading();
        nb.waitUntilVisibleAllElement();
        dc.sendKeysFunction(dc.getSearchNameInput(),name);
        dc.clickFunction(dc.getSearchButton());
        dc.waitUntilVisibleAllElement();
        dc.clickFunction(dc.getEditButton());
        dc.waitUntilVisibleAllElement();
        dc.clearFunction(dc.getNameInput());
        dc.sleep();
        dc.waitUntilVisibleAllElement();
        dc.sendKeysFunction(dc.getNameInput(),updatedName);
        dc.waitUntilVisibleAllElement();
        dc.sleep();
        dc.clickFunction(dc.getSaveButton());



    }
    @Test(priority = 4)
    @Given("User delete state {string}")
    public void userDeleteState(String name) {

        nb.clickFunction(nb.getSetupOne());
        nb.clickFunction(nb.getParameters());
        nb.clickFunction(nb.getStates());
        dc.sleep();
        //dc.clickFunction(dc.getClickCountry());
        //dc.clickFunction(dc.getClickEuropeTest1111());
        dc.sendKeysFunction(dc.getSearchNameInput(), name);
        dc.clickFunction(dc.getSearchButton());
        dc.waitUntilVisibleAllElement();
        dc.clickFunction(dc.getDeleteButton());
        dc.clickFunction(dc.getDeleteDialogBtn());
    }


    @Test(priority = 5)
    @When("User search  {string} in  input")
    public void userSearchInInput(String name) {
        {
            nb.clickFunction(nb.getSetupOne());
            nb.clickFunction(nb.getParameters());
            nb.clickFunction(nb.getStates());
            dc.waitUntilLoading();
           dc.sendKeysFunction(dc.getSearchNameInput(), name);
            dc.clickFunction(dc.getSearchButton());
            dc.sleep();
        }
    }

    @Then("User should see a success message")
    public void userShouldSeeASuccessMessage() {
        dc.validationText(dc.getSuccessMessage(), "successfully");
    }

    @Then("User should see an exist message")
    public void userShouldSeeAnExistMessage() {
        dc.validationText(dc.getAlreadyExist(), "exist");
    }

    @Then("User should see there is no data to be displayed message")
    public void userShouldSeeThereIsNoDataToBeDisplayedMessage() {
        dc.validationText(dc.getNoDataMessage(), "no");
    }




}

