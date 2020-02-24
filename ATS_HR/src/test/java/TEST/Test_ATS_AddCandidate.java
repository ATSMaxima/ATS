package TEST;

import org.testng.annotations.Test;

import Generic.CommonActions;
import POM.ATS_Login;
import POM.Add_Candidate;

public class Test_ATS_AddCandidate extends BaseTest{
	
//Manually Uploading the Resume Information
	//Logger log = Logger.getLogger(Test_ATS_AddCandidate.class);
	
	@Test(enabled=false)
	public void addCandidateManually()
	{
		l = extent.createTest("addCandidateManually");
		//log.info("****************************** Starting test cases execution  *****************************************");
		ATS_Login al = new ATS_Login(driver);
		//log.info("launching chrome broswer");
		al.loginATS(UN, PW);
		Add_Candidate ac = new Add_Candidate(driver);
		ac.homeButtonClick();
		ac.selectCandidates();
		ac.addCandidateButton();
		ac.continueWithoutResume();
		ac.firstName(FirstName);
		ac.lastName(LastName);
		ac.email(Email);
		ac.phoneNo(Phone);
		ac.profileUrl(profileUrl);
		ac.selectSourceClick();
		ac.selectSourceByClick();
		ac.nextButtonClick();
		ac.selectJobType();
		try {
			ac.candidateSubmitButton();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//***********************************************************
	//	ac.topCandidateNameFromTable(driver, "Anmol Shingote");
		try {
			ac.elementPresentInList(driver, fullName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//***********************************************************
		ac.logoutlist();
		ac.logoutClick();
		CommonActions.softAssert();
	}
	
//Uploading the Resume Information using parsing
	@Test(enabled=false)
	public void resumeUpload()
	{
		l = extent.createTest("resumeUpload");
		ATS_Login al = new ATS_Login(driver);
		al.loginATS(UN, PW);
		Add_Candidate ac = new Add_Candidate(driver);
		ac.homeButtonClick();
		ac.selectCandidates();
		ac.addCandidateButton();
		ac.browseResumeButton(driver);
		ac.uploadResume(uploadFilePath, driver);
		ac.nextButtonClick();
		ac.profileUrl(profileUrl);
		ac.selectSourceClick();
		ac.selectSourceByClick();
		ac.nextButtonClick();
		ac.selectJobType();
		ac.candidateSubmitButton();
		ac.logoutlist();
		ac.logoutClick();
		CommonActions.softAssert();
	}
	
//searching and checking whether candidate is present in table or not
	@Test
	public void seacrchCandidate()
	{
		l = extent.createTest("resumeUpload");
		ATS_Login al = new ATS_Login(driver);
		al.loginATS(UN, PW);
		Add_Candidate ac = new Add_Candidate(driver);
		ac.homeButtonClick();
		ac.selectCandidates();
		ac.searchCandidate(CandidateName);
		
	}
}
