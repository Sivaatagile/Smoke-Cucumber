package cucumberStepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.WE.WE_Admin_Services;
import com.WE.WE_Admin_User;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Info;
import com.WE.WE_Snackbar;
import com.api.Api;
import com.baseClass.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EDIT extends Base{
	WE_Admin_User user = new WE_Admin_User(driver);
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
	WE_Info info = new WE_Info(driver);
	WE_Snackbar snack = new WE_Snackbar(driver);
	WE_Admin_Services Service = new WE_Admin_Services(driver);
	WE_Admin_Services addon = new WE_Admin_Services(driver);
	WE_Admin_Services slot = new WE_Admin_Services(driver);
	Api api = new Api(driver);

	

///  ***************************************************************************** EDIT  STAFF

	
	@Then("Admin searches for the staff name in the search box as {string}")
	public void adminSearchesForTheStaffNameInTheSearchBoxAs(String StaffName) throws InterruptedException {
	   By StaffNameAfterSearch = By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty(StaffName)));
		ClickonElement(user.getSearchBox());
		passInput(user.getSearchBox(), getProperty(StaffName));
		Thread.sleep(3000);
		clickOnElementUsingBy(StaffNameAfterSearch);
	}
	
	@Then("Admin selects the edit option for the staff member")
	public void adminSelectsTheEditOptionForTheStaffMember() throws InterruptedException {
		Thread.sleep(1500);
		ClickonElement(user.getEdit());
	}
	
	@When("Admin erases the existing First Name as {string} and enter the new First name as {string}")
	public void adminErasesTheExistingFirstNameAsAndEnterTheNewFirstNameAs(String FirstName, String string2) {
		ClickonElement(user.getFirstName());
		ClearonElement(user.getFirstName());
		passInput(user.getFirstName(), getProperty(string2));
		driver.hideKeyboard();
	}
	
	@When("Admin erases the existing Last Name as {string} and enter the new Last name as {string}")
	public void adminErasesTheExistingLastNameAsAndEnterTheNewFirstNameAs(String string, String string2) {
		ClickonElement(user.getLastName());
		ClearonElement(user.getLastName());
		passInput(user.getLastName(), getProperty(string2));
		driver.hideKeyboard();
	}
	
	@When("Admin erases the existing email as {string} and enter the new email as {string}")
	public void adminErasesTheExistingEmailAsAndEnterTheNewEmailAs(String string, String string2) {
		ClickonElement(user.getEmail());
		ClearonElement(user.getEmail());
		passInput(user.getEmail(), getProperty(string2));
		driver.hideKeyboard();
	}
	
	@When("Admin erases the existing contact number for staff")
	public void adminErasesTheExistingContactNumberForStaff() throws InterruptedException {
		Thread.sleep(3000);
		ClickonElement(user.getContactNumber());
		ClearonElement(user.getContactNumber());
	}
	
	@When("Admin enters a new contact number as {string}")
	public void adminEntersANewContactNumberAs(String NewContactNumber) throws InterruptedException {
		Thread.sleep(2000);
		passInput(user.getContactNumber(), getProperty(NewContactNumber));
		driver.hideKeyboard();
	}
	
	@When("Admin erases the Addressline for staff {int} and enter the new address")
	public void adminErasesTheAddresslineForStaffAndEnterTheNewAddress(Integer int1) {
		WebElement addressLineElement;
		switch (int1) {
		case 1:
			addressLineElement = user.getAddressLine1();
			break;
		case 2:
			addressLineElement = user.getAddressLine2();
			break;
		default:
			throw new IllegalArgumentException("Invalid address line number: " + int1);
		}
		ClickonElement(addressLineElement);
		ClearonElement(addressLineElement);
		passInput(addressLineElement, getProperty("EDIT_ADMIN_STAFF_ADDRESSLINE_" + int1));
		driver.hideKeyboard();
	}
	
	@When("Admin erases the existing city as {string} and enter the new city name as {string}")
	public void adminErasesTheExistingCityAsAndEnterTheNewCityNameAs(String string, String string2) {
		ClickonElement(user.getCity());
		ClearonElement(user.getCity());
		passInput(user.getCity(), getProperty(string2));
		driver.hideKeyboard();
	}
	
	@When("Admin erases the existing postcode as {string} and enter the new post code as {string}")
	public void adminErasesTheExistingPostcodeAsAndEnterTheNewPostCodeAs(String string, String string2) {
		ClickonElement(user.getPostCode());
		ClearonElement(user.getPostCode());
		passInput(user.getPostCode(), getProperty(string2));
		driver.hideKeyboard();
	}
	
	
