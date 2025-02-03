package com.WE;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.Base;

import io.appium.java_client.android.AndroidDriver;

public class WE_Login_Details extends Base{
	
	
	public WE_Login_Details(AndroidDriver driver1) {
		Base.driver = driver1;
		PageFactory.initElements(driver1, this);
	}
	
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Sign up\"]")
	private WebElement SignUp;
	public WebElement getSignUp() {
		return SignUp;
	}
	
	@FindBy(xpath = "//android.view.View[contains(@content-desc,\"Welcome\")]")
	private WebElement welcome;
	public WebElement getwelcome() {
		return welcome;
	}
	
	@FindBy(xpath = "//android.widget.CheckBox")
	private WebElement checkbox;
	public WebElement getcheckbox() {
		return checkbox;
	}
	
	
	
	//android.view.View[@content-desc="Welcome "]
	@FindBy(xpath = "//android.widget.EditText[@hint='Continue with email']") 
	private WebElement ContinueWithEmail;
	public WebElement getContinueWithEmail() {
		return ContinueWithEmail;
	}
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Continue\"]")
	private WebElement ContinueButton;
	public WebElement getContinueButton() {
		return ContinueButton;
	}
	
	@FindBy(xpath = "//android.widget.EditText")
	private WebElement OTP;
	public WebElement getOTP() {
		return OTP;
	}
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Enter or paste your security code\"]")
	private WebElement EnterORPaste;
	public WebElement getEnterORPaste() {
		return EnterORPaste;
	}
	
	@FindBy(xpath = "//*[starts-with(@content-desc,'Tab 3 of 3')]")
	private WebElement Settings;
	public WebElement getSettings() {
		return Settings;
	}

	@FindBy(xpath = "//android.view.View[@content-desc=\"Logout\"]")
	private WebElement Logout;
	public WebElement getLogout() {
		return Logout;
	}
	
	@FindBy(xpath = "//*[starts-with(@content-desc,'Tab 6 of 6')]")
	private WebElement Admin_Settings;
	public WebElement getAdmin_Settings() {
		return Admin_Settings;
	}
	
	@FindBy (xpath ="//*[starts-with(@content-desc,'Pending')]")
	private WebElement   Pending_Tab ;
	public WebElement getPending_Tab() {
		return    Pending_Tab ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Add your info\"]")
	private WebElement   AddInfoPage ;
	public WebElement getAddInfoPage() {
		return    AddInfoPage ;
	}
	
	@FindBy (xpath ="//android.widget.Button")
	private WebElement   staffprofile ;
	public WebElement getstaffprofile() {
		return    staffprofile ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"My Schedule\"]")
	private WebElement   MyScedule ;
	public WebElement getMyScedule() {
		return    MyScedule ;
	}
	
	
	
}
