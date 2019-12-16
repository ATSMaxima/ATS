package Generic;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import TEST.BaseTest;

public class Listener extends BaseTest implements ITestListener{
	
//every time it will execute after Test Execution
	
	public void onFinish(ITestContext context) 
	{
		String str = context.getName();
		Reporter.log("Test Execution Finished : "+ str,true);
		//extent.flush();
	}

//every time it will execute on start of Test Execution
	
	public void onStart(ITestContext context) 
	{
		String str = context.getName();
		Reporter.log("Test Execution Start : "+ str,true);
		//logger = extent.createTest(str);
	}

// every time it will execute if our test method is almost within pass ratio but failed
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		String str = result.getName();
		Reporter.log("Test Method Almost Passed :"+ str,true);				
	}

//it will execute on test method failure, take screen shot and attach screen shot in Extent Report 	
	public void onTestFailure(ITestResult result)
	{
		String str = result.getName();
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			String temp = ScreenShotReader.getScreenShot(driver, str);
			// MarkupHelper is used to display the output in different colors
			l.log(Status.FAIL,MarkupHelper.createLabel("Test Case Failed is :"+str, ExtentColor.RED));
			l.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			try {
				l.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
				//l.addScreenCaptureFromPath(temp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Reporter.log("Test Method Failed : "+ str,true);
	}

//every time it will execute if any of the test method is skipped
	public void onTestSkipped(ITestResult result) 
	{
		String str = result.getName();
		if (result.getStatus() == ITestResult.SKIP) 
		{
			// logger.log(Status.SKIP, "Test Case Skipped is :"+result.getName());
			l.log(Status.SKIP, MarkupHelper.createLabel("Test Case Skipped is :"+str, ExtentColor.ORANGE));
			l.log(Status.SKIP,MarkupHelper.createLabel(result.getThrowable() + " - Test Case Skipped", ExtentColor.ORANGE));
		}
		Reporter.log("Test Method Skipped :"+ str,true);
	}
	
//every time it will execute once the test method starts 
	public void onTestStart(ITestResult result)
	{
		String str = result.getName();
		Reporter.log("Test Method Start :"+ str,true);
	}

//every time it execute if the test method is pass 
	public void onTestSuccess(ITestResult result) 
	{
		String str = result.getName();
		Reporter.log("Test Method Success :"+ str,true);
		l.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is :"+str, ExtentColor.GREEN));
	}


}
