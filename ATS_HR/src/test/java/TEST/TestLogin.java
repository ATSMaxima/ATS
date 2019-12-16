package TEST;

import org.testng.annotations.Test;

import Generic.CommonActions;
import POM.ATS_Login;

public class TestLogin extends BaseTest{
	
	@Test
	public void login()
	{
//login code
		l = extent.createTest("login");
		ATS_Login al = new ATS_Login(driver);
		al.loginATS(UN, PW);
		al.logoutlist();
		al.logoutClick();
		CommonActions.softAssert();
	}
}
