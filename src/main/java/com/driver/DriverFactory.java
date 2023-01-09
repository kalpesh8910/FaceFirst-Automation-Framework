package com.driver;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory implements Driver{
		
	public WebDriver driver;
	private WebDriverWait waitDriver;
	public final static int TIMEOUT = 60;
	public final static int WAIT_TIMEOUT = 10;
	private static final Logger logger = LogManager.getLogger(DriverFactory.class.getName());
	
	public WebDriver getDriverObject(DriverType driverType) {
		
			try{
				if(driverType.name().equalsIgnoreCase("FirefoxDriver")){
					WebDriverManager.firefoxdriver().setup();
					this.driver = new FirefoxDriver();
				}

				else if(driverType.name().equalsIgnoreCase("ChromeDriver")) {
					ChromeOptions chromeOptions = new ChromeOptions();
		            chromeOptions.addArguments("--disable-notifications");
		            WebDriverManager.chromedriver().setup();
		            this.driver = new ChromeDriver(chromeOptions);
		            
		            this.driver.manage().window().maximize();
		            this.driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT, TimeUnit.SECONDS);
		            this.driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);
		            this.driver.manage().timeouts().setScriptTimeout(TIMEOUT, TimeUnit.SECONDS);
		            this.waitDriver = new WebDriverWait(driver, TIMEOUT);
				}
				
				else if(driverType.name().equalsIgnoreCase("InternetExplorerDriver")) {
					 WebDriverManager.iedriver().setup();
					 this.driver = new InternetExplorerDriver();
				}

				else if(driverType.name().equalsIgnoreCase("EdgeDriver")) {
					WebDriverManager.edgedriver().setup();
					this.driver = new EdgeDriver();
				}
				
			}catch(Exception e){
				e.printStackTrace();
				logger.info("InstantiateDriverObject Exception Log: " + e.toString());
			}
			logger.info("Instantiate " + driverType.name());
			return this.driver;
		}
	
	public WebDriverWait getWaitDriver() {
		return this.waitDriver;
	}

}
