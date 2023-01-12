package com.FaceFirst.web.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageLocator {
			
	@FindBy(how = How.XPATH, using = "//span[text()='Close']")
    public WebElement closePopUpButton;
	
	@FindBy(how = How.ID, using = "customerId")
    public WebElement customerID_input;
	
	@FindBy(how = How.XPATH, using = "//p[text()='No license']")
    public WebElement noLicense;
	
	@FindBy(how = How.XPATH, using = "//*[@class='jss171'] //*[@class='jss26 jss29 jss27 jss179 jss172'] //*[@class='jss133 jss134 jss174'] //*[@class='jss138'] //*[@class='jss186'] //button[@class='jss63 jss57'][@aria-label='Edit'] //span[@class='jss62'] //svg[@class='jss66']")
    public WebElement pencillicenseStatsus;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Save']")
    public WebElement saveBuuton;
	
	@FindBy(how = How.XPATH, using = "//p[text()='Expires in 21 days, 1,000 enrollments']")
    public WebElement ExpiresStatus;
	
	@FindBy(how = How.XPATH, using = "//div[@title='Deployment Wizard']")
    public WebElement deploymentWizardMenu;
	
	// **************Deployment types**************
	
	@FindBy(how = How.XPATH, using = "//span[text()='All-in-One']")
    public WebElement allInOne;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Core']")
    public WebElement core;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Advanced Core']")
    public WebElement advancesCore;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Next']")
    public WebElement nextButton;
	
	//********************Select cameras menu*************
	
	@FindBy(how = How.XPATH, using = "//h6[text()='Select cameras for DESKTOP-KDRQDOD']")
    public WebElement selectCamerasText;
	
	@FindBy(how = How.XPATH, using = "//span[text()='No cameras to display']")
    public WebElement noCameraDispalyText;
	
	// *****************************Enter portal settings*****************
	
	@FindBy(how = How.ID, using = "standard-username")
    public WebElement EditUsername;
	
}
