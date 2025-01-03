package cucumberStepDefinition;

import com.WE.WE_Admin_Settings;
import com.WE.WE_Admin_WorkFlow;
import com.api.Api;
import com.baseClass.Base;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminCreatePricingrule extends Base{

	WE_Admin_Settings settings = new WE_Admin_Settings(driver);
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);

	
	@When("the user navigates to Pricing Rule")
	public void theUserNavigatesToPricingRule() {
		ClickonElement(settings.getAvailabilityandPricing());


	}
	@When("the user clicks on the FAB button to add a new pricing rule")
	public void theUserClicksOnTheFABButtonToAddANewPricingRule() throws InterruptedException {
		Thread.sleep(5000);
		ClickonElement(settings.getFAB());

	}
	@When("the user enters Pricing Rule Name as Single Date Premium")
	public void theUserEntersPricingRuleNameAsSingleDatePremium() {
		ClickonElement(settings.getPricingrule_Name());
		passInput(settings.getPricingrule_Name(), getProperty("Pricingrulename_Onetime"));
		driver.hideKeyboard();

	}
	@When("the user enters Pricing Rule Description as Rule for premium pricing on a single date")
	public void theUserEntersPricingRuleDescriptionAsRuleForPremiumPricingOnASingleDate() {
		ClickonElement(settings.getDescription());
		passInput(settings.getDescription(), getProperty("PricingruleDescription"));
		driver.hideKeyboard();

	}
	@When("the user enters Pricing Rule Priority")
	public void theUserEntersPricingRulePriority() throws InterruptedException {
		Api.Priority();
		Api.eliminatefrom100();
		ClickonElement(settings.getpriority());
		 String convertInttoString = ConvertInttoString(Api.priorityNumber);
		 Thread.sleep(2000);
		passInputUsingActions(settings.getpriority(), convertInttoString);
		driver.hideKeyboard();

	}
	@When("the user enters Pricing Rule type")
	public void theUserEntersPricingRuleType() throws InterruptedException {
		Thread.sleep(2000);
		ClickonElement(settings.getpremium());

	}
	@When("the user enters the pricing off set value")
	public void theUserEntersThePricingOffSetValue() throws Exception {
	    
		halfscroll(settings.getscrollview());
		ClickonElement(settings.getpricingoffsetvalue());
		passInput(settings.getpricingoffsetvalue(), "10");
		driver.hideKeyboard();
	}
	
	@Then("the user should see a confirmation message Pricing Rule creation")
	public void theUserShouldSeeAConfirmationMessagePricingRuleCreation() {

        System.out.println("snack bar ");
	}
	
}
