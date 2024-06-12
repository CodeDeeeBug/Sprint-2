package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.*;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Features\\SpringBoot.feature", glue="StepDefinition", dryRun=true)
public class SpringBootRunner extends AbstractTestNGCucumberTests{

}
