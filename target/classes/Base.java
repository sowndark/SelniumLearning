package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver browserIntializer() throws IOException {
		prop = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\Sowndar K\\eclipse-workspace\\E2EFrameWork\\src\\main\\java\\Resources\\base.properties");

		prop.load(file);

		// String browserToIntialize = System.getProperty("browser");

		String browserToIntialize = prop.getProperty("browser");

		// System.out.println("given by" + browserToIntialize);

		if ((browserToIntialize.contains("chrome"))) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Sowndar K\\BPMLinks Files\\Sowndar Needs\\Apps\\chrome path\\chromedriver.exe");

			driver = new ChromeDriver();
			// ChromeOptions opt = new ChromeOptions();
			/*
			 * if (browserToIntialize.contains("headless")) { opt.addArguments("headless");
			 * } driver = new ChromeDriver(opt);
			 */

		} else if ((browserToIntialize.equalsIgnoreCase("fireFox"))) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Sowndar K\\BPMLinks Files\\Sowndar Needs\\Apps\\Firefox Path\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if ((browserToIntialize.equalsIgnoreCase("internetExplorer"))) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\Sowndar K\\BPMLinks Files\\Sowndar Needs\\Apps\\InternetExplorer Path\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public String getScreenShot(String failedMethodName, WebDriver driver) throws IOException {
		TakesScreenshot sc = (TakesScreenshot) driver;
		File source = sc.getScreenshotAs(OutputType.FILE);
		String Destination = System.getProperty("user.dir") + "\\reports\\" + failedMethodName + ".png";
		FileUtils.copyFile(source, new File(Destination));
		return Destination;
	}
}
