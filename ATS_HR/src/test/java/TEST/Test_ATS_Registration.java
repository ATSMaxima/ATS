package TEST;

import org.testng.annotations.Test ;

import Generic.CommonActions;
import POM.ATS_Login;
import POM.ATS_Registration;

public class Test_ATS_Registration extends BaseTest{
	@Test
	public void registration()
	{
		l = extent.createTest("registration");
		ATS_Login al = new ATS_Login(driver);
		al.newUserClick();
		ATS_Registration ar = new ATS_Registration(driver);
		ar.userName(UN);
		ar.firstName(FirstName);
		ar.lastName(LastName);
		ar.email(Email);
		ar.confirmEmail(Email);
		ar.password(PW);
		ar.submitBtn();
		String str = driver.getTitle();
		CommonActions.waitTime(2000);
		System.out.println("Title of page is : " +str);
		if(str.contains("Applicant Tracking System"))
		{
			ar.logoutlist();
			ar.logoutClick();
		}
	}

}
