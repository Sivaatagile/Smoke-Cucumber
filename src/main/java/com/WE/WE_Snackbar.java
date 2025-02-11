package com.WE;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.Base;

import io.appium.java_client.android.AndroidDriver;

public class WE_Snackbar extends Base{
	
	public WE_Snackbar(AndroidDriver driver1) {
	    this.driver = driver1;
	    // Initialize all elements with the given driver instance
	    PageFactory.initElements(driver1, this);
	}
	
	@FindBy (xpath ="//android.widget.ImageView[@content-desc=\"Record Updated Successfully\"]")
	private WebElement  RecordUpdatedSuccessfully  ;
	public WebElement getRecordUpdatedSuccessfully() {
		return   RecordUpdatedSuccessfully  ;
	}
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Record Created Successfully\"]")
	private WebElement RecordCreatedSuccessfully;
	public WebElement getRecordCreatedSuccessfully() {
	    return RecordCreatedSuccessfully;
	}
	
	@FindBy (xpath ="//android.widget.ImageView[@content-desc=\"User's account has been approved successfully\"]")
	private WebElement  AccountApprovedSuccessfully  ;
	public WebElement getAccountApprovedSuccessfully() {
		return    AccountApprovedSuccessfully ;
	}
	
	@FindBy (xpath ="//android.widget.ImageView[@content-desc=\"Data inserted succesfully.\"]")
	private WebElement   DataInsertedSuccessfully ;
	public WebElement getDataInsertedSuccessfully() {
		return   DataInsertedSuccessfully  ;
	}
	
//	@FindBy (xpath ="")
//	private WebElement    ;
//	public WebElement get() {
//		return     ;
//	}
//	@FindBy (xpath ="")
//	private WebElement    ;
//	public WebElement get() {
//		return     ;
//	}
//	@FindBy (xpath ="")
//	private WebElement    ;
//	public WebElement get() {
//		return     ;
//	}
//	@FindBy (xpath ="")
//	private WebElement    ;
//	public WebElement get() {
//		return     ;
//	}

}
