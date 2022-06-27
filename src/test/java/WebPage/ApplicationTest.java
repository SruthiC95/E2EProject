package WebPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.PageBanner;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import resources.Base;

public class ApplicationTest extends Base {
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=Initialization();
		log.info("Browser is intitialized");
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
	@Test(dataProvider="getData")
	public void basePage(String useremail, String password) throws IOException, InterruptedException
	{
		
		log.info("Navigated to the Homepage");
		//One by inheritance
		//Create Object to that class and invoke methods of it
		// HomePage access 
		HomePage hp=new HomePage(driver); 
		LoginPage lp=hp.getSignin();
		log.info("SignIn is successfully clicked");
		
		lp.getUserEmail().sendKeys(useremail);
		lp.getPassword().sendKeys(password);
		lp.getSignIn().click();	
		log.info("Userdetails are entered");
		
	//	System.out.println(lp.getFailedError().getText());
	//	Assert.assertEquals(lp.getFailedError().getText(), "There is 1 error"+ "Authentication failed.");
		
		PageBanner pb=new PageBanner(driver);
		boolean check=pb.getPageBanner().isDisplayed();
		Assert.assertFalse(check);
		log.info(pb.getPageBanner().isDisplayed());	
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Row stands for how many different data types test should run
		//Column stands for how many values per each test
		Object[][] data=new Object[2][2];
		data[0][0]="sruthi.c95@gmail.com";
		data[0][1]="8903479938";
		
		data[1][0]="gopusd@gmail.com";
		data[1][1]="Sruthi123";
		
		return data;
	}
	
	@AfterClass
	public void exit()
	{
		driver.quit();
	}

}
