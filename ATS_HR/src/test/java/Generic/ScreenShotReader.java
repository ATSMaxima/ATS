package Generic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotReader implements AutoConstants{
	public static String getScreenShot(WebDriver driver, String name)
	{
//To get date and time along with screen shot we use below 3 lines of code
		Date d=new Date();
		SimpleDateFormat f=new SimpleDateFormat(" dd_MM_yyyy   hh-mm-ss");
		String str = f.format(d);
//Screen shot code
		TakesScreenshot shot=(TakesScreenshot)driver;
//it will take screen shot whose output type should be file
		File src=shot.getScreenshotAs(OutputType.FILE);
//user.dir= project folder location
//name= method name get from listeners
// str= date and time
		String path = System.getProperty("user.dir")+"/FailedScreenShots/"+name+str+".png";
//Create file at above mentioned path and copy it from source to destination
		File dest=new File(path);
		try 
		{
			FileUtils.copyFile(src, dest);
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		return path;
	}


}
