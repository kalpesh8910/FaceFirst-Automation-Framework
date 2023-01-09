package com.web.actions;

import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.driver.DriverFactory;

public abstract class WebJavaActions extends DriverFactory{

	private static final Logger logger = LogManager.getLogger(WebJavaActions.class.getName());
    
    public boolean compareString(String First, String Second) {
        if (First.equalsIgnoreCase(Second)) {
        	logger.info("Compare String : TRUE '" + First + "' and '" + Second);
            return true;
        } else {
        	logger.info("Compare String : FALSE '" + First + "' and '" + Second);
            return false;
        }

    }
    
    public boolean containsString(String First, String Second) {
        if (First.contains(Second)) {
        	logger.info("Contains String : TRUE '" + Second + "' in '" + First);
            return true;
        } else {
        	logger.info("Contains String : FALSE '" + Second + "' in '" + First);
            return false;
        }
    }    
    
    public String WebElementToString(WebElement webElement) {
    	try {
            return "-->" + webElement.toString().split(">")[1];
    	}catch(Exception e) {}
    	return "";
    }
    
    public String WebElementToString(List<WebElement> WebElements) {
    	try {
    		return "-->" + WebElements.toString().split(">")[1];
    	}catch(Exception e) {}
    	return "";
    }
    
    public JavascriptExecutor getJSExecutor() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		return js;
	}
    
    public String generateRandomString(int len) {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		//String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
	
    public String generateRandomNumbers(int len) {
		String chars = "0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}

}