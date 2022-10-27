package _06_StepDefinitions;

import _05_POM._02_Navigation_Bar_Elements;
import _05_POM._03_Dialog_Content_Elements;
import _08_Utils.ExcelUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;

public class _02_ApachePOI_Nationality_Steps {


  _02_Navigation_Bar_Elements nb = new _02_Navigation_Bar_Elements();
  _03_Dialog_Content_Elements dc = new _03_Dialog_Content_Elements();

  @Given("User create new nationality with ApachePOI")
  public void userCreateNewNationalityWithApachePOI() {

    // excelden oku ve citizenship i create et
    ArrayList<ArrayList<String>> data =
        ExcelUtility.getListData("src/test/java/_02_ApachePOI/Resources/ApacheExcel22.xlsx",
            "Nation", 1);
    nb.clickFunction(nb.getSetupOne());
    nb.clickFunction(nb.getParameters());
    nb.clickFunction(nb.getNationalities());

    for (ArrayList<String> row : data) {
      dc.clickFunction(dc.getAddButton());
      dc.sendKeysFunction(dc.getNameInput(), row.get(0));
      dc.clickFunction(dc.getSaveButton());
      dc.validationText(dc.getSuccessMessage(), "successfully");
      dc.sleep();
    }
  }

  @When("User edit nationality with ApachePOI")
  public void userEditNationalityWithApachePOI() {
    // excelden oku ve citizenship i create et
    ArrayList<ArrayList<String>> data =
        ExcelUtility.getListData("src/test/java/_02_ApachePOI/Resources/ApacheExcel22.xlsx",
            "Nation", 2);

    nb.clickFunction(nb.getSetupOne());
    nb.clickFunction(nb.getParameters());
    nb.clickFunction(nb.getNationalities());
    dc.waitUntilLoading();

    for (ArrayList<String> row : data) {
      dc.clearFunction(dc.getSearchInput());
      dc.sendKeysFunction(dc.getSearchInput(), row.get(0));
      dc.clickFunction(dc.getSearchButton());
      dc.sleep();

      dc.clickFunction(dc.getEditButton());
      dc.clearFunction(dc.getSearchInput2());

      dc.sendKeysFunction(dc.getSearchInput2(), row.get(1));
      dc.clickFunction(dc.getSaveButton());
      dc.validationText(dc.getSuccessMessage(), "successfully");
      dc.sleep();
    }

  }

  @Then("User delete nationality with ApachePOI")
  public void userDeleteNationalityWithApachePOI() {
// kaydettikkerini yine excelden okuyarak sil
    ArrayList<ArrayList<String>> data =
        ExcelUtility.getListData("src/test/java/_02_ApachePOI/Resources/ApacheExcel22.xlsx",
            "Nation", 2);

    nb.clickFunction(nb.getSetupOne());
    nb.clickFunction(nb.getParameters());
    nb.clickFunction(nb.getNationalities());
    for (ArrayList<String> row : data) {
      System.out.println("row = " + row);
      System.out.println("row.get(0) = " + row.get(1));

      dc.waitUntilLoading();
      dc.clearFunction(dc.getSearchInput());
      dc.sendKeysFunction(dc.getSearchInput(), row.get(1));
      dc.clickFunction(dc.getSearchButton());
      dc.waitUntilLoading();
      dc.clickFunction(dc.getDeleteButton());
      dc.clickFunction(dc.getDeleteDialogBtn());
      dc.validationText(dc.getSuccessMessage(), "successfully");
      dc.sleep();
    }
  }

}

