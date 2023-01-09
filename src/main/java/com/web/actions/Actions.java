package com.web.actions;

import com.driver.DriverType;

public class Actions extends WebActions{
		
	public Actions(DriverType driverType) {
		getDriverObject(driverType);
	}
	
}
