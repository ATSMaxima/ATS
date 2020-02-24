package Generic;

public interface AutoConstants {
	
//This is an Interface where we have store constants or file paths or 
//other data which we are using through out project 
	
//Driver Paths
	String PROPERTY_PATH = "../ATS_HR/PropertyFile.properties";
	String GeckoExe = "webdriver.gecko.driver";
	String GeckoPath = "..";
	String IE_EXE = "webdriver.ie.driver";
	String IE_PATH = "..";
	String ChromedriverKey = "webdriver.chrome.driver";
	String ChromedriverPath = "../ATS_HR/BrowserDriver/chromedriver.exe";
	
//Folder Paths
	String SCREENSHOT_LOC = "../ATS_HR/FailedScreenShots/";
	String DD_LOGIN_EXCEL = "../ATS_HR/ExcelFiles/ATS_Login_1.xlsx";
	String SHEET_NAME = "Sheet1";
	String DD_Registration_EXCEL = "../ATS_HR/ExcelFiles/ATS_Registration_4.xlsx";
	
// Waits
	int waitTime = 60;
// Un and PW
	String UN = "ashingote";
	String PW = "ashingote";
	
//File Upload Paths
	String uploadFilePath = "\\UploadFiles\\VivekGaikwad.pdf";
	
//Profile URl
	String profileUrl = "www.linkedin.com/ashingote";
	
//Manually Enter Information
	String FirstName = "RakeeshAaBB";
	String LastName = "PaatilabBAA";
	String Email = "rpaatilaABbAA@maximaconsulting.net";
	String Phone = "9886600914";
	String fullName = FirstName+" "+LastName;

//Search candidate
	String CandidateName = "Amol Shingote";
	
}
