package StepDefinition;

import PageObjects.IntialPageFactor;
import PageObjects.LoginPageFactor;
import Resources.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest extends Base {
	@Given("^intialize the chrome browser$")
	public void intialize_the_chrome_browser() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver = browserIntializer();

	}

	@Given("^landed to the \"([^\"]*)\" page$")
	public void landed_to_the_page(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get(arg1);

	}

	@Given("^click on the login button$")
	public void click_on_the_login_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		IntialPageFactor initial = new IntialPageFactor(driver);
		initial.loginClick().click();

	}

	@When("^user login by entering mail (.+) and the password (.+)$")
	public void user_login_by_entering_mail_and_the_password(String username, String password) throws Throwable {
		LoginPageFactor login = new LoginPageFactor(driver);
		login.email().sendKeys(username);
		login.password().sendKeys(password);
		login.submit().click();
	}

	@Then("^the user sucessfully logged \"([^\"]*)\"$")
	public void user_sucessfully_logged(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
//		validateLogedInPageFactor validate = new validateLogedInPageFactor(driver);
//		Assert.assertTrue(validate.serchboxFound().isDisplayed());

		System.out.println("We haven't used this method");

	}

	@And("^quit the browser$")
	public void quit_the_browser() throws Throwable {
		driver.quit();
	}

}
