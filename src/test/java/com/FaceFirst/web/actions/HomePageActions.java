package com.FaceFirst.web.actions;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.support.PageFactory;

import com.FaceFirst.web.locators.HomePageLocator;
import com.FaceFirst.web.locators.LoginPageLocators;
import com.FaceFirst.web.utilities.ConfigReader;
import com.FaceFirst.web.utilities.TestDataUtil;
import com.web.actions.Actions;

public class HomePageActions {
	
	ConfigReader configReader = new ConfigReader();
	TestDataUtil testdata = new TestDataUtil();
	//****************************************************
	HomePageLocator homePageLocators;
	
	Actions WebTestActions;
	//private static final Logger logger = LogManager.getLogger(SignUpPageActions.class.getName());

	public HomePageActions(Actions WebTestActions) {
		this.WebTestActions = WebTestActions;
		this.homePageLocators = new HomePageLocator();
		PageFactory.initElements(WebTestActions.driver, homePageLocators);
		PageFactory.initElements(WebTestActions.driver, this);
	}

	public void clickCloseButtonPopup(){
		
		WebTestActions.clickElement(homePageLocators.closePopUpButton);
		
	}
	
	public void checkLicenseStatus() {
		
		WebTestActions.clickElementJS(homePageLocators.pencillicenseStatsus);
		/*
		 * if(homePageLocators.ExpiresStatus.isDisplayed()) {
		 * 
		 * WebTestActions.clickElement(homePageLocators.pencillicenseStatsus);
		 * WebTestActions.writeText(configReader.configWeb.getProperty("licenseKey")
		 * ,homePageLocators.customerID_input);
		 * WebTestActions.clickElement(homePageLocators.saveBuuton);
		 * 
		 * }else {
		 * 
		 * System.out.println("User already have a license key...."); }
		 */
		
	}
}
