package cucumberStepDefinition;

import org.openqa.selenium.WebElement;

import com.WE.WE_Info;
import com.baseClass.Base;

import io.cucumber.java.en.*;

public class UserData extends Base {

	WE_Info UserInfo = new WE_Info(driver);

	@Given("the user has successfully signed up")
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

	@When("the user is on the user info page")
	public void theUserIsOnTheUserInfoPage() {
		boolean isLocator1Present = !driver.findElements(UserInfo.AddInfoPage).isEmpty();
		boolean isLocator2Present = !driver.findElements(UserInfo.AddCustomer).isEmpty();
		if (isLocator1Present || isLocator2Present) {
			System.out.println("Working fine");
		} else {
			System.out.println("No locators found");
		}
	}

	@When("the user should see fields for first name, last name, gender, phone number, address line {int}, address line {int}, city\\/town, pincode, and country")
	public void theUserShouldSeeFieldsForFirstNameLastNameGenderPhoneNumberAddressLineAddressLineCityTownPincodeAndCountry(
			Integer int1, Integer int2) {
		System.out.println("Working Fine");
	}

	@When("the user enters their first name {string}")
	public void theUserEntersTheirFirstName(String FirstName) throws InterruptedException {
		ClickonElement(UserInfo.getFirstName());
		Thread.sleep(2000);
		passInput(UserInfo.getFirstName(), getProperty(FirstName));
		driver.hideKeyboard();
	}

	@When("the user enters their last name {string}")
	public void theUserEntersTheirLastName(String LastName) {
		ClickonElement(UserInfo.getLastName());
		passInput(UserInfo.getLastName(), getProperty(LastName));
		driver.hideKeyboard();
	}

	@When("the user selects their gender")
	public void theUserSelectsTheirGender() {
		ClickonElement(UserInfo.getCustomerMale());
		ClickonElement(UserInfo.getCustomerFemale());
	}

	@When("the user enters their phone number {string}")
	public void theUserEntersTheirPhoneNumber(String PhoneNumber) {
		ClickonElement(UserInfo.getPhoneNumber());
		passInput(UserInfo.getPhoneNumber(), getProperty(PhoneNumber));
		driver.hideKeyboard();
	}

	@When("the user enters address line {int} {string}")
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

	@When("the user enters their city\\/town {string}")
	public void theUserEntersTheirCityTown(String City) {
		ClickonElement(UserInfo.getCityTown());
		passInput(UserInfo.getCityTown(), getProperty(City));
		driver.hideKeyboard();
	}

	@When("the user enters their pincode {string}")
	public void theUserEntersTheirPincode(String PostCode) {
		ClickonElement(UserInfo.getPostCode());
		passInput(UserInfo.getPostCode(), getProperty(PostCode));
		driver.hideKeyboard();
	}

	@When("the user selects their country")
	public void theUserSelectsTheirCountry() {
		scrollDown();
		ClickonElement(UserInfo.getCountryTab());
		ClickonElement(UserInfo.getCountryTab());
	}

	@Then("the user should be taken to the pet info page")
	public void theUserShouldBeTakenToThePetInfoPage() throws InterruptedException {
		waitForElement(UserInfo.getSnackbarAfterAddinfo());
		if (isElementAvailable(UserInfo.getSnackbarAfterAddinfo())) {
			System.out.println("Snack bar displays");
			WE_Info PetInfo = new WE_Info(driver);
			waitForElement(PetInfo.getAddPetInfoPageElement());
			boolean isLocator1Present = !driver.findElements(PetInfo.AddPetSignup).isEmpty();
			boolean isLocator2Present = !driver.findElements(PetInfo.AddpetCustomer).isEmpty();
			if (isLocator1Present || isLocator2Present) {
				System.out.println("Working fine");
			} else {
				System.out.println("No locators found");
			}
			
		}
		
		
	}

}