////     **************************************************************************   EDIT  CUSTOMER
	
	@Then("Admin searches for the Customer name in the search box as {string}")
	public void adminSearchesForTheCustomerNameInTheSearchBoxAs(String CustomerName) throws InterruptedException {
		By CustomerNameAfterSearch = By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty(CustomerName)));
		ClickonElement(user.getSearchBox());
		passInput(user.getSearchBox(), getProperty(CustomerName));
		Thread.sleep(3000);
		clickOnElementUsingBy(CustomerNameAfterSearch);
	}
	
	@Then("Admin selects the edit option for the customer")
	public void adminSelectsTheEditOptionForTheCustomer() throws InterruptedException {
		Thread.sleep(1500);
		ClickonElement(user.getEdit());
	}
	
	@When("Admin erases the existing First Name as {string} and enter the Customer's new First name as {string}")
	public void adminErasesTheExistingFirstNameAsAndEnterTheCustomerSNewFirstNameAs(String string, String string2) {
		ClickonElement(user.getFirstname());
		ClearonElement(user.getFirstname());
		passInput(user.getFirstname(), getProperty(string2));
		driver.hideKeyboard();

	}
	@When("Admin erases the existing Last Name as {string} and enter the Customer's new Last name as {string}")
	public void adminErasesTheExistingLastNameAsAndEnterTheCustomerSNewLastNameAs(String string, String string2) {
		ClickonElement(user.getLastname());
		ClearonElement(user.getLastname());
		passInput(user.getLastname(), getProperty(string2));
		driver.hideKeyboard();

	}

	@When("Admin erases the Addressline for Customer {int} and enter the new address")
	public void adminErasesTheAddresslineForCustomerAndEnterTheNewAddress(Integer int1) {
		WebElement addressLineElement;
		switch (int1) {
		case 1:
			addressLineElement = user.getAddressLine1();
			break;
		case 2:
			addressLineElement = user.getAddressLine2();
			break;
		default:
			throw new IllegalArgumentException("Invalid address line number: " + int1);
		}
		ClickonElement(addressLineElement);
		ClearonElement(addressLineElement);
		passInput(addressLineElement, getProperty("EDIT_ADMIN_CUSTOMER_ADDRESSLINE_" + int1));
		driver.hideKeyboard();

	}
	
	@When("Admin erases the existing contact number for customer")
	public void adminErasesTheExistingContactNumberForCustomer() throws InterruptedException {
		Thread.sleep(3000);
		Thread.sleep(1000);
		ClickonElement(user.getPhonenumber());
		ClearonElement(user.getPhonenumber());
	}
	
	@When("Admin enters a new contact number for customer as {string}")
	public void adminEntersANewContactNumberForCustomerAs(String NewContact) throws InterruptedException {
		Thread.sleep(2000);
		passInput(user.getPhonenumber(), getProperty(NewContact));
		driver.hideKeyboard();
	}
	
