package cucumberStepDefinition;

import java.text.BreakIterator;
import java.util.Random;

import com.WE.WE_Info;
import com.WE.WE_Snackbar;
import com.baseClass.Base;

import io.cucumber.java.en.*;

public class PetData extends Base {
	static Random random = new Random();
	WE_Info PetInfo = new WE_Info(driver);
	
	WE_Snackbar snackbar = new WE_Snackbar(driver);


	@Given("User navigates to the pet info page")
	public void theUserNavigatesToThePetInfoPage() throws InterruptedException {
		waitForElement(PetInfo.getAddPetInfoPageElement());
		boolean isLocator1Present = !driver.findElements(PetInfo.AddPetSignup).isEmpty();
		boolean isLocator2Present = !driver.findElements(PetInfo.AddpetCustomer).isEmpty();
		if (isLocator1Present || isLocator2Present) {
			System.out.println("Working fine");
		} else {
			System.out.println("No locators found");
		}
	}

	@When("User should see fields for pet name, gender, size, breed, dietary issues, allergies, vet name, vet address, vet phone number, microchip details, contact person name, contact person's phone number, special instructions, feeding schedules, additional contacts, and behavioral information")
	public void theUserShouldSeeFieldsForPetNameGenderSizeBreedDietaryIssuesAllergiesVetNameVetAddressVetPhoneNumberMicrochipDetailsContactPersonNameContactPersonSPhoneNumberSpecialInstructionsFeedingSchedulesAdditionalContactsAndBehavioralInformation() {
		System.out.println("Navigated to the Add pet");
	}

	@When("User enters the pet's name {string}")
	public void theUserEntersThePetSName(String PetName) {
		ClickonElement(PetInfo.getPet_Name());
		passInput(PetInfo.getPet_Name(), getProperty(PetName));
	}

	@When("User selects the pet's gender")
	public void theUserSelectsThePetSGender() {
		ClickonElement(PetInfo.getPetMale());
		ClickonElement(PetInfo.getPetFemale());
	}

	@When("User needs to select the birth of dog")
	public void theUserNeedsToSelectTheBirthOfDog() throws Exception {
		ClickonElement(PetInfo.getDate_Of_Birth());
		Thread.sleep(2500);
		scrollupRandomly(PetInfo.getDate_Format().get(2));
		scrolldownRandomly(PetInfo.getDate_Format().get(0));
		scrolldownRandomly(PetInfo.getDate_Format().get(1));
		ClickonElement(PetInfo.getSelect());
	}

	@When("User selects the pet's size")
	public void theUserSelectsThePetSSize() throws InterruptedException {
		ClickonElement(PetInfo.getSize());
		waitForElement(PetInfo.getBottomSheetSize());
		int PETsize = PetInfo.getPetSizeList().size();
		System.out.println("size of service  : " + PETsize);
		if (PETsize > 0) {
			int randomIndex = random.nextInt(PETsize - 1);
			System.out.println(randomIndex);
			ClickonElement(PetInfo.getPetSizeList().get(randomIndex));
			System.out.println("ggggggg");
		} else {
			System.out.println("Not enough elements to select a random one.");
		}
	}

	@When("User selects the pet's breed")
	public void theUserSelectsThePetSBreed() throws InterruptedException {
		ClickonElement(PetInfo.getBreed());
		waitForElement(PetInfo.getBottomresetbutton());
		int BREEDsize = PetInfo.getBreedlist().size();
		System.out.println("size of service  : " + BREEDsize);
		if (BREEDsize > 0) {
			int randomIndex = random.nextInt(BREEDsize - 1);
			System.out.println(randomIndex);
			ClickonElement(PetInfo.getBreedlist().get(randomIndex));
		} else {
			System.out.println("Not enough elements to select a random one.");
		}
		if (isElementAvailable(PetInfo.getAdminNotes())) {
			ClickonElement(PetInfo.getAdminNotes());
			passInput(PetInfo.getAdminNotes(), getProperty("ADMIN_NOTES"));
			driver.hideKeyboard();
		}
	}

	@When("User enters any dietary issues {string}")
	public void theUserEntersAnyDietaryIssues(String DietaryIssues) {
		ClickonElement(PetInfo.getDietary());
		passInput(PetInfo.getDietary(), getProperty(DietaryIssues));
		driver.hideKeyboard();
	}

	@When("User enters any allergies {string}")
	public void theUserEntersAnyAllergies(String Allergies) {
		ClickonElement(PetInfo.getAllergies());
		passInput(PetInfo.getAllergies(), getProperty(Allergies));
		driver.hideKeyboard();
	}

