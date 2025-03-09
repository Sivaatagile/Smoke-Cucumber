package cucumberStepDefinition;

import com.WE.WE_Admin_Services;
import com.WE.WE_Info;
import com.baseClass.Base;
import io.cucumber.java.en.*;

public class AdminCreateSlot extends Base {
	WE_Admin_Services slot = new WE_Admin_Services(driver);
	WE_Info info = new WE_Info(driver);

	@Given("Admin navigates to the Service tab")
	public void theAdminNavigatesToTheServiceTab() {
		ClickonElement(slot.getservice_Tab());
	}

	@Given("Admin clicks on Show All under slots")
	public void theAdminClicksOnShowAllUnderSlots() throws InterruptedException {
		ClickonElement(slot.getSlot_Showall());
	}

	@Then("Admin is navigated to the slot's list page")
	public void theAdminIsNavigatedToTheSlotSListPage() throws InterruptedException {
	   waitForElement(slot.getSlot());
	}
	
	@Given("Admin taps the plus button to create a new slot")
	public void theAdminTapsThePlusButtonToCreateANewSlot() throws InterruptedException {
		ClickonElement(slot.getfab());
	}

	@When("Admin enters {string} in the slot name input field")
	public void theAdminEntersInTheSlotNameInputField(String SlotName) throws InterruptedException {
		ClickonElement(slot.getSlotName());
		passInput(slot.getSlotName(), getProperty(SlotName));
		driver.hideKeyboard();
	}

	@When("Admin provides {string} in the slot description field")
	public void theAdminProvidesInTheSlotDescriptionField(String SlotDescription) throws InterruptedException {
		ClickonElement(slot.getDescriptionTextBox());
		passInput(slot.getDescriptionTextBox(), getProperty(SlotDescription));
		driver.hideKeyboard();
	}

	@When("sets Slot Starting Time as the starting time for the slot")
	public void setsSlotStartingTimeAsTheStartingTimeForTheSlot() throws Exception {
		Thread.sleep(1000);
		ClickonElement(slot.getStartTime());
		Thread.sleep(1000);
		scrollUntilElementFound_DatePicker_Time1(slot.getHours(), slot.HoursExpected);
		Thread.sleep(1000);
		scrollUntilElementFound_DatePicker_Time1(slot.getMinutes(), slot.MinutesExpected);
		Thread.sleep(1000);
		scrollUntilElementFound_DatePicker_Time1(slot.getSession(), slot.SessionExpected);
		Thread.sleep(1000);
		ClickonElement(slot.getSelect());
	}

	@When("Admin clicks on the save button")
	public void theAdminClicksOnTheSaveButton() throws InterruptedException {
		ClickonElement(slot.getSave());
		Thread.sleep(2000);
		if (isElementAvailable(slot.getOKbutton())) {
			ClickonElement(slot.getOKbutton());
			
		}
	}
	
	@Then("The slot should be created successfully")
	public void theSlotShouldBeCreatedSuccessfully() throws InterruptedException {
		 waitForElement(slot.getSlot());
	}

}
