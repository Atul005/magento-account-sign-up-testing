package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions","base"},
        plugin = {"pretty", "html:magento-test-reports/magento-test.html","json:magento-test-reports/magento-test.json"}
)
public class TestRunner {
}
