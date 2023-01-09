package com.FaceFirst.web.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * The Seleniumdriver class returns an instance of WebDriver and has methods for
 * teardown after the session has ended
 * 
 * @author AKHIL
 *
 */

public class Seleniumdriver {

	private static Seleniumdriver seleniumdriver;
	private static WebDriver driver;
	private static WebDriverWait waitDriver;
	public final static int TIMEOUT = 60;
	public final static int WAIT_TIMEOUT = 10;

	// returns an instance of the driver
	public static WebDriver getDriver() {
		return driver;
	}

	// the below method returns the webdriverwait instance to be used
	public static WebDriverWait getWaitDriver() {
		return waitDriver;
	}

	// navigate to a particular URL
	public static void openPage(String url) {
		driver.get(url);
	}

	// invokes the private constructor of the Seleniumdriver class
	public static void setUpDriver() {
		if (seleniumdriver == null)
			seleniumdriver = new Seleniumdriver();
	}

	// The tear down method is used to close an instance of the driver and quit it.
	public static void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
		seleniumdriver = null;
	}

	// the constructor is private and we have a method to invoke
	private Seleniumdriver() {
		WebDriverManager.chromedriver().setup();
		/*String driverPath = System.getProperty("user.dir") + "/src/test/resources/tools/web/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",driverPath);*/

		// Set desirable options, e.g.
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("â€“-disable-application-cache");
		options.addArguments("--disable-default-apps");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--no-sandbox");
		options.addArguments("--window-size=1920,1080");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(TIMEOUT, TimeUnit.SECONDS);
		waitDriver = new WebDriverWait(driver, TIMEOUT);

	}

}
