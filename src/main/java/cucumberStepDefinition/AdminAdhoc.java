package cucumberStepDefinition;

import com.WE.WE_Admin_Settings;
import com.WE.WE_Admin_WorkFlow;
import com.baseClass.Base;

import io.cucumber.java.en.Given;

public class AdminAdhoc extends Base{

	@Given("Adoc")
	public void adoc() throws InterruptedException {
	   
		WE_Admin_Settings settings = new WE_Admin_Settings(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		ClickonElement(workflow.getSettings_navigation_Bar());
		ClickonElement(settings.getAccounts());
		Thread.sleep(2000);
		ClickonElement(settings.getFAB());
		Thread.sleep(2000);

		ClickonElement(settings.getAccountsCustomer());
		Thread.sleep(2000);

		ClickonElement(settings.getSearchCustomer_Accounts());
		Thread.sleep(2000);

		passInput(settings.getSearchCustomer_Accounts(), getProperty("SIGNUP_FIRSTNAME")+" "+getProperty("SIGNUP_LASTNAME"));
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
		
		ClickonElement(settings.getback());
	}
	
	
	
}
