package cucumberStepDefinition;

import org.openqa.selenium.WebElement;

import com.WE.WE_Info;
import com.WE.WE_Snackbar;
import com.baseClass.Base;

import io.cucumber.java.en.*;

public class UserData extends Base {

	WE_Info UserInfo = new WE_Info(driver); 
	WE_Snackbar snackbar = new WE_Snackbar(driver);

	@Given("User has successfully signed up")
	public void theUserHasSuccessfullySignedUp() throws InterruptedException {
		WE_Info UserInfo = new WE_Info(driver);
		waitForElement(UserInfo.getAddInfoPageElement());
		boolean isLocator1Present = !driver.findElements(UserInfo.AddInfoPage).isEmpty();
		boolean isLocator2Present = !driver.findElements(UserInfo.AddCustomer).isEmpty();
		if (isLocator1Present || isLocator2Present) {
			System.out.println("Working fine");
		} else {
			System.out.println("No locators found");
		}
	}

	@When("User is on the user info page")
	public void theUserIsOnTheUserInfoPage() {
		boolean isLocator1Present = !driver.findElements(UserInfo.AddInfoPage).isEmpty();
		boolean isLocator2Present = !driver.findElements(UserInfo.AddCustomer).isEmpty();
		if (isLocator1Present || isLocator2Present) {
			System.out.println("Working fine");
		} else {
			System.out.println("No locators found");
		}
	}

	@When("User should see fields for first name, last name, gender, phone number, address line {int}, address line {int}, city\\/town, pincode, and country")
	public void theUserShouldSeeFieldsForFirstNameLastNameGenderPhoneNumberAddressLineAddressLineCityTownPincodeAndCountry(
			Integer int1, Integer int2) {
		System.out.println("Working Fine");
	}

	@When("User enters their first name {string}")
	public void theUserEntersTheirFirstName(String FirstName) throws InterruptedException {
		ClickonElement(UserInfo.getFirstName());
		passInput(UserInfo.getFirstName(), getProperty(FirstName));
		driver.hideKeyboard();
	}

	@When("User enters their last name {string}")
	public void theUserEntersTheirLastName(String LastName) {
		ClickonElement(UserInfo.getLastName());
		passInput(UserInfo.getLastName(), getProperty(LastName));
		driver.hideKeyboard();
	}

	@When("User selects their gender")
	public void theUserSelectsTheirGender() {
		ClickonElement(UserInfo.getCustomerMale());
		ClickonElement(UserInfo.getCustomerFemale());
	}

	@When("User enters their phone number {string}")
	public void theUserEntersTheirPhoneNumber(String PhoneNumber) {
		ClickonElement(UserInfo.getPhoneNumber());
		passInput(UserInfo.getPhoneNumber(), getProperty(PhoneNumber));
		driver.hideKeyboard();
	}

	@When("User enters address line {int} {string}")
	public void theUserEntersAddressLine(Integer int1, String Addressline) {
		// Determine the address line element dynamically based on the input integer
		WebElement addressLineElement;
		switch (int1) {
		case 1:
			addressLineElement = UserInfo.getAddressLine1();
			break;
		case 2:
			addressLineElement = UserInfo.getAddressLine2();
			break;
		// Add more cases if needed
		default:
			throw new IllegalArgumentException("Invalid address line number: " + int1);
		}
		// Perform actions on the dynamically selected address line
		ClickonElement(addressLineElement);
		passInput(addressLineElement, getProperty("SIGNUP_ADDRESSLINE" + int1));
		driver.hideKeyboard();
	}

	@When("User enters their city\\/town {string}")
	public void theUserEntersTheirCityTown(String City) {
		ClickonElement(UserInfo.getCityTown());
		passInput(UserInfo.getCityTown(), getProperty(City));
		driver.hideKeyboard();
	}

	@When("User enters their pincode {string}")
	public void theUserEntersTheirPincode(String PostCode) {
		ClickonElement(UserInfo.getPostCode());
		passInput(UserInfo.getPostCode(), getProperty(PostCode));
		driver.hideKeyboard();
	}

	@When("User selects their country")
	public void theUserSelectsTheirCountry() {
		scrollDown();
		ClickonElement(UserInfo.getCountryTab());
		ClickonElement(UserInfo.getCountryTab());
	}

	
	@When("User verifies the snackbar after entering the user data")
	public void theUserVerifiesTheSnackbarAfterEnteringTheUserData() throws InterruptedException {
		waitForElement(snackbar.getRecordUpdatedSuccessfully());
		
	}
	
	@When("User should be taken to the pet info page")
	public void theUserShouldBeTakenToThePetInfoPage() throws InterruptedException {
		
		if (isElementAvailable(snackbar.getRecordUpdatedSuccessfully())) {
			System.out.println("Snack bar verified successfully");
			WE_Info PetInfo = new WE_Info(driver);
			waitForElement(PetInfo.getAddPetInfoPageElement());
			boolean isLocator1Present = !driver.findElements(PetInfo.AddPetSignup).isEmpty();
			boolean isLocator2Present = !driver.findElements(PetInfo.AddpetCustomer).isEmpty();
			if (isLocator1Present || isLocator2Present) {
				System.out.println("Working fine");
			} else {
				System.out.println("No locators found");
			}

		}else {
			System.out.println("owaste");
		}

	}

}
