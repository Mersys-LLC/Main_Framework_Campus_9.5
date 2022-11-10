package _07_Runners;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

  @CucumberOptions(
      tags = "@SmokeTest",
      features = {"src/test/java/_01_FeatureFiles/"},
      glue = {"_06_StepDefinitions"},
      plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"}
  )

  public class _02_TestRunnerSmoke_MasterReport extends AbstractTestNGCucumberTests {

}
