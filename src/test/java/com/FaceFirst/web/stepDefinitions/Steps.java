
package com.FaceFirst.web.stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeoutException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.FaceFirst.web.actions.LoginPageActions;
import com.FaceFirst.web.utilities.ConfigReader;
import com.FaceFirst.web.utilities.TestDataUtil;
import com.driver.DriverType;
import com.google.common.base.Verify;
import com.web.actions.Actions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	
	LoginPageActions loginPageActions;
	
	ConfigReader configReader = new ConfigReader();
	TestDataUtil testdata = new TestDataUtil();

	private String TestdataFile = System.getProperty("user.dir") + configReader.configWeb.getProperty("TestDataXLFile");
	private Actions WebTestActions;
	private static final Logger logger = LogManager.getLogger(Steps.class.getName());

	//********************************************************************************************
	//********************************************************************************************

	@Before
	public void setUpDriver() {
		//Seleniumdriver.setUpDriver();
		this.WebTestActions = new Actions(DriverType.ChromeDriver);
     	this.loginPageActions = new LoginPageActions(this.WebTestActions);

	}
	
	@Before
	public void PrintScenarioName(Scenario scenario) throws IOException {
		System.out.println("Executing --> " + scenario.getName());
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		File screenshot = ((TakesScreenshot) WebTestActions.driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
		scenario.attach(fileContent, "image/png", scenario.getName().toString());
		}
	
	@After
	public void tearDown(Scenario scenario) {
		//System.out.println(scenario.isFailed());
		WebTestActions.CloseBrowser();
	}
	
    
    //****************************************
  	// Login page Face First
  	//****************************************
    
    @Given("user navigate to the FaceFirst Website")
    public void user_navigate_to_the_orange_hrm_website() {
    	WebTestActions.navigateToURL(configReader.configWeb.getProperty("webURL"));
    	
    }
    
    @When("user enter right username")
    public void user_enter_right_username() throws InterruptedException {
    	
    	loginPageActions.enterusername();
    }

    @When("user enter right password")
    public void user_enter_right_password() throws InterruptedException {
    	loginPageActions.enterpassword();
    }

   
    @When("user click on login button")
    public void user_click_on_login_button() throws InterruptedException {
    	loginPageActions.ClickloginBtn();
    }

    @Then("verify user should be successfully login and redirected on welcome page")
    public void verify_user_should_be_successfully_login_and_redirected_on_dashborad_page() {
       loginPageActions.verifymsgAfterlogin();
    }
    
    @When("user enter invalid username")
    public void user_enter_invalid_username() {
       loginPageActions.enterInvalidUsername();
    }

    @When("user enter invalid password")
    public void user_enter_invalid_password() {
       loginPageActions.enterInvalidPassword();
    }

    @Then("verify validation message for the invalid username and password")
    public void verify_validation_message_for_the_invalid_username_and_password() {
    	loginPageActions.verifyErrorMessageInvalidCredential();
    }
}