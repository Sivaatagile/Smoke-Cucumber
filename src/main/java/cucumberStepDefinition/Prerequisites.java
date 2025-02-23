package cucumberStepDefinition;

import java.io.IOException;
import java.net.MalformedURLException;


import com.WE.WE_Login_Details;
import com.api.Api;
import com.baseClass.Base;

import io.cucumber.java.en.*;

public class Prerequisites extends Base {
	Api Api= new Api(driver);
	WE_Login_Details login = new WE_Login_Details(driver);
	
	@Given("PropertyFile Loaded")
	public void propertyfileLoaded() throws IOException, InterruptedException {
		ChooseApi(API_BASE_URL.Automation);
		PropertyFile("Data");
		
		com.api.Api.signInAdmin(getProperty("PREDEFINED_ADMIN_EMAIL"));
		com.api.Api.verifyOtp(getProperty("PREDEFINED_ADMIN_OTP"));
		com.api.Api.refreshAdminToken(com.api.Api.VerifiedRefreshToken);
		
//		com.api.Api.ServiceSlotTimeCount(getProperty("SERVICE_NAME"));
//		com.api.Api.OverallSlotList();
//		com.api.Api.BreedList();
//		com.api.Api.Compare("BREED_Name",com.api.Api.UniqueBreed, com.api.Api.BreedNames, getProperty("BREED"));
//		com.api.Api.ServiceList();
//		com.api.Api.Compare("SERVICE_NAME", com.api.Api.UniqueService, com.api.Api.ServiceNames, getProperty("SERVICE"));
//		com.api.Api.Compare("ADDON_SERVICE_NAME", com.api.Api.UniqueService, com.api.Api.ServiceNames, getProperty("SERVICE"));
//		com.api.Api.SlotList();
//		com.api.Api.Compare("SLOT_NAME", com.api.Api.UniqueSlot, com.api.Api.SlotNames, getProperty("SLOTS"));
//		com.api.Api.AddonList();
//		com.api.Api.Compare("ADDON_PRIVILAGE", com.api.Api.UniqueAddons, com.api.Api.AddonsNames, getProperty("ADDON"));
//		com.api.Api.Compare("ADDON_ASSIGNABLE", com.api.Api.UniqueAddons, com.api.Api.AddonsNames, getProperty("ADDON"));
//		com.api.Api.TagList();
//		com.api.Api.Compare("ADMIN_TAG_CATEGORY_NAME", com.api.Api.UniqueTag, com.api.Api.TagNames, getProperty("TAGS"));
//		com.api.Api.PricingRuleList();
//		com.api.Api.Compare("Pricingrulename_Onetime_premium", com.api.Api.Uniquepricingrulename, com.api.Api.PricingRuleNames, getProperty("PREMIUM_PRICINGRULE_NAME"));
//		com.api.Api.Compare("Pricingrulename_Onetime_discount", com.api.Api.Uniquepricingrulename, com.api.Api.PricingRuleNames, getProperty("DISCOUNT_PRICINGRULE_NAME"));
//		com.api.Api.Compare("Pricingrulename_Onetime_notavailable", com.api.Api.Uniquepricingrulename, com.api.Api.PricingRuleNames, getProperty("NOTAVAILABLE_PRICINGRULE_NAME"));
//		com.api.Api.PoolingList();
//		com.api.Api.Compare("POOL_NAME", com.api.Api.Uniquepoolingname, com.api.Api.PoolingNames, getProperty("POOL"));
//		
//		UpdateEmailProperty("SIGNUP_EMAIL");	
//		UpdateNameProperty("SIGNUP_FIRSTNAME",getProperty("NAME"));
//		UpdateNameProperty("SIGNUP_LASTNAME",getProperty("NAME"));
//		UpdateNameProperty("SIGNUP_CITYTOWN", getProperty("CITY"));
//		UpdateNameProperty("SIGNUP_POSTCODE", getProperty("POSTCODE"));
//		
//		UpdateNameProperty("PET_NAME", getProperty("PET_NAME_List"));
//		
//		UpdateEmailProperty("ADMIN_ADMIN_EMAIL");
//        UpdateNameProperty("ADMIN_ADMIN_FIRST_NAME", getProperty("NAME"));
//		UpdateNameProperty("ADMIN_ADMIN_LAST_NAME",getProperty("NAME"));
//        UpdateNameProperty("ADMIN_ADMIN_CITY", getProperty("CITY"));
//		UpdateNameProperty("ADMIN_ADMIN_POSTCODE", getProperty("POSTCODE"));
//		
//		UpdateEmailProperty("ADMIN_CUSTOMER_EMAIL");
//		UpdateNameProperty("ADMIN_CUSTOMER_FIRSTNAME",getProperty("NAME"));
//		UpdateNameProperty("ADMIN_CUSTOMER_LASTNAME",getProperty("NAME"));
//		UpdateNameProperty("ADMIN_CUSTOMER_CITYTOWN", getProperty("CITY"));
//		UpdateNameProperty("ADMIN_CUSTOMER_POSTCODE", getProperty("POSTCODE"));
//		
//		UpdateEmailProperty("ADMIN_STAFF_EMAIL");
//        UpdateNameProperty("ADMIN_STAFF_FIRST_NAME", getProperty("NAME"));
//        UpdateNameProperty("ADMIN_STAFF_LAST_NAME", getProperty("NAME"));
//    	UpdateNameProperty("ADMIN_STAFF_CITY", getProperty("CITY"));
//		UpdateNameProperty("ADMIN_STAFF_POSTCODE", getProperty("POSTCODE"));
//		
//		UpdateEmailProperty("ADMIN_STAFF_2_EMAIL");
//        UpdateNameProperty("ADMIN_STAFF_2_FIRST_NAME", getProperty("NAME"));
//        UpdateNameProperty("ADMIN_STAFF_2_LAST_NAME", getProperty("NAME"));
//    	UpdateNameProperty("ADMIN_STAFF_2_CITY", getProperty("CITY"));
//		UpdateNameProperty("ADMIN_STAFF_2_POSTCODE", getProperty("POSTCODE"));
//		
//		UpdateNameProperty("SECOND_PET_NAME", getProperty("PET_NAME_List"));		

		PropertyFile("Data");
	}

