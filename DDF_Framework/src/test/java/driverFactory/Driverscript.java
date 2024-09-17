package driverFactory;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import cofig.Supplier1;
import commonFunctions.SupplierPage;
import utilities.Excelfileutil;

public class Driverscript extends Supplier1{
	
	String inputpath = "./FileInput/SupplierData_lyst9136.xlsx";
    String outputpath = "./FileOutput/SupplierResults.xlsx";
    boolean res = false;
    
    @Test
    public void startTest() throws IOException, Throwable
    {
    Excelfileutil xl = new Excelfileutil(inputpath);
    int rc = xl.rowcount("supplier");
    Reporter.log("rowcount", rc, true);
    for (int i=1;i<=rc;i++)
    {
    String suppliername = xl.getCellData("supplier", i,0 )	;
    String address = xl.getCellData("supplier", i,1 )	;
    String city = xl.getCellData("supplier", i,2 )	;
    String country = xl.getCellData("supplier", i,3 )	;
    String contactperson = xl.getCellData("supplier", i,4 )	;
    String phonenumber = xl.getCellData("supplier", i,5 )	;
    String email = xl.getCellData("supplier", i,6 )	;
    String mobilenumber= xl.getCellData("supplier", i,7)	;
    String notes = xl.getCellData("supplier", i,8)	;
    
    SupplierPage sp = PageFactory.initElements(driver,SupplierPage.class);
    res = sp.add_Supplier(suppliername, address, city, country, contactperson, phonenumber, email, mobilenumber, notes);
    if (res)
    {
    	xl.setCelldata("supplier",i, 9,"pass", outputpath);
    }else 
    {
    	xl.setCelldata("supplier",i, 9, "fail",outputpath);
    }
    	
    }
    }
}
