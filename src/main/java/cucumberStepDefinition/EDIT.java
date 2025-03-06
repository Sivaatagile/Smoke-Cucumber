package cucumberStepDefinition;

import org.openqa.selenium.WebElement;

import com.WE.WE_Admin_User;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Info;
import com.WE.WE_Snackbar;
import com.baseClass.Base;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EDIT extends Base{
	WE_Admin_User user = new WE_Admin_User(driver);
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
	WE_Info info = new WE_Info(driver);
	WE_Snackbar snack = new WE_Snackbar(driver);
	
	

///                                                         	  EDIT  STAFF

	
	@Then("Admin searches for the staff name in the search box as {string}")
	public void adminSearchesForTheStaffNameInTheSearchBoxAs(String StaffName) throws InterruptedException {
		ClickonElement(user.getSearchBox());
		passInput(user.getSearchBox(), getProperty(StaffName));
		Thread.sleep(3000);
		clickOnElementUsingBy(user.StaffNameAfterSearch);
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
	
	
////                                                       EDIT  CUSTOMER
	
	@Then("Admin searches for the Customer name in the search box as {string}")
	public void adminSearchesForTheCustomerNameInTheSearchBoxAs(String CustomerName) throws InterruptedException {
		ClickonElement(user.getSearchBox());
		passInput(user.getSearchBox(), getProperty(CustomerName));
		Thread.sleep(3000);
		clickOnElementUsingBy(user.CustomerNameAfterSearch);
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
	
////                                                         EDIT  ADMINISTRATION

	@Then("Admin searches for the Admin name in the search box as {string}")
	public void adminSearchesForTheAdminNameInTheSearchBoxAs(String AdminName) throws InterruptedException {
		ClickonElement(user.getSearchBox());
		passInput(user.getSearchBox(), getProperty(AdminName));
		Thread.sleep(3000);
		clickOnElementUsingBy(user.AdminNameAfterSearch);
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
	
////	                                                	EDIT  TAG CATEGORIES
	
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
	
	
}
