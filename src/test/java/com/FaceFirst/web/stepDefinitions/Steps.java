
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

import com.FaceFirst.web.actions.ClientLoginPageActions;
import com.FaceFirst.web.actions.DeployPageActions;
import com.FaceFirst.web.actions.HomePageActions;
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
	HomePageActions homePageActions;
	DeployPageActions deployPageActions;
	ClientLoginPageActions clientLoginPageActions;
		
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
     	this.homePageActions = new HomePageActions(this.WebTestActions);
     	this.deployPageActions = new DeployPageActions(this.WebTestActions);
     	this.clientLoginPageActions = new ClientLoginPageActions(this.WebTestActions);

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
    
    
    //****************************************
  	// Home page Face First
  	//****************************************
    
    @When("user logged in successfully and closed the pop-up")
    public void user_logged_in_successfully_and_closed_the_pop_up() throws InterruptedException {
    	loginPageActions.enterusername();
    	loginPageActions.enterpassword();
    	loginPageActions.ClickloginBtn();
    	Thread.sleep(2000);
    	homePageActions.clickCloseButtonPopup();
    }
 
    @Then("verify if user have no license key then user will enter license key")
    public void verify_if_user_have_no_license_key_then_user_will_enter_license_key() throws InterruptedException {
    	Thread.sleep(5000);
       homePageActions.checkLicenseStatus();
    }
    
  //****************************************
  // Deploy page Face First
  //****************************************
  
    @When("click on deployment wizerd")
    public void click_on_deployment_wizerd() throws InterruptedException {
    	
    	deployPageActions.deploymentWizerd();
    	
    }

    @When("user select all in one deployment type")
    public void user_select_all_in_one_deployment_type() {
       
    }

    @When("click on next button")
    public void click_on_next_button() {
       
    }

    @Then("user should be navigated to select cameras tab")
    public void user_should_be_navigated_to_select_cameras_tab() {
      
    }

    @Then("user should be navigated to Enter portal settings")
    public void user_should_be_navigated_to_enter_portal_settings() {
       
    }

    @Then("enter username, password and confirm password")
    public void enter_username_password_and_confirm_password() {
      
    }

    @Then("enter email address")
    public void enter_email_address() {
       
    }

    @Then("select timezone")
    public void select_timezone() {
      
    }

    @Then("user should be navigated to Enter system settings")
    public void user_should_be_navigated_to_enter_system_settings() {
       
    }

    @Then("enter name")
    public void enter_name() {
       
    }

    @Then("click on deploy")
    public void click_on_deploy() {
      
    }
    
    //****************************************
    // User (Client) page Face First
    //****************************************
    
    @When("click on Portal URL")
    public void click_on_portal_url() {
       
    	clientLoginPageActions.clickPortalLink();
    }

    @When("enter client username")
    public void enter_client_username() {
       
    	clientLoginPageActions.enterClientUsername();
    }

    @When("enter client password")
    public void enter_client_password() {
       
    	clientLoginPageActions.enterClientPassword();
    }

    @When("click on users button")
    public void click_on_users_button() {
     
    	clientLoginPageActions.clickUserButton();
    }

    @Then("verify Users text and Enabled text should be displayed")
    public void verify_users_text_and_enabled_text_should_be_displayed() throws InterruptedException {
       
    	Thread.sleep(1000);
    	clientLoginPageActions.verifyUserEnabledText();
    }

    @Then("click on logout button")
    public void click_on_logout_button() throws InterruptedException {
      
    	Thread.sleep(2000);
    	clientLoginPageActions.clickLogoutButton();
    }

    @When("click on event user")
    public void click_on_event_user() {
       
    	clientLoginPageActions.clickEnventButton();
    }

    @Then("verify Event text")
    public void verify_event_text() {
       
    	clientLoginPageActions.verifyEventtext();
    }
    
}