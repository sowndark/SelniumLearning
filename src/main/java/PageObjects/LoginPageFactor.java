package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactor {

	WebDriver driver;

	public LoginPageFactor(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "user_email")
	private WebElement email;
	@FindBy(id = "user_password")
	private WebElement password;
	@FindBy(name = "commit")
	private WebElement submit;

	public WebElement email() {
		return email;

	}

	public WebElement password() {
		return password;

	}

	public WebElement submit() {
		return submit;

	}

}
