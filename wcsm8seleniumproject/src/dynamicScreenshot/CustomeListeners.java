package dynamicScreenshot;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomeListeners extends BaseTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("Test case is start",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test case is Executed Successfully",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String failedMethod = result.getMethod().getMethodName();
		Reporter.log("Test case Failed due to: "+failedMethod,true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test case is Skipped",true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Reporter.log("Test case is Executed Successfully",true);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		Reporter.log("Test case is failed due to timeout",true);
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("Test case is Executed Successfully",true);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("Test case is finished",true);

}
}
