package cucumberStepDefinition;

import org.openqa.selenium.By;

import com.WE.WE_Admin_Settings;
import com.WE.WE_Admin_WorkFlow;
import com.baseClass.Base;
import com.frontend.Customer_Settings;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminSettings extends Base {
	WE_Admin_Settings settings = new WE_Admin_Settings(driver);
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);

//	-------------------------------------------------------->   Manage Credit Limit

	@When("the admin taps on Manage Credit Limit")
	public void theAdminTapsOnManageCreditLimit() {
		ClickonElement(settings.getManageCreditLimit());
	}

	@When("the admin clicks on the search button on manage credit limit")
	public void theAdminClicksOnTheSearchButtonOnManageCreditLimit() {
		ClickonElement(settings.getsearch());
	}

	@When("the admin enters the customer name for updating the credit limit")
	public void theAdminEntersTheCustomerNameForUpdatingTheCreditLimit() throws InterruptedException {
		passInput(settings.getsearch(), getProperty("SIGNUP_FIRSTNAME") + " " + getProperty("SIGNUP_LASTNAME"));
		Thread.sleep(3000);
		clickOnElementUsingBy(settings.CustomerNameForRemainingcredit);
	}

	@When("the admin enters the credit limit amount then the credit limit should be automatically saved")
	public void theAdminEntersTheCreditLimitAmountThenTheCreditLimitShouldBeAutomaticallySaved() {
		passInput(settings.CustomerNameForRemainingcredit, "999");
		driver.hideKeyboard();
	}

	@When("the admin should see a snackbar with the message")
	public void theAdminShouldSeeASnackbarWithTheMessage() {
		System.out.println("Check the snack bar ");
	}

//	------------------------------------------------------->   Adhoc 

	@Given("the admin selects the accounts")
	public void theAdminSelectsTheAccounts() {
		ClickonElement(settings.getAccounts());
	}

	@When("the admin taps the plus icon in that account")
	public void theAdminTapsThePlusIconInThatAccount() throws InterruptedException {
		Thread.sleep(2000);
		ClickonElement(settings.getFAB());
	}

	@When("the admin taps the search button in account")
	public void theAdminTapsTheSearchButtonInAccount() throws InterruptedException {
		Thread.sleep(2000);
		ClickonElement(settings.getAccountsCustomer());
		Thread.sleep(2000);
		ClickonElement(settings.getSearchCustomer_Accounts());
	}

	@When("the admin enters the customer name")
	public void theAdminEntersTheCustomerName() throws InterruptedException {
		Thread.sleep(2000);
		passInput(settings.getSearchCustomer_Accounts(),
				getProperty("SIGNUP_FIRSTNAME") + " " + getProperty("SIGNUP_LASTNAME"));
		Thread.sleep(2000);
		driver.hideKeyboard();
	}

	@When("the admin finds the customer and select it")
	public void theAdminFindsTheCustomerAndSelectIt() throws InterruptedException {
		Thread.sleep(2000);
		clickOnElementUsingBy(settings.CustomerNameInAccountsSearch);
	}

	@When("the admin taps on the Adhoc amount")
	public void theAdminTapsOnTheAdhocAmount() {
		ClickonElement(settings.getAdhocAmount());
	}

	@When("the admin enters the amount in Adhoc amount")
	public void theAdminEntersTheAmountInAdhocAmount() {
		passInput(settings.getAdhocAmount(), "10000");
	}

	@When("the admin taps on the remarks field in Adhoc")
	public void theAdminTapsOnTheRemarksFieldInAdhoc() {
		ClickonElement(settings.getRemarksAccounts());
	}

	@When("the admin enters the remark details in Adhoc")
	public void theAdminEntersTheRemarkDetailsInAdhoc() {
		passInput(settings.getRemarksAccounts(), "Remarks");
		driver.hideKeyboard();
	}

	@Then("the admin taps on the submit button in adhoc")
	public void theAdminTapsOnTheSubmitButtonInAdhoc() {
		ClickonElement(settings.getSubmitAdhoc());
	}

//	------------------------------------------------------------------->   Admin Statement
	
	@When("the admin taps on Statements")
	public void theAdminTapsOnStatements() throws InterruptedException {
		ClickonElement(settings.getstatements());
		waitForElement(settings.getYearStatement());
	}
	
	@When("the admin taps on the search button in Admin Statements")
	public void theAdminTapsOnTheSearchButtonInAdminStatements() throws InterruptedException {
		Thread.sleep(2000);
		ClickonElement(settings.getsearch());
	}
	
	@When("the admin enters the customer name in the search box")
	public void theAdminEntersTheCustomerNameInTheSearchBox() throws InterruptedException {
		Thread.sleep(2000);
		passInput(settings.getsearch(), getProperty("SIGNUP_FIRSTNAME"));
	}
	
	@When("the admin finds the customer label and taps on the customer label")
	public void theAdminFindsTheCustomerLabelAndTapsOnTheLabel() throws InterruptedException {
		clickOnElementUsingBy(settings.SignupFirstname);
	}

	@Then("the invoice number should be listed")
	public void theInvoiceNumberShouldBeListed() throws Exception {
		Thread.sleep(5000);
		System.out.println(Booking.InvoiceNumber);
		By BookedPAYMENT1 = By.xpath("//android.view.View[@content-desc='#" + Booking.InvoiceNumber + "']");
		System.out.println(BookedPAYMENT1);
		halfscrollUntilElementFound12(settings.getscroll(), BookedPAYMENT1);
		if (isElementAvailable(BookedPAYMENT1)) {
			Thread.sleep(4000);
			System.out.println("hhh : " + Booking.StatementCreatedDate);
			Thread.sleep(3000);
			By statementcreateddatelocator = By
					.xpath("//android.view.View[@content-desc='" + Booking.StatementCreatedDate + "']");
			// android.view.View[@content-desc="Jan 01 2025"]
			if (isElementAvailable(statementcreateddatelocator)) {
				System.out.println("date showed");
				System.out.println("Bookings is listed on admins statement page ");
			}
		} else {
			System.out.println("Not listed");
		}
	}
	
	@Then("the admin get back to the statements page")
	public void theAdminGetBackToTheStatementsPage() throws InterruptedException {
		Thread.sleep(1000);
		ClickonElement(settings.getgetback());
	}
	
	@Then("the admin get back to the settings page")
	public void theAdminGetBackToTheSettingsPage() throws InterruptedException {
		Thread.sleep(2000);
		ClickonElement(settings.getgetback());
		ClickonElement(settings.gethometab());
	}
	
//	---------------------------------------------------------------->    Admin Invoices 
	
	@When("the admin taps on Invoices")
	public void theAdminTapsOnInvoices() throws InterruptedException {
		Thread.sleep(2000);
		ClickonElement(settings.getinvoices());
	}
	
	@When("the admin enters the invoice number in the search box of Admin Invoices")
	public void theAdminEntersTheInvoiceNumberInTheSearchBoxOfAdminInvoices() throws InterruptedException {
		Thread.sleep(2000);
		ClickonElement(settings.getsearch());
		Thread.sleep(2000);
		passInput(settings.getsearch(), Booking.InvoiceNumber);
		driver.hideKeyboard();
	}
	
	@Then("the admin finds and verifies the invoice number")
	public void theAdminFindsAndVerifiesTheInvoiceNumber() throws InterruptedException {
		Thread.sleep(2000);
		if (isElementAvailable(settings.getSelectInvoice())) {
			System.out.println("Successfully  invoice is generated ");
		} else if (isElementAvailable(settings.getNoRecordFound())) {
			System.out.println("Invoice is not generated");
		}
	}
	

}
