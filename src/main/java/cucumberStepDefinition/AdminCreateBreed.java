package cucumberStepDefinition;

import com.WE.WE_Admin_Settings;
import com.WE.WE_Admin_WorkFlow;
import com.baseClass.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminCreateBreed extends Base {

	WE_Admin_Settings settings = new WE_Admin_Settings(driver);
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);

	@Given("the admin opens the Manage Breed section")
	public void theAdminOpensTheManageBreedSection() {
		ClickonElement(settings.getManageBreeds());

	}

	@When("the admin clicks on the Plus button to add a new breed")
	public void theAdminClicksOnThePlusButtonToAddANewBreed() {
		ClickonElement(settings.getFABBreed());

	}

	@When("the admin enters Breed Name in the breed name field")
	public void theAdminEntersBreedNameInTheBreedNameField() throws InterruptedException {
		ClickonElement(settings.getBreedName());
		passInputUsingActions(settings.getBreedName(), getProperty("BREED_Name"));

	}

	@Then("the admin should see a confirmation message of Breed creation")
	public void theAdminShouldSeeAConfirmationMessageOfBreedCreation() throws InterruptedException {
if (isElementAvailable(settings.getmanageBreed())) {
	
}
		
		
		System.out.println("snack bar ");
	}

}
