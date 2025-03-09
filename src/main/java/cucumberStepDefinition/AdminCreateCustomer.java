package cucumberStepDefinition;

import org.openqa.selenium.WebElement;

import com.WE.WE_Admin_User;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Info;
import com.WE.WE_Snackbar;
import com.baseClass.Base;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminCreateCustomer extends Base{

	WE_Admin_User user = new WE_Admin_User(driver);
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
	WE_Info info = new WE_Info(driver);
	WE_Snackbar snack = new WE_Snackbar(driver);
	
	@When("Admin enters the Customer first name {string}")
	public void theAdminEntersTheCustomerFirstName(String CUSTOMER_FIRSTNAME) {
		ClickonElement(user.getFirstname());
		passInput(user.getFirstname(), getProperty(CUSTOMER_FIRSTNAME));
		driver.hideKeyboard();
	}
	
	@When("Admin enters the Customer last name {string}")
	public void theAdminEntersTheCustomerLastName(String CUSTOMER_LASTNAME) {
		ClickonElement(user.getLastname());
		passInput(user.getLastname(), getProperty(CUSTOMER_LASTNAME));
		driver.hideKeyboard();
	}
	
	@When("Admin clicks on Customer's Show All")
	public void theAdminClicksOnCustomerSShowAll() {
		ClickonElement(user.getShowall_AllCustomers());
	}
	
	@Then("Admin is navigated to the Customer's list page")
	public void theAdminIsNavigatedToTheCustomerSListPage() throws InterruptedException {
		waitForElement(user.getAllCustomers());
	}
	
	@When("Admin clicks on the + button to add a new Customer")
	public void theAdminClicksOnTheButtonToAddANewCustomer() {
		ClickonElement(user.getFAB());
	}
	
	@When("Admin enters the customer phone number {string}")
	public void theAdminEntersTheCustomerPhoneNumber(String CUSTOMER_PHONENUMBER) throws InterruptedException {
		Thread.sleep(1000);
		ClickonElement(user.getPhonenumber());
		passInput(user.getPhonenumber(), getProperty(CUSTOMER_PHONENUMBER));
		driver.hideKeyboard();
	}
	
	@When("Admin enters the address line for customer {int}")
	public void theAdminEntersTheAddressLineForCustomer(Integer int1) {
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
		passInput(addressLineElement, getProperty("ADMIN_CUSTOMER_ADDRESSLINE_" + int1));
		driver.hideKeyboard();
	}
		
	@Then("The new customer details should be successfully saved")
	public void theNewCustomerDetailsShouldBeSuccessfullySaved() throws InterruptedException {
		waitForElement(user.getAllCustomers());
	}
	
}
