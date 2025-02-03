package com.WE;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.Base;

import io.appium.java_client.android.AndroidDriver;

public class WE_Customer_Details extends Base{
	

	public WE_Customer_Details(AndroidDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver1, this);
    }
	
	@FindBy (xpath ="//android.view.View[contains(@content-desc,\"app_barmonth\")]/following-sibling::android.widget.Button[2]")
	private WebElement   CustomerProfile ;
	public WebElement getCustomerProfile() {
		return   CustomerProfile  ;
	}
	
	@FindBy(xpath = "//android.view.View[contains(@content-desc,\"My Pet\")]")
	private WebElement MyPet;
	public WebElement getMyPet() {
		return MyPet;
	}
	
	@FindBy (xpath ="(//android.widget.Button)[2]")
	private WebElement  FAB  ;
	public WebElement getFAB() {
		return   FAB  ;
	}
	
//	@FindBy (xpath ="")
//	private WebElement    ;
//	public WebElement get() {
//		return     ;
//	}
//	
//	@FindBy (xpath ="")
//	private WebElement    ;
//	public WebElement get() {
//		return     ;
//	}
//	
//	@FindBy (xpath ="")
//	private WebElement    ;
//	public WebElement get() {
//		return     ;
//	}
//	
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
//	@FindBy (xpath ="")
//	private WebElement    ;
//	public WebElement get() {
//		return     ;
//	}}

}
