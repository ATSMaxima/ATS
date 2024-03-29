package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Generic.CommonActions;

public class Base_CommonComponent {
	@FindBy(xpath = "//ul[@class='nav']//li//i")
	private WebElement homeClickBtn;
	@FindBy(xpath = "//span[contains(text(),'Updates')]")
	private WebElement updates;
	@FindBy(xpath = "//span[contains(text(),'Candidates')]")
	private WebElement candidates;
	@FindBy(xpath = "//span[contains(text(),'Jobs')]")
	private WebElement jobs;
	@FindBy(xpath = "//span[contains(text(),'Schedular')]")
	private WebElement schedular;
	@FindBy(xpath = "//span[contains(text(),'Settings')]")
	private WebElement settings;
	@FindBy(xpath = "//a[@class='shutter-out-horizontal']")
	private WebElement logoutlist;
	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	private WebElement logOutClick;

	// public Base_CommonComponent(WebDriver driver)
	// {
	// PageFactory.initElements(driver, this);
	// }

	public void homeBtnclick() {
		CommonActions.waitTime(2000);
		homeClickBtn.click();
		CommonActions.waitTime(2000);
	}

	public void updates() {
		updates.click();
		CommonActions.waitTime(1000);
	}

	public void candidates() {
		candidates.click();
		CommonActions.waitTime(1000);
	}

	public void jobs() {
		jobs.click();
		CommonActions.waitTime(1000);
	}

	public void schedular() {
		schedular.click();
		CommonActions.waitTime(1000);
	}

	public void settings() {
		settings.click();
		CommonActions.waitTime(1000);
	}

	public void logoutlist() {
		logoutlist.click();
		CommonActions.waitTime(1000);
	}

	public void logoutClick() {
		logOutClick.click();
		CommonActions.waitTime(1000);
	}
}
