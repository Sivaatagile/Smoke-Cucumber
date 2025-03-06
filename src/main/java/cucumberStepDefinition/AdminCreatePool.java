package cucumberStepDefinition;

import com.WE.WE_Admin_Settings;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Snackbar;
import com.baseClass.Base;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminCreatePool extends Base {
	WE_Admin_Settings settings = new WE_Admin_Settings(driver);
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
	WE_Snackbar snack = new WE_Snackbar(driver);

	@When("the admin navigates to Manage Service Pools")
	public void theAdminNavigatesToManageServicePools() {
		ClickonElement(settings.getServicePool());
	}

	@When("the admin clicks on the Plus button to add a new pool")
	public void theAdminClicksOnThePlusButtonToAddANewPool() {
		ClickonElement(settings.getFAB());
	}

	@When("the admin enters Pool Name")
	public void theAdminEntersPoolName() {
		ClickonElement(settings.getPoolName());
		passInput(settings.getPoolName(), getProperty("POOL_NAME"));
		driver.hideKeyboard();
	}

	@When("the admin enters Pool Remarks")
	public void theAdminEntersPoolRemarks() {
		ClickonElement(settings.getPoolRemarks());
		passInput(settings.getPoolRemarks(), getProperty("POOL_REMARKS"));
		driver.hideKeyboard();
	}

	@When("the admin enters Pool Capacity")
	public void theAdminEntersPoolCapacity() {
		ClickonElement(settings.getPoolCapacity());
		passInput(settings.getPoolCapacity(), getProperty("POOL_CAPACITY"));
		driver.hideKeyboard();
	}

	@Then("the admin should see a confirmation message of Pool creation")
	public void theAdminShouldSeeAConfirmationMessageOfPoolCreation() {
//		System.out.println("sanck bar");
	}
	
	@When("the admin verifies the snackbar after creating the new service pool")
	public void theAdminVerifiesTheSnackbarAfterCreatingTheNewServicePool() throws InterruptedException {
//		waitForElement(snack.getDataInsertedSuccessfully());
	}
	
	@Then("the admin is navigated to the service pools list page")
	public void theAdminIsNavigatedToTheServicePoolsListPage() throws InterruptedException {
		waitForElement(settings.getServicePool());
	}
	
	@Then("the new service pool details should be successfully saved")
	public void theNewServicePoolDetailsShouldBeSuccessfullySaved() throws InterruptedException {   
		waitForElement(settings.getServicePool());
	}

}
