package TEST;

import org.testng.annotations.Test;

import Generic.CommonActions;
import POM.ATS_JobPage;
import POM.ATS_Login;

public class Test_Add_Job extends BaseTest {
	String str = null;
	@Test
	public void addJob (){
	l = extent.createTest("addJob");
	ATS_Login al = new ATS_Login(driver);
	al.loginATS(UN, PW);
	ATS_JobPage aj = new ATS_JobPage(driver);
	aj.homeBtnclick();
	aj.select("JOBS");
	aj.click_AddJob();
	aj.get_JobTitle("Consultant");
	aj.get_ReqId("S123");
	aj.get_Location_Address("Pune");
	aj.get_Department("Support");
	aj.get_ApplicationForm("Resume Required");
	aj.get_JobType("Contract");
	aj.get_JobTime("Part Time");
	aj.get_Salary("500000");
	aj.get_SalaryType("Annually");
	aj.click_BasicsNext();
	aj.get_ClientManager("Martin");
	aj.get_Number_Of_Resources("6");
	aj.click_CalenderIcon();
	aj.get_Date("26/December/2019");
	aj.get_Description("Demo of Max-Hire");
	aj.click_BasicsNext();
	aj.get_HiringManagers("manish");
	aj.get_Coordinators("HR Team");
	aj.get_Recruiters("hitesh");
	aj.get_HiringProcess("External Client");
	aj.click_addJob_on_Popup();
	str = driver.getTitle();
	CommonActions.waitTime(2000);
	System.out.println("Title of page is : " + str);
	if(str.contains("Applicant Tracking System"))
	 {
		aj.logoutlist();
		aj.logoutClick();
	 }
	CommonActions.softAssert();
	}

}
