package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class validateLogedInPageFactor {

	WebDriver driver;

	public validateLogedInPageFactor(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "search-courses")
	WebElement searchBox;

	public WebElement serchboxFound() {
		return searchBox;
	}

}
