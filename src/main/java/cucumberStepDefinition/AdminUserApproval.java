package cucumberStepDefinition;

import com.WE.WE_Admin_User;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Info;
import com.baseClass.Base;

import io.cucumber.java.en.*;

public class AdminUserApproval extends Base {
	WE_Admin_User user = new WE_Admin_User(driver);
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
	WE_Info info = new WE_Info(driver);

	@Given("the admin clicks on the Users tab")
	public void theAdminClicksOnTheUsersTab() {
		ClickonElement(workflow.getUsers_navigation_Bar());
	}

	@When("clicks on the Pending Requests showall option")
	public void clicksOnThePendingRequestsShowallOption() {
		ClickonElement(user.getShowall_PendingRequest());
	}

	@When("searches for the signup customer name")
	public void searchesForTheSignupCustomerName() throws InterruptedException {
		Thread.sleep(4000);
		ClickonElement(user.getSearchBox());
		Thread.sleep(3000);
		passInput(user.getSearchBox(), getProperty("SIGNUP_FIRSTNAME"));
		driver.hideKeyboard();
	}

	@Then("the matching customer list is displayed")
	public void theMatchingCustomerListIsDisplayed() throws InterruptedException {
		Thread.sleep(4000);
		if (isElementAvailable(user.UserLocator1)) {
			System.out.println("user found");
		} else {
			System.out.println("user not found");
			throw new Error("User not found");
		}
	}

	@When("the admin clicks on the customer name")
	public void theAdminClicksOnTheCustomerName() throws InterruptedException {
		Thread.sleep(2000);
		clickOnElementUsingBy(user.EyeIcon1);
	}

	@When("scrolls down to find the Accept button and click it")
	public void scrollsDownToFindTheAcceptButtonAndClickIt() throws InterruptedException {
		boolean isElementFound = false;
		Thread.sleep(1000);
		while (!isElementFound) {
			try {
				Thread.sleep(1000);
				if (isScrollViewAvailable()) {
					Thread.sleep(3000);
					scroll(user.getscroll());
					Thread.sleep(2000);
					ClickonElementwithoutWAIT(user.getAccept());
					isElementFound = true;
				}
			} catch (Exception e) {
				System.out.println("Accept element not found, scrolling again...");
			}
		}
	}

	@Then("a confirmation popup is displayed then the admin clicks on the Confirm button in the popup")
	public void aConfirmationPopupIsDisplayedThenTheAdminClicksOnTheConfirmButtonInThePopup() {
		ClickonElement(user.getConfirm());
	}

	@Then("the customer request is successfully approved")
	public void theCustomerRequestIsSuccessfullyApproved() {
		System.out.println("Check the snack bar");
		ClickonElement(info.getBackButton());
	}

	@Then("the admin is navigated back to the home page")
	public void theAdminIsNavigatedBackToTheHomePage() {
		ClickonElement(user.getHome());
	}
}
