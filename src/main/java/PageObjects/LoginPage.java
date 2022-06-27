package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
public WebDriver driver;
	
	// LoginPage of Web App
	private By userEmail=By.id("email");
	private By password=By.id("passwd");
	private By signIn=By.id("SubmitLogin");

	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
	}

	public WebElement getUserEmail()
	{
		return driver.findElement(userEmail);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	} 
	
	public WebElement getSignIn()
	{
		return driver.findElement(signIn);
	
	} 


}
