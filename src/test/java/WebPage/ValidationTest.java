package WebPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import resources.Base;

public class ValidationTest extends Base{
	public WebDriver driver;
	HomePage hp;
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=Initialization();
	//	driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void ValidatePage() throws IOException, InterruptedException	
	{
		
		// HomePage access 
		hp=new HomePage(driver); 
		Assert.assertEquals(hp.getContact().getText(),"Call us now: 0123-456-789");
		log.info(hp.getContact().getText());
	}
	
	@Test
	public void ValidatePageFooter()throws IOException, InterruptedException
	{
		Assert.assertEquals(hp.getfollow().getText(),"Follow us on Facebook");
	}
	
	@AfterClass
	public void exit()
	{
		driver.quit();
	}

}
