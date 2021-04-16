package E2E.E2EFrameWork;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.IntialPageFactor;
import PageObjects.LoginPageFactor;
import Resources.Base;

public class Login extends Base {
	Logger logger = LogManager.getLogger(Login.class);

	@BeforeTest
	public void initial() throws IOException {
		driver = browserIntializer();
		logger.info("Driver Intialized");

	}

	@Test(dataProvider = "datas")
	public void LoginPage(String email, String password) throws IOException {
		driver.get(prop.getProperty("url"));
		logger.info("URL opened");

		IntialPageFactor initial = new IntialPageFactor(driver);
		initial.loginClick().click();
		LoginPageFactor login = new LoginPageFactor(driver);
		login.email().sendKeys(email);
		login.password().sendKeys(password);
		login.submit().click();
		logger.info("logined Sucessfully");

	}

	@DataProvider
	public Object[][] datas() {
		Object[][] obj = new Object[2][2];
		obj[0][0] = "1st email";
		obj[0][1] = "1st passWord";

		obj[1][0] = "2nd email";
		obj[1][1] = "2nd passWord";

		return obj;
	}

	@AfterTest
	public void browserClose() {
		driver.close();
	}
}
