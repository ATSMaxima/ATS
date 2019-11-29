package TEST;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic.CommonActions;
import Generic.ExcelReader;
import POM.ATS_Login;

public class TestLogin extends BaseTest{
	
	@Test(priority = 0, alwaysRun = true)
	public void login()
	{
		l = extent.createTest("login");
		ATS_Login al = new ATS_Login(driver);
		al.loginATS(UN, PW);
		al.logoutlist();
		al.logoutClick();
	}
	
	@Test(dataProvider="Authentication", priority = 1)
	public void DD_Login_data(String sUserName,String sPassword)
	{
		String str = "";
		
		try {
			
			l = extent.createTest("DD_Login_data");
			ATS_Login rv = new ATS_Login(driver);
			System.out.println(" User Name is " +sUserName);
			System.out.println(" Password is " +sPassword);
			rv.loginATS(sUserName, sUserName);
			CommonActions.waitTime(2000);
			str = driver.getTitle();
			System.out.println("Title of page is : " +str);
//		if(str.contains("Applicant Tracking System"))
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		{
//			rv.logoutlist();
//			rv.logoutClick();
//		}
		for (int i = 1; i < 5; i++) 
		{	
			if(str.contains("Login"))
			{
				ExcelReader.setExcelData("Sheet1", i, 2, "fail", DD_LOGIN_EXCEL);
			}
			else if (str.contains("Applicant Tracking System"))
			{	
				ExcelReader.setExcelData("Sheet1", i, 2, "pass", DD_LOGIN_EXCEL);						
			}
		}
	}
	
	@DataProvider
	public Object[][] Authentication() throws Exception
	{
		Object[][] testObjArray = ExcelReader.getTableArray(DD_LOGIN_EXCEL,SHEET_NAME);
		return testObjArray;
	}
	

}
