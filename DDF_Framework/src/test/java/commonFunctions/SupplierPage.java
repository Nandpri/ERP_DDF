package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SupplierPage {
	
	WebDriver driver;
	
	
	public SupplierPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	//obj repository for supplierpage
	
	@FindBy(xpath ="(//a[contains(text(),'Suppliers')])[2]" )
	WebElement ObjSupplier;
	@FindBy(xpath = "(//span[@data-caption='Add'])[1]")
	WebElement ObjAddIcon;
	@FindBy(xpath = "//input[@id='x_Supplier_Number']")
	WebElement Objsuppliernumber;
	@FindBy(xpath = "//input[@id='x_Supplier_Name']")
	WebElement Objsuppliername;
	@FindBy(xpath = "//textarea[@id='x_Address']")
	WebElement ObjAddress;
	@FindBy(xpath = "//input[@id='x_City']")
	WebElement ObjCity;
	@FindBy(xpath = "//input[@id='x_Country']")
	WebElement ObjCountry;
	@FindBy(xpath = "//input[@id='x_Contact_Person']")
	WebElement Objcontactperson;
	@FindBy(xpath = "//input[@id='x_Phone_Number']")
	WebElement ObjPhonenumber;
	@FindBy(xpath = "//input[@id='x__Email']")
	WebElement ObjEmail;
	@FindBy(xpath = "//input[@id='x_Mobile_Number']")
	WebElement ObjMobilenumber;
	@FindBy(xpath = "//textarea[@id='x_Notes']")
	WebElement ObjNote;
	@FindBy(id = "btnAction")
	WebElement ObjAddBtn;
	@FindBy(xpath = "//button[normalize-space()='OK!']")
	WebElement ObjconfirmOkBtn;
	@FindBy(xpath = "(//button[contains(text(),'OK')])[6]")
	WebElement ObjAlertOkBtn;
	@FindBy(xpath = "//span[@data-caption='Search']")
	WebElement ObjSearchPanel;
	@FindBy(xpath = "//input[@id='psearch']")
	WebElement ObjSearchTextbox;
	@FindBy(xpath = "//button[@id='btnsubmit']")
	WebElement ObjSearchButton;
	@FindBy(xpath = "//table[@class='table ewTable']/tbody/tr[1]/td[6]/div/span/span")
	WebElement webTable;

	
	public boolean add_Supplier(String suppliername,String Address,String City,String Country,
		String ContactPerson,String PhoneNumber,String Email,String MobileNumber,String Notes)throws Throwable
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(this.ObjSupplier).click().perform();
		Thread.sleep(2000);
		ac.moveToElement(this.ObjAddIcon).click().perform();
		Thread.sleep(2000);
		String Exp =this.Objsuppliernumber.getAttribute("value");
		this.Objsuppliername.sendKeys(suppliername);
		this.ObjAddress.sendKeys(Address);
		this.ObjCity.sendKeys(City);
		this.ObjCountry.sendKeys(Country);
		this.Objcontactperson.sendKeys(ContactPerson);
		this.ObjPhonenumber.sendKeys(PhoneNumber);
		this.ObjEmail.sendKeys(Email);
		this.ObjMobilenumber.sendKeys(MobileNumber);
		this.ObjNote.sendKeys(Notes);
		ac.moveToElement(this.ObjAddBtn).click().perform();
		Thread.sleep(2000);
		ac.moveToElement(this.ObjconfirmOkBtn).click().perform();
		Thread.sleep(2000);
		ac.moveToElement(this.ObjAlertOkBtn).click().perform();
		Thread.sleep(2000);
		if (!this.ObjSearchTextbox.isDisplayed())
		{
			this.ObjSearchPanel.click();
			this.ObjSearchTextbox.clear();
			this.ObjSearchTextbox.sendKeys(Exp);
			this.ObjSearchButton.click();
		}
		Thread.sleep(2000);
		String Act =this.webTable.getText();
		if(Exp.equals(Act))
		{
			Reporter.log("Supplier Add Success::"+Exp+"     "+Act,true);
			return true;
		}
		else
		{
			Reporter.log("Supplier Add Fail::"+Exp+"     "+Act,true);
			return false;
		}
		
	}
	}


