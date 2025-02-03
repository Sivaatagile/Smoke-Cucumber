package com.frontend;

import java.sql.Driver;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.WE.WE_Admin_Settings;
import com.WE.WE_Admin_WorkFlow;
import com.api.Api;
import com.baseClass.Base;
import com.baseClass.Base.API_BASE_URL;

public class Admin_Settings extends Base {
	
	 public static LocalDate prdate ;
	 public static   String formattedDatesss;

	public static void CreateBreed() throws InterruptedException {
		WE_Admin_Settings settings = new WE_Admin_Settings(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);

		ClickonElement(workflow.getSettings_navigation_Bar());
		ClickonElement(settings.getManageBreeds());
		ClickonElement(settings.getFABBreed());
		ClickonElement(settings.getBreedName());
		passInput(settings.getBreedName(), getProperty("BREED_Name"));
		ClickonElement(settings.getSaveBreed());
		ClickonElement(settings.getback());

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
		ClickonElement(settings.getback());
	}

	public static void CreatePricingRulePremium() throws Exception {

		WE_Admin_Settings settings = new WE_Admin_Settings(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);

		ClickonElement(workflow.getSettings_navigation_Bar());
		ClickonElement(settings.getAvailabilityandPricing());
		Thread.sleep(5000);
		ClickonElement(settings.getFAB());
		ClickonElement(settings.getPricingrule_Name());
		passInput(settings.getPricingrule_Name(), getProperty("Pricingrulename_Onetime_premium"));
		driver.hideKeyboard();
		ClickonElement(settings.getDescription());
		passInput(settings.getDescription(), getProperty("PricingruleDescription_premium"));
		driver.hideKeyboard();
		Api.Priority();
		Api.eliminatefrom100();
		ClickonElement(settings.getpriority());
		String convertInttoString = ConvertInttoString(Api.priorityNumber);
		Thread.sleep(2000);
		passInputUsingActions(settings.getpriority(), convertInttoString);
		driver.hideKeyboard();
		
		Thread.sleep(2000);

		ClickonElement(settings.getSelectdate());
		waitForElement(settings.getpricingruleDate());
		String From_Month = settings.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + From_Month);
		String From_Date = settings.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + From_Date);
		String From_Year = settings.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + From_Year);
	
		scrollUntilElementFound12(settings.getMonth(), settings.ToMonthExpected);
		String To_Month = settings.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + To_Month);
		scrollUntilElementFound12(settings.getDate(), settings.ToDateExpected);
		String To_Date = settings.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + To_Date);
		scrollUntilElementFound12(settings.getYear(), settings.ToYearExpected);
		String To_Year = settings.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + To_Year);
		
		ClickonElement(settings.getSelect());
		
		Thread.sleep(2000);
		ClickonElement(settings.getpremium());
		halfscroll(settings.getscrollview());
		ClickonElement(settings.getpricingoffsetvalue());
		passInput(settings.getpricingoffsetvalue(), "10");
		driver.hideKeyboard();
		Thread.sleep(4000);
		
		ClickonElement(settings.getsave());
		ClickonElement(settings.getback());

	}
	
	public static void CreatePricingRuleDiscount() throws Exception {

		WE_Admin_Settings settings = new WE_Admin_Settings(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);

		ClickonElement(workflow.getSettings_navigation_Bar());
		ClickonElement(settings.getAvailabilityandPricing());
		Thread.sleep(5000);
		ClickonElement(settings.getFAB());
		ClickonElement(settings.getPricingrule_Name());
		passInput(settings.getPricingrule_Name(), getProperty("Pricingrulename_Onetime_discount"));
		driver.hideKeyboard();
		ClickonElement(settings.getDescription());
		passInput(settings.getDescription(), getProperty("PricingruleDescription_discount"));
		driver.hideKeyboard();
		Api.Priority();
		Api.eliminatefrom100();
		ClickonElement(settings.getpriority());
		String convertInttoString = ConvertInttoString(Api.priorityNumber);
		Thread.sleep(2000);
		passInputUsingActions(settings.getpriority(), convertInttoString);
		driver.hideKeyboard();
		
		Thread.sleep(2000);

		ClickonElement(settings.getSelectdate());
		waitForElement(settings.getpricingruleDate());
		String From_Month = settings.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + From_Month);
		String From_Date = settings.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + From_Date);
		String From_Year = settings.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + From_Year);
	
		scrollUntilElementFound12(settings.getMonth(), settings.ToMonthExpected);
		String To_Month = settings.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + To_Month);
		scrollUntilElementFound12(settings.getDate(), settings.ToDateExpected);
		String To_Date = settings.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + To_Date);
		scrollUntilElementFound12(settings.getYear(), settings.ToYearExpected);
		String To_Year = settings.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + To_Year);
		
		ClickonElement(settings.getSelect());
		
		Thread.sleep(2000);
		ClickonElement(settings.getdiscount());
		halfscroll(settings.getscrollview());
		ClickonElement(settings.getpricingoffsetvalue());
		passInput(settings.getpricingoffsetvalue(), "10");
		driver.hideKeyboard();
		Thread.sleep(4000);
		
		ClickonElement(settings.getsave());
		ClickonElement(settings.getback());

	}
	
	public static void CreatePricingRuleNotAvailable() throws Exception {

		WE_Admin_Settings settings = new WE_Admin_Settings(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);

		ClickonElement(workflow.getSettings_navigation_Bar());
		ClickonElement(settings.getAvailabilityandPricing());
		Thread.sleep(5000);
		ClickonElement(settings.getFAB());
		ClickonElement(settings.getPricingrule_Name());
		passInput(settings.getPricingrule_Name(), getProperty("Pricingrulename_Onetime_notavailable"));
		driver.hideKeyboard();
		ClickonElement(settings.getDescription());
		passInput(settings.getDescription(), getProperty("PricingruleDescription_notavailable"));
		driver.hideKeyboard();
		
		
		Thread.sleep(2000);

		ClickonElement(settings.getSelectdate());
		waitForElement(settings.getpricingruleDate());
		String From_Month = settings.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + From_Month);
		String From_Date = settings.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + From_Date);
		String From_Year = settings.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + From_Year);
	
		scrollUntilElementFound12(settings.getMonth(), settings.ToMonthExpected);
		String To_Month = settings.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + To_Month);
		scrollUntilElementFound12(settings.getDate(), settings.ToDateExpected);
		String To_Date = settings.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + To_Date);
		scrollUntilElementFound12(settings.getYear(), settings.ToYearExpected);
		String To_Year = settings.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + To_Year);
		
		ClickonElement(settings.getSelect());
		
		Thread.sleep(2000);
		ClickonElement(settings.getNotAvailable());
	
		Thread.sleep(2000);
		ClickonElement(settings.getsave());
		ClickonElement(settings.getback());

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
			if (isElementAvailable(statementcreateddatelocator)) {
				System.out.println("date showed");
			}
		} else {
			System.out.println("Not listed");
		}
	}
	
	public static void main(String[] args) throws Exception {
		method1("First");
		Latest_StagingAPK_download(getProperty("STAGING"));
		Application();
		ChooseApi(API_BASE_URL.Staging);
		Api.signInAdmin(getProperty("PREDEFINED_ADMIN_EMAIL"));
		Api.verifyOtp(getProperty("PREDEFINED_ADMIN_OTP"));
		Login_Details.login_Admin();
		CreateBreed();
		CreatePool();
		CreatePricingRulePremium();
		CreatePricingRuleDiscount();
		CreatePricingRuleNotAvailable();
		
	}
	
	

}
