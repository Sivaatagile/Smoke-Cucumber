package cucumberStepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.interactions.Actions;

import com.WE.WE_Info;
import com.WE.WE_Login_Details;
import com.api.Api;
import com.baseClass.Base;
import com.baseClass.Base.API_BASE_URL;

import io.cucumber.java.en.*;

public class Prerequisites extends Base {

	@Given("PropertyFile Loaded")
	public void propertyfileLoaded() throws IOException {
		ChooseApi(API_BASE_URL.Automation);
		PropertyFile("First");
		
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
//		UpdateNameProperty("ADMIN_TAG_CATEGORY_NAME", getProperty("TAGS"));
//
//		UpdateNameProperty("SLOT_NAME", getProperty("SLOTS"));
//
//	    UpdateNameProperty("SERVICE_NAME", getProperty("SERVICE"));
//	    UpdateNameProperty("ADDON_PRIVILAGE", getProperty("ADDON"));
//	    UpdateNameProperty("ADDON_ASSIGNABLE", getProperty("ADDON"));
//	    UpdateNameProperty("ADDON_SERVICE_NAME", getProperty("SERVICE"));
//
//		UpdateEmailProperty("ADMIN_STAFF_EMAIL");
//        UpdateNameProperty("ADMIN_STAFF_FIRST_NAME", getProperty("NAME"));
//        UpdateNameProperty("ADMIN_STAFF_LAST_NAME", getProperty("NAME"));
//    	UpdateNameProperty("ADMIN_STAFF_CITY", getProperty("CITY"));
//		UpdateNameProperty("ADMIN_STAFF_POSTCODE", getProperty("POSTCODE"));
//	    
//		UpdateNameProperty("BREED_Name", getProperty("BREED"));
//
//		UpdateNameProperty("POOL_NAME", getProperty("POOL"));
//
//		UpdateNameProperty("Pricingrulename_Onetime_premium", getProperty("PREMIUM_PRICINGRULE_NAME"));
//		UpdateNameProperty("Pricingrulename_Onetime_discount", getProperty("DISCOUNT_PRICINGRULE_NAME"));
//		UpdateNameProperty("Pricingrulename_Onetime_notavailable", getProperty("NOTAVAILABLE_PRICINGRULE_NAME"));
//
//		UpdateNameProperty("SECOND_PET_NAME", getProperty("PET_NAME_List"));

		System.out.println("working fine");
		System.out.println("property loaded");
	}

	@Given("Configure driver")
	public void configureDriver() throws IOException {
		PropertyFile("First");
		System.out.println("gctgt");
	}

	@Given("Open the application")
	public void openTheApplication() throws MalformedURLException, InterruptedException {
		Latest_StagingAPK_download(getProperty("AUTOMATION"));
		Application();
//		OpenApplicationWithoutReset();
//		ApplicationWithApk("Preprod_v1.7.1_7-2-25.apk");
		System.out.println("cyhcvf");
	}

	@Given("Api configuration")
	public void apiConfiguration() throws InterruptedException, IOException {
		Api Api= new Api(driver);
		
		Api.signInAdmin(getProperty("PREDEFINED_ADMIN_EMAIL"));
		Api.verifyOtp(getProperty("PREDEFINED_ADMIN_OTP"));
		Api.refreshAdminToken(Api.VerifiedRefreshToken);
		Api.ServiceSlotTimeCount();
		Api.OverallSlotList();
//		Api.BreedList();
//		Api.Compare("BREED_Name",Api.UniqueBreed, Api.BreedNames, getProperty("BREED"));
//		Api.ServiceList();
//		Api.Compare("SERVICE_NAME", Api.UniqueService, Api.ServiceNames, getProperty("SERVICE"));
//		Api.Compare("ADDON_SERVICE_NAME", Api.UniqueService, Api.ServiceNames, getProperty("SERVICE"));
//		Api.SlotList();
//		Api.Compare("SLOT_NAME", Api.UniqueSlot, Api.SlotNames, getProperty("SLOTS"));
//		Api.AddonList();
//		Api.Compare("ADDON_PRIVILAGE", Api.UniqueAddons, Api.AddonsNames, getProperty("ADDON"));
//		Api.Compare("ADDON_ASSIGNABLE", Api.UniqueAddons, Api.AddonsNames, getProperty("ADDON"));
//		Api.TagList();
//		Api.Compare("ADMIN_TAG_CATEGORY_NAME", Api.UniqueTag, Api.TagNames, getProperty("TAGS"));
//		Api.PricingRuleList();
//		Api.Compare("Pricingrulename_Onetime_premium", Api.Uniquepricingrulename, Api.PricingRuleNames, getProperty("PREMIUM_PRICINGRULE_NAME"));
//		Api.Compare("Pricingrulename_Onetime_discount", Api.Uniquepricingrulename, Api.PricingRuleNames, getProperty("DISCOUNT_PRICINGRULE_NAME"));
//		Api.Compare("Pricingrulename_Onetime_notavailable", Api.Uniquepricingrulename, Api.PricingRuleNames, getProperty("NOTAVAILABLE_PRICINGRULE_NAME"));
//		Api.PoolingList();
//		Api.Compare("POOL_NAME", Api.Uniquepoolingname, Api.PoolingNames, getProperty("POOL"));
	
		PropertyFile("First");
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
		if (PreprodEnvironment) {
			clearAppCache(getProperty("PREPROD_APP_PACKAGE"));
		}else {
			clearAppCache(getProperty("APP_PACKAGE"));
		}
		
	}

	@When("the admin opens the application")
	public void theAdminOpensTheApplication() throws MalformedURLException, InterruptedException {
		Thread.sleep(5000);
		AfterClearCacheOpenApplication();
	}

	@Then("the application launches successfully")
	public void theApplicationLaunchesSuccessfully() {
		System.out.println("Check if the application is open");
	}

	@Then("the admin is navigated to the login page \\(or home page if already logged in)")
	public void theAdminIsNavigatedToTheLoginPageOrHomePageIfAlreadyLoggedIn() {

	}

}
