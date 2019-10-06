package org.brightside.login;

import org.brightside.core.TestValidator;
import org.brightside.core.WebConnector;
import org.openqa.selenium.By;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginStepDefination extends WebConnector {

	WebConnector selenium = new WebConnector();

	@Given("^user opens the \"([^\"]*)\" in the \"([^\"]*)\"$")
	public void user_opens_the_browser(String URL, String browser) throws Throwable {
		selenium.openBrowser(browser);
		TestValidator.WaitUntilInvisiblityOfElement(PRELOADER);
		selenium.navigate(URL);
	}

	@When("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {
		Assert.assertTrue(driver.getTitle().equals("loginTitle"));
		Assert.assertTrue(driver.findElement(By.xpath(OR.getProperty("brightsideLogo"))).isDisplayed());
	}

	@Then("^user types \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_types_username(String locator, String email) throws Throwable {
		selenium.type(locator, email);
		Thread.sleep(2000);
	}

	@Then("^user types \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_types_password(String locator, String password) throws Throwable {
		selenium.type(locator, password);
		Thread.sleep(2000);
	}

	@Then("^user clicks \"([^\"]*)\"$")
	public void user_clicks_signin_button(String locator) throws Throwable {
		selenium.click(locator);
	}

	@Then("^user validate \"([^\"]*)\" in the homepage$")
	public void user_validate_homepage(String locator) {
		try {
			Assert.assertTrue(driver.findElement(By.xpath(OR.getProperty(locator))).isDisplayed());
			System.out.println("Scenario: Testing the login functionality is : Passed");
		} catch (Exception e) {
			System.out.println("Scenario: Testing the login functionality is : Failed");
			e.printStackTrace();
		}
	}
}