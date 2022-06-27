package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	public Logger log=LogManager.getLogger(Base.class.getName());
	public WebDriver Initialization() throws IOException
	{
		prop=new Properties();
		;
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		// Used to access the browser input from maven comments
		//String browserName=System.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
			
		}
		else if(browserName.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\msedgedriver.exe");
			driver=new EdgeDriver();	
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
			driver=new FirefoxDriver();	
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
		TakesScreenshot ts =(TakesScreenshot)driver;
	//	String base64=ts.getScreenshotAs(OutputType.BASE64);
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination= System.getProperty("user.dir")+"\\reports\\screenshots\\"+testCaseName+formater.format(calendar.getTime())+".png";
		FileUtils.copyFile(source, new File(destination)); 
	//	
		return destination;
    }
	

}
