package _07_Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(

    features = {"src/test/java/_01_FeatureFiles/"},
    glue = {"_06_StepDefinitions"},
    plugin= {"html:target/site/cucumber-reports.html"}
)

public class _01_TestRunnerAll extends AbstractTestNGCucumberTests {



}
