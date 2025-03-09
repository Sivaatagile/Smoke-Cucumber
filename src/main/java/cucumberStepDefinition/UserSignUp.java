package cucumberStepDefinition;

import com.WE.WE_Login_Details;
import com.baseClass.Base;

import io.cucumber.java.en.*;

public class UserSignUp extends Base {
	public static String otp_Received;
	WE_Login_Details signup = new WE_Login_Details(driver);

	@Given("User clicks on the Sign Up button")
	public void theUserClicksOnTheSignUpButton() throws InterruptedException {
		ClickonElement(signup.getSignUp());
	}

	@When("User enters their {string} address")
	public void theUserEntersTheirAddress(String Email) throws InterruptedException {
		ClickonElement(signup.getContinueWithEmail());
		passInput(signup.getContinueWithEmail(), getProperty(Email));
		driver.hideKeyboard();
		if (isElementAvailable(signup.getwelcome())) {
			ClickonElement(signup.getcheckbox());
		}
	}

	@When("User clicks on the Continue button")
	public void theUserClicksOnTheContinueButton() {
		ClickonElement(signup.getContinueButton());
	}

	@Then("User receives an OTP in their email")
	public void theUserReceivesAnOTPInTheirEmail() throws InterruptedException {
		otp_Received = getOtpFromSource1();
		System.out.println("The OTP is  : " + otp_Received);
	}

	@When("User enters the OTP received in the email")
	public void theUserEntersTheOTPReceivedInTheEmail() throws InterruptedException {
		passInputUsingActions(signup.getOTP(), otp_Received);
	}

	@Then("User should be signed up successfully")
	public void theUserShouldBeSignedUpSuccessfully() throws InterruptedException {
		waitForElement(signup.getAddInfoPage());
		if (isElementAvailable(signup.getAddInfoPage())) {
			System.out.println("Successfully navigated to add info page");
		} else {
			System.out.println("doesn't navigated");
		}
	}
	

}
