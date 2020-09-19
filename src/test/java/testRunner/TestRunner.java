package testRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags="@Testing",monochrome = true,features="src/test/resources/featureFiles", glue= {"stepClasses"})
public class TestRunner extends AbstractTestNGCucumberTests{
	
}
