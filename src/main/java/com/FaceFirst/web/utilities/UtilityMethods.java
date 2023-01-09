package com.FaceFirst.web.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UtilityMethods {

	public static void moveToElement(WebElement element) {

		Actions action = new Actions(Seleniumdriver.getDriver());
		action.moveToElement(element);
		action.perform();

	}

}
