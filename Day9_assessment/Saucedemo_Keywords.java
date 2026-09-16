package KeywordFrameworkImplementation;

import KeyWordDriven.Saucedemo_keywordExecutors;

public class saucedemo_keywords {

	public static void main(String[] args) throws InterruptedException {
		Saucedemo_keywordExecutors e=new Saucedemo_keywordExecutors();
		e.Executors("LAUNCH_BROWSER");
		Thread.sleep(1000);
		e.Executors("OPEN_URL");
		Thread.sleep(1000);
		e.Executors("USERNAME_TF");
		Thread.sleep(1000);
		e.Executors("PASSWORD_TF");
		Thread.sleep(1000);
		e.Executors("LOGIN_BUTTON");
		Thread.sleep(1000);
		e.Executors("CLOSE_BROWSER");

	}

}
