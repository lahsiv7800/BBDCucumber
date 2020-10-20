package cucumberOption;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features/Login.feature",
		glue = "src/test/java/stepDefination"
         )		
		
		         

public class TestRunner {

}