	@Given("Configure driver")
	public void configureDriver() throws IOException {
        System.out.println(driver);
	}

	@Given("Api configuration")
	public void apiConfiguration() throws InterruptedException, IOException {
		com.api.Api.signInAdmin(getProperty("PREDEFINED_ADMIN_EMAIL"));
		com.api.Api.verifyOtp(getProperty("PREDEFINED_ADMIN_OTP"));
		com.api.Api.refreshAdminToken(com.api.Api.VerifiedRefreshToken);
		PropertyFile("Data");
	}
	
	@Given("Open the application")
	public void openTheApplication() throws MalformedURLException, InterruptedException {
		Latest_StagingAPK_download(getProperty("AUTOMATION"));
		Application();
//		OpenApplicationWithoutReset();
//		ApplicationWithApk("Preprod_v1.7.1_7-2-25.apk");
		System.out.println("\033[1mOpen the application\033[0m");
	}

	@Then("Successfully navigated to the login screen")
	public void successfullyNavigatedToTheLoginScreen() {
		System.out.println("\033[1mSuccessfully opened the application\033[0m");
	}
	
	@Given("the admin clears the application cache")
	public void theAdminClearsTheApplicationCache() throws IOException, InterruptedException {
		if (PreprodEnvironment) {
			clearAppCache(getProperty("PREPROD_APP_PACKAGE"));
		}else {
			clearAppCache(getProperty("APP_PACKAGE"));
		}	
	}

	@When("the admin opens the application")
	public void theAdminOpensTheApplication() throws MalformedURLException, InterruptedException {
		AfterClearCacheOpenApplication();
	}

	@Then("the application launches successfully")
	public void theApplicationLaunchesSuccessfully() {
		System.out.println("\033[1mCheck if the application is open\033[0m");
	}

	@Then("the admin is navigated to the login page \\(or home page if already logged in)")
	public void theAdminIsNavigatedToTheLoginPageOrHomePageIfAlreadyLoggedIn() throws InterruptedException {
//       Thread.sleep(7000);
//		waitForElement(login.getSignin());
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

	

}
