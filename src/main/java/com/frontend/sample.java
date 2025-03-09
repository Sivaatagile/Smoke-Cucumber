package com.frontend;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import com.WE.WE_Admin_Settings;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Sample;
import com.baseClass.Base;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class sample  extends Base{

	
	public static  void Servicewd() throws Exception {
		WE_Admin_Settings settings = new WE_Admin_Settings(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);

		ClickonElement(workflow.getSettings_navigation_Bar());
		ClickonElement(settings.getAccounts());
		ClickonElement(settings.getCustomerFilter());
		Thread.sleep(4000);
		 By CustomerName= By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty("SIGNUP_FIRSTNAME")+" "+getProperty("SIGNUP_LASTNAME")));
		slowscrolluntilelementfound(CustomerName);
		clickOnElementUsingBy(CustomerName);
		
	}
	
	public static  void sin() {
		 LocalDate inputDate = LocalDate.parse("2025-03-09"); // Change this date to test

	        // Define formatter for day, month, and date separately
	        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("E");
	        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMM");
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d");

	        // Extract parts
	        String day = inputDate.format(dayFormatter);
	        String month = inputDate.format(monthFormatter);
	        String date = inputDate.format(dateFormatter);

	        // Add space before single-digit date
	        if (date.length() == 1) {
	            date = date+" " ;
	        }

	        // Combine formatted parts
	        String formattedDate = day + " " + month + " " + date;

	        // Print result
	        System.out.println(formattedDate);
	}
	public static void main(String[] args) {
		sin();
	}
	
	
}