////  *********************************************************************    EDIT  ADMINISTRATION

	@Then("Admin searches for the Admin name in the search box as {string}")
	public void adminSearchesForTheAdminNameInTheSearchBoxAs(String AdminName) throws InterruptedException {
		By AdminNameAfterSearch = By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty(AdminName)));

		ClickonElement(user.getSearchBox());
		passInput(user.getSearchBox(), getProperty(AdminName));
		Thread.sleep(3000);
		clickOnElementUsingBy(AdminNameAfterSearch);
	}
	
	@Then("Admin selects the edit option for the Admin")
	public void adminSelectsTheEditOptionForTheAdmin() throws InterruptedException {
		Thread.sleep(1500);
		ClickonElement(user.getEdit());
	}
	
	@When("Admin erases the Addressline for Admin {int} and enter the new address")
	public void adminErasesTheAddresslineForAdminAndEnterTheNewAddress(Integer int1) {
	    
		WebElement addressLineElement;
		switch (int1) {
		case 1:
			addressLineElement = user.getAddressLine1();
			break;
		case 2:
			addressLineElement = user.getAddressLine2();
			break;
		default:
			throw new IllegalArgumentException("Invalid address line number: " + int1);
		}
		ClickonElement(addressLineElement);
		ClearonElement(addressLineElement);
		passInput(addressLineElement, getProperty("EDIT_ADMIN_ADMIN_ADDRESSLINE_" + int1));
		driver.hideKeyboard();
	}
	
	@When("Admin erases the existing contact number for Admin")
	public void adminErasesTheExistingContactNumberForAdmin() throws InterruptedException {
		Thread.sleep(3000);
		ClickonElement(user.getPhoneNumber());
		ClearonElement(user.getPhoneNumber());
	}
	
	@When("Admin enters a new contact number for Admin as {string}")
	public void adminEntersANewContactNumberForAdminAs(String NewContact) throws InterruptedException {
		Thread.sleep(1500);
		passInput(user.getPhoneNumber(), getProperty(NewContact));
		driver.hideKeyboard();
	}
	
////**********************************************************************    EDIT  TAG CATEGORIES
	
	@Then("the admin pick the category name from the list")
	public void theAdminPickTheCategoryNameFromTheList() throws Exception {
		if (!isElementAvailable(user.searchingCategoryName)) {
			slowscrolluntilelementfound(user.searchingCategoryName);
			clickOnElementUsingBy(user.searchingCategoryName);
		}else {
			clickOnElementUsingBy(user.searchingCategoryName);
		}
	}
	
	@Then("Admin selects the edit option for the Tag")
	public void adminSelectsTheEditOptionForTheTag() throws InterruptedException {
		Thread.sleep(1000);
		ClickonElement(user.getEdit());
	}
	
	@When("Admin erases the existing CategoryName as {string} and enter the new Category Name as {string}")
	public void adminErasesTheExistingCategoryNameAsAndEnterTheNewCategoryNameAs(String string, String string2) {
		ClickonElement(user.getCategoryName());
		ClearonElement(user.getCategoryName());
		passInput(user.getCategoryName(), getProperty(string2));
		driver.hideKeyboard();
		
	}
	@When("Admin erases the existing maximum entity level as {string} and enter the new maximum entity level as {string}")
	public void adminErasesTheExistingMaximumEntityLevelAsAndEnterTheNewMaximumEntityLevelAs(String string, String string2) {
		ClickonElement(user.getMaximumEntityLevel());
		ClearonElement(user.getMaximumEntityLevel());
		passInput(user.getMaximumEntityLevel(), getProperty(string2));
		driver.hideKeyboard();
		
	}

	
	
	@Then("the admin erases the description of the tag")
	public void theAdminErasesTheDescriptionOfTheTag() throws InterruptedException {
		Thread.sleep(1000);
		ClickonElement(user.getDecsription());
		ClearonElement(user.getDecsription());
	}
	
	@Then("the admin enter the new description for editting the tag")
	public void theAdminEnterTheNewDescriptionForEdittingTheTag() throws InterruptedException {
		Thread.sleep(2000);
		passInput(user.getDecsription(), getProperty("EDIT_ADMIN_TAG_CATEGORY_DESCRIPTION"));
		driver.hideKeyboard();
	}
	
	
