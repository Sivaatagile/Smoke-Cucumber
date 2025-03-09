package cucumberStepDefinition;

import java.util.Random;

import com.WE.WE_Customer_BookingFlow;
import com.api.Api;
import com.baseClass.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CustomerBookingflowAddon extends Base{
	WE_Customer_BookingFlow booking = new WE_Customer_BookingFlow(driver);
	Api api = new Api(driver);
	Random random = new Random();
	public static int randomValue;
	
	
	@Given("the user selects a {string} for booking")
	public void theUserSelectsAForBooking(String ServicewithAddon) throws InterruptedException {
	   
		if (isElementAvailable(booking.getServiceShowAll())) {
			ClickonElement(booking.getServiceShowAll());
			ClickonElement(booking.getSearchServices());
			Thread.sleep(1000);
			passInput(booking.getSearchServices(), getProperty(ServicewithAddon));
			driver.hideKeyboard();
			Thread.sleep(1000);
			ClickonElement(booking.getSelectAddonService());
		} else if (isElementAvailable(booking.AddonServiceViewable)) {
			Thread.sleep(1000);
			clickOnElementUsingBy(booking.AddonServiceViewable);
		} else {
			System.out.println("Service is not available");
		}
	}
	
	@When("the user select the addon mentioned in the service {string}")
	public void theUserSelectTheAddonMentionedInTheService(String string) throws InterruptedException {
	   
		waitForElement(booking.getAddons());
		Thread.sleep(4000);
		clickOnElementUsingBy(booking.PrivilegeAddon);
		clickOnElementUsingBy(booking.AssignableAddon);
		Thread.sleep(2000);
		
	}

@When("the user select the random slot mentioned in the service at {string}")
public void theUserSelectTheRandomSlotMentionedInTheServiceAt(String string) throws InterruptedException {
    
		Api.ServiceSlotTimeCount(getProperty(string));
		int SlotCount = api.timeSlotsCount;
		System.out.println("slot  :  " + SlotCount);
		randomValue = random.nextInt(SlotCount);
		System.out.println("Random value: " + randomValue);
		Thread.sleep(4000);
	}
@When("the user selects a random slot for addon from the slot list, scrolling the slot picker if necessary")
public void theUserSelectsARandomSlotForAddonFromTheSlotListScrollingTheSlotPickerIfNecessary() throws Exception {
	Thread.sleep(4000);
	for (int i = 1; i < randomValue; i++) {
		scroll(booking.getseekbar());
		System.out.println(i);
		Thread.sleep(500); // waits for 500ms
	}
	Thread.sleep(2500);
	Selected_Slot = booking.getseekbar().getAttribute("content-desc");
	System.out.println(Selected_Slot);
}

}
