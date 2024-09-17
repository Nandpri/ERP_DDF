package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutpage {
	 
	// objectRepository for logout
	@FindBy(xpath = "(//a[starts-with(text(),' Logout')])[2]")
	WebElement ObjLogout;
	
	public void LogoutApp()
	{
		ObjLogout.click();
	}

}