////  ********************************************************************* EDIT  SERVICE	
   
	@Given("Admin searches for the service name in the search box as {string} and tap the service")
	public void adminSearchesForTheServiceNameInTheSearchBoxAsAndTapTheService(String string) throws InterruptedException {
		Thread.sleep(1500);
		ClickonElement(Service.getSearchBox());
		passInput(Service.getSearchBox(), getProperty(string));
		clickOnElementUsingBy(Service.serviceNameAfterSearch);
	}
	
	@Given("the admin select the edit in title bar")
	public void theAdminSelectTheEditInTitleBar() throws InterruptedException {
		Thread.sleep(1500);
		ClickonElement(Service.getSlotEditICON());
	}
	
	@When("Admin erases the existing Service Name as {string} and enter the new Service name as {string}")
	public void adminErasesTheExistingServiceNameAsAndEnterTheNewServiceNameAs(String string, String string2) throws InterruptedException {
		Thread.sleep(1500);
		ClickonElement(Service.getService_name());
		ClearonElement(Service.getService_name());
		passInput(Service.getService_name(), getProperty(string2));
		driver.hideKeyboard();
	}
	
	@When("Admin erases the existing Service Description as {string} and enter the new Service Descriprion as {string}")
	public void adminErasesTheExistingServiceDescriptionAsAndEnterTheNewServiceDescriprionAs(String string, String string2) throws InterruptedException {
		Thread.sleep(1500);
		ClickonElement(Service.getDescription_textbox());
		ClearonElement(Service.getDescription_textbox());
		passInput(Service.getDescription_textbox(), getProperty(string2));
		driver.hideKeyboard();
	}
	
	@When("Admin erases the existing Service Base price as {string} and enter the new Service base price as {string}")
	public void adminErasesTheExistingServiceBasePriceAsAndEnterTheNewServiceBasePriceAs(String string, String string2) throws Exception {
		Thread.sleep(1500);
		slowscrolluntilelementfound(Service.getFirstElement());
		ClickonElement(Service.getFirstElement());
		ClearonElement(Service.getFirstElement());
		Thread.sleep(1500);
		api.universal_creditlimit();
		double universalCreditLimit = api.universalCreditLimit;
	    double	Baseprice=universalCreditLimit-10;
	    int converted = (int) Baseprice;
	    String str = String.valueOf(converted);
	    Thread.sleep(1500);
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
			passInput(Service.getBaseprice().get(i), getProperty(string2));
			driver.hideKeyboard();
			Thread.sleep(500);
		}

	}
	
	@When("Admin erases the existing Service maximum capacity as {string} and enter the new Service maximum capacity as {string}")
	public void adminErasesTheExistingServiceMaximumCapacityAsAndEnterTheNewServiceMaximumCapacityAs(String string, String string2) throws InterruptedException, Exception {
		Thread.sleep(1500);
		if (isElementAvailable(Service.getMaximum_capacity())) {
			ClickonElement(Service.getMaximum_capacity());
			ClearonElement(Service.getMaximum_capacity());
			passInput(Service.getMaximum_capacity(), getProperty(string2));
			driver.hideKeyboard();
		}else {
			slowScroll();
			ClickonElement(Service.getMaximum_capacity());
			ClearonElement(Service.getMaximum_capacity());
			passInput(Service.getMaximum_capacity(), getProperty(string2));
			driver.hideKeyboard();	
		}
	}
	
	@When("Admin erases the existing Service maximum capacity per staff as {string} and enter the new Service maximum capacity per staff as {string}")
	public void adminErasesTheExistingServiceMaximumCapacityPerStaffAsAndEnterTheNewServiceMaximumCapacityPerStaffAs(String string, String string2) throws InterruptedException {
		Thread.sleep(1500);
		ClickonElement(Service.getMaximum_capacity_Per_Staff());
		ClearonElement(Service.getMaximum_capacity_Per_Staff());
		passInput(Service.getMaximum_capacity_Per_Staff(), getProperty(string2));
		driver.hideKeyboard();

	}
	
	@When("Admin erases the existing Service maximum advance booking limit as {string} and enter the new Service maximum advance booking limit as {string}")
	public void adminErasesTheExistingServiceMaximumAdvanceBookingLimitAsAndEnterTheNewServiceMaximumAdvanceBookingLimitAs(String string, String string2) throws Exception {
		Thread.sleep(1500);
		slowscrolluntilelementfound(Service.getMax_Advance_Booking_Limit());
		ClickonElement(Service.getMax_Advance_Booking_Limit());
		ClearonElement(Service.getMax_Advance_Booking_Limit());
		passInput(Service.getMax_Advance_Booking_Limit(), getProperty(string2));
		driver.hideKeyboard();
	}
	
