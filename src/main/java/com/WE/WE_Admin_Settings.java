package com.WE;

import java.util.List;

import org.openqa.selenium.By;
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
	

	
//	 Element for the Settings tab
	@FindBy(xpath = "//*[starts-with(@content-desc,'Tab 6 of 6')]")
	private WebElement settingstab;
	public WebElement getSettingstab() {
	    return settingstab;
	}
	
//  Element of the invoice in settings	
	@FindBy (xpath="//android.view.View[@content-desc=\"Invoices\"]")
	private WebElement invoices;
	public WebElement getinvoices() {
		return invoices;
	}
//   Element of the search of invoice	
	@FindBy (xpath="//*[starts-with(@hint,'Search')]")
	private WebElement Search_invoice;
	public WebElement getSearch_invoice() {
		return Search_invoice;
	}
	
//   Element of the invoive date :    it is for chceking purpose 
	@FindBy (xpath="//android.view.View[@content-desc=\"Invoice Date : \"]")
	private List<WebElement> invoice_Date;
	public List<WebElement> getinvoice_Date() {
		return invoice_Date;
	}//*[starts-with(@content-desc,'statement')]
	
//	Get back
	@FindBy (xpath="(//android.widget.Button)[1]")
	private WebElement getback;
	public WebElement getgetback() {
		return getback;
	}
//	 Element for the Home tab
	@FindBy(xpath = "//*[starts-with(@content-desc,'Tab 1 of 6')]")
	private WebElement hometab;
	// Getter method for the Settings tab element
	public WebElement gethometab() {
	    return hometab;
	}
	
//	 element for statement
	@FindBy (xpath="//android.view.View[@content-desc=\"Statements\"]")
	private WebElement   statements;
	public WebElement getstatements() {
		return statements;
	}
	
	@FindBy (xpath="//*[starts-with(@content-desc,'search')]")
	private WebElement  statementSearch ;
	public WebElement getstatementSearch() {
		return statementSearch;
	}
	
	@FindBy (xpath="(//*[starts-with(@content-desc,'statement')])[3]")
	private WebElement  Firststatement  ;
	public WebElement getFirststatement() {
		return Firststatement;
	}
	
	@FindBy (xpath="//android.view.View[@content-desc=\"Availability and Pricing\"]")
	private WebElement  AvailabilityandPricing ;
	public WebElement getAvailabilityandPricing() {
		return AvailabilityandPricing;
	}
	
	@FindBy (xpath="(//android.widget.Button)[2]")
	private WebElement  FAB ;   ;
	public WebElement getFAB() {
		return FAB;
	}
	
	@FindBy (xpath="(//android.widget.EditText)[1]")
	private WebElement  Pricingrule_Name;
	public WebElement getPricingrule_Name() {
		return Pricingrule_Name;
	}
	
	@FindBy (xpath="(//android.widget.EditText)[2]")
	private WebElement  Description ;
	public WebElement getDescription() {
		return Description;
	}
	
	@FindBy (xpath="//android.widget.ImageView[@content-desc=\"Tab 5 of 6\"]")
	private WebElement   service;
	public WebElement getservice() {
		return service;
	}
	
	@FindBy (xpath="(//android.view.View[@content-desc=\"Show all\"])[2]")
	private WebElement  Slot_Showall ;
	public WebElement getSlot_Showall() {
		return Slot_Showall;
	}
	
	@FindBy (xpath="//android.view.View[@content-desc='Priority *']/following-sibling::android.widget.EditText[1]")
	private WebElement priority  ;
	public WebElement getpriority() {
		return priority;
	}
	
	@FindBy(xpath = "//*[starts-with(@content-desc,'avatar_name')]")
	private List<WebElement> check_slots;
	public List<WebElement> getcheck_slots() {
	    return check_slots;
	}
	
	
	@FindBy (xpath="(//android.widget.Button)[1]")
	private WebElement  back ;
	public WebElement getback() {
		return back ;
	}
	
	@FindBy (xpath="//android.view.View[@content-desc=\"One Time\"]")
	private WebElement Onetime  ;
	public WebElement getOnetime() {
		return Onetime;
	}
	
	@FindBy (xpath="//*[starts-with(@content-desc,'pricing_rule_form_Date')]/following-sibling::android.view.View[1]")
	private WebElement  click_date ;
	public WebElement getclick_date() {
		return click_date;
	}

	@FindBy (xpath="//android.view.View[@content-desc=\"Select\"]")
	private WebElement  Select  ;
	public WebElement getSelect() {
		return Select;
	}
	
	@FindBy (xpath="(//android.widget.SeekBar)[3]")
	private WebElement   seekbar;
	public WebElement getseekbar() {
		return seekbar;
	}
	
	
	@FindBy (xpath="//*[starts-with(@content-desc,'slot_name')]/android.widget.EditText")
	private List<WebElement>  SlotText;
	public List<WebElement> getSlotText() {
		return SlotText;
	}
	
	
	
