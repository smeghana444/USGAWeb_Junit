package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
            features = "src/test/resources/Feature/steps.feature",
            		plugin = {"pretty",
            				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
            glue = {"stepdefinations","AppHooks"},
           tags="@NavigateLatestSection"

    )

public class Runner 
{

}
