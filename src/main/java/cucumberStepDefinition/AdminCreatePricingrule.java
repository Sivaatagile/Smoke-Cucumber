package cucumberStepDefinition;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.WE.WE_Admin_Settings;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Snackbar;
import com.api.Api;
import com.baseClass.Base;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminCreatePricingrule extends Base {

	WE_Admin_Settings settings = new WE_Admin_Settings(driver);
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
	WE_Snackbar snack = new WE_Snackbar(driver);
	Api api = new Api(driver);

	@When("the admin navigates to Pricing Rule")
	public void theAdminNavigatesToPricingRule() {
		ClickonElement(settings.getAvailabilityandPricing());
	}

	@When("the admin clicks on the FAB button to add a new pricing rule")
	public void theAdminClicksOnTheFABButtonToAddANewPricingRule() throws InterruptedException {
		ClickonElement(settings.getFAB());
	}

	@When("the admin enters Pricing Rule Name as Single Date Premium")
	public void theAdminEntersPricingRuleNameAsSingleDatePremium() {
	    ClickonElement(settings.getPricingrule_Name());
		passInput(settings.getPricingrule_Name(), getProperty("Pricingrulename_Onetime_premium"));
		driver.hideKeyboard();
	}

	@When("the admin enters Pricing Rule Description as Rule for premium pricing on a single date")
	public void theAdminEntersPricingRuleDescriptionAsRuleForPremiumPricingOnASingleDate() throws InterruptedException {
	    ClickonElement(settings.getDescription());
		passInput(settings.getDescription(), getProperty("PricingruleDescription_premium"));
		driver.hideKeyboard();
		Thread.sleep(25000);
	}

	@When("the admin enters Pricing Rule Priority")
	public void theAdminEntersPricingRulePriority() throws InterruptedException {
		Api.Priority();
		Api.eliminatefrom100();
		ClickonElement(settings.getpriority());
		String convertInttoString = ConvertInttoString(Api.priorityNumber);
		passInputUsingActions(settings.getpriority(), convertInttoString);
		driver.hideKeyboard();
	}
	
	@When("the admin choose the single date for premium rule")
	public void theAdminChooseTheSingleDateForPremiumRule() throws Exception {
		Thread.sleep(500);
		ClickonElement(settings.getSelectdate());
		waitForElement(settings.getpricingruleDate());
		String From_Month = settings.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + From_Month);
		String From_Date = settings.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + From_Date);
		String From_Year = settings.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + From_Year);
		scrollUntilElementFound_DatePicker_Time1(settings.getMonth(), settings.ToMonthExpectedPremium);
		String To_Month = settings.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + To_Month);
		scrollUntilElementFound_DatePicker_Time1(settings.getDate(), settings.ToDateExpectedPremium);
		String To_Date = settings.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + To_Date);
		scrollUntilElementFound_DatePicker_Time1(settings.getYear(), settings.ToYearExpectedPremium);
		String To_Year = settings.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + To_Year);
		String SingleDatePremiumPricingRule =getProperty("TO_Month_Premium_PricingRule") + getProperty("TO_Date_Premium_PricingRule") +","+ getProperty("TO_Year_Premium_PricingRule");
		System.out.println(SingleDatePremiumPricingRule);
		System.out.println("yyyy  :  "+SingleDatePremiumPricingRule);
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMMd,yyyy");
		LocalDate  prdate = LocalDate.parse(SingleDatePremiumPricingRule, inputFormatter);
	    String formattedDatesss = prdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    System.out.println("Formatted Date: " + formattedDatesss);
	    System.out.println("LocalDate: " + prdate);
		ClickonElement(settings.getSelect());
	}
	
	@When("the admin enters Pricing Rule type as premium")
	public void theAdminEntersPricingRuleTypeAsPremium() throws InterruptedException {
		Thread.sleep(500);
		ClickonElement(settings.getpremium());
	}

	@When("the admin enters the pricing offset value")
	public void theAdminEntersThePricingOffsetValue() throws Exception {
		halfscroll(settings.getscrollview());
		ClickonElement(settings.getpricingoffsetvalue());
		passInput(settings.getpricingoffsetvalue(), "10");
		driver.hideKeyboard();
	}

	@Then("the admin should see a confirmation message of Pricing Rule creation")
	public void theAdminShouldSeeAConfirmationMessageOfPricingRuleCreation() {
//		System.out.println("snack bar ");
	}
	
	@When("the admin choose the single date for discount rule")
	public void theAdminChooseTheSingleDateForDiscountRule() throws Exception {
		Thread.sleep(500);
		ClickonElement(settings.getSelectdate());
		waitForElement(settings.getpricingruleDate());
		String From_Month = settings.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + From_Month);
		String From_Date = settings.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + From_Date);
		String From_Year = settings.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + From_Year);
		scrollUntilElementFound_DatePicker_Time1(settings.getMonth(), settings.ToMonthExpectedDiscount);
		String To_Month = settings.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + To_Month);
		scrollUntilElementFound_DatePicker_Time1(settings.getDate(), settings.ToDateExpectedDiscount);
		String To_Date = settings.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + To_Date);
		scrollUntilElementFound_DatePicker_Time1(settings.getYear(), settings.ToYearExpectedDiscount);
		String To_Year = settings.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + To_Year);
		String SingleDatePremiumPricingRule =getProperty("TO_Month_Discount_PricingRule") + getProperty("TO_Date_Discount_PricingRule") +","+ getProperty("TO_Year_Discount_PricingRule");
		System.out.println(SingleDatePremiumPricingRule);
		System.out.println("yyyy  :  "+SingleDatePremiumPricingRule);
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMMd,yyyy");
		LocalDate  prdate = LocalDate.parse(SingleDatePremiumPricingRule, inputFormatter);
	    String formattedDatesss = prdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    System.out.println("Formatted Date: " + formattedDatesss);
	    System.out.println("LocalDate: " + prdate);
		ClickonElement(settings.getSelect());
	}
	
	@When("the admin enters Pricing Rule Name as Single Date discount")
	public void theAdminEntersPricingRuleNameAsSingleDateDiscount() {
		ClickonElement(settings.getPricingrule_Name());
		passInput(settings.getPricingrule_Name(), getProperty("Pricingrulename_Onetime_discount"));
		driver.hideKeyboard();
	}
	
	@When("the admin enters Pricing Rule Description as Rule for discount pricing on a single date")
	public void theAdminEntersPricingRuleDescriptionAsRuleForDiscountPricingOnASingleDate() throws InterruptedException {
		ClickonElement(settings.getDescription());
		passInput(settings.getDescription(), getProperty("PricingruleDescription_discount"));
		driver.hideKeyboard();
		Thread.sleep(25000);

	}
	
	@When("the admin enters Pricing Rule type as discount")
	public void theAdminEntersPricingRuleTypeAsDiscount() throws InterruptedException {
		Thread.sleep(500);
		ClickonElement(settings.getdiscount());
	}
	
	@When("the admin enters Pricing Rule Name as Single Date not available")
	public void theAdminEntersPricingRuleNameAsSingleDateNotAvailable() {
		ClickonElement(settings.getPricingrule_Name());
		passInput(settings.getPricingrule_Name(), getProperty("Pricingrulename_Onetime_notavailable"));
		driver.hideKeyboard();	
	}
	
	@When("the admin enters Pricing Rule Description as Rule for not available pricing on a single date")
	public void theAdminEntersPricingRuleDescriptionAsRuleForNotAvailablePricingOnASingleDate() throws InterruptedException {
		ClickonElement(settings.getDescription());
		passInput(settings.getDescription(), getProperty("PricingruleDescription_notavailable"));
		driver.hideKeyboard();
		Thread.sleep(25000);

	}
	
	@When("the admin choose the single date for not available rule")
	public void theAdminChooseTheSingleDateForNotAvailableRule() throws Exception {
		ClickonElement(settings.getSelectdate());
		waitForElement(settings.getpricingruleDate());
		String From_Month = settings.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + From_Month);
		String From_Date = settings.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + From_Date);
		String From_Year = settings.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + From_Year);
		scrollUntilElementFound_DatePicker_Time1(settings.getMonth(), settings.ToMonthExpectedNotAvailable);
		String To_Month = settings.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + To_Month);
		scrollUntilElementFound_DatePicker_Time1(settings.getDate(), settings.ToDateExpectedNotAvailable);
		String To_Date = settings.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + To_Date);
		scrollUntilElementFound_DatePicker_Time1(settings.getYear(), settings.ToYearExpectedNotAvailable);
		String To_Year = settings.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + To_Year);
		String SingleDatePremiumPricingRule =getProperty("TO_Month_PricingRule_NotAvailable") + getProperty("TO_Date_PricingRule_NotAvailable") +","+ getProperty("TO_Year_PricingRule_NotAvailable");
		System.out.println(SingleDatePremiumPricingRule);
		System.out.println("yyyy  :  "+SingleDatePremiumPricingRule);
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMMd,yyyy");
		LocalDate  prdate = LocalDate.parse(SingleDatePremiumPricingRule, inputFormatter);
	    PricingruleNotAvailableDate = prdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    System.out.println("Formatted Date: " + PricingruleNotAvailableDate);
	    System.out.println("LocalDate: " + prdate);
		ClickonElement(settings.getSelect());
	}
	
	@When("the admin unselect all the tags in pricingrule")
	public void theAdminUnselectAllTheTagsInPricingrule() throws Exception {
		Thread.sleep(500);
		ClickonElement(settings.getPricingruleTag());
		api.UnselectTags(api.OverallTagList());
		ClickonElement(settings.getSelect());
	}
	
	@Then("the admin is navigated to the pricing rule list page")
	public void theAdminIsNavigatedToThePricingRuleListPage() throws InterruptedException {
	    waitForElement(settings.getpricingrule());		
	}
	
	@Then("the new pricing rule details should be successfully saved")
	public void theNewPricingRuleDetailsShouldBeSuccessfullySaved() throws InterruptedException {	   
	    waitForElement(settings.getpricingrule());	
	}
	
	@When("the admin enters Pricing Rule type as Not available")
	public void theAdminEntersPricingRuleTypeAsNotAvailable() {
		ClickonElement(settings.getNotAvailable());
	}
	
	@When("the admin verifies the snackbar after creating the new premium pricing rule")
	public void theAdminVerifiesTheSnackbarAfterCreatingTheNewPremiumPricingRule() throws InterruptedException {
//		waitForElement(snack.getRecordCreatedSuccessfully());
	}
	
	@When("the admin verifies the snackbar after creating the new discount pricing rule")
	public void theAdminVerifiesTheSnackbarAfterCreatingTheNewDiscountPricingRule() throws InterruptedException {
//		waitForElement(snack.getRecordCreatedSuccessfully());
	}
	
	@When("the admin verifies the snackbar after creating the new Not Available pricing rule")
	public void theAdminVerifiesTheSnackbarAfterCreatingTheNewNotAvailablePricingRule() throws InterruptedException {
//		waitForElement(snack.getRecordCreatedSuccessfully());
	}

}
