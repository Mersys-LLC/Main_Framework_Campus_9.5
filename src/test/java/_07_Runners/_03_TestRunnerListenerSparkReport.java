package _07_Runners;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;


@CucumberOptions(
    tags = "@SmokeTest2",
    features = {"src/test/java/_01_FeatureFiles/"},
    glue = {"_06_StepDefinitions"}
)
@Listeners({ExtentITestListenerClassAdapter.class}) //just listen and report logs

public class _03_TestRunnerListenerSparkReport extends AbstractTestNGCucumberTests {

}
