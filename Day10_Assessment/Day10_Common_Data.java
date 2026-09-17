package Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Day10_Common_Data 
{
	public String browser;
	public String url;
	public String username;
	public String password;
	
	public void cdata() throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/Day10_assessment/Day10_Saucedemo.properties");
		Properties p=new Properties();
		p.load(fis);
		
		browser=p.getProperty("browser");
		url=p.getProperty("url");
		username=p.getProperty("username");
		password=p.getProperty("password");
	}
}
