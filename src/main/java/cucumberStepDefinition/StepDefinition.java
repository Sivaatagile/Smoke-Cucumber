package cucumberStepDefinition;

import java.io.IOException;
import java.net.MalformedURLException;

import com.WE.WE_Login_Details;
import com.baseClass.Base;

import io.cucumber.java.en.*;

public class StepDefinition extends Base {

	WE_Login_Details Login = new WE_Login_Details(driver);

	@Then("Successfully navigated to the login screen")
	public void successfullyNavigatedToTheLoginScreen() {
		System.out.println("Successfully opened the application");
	}

	@Given("Enter the Users valid E-mail adddress")
	public void enterTheUsersValidEMailAdddress() throws InterruptedException {
		System.out.println(Login.getContinueWithEmail());
		System.out.println("temp1");
		ClickonElement(Login.getContinueWithEmail());
		Thread.sleep(3000);
		passInput(Login.getContinueWithEmail(), getProperty("PREDEFINED_CUSTOMER_EMAIL"));
		driver.hideKeyboard();
		ClickonElement(Login.getContinueButton());
	}

	@Given("Enter the Predefined OTP")
	public void enterThePredefinedOTP() throws InterruptedException {
		waitForElement(Login.getEnterORPaste());
		passInputUsingActions(Login.getOTP(), getProperty("PREDEFINED_CUSTOMER_OTP"));
		driver.hideKeyboard();
	}

	@When("After enter the otp validate the respected otp and logged in")
	public void afterEnterTheOtpValidateTheRespectedOtpAndLoggedIn() throws InterruptedException {
		waitForElement(Login.getPending_Tab());
		System.out.println("cyv");
	}

	@Then("Successfully logged in to the User account")
	public void successfullyLoggedInToTheUserAccount() {
		System.out.println("Successfully logged in");
	}

}
