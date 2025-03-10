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
		Api api = new Api(driver);
		
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

		scrollUntilElementFound12(settings.getMonth(), settings.ToMonthExpectedPremium);
		String To_Month = settings.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + To_Month);
		scrollUntilElementFound12(settings.getDate(), settings.ToDateExpectedPremium);
		String To_Date = settings.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + To_Date);
		scrollUntilElementFound12(settings.getYear(), settings.ToYearExpectedPremium);
		String To_Year = settings.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + To_Year);

		String SingleDatePremiumPricingRule = getProperty("TO_Month_Premium_PricingRule")
				+ getProperty("TO_Date_Premium_PricingRule") + "," + getProperty("TO_Year_Premium_PricingRule");
		System.out.println(SingleDatePremiumPricingRule);
		System.out.println("yyyy  :  " + SingleDatePremiumPricingRule);
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMMd,yyyy");
		LocalDate prdate = LocalDate.parse(SingleDatePremiumPricingRule, inputFormatter);
		// Format to new string
		String formattedDatesss = prdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		// Print results
		System.out.println("Formatted Date: " + formattedDatesss);
		System.out.println("LocalDate: " + prdate);
		ClickonElement(settings.getSelect());
		
		Thread.sleep(2000);
		ClickonElement(settings.getPricingruleTag());
		api.UnselectTags(api.OverallTagList());
		ClickonElement(settings.getSelect());

		Thread.sleep(2000);
		ClickonElement(settings.getpremium());
		halfscroll(settings.getscrollview());
		ClickonElement(settings.getpricingoffsetvalue());
		passInput(settings.getpricingoffsetvalue(), getProperty("PREMIUM_AMOUNT"));
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

		scrollUntilElementFound12(settings.getMonth(), settings.ToMonthExpectedDiscount);
		String To_Month = settings.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + To_Month);
		scrollUntilElementFound12(settings.getDate(), settings.ToDateExpectedDiscount);
		String To_Date = settings.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + To_Date);
		scrollUntilElementFound12(settings.getYear(), settings.ToYearExpectedDiscount);
		String To_Year = settings.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + To_Year);

		String SingleDatePremiumPricingRule = getProperty("TO_Month_Discount_PricingRule")
				+ getProperty("TO_Date_Discount_PricingRule") + "," + getProperty("TO_Year_Discount_PricingRule");
		System.out.println(SingleDatePremiumPricingRule);
		System.out.println("yyyy  :  " + SingleDatePremiumPricingRule);
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMMd,yyyy");
		LocalDate prdate = LocalDate.parse(SingleDatePremiumPricingRule, inputFormatter);
		// Format to new string
		String formattedDatesss = prdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		// Print results
		System.out.println("Formatted Date: " + formattedDatesss);
		System.out.println("LocalDate: " + prdate);
		ClickonElement(settings.getSelect());
		
		Thread.sleep(2000);
		ClickonElement(settings.getPricingruleTag());	
		Api.UnselectTags(Api.OverallTagList());
		Thread.sleep(2000);
		ClickonElement(settings.getSelect());
		ClickonElement(settings.getdiscount());
		halfscroll(settings.getscrollview());
		ClickonElement(settings.getpricingoffsetvalue());
		passInput(settings.getpricingoffsetvalue(), getProperty("DISCOUNT_AMOUNT"));
		driver.hideKeyboard();
		Thread.sleep(4000);
		ClickonElement(settings.getsave());
		ClickonElement(settings.getback());

	}

	public static void CreatePricingRuleNotAvailable() throws Exception {

		WE_Admin_Settings settings = new WE_Admin_Settings(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		Api api = new Api(driver);
		
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

		scrollUntilElementFound12(settings.getMonth(), settings.ToMonthExpectedNotAvailable);
		String To_Month = settings.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + To_Month);
		scrollUntilElementFound12(settings.getDate(), settings.ToDateExpectedNotAvailable);
		String To_Date = settings.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + To_Date);
		scrollUntilElementFound12(settings.getYear(), settings.ToYearExpectedNotAvailable);
		String To_Year = settings.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + To_Year);

		String SingleDatePremiumPricingRule = getProperty("TO_Month_PricingRule_NotAvailable")
				+ getProperty("TO_Date_PricingRule_NotAvailable") + ","
				+ getProperty("TO_Year_PricingRule_NotAvailable");

		System.out.println(SingleDatePremiumPricingRule);
		System.out.println("yyyy  :  " + SingleDatePremiumPricingRule);
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMMd,yyyy");
		LocalDate prdate = LocalDate.parse(SingleDatePremiumPricingRule, inputFormatter);
		// Format to new string
		String formattedDatesss = prdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		// Print results
		System.out.println("Formatted Date: " + formattedDatesss);
		System.out.println("LocalDate: " + prdate);
		ClickonElement(settings.getSelect());
		Thread.sleep(2000);
		ClickonElement(settings.getPricingruleTag());
		api.UnselectTags(api.OverallTagList());
		ClickonElement(settings.getSelect());
		Thread.sleep(2000);
		ClickonElement(settings.getNotAvailable());
		Thread.sleep(2000);
		ClickonElement(settings.getsave());
		ClickonElement(settings.getback());

	}

	public static void Admin_Statement() throws Exception {
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
		By BookedPAYMENT1 = By.xpath("//android.view.View[@content-desc='#" + Customer_Settings.InvoiceNumber + "']");
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
		ClickonElement(settings.getback());
		Thread.sleep(1500);
		ClickonElement(settings.getback());
		
	}
	
	public static  void Admin_Invoices() throws InterruptedException {
		WE_Admin_Settings settings = new WE_Admin_Settings(driver);

		Thread.sleep(2000);
		ClickonElement(settings.getinvoices());Thread.sleep(2000);
		ClickonElement(settings.getsearch());
		Thread.sleep(2000);
		passInput(settings.getsearch(), InvoiceNumber);
		driver.hideKeyboard();Thread.sleep(2000);
		if (isElementAvailable(settings.getSelectInvoice())) {
			System.out.println("Successfully  invoice is generated ");
		} else if (isElementAvailable(settings.getNoRecordFound())) {
			System.out.println("Invoice is not generated");
		}
		ClickonElement(settings.getback());
	}
	
	
	public static  void UpdateCreditLimit() throws InterruptedException {
		WE_Admin_Settings settings = new WE_Admin_Settings(driver);
		
        ClickonElement(settings.getSettingstab());
		ClickonElement(settings.getManageCreditLimit());
		ClickonElement(settings.getsearch());
        passInput(settings.getsearch(), getProperty("SIGNUP_FIRSTNAME") + " " + getProperty("SIGNUP_LASTNAME"));
		Thread.sleep(3000);
		clickOnElementUsingBy(settings.CustomerNameForRemainingcredit);passInput(settings.CustomerNameForRemainingcredit, "999");
		driver.hideKeyboard();
		Thread.sleep(1000);
		ClickonElement(settings.getback());
	}
	
	public static  void Adhoc() throws InterruptedException {
		WE_Admin_Settings settings = new WE_Admin_Settings(driver);

		ClickonElement(settings.getAccounts());
		Thread.sleep(2000);
		ClickonElement(settings.getFAB());
		Thread.sleep(2000);
		ClickonElement(settings.getAccountsCustomer());
		Thread.sleep(2000);
		ClickonElement(settings.getSearchCustomer_Accounts());
		Thread.sleep(2000);
		passInput(settings.getSearchCustomer_Accounts(),
				getProperty("SIGNUP_FIRSTNAME") + " " + getProperty("SIGNUP_LASTNAME"));
		Thread.sleep(2000);
		driver.hideKeyboard();
		Thread.sleep(2000);
		clickOnElementUsingBy(settings.CustomerNameInAccountsSearch);
		ClickonElement(settings.getAdhocAmount());
		passInput(settings.getAdhocAmount(), "10000");
		ClickonElement(settings.getRemarksAccounts());
		passInput(settings.getRemarksAccounts(), "Remarks");
		driver.hideKeyboard();
		ClickonElement(settings.getSubmitAdhoc());
		Thread.sleep(1000);
		ClickonElement(settings.getback());
	}

	
	public static void main(String[] args) throws Exception {
		PropertyFile("Data");
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
