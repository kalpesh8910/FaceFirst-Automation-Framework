package com.driver;

import org.openqa.selenium.WebDriver;

public interface Driver{
	
	WebDriver getDriverObject(DriverType driverType);
	
}