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

	@Given("the user opens the Manage Breed section")
	public void theUserOpensTheManageBreedSection() {
		ClickonElement(settings.getManageBreeds());

	}

	@When("the user clicks on the Plus button to add a new breed")
	public void theUserClicksOnThePlusButtonToAddANewBreed() {
		ClickonElement(settings.getFABBreed());

	}

	@When("the user enters Breed Name in the breed name field")
	public void theUserEntersBreedNameInTheBreedNameField() throws InterruptedException {
		ClickonElement(settings.getBreedName());
		passInputUsingActions(settings.getBreedName(), "Poodle 1");

	}

	@Then("the user should see a confirmation message of Breed creation")
	public void theUserShouldSeeAConfirmationMessageOfBreedCreation() {

		System.out.println("snack bar ");
	}

}
