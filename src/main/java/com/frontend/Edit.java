package com.frontend;

import com.WE.WE_Admin_User;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Info;
import com.baseClass.Base;

public class Edit extends Base {

	public static  void EditStaff() throws InterruptedException {

		WE_Admin_User user = new WE_Admin_User(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		WE_Info info = new WE_Info(driver);
		Thread.sleep(3000);
		ClickonElement(workflow.getUsers_navigation_Bar());
		ClickonElement(user.getShowall_AllStaff());
		waitForElement(user.getAllStaff());
		ClickonElement(user.getSearchBox());
		passInput(user.getSearchBox(), getProperty("ADMIN_STAFF_FIRST_NAME"));
		Thread.sleep(3000);
		clickOnElementUsingBy(user.StaffNameAfterSearch);
		Thread.sleep(1500);
		ClickonElement(user.getEdit());
		Thread.sleep(3000);
		ClickonElement(user.getContactNumber());
		ClearonElement(user.getContactNumber());
		passInput(user.getContactNumber(), getProperty("EDIT_ADMIN_STAFF_CONTACTNUMBER"));
		driver.hideKeyboard();
		ClickonElement(user.getSave());
		waitForElement(user.getAllStaff());
	    ClickonElement(info.getBackButton());
	}
	
	public static  void EditCustomer() throws InterruptedException {

		WE_Admin_User user = new WE_Admin_User(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		WE_Info info = new WE_Info(driver);
		Thread.sleep(3000);
		ClickonElement(workflow.getUsers_navigation_Bar());
		ClickonElement(user.getShowall_AllCustomers());
		waitForElement(user.getAllCustomers());
		ClickonElement(user.getSearchBox());
		passInput(user.getSearchBox(), getProperty("ADMIN_CUSTOMER_FIRSTNAME"));
		Thread.sleep(3000);
		clickOnElementUsingBy(user.CustomerNameAfterSearch);
		Thread.sleep(1500);
		ClickonElement(user.getEdit());
		Thread.sleep(3000);
		Thread.sleep(1000);
		ClickonElement(user.getPhonenumber());
		ClearonElement(user.getPhonenumber());
		passInput(user.getPhonenumber(), getProperty("EDIT_ADMIN_CUSTOMER_PHONENUMBER"));
		driver.hideKeyboard();
		ClickonElement(user.getSave());
		waitForElement(user.getAllCustomers());
	    ClickonElement(info.getBackButton());
	}
	
	public static void EditAdmin() throws InterruptedException {
		WE_Admin_User user = new WE_Admin_User(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		WE_Info info = new WE_Info(driver);
		Thread.sleep(3000);
		ClickonElement(workflow.getUsers_navigation_Bar());
		ClickonElement(user.getShowall_AllAdmin());
		waitForElement(user.getAllAdministrations());
		ClickonElement(user.getSearchBox());
		passInput(user.getSearchBox(), getProperty("ADMIN_ADMIN_FIRST_NAME"));
		Thread.sleep(3000);
		clickOnElementUsingBy(user.AdminNameAfterSearch);
		Thread.sleep(1500);
		ClickonElement(user.getEdit());
		Thread.sleep(3000);
		ClickonElement(user.getPhoneNumber());
		ClearonElement(user.getPhoneNumber());
		Thread.sleep(1500);
		passInput(user.getPhoneNumber(), getProperty("EDIT_ADMIN_ADMIN_CONTACTNUMBER"));
		driver.hideKeyboard();
		ClickonElement(user.getSave());
		waitForElement(user.getAllAdministrations());
	    ClickonElement(info.getBackButton());
		
	}
	
	public static  void EditTag() throws Exception {
		WE_Admin_User user = new WE_Admin_User(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		WE_Info info = new WE_Info(driver);
		Thread.sleep(5000);
		ClickonElement(workflow.getUsers_navigation_Bar());
		Thread.sleep(3000);
		halfscrollUntilElementFound12(user.getTagscrollview(), user.getTagCategoriesShowall());
		Thread.sleep(1000);
		ClickonElement(user.getTagCategoriesShowall());
		waitForElement(user.getTagCategories());
		if (!isElementAvailable(user.searchingCategoryName)) {
			slowscrolluntilelementfound(user.searchingCategoryName);
			clickOnElementUsingBy(user.searchingCategoryName);
		}else {
			clickOnElementUsingBy(user.searchingCategoryName);
		}
		Thread.sleep(1000);
		ClickonElement(user.getEdit());
		ClickonElement(user.getDecsription());
		ClearonElement(user.getDecsription());
		passInput(user.getDecsription(), getProperty("EDIT_ADMIN_TAG_CATEGORY_DESCRIPTION"));
		driver.hideKeyboard();
		Thread.sleep(1000);
		ClickonElement(user.getSave());
		
	}
	
	public static  void EditService() {

		
	}
	
	
	
	
}
