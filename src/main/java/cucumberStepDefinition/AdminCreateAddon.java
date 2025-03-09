package cucumberStepDefinition;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.WE.WE_Admin_Services;
import com.WE.WE_Admin_Services.AddOnType;
import com.WE.WE_Info;
import com.WE.WE_Snackbar;
import com.api.Api;
import com.baseClass.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class AdminCreateAddon extends Base{

	WE_Admin_Services addon = new WE_Admin_Services(driver);
	WE_Info info = new WE_Info(driver);
	Api api = new Api(driver);
	WE_Snackbar snack = new WE_Snackbar(driver);

	public static void selectSlot(List<String> slotList) throws Exception {
		WE_Admin_Services Service = new WE_Admin_Services(driver);
		Collections.reverse(slotList);
		WebElement Firstslot = driver
				.findElement(By.xpath("//android.view.View[@content-desc='" + slotList.get(0) + "']"));
		ClickonElement(Firstslot);
		for (String slot : slotList) {
			boolean isSlotFound = false;
			while (!isSlotFound) {
				try {
					WebElement slotElement = driver
							.findElement(By.xpath("//android.view.View[@content-desc='" + slot + "']"));
					slotElement.click();
					isSlotFound = true;
					System.out.println("Slot clicked: " + slot);
				} catch (NoSuchElementException e) {
					System.out.println("Slot not found, scrolling...");
                    slowScroll();
				}
			}
		}
	}	
	
	@Given("Admin taps the plus button to create a new addon")
	public void theAdminTapsThePlusButtonToCreateANewAddon() {
		ClickonElement(addon.getFab_Service());
	}
	
	@Given("Admin select the Addon while creating a addon")
	public void theAdminSelectTheAddonWhileCreatingAAddon() {
		ClickonElement(addon.getAddon());
	}
	
	@When("Admin enters {string} in the addon name input field")
	public void theAdminEntersInTheAddonNameInputField(String AddonName) {
		ClickonElement(addon.getAddon_name());
		passInput(addon.getAddon_name(), getProperty(AddonName));
		driver.hideKeyboard();
	}
	
	@When("Admin provides {string} in the addon description field")
	public void theAdminProvidesInTheAddonDescriptionField(String AddonDescription) {
		ClickonElement(addon.getAddon_Description_textbox());
		passInput(addon.getAddon_Description_textbox(), getProperty(AddonDescription));
		driver.hideKeyboard();
	}
	
	@When("Admin select the addon type {string}")
	public void theAdminSelectTheAddonType(String addOnType) {
		 try {
	            AddOnType selectedAddOnType = AddOnType.valueOf(addOnType.toUpperCase());
	            addon.toggleAddOn(selectedAddOnType);
	            System.out.println("Toggled Add-On: " + selectedAddOnType);
	        } catch (IllegalArgumentException e) {
	            throw new IllegalArgumentException("Invalid addon type: " + addOnType);
	        }
	}
		
	@When("Admin sets the {string} for {int} to {int} pets for addon")
	public void theAdminSetsTheForToPetsForAddon(String AddonBasePrice, Integer int1, Integer int2) throws Exception {
		slowscrolluntilelementfound(addon.getFirstElement());
		ClickonElement(addon.getFirstElement());
		passInput(addon.getFirstElement(), getProperty(AddonBasePrice));
        driver.hideKeyboard();
        slowscrolluntilelementfound(addon.getFourthElement());
		int BasePrice_size = addon.getBaseprice().size();
		System.out.println("size of Base list  : " + BasePrice_size);
		Thread.sleep(500);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(500);
			addon.getBaseprice().get(i).click();
			Thread.sleep(500);
			passInput(addon.getBaseprice().get(i), getProperty(AddonBasePrice));
			driver.hideKeyboard();
			Thread.sleep(500);
		}
	}

	@When("Admin selects Capacity Type from the tab for addon")
	public void theAdminSelectsCapacityTypeFromTheTabForAddon() throws InterruptedException {
		waitForElement(addon.getcapacityType());
		ClickonElement(addon.getFixed());
	}

	@When("Admin sets the {string} for the addon maximum capacity per slot")
	public void theAdminSetsTheForTheAddonMaximumCapacityPerSlot(String MaximumCapacitySlot) {
		ClickonElement(addon.getAddon_Maximum_capacity());
		passInput(addon.getAddon_Maximum_capacity(), getProperty(MaximumCapacitySlot));
		driver.hideKeyboard();
	}
	
	@When("Admin sets the {string} for addon maximum capacity per staff")
	public void theAdminSetsTheForAddonMaximumCapacityPerStaff(String MaximumCapacityStaff) {	  
		ClickonElement(addon.getAddon_Maximum_capacity_Per_Staff());
		passInput(addon.getAddon_Maximum_capacity_Per_Staff(), getProperty(MaximumCapacityStaff));
		driver.hideKeyboard();
	}
	
	@When("Admin provides {string} and {string} dates for privilege addon")
	public void theAdminProvidesAndDatesForPrivilegeAddon(String string, String string2) throws Exception {
		slowscrolluntilelementfound(addon.getFrom_To_DateDetails());
		ClickonElement(addon.getFrom_DateDetails());
		waitForElement(addon.getFrom());
		String From_Month = addon.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + From_Month);
		String From_Date = addon.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + From_Date);
		String From_Year = addon.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + From_Year);
		Thread.sleep(1000);
		ClickonElement(addon.getSelect1());
		Thread.sleep(1000);
		slowscrolluntilelementfound(addon.getto());
		ClickonElement(addon.getTo_DateDetails());
		waitForElement(addon.getTo());
		scrollUntilElementFound_DatePicker_Time1(addon.getMonth(), addon.ToMonthPrivilegeAddonExpected);
		String To_Month = addon.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + To_Month);
		scrollUntilElementFound_DatePicker_Time1(addon.getDate(), addon.ToDatePrivilegeAddonExpected);
		String To_Date = addon.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + To_Date);
		scrollUntilElementFound_DatePicker_Time1(addon.getYear(), addon.ToYearPrivilegeAddonExpected);
		String To_Year = addon.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + To_Year);
		Thread.sleep(1000);
		ClickonElement(addon.getSelect1());
	}
	
	@When("Admin provides {string} and {string} dates for assignable addon")
	public void theAdminProvidesAndDatesForAssignableAddon(String string, String string2) throws Exception {
		slowscrolluntilelementfound(addon.getFrom_To_DateDetails());
		ClickonElement(addon.getFrom_DateDetails());
		waitForElement(addon.getFrom());
		String From_Month = addon.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + From_Month);
		String From_Date = addon.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + From_Date);
		String From_Year = addon.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + From_Year);
		Thread.sleep(1000);
		ClickonElement(addon.getSelect1());
		Thread.sleep(1000);
		slowscrolluntilelementfound(addon.getto());
		ClickonElement(addon.getTo_DateDetails());
		waitForElement(addon.getTo());
		scrollUntilElementFound_DatePicker_Time1(addon.getMonth(), addon.ToMonthAssignableAddonExpected);
		String To_Month = addon.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + To_Month);
		scrollUntilElementFound_DatePicker_Time1(addon.getDate(), addon.ToDateAssignableAddonExpected);
		String To_Date = addon.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + To_Date);
		scrollUntilElementFound_DatePicker_Time1(addon.getYear(), addon.ToYearAssignableAddonExpected);
		String To_Year = addon.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + To_Year);
		Thread.sleep(1000);
		ClickonElement(addon.getSelect1());
	}
	
	
	@When("Admin verifies the snackbar after creating the new Assignable addon")
	public void theAdminVerifiesTheSnackbarAfterCreatingTheNewAssignableAddon() throws InterruptedException {
		waitForElement(snack.getRecordCreatedSuccessfully());
	}
	
	@When("Admin verifies the snackbar after creating the new privilege addon")
	public void theAdminVerifiesTheSnackbarAfterCreatingTheNewPrivilegeAddon() throws InterruptedException {
		waitForElement(snack.getRecordCreatedSuccessfully());
	}
	
}
