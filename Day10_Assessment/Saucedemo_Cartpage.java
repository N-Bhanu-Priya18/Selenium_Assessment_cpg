package Day10_assessment_PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Saucedemo_Cartpage
{
	//Initialize
	WebDriver driver;
	public Saucedemo_Cartpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//Declare
	@FindBy(xpath="//button[@id='checkout']")
	private WebElement checkOut;
	
	
	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
	private WebElement product;
	
	//Access using getters
	public void getCheckOut()
	{
		checkOut.click();
	}
	
	public void verifyproduct(String value)
	{
		if(product.getText().contains(value))
			System.out.println("Product is diplayed");
		else
			System.out.println("product is not displayed ");
	}
}
