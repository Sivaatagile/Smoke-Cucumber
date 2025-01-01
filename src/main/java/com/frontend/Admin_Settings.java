package com.frontend;

import org.openqa.selenium.By;

import com.WE.WE_Admin_Settings;
import com.WE.WE_Admin_WorkFlow;
import com.baseClass.Base;

public class Admin_Settings extends Base{

	
	public static void CreateBreed() throws InterruptedException {
		WE_Admin_Settings settings = new WE_Admin_Settings(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		
		ClickonElement(workflow.getSettings_navigation_Bar());
		ClickonElement(settings.getManageBreeds());
		ClickonElement(settings.getFABBreed());
		ClickonElement(settings.getBreedName());
		passInputUsingActions(settings.getBreedName(), "Poodle 1");
		ClickonElement(settings.getSaveBreed());

	}
	
	public void Admin_Statement() throws Exception {
		WE_Admin_Settings settings = new WE_Admin_Settings(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		ClickonElement(workflow.getSettings_navigation_Bar());
		ClickonElement(settings.getstatements());
		waitForElement(settings.getYearStatement());
		Thread.sleep(2000);
		ClickonElement(settings.getsearch());
		Thread.sleep(2000);
		passInput(settings.getsearch(),getProperty("SIGNUP_FIRSTNAME"));
		clickOnElementUsingBy(settings.SignupFirstname);
		
		 Thread.sleep(5000);
		 System.out.println(Customer_Settings.InvoiceNumber);
	        By BookedPAYMENT1 = By.xpath("//android.view.View[@content-desc='"+ Customer_Settings.InvoiceNumber + "']");
	        System.out.println(BookedPAYMENT1);
		 halfscrollUntilElementFound12(settings.getscroll(),BookedPAYMENT1 );
		 if (isElementAvailable(BookedPAYMENT1)) {
			 Thread.sleep(4000);
			 System.out.println("hhh : "+Customer_Settings.StatementCreatedDate);
			 Thread.sleep(3000);
		        By statementcreateddatelocator = By.xpath("//android.view.View[@content-desc='"+ Customer_Settings.StatementCreatedDate + "']");

			//android.view.View[@content-desc="Jan 01 2025"]
			 if (isElementAvailable(statementcreateddatelocator)) {
				 
				 System.out.println("date showed");
				
			}
	    	} else {
	    	    System.out.println("Not listed");
	    	}
//		 Thread.sleep(1000);
//		  ClickonElement(settings.getBackButton());
//		  Thread.sleep(2000);
//	        ClickonElement(settings.getBackButton());
//	        ClickonElement(settings.getHomeTab());
	
}
	
}
