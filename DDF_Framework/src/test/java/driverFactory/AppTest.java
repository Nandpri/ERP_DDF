package driverFactory;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cofig.Apputil;
import commonFunctions.Functionlibrary;
import utilities.Excelfileutil;

@Test
public class AppTest extends Apputil {
	
	String inputpath = "./FileInput/LoginData_lyst2438.xlsx";
    String outputpath = "./FileOutput/DatadrivenResults.xlsx";
    ExtentReports reports;
    ExtentTest test;
    
    public void startTest() throws IOException, Throwable
    {
    	reports = new ExtentReports("./ExtentReports/Loginreport.html");
    	boolean res = false;
    	Excelfileutil xl = new Excelfileutil(inputpath);
    	int rc = xl.rowcount("Login");
    	System.out.println("login rowcount" + rc);
    	for (int i=1;i<=rc;i++)
    	{
    	String username = xl.getCellData("Login",i, 0); 
    	String password =xl.getCellData("Login", i, 1);
    	test = reports.startTest("Logintest");
    	test.assignAuthor("priya");
    	res = Functionlibrary.verify_Login(username, password);
    	if (res)
    	{
    		xl.setCelldata("Login",i, 2,"Loginpass", outputpath);
    		xl.setCelldata("Login", i, 3, "pass",outputpath);
    		test.log(LogStatus.PASS,"Login Success");
    	}else
    	{
    		TakesScreenshot ts = (TakesScreenshot)driver;
    		File src = ts.getScreenshotAs(OutputType.FILE);
    		File trg = new File ("./screenshot/Iteration"+i+ "Loginpage.png");
    		FileUtils.copyFile(src,trg);
    		xl.setCelldata("Login",i, 2,"Loginfail", outputpath);
    		xl.setCelldata("Login", i, 3, "fail",outputpath);
    		test.log(LogStatus.FAIL,"Login fail");
    		reports.endTest(test);
    		reports.flush();
    	}
    	}
    }
}
