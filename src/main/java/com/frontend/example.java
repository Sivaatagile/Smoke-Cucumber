package com.frontend;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import com.WE.WE_Login_Details;
import com.baseClass.Base;

import io.appium.java_client.android.AndroidDriver;

public class example extends Base {

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
