package TEST;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic.CommonActions;
import Generic.ExcelReader;
import POM.ATS_Login;

public class TestDataProviderATSLogin extends BaseTest {
	String str = null;
	int count = 1;

	@Test(dataProvider = "Authentication")
	public void DD_Login_data(String sUserName, String sPassword) throws Exception {
		l = extent.createTest("DD_Login_data");
		ATS_Login rv = new ATS_Login(driver);
		rv.loginATS(sUserName, sUserName);
		CommonActions.waitTime(2000);
		str = driver.getTitle();
		CommonActions.waitTime(2000);
		System.out.println("Title of page is : " + str);
		if (str.contains("Applicant Tracking System")) {
			rv.logoutlist();
			rv.logoutClick();
		}
		CommonActions.softAssert();
	}

	@DataProvider
	public Object[][] Authentication() throws Exception {
		Object[][] testObjArray = ExcelReader.getTableArray(DD_LOGIN_EXCEL, SHEET_NAME);
		return testObjArray;
	}

	@AfterTest
	public void aftertestmethod() {
		if (str.equalsIgnoreCase("Applicant Tracking System")) {
			ExcelReader.setExcelData("Sheet1", count, "pass", DD_LOGIN_EXCEL);
		} else {

			ExcelReader.setExcelData("Sheet1", count, "fail", DD_LOGIN_EXCEL);
		}
		count++;
	}

}
