package _06_StepDefinitions;

import _05_POM._02_Navigation_Bar_Elements;
import _05_POM._03_Dialog_Content_Elements;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import org.testng.annotations.Test;

public class _01_Nationality_Steps {

  _02_Navigation_Bar_Elements nb =new _02_Navigation_Bar_Elements();
  _03_Dialog_Content_Elements dc= new _03_Dialog_Content_Elements();

  @Test(priority =1, enabled = true)
  @Given("User add nation {string}")
  public void userAddNation(String name){
    nb.sleep();
//    nb.setupOne.click();
    nb.clickFunction(nb.getSetupOne());
    nb.clickFunction(nb.getParameters());
    nb.clickFunction(nb.getNationalities());
    dc.clickFunction(dc.getAddButton());
    dc.sendKeysFunction(dc.getNameInput(), name);
    dc.clickFunction(dc.getSaveButton());
  }

  @Test(priority =2,enabled=true)
  @When("User add same nation name")
  public void userAddSameNationName(DataTable dataTable) {
    nb.sleep();
    nb.clickFunction(nb.getSetupOne());
    nb.clickFunction(nb.getParameters());
    nb.clickFunction(nb.getNationalities());
    dc.clickFunction(dc.getAddButton());
    List<List<String>> testData = dataTable.asLists();
    for (List<String> data : testData) {
      dc.sendKeysFunction(dc.getNameInput(), data.get(0));
      dc.clickFunction(dc.getSaveButton());
      dc.clearFunction(dc.getNameInput());
    }
  }

  @Test(priority =3,enabled=true)
  @Given("User edit Nation Name")
  public void userEditNationName(DataTable dataTable) {
    nb.clickFunction(nb.getSetupOne());
    nb.clickFunction(nb.getParameters());
    nb.clickFunction(nb.getNationalities());
    nb.waitUntilLoading();

    List<List<String>> testData = dataTable.asLists();

    nb.clearFunction(dc.getSearchInput());
    dc.sendKeysFunction(dc.getSearchInput(), testData.get(0).get(0));
    dc.clickFunction(dc.getSearchButton());
    dc.sleep();
    dc.clickFunction(dc.getEditButton());
    dc.clearFunction(dc.getSearchInput2());
    dc.sendKeysFunction(dc.getSearchInput2(), "UKY1");
    dc.clickFunction(dc.getSaveButton());

    dc.clearFunction(dc.getSearchInput());
    dc.sendKeysFunction(dc.getSearchInput(), testData.get(0).get(1));
    dc.clickFunction(dc.getSearchButton());
    dc.sleep();
    dc.clickFunction(dc.getEditButton());
    dc.clearFunction(dc.getSearchInput2());
    dc.sendKeysFunction(dc.getSearchInput2(), "RUY2");
    dc.clickFunction(dc.getSaveButton());
  }

  @Test(priority = 4)
  @Given("User delete nation {string}")
  public void userDeleteNation(String name) {

    nb.clickFunction(nb.getSetupOne());
    nb.clickFunction(nb.getParameters());
    nb.clickFunction(nb.getNationalities());
    dc.waitUntilLoading();
    dc.clearFunction(dc.getSearchInput());
    dc.sendKeysFunction(dc.getSearchInput(),name);
    dc.clickFunction(dc.getSearchButton());
    dc.waitUntilLoading();
    dc.clickFunction(dc.getDeleteButton());
    dc.clickFunction(dc.getDeleteDialogBtn());

  }

  @Test(priority = 5)
  @When("User search deleted {string} in search input")
  public void userSearchDeletedInSearchInput(String name) {
    nb.clickFunction(nb.getSetupOne());
    nb.clickFunction(nb.getParameters());
    nb.clickFunction(nb.getNationalities());
    dc.waitUntilLoading();
    dc.sendKeysFunction(dc.getSearchInput(), name);
    dc.clickFunction(dc.getSearchButton());
  }

  @Then("Success message should be displayed")
  public void successMessageShouldBeDisplayed() {
    dc.validationText(dc.getSuccessMessage(), "successfully");
  }

  @Then("Exist message should be displayed")
  public void existMessageShouldBeDisplayed() {
    dc.validationText(dc.getAlreadyExist(), "exist");
  }

  @Then("There is no data should be displayed")
  public void thereIsNoDataShouldBeDisplayed() {
    dc.validationText(dc.getNoDataMessage(), "no");
  }

}



