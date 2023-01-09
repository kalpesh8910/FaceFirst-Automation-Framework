package com.web.actions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public abstract class WebBrowserActions extends WebJavaActions{

	private static final Logger logger = LogManager.getLogger(WebBrowserActions.class.getName());
	
	public String PageTitle() {
        String PageTitle = null;
		try {
			PageTitle = driver.getTitle();
            logger.info("PageTitle: " + PageTitle);
            return PageTitle;
        } catch (Exception e) {
        	logger.info("Exception: PageTitle.");
			logger.info("Exception Log: " + e.toString());
            return PageTitle;
        }
    }
	
    /**
     * This keyword closes all the open browser sessions started by Selenium. It
     * does not take any input argument.
     *
     * @return
     */
    public boolean CloseAllBrowsers() {
        try {
            driver.quit();
            logger.info("Close All Browsers.");
            return true;
        } catch (Exception e) {
        	logger.info("Exception: CloseAllBrowsers.");
			logger.info("Exception Log: " + e.toString());
            return false;
        }
    }

    /**
     * This keyword closes the currently opened browser session.
     *
     * @return
     */
    public boolean CloseBrowser() {
        try {
            driver.close();
            logger.info("closes the currently opened browser session.");
            return true;
        } catch (Exception e) {
        	logger.info("Exception: CloseBrowser.");
			logger.info("Exception Log: " + e.toString());
            return false;
        }
    }

    /**
     * This keyword closes the selected window. It takes title name of the
     * window to be closed as data input argument.
     *
     * @param title
     * @return
     */
    public boolean CloseSelectedWindow(String title) {
        String currentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        logger.info("Closes the selected window " + title);
        for (String window : windows) {
            if (driver.switchTo().window(window).getTitle().equals(title)) {
                driver.close();
                return true;
            } else {
                driver.switchTo().window(currentWindow);
                return false;
            }

        }
        return false;
    }
    
    /**
     * This keyword navigates back to previous page and then wait for specified
     * seconds.
     *
     * @param seconds
     * @return
     */
    public boolean GoBackAndWait(long seconds) {
        try {
            driver.navigate().back();
            logger.info("Go Back And Wait");
            TimeUnit.SECONDS.sleep(seconds);
            return true;
        } catch (Exception e) {
        	logger.info("Exception: GoBackAndWait.");
			logger.info("Exception Log: " + e.toString());
            return false;
        }
    }

    /**
     * This keyword navigates forward to next browser page.
     *
     * @return
     */
    public boolean GoForward() {
        try {
            driver.navigate().forward();
            // TimeUnit.SECONDS.sleep(seconds);
            logger.info("Go Forward");
            return true;
        } catch (Exception e) {
        	logger.info("Exception: GoForward.");
			logger.info("Exception Log: " + e.toString());
            return false;
        }
    }

    /**
     * This keyword navigates forward to next browser page and waits for
     * specified time. It takes timeout (sec) as input parameter.
     *
     * @param seconds
     * @return
     */
    public boolean GoForwardAndWait(long seconds) {
        try {
            driver.navigate().forward();
            logger.info("Go Forward And Wait");
            TimeUnit.SECONDS.sleep(seconds);
            return true;
        } catch (Exception e) {
        	logger.info("Exception: GoForwardAndWait.");
			logger.info("Exception Log: " + e.toString());
            return false;
        }
    }
    
    /**
     * This keyword maximizes the current browser.
     *
     * @return
     */
    public boolean MaximizeBrowser() {
        try {
            driver.manage().window().maximize();
            logger.info("Maximizes the current browser");
            return true;
        } catch (Exception e) {
        	logger.info("Exception: MaximizeBrowser");
			logger.info("Exception Log: " + e.toString());
            return false;
        }
    }
    
    /**
     * This keyword refreshes the current browser session.
     *
     * @return
     */
    public boolean RefreshBrowser() {
        try {
            driver.navigate().refresh();
            //driver.get(driver.getCurrentUrl());
            //driver.findElement(By.xpath(".//a")).sendKeys(Keys.F5);
            logger.info("refreshes the current browser session");
            return true;
        } catch (Exception e) {
        	logger.info("Exception: RefreshBrowser");
			logger.info("Exception Log: " + e.toString());
            return false;
        }

    }

    /**
     * This keyword refreshes the browser page and waits for the given timeout.
     * This keyword takes timeout (in seconds) to wait after refreshing the
     * page.
     *
     * @param seconds
     * @return
     */
    public boolean RefreshAndWait(long seconds) {
        try {
            driver.navigate().refresh();
            logger.info("Refreshes the browser page and waits for the given timeout");
            TimeUnit.SECONDS.sleep(seconds);
            return true;
        } catch (Exception e) {
        	logger.info("Exception: RefreshAndWait");
			logger.info("Exception Log: " + e.toString());
            return false;
        }

    }
    
    public boolean OpenNewTab() {
        try {
            driver.findElement(By.xpath(".//a")).sendKeys(Keys.CONTROL, "t");
            logger.info("Open New Tab");
            return true;
        } catch (Exception e) {
        	logger.info("Exception: OpenNewTab");
			logger.info("Exception Log: " + e.toString());
            return false;
        }
    }
    
    public boolean CloseAllOpenedTabsExceptFirstTab() {
        try {
        	String originalHandle = driver.getWindowHandle();
            for(String handle : driver.getWindowHandles()) {
                if (!handle.equals(originalHandle)) {
                    driver.switchTo().window(handle);
                    driver.close();
                }
            }

            driver.switchTo().window(originalHandle);
            logger.info("Close All Opened Tabs Except First Tab");
            return true;
        } catch (Exception e) {
        	logger.info("Exception: Close All Opened Tabs Except First Tab");
			logger.info("Exception Log: " + e.toString());
            return false;
        }
    }
    
}