package testRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/java/feature",
		glue= {"stepdefination"},
		strict = true
		)
public class testRunner {

}
