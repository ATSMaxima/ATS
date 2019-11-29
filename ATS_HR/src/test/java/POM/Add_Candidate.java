package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Generic.CommonActions;

public class Add_Candidate extends Base_CommonComponent{
	@FindBy(xpath = "//ul[@class='nav']//li//i")
	private WebElement homeClickBtn;
	@FindBy(xpath = "//li//span[@class='sub-sidebar-txt']")
	private List<WebElement> homeBtnList;
	@FindBy(xpath = "//button[contains(text(),'Add Candidate')]")
	private WebElement addCandidateBtn;
	@FindBy(xpath = "//input[@id='validatedCustomFile']")
	private WebElement browseBtn;
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement nextBtn;
	@FindBy(xpath = "//input[@id='id_profile_url']")
	private WebElement profileUrl;
	@FindBy(xpath = "//select[@id='id_source']")
	private WebElement source;
	@FindBy(xpath = "//select[@id='id_source']//option")
	private List<WebElement> sourceList;
	@FindBy(xpath = "//select[@id='id_sourced_by']")
	private WebElement sourceBy;
	@FindBy(xpath = "//select[@id='id_sourced_by']//option")
	private List<WebElement> sourceByList;
	@FindBy(xpath = "//div[contains(text(),'First Name is required!')]")
	private WebElement errorFirstName;
	@FindBy(xpath = "//div[contains(text(),'Last Name is required!')]")
	private WebElement errorLastName;
	@FindBy(xpath = "//div[contains(text(),'Email address is required!')]")
	private WebElement errorEmailExist;
	@FindBy(xpath = "//select[@id='id_job']")
	private WebElement jobTitle;
	@FindBy(xpath = "//select[@id='id_job']//option")
	private List<WebElement> jobTitleList;
	@FindBy(xpath = "(//button[contains(text(),'Add Candidate')])[1]")
	private WebElement addCandidateSubmitBtn;
	// *************************************************************************
	@FindBy(xpath = "//div[@id='withoutResume']")
	private WebElement continueWithoutResume;
	@FindBy(xpath = "//input[@name='first_name']")
	private WebElement firstName;
	@FindBy(xpath = "//input[@name='last_name']")
	private WebElement lastName;
	@FindBy(xpath = "//input[@name='email']")
	private WebElement email;
	@FindBy(xpath = "//input[@name='phone']")
	private WebElement phoneNumber;

	// ************************************************************
	public Add_Candidate(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// ************************************************************

	public void homeButtonClick() {
		CommonActions.waitTime(2000);
		homeClickBtn.click();
	}

	public void selectCandidates() {
		CommonActions.waitTime(2000);
		CommonActions.selectListComponent(homeBtnList, "CANDIDATES");
	}

	public void addCandidateButton() {
		CommonActions.waitTime(2000);
		addCandidateBtn.click();
	}

	public void browseResumeButton(WebDriver driver) {
		CommonActions.waitTime(2000);
		CommonActions.actionsClick(driver, browseBtn);
	}

	public void uploadResume(String filePath, WebDriver driver) {
		CommonActions.waitTime(2000);
		CommonActions.fileUpload(filePath, driver);
	}

	public void nextButtonClick() {
		CommonActions.waitTime(2000);
		nextBtn.click();
	}

	public void profileUrl(String Url) {
		CommonActions.waitTime(2000);
		profileUrl.sendKeys(Url);
	}

	public void selectSourceClick() {
		CommonActions.waitTime(2000);
		source.click();
		CommonActions.waitTime(2000);
		CommonActions.selectListComponent(sourceList, "External Source");
	}

	public void selectSourceByClick() {
		CommonActions.waitTime(2000);
		sourceBy.click();
		CommonActions.waitTime(2000);
		CommonActions.selectListComponent(sourceByList, "Naukri");
	}

	public void selectJobType() {
		CommonActions.waitTime(2000);
		jobTitle.click();
		CommonActions.waitTime(2000);
		CommonActions.selectListComponent(jobTitleList, "Dev_Testing");
	}

	public void candidateSubmitButton() {
		CommonActions.waitTime(2000);
		addCandidateSubmitBtn.click();
		CommonActions.waitTime(4000);
	}

	// *******************************************************************
	public void continueWithoutResume() {
		CommonActions.waitTime(2000);
		continueWithoutResume.click();
	}

	public void firstName(String name) {
		CommonActions.waitTime(2000);
		firstName.sendKeys(name);
	}

	public void lastName(String lastname) {
		CommonActions.waitTime(2000);
		lastName.sendKeys(lastname);
	}

	public void email(String emailId) {
		CommonActions.waitTime(2000);
		email.sendKeys(emailId);
	}

	public void phoneNo(String number) {
		CommonActions.waitTime(2000);
		phoneNumber.sendKeys(number);
	}

}