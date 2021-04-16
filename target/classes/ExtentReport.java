package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	static ExtentReports report;

	static public ExtentReports extentReportSetting() {

		String path = System.getProperty(("user.dir")) + "\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Extended Report");
		reporter.config().setReportName("Automatted extended Report");
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Sowndar");

		return report;
	}

}
