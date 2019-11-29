package Generic;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader implements AutoConstants{
	public static String getPropertyValue(String key)
	{
		String path=PROPERTY_PATH;
		Properties p=new Properties();
		try 
		{
			FileInputStream file=new FileInputStream(path);
			p.load(file);
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		return p.getProperty(key);
	}


}
