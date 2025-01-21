package com.WE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.Base;
import com.frontend.Customer_Settings;

import cucumberStepDefinition.Booking;
import io.appium.java_client.android.AndroidDriver;

public class WE_Customer_Settings extends Base{
	
	public static String TotalAmountWithSymbol;
	
	public WE_Customer_Settings(AndroidDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver1, this);
	}
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"My Bookings\"]")
	private WebElement MyBookings;

	public WebElement getMyBookings() {
		return MyBookings;
	}

//	settings tab
	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Tab 3 of 3\"]")
	private WebElement SettingsTab;

	public WebElement getSettingsTab() {
		return SettingsTab;
	}

//	element for my invoices
	@FindBy(xpath = "//android.view.View[@content-desc=\"My Invoices\"]")
	private WebElement MyInvoices;

	public WebElement getMyInvoices() {
		return MyInvoices;
	}

//	element for my statements
	@FindBy(xpath = "//android.view.View[@content-desc=\"My Statements\"]")
	private WebElement MyStatements;

	public WebElement getMyStatements() {
		return MyStatements;
	}

//	element for accounts
	@FindBy(xpath = "//android.view.View[@content-desc=\"Accounts\"]")
	private WebElement Accounts;

	public WebElement getAccounts() {
		return Accounts;
	}
//element for logout
	@FindBy(xpath = "//android.view.View[@content-desc=\"Logout\"]")
	private WebElement CustomerLogout;

	public WebElement getCustomerLogout() {
		return CustomerLogout;
	}
	
	
	public static By sales = By.xpath(String.format("//android.view.View[@content-desc=\"sales\"]/following-sibling::android.view.View[@content-desc="+"-"+"'"+TotalAmountWithSymbol+"']"));
//	System.out.println(sales);
	public static By payment = By.xpath(String.format("//android.view.View[@content-desc=\"Payment\"]/following-sibling::android.view.View[@content-desc='"+TotalAmountWithSymbol+"']"));
//	System.out.println(payment);

//	@FindBy(xpath = "//android.view.View[@content-desc=\"sales\"]/following-sibling::android.view.View[@content-desc="+"-"+"'"+TotalAmountWithSymbol+"']")
//	private WebElement sales;
//	public WebElement getsales() {
//		return sales;
//	}
//	
	@FindBy(xpath = "(//android.widget.Button)[1]")
	private WebElement BackButton;
	public WebElement getBackButton() {
		return BackButton;
	}
	
	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Tab 1 of 3\"]")
	private WebElement HomeTab;

	public WebElement getHomeTab() {
		return HomeTab;
	}
//	
	@FindBy(xpath = "(//*[starts-with(@content-desc,'invoice_number')])[1]")
	private WebElement FirstInvoice;
	public WebElement getFirstInvoice() {
		return FirstInvoice;
	}
//	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Invoice.No :\"]/parent::android.view.View[1]//following-sibling::android.view.View[1]/android.view.View[1]")
	private WebElement FindoutInvoiceNumber;
	public WebElement getFindoutInvoiceNumber() {
		return FindoutInvoiceNumber;
	}
//	
	@FindBy(xpath = "//android.widget.ScrollView")
	private WebElement scroll;
	public WebElement getscroll() {
		return scroll;
	}
	
	
	 
	 
	
	
//	
//	@FindBy(xpath = "//android.view.View[@content-desc=\"Payment\"]/following-sibling::android.view.View[@content-desc="'+Booking.TotalAmountWithSymbol +'"]")
//	private WebElement pay;
//	public WebElement get() {
//		return pay;
//	}
//	
//	@FindBy(xpath = "")
//	private WebElement ;
//	public WebElement get() {
//		return ;
//	}
//	
//	@FindBy(xpath = "")
//	private WebElement ;
//	public WebElement get() {
//		return ;
//	}
//	
//	@FindBy(xpath = "")
//	private WebElement ;
//	public WebElement get() {
//		return ;
//	}

}
