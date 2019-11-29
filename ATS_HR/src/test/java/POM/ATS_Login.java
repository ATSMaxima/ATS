package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.CommonActions;

public class ATS_Login extends Base_CommonComponent{
	@FindBy(name = "username")
	private WebElement userName;
	@FindBy(name = "password")
	private WebElement passWord;
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement rememberChkBox;
	@FindBy(xpath = "//button[contains(text(),'Login')]")
	private WebElement loginButton;
	@FindBy(xpath = "//li[contains(text(), 'User does not exist.')]")
	private WebElement errorMsg;
	// ***********************************************************************
	@FindBy(xpath = "//button[contains(text(),'New User? Sign Up')]")
	private WebElement newUser;

	public ATS_Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginATS(String un, String pw) {
		userName.sendKeys(un);
		CommonActions.waitTime(1000);
		passWord.sendKeys(pw);
		CommonActions.waitTime(1000);
		rememberChkBox.click();
		CommonActions.waitTime(1000);
		loginButton.click();
	}
	
	public void newUserClick()
	{
		newUser.click();
	}

}