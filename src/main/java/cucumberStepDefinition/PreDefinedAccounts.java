package cucumberStepDefinition;

import com.WE.WE_Login_Details;
import com.baseClass.Base;

import io.cucumber.java.en.*;

public class PreDefinedAccounts extends Base{
	WE_Login_Details login = new WE_Login_Details(driver);
	
	@Given("the user enters their predefined {string} address")
	public void theUserEntersTheirPredefinedAddress(String PredefinedEmailAddress) {
		ClickonElement(login.getContinueWithEmail());
		passInput(login.getContinueWithEmail(), getProperty(PredefinedEmailAddress));
		driver.hideKeyboard();
	}

	@When("the user enters the Predefined Otp {string}")
	public void theUserEntersThePredefinedOtp(String PredefinedOTP) throws InterruptedException {
		Thread.sleep(2000);
		waitForElement(login.getEnterORPaste());
		passInputUsingActions(login.getOTP(), getProperty(PredefinedOTP));
		driver.hideKeyboard();
	}
	
}
