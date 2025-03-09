package com.frontend;

import org.openqa.selenium.By;

import com.WE.WE_Admin_User;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Info;
import com.baseClass.Base;

public class Delete extends Base{

	public static  void Deletestaff(String StaffName) throws InterruptedException {
	WE_Admin_User user = new WE_Admin_User(driver);
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
	WE_Info info = new WE_Info(driver);
	Thread.sleep(3000);
	ClickonElement(workflow.getUsers_navigation_Bar());
	ClickonElement(user.getShowall_AllStaff());
	waitForElement(user.getAllStaff());
	ClickonElement(user.getSearchBox());
	passInput(user.getSearchBox(), getProperty(StaffName));
	Thread.sleep(3000);
	By StaffNameAfterSearch = By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty(StaffName)));
    clickOnElementUsingBy(StaffNameAfterSearch);
	ClickonElement(user.getDelete());
	ClickonElement(user.getConfirm1());
}
	
	
	
	public static void Deleteadmin(String Admin) throws InterruptedException {
		WE_Admin_User user = new WE_Admin_User(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		WE_Info info = new WE_Info(driver);
		Thread.sleep(3000);
		ClickonElement(workflow.getUsers_navigation_Bar());
		ClickonElement(user.getShowall_AllAdmin());
		waitForElement(user.getAllAdministrations());
		ClickonElement(user.getSearchBox());
		passInput(user.getSearchBox(), getProperty(Admin));
		Thread.sleep(3000);
		By AdminNameAfterSearch = By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty(Admin)));
	    clickOnElementUsingBy(AdminNameAfterSearch);
		ClickonElement(user.getDelete());
		ClickonElement(user.getConfirm1());

	}
	
	
	public static  void DeleteCustomer(String Customer) throws InterruptedException {

		WE_Admin_User user = new WE_Admin_User(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		WE_Info info = new WE_Info(driver);
		Thread.sleep(3000);
		ClickonElement(workflow.getUsers_navigation_Bar());
		ClickonElement(user.getShowall_AllCustomers());
		waitForElement(user.getAllCustomers());
		ClickonElement(user.getSearchBox());
		passInput(user.getSearchBox(), getProperty(Customer));
		Thread.sleep(3000);
		By CustomerNameAfterSearch = By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty(Customer)));
	    clickOnElementUsingBy(CustomerNameAfterSearch);
		ClickonElement(user.getDelete());
		ClickonElement(user.getConfirm1());

	}
	
	public static  void DeleteTag(String Tag) throws Exception {

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
		 By  searchingCategoryName= By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty("Tag")));

		if (!isElementAvailable(searchingCategoryName)) {
			slowscrolluntilelementfound(searchingCategoryName);
			clickOnElementUsingBy(searchingCategoryName);
		}else {
			clickOnElementUsingBy(searchingCategoryName);
		}
		Thread.sleep(1000);
		ClickonElement(user.getDelete());
		ClickonElement(user.getConfirm1());

	}
}
