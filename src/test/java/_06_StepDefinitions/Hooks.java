package _06_StepDefinitions;

import _05_POM.Login_Page_Elements;
import _05_POM._02_Navigation_Bar_Elements;
import _08_Utils.Driver;
import _08_Utils.ExcelUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

  WebDriver driver = Driver.getDriver();
  Login_Page_Elements lp = new Login_Page_Elements();

  @Before
  public void setup() {

    driver.get("https://demo.mersys.io/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    lp.loginFunctionCredential();
  }

  @After
  public void tearDown(Scenario scenario) {

    System.out.println("Scenario result=" + scenario.getStatus());

    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formatLocalDateTime = dateTime.format(formatter);

    ExcelUtility.writeExcel("src/test/java/_02_ApachePOI/Resources/ScenarioStatus.xlsx",
        scenario, Driver.threadBrowserName.get(), formatLocalDateTime);

    if (scenario.isFailed()) {
      TakesScreenshot screenshot = ((TakesScreenshot) driver); // which driver to get a screenshot
      File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
      //Extend Reporta ekleniyor  EXTEND report olmadığında burası kaldırılmalı !!! yoksa browserlar KAPANMAZ
//      ExtentTestManager.getTest().addScreenCaptureFromBase64String(getBase64Screenshot());
      String scenarioName = scenario.getName();
      File destinationFile = new File("target/FailedScreenshots/" + scenarioName + ".png");
      try {
        FileUtils.copyFile(srcFile, destinationFile);
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    Driver.quitDriver();
  }

  public String getBase64Screenshot() {
    return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BASE64);
  }
}


