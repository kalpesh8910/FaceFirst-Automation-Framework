
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
import com.FaceFirst.web.actions.ClientLoginPageOptionsActions;
import com.FaceFirst.web.actions.DeployPageActions;
import com.FaceFirst.web.actions.EventGenerationEnd2EndFlowActions;
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
	ClientLoginPageActions clientLoginPageActions;
	HomePageActions homePageActions;
	DeployPageActions deployPageActions;
	ClientLoginPageOptionsActions clientLoginPageOptionsLocator;
	EventGenerationEnd2EndFlowActions eventGenerationEnd2EndFlowActions;
		
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
     	this.clientLoginPageActions = new ClientLoginPageActions(this.WebTestActions);
     	this.homePageActions = new HomePageActions(this.WebTestActions);
     	this.deployPageActions = new DeployPageActions(this.WebTestActions);
     	this.eventGenerationEnd2EndFlowActions = new EventGenerationEnd2EndFlowActions(this.WebTestActions);
     	this.clientLoginPageOptionsLocator = new ClientLoginPageOptionsActions(this.WebTestActions);

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
    // User (Client) Login page options Face First
    //****************************************
    
    @When("click on Portal URL")
    public void click_on_portal_url() {
       
    	clientLoginPageOptionsLocator.clickPortalLink();
    }

    @When("enter client username")
    public void enter_client_username() {
       
    	clientLoginPageOptionsLocator.enterClientUsername();
    }

    @When("enter client password")
    public void enter_client_password() {
       
    	clientLoginPageOptionsLocator.enterClientPassword();
    }

    @When("click on users button")
    public void click_on_users_button() {
     
    	clientLoginPageOptionsLocator.clickUserButton();
    }

    @Then("verify Users text and Enabled text should be displayed")
    public void verify_users_text_and_enabled_text_should_be_displayed() throws InterruptedException {
       
    	Thread.sleep(1000);
    	clientLoginPageOptionsLocator.verifyUserEnabledText();
    }

    @Then("click on logout button")
    public void click_on_logout_button() throws InterruptedException {
      
    	Thread.sleep(2000);
    	clientLoginPageOptionsLocator.clickLogoutButton();
    }

    @When("click on event user")
    public void click_on_event_user() {
       
    	clientLoginPageOptionsLocator.clickEnventButton();
    }

    @Then("verify Event text")
    public void verify_event_text() {
       
    	clientLoginPageOptionsLocator.verifyEventtext();
    }
    
    @When("click on Identify & Enroll")
    public void click_on_identify_enroll() {
    	clientLoginPageOptionsLocator.clickIdentifyandEnroll();
    }

    @Then("verify Identify & Enroll text")
    public void verify_identify_enroll_text() {
    	clientLoginPageOptionsLocator.verifyIdentifyandEnrollText();
    }

    @When("click on Account")
    public void click_on_account() {
    	clientLoginPageOptionsLocator.clickAccountButton();
    }

    @Then("verify Account text")
    public void verify_account_text() {
    	clientLoginPageOptionsLocator.verifyAccountText();
    }
    
    //****************************************
    // User (Client) Login page Face First
    //****************************************
    
    @When("press enter button")
    public void press_enter_button() {
    	clientLoginPageActions.clickEnterButton();
    }

    @Then("verify user successful login")
    public void verify_user_successful_login() {
    	clientLoginPageActions.verifySuccessfulClintLogin();
    }

    @When("enter client wrong username")
    public void enter_client_wrong_username() {
    	clientLoginPageActions.enterWrongClientUsername();
    }

    @When("enter client wrong password")
    public void enter_client_wrong_password() {
    	clientLoginPageActions.enterWrongClientPassword();
    }

    @Then("verify the validation message is displyed")
    public void verify_the_validation_message_is_displyed() {
    	clientLoginPageActions.verifyValidationMsgInvalidLogin();
    }
    
  //****************************************
  // Event Generation End 2 End flow Face First
  //****************************************
    
    @When("user login in clint login page")
    public void user_login_in_clint_login_page() {
    	clientLoginPageOptionsLocator.enterClientUsername();
    	clientLoginPageOptionsLocator.enterClientPassword();
    	clientLoginPageActions.clickEnterButton();
    	clientLoginPageActions.verifySuccessfulClintLogin();
    	
    }

    @When("user click on visitors menu iteam")
    public void user_click_on_visitors_menu_iteam() {
    	eventGenerationEnd2EndFlowActions.clickOnVisitorMenu();
    }

    @Then("visitor tab is opened")
    public void visitor_tab_is_opened() {
    	eventGenerationEnd2EndFlowActions.verifyVisitorTab();
    }

    @When("user click on criminal visitor photo")
    public void user_click_on_criminal_visitor_photo() {
    	eventGenerationEnd2EndFlowActions.clickCriminalPhoto();
    }

    @Then("visitor photo view tab is opened")
    public void visitor_photo_view_tab_is_opened() {
    	eventGenerationEnd2EndFlowActions.verifyVisitorPhotoTab();
    }

    @When("user click on Identify within Enrollments")
    public void user_click_on_identify_within_enrollments() throws Throwable {
    	eventGenerationEnd2EndFlowActions.clickOnIdentifyWithinEnrollments();
    }

    @Then("Identify and Enroll tab is opened")
    public void identify_and_enroll_tab_is_opened() {
    	eventGenerationEnd2EndFlowActions.verifyIdentifyAndEnrollTab();
    }

    @When("visitor photo is no matches found then Add Details tab is opened")
    public void visitor_photo_is_no_matches_found_then_add_details_tab_is_opened() throws Throwable {
    	eventGenerationEnd2EndFlowActions.addCriminalDetails();
    }

    @When("user enter all required and optional fields and save the deatils")
    public void user_enter_all_required_and_optional_fields_and_save_the_deatils() {
    	eventGenerationEnd2EndFlowActions.enterCriminalAllDetails();
    }

    @Then("Enrollment success meassage is displyed")
    public void enrollment_success_meassage_is_displyed() {
    	eventGenerationEnd2EndFlowActions.enrollmentSuccessMeassageVerify();
    }

    @When("user navigate to events menu iteam")
    public void user_navigate_to_events_menu_iteam() {
    	eventGenerationEnd2EndFlowActions.navigateToEventsMenu();
    }

    @Then("Event tab is opened")
    public void event_tab_is_opened() {
    	eventGenerationEnd2EndFlowActions.verifyEventTab();
    }

    @When("same criminal is visiting again")
    public void same_criminal_is_visiting_again() throws Throwable {
    	eventGenerationEnd2EndFlowActions.criminalIsVisitingAgain();
    }

    @Then("Event should be genrated")
    public void event_should_be_genrated() throws Throwable {
    	eventGenerationEnd2EndFlowActions.verifyEventGenration();
    }
    
    
    
    
    
    
    
    
    
    
    
    
}