package TEST;

import org.testng.annotations.Test;
import POM.ATS_Login;
import POM.Add_Candidate;

public class Test_ATS_AddCandidate extends BaseTest{
	
//Manually Uploading the Resume Information
	@Test(priority = 0)
	public void addCandidateManually()
	{
		l = extent.createTest("resumeUpload");
		ATS_Login al = new ATS_Login(driver);
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
		ac.candidateSubmitButton();	
		ac.logoutlist();
		ac.logoutClick();
	}
	
//Uploading the Resume Information using parsing
	@Test(priority = 1)
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
	}
	
}
