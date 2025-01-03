package cucumberStepDefinition;

import com.WE.WE_Admin_Settings;
import com.WE.WE_Admin_WorkFlow;
import com.baseClass.Base;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminCreatePool extends Base{
	WE_Admin_Settings settings = new WE_Admin_Settings(driver);
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);

	@When("the user navigates to Manage Service Pools")
	public void theUserNavigatesToManageServicePools() {

		ClickonElement(settings.getServicePool());

	}
	@When("the user clicks on the Plus button to add a new pool")
	public void theUserClicksOnThePlusButtonToAddANewPool() {

		ClickonElement(settings.getFAB());

	}
	@When("the user enters Pool Name")
	public void theUserEntersPoolName() {
		ClickonElement(settings.getPoolName());
		passInput(settings.getPoolName(), getProperty("POOL_NAME"));
		driver.hideKeyboard();

	}
	@When("the user enters Pool Remarks")
	public void theUserEntersPoolRemarks() {
		ClickonElement(settings.getPoolRemarks());
		passInput(settings.getPoolRemarks(), getProperty("POOL_REMARKS"));
		driver.hideKeyboard();

	}
	@When("the user enters Pool Capacity")
	public void theUserEntersPoolCapacity() {

		ClickonElement(settings.getPoolCapacity());
		passInput(settings.getPoolCapacity(), getProperty("POOL_CAPACITY"));
		driver.hideKeyboard();
	}
	@Then("the user should see a confirmation message Pool creation")
	public void theUserShouldSeeAConfirmationMessagePoolCreation() {

System.out.println("sanck bar");
	}

	
}
