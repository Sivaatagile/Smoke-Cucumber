package cucumberStepDefinition;

import com.WE.WE_Login_Details;
import com.baseClass.Base;

import io.cucumber.java.en.*;

public class LoginLogout extends Base {
	WE_Login_Details login = new WE_Login_Details(driver);

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

}
