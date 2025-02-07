package cucumberStepDefinition;

import com.WE.WE_Login_Details;
import com.baseClass.Base;

import io.cucumber.java.en.*;

public class UserSignUp extends Base {
	public static String otp_Received;
	WE_Login_Details signup = new WE_Login_Details(driver);

	@Given("the user clicks on the Sign Up button")
	public void theUserClicksOnTheSignUpButton() throws InterruptedException {
		Thread.sleep(9000);
		ClickonElement(signup.getSignUp());
	}

	@When("the user enters their {string} address")
	public void theUserEntersTheirAddress(String Email) throws InterruptedException {
		ClickonElement(signup.getContinueWithEmail());
		passInput(signup.getContinueWithEmail(), getProperty(Email));
		driver.hideKeyboard();
		Thread.sleep(3000);
		if (isElementAvailable(signup.getwelcome())) {
			ClickonElement(signup.getcheckbox());
		}
	}

	@When("the user clicks on the Continue button")
	public void theUserClicksOnTheContinueButton() {
		ClickonElement(signup.getContinueButton());
	}

	@Then("the user receives an OTP in their email")
	public void theUserReceivesAnOTPInTheirEmail() throws InterruptedException {
		Thread.sleep(4000);
		otp_Received = getOtpFromSource();
		System.out.println("The OTP is  : " + otp_Received);
	}

	@When("the user enters the OTP received in the email")
	public void theUserEntersTheOTPReceivedInTheEmail() throws InterruptedException {
		Thread.sleep(2000);
		passInputUsingActions(signup.getOTP(), otp_Received);
	}

	@Then("the user should be signed up successfully")
	public void theUserShouldBeSignedUpSuccessfully() throws InterruptedException {
		waitForElement(signup.getAddInfoPage());
		if (isElementAvailable(signup.getAddInfoPage())) {
			System.out.println("Successfully navigated to add info page");
		} else {
			System.out.println("doesn't navigated");
		}
	}
}
