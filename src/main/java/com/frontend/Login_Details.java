package com.frontend;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import com.WE.WE_Login_Details;
import com.baseClass.Base;

import io.appium.java_client.android.AndroidDriver;

public class Login_Details extends Base {

	public static void signupCustomer() throws InterruptedException {
		WE_Login_Details signup = new WE_Login_Details(driver);
		ClickonElement(signup.getSignUp());
		ClickonElement(signup.getContinueWithEmail());
		passInput(signup.getContinueWithEmail(), getProperty("SIGNUP_EMAIL"));
		driver.hideKeyboard();
		Thread.sleep(3000);
		if (isElementAvailable(signup.getwelcome())) {
			ClickonElement(signup.getcheckbox());
		}
		ClickonElement(signup.getContinueButton());
		Thread.sleep(10000);
		String otp = getOtpFromSource1();
		Thread.sleep(2000);
		passInputUsingActions(signup.getOTP(), otp);
	}

	public static void login_Customer() throws InterruptedException {
		WE_Login_Details login = new WE_Login_Details(driver);
		ClickonElement(login.getContinueWithEmail());
		passInput(login.getContinueWithEmail(), getProperty("SIGNUP_EMAIL"));
		driver.hideKeyboard();
		ClickonElement(login.getContinueButton());
		waitForElement(login.getEnterORPaste());
		Thread.sleep(2000);
		String otp = getOtpFromSource1();
		Thread.sleep(2000);
		passInputUsingActions(login.getOTP(), otp);
		driver.hideKeyboard();
	}

	public static void Logout_Customer() {
		WE_Login_Details login = new WE_Login_Details(driver);
		ClickonElement(login.getSettings());
		ClickonElement(login.getLogout());
	}

	public static void login_Admin() throws InterruptedException {
		WE_Login_Details login = new WE_Login_Details(driver);
		ClickonElement(login.getContinueWithEmail());
		passInput(login.getContinueWithEmail(), getProperty("PREDEFINED_ADMIN_EMAIL"));
		driver.hideKeyboard();
		ClickonElement(login.getContinueButton());
		waitForElement(login.getEnterORPaste());
		passInputUsingActions(login.getOTP(), getProperty("PREDEFINED_ADMIN_OTP"));
		driver.hideKeyboard();
	}

	public static void Logout_Admin() {

		WE_Login_Details login = new WE_Login_Details(driver);
		ClickonElement(login.getAdmin_Settings());
		ClickonElement(login.getLogout());
	}

	public static void login_staff() throws InterruptedException {
		WE_Login_Details login = new WE_Login_Details(driver);
		ClickonElement(login.getContinueWithEmail());
		passInput(login.getContinueWithEmail(), getProperty("PREDEFINED_STAFF_EMAIL"));
		driver.hideKeyboard();
		ClickonElement(login.getContinueButton());
		waitForElement(login.getEnterORPaste());
		passInputUsingActions(login.getOTP(), getProperty("PREDEFINED_STAFF_OTP"));
		driver.hideKeyboard();
	}
	
	public static  void stafflogout() throws InterruptedException {
		WE_Login_Details login = new WE_Login_Details(driver);
        waitForElement(login.getMyScedule());
		ClickonElement(login.getstaffprofile());
		scrollDown();
		ClickonElement(login.getLogout());
		
	}

	public static void Predefined_login_Customer() throws InterruptedException {
		WE_Login_Details login = new WE_Login_Details(driver);
		ClickonElement(login.getContinueWithEmail());
		passInput(login.getContinueWithEmail(), getProperty("PREDEFINED_CUSTOMER_EMAIL"));
		driver.hideKeyboard();
		ClickonElement(login.getContinueButton());
		waitForElement(login.getEnterORPaste());
		passInputUsingActions(login.getOTP(), getProperty("PREDEFINED_CUSTOMER_OTP"));
		driver.hideKeyboard();
	}

//	public static void main(String[] args) throws InterruptedException, IOException {
//		method1("First");
//		Latest_StagingAPK_download(getProperty("STAGING"));
//		Application();
//		login_Customer();
//		Logout_Customer();
//		login_Admin();
//		Logout_Admin();
//		login_staff();
//		stafflogout();
//		Predefined_login_Customer();
//		Logout_Customer();
//		
//		
//		
//	}

}
