package cucumberStepDefinition;

import com.WE.WE_Login_Details;
import com.baseClass.Base;

import io.cucumber.java.en.*;

public class LoginLogout extends Base {
	WE_Login_Details login = new WE_Login_Details(driver);
	public static String otp_Received;

	@Given("the admin navigates to the Settings tab")
	public void theAdminNavigatesToTheSettingsTab() throws InterruptedException {
		Thread.sleep(3500);
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

	@Given("the customer enters their {string} address")
	public void theCustomerEntersTheirAddress(String customerEmail) throws InterruptedException {
		Thread.sleep(5000);
		ClickonElement(login.getContinueWithEmail());
		passInput(login.getContinueWithEmail(), getProperty(customerEmail));
		Thread.sleep(1000);
		driver.hideKeyboard();

	}

	@When("the customer enters the Otp")
	public void theCustomerEntersTheOtp() throws InterruptedException {
		Thread.sleep(5000);
		String otp_Received = getOtpFromSource();
		System.out.println("The OTP is  : " + otp_Received);
		ClickonElement(login.getOTP());
		Thread.sleep(2000);
		passInputUsingActions(login.getOTP(), otp_Received);

	}

	@Given("the customer navigates to the Settings tab")
	public void theCustomerNavigatesToTheSettingsTab() throws InterruptedException {
		Thread.sleep(3500);

		ClickonElement(login.getSettings());
	}

	@Given("the customer clicks on the logout button")
	public void theCustomerClicksOnTheLogoutButton() {
		
		ClickonElement(login.getLogout());
	}
	
	@When("the customer clicks on the Continue button")
	public void theCustomerClicksOnTheContinueButton() throws InterruptedException {
		Thread.sleep(2000);
		ClickonElement(login.getContinueButton());
	}

	@Then("the customer should be logged in successfully")
	public void theCustomerShouldBeLoggedInSuccessfully() throws InterruptedException {
		Thread.sleep(10000);
		System.out.println("good ");
	}
	
	
	@Given("the staff enters their {string} address")
	public void theStaffEntersTheirAddress(String staffEmail) {
		ClickonElement(login.getContinueWithEmail());
		passInput(login.getContinueWithEmail(), getProperty(staffEmail));
		driver.hideKeyboard();
	}
	@When("the staff clicks on the Continue button")
	public void theStaffClicksOnTheContinueButton() {
		ClickonElement(login.getContinueButton());

		
	}
	@When("the staff enters the Otp")
	public void theStaffEntersTheOtp() throws InterruptedException {
		Thread.sleep(5000);
		String otp_Received = getOtpFromSource();
		System.out.println("The OTP is  : " + otp_Received);
		Thread.sleep(2000);
		passInputUsingActions(login.getOTP(), otp_Received);
	}
	@Then("the staff should be logged in successfully")
	public void theStaffShouldBeLoggedInSuccessfully() throws InterruptedException {
	   Thread.sleep(10000);
	   System.out.println("good");
	}

}
