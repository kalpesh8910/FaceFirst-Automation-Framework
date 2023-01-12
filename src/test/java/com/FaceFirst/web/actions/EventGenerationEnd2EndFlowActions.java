package com.FaceFirst.web.actions;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.FaceFirst.web.locators.DeployPageLocator;
import com.FaceFirst.web.locators.EventGenerationEnd2EndFlowLocator;
import com.FaceFirst.web.utilities.ConfigReader;
import com.FaceFirst.web.utilities.TestDataUtil;
import com.web.actions.Actions;

import freemarker.core.JavaScriptOutputFormat;

public class EventGenerationEnd2EndFlowActions {

	ConfigReader configReader = new ConfigReader();
	TestDataUtil testdata = new TestDataUtil();
	WebDriver driver;
	// ****************************************************
	DeployPageLocator deployPageLocator;
	EventGenerationEnd2EndFlowLocator eventGenerationEnd2EndFlowLocator;

	Actions WebTestActions;
	// private static final Logger logger =
	// LogManager.getLogger(SignUpPageActions.class.getName());

	public EventGenerationEnd2EndFlowActions(Actions WebTestActions) {
		this.WebTestActions = WebTestActions;
		this.eventGenerationEnd2EndFlowLocator = new EventGenerationEnd2EndFlowLocator();
		PageFactory.initElements(WebTestActions.driver, eventGenerationEnd2EndFlowLocator);
		PageFactory.initElements(WebTestActions.driver, this);
	}

	public void clickOnVisitorMenu() {
		WebTestActions.clickElement(eventGenerationEnd2EndFlowLocator.visitor_button);
	}

	public void verifyVisitorTab() {
		WebTestActions.VerifyObjectIsDisplayed(eventGenerationEnd2EndFlowLocator.visitor_tab_verify);
	}

	public void clickCriminalPhoto() {
		WebTestActions.clickElement(eventGenerationEnd2EndFlowLocator.criminal_visitor_img);
	}

	public void verifyVisitorPhotoTab() {
		WebTestActions.VerifyObjectIsDisplayed(eventGenerationEnd2EndFlowLocator.criminal_photo_view);
	}

	public void clickOnIdentifyWithinEnrollments() throws InterruptedException {
		WebTestActions.clickElement(eventGenerationEnd2EndFlowLocator.visitor_action_button);
		Thread.sleep(2000);
		WebTestActions.clickElement(eventGenerationEnd2EndFlowLocator.identify_within_Enrollments_button);

	}

	public void verifyIdentifyAndEnrollTab() {
		WebTestActions.VerifyObjectIsDisplayed(eventGenerationEnd2EndFlowLocator.identify_within_Enrollments_verify);
	}

	public void addCriminalDetails() throws Throwable{
		Thread.sleep(5000);
		if(eventGenerationEnd2EndFlowLocator.no_match_found_msg.isDisplayed()) {
			WebTestActions.VerifyObjectIsDisplayed(eventGenerationEnd2EndFlowLocator.add_criminal_details_tab);
		}	
	}

	public void enterCriminalAllDetails() {

		WebTestActions.SelectByValue("DefaultEnrollmentGroup (Serious Offender - None)", eventGenerationEnd2EndFlowLocator.enrollment_group);
		WebTestActions.writeText("mumbai", eventGenerationEnd2EndFlowLocator.location_store);
		WebTestActions.writeText("kill 1 person", eventGenerationEnd2EndFlowLocator.case_subject);
		WebTestActions.writeText("500000", eventGenerationEnd2EndFlowLocator.reported_loss);
		WebTestActions.writeText("07122000 0625", eventGenerationEnd2EndFlowLocator.date_incident);
		WebTestActions.writeText("call police", eventGenerationEnd2EndFlowLocator.action_field);
		WebTestActions.clickElement(eventGenerationEnd2EndFlowLocator.save_button);

	}

	public void enrollmentSuccessMeassageVerify() {
		WebTestActions.VerifyObjectIsDisplayed(eventGenerationEnd2EndFlowLocator.enrollment_success_tab);
	}

	public void navigateToEventsMenu() {
		WebTestActions.clickElementJS(eventGenerationEnd2EndFlowLocator.close_enrollment_success_tab);
		//WebTestActions.clickElement(eventGenerationEnd2EndFlowLocator.close_enrollment_success_tab);
		WebTestActions.clickElementJS(eventGenerationEnd2EndFlowLocator.close_visitor_photo_view_tab);
		WebTestActions.clickElementJS(eventGenerationEnd2EndFlowLocator.close_visitor_tab);
		//WebTestActions.clickElement(eventGenerationEnd2EndFlowLocator.close_visitor_photo_view_tab);
	//	WebTestActions.clickElement(eventGenerationEnd2EndFlowLocator.close_visitor_tab);
		WebTestActions.clickElement(eventGenerationEnd2EndFlowLocator.cloud_menu);
		WebTestActions.clickElement(eventGenerationEnd2EndFlowLocator.event_menu);
	}

	public void verifyEventTab() {
		WebTestActions.VerifyObjectIsDisplayed(eventGenerationEnd2EndFlowLocator.event_tab_verify);		
	}

	public void criminalIsVisitingAgain() throws Throwable {
		WebTestActions.clickElement(eventGenerationEnd2EndFlowLocator.select_all_event_checkbox);
		Thread.sleep(4000);
		WebTestActions.clickElement(eventGenerationEnd2EndFlowLocator.event_action_button);
		Thread.sleep(4000);
		WebTestActions.clickElement(eventGenerationEnd2EndFlowLocator.delete_all_Event_button);
		Thread.sleep(4000);
		WebTestActions.clickElement(eventGenerationEnd2EndFlowLocator.delete_confirm_button);
		Thread.sleep(10000);
	}

	public void verifyEventGenration() throws Throwable {
		Thread.sleep(5000);
		WebTestActions.VerifyObjectIsDisplayed(eventGenerationEnd2EndFlowLocator.successful_event_genration);
	}







}
