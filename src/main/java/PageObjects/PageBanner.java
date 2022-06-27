package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBanner {
	
public WebDriver driver;
	
	// HomePage of  App
	
	private By banner=By.cssSelector("[class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']");
		
	public  PageBanner(WebDriver driver) {
		
		this.driver=driver;
	}

	public WebElement getPageBanner()
	{
		return driver.findElement(banner);
	}

}
