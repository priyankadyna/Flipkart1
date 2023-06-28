package in.co.irctc;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\dynam\\eclipse-workspace\\Cucumber\\src\\test\\resources\\Flipkart1.feature", 
                 glue="in.co.irctc", 
                 dryRun=false,
                 monochrome = true,
                 plugin = "html:target/index.html")
public class TestRunner {

}
