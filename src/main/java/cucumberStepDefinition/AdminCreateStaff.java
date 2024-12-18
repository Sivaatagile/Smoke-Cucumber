package cucumberStepDefinition;

import org.openqa.selenium.WebElement;

import com.WE.WE_Admin_User;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Info;
import com.baseClass.Base;

import io.cucumber.java.en.*;

public class AdminCreateStaff extends Base {
	WE_Admin_User user = new WE_Admin_User(driver);
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
	WE_Info info = new WE_Info(driver);

	@When("the admin clicks on Staff's Show All")
	public void theAdminClicksOnStaffSShowAll() {
		ClickonElement(user.getShowall_AllStaff());
	}

	@Then("the admin is navigated to the staff list page")
	public void theAdminIsNavigatedToTheStaffListPage() throws InterruptedException {
		waitForElement(user.getAllStaff());
	}

	@When("the admin clicks on the + button to add a new staff")
	public void theAdminClicksOnTheButtonToAddANewStaff() {
		ClickonElement(user.getFAB());
	}

	@When("the admin clicks on the Skills dropdown and selects the staff's skill")
	public void theAdminClicksOnTheSkillsDropdownAndSelectsTheStaffSSkill() {
		System.out.println("Skills are in the list ");
	}

	@Then("the new staff details should be successfully saved")
	public void theNewStaffDetailsShouldBeSuccessfullySaved() throws InterruptedException {
		waitForElement(user.getSnackbarCreatedstaff());
		if (isElementAvailable(user.getSnackbarCreatedstaff())) {
			System.out.println("Staff Created");
		}
	}

	@When("the admin selects the gender for Staff")
	public void theAdminSelectsTheGenderForStaff() {
		ClickonElement(user.getFemale());
		ClickonElement(user.getMale());
	}

	@When("the admin enters the address line for staff {int}")
	public void theAdminEntersTheAddressLineForStaff(Integer int1) {
		WebElement addressLineElement;
		switch (int1) {
		case 1:
			addressLineElement = user.getAddressLine1();
			break;
		case 2:
			addressLineElement = user.getAddressLine2();
			break;
		// Add more cases if needed
		default:
			throw new IllegalArgumentException("Invalid address line number: " + int1);
		}
		// Perform actions on the dynamically selected address line
		ClickonElement(addressLineElement);
		passInput(addressLineElement, getProperty("ADMIN_STAFF_ADDRESSLINE_" + int1));
		driver.hideKeyboard();
	}

	@When("the admin enters the Contact number {string}")
	public void theAdminEntersTheContactNumber(String Contact) {
		ClickonElement(user.getContactNumber());
		passInput(user.getContactNumber(), getProperty(Contact));
		driver.hideKeyboard();
	}

}
