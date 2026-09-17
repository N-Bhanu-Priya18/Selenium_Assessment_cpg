package Day10_assessment_PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Saucedemo_Homepage 
{
	//Initialize
	WebDriver driver;
	public Saucedemo_Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Declare
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	private WebElement addToCart;
	
	@FindBy(xpath="//span[text()='1']")
	private WebElement viewCart;
	
	//Access using getters
	public void getAddToCart()
	{
		addToCart.click();
	}
	
	public void getViewCart(String value)
	{
		if(viewCart.getText().equals(value))
			System.out.println("cart contains 1 item");
		else
			System.out.println("cart does not contains 1 item");
	}
	
	public void clickCart()
	{
		viewCart.click();
	}
	
	public void verifyProductPage(String value)
	{
	    if(driver.getCurrentUrl().contains(value))
	        System.out.println("product page is displayed");
	    else
	        System.out.println("product page is not displayed");
	}
	
}