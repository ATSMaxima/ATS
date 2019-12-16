package TEST;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic.CommonActions;
import Generic.ExcelReader;
import POM.ATS_Login;
import POM.ATS_Registration;

public class Test_DataProviderATSRegistration extends BaseTest{
	String str = null ;
	int count = 1 ;
	@Test(dataProvider="Authentication")
	public void DD_Registration_data(String user, String name, String lastname, String emailID, String emailconfirm, String pwd)
	{
		l = extent.createTest("DD_Registration_data");
		ATS_Login al = new ATS_Login(driver);
		al.newUserClick();
		ATS_Registration ar = new ATS_Registration(driver);
		ar.userName(user);
		ar.firstName(name);
		ar.lastName(lastname);
		ar.email(emailID);
		ar.confirmEmail(emailconfirm);
		ar.password(pwd);
		ar.submitBtn();
		String str= driver.getTitle();
		CommonActions.waitTime(2000);
		System.out.println("Title of page is : " +str);
		if(str.contains("Applicant Tracking System"))
		{
			ar.logoutlist();
			ar.logoutClick();
		}
		CommonActions.softAssert();
	}
	
	@DataProvider
	public Object[][] Authentication() throws Exception
	{
		Object[][] testObjArray = ExcelReader.getTableArray(DD_Registration_EXCEL,SHEET_NAME);
		return testObjArray;
	}
	@AfterMethod
	public void aftertestmethod (){
		if (str.equalsIgnoreCase("Applicant Tracking System")) {
			ExcelReader.setExcelData("Sheet1", count, 2, "pass", DD_Registration_EXCEL);
			System.out.println("Test Case is Passed "+count+"----");
		
			
		} else  {
			
			ExcelReader.setExcelData("Sheet1", count, 2, "fail", DD_Registration_EXCEL);
			System.out.println("Test Case is Failed " +count+ "-----");			
			
		}
		count++ ;		
		
	}

}
