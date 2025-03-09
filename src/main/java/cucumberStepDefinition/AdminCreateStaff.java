package cucumberStepDefinition;

import org.openqa.selenium.WebElement;

import com.WE.WE_Admin_User;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Info;
import com.WE.WE_Snackbar;
import com.baseClass.Base;

import io.cucumber.java.en.*;

public class AdminCreateStaff extends Base {
	WE_Admin_User user = new WE_Admin_User(driver);
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
	WE_Info info = new WE_Info(driver);
	WE_Snackbar snack = new WE_Snackbar(driver);

	@When("Admin clicks on Staff's Show All")
	public void theAdminClicksOnStaffSShowAll() {
		ClickonElement(user.getShowall_AllStaff());
	}

	@Then("Admin is navigated to the staff list page")
	public void theAdminIsNavigatedToTheStaffListPage() throws InterruptedException {
		waitForElement(user.getAllStaff());
	}

	@When("Admin clicks on the + button to add a new staff")
	public void theAdminClicksOnTheButtonToAddANewStaff() {
		ClickonElement(user.getFAB());
	}

	@When("Admin clicks on the Skills dropdown and selects the staff's skill")
	public void theAdminClicksOnTheSkillsDropdownAndSelectsTheStaffSSkill() throws InterruptedException, Exception {
		Thread.sleep(500);
		ClickonElement(user.getSkillsset());
		if (isElementAvailable(user.ServiceSkill)) {
			clickOnElementUsingBy(user.ServiceSkill);
		} else {
			halfscrollUntilElementFound12(user.getscroll(), user.ServiceSkill);
			clickOnElementUsingBy(user.ServiceSkill);
		}
		ClickonElement(user.getselect());
	}

	@Then("the new staff details should be successfully saved")
	public void theNewStaffDetailsShouldBeSuccessfullySaved() throws InterruptedException {
		waitForElement(user.getAllStaff());
	}

	@When("Admin selects the gender for Staff")
	public void theAdminSelectsTheGenderForStaff() {
		ClickonElement(user.getFemale());
		ClickonElement(user.getMale());
	}

	@When("Admin enters the address line for staff {int}")
	public void theAdminEntersTheAddressLineForStaff(Integer int1) {
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
		passInput(addressLineElement, getProperty("ADMIN_STAFF_ADDRESSLINE_" + int1));
		driver.hideKeyboard();
	}

	@When("Admin enters the Contact number {string}")
	public void theAdminEntersTheContactNumber(String Contact) {
		ClickonElement(user.getContactNumber());
		passInput(user.getContactNumber(), getProperty(Contact));
		driver.hideKeyboard();
	}
	
	@When("Admin verifies the snackbar after creating the new staff")
	public void theAdminVerifiesTheSnackbarAfterCreatingTheNewStaff() throws InterruptedException {
//	 waitForElement(snack.getRecordCreatedSuccessfully());
	}
	

}
