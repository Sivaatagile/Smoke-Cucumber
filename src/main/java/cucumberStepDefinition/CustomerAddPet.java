package cucumberStepDefinition;

import com.WE.WE_Customer_BookingFlow;
import com.WE.WE_Customer_Details;
import com.WE.WE_Info;
import com.baseClass.Base;
import com.frontend.Info;

import io.cucumber.java.en.Given;

public class CustomerAddPet  extends Base{
	
	@Given("Customer Second Pet")
	public void customerSecondPet() throws Exception {
		WE_Info info = new WE_Info(driver);
		WE_Customer_BookingFlow booking = new WE_Customer_BookingFlow(driver);
		WE_Customer_Details CustomerDetails = new WE_Customer_Details(driver);

		waitForElement(booking.getassorted());
		ClickonElement(CustomerDetails.getCustomerProfile());
		ClickonElement(CustomerDetails.getMyPet());
		ClickonElement(CustomerDetails.getFAB());
		Info.Pet_Data();
		
		ClickonElement(info.getBackButton());
		
	}

}
