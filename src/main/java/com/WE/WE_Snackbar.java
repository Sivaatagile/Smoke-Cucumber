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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"We're unable to delete this service as it has associated bookings.\"]")
	private WebElement   ServiceUnableToDeleted ;
	public WebElement getServiceUnableToDeleted() {
		return   ServiceUnableToDeleted  ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Deleted Successfully\"]")
	private WebElement  RecordDeletedSuccessfully  ;
	public WebElement getRecordDeletedSuccessfully() {
		return  RecordDeletedSuccessfully   ;
	}
	
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"The add-on is currently assigned to the following services (Personalized Dog Adventure Maps). To delete this add-on, first disable it within each service, and then you can proceed with the deletion.\"]")
	private WebElement   AddonUnableToDeleted ;
	public WebElement getAddonUnableToDeleted() {
		return  AddonUnableToDeleted   ;
	}
	
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"We are sorry to inform you that certain records are linked to other active records, preventing their deletion.\"]")
	private WebElement   SlotUnableToDeleted ;
	public WebElement getSlotUnableToDeleted() {
		return   SlotUnableToDeleted  ;
	}
	
	@FindBy (xpath ="//android.widget.ImageView[@content-desc=\"User's account has been rejected\"]")
	private WebElement  RejectUSer  ;
	public WebElement getRejectUSer() {
		return  RejectUSer   ;
	}
	
	@FindBy (xpath ="//android.widget.ImageView[@content-desc=\"User's account has been approved successfully\"]")
	private WebElement   ApproveUSer ;
	public WebElement getApproveUSer() {
		return   ApproveUSer  ;
	}
	
	@FindBy (xpath ="//android.widget.ImageView[@content-desc=\"Tag category is currently in use and cannot be deleted\"]")
	private WebElement TagUnableToDeleted   ;
	public WebElement getTagUnableToDeleted() {
		return    TagUnableToDeleted ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Beneficiary SubType must be unique\"]")
	private WebElement  BeneficiarySubTypeUnique  ;
	public WebElement getBeneficiarySubTypeUnique() {
		return    BeneficiarySubTypeUnique ;
	}
	

//	@FindBy (xpath ="")
//	private WebElement    ;
//	public WebElement get() {
//		return     ;
//	}
//	
//
//	@FindBy (xpath ="")
//	private WebElement    ;
//	public WebElement get() {
//		return     ;
//	}
//	
//	
//
//	@FindBy (xpath ="")
//	private WebElement    ;
//	public WebElement get() {
//		return     ;
//	}
//	
//
//	@FindBy (xpath ="")
//	private WebElement    ;
//	public WebElement get() {
//		return     ;
//	}

}
