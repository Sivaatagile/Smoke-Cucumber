package com.frontend;

import com.WE.WE_Admin_Services;
import com.WE.WE_Admin_User;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Info;
import com.api.Api;
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
	
	public static  void EditService() throws Exception {
		WE_Admin_Services Service = new WE_Admin_Services(driver);
		WE_Info info = new WE_Info(driver);
		Api api = new Api(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);

		Thread.sleep(5000);
		ClickonElement(workflow.getServices_navigation_Bar());
		
		ClickonElement(Service.getService_Showall());

		   waitForElement(Service.getAllServices());

		ClickonElement(Service.getSearchBox());
		
		passInput(Service.getSearchBox(), getProperty("SERVICE_NAME"));
		
		clickOnElementUsingBy(Service.serviceNameAfterSearch);
		
		ClickonElement(Service.getSlotEditICON());
		
		
		ClickonElement(Service.getService_name());
		ClearonElement(Service.getService_name());
		passInput(Service.getService_name(), getProperty("EDIT_SERVICE_NAME"));
		driver.hideKeyboard();
		
		ClickonElement(Service.getDescription_textbox());
		ClearonElement(Service.getDescription_textbox());
		passInput(Service.getDescription_textbox(), getProperty("EDIT_SERVICE_DESCRIPTION"));
		driver.hideKeyboard();
		
		slowscrolluntilelementfound(Service.getFirstElement());
		ClickonElement(Service.getFirstElement());
		ClearonElement(Service.getFirstElement());
		api.universal_creditlimit();
		double universalCreditLimit = api.universalCreditLimit;
	    double	Baseprice=universalCreditLimit-10;
	    int converted = (int) Baseprice;
	    String str = String.valueOf(converted);
		passInput(Service.getFirstElement(), str);
		driver.hideKeyboard();
		Thread.sleep(1000);
		slowscrolluntilelementfound(Service.getFourthElement());
		int BasePrice_size = Service.getBaseprice().size();
		System.out.println("size of Base list  : " + BasePrice_size);
		Thread.sleep(1000);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(500);
			Service.getBaseprice().get(i).click();
			Service.getBaseprice().get(i).clear();
			Thread.sleep(500);
			passInput(Service.getBaseprice().get(i), getProperty("EDIT_BASE_PRICE_AMOUNT"));
			driver.hideKeyboard();
			Thread.sleep(500);
		}
		
		if (isElementAvailable(Service.getMaximum_capacity())) {
			ClickonElement(Service.getMaximum_capacity());
			ClearonElement(Service.getMaximum_capacity());
			passInput(Service.getMaximum_capacity(), getProperty("EDIT_MAX_CAPACITY_SLOT"));
			driver.hideKeyboard();
		}else {
			slowScroll();
			ClickonElement(Service.getMaximum_capacity());
			ClearonElement(Service.getMaximum_capacity());
			passInput(Service.getMaximum_capacity(), getProperty("EDIT_MAX_CAPACITY_SLOT"));
			driver.hideKeyboard();	
		}
		
		
		ClickonElement(Service.getMaximum_capacity_Per_Staff());
		ClearonElement(Service.getMaximum_capacity_Per_Staff());
		passInput(Service.getMaximum_capacity_Per_Staff(), getProperty("EDIT_MAX_CAPACITY_STAFF"));
		driver.hideKeyboard();
		
		slowscrolluntilelementfound(Service.getMax_Advance_Booking_Limit());
		ClickonElement(Service.getMax_Advance_Booking_Limit());
		ClearonElement(Service.getMax_Advance_Booking_Limit());
		passInput(Service.getMax_Advance_Booking_Limit(), getProperty("EDIT_MAX_ADVANCE_BOOKING_LIMIT"));
		driver.hideKeyboard();
		
		ClickonElement(Service.getSave());
		
	}
	
	public static  void EditAddon() throws Exception {
		WE_Admin_Services addon = new WE_Admin_Services(driver);
		WE_Info info = new WE_Info(driver);
		Api api = new Api(driver);
		WE_Admin_Services Service = new WE_Admin_Services(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);

		
		Thread.sleep(5000);
		ClickonElement(workflow.getServices_navigation_Bar());
		
		ClickonElement(Service.getService_Showall());

		   waitForElement(Service.getAllServices());

		ClickonElement(Service.getSearchBox());
		
		passInput(Service.getSearchBox(), getProperty("ADDON_PRIVILAGE"));
		
		clickOnElementUsingBy(Service.addonNameAfterSearch);
		
		ClickonElement(Service.getSlotEditICON());
		
		
		ClickonElement(addon.getAddon_name());
		ClearonElement(addon.getAddon_name());
		passInput(addon.getAddon_name(), getProperty("EDIT_ADDON_PRIVILAGE"));
		driver.hideKeyboard();
		
		ClickonElement(addon.getAddon_Description_textbox());
		ClearonElement(addon.getAddon_Description_textbox());
		passInput(addon.getAddon_Description_textbox(), getProperty("EDIT_ADDON_PRIVILAGE_DESCRIPTION"));
		driver.hideKeyboard();
		
		slowscrolluntilelementfound(addon.getFirstElement());
		ClickonElement(addon.getFirstElement());
		ClearonElement(addon.getFirstElement());
		passInput(addon.getFirstElement(), getProperty("EDIT_ADDON_PRIVILAGE_BASE_PRICE_AMOUNT"));
        driver.hideKeyboard();
        slowscrolluntilelementfound(addon.getFourthElement());
		int BasePrice_size = addon.getBaseprice().size();
		System.out.println("size of Base list  : " + BasePrice_size);
		Thread.sleep(500);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(500);
			addon.getBaseprice().get(i).click();
			addon.getBaseprice().get(i).clear();
			Thread.sleep(500);
			passInput(addon.getBaseprice().get(i), getProperty("EDIT_ADDON_PRIVILAGE_BASE_PRICE_AMOUNT"));
			driver.hideKeyboard();
			Thread.sleep(500);
		}
		
		ClickonElement(addon.getAddon_Maximum_capacity());
		ClearonElement(addon.getAddon_Maximum_capacity());
		passInput(addon.getAddon_Maximum_capacity(), getProperty("EDIT_ADDON_PRIVILAGE_MAX_CAPACITY_SLOT"));
		driver.hideKeyboard();
		
		
		ClickonElement(addon.getAddon_Maximum_capacity_Per_Staff());
		ClearonElement(addon.getAddon_Maximum_capacity_Per_Staff());
		passInput(addon.getAddon_Maximum_capacity_Per_Staff(), getProperty("EDIT_ADDON_PRIVILAGE_MAX_CAPACITY_STAFF"));
		driver.hideKeyboard();
		
		ClickonElement(Service.getSave());

	}
	
	
	public static  void EditSlot() throws Exception {
		WE_Admin_Services addon = new WE_Admin_Services(driver);
		WE_Info info = new WE_Info(driver);
		Api api = new Api(driver);
		WE_Admin_Services Service = new WE_Admin_Services(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		WE_Admin_Services slot = new WE_Admin_Services(driver);

		
		Thread.sleep(5000);
		ClickonElement(workflow.getServices_navigation_Bar());
		ClickonElement(slot.getSlot_Showall());
		   waitForElement(slot.getSlot());
		   ClickonElement(Service.getSearchBox());
			
			passInput(Service.getSearchBox(), getProperty("SLOT_NAME"));
			
			clickOnElementUsingBy(Service.slotNameAfterSearch);
		   
			ClickonElement(Service.getSlotEditICON());

		   ClickonElement(slot.getSlotName());
		   ClearonElement(slot.getSlotName());
			passInput(slot.getSlotName(), getProperty("EDIT_SLOT_NAME"));
			driver.hideKeyboard();
		
		
			ClickonElement(slot.getDescriptionTextBox());
			   ClearonElement(slot.getDescriptionTextBox());

			passInput(slot.getDescriptionTextBox(), getProperty("EDIT_SLOT_DESCRIPTION"));
			driver.hideKeyboard();
		
			Thread.sleep(1000);
			ClickonElement(slot.getStartTime());
			Thread.sleep(1000);
			scrollUntilElementFound_DatePicker_Time1(slot.getHours(), slot.EditedHoursExpected);
			Thread.sleep(1000);
			scrollUntilElementFound_DatePicker_Time1(slot.getMinutes(), slot.EditedMinutesExpected);
			Thread.sleep(1000);
			scrollUntilElementFound_DatePicker_Time1(slot.getSession(), slot.EditedSessionExpected);
			Thread.sleep(1000);
			ClickonElement(slot.getSelect());
			
			
			ClickonElement(Service.getSave());

			
	}
	
}
