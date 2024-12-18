package com.testing;

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
import com.frontend.Admin_User;
import com.frontend.Customer_Bookingflow;
import com.frontend.Customer_Settings;
import com.frontend.Info;
import com.frontend.Login_Details;

import io.appium.java_client.android.options.UiAutomator2Options;

public class TestRun extends Base {

	@BeforeTest()
	public static void load_Properties() throws IOException {
		method1("First");
	}

//	@BeforeTest(dependsOnMethods = { "load_Properties" })
//	public static void ApiRunner() throws InterruptedException {
//		Api.signInAdmin(getProperty("PREDEFINED_ADMIN_EMAIL"));
//		Api.verifyOtp(getProperty("PREDEFINED_ADMIN_OTP"));
//		Api.refreshAdminToken(Api.VerifiedRefreshToken);
//		Api.ServiceSlotTimeCount();
//		Api.OverallSlotList();
//	}
//
//	@BeforeTest(dependsOnMethods = { "ApiRunner" })
//	public static void DownloadApk() throws InterruptedException, MalformedURLException {
//		Latest_StagingAPK_download();
//		Application();
//	}
	
	@Test(priority = 1)
	public static void signupCustomer() throws Exception {

		WE_Info info = new WE_Info(driver);
		OpenApplicationWithoutReset();
		Login_Details.signupCustomer();
		Info.User_Data();
		Thread.sleep(2000);
		Info.Pet_Data();
		Thread.sleep(2000);
		info.getcloseApp();
	}

	@Test(priority = 2)
	public static void Clear_Cache() throws IOException {

		clearCache();
		OpenApplication();
		Runtime.getRuntime().exec("adb shell pm clear com.petcaretechnologies.app");
	}

	@Test(priority = 3)
	public static void AdminLogin() throws Exception {

		Login_Details.login_Admin();
		Thread.sleep(3000);
		System.out.println("completed");
	}

	@Test(priority = 4)
	public static void NewUserApproval() throws Exception {

		Admin_User.approveUserUsingSearch();
		Thread.sleep(4000);
		System.out.println("completed");
	}

	@Test(priority = 5)
	public static void CreateAdmin() throws InterruptedException {

		Admin_User.Create_Admin();
		Thread.sleep(4000);
		System.out.println("completed");
	}

	@Test(priority = 6)
	public static void CreateStaff() throws InterruptedException {

		Admin_User.Create_Staff();
		Thread.sleep(4000);
		System.out.println("completed");
	}

	@Test(priority = 7)
	public static void CreateTag() throws Exception {

		Admin_User.CreateTag();
		Thread.sleep(4000);
		System.out.println("completed");
	}

	@Test(priority = 8)
	public static void CreateSlot() throws Exception {
		Admin_Services.slot_creation();
		Thread.sleep(4000);
		System.out.println("completed");
	}

	@Test(priority = 9)
	public static void ServiceCreation() throws Exception {
		Api.refreshAdminToken(Api.VerifiedRefreshToken);
		Api.OverallSlotList();
		Admin_Services.ServiceCreation();
		Thread.sleep(4000);
		System.out.println("completed");
	}

	@Test(priority = 10)
	public static void Logout_Admin() {
		Login_Details.Logout_Admin();
	}

	@Test(priority = 11)
	public static void Login_PredefinedCustomer() throws InterruptedException, MalformedURLException {
		
		OpenApplication();
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
		WE_Info info = new WE_Info(driver);
		method1("First");
		Latest_StagingAPK_download();
		Application();
//		OpenApplication();
		Login_Details.signupCustomer();
		Info.User_Data();
		Thread.sleep(2000);
		Info.Pet_Data();
		info.getcloseApp();
	}

}
