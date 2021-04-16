package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IntialPageFactor {

	WebDriver driver;

	public IntialPageFactor(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href=\"https://courses.rahulshettyacademy.com/sign_in\"]")
	WebElement loginclick;

	public WebElement loginClick() {
		return loginclick;

	}

	@FindBy(xpath = "//h2[text()='Featured Courses']")
	WebElement textCheck;

	public WebElement textCheck() {
		return textCheck;

	}

}
