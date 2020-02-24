package Generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class CommonActions {
	// Select element using index number from ListBox
	public static void selectListboxOption(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	// Mouse Hover Actions= move mouse pointer to specific element
	public static void actionMoveToElement(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();
	}

	// Mouse Hover Actions= move mouse pointer to specific element and click on
	// that element
	public static void actionsClick(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).click().build().perform();
	}

	// Verify whether Alert popup is present
	public static void alertVerification(WebDriver driver, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	// alert pop up accept/Ok button click
	public static void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	// alert pop up cancel button click
	public static void alertCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	// Switch to particular frame by their value
	public static void frameHandle(WebDriver driver, String value) {
		driver.switchTo().frame(value);
	}

	// wait until specific Page/title of the page is verified
	public static void homePageVerify(WebDriver driver, long time, String title) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.titleContains(title));
	}

	// wait until specific element is displayed on page
	public static void visibilityOfElement(WebDriver driver, long time, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	// Get text of any component and verify (Use for any component or
	// warning/error msg is disp and get text and verify)
	public static boolean getTextAndVerify(WebElement ele, String str1) {
		boolean result = false;
		if (ele.isDisplayed()) {
			String text = ele.getText();
			result = text.equalsIgnoreCase(str1);
		}

		return result;
	}

	// Soft Assert
	public static void softAssert() {
		SoftAssert soft = new SoftAssert();
		soft.assertAll();
	}

	// file upload code
	public static void fileUpload(String filePath, WebDriver driver) {
		// Get the file path
		String path = System.getProperty("user.dir") + filePath;
		// Store path in stringSelection Object reference
		StringSelection stringSelection = new StringSelection(path);
		// Activate System Clipboard
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		// Copy File Path using setContent to Clipboard
		clipboard.setContents(stringSelection, null);
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.delay(2000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	// Robot Keys Actions
	public static void keyAction(String key) {
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.delay(2000);
		if (key.equalsIgnoreCase("enter")) {
			r.keyPress(KeyEvent.VK_ENTER);
		} else if (key.equalsIgnoreCase("tab")) {
			r.keyPress(KeyEvent.VK_TAB);
		}
	}

	// Select List component using Contains Text

	public static void selectListComponent(List<WebElement> options, String textToBeCompare) {
		for (WebElement list : options) {
			System.out.println(list.getText());
			if (list.getText().contains(textToBeCompare)) {
				list.click();
				break;
			}
		}
	}

	public static void verifyListComponent(List<WebElement> options, WebElement nextButton, String textToBeCompare) {
		int position = 0;
		boolean isDisplay = false;
		String text = "";
		do {
			// Get all the options in list and iterate it one by one if text not
			// found click on next button
			// and this process continue till text matches and once the text
			// matches it break the do while loop
			for (WebElement list : options) {
				text = list.getText();
				System.out.println(text);
				if (text.equals(textToBeCompare)) {
					System.out.println("Text to be compare is : " + textToBeCompare);
					System.out.println(list.getText() + " is present at " + position + " position");
					isDisplay = true;
					break;
				}
				++position;
			}
			if (isDisplay == false) {
				nextButton.click();
			}
		} while (isDisplay == false);

	}

	// while (text.equals(textToBeCompare)

	// wait
	public static void waitTime(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
