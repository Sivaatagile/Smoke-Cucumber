package cucumberStepDefinition;

import com.WE.WE_Customer_BookingFlow;
import com.baseClass.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CustomerBookingflowAddon extends Base{
	WE_Customer_BookingFlow booking = new WE_Customer_BookingFlow(driver);

	@Given("the user selects a {string} for booking")
	public void theUserSelectsAForBooking(String ServicewithAddon) throws InterruptedException {
	   
		if (isElementAvailable(booking.getServiceShowAll())) {
			ClickonElement(booking.getServiceShowAll());
			ClickonElement(booking.getSearchServices());
			Thread.sleep(1000);
			passInput(booking.getSearchServices(), getProperty(ServicewithAddon));
			driver.hideKeyboard();
			ClickonElement(booking.getSelectService());
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
		
	}
	@When("the user select the random slot mentioned in the service")
	public void theUserSelectTheRandomSlotMentionedInTheService() {
	    
		
	}

}
