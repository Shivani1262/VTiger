package commonUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	ExtentReports report ;
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+" Testscript execution is started",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log("Testscript execution is passed",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
//		String message = result.getThrowable().toString();
//		String methodName = result.getMethod().getMethodName();
//		Reporter.log("Testscript execution is failed" +message,true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
//		String methodName = result.getMethod().getMethodName();
//		Reporter.log("To skip the testscript",true);
	}

//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		Reporter.log("",true);
//	}
//
//	@Override
//	public void onTestFailedWithTimeout(ITestResult result) {
//		Reporter.log("",true);
//	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("To start execution",true);
		//use ExtentSparkReporter class just to configure extentreport
		JavaUtils jutil = new JavaUtils();
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extentreport/report"+jutil.getRandomNumber()+".html");
		reporter.config().setDocumentTitle("vtigercrm");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Pune");
		
		//use ExtentReports to generate extentReport
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("OS", "Window");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("ChromeVersion", "122");
		report.setSystemInfo("Author", "Shivani");
	}

	@Override
	public void onFinish(ITestContext context) {
//		Reporter.log("To Finish execution",true);
		report.flush();
	}
		
}
