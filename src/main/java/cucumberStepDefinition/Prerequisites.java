package cucumberStepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import com.WE.WE_Info;
import com.WE.WE_Login_Details;
import com.api.Api;
import com.baseClass.Base;

import io.cucumber.java.en.*;

public class Prerequisites extends Base{

	@Given("PropertyFile Loaded")
	public void propertyfileLoaded() throws IOException {
		method1("First");
		 UpdateEmailProperty("SIGNUP_EMAIL");
			UpdateNameProperty("PET_NAME");
			UpdateNameProperty("CUSTOMER_FIRSTNAME");
			UpdateEmailProperty("CUSTOMER_EMAIL");
			UpdateNameProperty("SERVICE_NAME");
			UpdateNameProperty("ADDON_PRIVILAGE");
			UpdateNameProperty("ADDON_ASSIGNABLE");
			UpdateNameProperty("ADDON_SERVICE_NAME");
			UpdateNameProperty("ADMIN_STAFF_FIRST_NAME");
			UpdateEmailProperty("ADMIN_STAFF_EMAIL");
			UpdateNameProperty("ADMIN_ADMIN_FIRST_NAME");
			UpdateEmailProperty("ADMIN_ADMIN_EMAIL");
			UpdateNameProperty("ADMIN_TAG_CATEGORY_NAME");
			UpdateNameProperty("ADMIN_BREED_NAME");
			UpdateNameProperty("SLOT_NAME");
			System.out.println("working fine");
		System.out.println("property loaded");
	}

	@Given("Configure driver")
	public void configureDriver() throws IOException {
		method1("First");
		System.out.println("gctgt");
	}

	@Given("Open the application")
	public void openTheApplication() throws MalformedURLException {
		OpenApplicationWithoutReset();
		System.out.println("cyhcvf");
	}
	
	@Given("Api configuration")
	public void apiConfiguration() throws InterruptedException {
		Api.signInAdmin(getProperty("PREDEFINED_ADMIN_EMAIL"));
		Api.verifyOtp(getProperty("PREDEFINED_ADMIN_OTP"));
		Api.refreshAdminToken(Api.VerifiedRefreshToken);
		Api.ServiceSlotTimeCount();
		Api.OverallSlotList();
	}
	
	@When("the user enters the Predefined {string}")
	public void theUserEntersThePredefined(String OTP) throws InterruptedException {
		WE_Login_Details login = new WE_Login_Details(driver);
		waitForElement(login.getEnterORPaste());
		passInputUsingActions(login.getOTP(), getProperty(OTP));
		driver.hideKeyboard();
	}

	@Then("the user should be logged in successfully")
	public void theUserShouldBeLoggedInSuccessfully() {
	    
	}
	
	
	@Given("the admin clears the application cache")
	public void theAdminClearsTheApplicationCache() throws IOException, InterruptedException {
		 clearAppCache(getProperty("APP_PACKAGE"));
	}

	@When("the admin opens the application")
	public void theAdminOpensTheApplication() throws MalformedURLException, InterruptedException {
		Thread.sleep(5000);
		appli();
	}
	
	@Then("the application launches successfully")
	public void theApplicationLaunchesSuccessfully() {
	    System.out.println("Check if the application is open");
	}

	@Then("the admin is navigated to the login page \\(or home page if already logged in)")
	public void theAdminIsNavigatedToTheLoginPageOrHomePageIfAlreadyLoggedIn() {
	    
	}

	
}
