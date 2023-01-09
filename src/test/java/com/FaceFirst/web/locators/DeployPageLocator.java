package com.FaceFirst.web.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DeployPageLocator {
			
	// **************Deployment types**************
	
	@FindBy(how = How.XPATH, using = "//div[@title='Deployment Wizard']")
    public WebElement deploymentWizardMenu;
		
	@FindBy(how = How.XPATH, using = "//span[text()='All-in-One']")
    public WebElement allInOne;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Core']")
    public WebElement core;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Advanced Core']")
    public WebElement advancesCore;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Next']")
    public WebElement nextButton;
	
	//********************Select cameras menu*************
		
	@FindBy(how = How.XPATH, using = "//span[text()='Select cameras']")
    public WebElement selectCameraText;
	
	// *****************************Enter portal settings*****************
	
	@FindBy(how = How.XPATH, using = "//span[text()='Enter portal settings']")
    public WebElement portalSettingsText;
	
	@FindBy(how = How.ID, using = "standard-username")
    public WebElement input_username;
	
	@FindBy(how = How.ID, using = "standard-adornment-password")
    public WebElement input_password;
	
	@FindBy(how = How.ID, using = "standard-adornment-password-confirmation")
    public WebElement input_confirmPassword;
	
	@FindBy(how = How.ID, using = "standard-email")
    public WebElement input_email;
	
	@FindBy(how = How.ID, using = "timezone-simple")
    public WebElement click_timezone;
	
	@FindBy(how = How.XPATH, using = "//li[@data-value='Asia/Kolkata']")
    public WebElement select_timezone;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Enter system settings']")
    public WebElement enterPortalSettingsText;
	
	@FindBy(how = How.ID, using = "name")
    public WebElement enterSystemSettingsName;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Deploy' and @class='jss75 jss84 jss4060 jss4066 jss4061']")
    public WebElement deployText;
	
	
	
}
