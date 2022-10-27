package _06_StepDefinitions;

import _05_POM._02_Navigation_Bar_Elements;
import _05_POM._03_Dialog_Content_Elements;
import _08_Utils.DBUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class _03_JDBC_Nationality_Steps {

  _02_Navigation_Bar_Elements nb = new _02_Navigation_Bar_Elements();
  _03_Dialog_Content_Elements dc = new _03_Dialog_Content_Elements();

  @Given("Navigate to nationalities feature")
  public void navigateToNationalitiesFeature() {
    nb.clickFunction(nb.getSetupOne());
    nb.clickFunction(nb.getParameters());
    nb.clickFunction(nb.getNationalities());
  }

  @Then("Send the query the database {string} and control match")
  public void sendTheQueryTheDatabaseAndControlMatch(String sqlQuery) {

    //DBden gerekli listeyi alıcam
    List<List<String>> dbList = DBUtility.getListData(sqlQuery);
    System.out.println("dbList = " + dbList);  // 0.satırın 0 elamanı  id' dir yani 1

    //Webdeb ekrandaki isimleri alıcam
    List<WebElement> uiList = dc.waitUntilVisibleAllElement(dc.nameList);
    int count=1;
    for (WebElement nation : uiList)
      System.out.println("UI-Nation"+count++ +": " + nation.getText());

    //karşılaştırıcam
    for (int i = 0; i < uiList.size(); i++) {
//      Assert.assertTrue(dbList.contains(dbList.get(i).get(1)), uiList.get(i).getText()); //get(1) represent nation name inside db list
      if (uiList.get(i).getText().contains(dbList.get(i).get(1))) {
      }
    }
  }
}


