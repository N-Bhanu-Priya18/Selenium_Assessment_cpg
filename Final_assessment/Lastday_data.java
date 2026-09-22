package Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Lastday_data 
{
	public String browser;
	public String url;
	public String username;
	public String password;
	public String data1;
	
	public void cdata() throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/LastDay_assessment/commondata+specific.properties");
		Properties p=new Properties();
		p.load(fis);
		
		browser=p.getProperty("browser");
		url=p.getProperty("url");
		username=p.getProperty("username");
		password=p.getProperty("password");
		data1=p.getProperty("data1");
	}
}
