package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import util.ScreenRecorderUtil;

@RunWith(Cucumber.class)
@CucumberOptions(
            features = "src/test/resources/Feature/steps.feature",
            		plugin = {"pretty","json:target/cucumber-reports/cucumber.json",
            				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
            glue = {"stepdefinations","AppHooks"},
           tags="@NavigateLatestSection"

    )

public class Runner 
{

}
