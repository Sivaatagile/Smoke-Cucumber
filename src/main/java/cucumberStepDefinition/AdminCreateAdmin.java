package cucumberStepDefinition;

import org.openqa.selenium.WebElement;

import com.WE.WE_Admin_User;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Info;
import com.WE.WE_Snackbar;
import com.baseClass.Base;
import io.cucumber.java.en.*;

public class AdminCreateAdmin extends Base {
	WE_Admin_User user = new WE_Admin_User(driver);
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
	WE_Info info = new WE_Info(driver);
	WE_Snackbar snack = new WE_Snackbar(driver);

	@When("Admin clicks on Admin's Show All")
	public void theAdminClicksOnAdminSShowAll() {
		ClickonElement(user.getShowall_AllAdmin());
	}

	@Then("Admin is navigated to Admin's list page")
	public void theAdminIsNavigatedToTheAdminSListPage() throws InterruptedException {
		waitForElement(user.getAllAdministrations());
	}

	@When("Admin clicks on the + button to add a new admin")
	public void theAdminClicksOnTheButtonToAddANewAdmin() {
		ClickonElement(user.getFAB());
	}

	@When("Admin enters the first name {string}")
	public void theAdminEntersTheFirstName(String FirstName) {
		ClickonElement(user.getFirstName());
		passInput(user.getFirstName(), getProperty(FirstName));
		driver.hideKeyboard();
	}

	@When("Admin enters the last name {string}")
	public void theAdminEntersTheLastName(String LastName) {
		ClickonElement(user.getLastName());
		passInput(user.getLastName(), getProperty(LastName));
		driver.hideKeyboard();
	}

	
	@When("Admin enters the email {string}")
	public void theAdminEntersTheEmail(String AdminEmail) {
		ClickonElement(user.getEmail());
		passInput(user.getEmail(), getProperty(AdminEmail));
		driver.hideKeyboard();
	}

	@When("Admin enters the admin's phone number {string}")
	public void theAdminEntersTheAdminPhoneNumber(String PhoneNumber) {
		ClickonElement(user.getPhoneNumber());
		passInput(user.getPhoneNumber(), getProperty(PhoneNumber));
		driver.hideKeyboard();
	}

	@When("Admin selects the gender")
	public void theAdminSelectsTheGender() {
		ClickonElement(user.getFemale());
		ClickonElement(user.getMale());
	}

	@When("Admin enters the phone number {string}")
	public void theAdminEntersThePhoneNumber(String string) {
		ClickonElement(user.getPhoneNumber());
		passInput(user.getPhoneNumber(), getProperty("ADMIN_PHONENUMBER"));
		driver.hideKeyboard();
	}

	@When("Admin enters the additional contact number {string}")
	public void theAdminEntersTheAdditionalContactNumber(String AdditionalContactNumber) {
		ClickonElement(user.getAdditionalContactNumber());
		passInput(user.getAdditionalContactNumber(), getProperty(AdditionalContactNumber));
		driver.hideKeyboard();
	}

	@When("Admin enters the address line for admin {int}")
	public void theAdminEntersTheAddressLineForAdmin(Integer int1) {
		WebElement addressLineElement;
		switch (int1) {
		case 1:
			addressLineElement = user.getAddressLine1();
			break;
		case 2:
			addressLineElement = user.getAddressLine2();
			break;
		default:
			throw new IllegalArgumentException("Invalid address line number: " + int1);
		}
		ClickonElement(addressLineElement);
		passInput(addressLineElement, getProperty("ADMIN_ADMIN_ADDRESSLINE_" + int1));
		driver.hideKeyboard();
	}

	@When("Admin selects the country")
	public void theAdminSelectsTheCountry() {
		ClickonElement(user.getCountry());
		ClickonElement(user.getCountryName());
	}

	@When("Admin enters the city or town {string}")
	public void theAdminEntersTheCityOrTown(String AdminCity) {
		ClickonElement(user.getCity());
		passInput(user.getCity(), getProperty(AdminCity));
		driver.hideKeyboard();
	}

	@When("Admin enters the post code {string}")
	public void theAdminEntersThePostCode(String AdminPostcode) {
		ClickonElement(user.getPostCode());
		passInput(user.getPostCode(), getProperty(AdminPostcode));
		driver.hideKeyboard();
	}

	@When("Admin clicks on the Save button")
	public void AdminClicksOnTheSaveButton() throws InterruptedException {
		ClickonElement(user.getSave());
	}
	
	@Then("the admin clicks on the Save button")
	public void theAdminClicksOnTheSaveButton() {
		ClickonElement(user.getSave());

	}
	@Then("the admin is navigated back to the home page")
	public void theAdminIsNavigatedBackToTheHomePage() {
		ClickonElement(user.getHome());

	}
	
	@Then("The new admin details should be successfully saved")
	public void theNewAdminDetailsShouldBeSuccessfullySaved() throws InterruptedException {
		waitForElement(user.getAllAdministrations());
	}

	@When("Admin clicks on the Back button")
	public void theAdminClicksOnTheBackButton() throws InterruptedException {
		Thread.sleep(1000);
		ClickonElement(info.getBackButton());
	}

	@When("Admin taps the Home icon")
	public void theAdminTapsTheHomeIcon() {
		ClickonElement(workflow.getHOME_navigation_Bar());
	}
}
