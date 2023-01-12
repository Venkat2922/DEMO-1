package GenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation  implements ITestListener {

	ExtentTest test;
	ExtentReports reports;
	
	public void onTestStart(ITestResult result) {
		
		test=reports.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,result.getMethod().getMethodName()+"got passed");
	}

	public void onTestFailure(ITestResult result) {
		String path=null;
		path=BaseClass.takeScreenShot(result.getMethod().getMethodName());
	//	BaseClass.takeScreenShot(result.getMethod().getMethodName()+"got failed");
		test.log(Status.FAIL,result.getMethod().getMethodName()+"got failed");
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+"got skipperd");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("./ExtentreportZoo/zoo1.html");
		extentSparkReporter.config().setDocumentTitle("Zoo Management system");
		extentSparkReporter.config().setTheme(Theme.STANDARD);
		reports=new ExtentReports();
		reports.attachReporter(extentSparkReporter);
		reports.setSystemInfo("browser", "chrme");
		reports.setSystemInfo("Build", "build-11");
		reports.setSystemInfo("environment", "Automation");
		reports.setSystemInfo("ReporterName", "venkat");
	}

	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
