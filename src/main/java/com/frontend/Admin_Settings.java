package com.frontend;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.WE.WE_Admin_Settings;
import com.WE.WE_Admin_WorkFlow;
import com.api.Api;
import com.baseClass.Base;

public class Admin_Settings extends Base {

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
		passInput(settings.getsearch(), getProperty("SIGNUP_FIRSTNAME"));
		clickOnElementUsingBy(settings.SignupFirstname);

		Thread.sleep(5000);
		System.out.println(Customer_Settings.InvoiceNumber);
		By BookedPAYMENT1 = By.xpath("//android.view.View[@content-desc='" + Customer_Settings.InvoiceNumber + "']");
		System.out.println(BookedPAYMENT1);
		halfscrollUntilElementFound12(settings.getscroll(), BookedPAYMENT1);
		if (isElementAvailable(BookedPAYMENT1)) {
			Thread.sleep(4000);
			System.out.println("hhh : " + Customer_Settings.StatementCreatedDate);
			Thread.sleep(3000);
			By statementcreateddatelocator = By
					.xpath("//android.view.View[@content-desc='" + Customer_Settings.StatementCreatedDate + "']");

			// android.view.View[@content-desc="Jan 01 2025"]
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

	public static void CreatePool() {

		WE_Admin_Settings settings = new WE_Admin_Settings(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);

		ClickonElement(workflow.getSettings_navigation_Bar());
		ClickonElement(settings.getServicePool());
		ClickonElement(settings.getFAB());
		ClickonElement(settings.getPoolName());
		passInput(settings.getPoolName(), getProperty("POOL_NAME"));
		driver.hideKeyboard();

		ClickonElement(settings.getPoolRemarks());
		passInput(settings.getPoolRemarks(), getProperty("POOL_REMARKS"));
		driver.hideKeyboard();

		ClickonElement(settings.getPoolCapacity());
		passInput(settings.getPoolCapacity(), getProperty("POOL_CAPACITY"));
		driver.hideKeyboard();

		ClickonElement(settings.getsave());

	}

	public static void CreatePricingRule() throws Exception {

		WE_Admin_Settings settings = new WE_Admin_Settings(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);

		ClickonElement(workflow.getSettings_navigation_Bar());
		ClickonElement(settings.getAvailabilityandPricing());
		Thread.sleep(5000);
		ClickonElement(settings.getFAB());
		ClickonElement(settings.getPricingrule_Name());
		passInput(settings.getPricingrule_Name(), getProperty("Pricingrulename_Onetime"));
		driver.hideKeyboard();
		ClickonElement(settings.getDescription());
		passInput(settings.getDescription(), getProperty("PricingruleDescription"));
		driver.hideKeyboard();
		Api.Priority();
		Api.eliminatefrom100();
		ClickonElement(settings.getpriority());
		String convertInttoString = ConvertInttoString(Api.priorityNumber);
		Thread.sleep(2000);
		passInputUsingActions(settings.getpriority(), convertInttoString);
		driver.hideKeyboard();
		Thread.sleep(2000);
		ClickonElement(settings.getpremium());
		halfscroll(settings.getscrollview());
		ClickonElement(settings.getpricingoffsetvalue());
		passInput(settings.getpricingoffsetvalue(), "10");
		driver.hideKeyboard();
//		PremiumclickSlots(api.slotNames, api.TotalSlotCount);
		Thread.sleep(4000);
		ClickonElement(settings.getsave());

	}

}