//	
	@FindBy (xpath="//android.view.View[@content-desc=\"Discount\"]")
	private WebElement   Discount;
	public WebElement getDiscount() {
		return Discount;
	}
//	
	@FindBy (xpath="//android.view.View[@content-desc=\"Weekly\"]")
	private WebElement weekly  ;
	public WebElement getweekly() {
		return weekly;
	}
//	
	@FindBy (xpath="//*[starts-with(@content-desc,'pricing_rule_form_End')]/following-sibling::android.view.View[1]")
	private WebElement  Enddate ;
	public WebElement getEnddate() {
		return Enddate;
	}
	
	
	
	
	
	@FindBy (xpath ="(//android.widget.Button)[2]")
	private WebElement  FABButton  ;
	public WebElement getFABButton() {
		return    FABButton ;
	}
	
	
	
	@FindBy (xpath="//android.widget.ScrollView")
	private WebElement  scrollview ;
	public WebElement getscrollview() {
		return scrollview;
	}
	

	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Not Available\"]")
	private WebElement   NotAvailable ;
	public WebElement getNotAvailable() {
		return    NotAvailable ;
	}
//	
	@FindBy (xpath ="//*[starts-with(@content-desc,'dialog_box_submit_button')]")
	private WebElement  proceed  ;
	public WebElement getproceed() {
		return   proceed  ;
	}
	
	@FindBy (xpath ="(//android.widget.ImageView)[2]")
	private WebElement Delete  ;
	public WebElement getDelete() {
		return  Delete   ;
	}
//	
	@FindBy (xpath ="(//android.widget.Button)[2]")
	private WebElement ConfirmDelete   ;
	public WebElement getConfirmDelete() {
		return  ConfirmDelete   ;
	}
	
	@FindBy (xpath ="(//android.view.View[contains(@content-desc, \"pricing\")])[3]/android.widget.ImageView[3]")
	private WebElement  DeletePricing  ;
	public WebElement getDeletePricing() {
		return  DeletePricing   ;
	}
	@FindBy (xpath ="//android.widget.ScrollView/android.view.View[12]")
	private WebElement  PricingCalendar  ;
	public WebElement getPricingCalendar() {
		return  PricingCalendar   ;
	}

	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Accounts\"]")
	private WebElement Accounts   ;
	public WebElement getAccounts() {
		return Accounts    ;
	}
//	
	@FindBy (xpath ="//android.widget.ScrollView/android.view.View[1]")
	private WebElement   AdhocCustomer ;
	public WebElement getAdhocCustomer() {
		return AdhocCustomer    ;
	}
//	
//	@FindBy (xpath ="//android.widget.EditText")
//	private WebElement Search   ;
//	public WebElement getSearch() {
//		return  Search   ;
//	}
	
	@FindBy (xpath ="(//android.view.View[contains(@content-desc, 'filter_name')])[1]")
	private WebElement  SelectCustomerAdhoc  ;
	public WebElement getSelectCustomerAdhoc() {
		return SelectCustomerAdhoc    ;
	}
//	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Amount * \"]/following-sibling::android.widget.EditText[1]")
	private WebElement  Amount  ;
	public WebElement getAmount() {
		return  Amount   ;
	}
//	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Remarks * \"]/following-sibling::android.widget.EditText[1]")
	private WebElement  Remarks  ;
	public WebElement getRemarks() {
		return  Remarks   ;
	}
