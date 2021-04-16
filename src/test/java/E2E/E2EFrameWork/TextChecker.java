package E2E.E2EFrameWork;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.IntialPageFactor;
import Resources.Base;

public class TextChecker extends Base {

	public WebDriver driver;

	Logger logger = LogManager.getLogger(TextChecker.class);

	@BeforeTest
	public void initial() throws IOException {
		driver = browserIntializer();
		logger.info("Driver Intialized");

		driver.get(prop.getProperty("url"));
		logger.info("URL opened");
	}

	@Test
	public void Text() throws IOException {

		IntialPageFactor initial = new IntialPageFactor(driver);
		String textFound = initial.textCheck().getText();

		Assert.assertEquals(textFound, "Featured Courses");
		logger.info("Text verified");

	}

	@AfterTest
	public void browserClose() {
		driver.close();
	}

}
