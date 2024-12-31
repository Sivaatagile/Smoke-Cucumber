package cucumberStepDefinition;

import com.WE.WE_Login_Details;
import com.baseClass.Base;

import io.cucumber.java.en.*;

public class LoginLogout extends Base {
	WE_Login_Details login = new WE_Login_Details(driver);
	public static String otp_Received ;

	@Given("the admin navigates to the Settings tab")
	public void theAdminNavigatesToTheSettingsTab() {
		ClickonElement(login.getAdmin_Settings());
	}

	@Given("the admin clicks on the logout button")
	public void theAdminClicksOnTheLogoutButton() {
		ClickonElement(login.getLogout());
	}

	@Then("the admin should be logged out successfully")
	public void theAdminShouldBeLoggedOutSuccessfully() {
		System.out.println("Check the login  elements  their after logout");
	}

	@Given("the user enters their  {string} address")
	public void theUserEntersTheirAddress(String staffEmail) {
		ClickonElement(login.getContinueWithEmail());
		passInput(login.getContinueWithEmail(), getProperty(staffEmail));
		driver.hideKeyboard();
		
		
	}
	@When("the user enters the Otp")
	public void theUserEntersTheOtp() throws InterruptedException {
		Thread.sleep(10000);
		String otp_Received = getOtpFromSource();
		System.out.println("The OTP is  : " + otp_Received);
		Thread.sleep(2000);
		passInputUsingActions(login.getOTP(), otp_Received);
		
	}
	
	
	
	@Given("the customer navigates to the Settings tab")
	public void theCustomerNavigatesToTheSettingsTab() {
		ClickonElement(login.getSettings());
	}
	@Given("the customer clicks on the logout button")
	public void theCustomerClicksOnTheLogoutButton() {
		ClickonElement(login.getLogout());
	}
	@Then("the customer should be logged out successfully")
	public void theCustomerShouldBeLoggedOutSuccessfully() throws InterruptedException {
	   Thread.sleep(10000);
	   System.out.println("good ");
	}
	
	
}
