package driverFactory;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import cofig.Customer1;
import commonFunctions.Customerpage;
import utilities.Excelfileutil;

public class Customertest extends Customer1 {
	String inputpath = "./FileInput/customer.xlsx";
    String outputpath = "./FileOutput/CustomerResults.xlsx";
    boolean res = false ;
    
    @Test
    public void startTest() throws IOException, Throwable
    {
    Excelfileutil xl = new Excelfileutil(inputpath);
    int rc = xl.rowcount("customer");
    Reporter.log("rowcount", rc, true);
    for (int i=1;i<=rc;i++)
    {
    String customername = xl.getCellData("customer", i,0 )	;
    String address = xl.getCellData("customer", i,1 )	;
    String city = xl.getCellData("customer", i,2 )	;
    String country = xl.getCellData("customer", i,3 )	;
    String contactperson = xl.getCellData("customer", i,4 )	;
    String phonenumber = xl.getCellData("customer", i,5 )	;
    String email = xl.getCellData("customer", i,6 )	;
    String mobilenumber= xl.getCellData("customer", i,7)	;
    String notes = xl.getCellData("customer", i,8)	;
    
   Customerpage cp = PageFactory.initElements(driver,Customerpage.class);
   res = cp.addCustomer(customername, address, city, country, contactperson, phonenumber, email, mobilenumber, notes);
    if (res)
    {
    	xl.setCelldata("customer",i, 9,"pass", outputpath);
    }else 
    {
    	xl.setCelldata("customer",i, 9, "fail",outputpath);
    }
    	
    }
    }
}



