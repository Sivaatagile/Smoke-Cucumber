package cucumberStepDefinition;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.WE.WE_Admin_Settings;
import com.WE.WE_Admin_WorkFlow;
import com.api.Api;
import com.baseClass.Base;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminCreatePricingrule extends Base {

	WE_Admin_Settings settings = new WE_Admin_Settings(driver);
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);

	@When("the admin navigates to Pricing Rule")
	public void theAdminNavigatesToPricingRule() {
		ClickonElement(settings.getAvailabilityandPricing());

	}

	@When("the admin clicks on the FAB button to add a new pricing rule")
	public void theAdminClicksOnTheFABButtonToAddANewPricingRule() throws InterruptedException {
		Thread.sleep(5000);
		ClickonElement(settings.getFAB());

	}

	@When("the admin enters Pricing Rule Name as Single Date Premium")
	public void theAdminEntersPricingRuleNameAsSingleDatePremium() {
	ClickonElement(settings.getPricingrule_Name());
		passInput(settings.getPricingrule_Name(), getProperty("Pricingrulename_Onetime_premium"));
		driver.hideKeyboard();

	}

	@When("the admin enters Pricing Rule Description as Rule for premium pricing on a single date")
	public void theAdminEntersPricingRuleDescriptionAsRuleForPremiumPricingOnASingleDate() {
	ClickonElement(settings.getDescription());
		passInput(settings.getDescription(), getProperty("PricingruleDescription_premium"));
		driver.hideKeyboard();

	}

	@When("the admin enters Pricing Rule Priority")
	public void theAdminEntersPricingRulePriority() throws InterruptedException {
		Api.Priority();
		Api.eliminatefrom100();
		ClickonElement(settings.getpriority());
		String convertInttoString = ConvertInttoString(Api.priorityNumber);
		Thread.sleep(2000);
		passInputUsingActions(settings.getpriority(), convertInttoString);
		driver.hideKeyboard();

	}

	@When("the admin enters Pricing Rule type as premium")
	public void theAdminEntersPricingRuleTypeAsPremium() throws InterruptedException {
		Thread.sleep(2000);
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

		System.out.println("snack bar ");
	}
	
	
	
	
	
	@When("the admin enters Pricing Rule Name as Single Date discount")
	public void theAdminEntersPricingRuleNameAsSingleDateDiscount() {
	    
		ClickonElement(settings.getPricingrule_Name());
		passInput(settings.getPricingrule_Name(), getProperty("Pricingrulename_Onetime_discount"));
		driver.hideKeyboard();

	}
	@When("the admin enters Pricing Rule Description as Rule for discount pricing on a single date")
	public void theAdminEntersPricingRuleDescriptionAsRuleForDiscountPricingOnASingleDate() {
	   
		ClickonElement(settings.getDescription());
		passInput(settings.getDescription(), getProperty("PricingruleDescription_discount"));
		driver.hideKeyboard();
	}
	@When("the admin enters Pricing Rule type as discount")
	public void theAdminEntersPricingRuleTypeAsDiscount() throws InterruptedException {
		Thread.sleep(2000);
		ClickonElement(settings.getdiscount());
		
	}
	
	
	
	@When("the admin enters Pricing Rule Name as Single Date not available")
	public void theAdminEntersPricingRuleNameAsSingleDateNotAvailable() {
		ClickonElement(settings.getPricingrule_Name());
		passInput(settings.getPricingrule_Name(), getProperty("Pricingrulename_Onetime_notavailable"));
		driver.hideKeyboard();
		
	}
	@When("the admin enters Pricing Rule Description as Rule for not available pricing on a single date")
	public void theAdminEntersPricingRuleDescriptionAsRuleForNotAvailablePricingOnASingleDate() {
	 
		ClickonElement(settings.getDescription());
		passInput(settings.getDescription(), getProperty("PricingruleDescription_notavailable"));
		driver.hideKeyboard();
		
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
		
	

		
		
		scrollUntilElementFound12(settings.getMonth(), settings.ToMonthExpectedNotAvailable);
		String To_Month = settings.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + To_Month);
		scrollUntilElementFound12(settings.getDate(), settings.ToDateExpectedNotAvailable);
		String To_Date = settings.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + To_Date);
		scrollUntilElementFound12(settings.getYear(), settings.ToYearExpectedNotAvailable);
		String To_Year = settings.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + To_Year);
		
		
		String From_Month1 = settings.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + From_Month1);
		String From_Date1 = settings.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + From_Date1);
		String From_Year1 = settings.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + From_Year1);
		
		String  date = From_Month1 + From_Date1+"," + From_Year1;
		
		System.out.println("yyyy  :  "+date);
		
		 DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMMd,yyyy");
		 LocalDate  prdate = LocalDate.parse(date, inputFormatter);

	        // Format to new string
	        String formattedDatesss = prdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

	        // Print results
	        System.out.println("Formatted Date: " + formattedDatesss);
	        System.out.println("LocalDate: " + prdate);
		
		
		
		ClickonElement(settings.getSelect());
		
	}
	@When("the admin enters Pricing Rule type as Not available")
	public void theAdminEntersPricingRuleTypeAsNotAvailable() {
	   
		ClickonElement(settings.getNotAvailable());
	}
	
	

}
