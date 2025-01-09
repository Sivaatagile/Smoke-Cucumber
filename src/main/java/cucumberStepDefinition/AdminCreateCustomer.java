package cucumberStepDefinition;

import org.openqa.selenium.WebElement;

import com.WE.WE_Admin_User;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Info;
import com.baseClass.Base;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminCreateCustomer extends Base{

	WE_Admin_User user = new WE_Admin_User(driver);
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
	WE_Info info = new WE_Info(driver);
	
	
	@When("the admin enters the Customer first name {string}")
	public void theAdminEntersTheCustomerFirstName(String string) {
		ClickonElement(user.getFirstname());
		passInput(user.getFirstname(), getProperty("CUSTOMER_FIRSTNAME"));
		driver.hideKeyboard();
	}
	@When("the admin enters the Customer last name {string}")
	public void theAdminEntersTheCustomerLastName(String string) {
		ClickonElement(user.getLastname());
		passInput(user.getLastname(), getProperty("CUSTOMER_LASTNAME"));
		driver.hideKeyboard();
		
	}
	
	@When("the admin clicks on Customer's Show All")
	public void theAdminClicksOnCustomerSShowAll() {
		ClickonElement(user.getShowall_AllCustomers());


	}
	@Then("the admin is navigated to the Customer's list page")
	public void theAdminIsNavigatedToTheCustomerSListPage() throws InterruptedException {
waitForElement(user.getAllCustomers());

	}
	@When("the admin clicks on the + button to add a new Customer")
	public void theAdminClicksOnTheButtonToAddANewCustomer() {
		ClickonElement(user.getFAB());


	}
	@When("the admin enters the customer phone number {string}")
	public void theAdminEntersTheCustomerPhoneNumber(String string) throws InterruptedException {
		Thread.sleep(1000);
		ClickonElement(user.getPhonenumber());
		passInput(user.getPhonenumber(), getProperty("CUSTOMER_PHONENUMBER"));
		driver.hideKeyboard();

	}
	@When("the admin enters the address line for customer {int}")
	public void theAdminEntersTheAddressLineForCustomer(Integer int1) {
		WebElement addressLineElement;
		switch (int1) {
		case 1:
			addressLineElement = user.getAddressLine1();
			break;
		case 2:
			addressLineElement = user.getAddressLine2();
			break;
		// Add more cases if needed
		default:
			throw new IllegalArgumentException("Invalid address line number: " + int1);
		}
		// Perform actions on the dynamically selected address line
		ClickonElement(addressLineElement);
		passInput(addressLineElement, getProperty("ADMIN_CUSTOMER_ADDRESSLINE_" + int1));
		driver.hideKeyboard();

	}
	@Then("the new customer details should be successfully saved")
	public void theNewCustomerDetailsShouldBeSuccessfullySaved() {
		System.out.println("Admin created ");


	}
	
}
