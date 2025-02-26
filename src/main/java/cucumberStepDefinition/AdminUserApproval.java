package cucumberStepDefinition;

import com.WE.WE_Admin_User;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Info;
import com.WE.WE_Snackbar;
import com.baseClass.Base;

import io.cucumber.java.en.*;
import io.qameta.allure.Allure;

public class AdminUserApproval extends Base {
	WE_Admin_User user = new WE_Admin_User(driver);
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
	WE_Info info = new WE_Info(driver); 
	WE_Snackbar snack = new WE_Snackbar(driver);

	@Given("the admin clicks on the Users tab")
	public void theAdminClicksOnTheUsersTab() {
		ClickonElement(workflow.getUsers_navigation_Bar());
	}

	@When("the admin clicks on the Pending Requests showall option")
	public void theAdminClicksOnThePendingRequestsShowallOption() {
		ClickonElement(user.getShowall_PendingRequest());
	}

	@When("searches for the signup customer name")
	public void searchesForTheSignupCustomerName() throws InterruptedException {
		ClickonElement(user.getSearchBox());
		passInput(user.getSearchBox(), getProperty("SIGNUP_FIRSTNAME"));
		driver.hideKeyboard();
	}

	@Then("the matching customer list is displayed")
	public void theMatchingCustomerListIsDisplayed() throws InterruptedException {
		if (isElementAvailable(user.UserLocator1)) {
			System.out.println("user found");
		} else {
			System.out.println("user not found");
			throw new Error("User not found");
		}
	}

	@When("the admin clicks on the customer name")
	public void theAdminClicksOnTheCustomerName() throws InterruptedException {
		clickOnElementUsingBy(user.EyeIcon1);
	}

	@When("scrolls down to find the Accept button and clicks it")
	public void scrollsDownToFindTheAcceptButtonAndClicksIt() throws InterruptedException {
		boolean isElementFound = false;
		while (!isElementFound) {
			try {
				if (isScrollViewAvailable()) {
					scroll(user.getscroll());
					ClickonElementwithoutWAIT(user.getAccept());
					isElementFound = true;
				}
			} catch (Exception e) {
				System.out.println("Accept element not found, scrolling again...");
			}
		}
	}

	@Then("a confirmation popup is displayed then the admin clicks on the Confirm button in the popup")
	public void aConfirmationPopupIsDisplayedThenTheAdminClicksOnTheConfirmButtonInThePopup() throws InterruptedException {
		ClickonElement(user.getConfirm());
		waitForElement(snack.getAccountApprovedSuccessfully());
	}

	@Then("the customer request is successfully approved")
	public void theCustomerRequestIsSuccessfullyApproved() throws InterruptedException {
		System.out.println("Check the snack bar");
		ClickonElement(info.getBackButton());
	}

	@Then("the admin is navigated back to the home page")
	public void theAdminIsNavigatedBackToTheHomePage() {
		ClickonElement(user.getHome());
	}
		
	@Given("approve pet")
	public void approvePet() throws InterruptedException {

			ClickonElement(workflow.getUsers_navigation_Bar());
			ClickonElement(user.getShowall_PendingRequest());
			Thread.sleep(4000);
			ClickonElement(user.getSearchBox());
			Thread.sleep(3000);
			passInput(user.getSearchBox(), getProperty("PET_NAME"));
			driver.hideKeyboard();
			Thread.sleep(4000);
			if (isElementAvailable(user.PetLocator1)) {
				System.out.println("Pet found");
			} else {
				System.out.println("Pet not found");
				throw new Error("Pet not found");
			}
			clickOnElementUsingBy(user.PetEyeIcon1);
			waitForElement(user.getgender());
			boolean isElementFound = false;
			while (!isElementFound) {
				try {
					if (isScrollViewAvailable()) {
						Thread.sleep(3000);
						scrolling();
						Allure.step("Scroll the Customer Info");
						Thread.sleep(2000);
						ClickonElementwithoutWAIT(user.getAccept());
						isElementFound = true;
					}
				} catch (Exception e) {
					System.out.println("Accept element not found, scrolling again...");
				}
			}
			ClickonElement(user.getConfirm());

		}
	}
	

