package com.web.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public abstract class WebActions extends WebBrowserActions{

	private static final Logger logger = LogManager.getLogger(WebActions.class.getName());

    public void navigateToURL(String URL) {
    	try {
    		driver.navigate().to(URL);
            logger.info("Navigate to '" + URL);
    	}catch(Exception e) {
    		logger.info("Exception: Navigate to '" + URL);
    		logger.info("Exception Log: " + e.toString());
    		e.printStackTrace();
    	}
    }
    
    public void writeText(String data, WebElement WebElement) {
    	try {
    		ClearText(findWebElement(WebElement));
    		findWebElement(WebElement).sendKeys(data);
            logger.info("Write Text '" + data + "' on " + WebElementToString(WebElement));
    	}catch(Exception e) {
    		logger.info("Exception: Write Text '" + data + "' on " + WebElementToString(WebElement));
    		logger.info("Exception Log: " + e.toString());
    		e.printStackTrace();
    	}
    }
    
    public boolean clickElement(WebElement WebElement) {
    	try {
    		findWebElement(WebElement).click();
            logger.info("Click on :" + WebElementToString(WebElement));
            return true;
    	}catch(Exception e) {
    		logger.info("Exception: clickElement '" + WebElementToString(WebElement));
    		logger.info("Exception Log: " + e.toString());
    		//e.printStackTrace();
    		return false;
    	}    	
    }
    	
	public boolean clickElementJS(WebElement WebElement) {
		try {
			getJSExecutor().executeScript("arguments[0].click()", findWebElement(WebElement));
			logger.info("Click on :" + WebElementToString(WebElement));
            return true;
		}catch(Exception e) {
    		logger.info("Exception: clickElement '" + WebElementToString(WebElement));
    		logger.info("Exception Log: " + e.toString());
    		e.printStackTrace();
    		return false;
    	}
		
	}

    public String getObjectText(WebElement WebElement) {
        String ObjectText = null;
        try {
        	ObjectText = findWebElement(WebElement).getText();
            logger.info("Object Text : " + ObjectText + ", " +  WebElementToString(WebElement));
    	}catch(Exception e) {
    		logger.info("Exception: getObjectText '" + WebElementToString(WebElement));
    		logger.info("Exception Log: " + e.toString());
    		e.printStackTrace();
    	}
        return ObjectText;
    }
    
    public List<String> getObjectText(List<WebElement> WebElements) {
        List<String> ObjectTexts = new ArrayList<>();
        try {
        	for(WebElement element: WebElements) {
        	ObjectTexts.add(element.getText());
        	logger.info("Object Text : " + element.getText() + ", " +  WebElementToString(WebElements));}
    	}catch(Exception e) {
    		logger.info("Exception: getObjectText '" + WebElementToString(WebElements));
    		logger.info("Exception Log: " + e.toString());
    		e.printStackTrace();
    	}
        return ObjectTexts;
    }
        
    public void clickLink(String data) {
        try {
        	driver.findElement(By.linkText(data)).click();
            logger.info("Click on Link : " + data);
    	}catch(Exception e) {
    		logger.info("Exception: clickLink '" + data);
    		logger.info("Exception Log: " + e.toString());
    		e.printStackTrace();
    	}
    }
    
    public void clickPartialLinkText(String data) {
    	try {
	    	driver.findElement(By.partialLinkText(data)).click();
	        logger.info("Click on Link : " + data);
	    }catch(Exception e) {
			logger.info("Exception: clickPartialLinkText '" + data);
			logger.info("Exception Log: " + e.toString());
			e.printStackTrace();
		}
    }
    
    public void SelectByValue(String Value, WebElement WebElement) {
    	try {
    		clickElement(findWebElement(WebElement));
	        Select select = new Select(findWebElement(WebElement));
	        select.selectByValue(Value);
	        logger.info("Select By Value : " + Value + ", " + WebElementToString(WebElement)) ;
	    } catch (Exception e) {
	    	logger.info("Exception: SelectByValue: " + Value + ", " + WebElementToString(WebElement));
			logger.info("Exception Log: " + e.toString());
			//e.printStackTrace();
	    }
    }

    public void SelectByIndex(int Index, WebElement WebElement) {
    	try {
    		clickElement(findWebElement(WebElement));
	        Select select = new Select(findWebElement(WebElement));
	        select.selectByIndex(Index);
	        logger.info("Select By Index : " + Index + ", " + WebElementToString(WebElement)) ;
	    } catch (Exception e) {
	    	logger.info("Exception: SelectByIndex: " + Index + ", " + WebElementToString(WebElement));
			logger.info("Exception Log: " + e.toString());
			//e.printStackTrace();
	    }
    }
    
    public void SelectByVisibleText(String Text, WebElement WebElement) {
    	try {
    		clickElement(findWebElement(WebElement));
    		Select select = new Select(WebElement);
	        select.selectByVisibleText(Text);
	        logger.info("Select By Visible Text : [" + Text + "], " + WebElementToString(WebElement)) ;
	    } catch (Exception e) {
	    	logger.info("Exception: SelectByVisibleText: [" + Text + "], " + WebElementToString(WebElement));
			logger.info("Exception Log: " + e.toString());
			//e.printStackTrace();
	    }
    }

    public boolean selectdropdown(List<WebElement> WebElements, String value) {
        try {
            for (WebElement element : WebElements) {
                //System.out.println(element.getText());
                if (element.getText().contains(value)) {
                    //element.click();
                    clickElement(findWebElement(element));
                    logger.info("Select drop down by value : " + value + ", " + WebElementToString(WebElements)) ;
                }
            }
            return true;
        } catch (Exception e) {
        	logger.info("Exception: selectdropdown: " + value + ", " + WebElementToString(WebElements));
			logger.info("Exception Log: " + e.toString());
			//e.printStackTrace();
        }
        return false;
    }
    
    public String getFirstSelectedOption(WebElement WebElement) {
    	String FirstSelectedOption = null;
    	try {
    		clickElement(findWebElement(WebElement));
    		Select select = new Select(findWebElement(WebElement));
    		WebElement option = select.getFirstSelectedOption();
    		FirstSelectedOption = option.getText();
    		logger.info("First Selected Option value : " + FirstSelectedOption + ", " + WebElementToString(WebElement)) ;
    	} catch (Exception e) {
        	logger.info("Exception: FirstSelectedOption: " + WebElementToString(WebElement));
			logger.info("Exception Log: " + e.toString());
			//e.printStackTrace();
        }
		return FirstSelectedOption;
		
	}
    
    public List<WebElement> getDropdownOption(WebElement WebElement) {
    	List<WebElement> Options = null;
    	try {
    		clickElement(findWebElement(WebElement));
    		Select select = new Select(findWebElement(WebElement));
    		Options = select.getOptions();
    		logger.info("Dropdown Option : " + WebElementToString(WebElement)) ;
    	} catch (Exception e) {
        	logger.info("Exception: getDropdownOption: " + WebElementToString(WebElement));
			logger.info("Exception Log: " + e.toString());
			//e.printStackTrace();
        }
		return Options;
		
	}
    
    public boolean verifyObjectText(String Text, WebElement WebElement) {
        return compareString(Text, getObjectText(WebElement));
    }

    public boolean VerifyObjectIsDisplayed(WebElement WebElement) {
    	boolean ElementDisplayed = false;
    	try {    
    		ElementDisplayed = findWebElement(WebElement).isDisplayed();
	    	logger.info("Verify Object Exists : TRUE " + WebElementToString(WebElement));
	    	return ElementDisplayed;
	    }catch(Exception e) {
	    	logger.info("Verify Object Exists : FALSE " + WebElementToString(WebElement));
			return ElementDisplayed;
		}
    }
    
    public List<WebElement> getAllObjects(By by) {
    	List<WebElement> ObjectList  = null;
    	try {    
    		ObjectList = driver.findElements(by);
	    	logger.info("Get All Object Size : " + ObjectList.size() + " of " + by.toString());
	    	return ObjectList;
	    }catch(Exception e) {
	    	logger.info("Is Object Exists : FALSE " + by.toString());
			return ObjectList;
		}
    }

    public boolean VerifyObjectEnabled(WebElement WebElement) {
        boolean ElementEnabled  = false;
    	try {
    		ElementEnabled = findWebElement(WebElement).isEnabled();
	        logger.info("Verify Object Enabled : TRUE " + WebElementToString(WebElement));
	        return ElementEnabled;
	    }catch(Exception e) {
	    	logger.info("Verify Object Enabled : FALSE " + WebElementToString(WebElement));
            return ElementEnabled;
		}
    }
    
    public boolean VerifyObjectSelected(WebElement WebElement) {
    	 boolean ElementSelected  = false;
    	try {	
    		ElementSelected = findWebElement(WebElement).isSelected();
	        logger.info("Verify Object Selected : TRUE " + WebElementToString(WebElement));
	        return ElementSelected;
	    }catch(Exception e) {
	    	logger.info("Verify Object Selected : FALSE " + WebElementToString(WebElement));
            return ElementSelected;
		}
    }
    
    public String getobjectValue(WebElement WebElement) {
    	String ObjectText = null;
    	try {
    		ObjectText = findWebElement(WebElement).getAttribute("value");
    		logger.info("Get Object Value : '" + ObjectText + "' : " + WebElementToString(WebElement));
	    }catch(Exception e) {
			logger.info("Exception: getobjectValue '" + WebElementToString(WebElement));
			logger.info("Exception Log: " + e.toString());
			e.printStackTrace();
		}
    	return ObjectText;
    }

    public void ClearText(WebElement WebElement) {
    	try {
    		findWebElement(WebElement).clear();
	    	logger.info("Clear Text From : "  + WebElementToString(WebElement));
	    }catch(Exception e) {
			logger.info("Exception: ClearText '" + WebElementToString(WebElement));
			logger.info("Exception Log: " + e.toString());
			e.printStackTrace();
		}
    }

    public void ClickButtonAndWait(WebElement WebElement, long time) throws Exception {
    	try {
	    	clickElement(findWebElement(WebElement));
	        TimeUnit.SECONDS.sleep(time);
	        logger.info("Click Button And Wait :"  + WebElementToString(WebElement));
	    }catch(Exception e) {
			logger.info("Exception: ClickButtonAndWait '" + WebElementToString(WebElement));
			logger.info("Exception Log: " + e.toString());
			e.printStackTrace();
		}
    }
    
    public boolean MouseHover(WebElement WebElement) {
        try {
            new Actions(driver).moveToElement(findWebElement(WebElement)).perform();
            logger.info("MouseHover: " + WebElementToString(WebElement));
            return true;
        } catch (Exception e) {
        	logger.info("Exception: MouseHover " + WebElementToString(WebElement));
			logger.info("Exception Log: " + e.toString());
			e.printStackTrace();
            return false;
        }
    }
    
    public boolean MouseHoverAndClick(WebElement WebElement) {
        try {
            new Actions(driver).moveToElement(findWebElement(WebElement)).build().perform();
            
            logger.info("MouseHover: " + WebElementToString(WebElement));
            return true;
        } catch (Exception e) {
        	logger.info("Exception: MouseHover " + WebElementToString(WebElement));
			logger.info("Exception Log: " + e.toString());
			e.printStackTrace();
            return false;
        }
    }

    public boolean RightClickOnObject(WebElement WebElement) {
        try {
            new Actions(driver)
                    .contextClick(findWebElement(WebElement)).build().perform();
            logger.info("Right clicks on object" + WebElementToString(WebElement));
            return true;
        } catch (Exception e) {
        	logger.info("Exception: RightClickOnObject " + WebElementToString(WebElement));
			logger.info("Exception Log: " + e.toString());
			e.printStackTrace();
            return false;
        }

    }

    public boolean DoubleClick(WebElement WebElement) {
        try {
            new Actions(driver)
                    .doubleClick(findWebElement(WebElement)).build()
                    .perform();
            logger.info("Double Click on " + WebElementToString(WebElement));
            return true;
        } catch (Exception e) {
        	logger.info("Exception: DoubleClick." + WebElementToString(WebElement));
			logger.info("Exception Log: " + e.toString());
			e.printStackTrace();
            return false;
        }
    }

    public boolean DoubleClickAndWait(WebElement WebElement, long seconds) {
        try {
            new Actions(driver)
                    .doubleClick(WebElement).build()
                    .perform();
            TimeUnit.SECONDS.sleep(seconds);
            logger.info("Double Click and wait " + WebElementToString(WebElement));
            return true;
        } catch (Exception e) {
        	logger.info("Exception: DoubleClickAndWait." + WebElementToString(WebElement));
			logger.info("Exception Log: " + e.toString());
			e.printStackTrace();
            return false;
        }

    }

    public boolean DoubleClickAt(WebElement WebElement, int start, int end) {
        try {
            new Actions(driver)
                    .moveToElement(findWebElement(WebElement))
                    .moveByOffset(start, end).click().perform();
            logger.info("Double Click At " + WebElementToString(WebElement));
            return true;
        } catch (Exception e) {
        	logger.info("Exception: DoubleClickAt." + WebElementToString(WebElement));
			logger.info("Exception Log: " + e.toString());
			e.printStackTrace();
            return false;
        }
    }

    public boolean Enter(WebElement WebElement) {
        try {
        	findWebElement(WebElement).sendKeys(Keys.ENTER);
        	logger.info("Enter Key On " + WebElementToString(WebElement));
            return true;
        } catch (Exception e) {
        	logger.info("Exception: Enter Key." + WebElementToString(WebElement));
			logger.info("Exception Log: " + e.toString());
			e.printStackTrace();
            return false;
        }
    }

    public boolean pressESC(WebElement WebElement) {
        try {
        	findWebElement(WebElement).sendKeys(Keys.ESCAPE);
        	logger.info("ESCAPE Key On " + WebElementToString(WebElement));
            return true;
        } catch (Exception e) {
        	logger.info("Exception: pressESC." + WebElementToString(WebElement));
			logger.info("Exception Log: " + e.toString());
			e.printStackTrace();
            return false;
        }
    } 

    public boolean KeyLeft(WebElement WebElement) {
        try {
        	findWebElement(WebElement).sendKeys(Keys.ARROW_LEFT);
            logger.info("Key Left " + WebElementToString(WebElement));
            return true;
        } catch (Exception e) {
        	logger.info("Exception: KeyLeft " + WebElementToString(WebElement));
			logger.info("Exception Log: " + e.toString());
			e.printStackTrace();
            return false;
        }

    }

    public boolean KeyRight(WebElement WebElement) {
        try {
        	findWebElement(WebElement).sendKeys(Keys.RIGHT);
            logger.info("Key Right" + WebElementToString(WebElement));
            return true;
        } catch (Exception e) {
        	logger.info("Exception: KeyRight " + WebElementToString(WebElement));
			logger.info("Exception Log: " + e.toString());
			e.printStackTrace();
            return false;
        }

    }

    public boolean KeyDown(WebElement WebElement) {
        try {
            //driver.findElement(By.xpath(".//a")).sendKeys(Keys.ARROW_DOWN);
        	findWebElement(WebElement).sendKeys(Keys.ARROW_DOWN);
            logger.info("Key Down " + WebElementToString(WebElement));
            return true;
        } catch (Exception e) {
        	logger.info("Exception: KeyDown " + WebElementToString(WebElement));
			logger.info("Exception Log: " + e.toString());
			e.printStackTrace();
            return false;
        }

    }

    public boolean PageDown(int PageDownTimes) {
        try {
            while (PageDownTimes > 0) {
                driver.findElement(By.xpath(".//a")).sendKeys(Keys.PAGE_DOWN);
                PageDownTimes--;
            }
            logger.info("Page Down");
            return true;
        } catch (Exception e) {
        	logger.info("Exception: PageDown");
			logger.info("Exception Log: " + e.toString());
			e.printStackTrace();
            return false;
        }

    }

    public boolean PageUP(int PageUpTimes) {
        try {
            while (PageUpTimes > 0) {
                driver.findElement(By.xpath(".//a")).sendKeys(Keys.PAGE_UP);
                PageUpTimes--;
            }
            logger.info("Page Up ");
            return true;
        } catch (Exception e) {
        	logger.info("Exception: PageUP");
			logger.info("Exception Log: " + e.toString());
			e.printStackTrace();
            return false;
        }

    }

    public void waitForElementToBeClickable(WebElement WebElement) {
    	try {
    		getWaitDriver().until(ExpectedConditions.elementToBeClickable(findWebElement(WebElement)));
            logger.info("Wait For Element To Be Clickable: " + WebElementToString(WebElement));
    	}catch(Exception e) {
    		logger.info("Exception: waitForElementToBeClickable '" + WebElementToString(WebElement));
    		logger.info("Exception Log: " + e.toString());
    		e.printStackTrace();
    	}
    }
    
    public void waitForElementToBeVisibile(WebElement WebElement) {
    	try {
    		getWaitDriver().until(ExpectedConditions.visibilityOf(findWebElement(WebElement)));
            logger.info("Wait For Element To Be Visibile: " + WebElementToString(WebElement));
    	}catch(Exception e) {
    		logger.info("Exception: waitForElementToBeVisibile '" + WebElementToString(WebElement));
    		logger.info("Exception Log: " + e.toString());
    		e.printStackTrace();
    	}
    }
    
    public void waitForElementToBeInvisibile(WebElement WebElement) {
    	try {
    		getWaitDriver().until(ExpectedConditions.invisibilityOf(findWebElement(WebElement)));
            logger.info("Wait For Element To Be Visibile: " + WebElementToString(WebElement));
    	}catch(Exception e) {
    		logger.info("Exception: waitForElementToBeVisibile '" + WebElementToString(WebElement));
    		logger.info("Exception Log: " + e.toString());
    		e.printStackTrace();
    	}
    }
    
    public String AlertText() {
        String ObjectText = null;
        try {
        	ObjectText = driver.switchTo().alert().getText();
            logger.info("Alert Text : " + ObjectText );
    	}catch(Exception e) {
    		logger.info("Exception: AlertText '");
    		logger.info("Exception Log: " + e.toString());
    		e.printStackTrace();
    	}
        return ObjectText;
    }
    
    public boolean AlertDismiss() {
    	boolean AlertBoolean = false;
        try {
        	driver.switchTo().alert().dismiss();
        	AlertBoolean = true;
            logger.info("Alert Dismiss : " + AlertBoolean );
    	}catch(Exception e) {
    		logger.info("Exception: AlertBoolean '");
    		//logger.info("Exception Log: " + e.toString());
    		//e.printStackTrace();
    	}
        return AlertBoolean;
    }
    
    public boolean AlertAccept() {
    	boolean AlertBoolean = false;
        try {
        	driver.switchTo().alert().accept();
        	AlertBoolean = true;
            logger.info("Alert Accept : " + AlertBoolean );
    	}catch(Exception e) {
    		logger.info("Exception: AlertAccept '");
    		/*logger.info("Exception Log: " + e.toString());
    		e.printStackTrace();*/
    	}
        return AlertBoolean;
    }
    
    public boolean WriteTextToAlert(String TextToAlert) {
    	boolean AlertBoolean = false;
        try {
        	driver.switchTo().alert().sendKeys(TextToAlert);
        	AlertBoolean = true;
            logger.info("Write Text To Alert : " + TextToAlert );
    	}catch(Exception e) {
    		logger.info("Exception: WriteTextToAlert '");
    		logger.info("Exception Log: " + e.toString());
    		e.printStackTrace();
    	}
        return AlertBoolean;
    }
    
    public boolean MoveToElementJS(WebElement WebElement) {
    	boolean AlertBoolean = false;
        try {
        	JavascriptExecutor js=(JavascriptExecutor) driver;
        	js.executeScript("arguments[0].scrollIntoView(true);", WebElement);
        	AlertBoolean = true;
            logger.info("Move To Element : " + WebElementToString(WebElement));
    	}catch(Exception e) {
    		logger.info("Exception: MoveToElement '" + WebElementToString(WebElement));
    		logger.info("Exception Log: " + e.toString());
    	}
        return AlertBoolean;
    }
    
    
    
//**********************************************************************************
    //JAVA SCRIPT
    
    //
//**********************************************************************************
    
    	private WebElement lastElem = null;
    	
    	public WebElement findWebElement(WebElement WebElement) {
    		JavascriptExecutor js=(JavascriptExecutor) driver;
    		if (lastElem != null) {
    			unhighlightLast(js, lastElem);
    		}
    		
    		lastElem = WebElement;    		
    		highlightElement(js, WebElement);
    		js=null;
			return WebElement;    		
    	}
    	
    	private void highlightElement(JavascriptExecutor js,WebElement WebElement) {
    		try {
    	    	//js.executeScript("arguments[0].style.border='3px solid red'", element);
    			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", WebElement, "color: red; background: SkyBlue; border: 2px solid red;");
    		}catch(Exception e) {
    			
    		}
    	}

    	private void unhighlightLast(JavascriptExecutor js,WebElement WebElement) {
	    	try {
	       	 	//js.executeScript("arguments[0].style.border=" + lastElemStyle, element);
	    		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", WebElement, "");
	    	}catch(Exception e) {
	    		
	    	}
    	}
    	    	
    	public String getWebElementProperty(final String name, WebElement WebElement) {
    		JavascriptExecutor js = (JavascriptExecutor) driver;
    	    return js.executeScript("return arguments[0]." + name + ";", findWebElement(WebElement)).toString();
    	}
    	    
    /**
     * LiDropdown is used  where dropdown contains values in
     * li tag
     *
     * @return
     *//*

    public boolean LiDropdown(Xpath.Locators LocatorType, String LocatorValue, String value) {
        List<WebElement> elements = driver.findElements(Locators(LocatorType, LocatorValue));
        elements.stream().filter(p -> p.getText().trim().equalsIgnoreCase(value)).findFirst().get().click();
        return true;


*//*		elements.stream().forEach(a -> {
			System.out.println(a.getText());
			if (a.getText().contains((value))) {
				a.click();
			}
		});
		return true;
*//*
    }*/
}