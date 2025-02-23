package cucumberStepDefinition;

import com.baseClass.Base;
import com.frontend.Customer_Bookingflow;

import io.cucumber.java.en.Given;

public class AAAAAAAAAAAA extends Base {

	@Given("pricingrule booking")
	public void pricingruleBooking() throws Exception {
	    
		Customer_Bookingflow.BookingFlow("NOTAVAILABLE",getProperty("SERVICE_NAME"), AdminCreatePricingrule.PricingruleNotAvailableDate, getProperty("Individual_slot"));

	}
	
}