//	********************************************************* EDIT ADDON
	
	@Given("Admin searches for the Addon name in the search box as {string} and tap the service")
	public void adminSearchesForTheAddonNameInTheSearchBoxAsAndTapTheService(String string) throws InterruptedException {
		Thread.sleep(1500);
		ClickonElement(Service.getSearchBox());
		passInput(Service.getSearchBox(), getProperty(string));
		clickOnElementUsingBy(Service.addonNameAfterSearch);
	}

	@When("Admin erases the existing Addon Name as {string} and enter the new Addon name as {string}")
	public void adminErasesTheExistingAddonNameAsAndEnterTheNewAddonNameAs(String string, String string2) throws InterruptedException {
		Thread.sleep(1500);
		ClickonElement(addon.getAddon_name());
		ClearonElement(addon.getAddon_name());
		passInput(addon.getAddon_name(), getProperty(string2));
		driver.hideKeyboard();
	}
	@When("Admin erases the existing Addon Description as {string} and enter the new Addon Descriprion as {string}")
	public void adminErasesTheExistingAddonDescriptionAsAndEnterTheNewAddonDescriprionAs(String string, String string2) throws InterruptedException {
		Thread.sleep(1500);
		ClickonElement(addon.getAddon_Description_textbox());
		ClearonElement(addon.getAddon_Description_textbox());
		passInput(addon.getAddon_Description_textbox(), getProperty(string2));
		driver.hideKeyboard();

	}
	@When("Admin erases the existing Addon Base price as {string} and enter the new Addon base price as {string}")
	public void adminErasesTheExistingAddonBasePriceAsAndEnterTheNewAddonBasePriceAs(String string, String string2) throws Exception {
		Thread.sleep(1500);
		slowscrolluntilelementfound(addon.getFirstElement());
		ClickonElement(addon.getFirstElement());
		ClearonElement(addon.getFirstElement());
		passInput(addon.getFirstElement(), getProperty(string2));
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
			passInput(addon.getBaseprice().get(i), getProperty(string2));
			driver.hideKeyboard();
			Thread.sleep(500);
		}

	}
	@When("Admin erases the existing Addon maximum capacity as {string} and enter the new Addon maximum capacity as {string}")
	public void adminErasesTheExistingAddonMaximumCapacityAsAndEnterTheNewAddonMaximumCapacityAs(String string, String string2) {
		ClickonElement(addon.getAddon_Maximum_capacity());
		ClearonElement(addon.getAddon_Maximum_capacity());
		passInput(addon.getAddon_Maximum_capacity(), getProperty(string2));
		driver.hideKeyboard();

	}
	@When("Admin erases the existing Addon maximum capacity per staff as {string} and enter the new Addon maximum capacity per staff as {string}")
	public void adminErasesTheExistingAddonMaximumCapacityPerStaffAsAndEnterTheNewAddonMaximumCapacityPerStaffAs(String string, String string2) {
		ClickonElement(addon.getAddon_Maximum_capacity_Per_Staff());
		ClearonElement(addon.getAddon_Maximum_capacity_Per_Staff());
		passInput(addon.getAddon_Maximum_capacity_Per_Staff(), getProperty(string2));
		driver.hideKeyboard();

	}
	
////  ******************************************************** EDIT SLOT


	@Then("Admin searches for the slot name in the search box as {string} and tap the slot")
	public void adminSearchesForTheSlotNameInTheSearchBoxAsAndTapTheSlot(String string) throws InterruptedException {
	   
		passInput(Service.getSearchBox(), getProperty(string));
		
		clickOnElementUsingBy(Service.slotNameAfterSearch);
	   
	}
	
	
	@When("Admin erases the existing slot Name as {string} and enter the new slot name as {string}")
	public void adminErasesTheExistingSlotNameAsAndEnterTheNewSlotNameAs(String string, String string2) {
		   ClickonElement(slot.getSlotName());
		   ClearonElement(slot.getSlotName());
			passInput(slot.getSlotName(), getProperty(string2));
			driver.hideKeyboard();

	}
	@When("Admin erases the existing slot Description as {string} and enter the new slot Descriprion as {string}")
	public void adminErasesTheExistingSlotDescriptionAsAndEnterTheNewSlotDescriprionAs(String string, String string2) {

		ClickonElement(slot.getDescriptionTextBox());
		  ClearonElement(slot.getDescriptionTextBox());
		passInput(slot.getDescriptionTextBox(), getProperty(string2));
		driver.hideKeyboard();
	}
	@When("Admin change the start time of the slot")
	public void adminChangeTheStartTimeOfTheSlot() throws Exception {
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

	}
	
}