//	
	@FindBy (xpath ="//android.widget.Button[@content-desc=\"submit_button_label\"]")
	private WebElement SubmitAdhoc   ;
	public WebElement getSubmitAdhoc() {
		return  SubmitAdhoc   ;
	}
	@FindBy (xpath ="//android.view.View[@content-desc=\"account_page_customer_name\"]")
	private WebElement  SelectCustomer  ;
	public WebElement getSelectCustomer() {
		return  SelectCustomer   ;
	}
	@FindBy (xpath ="(//android.view.View[@content-desc=\"common_pagefirst_name\"])[1]")
	private WebElement  Customer  ;
	public WebElement getCustomer() {
		return  Customer   ;
	}
	

	@FindBy (xpath ="//android.widget.EditText")
	private WebElement  SearchCustomer  ;
	public WebElement getSearchCustomer () {
		return  SearchCustomer    ;
	}
	@FindBy (xpath ="(//android.widget.Button)[1]")
	private WebElement  BackSettings  ;
	public WebElement getBackSettings() {
		return BackSettings    ;
	}
	
	@FindBy (xpath="//*[starts-with(@content-desc,'statement')]")
	private List<WebElement> statementlist;
	public List<WebElement> getstatementlist() {
		return statementlist;
	}
	
	@FindBy (xpath="//*[starts-with(@hint,'Search')]")
	private WebElement search;
	public WebElement getsearch() {
		return search;
	}
	
	@FindBy (xpath ="//android.widget.ImageView[@content-desc=\"Year\"]")
	private WebElement  YearStatement   ;
	public WebElement getYearStatement() {
		return  YearStatement   ;
	}
	
	@FindBy (xpath="//*[starts-with(@content-desc,'account_page_customer_name')]")
	private List<WebElement> Accountslist;
	public List<WebElement> getAccountslist() {
		return Accountslist;
	}
	
	public static By SignupFirstname = By.xpath("//*[starts-with(@content-desc,'"+getProperty("SIGNUP_FIRSTNAME")+"')]");

	
	@FindBy(xpath = "//android.widget.ScrollView")
	private WebElement scroll;
	public WebElement getscroll() {
		return scroll;
	}
	
//	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Manage Service Pools\"]")
	private WebElement   ServicePool ;
	public WebElement getServicePool() {
		return   ServicePool  ;
	}
//	
//	v122CdpInfo
	@FindBy (xpath ="//android.view.View[contains(@content-desc, \"Name\")]/following-sibling::android.widget.EditText[1]")
	private WebElement  PoolName  ;
	public WebElement getPoolName() {
		return    PoolName ;
	}
//
//	
	@FindBy (xpath ="//android.view.View[contains(@content-desc, \"Remarks\")]/following-sibling::android.widget.EditText[1]")
	private WebElement  PoolRemarks  ;
	public WebElement getPoolRemarks() {
		return   PoolRemarks  ;
	}
//	
	
	@FindBy(xpath = "(//android.widget.ImageView)[1]")
	private WebElement PoolCapacityRangeFrom;
	public WebElement getPoolCapacityRangeFrom() {
	    return PoolCapacityRangeFrom;
	}
	
	@FindBy(xpath = "(//android.widget.ImageView)[2]")
	private WebElement PoolCapacityRangeTo;
	public WebElement getPoolCapacityRangeTo() {
	    return PoolCapacityRangeTo;
	}
	
	@FindBy (xpath ="(//android.widget.ImageView)[2]/following-sibling::android.widget.EditText[1]")
	private WebElement  PoolCapacity  ;
	public WebElement getPoolCapacity() {
		return   PoolCapacity  ;
	}
	
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Save\"]")
	private WebElement   save ;
	public WebElement getsave() {
		return    save ;
	}
	
	@FindBy (xpath ="//android.view.View[contains(@content-desc,\"Pricing offset value\")]/following-sibling::android.widget.EditText[1]")
	private WebElement  pricingoffsetvalue  ;
	public WebElement getpricingoffsetvalue() {
		return    pricingoffsetvalue ;
	}
//	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Premium\"]")
	private WebElement   premium ;
	public WebElement getpremium() {
		return   premium  ;
	}
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
//	}
//	@FindBy (xpath ="")
//	private WebElement    ;
//	public WebElement get() {
//		return     ;
//	}}
}
