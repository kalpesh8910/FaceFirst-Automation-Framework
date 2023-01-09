package com.FaceFirst.web.actions;

import org.openqa.selenium.support.PageFactory;

import com.FaceFirst.web.locators.LoginPageLocators;
import com.FaceFirst.web.utilities.ConfigReader;
import com.FaceFirst.web.utilities.TestDataUtil;
import com.web.actions.Actions;

public class LoginPageActions {
	
	ConfigReader configReader = new ConfigReader();
	TestDataUtil testdata = new TestDataUtil();
	//****************************************************
	LoginPageLocators loginPageLocators;
	
	Actions WebTestActions;
	//private static final Logger logger = LogManager.getLogger(SignUpPageActions.class.getName());

	public LoginPageActions(Actions WebTestActions) {
		this.WebTestActions = WebTestActions;
		this.loginPageLocators = new LoginPageLocators();
		PageFactory.initElements(WebTestActions.driver, loginPageLocators);
		PageFactory.initElements(WebTestActions.driver, this);
	}

	public void enterusername() throws InterruptedException
	{
		Thread.sleep(8000);
		loginPageLocators.username.sendKeys((configReader.configWeb.getProperty("username")));
		Thread.sleep(4000);
	}

	public void enterpassword() throws InterruptedException
	{
		WebTestActions.writeText(configReader.configWeb.getProperty("password"), loginPageLocators.password);
		Thread.sleep(4000);
	}
	
	public void ClickloginBtn() throws InterruptedException
	{
		WebTestActions.clickElement(loginPageLocators.loginbutn);
		Thread.sleep(4000);
	}
	
	public void verifymsgAfterlogin()
	{
		WebTestActions.VerifyObjectIsDisplayed(loginPageLocators.welcomeMsgAfterLogin);
	}
	
	public void enterInvalidUsername()
	{
		WebTestActions.writeText(configReader.configWeb.getProperty("invalidusername"), loginPageLocators.username);
	}
	
	public void enterInvalidPassword()
	{
		WebTestActions.writeText(configReader.configWeb.getProperty("invalidpassword"), loginPageLocators.password);
	}
	
	public void verifyErrorMessageInvalidCredential()

	{
		WebTestActions.VerifyObjectIsDisplayed(loginPageLocators.errorMsgforInvalidCredential);
	}
}
