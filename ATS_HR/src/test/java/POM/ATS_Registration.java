package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ATS_Registration extends Base_CommonComponent{
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userName;
	@FindBy(xpath = "//input[@name='first_name']")
	private WebElement firstName;
	@FindBy(xpath = "//input[@name='last_name']")
	private WebElement lastName;
	@FindBy(xpath = "//input[@name='email']")
	private WebElement email;
	@FindBy(xpath = "//input[@name='confirm_email']")
	private WebElement confirmEmail;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	@FindBy(xpath = "//div//input[@class='btn btn-success']")
	private WebElement submitBtn;
	@FindBy(xpath = "//button[contains(text(),'click here to Login')]")
	private WebElement clickHereToLogin;

	public ATS_Registration(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void userName(String user) {
		userName.sendKeys(user);
	}

	public void firstName(String name) {
		firstName.sendKeys(name);
	}

	public void lastName(String lastname) {
		lastName.sendKeys(lastname);
	}

	public void email(String emailID) {
		email.sendKeys(emailID);
	}

	public void confirmEmail(String emailconfirm) {
		confirmEmail.sendKeys(emailconfirm);
	}

	public void password(String pwd) {
		password.sendKeys(pwd);
	}

	public void submitBtn() {
		submitBtn.click();
	}

	public void clickHereToLogin() {
		clickHereToLogin.click();
	}

}