package TEST;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic.CommonActions;
import Generic.ExcelReader;
import POM.ATS_Login;

public class TestDataProviderATSLogin extends BaseTest {
	@Test(dataProvider = "Authentication")
	public void DD_Login_data(String sUserName, String sPassword) throws Exception {
		l = extent.createTest("DD_Login_data");
		ATS_Login rv = new ATS_Login(driver);
		System.out.println(" User Name is " + sUserName);
		System.out.println(" Password is " + sPassword);
		rv.loginATS(sUserName, sUserName);
		CommonActions.waitTime(2000);
		String str = driver.getTitle();
		CommonActions.waitTime(2000);
		System.out.println("Title of page is : " + str);
		// if(str.contains("Applicant Tracking System"))
		// {
		// rv.logoutlist();
		// rv.logoutClick();
		// }

		for (int i = 1; i < 5; i++) {
			  
		      //int count =1;
			if (str.equalsIgnoreCase("Login")) {
				ExcelReader.setExcelData("Sheet1", i, 2, "fail", DD_LOGIN_EXCEL);
				System.out.println("Test Case is failed "+i+"----");
				
				break;
				
				
			} else if (str.contains("Applicant Tracking System")) {
				ExcelReader.setExcelData("Sheet1", i, 2, "pass", DD_LOGIN_EXCEL);
				System.out.println("Test Case is Passed " +i+ "-----");
				
			    break;
			}

			//count++;
		}

		
		while (str.equalsIgnoreCase("Applicant Tracking System")){
			
		}
			
		
	}

	@DataProvider
	public Object[][] Authentication() throws Exception {
		Object[][] testObjArray = ExcelReader.getTableArray(DD_LOGIN_EXCEL, SHEET_NAME);
		return testObjArray;
	}

}
