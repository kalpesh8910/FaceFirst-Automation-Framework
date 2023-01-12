package com.FaceFirst.web.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ClientLoginPageLocator {
			
	// **************Deployment types**************

		
	@FindBy(how = How.ID, using = "login-username")
    public WebElement input_ClientUsername;
	
	@FindBy(how = How.ID, using = "login-password")
    public WebElement input_ClientPassword;
	
	@FindBy(how = How.XPATH, using = "//img[@id='ff-header-logo']")
    public WebElement verify_facefirstLogo;
	
	@FindBy(how = How.XPATH, using = "//div[@class='ff-alert alert-error']")
    public WebElement verify_validation_msg;
	
	@FindBy(how = How.XPATH, using = "//a[@href='https://localhost']")
    public WebElement clickPortalLink;
	
	
	
	
}
