package com.FaceFirst.web.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ClientLoginPageOptionsLocator {
			
	// **************Deployment types**************
	
	@FindBy(how = How.XPATH, using = "//a[@href='https://localhost']")
    public WebElement portalLink;
		
	@FindBy(how = How.ID, using = "login-username")
    public WebElement input_ClientUsername;
	
	@FindBy(how = How.ID, using = "login-password")
    public WebElement input_ClientPassword;
	
	@FindBy(how = How.XPATH, using = "//p[text()='Users' and @class='login-menu-title tal posrel fltlft'] ")
    public WebElement User_button;
	
	@FindBy(how = How.XPATH, using = "//p[text()='Users' and @class='login-menu-title tal posrel fltlft']")
    public WebElement user_Text;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Enabled']")
    public WebElement Enabled_text;
	
	@FindBy(how = How.XPATH, using = "//div[@ng-click='logout()'and @class='footer-menu-item-min posrel fltlft']")
    public WebElement logout_button;
	
	@FindBy(how = How.XPATH, using = "//p[text()='Events' and @class='login-menu-title tal posrel fltlft']")
    public WebElement event_Button;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Events']")
    public WebElement event_text;
	
	@FindBy(how = How.XPATH, using = "//p[text()='Identify & Enroll' and @class='login-menu-title tal posrel fltlft']")
    public WebElement identify_enroll_button;
	
	@FindBy(how = How.XPATH, using = "//p[text()='Account' and @class='login-menu-title tal posrel fltlft']")
    public WebElement account_button;
	
	@FindBy(how = How.XPATH, using = "//p[text()='Identify & Enroll' and @class='posrel fltlft disblk']")
    public WebElement identifyEnroll_text;
	
	@FindBy(how = How.XPATH, using = "//p[text()='Account' and @class='posrel fltlft disblk']")
    public WebElement account_text;
	
	
	
	

	 

	 

	 

	
	
	
}
