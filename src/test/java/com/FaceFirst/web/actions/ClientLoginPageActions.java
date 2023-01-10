package com.FaceFirst.web.actions;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.support.PageFactory;

import com.FaceFirst.web.locators.ClientLoginPageLocator;
import com.FaceFirst.web.locators.DeployPageLocator;
import com.FaceFirst.web.locators.HomePageLocator;
import com.FaceFirst.web.locators.LoginPageLocators;
import com.FaceFirst.web.utilities.ConfigReader;
import com.FaceFirst.web.utilities.TestDataUtil;
import com.web.actions.Actions;

public class ClientLoginPageActions {

	ConfigReader configReader = new ConfigReader();
	TestDataUtil testdata = new TestDataUtil();
	// ****************************************************
	DeployPageLocator deployPageLocator;
	ClientLoginPageLocator clientLoginPageLocator;
	
	Actions WebTestActions;
	// private static final Logger logger =
	// LogManager.getLogger(SignUpPageActions.class.getName());

	public ClientLoginPageActions(Actions WebTestActions) {
		this.WebTestActions = WebTestActions;
		this.clientLoginPageLocator = new ClientLoginPageLocator();
		PageFactory.initElements(WebTestActions.driver, clientLoginPageLocator);
		PageFactory.initElements(WebTestActions.driver, this);
	}

	public void clickPortalLink() {
		
		WebTestActions.clickElement(clientLoginPageLocator.portalLink);
		WebTestActions.windowSwitching();
		
	}
	public void enterClientUsername() {
		
		WebTestActions.writeText(configReader.configWeb.getProperty("PortalUsername"), clientLoginPageLocator.input_ClientUsername);;
	}
	
	public void enterClientPassword() {
		
		WebTestActions.writeText(configReader.configWeb.getProperty("PortalPassword"), clientLoginPageLocator.input_ClientPassword);;
	}
	
	public void clickUserButton() {
		
		WebTestActions.clickElement(clientLoginPageLocator.User_button);
	}
	
	public void verifyUserEnabledText() {
		
		WebTestActions.VerifyObjectIsDisplayed(clientLoginPageLocator.user_Text);
		WebTestActions.VerifyObjectIsDisplayed(clientLoginPageLocator.Enabled_text);

	}
	
	public void clickLogoutButton() {
		
		WebTestActions.clickElement(clientLoginPageLocator.logout_button);
	}
	
	public void clickEnventButton() {
		
		WebTestActions.clickElement(clientLoginPageLocator.event_Button);
	}
	
	public void verifyEventtext() {
		
		WebTestActions.clickElementJS(clientLoginPageLocator.event_text);
	}
}
