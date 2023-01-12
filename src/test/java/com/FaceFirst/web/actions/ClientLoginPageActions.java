package com.FaceFirst.web.actions;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.support.PageFactory;

import com.FaceFirst.web.locators.ClientLoginPageLocator;
import com.FaceFirst.web.locators.ClientLoginPageOptionsLocator;
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

	public void enterWrongClientUsername() {

		WebTestActions.writeText(configReader.configWeb.getProperty("PortalInvalidUsername"),
				clientLoginPageLocator.input_ClientUsername);
	}

	public void enterWrongClientPassword() {

		WebTestActions.writeText(configReader.configWeb.getProperty("PortalInvalidPassword"),
				clientLoginPageLocator.input_ClientPassword);
	}

	public void clickEnterButton() {
		WebTestActions.Enter(clientLoginPageLocator.input_ClientPassword);
	}

	public void verifySuccessfulClintLogin() {
		WebTestActions.VerifyObjectIsDisplayed(clientLoginPageLocator.verify_facefirstLogo);
	}

	public void verifyValidationMsgInvalidLogin() {
		WebTestActions.VerifyObjectIsDisplayed(clientLoginPageLocator.verify_validation_msg);
	}

}