	@When("User enters the vet's name {string}")
	public void theUserEntersTheVetSName(String VetName) {
		ClickonElement(PetInfo.getVet_Name());
		passInput(PetInfo.getVet_Name(), getProperty(VetName));
		driver.hideKeyboard();
	}

	@When("User enters the vet's address {string}")
	public void theUserEntersTheVetSAddress(String VetAddress) {
		ClickonElement(PetInfo.getVet_Address());
		passInput(PetInfo.getVet_Address(), getProperty(VetAddress));
		driver.hideKeyboard();
	}

	@When("User enters the vet's phone number {string}")
	public void theUserEntersTheVetSPhoneNumber(String VetPhoneNumber) {
		ClickonElement(PetInfo.getVet_PhoneNumber());
		passInput(PetInfo.getVet_PhoneNumber(), getProperty(VetPhoneNumber));
		driver.hideKeyboard();
	}

	@When("User enters the microchip number {string}")
	public void theUserEntersTheMicrochipNumber(String Microchip) {
		ClickonElement(PetInfo.getMicrochip());
		passInput(PetInfo.getMicrochip(), getProperty(Microchip));
		driver.hideKeyboard();
	}

	@When("User enters the contact person's name {string}")
	public void theUserEntersTheContactPersonSName(String ContactPersonName) {
		ClickonElement(PetInfo.getPerson_Name());
		passInput(PetInfo.getPerson_Name(), getProperty(ContactPersonName));
		driver.hideKeyboard();
	}

	@When("User enters the contact person's phone number {string}")
	public void theUserEntersTheContactPersonSPhoneNumber(String ContactPersonNumber) {
		ClickonElement(PetInfo.getPerson_Number());
		passInput(PetInfo.getPerson_Number(), getProperty(ContactPersonNumber));
		driver.hideKeyboard();
	}

	@When("User enters any special instructions {string}")
	public void theUserEntersAnySpecialInstructions(String SpecialInstructions) {
		ClickonElement(PetInfo.getSpecial_Instruction());
		passInput(PetInfo.getSpecial_Instruction(), getProperty(SpecialInstructions));
		driver.hideKeyboard();
	}

	@When("User enters the feeding schedule {string}")
	public void theUserEntersTheFeedingSchedule(String FeedingDetails) {
		ClickonElement(PetInfo.getFeeding_Schedules());
		passInput(PetInfo.getFeeding_Schedules(), getProperty(FeedingDetails));
		driver.hideKeyboard();
	}

	@When("User enters any additional contacts {string}")
	public void theUserEntersAnyAdditionalContacts(String AdditionalContact) {
		ClickonElement(PetInfo.getAdditional_Contacts());
		passInput(PetInfo.getAdditional_Contacts(), getProperty(AdditionalContact));
		driver.hideKeyboard();
	}

	@When("User provides behavioral information")
	public void theUserProvidesBehavioralInformation() {
		ClickonElement(PetInfo.getBehavioral_Information1());
		ClickonElement(PetInfo.getBehavioral_Information2());
		ClickonElement(PetInfo.getBehavioral_Information3());
	}

	@When("User clicks on the Save button")
	public void theUserClicksOnTheSaveButton() throws InterruptedException {
		ClickonElement(PetInfo.getSave());
	}
	
	@When("User verifies the snackbar after entering the pet data")
	public void theUserVerifiesTheSnackbarAfterEnteringThePetData() throws InterruptedException {
		waitForElement(snackbar.getRecordCreatedSuccessfully());

		
	}

	@When("The pet information should be saved successfully")
	public void thePetInformationShouldBeSavedSuccessfully() throws InterruptedException {
		if (isElementAvailable(snackbar.getRecordCreatedSuccessfully())) {
			System.out.println("Snack bar verified successfully");
//			Thread.sleep(2500);
			if (isElementAvailable(PetInfo.getProfileWord())) {
				System.out.println("admin created a pet for a customer completed successfully");
			} else if (isElementAvailable(PetInfo.getcloseApp())) {
				System.out.println("Customer signed up successfully");
			}
		}else {
			System.out.println("waste");
		}

	}

	@Given("User navigates to the landing page")
	public void theUserNavigatesToTheLandingPage() throws InterruptedException {
		waitForElement(PetInfo.getcloseApp());
		if (isElementAvailable(PetInfo.getcloseApp())) {
			System.out.println("Successfully navigated to the landing screen");
			ClickonElement(PetInfo.getcloseApp());
		}
	}

}
