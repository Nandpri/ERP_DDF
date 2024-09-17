package cofig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import commonFunctions.LogOutpage;
import commonFunctions.LoginPage;

public class Customer1 {
	public static WebDriver driver;
	public static Properties conpro;
	
	@BeforeTest
	public static void setUp() throws Throwable, IOException
	{
	conpro = new Properties();
	conpro.load(new FileInputStream("./PropertyFiles/Environment.properties"));
	if (conpro.getProperty("Browser").equalsIgnoreCase("chrome"))
	{
	driver = new ChromeDriver()	;
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get(conpro.getProperty("Url"));
	LoginPage login = PageFactory.initElements(driver,LoginPage.class);
	login.Logintest("admin","master");
	}else if (conpro.getProperty("Browser").equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver()	;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(conpro.getProperty("Url"));
		LoginPage login = PageFactory.initElements(driver,LoginPage.class);
		login.Logintest("admin","master");
	}else 
	{
		Reporter.log("Browser value not matching",true);
	}
	}

	@AfterTest
	public static void logout()
	{
		LogOutpage logout = PageFactory.initElements(driver,LogOutpage.class);
		logout.LogoutApp();
		driver.quit();
	}
}


