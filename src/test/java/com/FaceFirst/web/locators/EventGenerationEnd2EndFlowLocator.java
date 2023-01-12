package com.FaceFirst.web.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EventGenerationEnd2EndFlowLocator {
			
	// **************Event Generation End 2 End Flow Locator**************

		
	@FindBy(how = How.XPATH, using = "//p[@class='posrel disblk fltlft' and text()='Visitors']")
    public WebElement visitor_button;
	
	@FindBy(how = How.XPATH, using = "//p[@class='posrel disblk fltlft' and text()='Visitors']")
    public WebElement visitor_tab_verify;
	
	@FindBy(how = How.XPATH, using = "(//img[@class='psuedo-back-img'])[1]")
    public WebElement criminal_visitor_img;
	
	@FindBy(how = How.XPATH, using = "//p[text()='Visitor - Photo View']")
    public WebElement criminal_photo_view;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Action')]")
    public WebElement visitor_action_button;
	
	@FindBy(how = How.XPATH, using = "//a[.='Identify within Enrollments']")
    public WebElement identify_within_Enrollments_button;
	
	
	@FindBy(how = How.XPATH, using = "/p[text()='Identify & Enroll' and @class='posrel fltlft disblk']")
    public WebElement identify_within_Enrollments_verify;
	
	@FindBy(how = How.XPATH, using = "(//div[text()='No matches found, enrolling...'])[2]")
    public WebElement no_match_found_msg;
	
	@FindBy(how = How.XPATH, using = "//p[text()='Add Details']")
    public WebElement add_criminal_details_tab;
	
	@FindBy(how = How.XPATH, using = "//select[@name='internal_group']")
    public WebElement enrollment_group;
	
	
	@FindBy(how = How.XPATH, using = "//input[@name='storeId']")
    public WebElement location_store;
	
	@FindBy(how = How.XPATH, using = "//input[@name='caseNumber']")
    public WebElement case_subject;
	
	@FindBy(how = How.XPATH, using = "//input[@name='reportedLoss']")
    public WebElement reported_loss;
	
	@FindBy(how = How.XPATH, using = "//input[@name='timeIncident']")
    public WebElement date_incident;
	
	@FindBy(how = How.XPATH, using = "//input[@name='action']")
    public WebElement action_field;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Save']")
    public WebElement save_button;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Enrollment Success' and @class='enroll-steps-title light-blue-bg']")
    public WebElement enrollment_success_tab;
	
	
	
	@FindBy(how = How.XPATH, using = "//div[@id='start-logo-container']")
    public WebElement cloud_menu;
	
	@FindBy(how = How.XPATH, using = "//p[text()='Events' and @class='login-menu-title tal posrel fltlft']")
    public WebElement event_menu;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Events' and @class='pull-left']")
    public WebElement event_tab_verify;
	
	@FindBy(how = How.XPATH, using = "//a[@class='btn dropdown-toggle pull-right toolbar-btn nav-pills-small']")
    public WebElement event_action_button;
	
	@FindBy(how = How.XPATH, using = "//a[@ng-click='deleteSelectedEventsClicked()']")
    public WebElement delete_all_Event_button;
	
	@FindBy(how = How.XPATH, using = "//input[@ng-model='selectAllCheckboxState']")
    public WebElement select_all_event_checkbox;
	
	@FindBy(how = How.XPATH, using = "//input[@ng-model='selectAllCheckboxState']")
    public WebElement delete_confirm_button;
	
	@FindBy(how = How.XPATH, using = "//div[@ng-style='dynamicRowHeightStyle']")
    public WebElement successful_event_genration;
	
	//close visitor tab//
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='main-container']/div[@id='x-scrolling-panel-container']/ul[@id='panel-container']/li[3]/div[1]/div[1]/div[1]/div[1]")
    public WebElement close_enrollment_success_tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id='large_view_7']/div[1]/div")
    public WebElement close_visitor_photo_view_tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id='aliens_6']/div[1]/div")
    public WebElement close_visitor_tab;
	
	
	
	
	
	
	
	
	
	
	
	
}
