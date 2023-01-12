package com.FaceFirst.web.actions;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.support.PageFactory;

import com.FaceFirst.web.locators.ClientLoginPageOptionsLocator;
import com.FaceFirst.web.locators.DeployPageLocator;
import com.FaceFirst.web.locators.HomePageLocator;
import com.FaceFirst.web.locators.LoginPageLocators;
import com.FaceFirst.web.utilities.ConfigReader;
import com.FaceFirst.web.utilities.TestDataUtil;
import com.web.actions.Actions;

public class ClientLoginPageOptionsActions {

	ConfigReader configReader = new ConfigReader();
	TestDataUtil testdata = new TestDataUtil();
	// ****************************************************
	DeployPageLocator deployPageLocator;
	ClientLoginPageOptionsLocator clientLoginPageOptionsLocator;
	
	Actions WebTestActions;
	// private static final Logger logger =
	// LogManager.getLogger(SignUpPageActions.class.getName());

	public ClientLoginPageOptionsActions(Actions WebTestActions) {
		this.WebTestActions = WebTestActions;
		this.clientLoginPageOptionsLocator = new ClientLoginPageOptionsLocator();
		PageFactory.initElements(WebTestActions.driver, clientLoginPageOptionsLocator);
		PageFactory.initElements(WebTestActions.driver, this);
	}

	public void clickPortalLink() {
		
		WebTestActions.clickElement(clientLoginPageOptionsLocator.portalLink);
		WebTestActions.windowSwitching();
		
	}
	public void enterClientUsername() {
		
		WebTestActions.writeText(configReader.configWeb.getProperty("PortalUsername"), clientLoginPageOptionsLocator.input_ClientUsername);;
	}
	
	public void enterClientPassword() {
		
		WebTestActions.writeText(configReader.configWeb.getProperty("PortalPassword"), clientLoginPageOptionsLocator.input_ClientPassword);;
	}
	
	public void clickUserButton() {
		
		WebTestActions.clickElement(clientLoginPageOptionsLocator.User_button);
	}
	
	public void verifyUserEnabledText() {
		
		WebTestActions.VerifyObjectIsDisplayed(clientLoginPageOptionsLocator.user_Text);
		WebTestActions.VerifyObjectIsDisplayed(clientLoginPageOptionsLocator.Enabled_text);

	}
	
	public void clickLogoutButton() {
		
		WebTestActions.clickElement(clientLoginPageOptionsLocator.logout_button);
	}
	
	public void clickEnventButton() {
		
		WebTestActions.clickElement(clientLoginPageOptionsLocator.event_Button);
	}
	
	public void verifyEventtext() {
		
		WebTestActions.clickElementJS(clientLoginPageOptionsLocator.event_text);
	}
	
    public void clickIdentifyandEnroll(){
    	WebTestActions.clickElement(clientLoginPageOptionsLocator.identify_enroll_button);
    }
    
	public void verifyIdentifyandEnrollText() {
		
		WebTestActions.VerifyObjectIsDisplayed(clientLoginPageOptionsLocator.identifyEnroll_text);

	}
	
	public void clickAccountButton() {
		WebTestActions.clickElement(clientLoginPageOptionsLocator.account_button);
	}
	
	public void verifyAccountText() {
		
		WebTestActions.VerifyObjectIsDisplayed(clientLoginPageOptionsLocator.account_text);

	}
	
	
    
}
