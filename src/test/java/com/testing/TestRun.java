package com.testing;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.WE.WE_Info;
import com.api.Api;
import com.baseClass.Base;
import com.frontend.Admin_Services;
import com.frontend.Admin_Settings;
import com.frontend.Admin_User;
import com.frontend.Admin_Workflow;
import com.frontend.Customer_Bookingflow;
import com.frontend.Customer_Settings;
import com.frontend.Info;
import com.frontend.Login_Details;
import com.frontend.sample;

import io.appium.java_client.android.options.UiAutomator2Options;

public class TestRun extends Base {

	@BeforeTest()
	public static void load_Properties() throws IOException {
		method1("First");
	}

	@BeforeTest(dependsOnMethods = { "load_Properties" })
	public static void ApiRunner() throws InterruptedException {
		Api.signInAdmin(getProperty("PREDEFINED_ADMIN_EMAIL"));
		Api.verifyOtp(getProperty("PREDEFINED_ADMIN_OTP"));
		Api.refreshAdminToken(Api.VerifiedRefreshToken);
		Api.ServiceSlotTimeCount();
		Api.OverallSlotList();
	}

//
	@BeforeTest(dependsOnMethods = { "ApiRunner" })
	public static void DownloadApk() throws InterruptedException, MalformedURLException {
		Latest_StagingAPK_download(getProperty("STAGING"));
		Application();
	}

//	@Test(priority = 1)
//	public static void signupCustomer() throws Exception {
//
//		WE_Info info = new WE_Info(driver);
//		OpenApplicationWithoutReset();
//		Login_Details.signupCustomer();
//		Info.User_Data();
//		Thread.sleep(2000);
//		Info.Pet_Data();
//		Thread.sleep(2000);
//		info.getcloseApp();
//	}
//
//	@Test(priority = 2)
//	public static void Clear_Cache() throws IOException {
//
//		clearCache();
//		OpenApplication();
//		Runtime.getRuntime().exec("adb shell pm clear com.petcaretechnologies.app");
//	}
//
//	@Test(priority = 3)
//	public static void AdminLogin() throws Exception {
//
//		Login_Details.login_Admin();
//		Thread.sleep(3000);
//		System.out.println("completed");
//	}
//
//	@Test(priority = 4)
//	public static void NewUserApproval() throws Exception {
//
//		Admin_User.approveUserUsingSearch();
//		Thread.sleep(4000);
//		System.out.println("completed");
//	}
//
//	@Test(priority = 5)
//	public static void CreateAdmin() throws InterruptedException {
//
//		Admin_User.Create_Admin();
//		Thread.sleep(4000);
//		System.out.println("completed");
//	}
//
//	@Test(priority = 6)
//	public static void CreateStaff() throws InterruptedException {
//
//		Admin_User.Create_Staff();
//		Thread.sleep(4000);
//		System.out.println("completed");
//	}
//
//	@Test(priority = 7)
//	public static void CreateTag() throws Exception {
//
//		Admin_User.CreateTag();
//		Thread.sleep(4000);
//		System.out.println("completed");
//	}
//
//	@Test(priority = 8)
//	public static void CreateSlot() throws Exception {
//		Admin_Services.slot_creation();
//		Thread.sleep(4000);
//		System.out.println("completed");
//	}
//
//	@Test(priority = 9)
//	public static void ServiceCreation() throws Exception {
//		Api.refreshAdminToken(Api.VerifiedRefreshToken);
//		Api.OverallSlotList();
//		Admin_Services.ServiceCreation();
//		Thread.sleep(4000);
//		System.out.println("completed");
//	}
//
//	@Test(priority = 10)
//	public static void Logout_Admin() {
//		Login_Details.Logout_Admin();
//	}
//
	@Test(priority = 11)
	public static void Login_PredefinedCustomer() throws InterruptedException, MalformedURLException {

//		OpenApplication();
		Login_Details.Predefined_login_Customer();

	}

	@Test(priority = 12)
	public static void BookingFlowCustomer() throws Exception {
		Api.ServiceSlotTimeCount();
		Customer_Bookingflow.booking();
		Customer_Bookingflow.BookingSuccessfullPage();
		Customer_Settings.MyBookings();
		Customer_Settings.Invoices();
		Customer_Settings.statement();
	}

	public static void main(String[] args) throws Exception {
//		String generateRandomString = generateRandomString(7);
////		deleteAllEmails();
//		System.out.println(generateRandomString);
		
		method1("First");
		Api.signInAdmin(getProperty("PREDEFINED_ADMIN_EMAIL"));
		Api.verifyOtp(getProperty("PREDEFINED_ADMIN_OTP"));
		Api.ServiceSlotTimeCount();
		Api.OverallSlotList();					
		OpenApplicationWithoutReset();
		Customer_Bookingflow.TwoPetBooking();
//		Admin_User.second_pet();
//		Login_Details.stafflogout();	
		
		
		
//		Api.signInAdmin(getProperty("PREDEFINED_ADMIN_EMAIL"));
//		Api.verifyOtp(getProperty("PREDEFINED_ADMIN_OTP"));
//		Api.ServiceSlotTimeCount();
//		Api.OverallSlotList();																																																																															
//		OpenApplicationWithoutReset();
//		Login_Details.login_Admin();
//		Admin_User.Create_Customer();
////		Admin_Workflow.Booking_For_Customer_As_Admin();
//		Admin_Settings.CreatePricingRule();
//		Login_Details.Logout_Admin();
////
//////		Api.signInAdmin(getProperty("PREDEFINED_ADMIN_EMAIL"));
//////		Api.verifyOtp(getProperty("PREDEFINED_ADMIN_OTP"));
//////		Api.refreshAdminToken(Api.VerifiedRefreshToken);
//////		Api.ServiceSlotTimeCount();
//////		Api.OverallSlotList();
//////		
//////		Latest_StagingAPK_download(getProperty("STAGING"));
//////		Application();
//		Login_Details.Predefined_login_Customer();
////		Api.ServiceSlotTimeCount();
////		Customer_Bookingflow.booking();
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
//		// Construct the path to the HTML file
////		 Thread.sleep(10000);
////		 
//	        String reportPath = System.getProperty("user.dir")+"/target/cucumber-reports123/index.html"; // Update with your report path
//	        Base.sendEmailWithReport(
//	                "developer@agilecyber.com",
//	                "Cucumber Test Report",
//	                "Please find the attached test report"
//	                + "Total Number of Tests= 18"
//	                		+ "total number of tests passed =17"
//	                + "Failed = 1",
//	                
//	                reportPath
//	        );
		
		
		
		
		
		
//		Response Status Code: 200
//		Names: [not available pricing, Not available, not, No, Pricing, Onetime, Onetimew, OnetimeRH, OnetimeRHWU, OnetimeRHWUQUL]
//		Priorities: [0, 0, 0, 0, 1, 2, 3, 4, 5, 6]
//		gggg  :  [7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100]
//		Smallest number in range: 7
//		Converted String: 7
//		Find out
//		Month  : January
//		Date  : 5
//		Year  : 2025
//		Target element not found, scrolling...
//		Target element found
//		Month  : February
//		Target element found
//		Date  : 5
//		Target element found
//		Year  : 2025
//		Month  : February
//		Date  : 5
//		Year  : 2025
//		yyyy  :  February52025
	}

}
