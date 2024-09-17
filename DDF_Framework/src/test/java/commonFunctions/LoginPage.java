package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
 // Object repository for loginpage
	
	@FindBy(xpath = "//button[@id='btnreset']")
	WebElement ObjResetbtn;
	@FindBy(xpath = "//input[@id='username']")
	WebElement ObjUsername;
	@FindBy(xpath = "//input[@id='password']")
	WebElement ObjPassword;
	@FindBy(xpath = "//button[@id='btnsubmit']")
	WebElement ObjLoginbtn;

	public void Logintest(String username , String password)
	{
		ObjResetbtn.click();
		ObjUsername.sendKeys(username);
		ObjPassword.sendKeys(password);
		ObjLoginbtn.click();
	}

}
