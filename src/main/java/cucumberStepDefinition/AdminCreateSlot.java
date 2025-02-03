package cucumberStepDefinition;

import com.WE.WE_Admin_Services;
import com.WE.WE_Info;
import com.baseClass.Base;
import io.cucumber.java.en.*;

public class AdminCreateSlot extends Base {
	WE_Admin_Services slot = new WE_Admin_Services(driver);
	WE_Info info = new WE_Info(driver);

	@Given("the admin navigates to the Service tab")
	public void theAdminNavigatesToTheServiceTab() {
		ClickonElement(slot.getservice_Tab());
	}

	@Given("the admin clicks on Show All under slots")
	public void theAdminClicksOnShowAllUnderSlots() throws InterruptedException {
		ClickonElement(slot.getSlot_Showall());
		Thread.sleep(3000);
	}

	@Given("the admin taps the plus button to create a new slot")
	public void theAdminTapsThePlusButtonToCreateANewSlot() throws InterruptedException {
		ClickonElement(slot.getfab());
		Thread.sleep(3000);
	}

	@When("the admin enters {string} in the slot name input field")
	public void theAdminEntersInTheSlotNameInputField(String SlotName) throws InterruptedException {
		ClickonElement(slot.getSlotName());
		Thread.sleep(3000);
		passInput(slot.getSlotName(), getProperty(SlotName));
		driver.hideKeyboard();
	}

	@When("the admin provides {string} in the slot description field")
	public void theAdminProvidesInTheSlotDescriptionField(String SlotDescription) throws InterruptedException {
		Thread.sleep(3000);
		ClickonElement(slot.getDescriptionTextBox());
		passInput(slot.getDescriptionTextBox(), getProperty(SlotDescription));
		driver.hideKeyboard();
	}

	@When("sets Slot Starting Time as the starting time for the slot")
	public void setsSlotStartingTimeAsTheStartingTimeForTheSlot() throws Exception {
		Thread.sleep(3000);
		ClickonElement(slot.getStartTime());
		Thread.sleep(3000);
		scrollUntilElementFound_DatePicker_Time(slot.getHours(), slot.HoursExpected);
		Thread.sleep(3000);
		scrollUntilElementFound_DatePicker_Time(slot.getMinutes(), slot.MinutesExpected);
		Thread.sleep(3000);
		scrollUntilElementFound_DatePicker_Time(slot.getSession(), slot.SessionExpected);
		Thread.sleep(3000);
		ClickonElement(slot.getSelect());
	}

	@When("the admin clicks on the save button")
	public void theAdminClicksOnTheSaveButton() throws InterruptedException {
		ClickonElement(slot.getSave());
		Thread.sleep(5000);
	}

	@Then("the slot should be created successfully")
	public void theSlotShouldBeCreatedSuccessfully() {
		System.out.println("Check the snack bar ");
		ClickonElement(info.getBackButton());
	}

}
