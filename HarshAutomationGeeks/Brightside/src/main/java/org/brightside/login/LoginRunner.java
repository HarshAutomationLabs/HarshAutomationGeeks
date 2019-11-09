package org.brightside.login;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "C:\\Users\\HARSH\\workspace\\BrightsideCommunities\\src\\main\\resources\\org\\brightside\\login\\Login.feature", 
	glue = { "org/brightside/login" }, // the path of the step definition files
	monochrome = true,
	strict = false, 
	dryRun = false
)

public class LoginRunner {

}
