package cucumberStepDefinition;

import com.WE.WE_Customer_BookingFlow;
import com.WE.WE_Customer_Details;
import com.WE.WE_Customer_Settings;
import com.WE.WE_Info;
import com.baseClass.Base;
import com.frontend.Info;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerProfile  extends Base{
	
	WE_Info info = new WE_Info(driver);
	WE_Customer_BookingFlow booking = new WE_Customer_BookingFlow(driver);
	WE_Customer_Details CustomerDetails = new WE_Customer_Details(driver);
	WE_Customer_Settings settings = new WE_Customer_Settings(driver);
	
	@Given("the customer taps on the profile icon")
	public void theCustomerTapsOnTheProfileIcon() throws InterruptedException {
		waitForElement(booking.getassorted());
		ClickonElement(CustomerDetails.getCustomerProfile());
	}
	
	@When("the customer taps on My Pets")
	public void theCustomerTapsOnMyPets() {
		ClickonElement(CustomerDetails.getMyPet());
	}
	
	@When("the customer presses the FAB button to add pet info")
	public void theCustomerPressesTheFABButtonToAddPetInfo() {
		ClickonElement(CustomerDetails.getFAB());
	}
	
	@When("the customer goes back from profile to the home page")
	public void theCustomerGoesBackFromProfileToTheHomePage() throws InterruptedException {
		Thread.sleep(1000);
		ClickonElement(settings.getBackButton());
		Thread.sleep(2000);
		ClickonElement(settings.getHomeTab());
	}

}
