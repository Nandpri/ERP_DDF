package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class Customerpage {

	WebDriver driver;
	public Customerpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/ul[1]/li[5]/a")
	WebElement Objcustomer;
	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div[3]/div[1]/div[1]/div[1]/div/a")
	WebElement ObjAddicon;
	@FindBy(xpath="//input[@id='x_Customer_Number']")
	WebElement Objcustomernumber;
	@FindBy(xpath="//input[@id='x_Customer_Name']")
	WebElement Objcustomername;
	@FindBy(xpath="//textarea[@id='x_Address']")
	WebElement Objaddress;
	@FindBy(xpath="//input[@id='x_City']")
	WebElement Objcity;
	@FindBy(xpath="//input[@id='x_Country']")
	WebElement Objcountry;
	@FindBy(xpath="//input[@id='x_Contact_Person']")
	WebElement Objcontactperson;
	@FindBy(xpath="//input[@id='x_Phone_Number']")
	WebElement Objphonenumber;
	@FindBy(xpath="//input[@id='x__Email']")
	WebElement Objemail;
	@FindBy(xpath="//input[@id='x_Mobile_Number']")
	WebElement Objmobilenumber;
	@FindBy(xpath="//input[@id='x_Notes']")
	WebElement Objnotes;
	@FindBy(xpath="//button[@id='btnAction']")
	WebElement ObjAddbtn;
	@FindBy(xpath="/html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")
	WebElement Objconfirmbtn;
	@FindBy(xpath="/html/body/div[17]/div[2]/div/div[4]/div[2]/button")
	WebElement Objalertbtn;
	@FindBy(xpath="/html/body/div[2]/div[3]/div/div/div[2]/div[2]/div/button/span")
	WebElement Objsearchpanel;
	@FindBy(xpath="//input[@id='psearch']")
	WebElement Objsearchtextbox;
	@FindBy(xpath="//button[@id='btnsubmit']")
	WebElement Objsearchbtn;
	@FindBy(xpath="/html/body/div[2]/div[3]/div/div/div[3]/form/div/div[2]/table/tbody/tr/td[5]/div/span/span")
	WebElement Webtable;
	
	
	public boolean addCustomer(String customername,String address,String city,String country,
			String contactperson,String phonenumber,String email,String mobilenumber,String notes)throws Throwable
		{
			Actions ac = new Actions(driver);
			ac.moveToElement(this.Objcustomer).click().perform();
			Thread.sleep(2000);
			ac.moveToElement(this.ObjAddicon).click().perform();
			Thread.sleep(2000);
			String Exp =this.Objcustomernumber.getAttribute("value");
			this.Objcustomername.sendKeys(customername);
			this.Objaddress.sendKeys(address);
			this.Objcity.sendKeys(city);
			this.Objcountry.sendKeys(country);
			this.Objcontactperson.sendKeys(contactperson);
			this.Objphonenumber.sendKeys(phonenumber);
			this.Objemail.sendKeys(email);
			this.Objmobilenumber.sendKeys(mobilenumber);
			this.Objnotes.sendKeys(notes);
			ac.moveToElement(this.ObjAddbtn).click().perform();
			Thread.sleep(2000);
			ac.moveToElement(this.Objconfirmbtn).click().perform();
			Thread.sleep(2000);
			ac.moveToElement(this.Objalertbtn).click().perform();
			Thread.sleep(2000);
			
				
				this.Objsearchpanel.click();
				this.Objsearchtextbox.clear();
				this.Objsearchtextbox.sendKeys(Exp);
				this.Objsearchbtn.click();
			
			Thread.sleep(2000);
		   String Act =this.Webtable.getText();
			if(Exp.equals(Act))
			{
				Reporter.log("customer Add Success::"+Exp+Act,true);
				return true;
			}
			else
			{
				Reporter.log("customer Add Fail::"+Exp+Act,true);
				return false;
			}
			
		}
}


