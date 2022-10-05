package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "basicRESTAssured",
        dryRun = false,
        monochrome = true,
        tags = "@api",
        plugin = {"pretty"}
)
public class APIRunner {
}
