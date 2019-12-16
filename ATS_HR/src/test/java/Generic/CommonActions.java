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
//Select List Box
	public static void selectListboxOption(WebElement element, int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
//Mouse Hover Actions= move to element
	public static void actionMoveToElement(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).build().perform();
	}
//Mouse Hover Actions and click on element
	public static void actionsClick(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).click().build().perform();
	}
//Verify whether Alert popup is present
	public static void alertVerification(WebDriver driver, long time)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.alertIsPresent());
	}
//alert pop up accept/Ok
	public static void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
//alert pop up cancel
	public static void alertCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
//Switch to perticular frame by their value
	public static void frameHandle(WebDriver driver, String value)
	{
		driver.switchTo().frame(value);
	}
//wait till specific Page/title of page
	public static void homePageVerify(WebDriver driver, long time, String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.titleContains(title));
	}
//wait till specific element is displayed on page
	public static void visibilityOfElement(WebDriver driver, long time, WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
//Soft Assert
	public static void softAssert()
	{
		SoftAssert soft = new SoftAssert();
		soft.assertAll();
	}
//file upload code
	public static void fileUpload(String filePath, WebDriver driver)
	{ 
		 String path = System.getProperty("user.dir") + filePath;
		 StringSelection stringSelection = new StringSelection(path);
	     Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
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
	
//List Contains Text
	
	public static void selectListComponent(List<WebElement> options, String textToBeCompare)
	{
		for(WebElement list : options)
		{
			System.out.println(list.getText());
			if(list.getText().contains(textToBeCompare))
			{
				list.click();
				break;
			}
		}
	}
//wait
	public static void waitTime(long time)
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
