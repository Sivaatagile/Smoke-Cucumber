package com.testing;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.WE.WE_Admin_Services.AddOnType;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Info;
import com.api.Api;
import com.baseClass.Base;
import com.frontend.Admin_Services;
import com.frontend.Admin_Settings;
import com.frontend.Admin_User;
import com.frontend.Admin_Workflow;
import com.frontend.Customer_Bookingflow;
import com.frontend.Customer_Home;
import com.frontend.Customer_Settings;
import com.frontend.Edit;
import com.frontend.Info;
import com.frontend.Login_Details;
import com.frontend.sample;

import io.appium.java_client.android.options.UiAutomator2Options;
	public class TestRun extends Base{
	
	public static void main(String[] args) throws Exception {
		
		WE_Info info = new WE_Info(driver);
		Api Api= new Api(driver);

		ChooseApi(API_BASE_URL.Staging);
		PropertyFile("Data");
//		Latest_StagingAPK_download(getProperty("AUTOMATION"));
//		Application();	
		OpenApplicationWithoutReset();
//		
		Api.signInAdmin(getProperty("PREDEFINED_ADMIN_EMAIL"));
		Api.verifyOtp(getProperty("PREDEFINED_ADMIN_OTP"));
		Api.refreshAdminToken(Api.VerifiedRefreshToken);
//		Api.ServiceSlotTimeCount(getProperty("SERVICE_NAME"));
//		Api.OverallSlotList();
//		Api.OverallTagList();
//		Api.BreedList();
//		
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
//	
//		UpdateEmailProperty("SIGNUP_EMAIL");	
//		UpdateNameProperty("SIGNUP_FIRSTNAME",getProperty("NAME"));
//		UpdateNameProperty("SIGNUP_LASTNAME",getProperty("NAME"));
//		UpdateNameProperty("SIGNUP_CITYTOWN", getProperty("CITY"));
//		UpdateNameProperty("SIGNUP_POSTCODE", getProperty("POSTCODE"));
//		UpdateNameProperty("PET_NAME", getProperty("PET_NAME_List"));
//		UpdateEmailProperty("ADMIN_ADMIN_EMAIL");
//        UpdateNameProperty("ADMIN_ADMIN_FIRST_NAME", getProperty("NAME"));
//		UpdateNameProperty("ADMIN_ADMIN_LAST_NAME",getProperty("NAME"));
//        UpdateNameProperty("ADMIN_ADMIN_CITY", getProperty("CITY"));
//		UpdateNameProperty("ADMIN_ADMIN_POSTCODE", getProperty("POSTCODE"));
//		UpdateEmailProperty("ADMIN_CUSTOMER_EMAIL");
//		UpdateNameProperty("ADMIN_CUSTOMER_FIRSTNAME",getProperty("NAME"));
//		UpdateNameProperty("ADMIN_CUSTOMER_LASTNAME",getProperty("NAME"));
//		UpdateNameProperty("ADMIN_CUSTOMER_CITYTOWN", getProperty("CITY"));
//		UpdateNameProperty("ADMIN_CUSTOMER_POSTCODE", getProperty("POSTCODE"));
//		UpdateEmailProperty("ADMIN_STAFF_EMAIL");
//        UpdateNameProperty("ADMIN_STAFF_FIRST_NAME", getProperty("NAME"));
//        UpdateNameProperty("ADMIN_STAFF_LAST_NAME", getProperty("NAME"));
//    	UpdateNameProperty("ADMIN_STAFF_CITY", getProperty("CITY"));
//		UpdateNameProperty("ADMIN_STAFF_POSTCODE", getProperty("POSTCODE"));
//		UpdateEmailProperty("ADMIN_STAFF_2_EMAIL");
//        UpdateNameProperty("ADMIN_STAFF_2_FIRST_NAME", getProperty("NAME"));
//        UpdateNameProperty("ADMIN_STAFF_2_LAST_NAME", getProperty("NAME"));
//    	UpdateNameProperty("ADMIN_STAFF_2_CITY", getProperty("CITY"));
//		UpdateNameProperty("ADMIN_STAFF_2_POSTCODE", getProperty("POSTCODE"));
//		UpdateNameProperty("SECOND_PET_NAME", getProperty("PET_NAME_List"));
//	
//		PropertyFile("Data");
//		
//		Login_Details.signupCustomer();
//		Info.User_Data();
//		Info.Pet_Data();
//		Thread.sleep(9000);
//		ClickonElement(WE_Info.getcloseApp());
//		if (PreprodEnvironment) {
//			clearAppCache(getProperty("PREPROD_APP_PACKAGE"));
//			AfterClearCacheOpenApplication();
//		}else {
//			clearAppCache(getProperty("APP_PACKAGE"));
//		}		AfterClearCacheOpenApplication();
//		
//		
//		Login_Details.login_Admin();
//		Admin_User.approveUserUsingSearch();
//		Admin_User.Create_Admin();
//		Admin_User.Create_Customer();
//		Admin_User.CreateTag();
//		Admin_Services.slot_creation();
//		Admin_Services.ServiceCreation();	
//		Admin_User.Create_Staff();
//		Admin_User.Create_Second_Staff();
//		Admin_Settings.CreateBreed();
//		Admin_Settings.CreatePool();
//		Admin_Settings.CreatePricingRulePremium();  
//		Admin_Settings.CreatePricingRuleDiscount();  
//		Admin_Settings.CreatePricingRuleNotAvailable();
//		Login_Details.Logout_Admin();
//		
//		
//		Login_Details.login_Customer();
//		Customer_Bookingflow.booking();
//		Customer_Bookingflow.BookingSuccessfullPage();
//		Customer_Settings.MyBookings();
//		Customer_Settings.Invoices();
//		Customer_Settings.statement();
//		Customer_Settings.Accounts();
//		Login_Details.Logout_Customer();
//		
//		
//		Login_Details.login_Admin();
//		Admin_Settings.UpdateCreditLimit();
//		Admin_Settings.Adhoc();
//		Admin_Settings.Admin_Invoices();
//		Admin_Settings.Admin_Statement();
//		Admin_Workflow.Pending_to_UnAssigned();
//		Admin_Workflow.UnAssigned_to_Assigned();
//		Thread.sleep(3000);
//		Admin_User.second_pet();
//		Login_Details.Logout_Admin();	
//				
//		Login_Details.login_Customer();
//		Customer_Bookingflow.TwoPetBooking();
//		Customer_Bookingflow.BookingSuccessfullPage();
//		Customer_Settings.MyBookings();
//		Customer_Settings.Accounts();	
//		Customer_Home.Customer_Add_pet();
//		Login_Details.Logout_Customer();
//				
//		Login_Details.login_Admin();
//		Admin_User.approvePetUsingSearch();
//		Login_Details.Logout_Admin();	
//			
////////***********************************************************     Pricing rule date booking 
//
//		Login_Details.login_Customer();
//		Customer_Bookingflow.BookingFlow("DISCOUNT", getProperty("SERVICE_NAME"), MergePricingruleDate(getProperty("TO_Month_Discount_PricingRule"),getProperty("TO_Date_Discount_PricingRule"),getProperty("TO_Year_Discount_PricingRule")), SelectOneRandomlyFromList(Api.slotNames));	
//		Customer_Bookingflow.BookingFlow("PREMIUM", getProperty("SERVICE_NAME"), MergePricingruleDate(getProperty("TO_Month_Premium_PricingRule"),getProperty("TO_Date_Premium_PricingRule"),getProperty("TO_Year_Premium_PricingRule")), SelectOneRandomlyFromList(Api.slotNames));	
//		Customer_Bookingflow.BookingFlow("NOT AVAILABLE", getProperty("SERVICE_NAME"), MergePricingruleDate(getProperty("TO_Month_PricingRule_NotAvailable"),getProperty("TO_Date_PricingRule_NotAvailable"),getProperty("TO_Year_PricingRule_NotAvailable")), SelectOneRandomlyFromList(Api.slotNames));	
//		Login_Details.Logout_Customer();
//		
//		Edit.EditStaff();
//		Edit.EditCustomer();
//		Edit.EditAdmin();
//Edit.EditTag();
//		Edit.EditService();
//	
//		Edit.EditAddon();
//		Edit.EditSlot();
		
		
		sample.Servicewd();
		
		
		
		
//		Login_Details.login_Customer();
		Customer_Bookingflow.BookingforAddonservice();
//		Admin_Workflow.Assigned_TO_Reassigned();
		
		
		
		
		
		
		
		
		
		
	
		
//		String generateRandomString = generateRandomString(7);
//		deleteAllEmails();
//		System.out.println(generateRandomString);
//		Api.signInAdmin(getProperty("PREDEFINED_ADMIN_EMAIL"));
//		Api.verifyOtp(getProperty("PREDEFINED_ADMIN_OTP"));
//		Api.ServiceSlotTimeCount();
//		Api.OverallSlotList();					
//		OpenApplicationWithoutReset();
//		Admin_Services.AddonCreation(AddOnType.ASSIGNABLE, getProperty("ADDON_ASSIGNABLE"));
//		Customer_Settings.Accounts();
//		Customer_Bookingflow.TwoPetBooking();
//		Admin_User.second_pet();
//		Login_Details.stafflogout();	
//		Api.signInAdmin(getProperty("PREDEFINED_ADMIN_EMAIL"));
//		Api.verifyOtp(getProperty("PREDEFINED_ADMIN_OTP"));
//		Api.ServiceSlotTimeCount();
//		Api.OverallSlotList();																																																																															
//		OpenApplicationWithoutReset();
//		Login_Details.login_Admin();
//		Admin_User.Create_Customer();
//		Admin_Workflow.Booking_For_Customer_As_Admin();
//		Admin_Settings.CreatePricingRule();
//		Login_Details.Logout_Admin();
//		Api.signInAdmin(getProperty("PREDEFINED_ADMIN_EMAIL"));
//		Api.verifyOtp(getProperty("PREDEFINED_ADMIN_OTP"));
//		Api.refreshAdminToken(Api.VerifiedRefreshToken);
//		Api.ServiceSlotTimeCount();
//		Api.OverallSlotList();
//		Latest_StagingAPK_download(getProperty("STAGING"));
//		Application();
//		Login_Details.Predefined_login_Customer();
//		Api.ServiceSlotTimeCount();
//		Customer_Bookingflow.booking();
//		Customer_Bookingflow.SingleDateBooking(Admin_Settings.prdate);
//		Customer_Bookingflow.BookingSuccessfullPage();
//		Customer_Settings.MyBookings();
//		Customer_Settings.Invoices();
//		Customer_Settings.statement();
//		Login_Details.Logout_Customer();
//		Login_Details.login_Admin();
//		Admin_Workflow.Pending_to_UnAssigned();
//		Admin_Workflow.UnAssigned_to_Assigned();
//

			
	}

}
