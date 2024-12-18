package com.WE;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.Base;

import io.appium.java_client.android.AndroidDriver;

public class WE_Admin_WorkFlow extends Base{

	
	public WE_Admin_WorkFlow(AndroidDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver1, this);
	}
	
	@FindBy (xpath ="//android.widget.ImageView[@content-desc=\"Tab 1 of 6\"]")
	private WebElement  HOME_navigation_Bar   ;
	public WebElement getHOME_navigation_Bar() {
		return   HOME_navigation_Bar  ;
	}
	
	@FindBy (xpath ="//android.widget.ImageView[@content-desc=\"Tab 2 of 6\"]")
	private WebElement  DashBoard_navigation_Bar  ;
	public WebElement getDashBoard_navigation_Bar() {
		return    DashBoard_navigation_Bar ;
	}
	
	@FindBy (xpath ="//android.widget.ImageView[@content-desc=\"Tab 3 of 6\"]")
	private WebElement   AllBookings_navigation_Bar ;
	public WebElement getAllBookings_navigation_Bar() {
		return   AllBookings_navigation_Bar  ;
	}
	
	@FindBy (xpath ="//android.widget.ImageView[@content-desc=\"Tab 4 of 6\"]")
	private WebElement  Users_navigation_Bar  ;
	public WebElement getUsers_navigation_Bar() {
		return   Users_navigation_Bar  ;
	}
	
	@FindBy (xpath ="//android.widget.ImageView[@content-desc=\"Tab 5 of 6\"]")
	private WebElement  Services_navigation_Bar  ;
	public WebElement getServices_navigation_Bar() {
		return   Services_navigation_Bar  ;
	}
	
	@FindBy (xpath ="//android.widget.ImageView[@content-desc=\"Tab 6 of 6\"]")
	private WebElement  Settings_navigation_Bar  ;
	public WebElement getSettings_navigation_Bar() {
		return   Settings_navigation_Bar  ;
	}
}
