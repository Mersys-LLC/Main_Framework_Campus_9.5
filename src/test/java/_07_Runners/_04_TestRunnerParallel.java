package _07_Runners;

import _08_Utils.Driver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


@CucumberOptions(
    tags = "@SmokeTest",
    features = {"src/test/java/_01_FeatureFiles/"},
    glue = {"_06_StepDefinitions"},
    plugin= {"html:target/site/cucumber-smoke-reports.html"}

)

public class _04_TestRunnerParallel extends AbstractTestNGCucumberTests {

  @BeforeClass(alwaysRun = true) // this is for BROWSER failed
  @Parameters("browser")
  public void beforeClass(String browser)
  {
    Driver.threadBrowserName.set(browser); // browser will be set for this thread
  }

    @AfterClass(alwaysRun = true) // alternative closing the browser
    public void afterClass() {
        Driver.quitDriver();
    }

}
