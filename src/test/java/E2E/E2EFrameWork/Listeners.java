package E2E.E2EFrameWork;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.Base;
import Resources.ExtentReport;

public class Listeners extends Base implements ITestListener {
	ExtentTest test;

	ThreadLocal<ExtentTest> extentThread = new ThreadLocal<ExtentTest>();

	ExtentReports report = ExtentReport.extentReportSetting();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = report.createTest(result.getMethod().getMethodName());
		extentThread.set(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentThread.get().log(Status.PASS, "Test Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		String methodName = result.getMethod().getMethodName();
		try {
			extentThread.get().fail(result.getThrowable());
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			extentThread.get().addScreenCaptureFromPath(getScreenShot(methodName, driver), methodName);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
	}

}
