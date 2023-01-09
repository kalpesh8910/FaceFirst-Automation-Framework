package com.FaceFirst.web.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageLocators {
			
	@FindBy(how = How.ID, using = "username")
    public WebElement username;
	
	@FindBy(how = How.ID, using = "password")
    public WebElement password;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),\"Login\")]")
    public WebElement loginbutn;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),\"Welcome to the FaceFirst platform!\")]")
    public WebElement welcomeMsgAfterLogin;
	
	@FindBy(how = How.XPATH, using = "//*[text()='Invalid username or password']")
	public WebElement errorMsgforInvalidCredential;
}
