package com.FaceFirst.web.actions;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.support.PageFactory;

import com.FaceFirst.web.locators.DeployPageLocator;
import com.FaceFirst.web.locators.HomePageLocator;
import com.FaceFirst.web.locators.LoginPageLocators;
import com.FaceFirst.web.utilities.ConfigReader;
import com.FaceFirst.web.utilities.TestDataUtil;
import com.web.actions.Actions;

public class DeployPageActions {

	ConfigReader configReader = new ConfigReader();
	TestDataUtil testdata = new TestDataUtil();
	// ****************************************************
	DeployPageLocator deployPageLocator;

	Actions WebTestActions;
	// private static final Logger logger =
	// LogManager.getLogger(SignUpPageActions.class.getName());

	public DeployPageActions(Actions WebTestActions) {
		this.WebTestActions = WebTestActions;
		this.deployPageLocator = new DeployPageLocator();
		PageFactory.initElements(WebTestActions.driver, deployPageLocator);
		PageFactory.initElements(WebTestActions.driver, this);
	}

	public void deploymentWizerd() {

		WebTestActions.clickElement(deployPageLocator.deploymentWizardMenu);
	}

	public void select_allinOne() {

		WebTestActions.clickElement(deployPageLocator.allInOne);
	}

	public void clickNextButton() {

		WebTestActions.clickElement(deployPageLocator.nextButton);
	}

	public void verifySelectCameraText() {

		WebTestActions.VerifyObjectIsDisplayed(deployPageLocator.selectCameraText);
	}

	public void verifySelectPortalSeetingText() {

		WebTestActions.VerifyObjectIsDisplayed(deployPageLocator.portalSettingsText);
	}

	public void enterPortalUsername() {

		WebTestActions.writeText(configReader.configWeb.getProperty("PortalUsername"),
				deployPageLocator.input_username);
	}

	public void enterPortalPassword() {

		WebTestActions.writeText(configReader.configWeb.getProperty("PortalPassword"),
				deployPageLocator.input_password);
	}

	public void enterPortalConfirmPassword() {

		WebTestActions.writeText(configReader.configWeb.getProperty("PortalConfirmPassword"),
				deployPageLocator.input_confirmPassword);
	}

	public void enterPortalEmail() {

		WebTestActions.writeText(configReader.configWeb.getProperty("PortalEmail"), deployPageLocator.input_email);

	}

	public void select_Timezone() {

		WebTestActions.clickElement(deployPageLocator.click_timezone);
		WebTestActions.clickElement(deployPageLocator.select_timezone);

	}

	public void verifyEnterSystemSettingsText() {

		WebTestActions.VerifyObjectIsDisplayed(deployPageLocator.enterPortalSettingsText);
	}
	
	public void enterSystemSettingName() {

		WebTestActions.writeText(configReader.configWeb.getProperty("SystemsettingName"), deployPageLocator.enterSystemSettingsName);

	}
	
	public void verifyDeployText() {

		WebTestActions.VerifyObjectIsDisplayed(deployPageLocator.deployText);
	}
}
