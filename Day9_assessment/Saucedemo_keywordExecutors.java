package KeyWordDriven;

public class Saucedemo_keywordExecutors {
	saucedemo_keywordImplementation sd=new saucedemo_keywordImplementation();
	public void Executors(String keyword)
	{
		if(keyword.equals("LAUNCH_BROWSER"))
		{
			sd.launchBrowser();
		}
		
		else if(keyword.equals("OPEN_URL"))
		{
			sd.openUrl();
		}
		
		else if(keyword.equals("USERNAME_TF"))
		{
			sd.username_tf();
		}
		
		else if(keyword.equals("PASSWORD_TF"))
		{
			sd.password_tf();
		}
		
		else if(keyword.equals("LOGIN_BUTTON"))
		{
			sd.loginButton();
		}
		
		else if(keyword.equals("CLOSE_BROWSER")) 
		{
			sd.closeBrowser();
		}
	}
}
