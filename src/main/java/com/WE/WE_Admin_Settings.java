package com.WE;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.Base;

import io.appium.java_client.android.AndroidDriver;

public class WE_Admin_Settings extends Base{

	public WE_Admin_Settings(AndroidDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver1, this);
	}
	
//	---------------------------------------------------------->      BREED CREATION ----------------------
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Manage Breeds\"]")
	private WebElement   ManageBreeds ;
	public WebElement getManageBreeds() {
		return   ManageBreeds  ;
	}
	
	@FindBy (xpath ="(//android.widget.Button)[2]")
	private WebElement  FABBreed  ;
	public WebElement getFABBreed() {
		return    FABBreed ;
	}
	
	@FindBy (xpath ="//*[starts-with(@hint,'Beneficiary SubType')]")
	private WebElement   BreedName ;
	public WebElement getBreedName() {
		return   BreedName  ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Save\"]")
	private WebElement   SaveBreed ;
	public WebElement getSaveBreed() {
		return  SaveBreed   ;
	}
}
