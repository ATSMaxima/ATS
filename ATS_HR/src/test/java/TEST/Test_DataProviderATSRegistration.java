package TEST;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic.CommonActions;
import Generic.ExcelReader;
import POM.ATS_Login;
import POM.ATS_Registration;

public class Test_DataProviderATSRegistration extends BaseTest{
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
		for (int i = 1; i < 5; i++) 
		{	
			if(str.contains("Register"))
			{
				ExcelReader.setExcelData("Sheet1", i, 6, "fail", DD_Registration_EXCEL);
			}
			else if (str.contains("Applicant Tracking System"))
			{	
				ExcelReader.setExcelData("Sheet1", i, 6, "pass", DD_Registration_EXCEL);						
			}
		}
	}
	
	@DataProvider
	public Object[][] Authentication() throws Exception
	{
		Object[][] testObjArray = ExcelReader.getTableArray(DD_Registration_EXCEL,SHEET_NAME);
		return testObjArray;
	}

}
