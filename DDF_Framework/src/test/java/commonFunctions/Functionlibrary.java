package commonFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Reporter;

import cofig.Apputil;

public class Functionlibrary extends Apputil{
	
	public static boolean verify_Login(String user , String pass) throws InterruptedException
	{
		driver.get(conpro.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath(conpro.getProperty("ObjReset"))).click();
		driver.findElement(By.xpath(conpro.getProperty("ObjUser"))).sendKeys(user);
		driver.findElement(By.xpath(conpro.getProperty("Objpass"))).sendKeys(pass);
		driver.findElement(By.xpath(conpro.getProperty("ObjLogin"))).click();
		Thread.sleep(3000);
		String Exp = "dashboard";
		String Act = driver.getCurrentUrl();
		if (Act.contains(Exp))
		{
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/ul[1]/li[11]/a")).click();
			Reporter.log("Loginsuccess"+ Exp + "" + Act + "" + true);
			return true;
		}else 
		{
	  String errmsg = driver.findElement(By.xpath(conpro.getProperty("Objerrormessage"))).getText();
	  driver.findElement(By.xpath(conpro.getProperty("Objok"))).click();
	  Reporter.log(errmsg, true);
	  return false;
		}
	}

}
