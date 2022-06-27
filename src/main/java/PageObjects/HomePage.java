package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;
	
	// HomePage of Myntra App
	
	private By signin=By.cssSelector("[class='login']");
	private By contact=By.xpath("//span[@class='shop-phone']");
	private By follow = By.cssSelector("div#facebook_block h4");
	
		
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
	}

	public LoginPage getSignin()
	{
		driver.findElement(signin).click();;
		LoginPage lp=new LoginPage(driver);
		return lp;
	}
	public WebElement getContact()
	{
		return driver.findElement(contact);
	}

	public WebElement getfollow()
	{
		return driver.findElement(follow);
	}
}
