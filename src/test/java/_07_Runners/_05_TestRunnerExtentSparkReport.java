package _07_Runners;

import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;

@CucumberOptions(
    tags = "@SmokeTest",
    features = {"src/test/java/_01_FeatureFiles/"},
    glue = {"_06_StepDefinitions"}
)
@Listeners({ExtentITestListenerClassAdapter.class})

public class _05_TestRunnerExtentSparkReport extends AbstractTestNGCucumberTests {

  @AfterClass
  public static void writeExtentReport() {
    ExtentService.getInstance().setSystemInfo("User Name", "YYOLDAS");
    ExtentService.getInstance().setSystemInfo("Application Name", "Campus");
    ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name").toString());
    ExtentService.getInstance().setSystemInfo("Department", "QA");
    ExtentService.getInstance().setSystemInfo("Extra Info", "Info");
}
}
