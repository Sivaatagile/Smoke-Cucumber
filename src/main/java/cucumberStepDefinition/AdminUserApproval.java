package cucumberStepDefinition;

import org.openqa.selenium.By;

import com.WE.WE_Admin_User;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Info;
import com.WE.WE_Snackbar;
import com.baseClass.Base;

import io.cucumber.java.en.*;

public class AdminUserApproval extends Base {
	WE_Admin_User user = new WE_Admin_User(driver);
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
	WE_Info info = new WE_Info(driver); 
	WE_Snackbar snack = new WE_Snackbar(driver);

////********************************************************** USER APPROVAL 

	@Given("Admin clicks on the Users tab")
	public void theAdminClicksOnTheUsersTab() {
		ClickonElement(workflow.getUsers_navigation_Bar());
	}

	@When("Admin clicks on the Pending Requests showall option")
	public void theAdminClicksOnThePendingRequestsShowallOption() {
		ClickonElement(user.getShowall_PendingRequest());
	}
	@When("searches for the signup customer name as {string}")
	public void searchesForTheSignupCustomerNameAs(String string) throws InterruptedException {
		Thread.sleep(2000);
		ClickonElement(user.getSearchBox());
		passInput(user.getSearchBox(), getProperty(string));
		driver.hideKeyboard();
	}

	@Then("the matching customer list is displayed as {string}")
	public void theMatchingCustomerListIsDisplayedAs(String string) throws InterruptedException, Error {
		 By EyeIcon1 = By.xpath("//*[starts-with(@content-desc,'pending')]/android.view.View[@content-desc='"+ getProperty(string) + "']/following-sibling::android.widget.ImageView[1]");

		if (isElementAvailable(EyeIcon1)) {
			System.out.println("user found");
		} else {
			System.out.println("user not found");
			throw new Error("User not found");
		}
	}

	@When("Admin clicks on the customer name as {string}")
	public void adminClicksOnTheCustomerNameAs(String string) throws InterruptedException {
		 By EyeIcon1 = By.xpath("//*[starts-with(@content-desc,'pending')]/android.view.View[@content-desc='"+ getProperty(string) + "']/following-sibling::android.widget.ImageView[1]");
		clickOnElementUsingBy(EyeIcon1);
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

	@Then("a confirmation popup is displayed then Admin clicks on the Confirm button in the popup")
	public void aConfirmationPopupIsDisplayedThenTheAdminClicksOnTheConfirmButtonInThePopup() throws InterruptedException {
		ClickonElement(user.getConfirm());
		waitForElement(snack.getAccountApprovedSuccessfully());
	}

	@Then("User request is successfully approved")
	public void theCustomerRequestIsSuccessfullyApproved() throws InterruptedException {
		System.out.println("Check the snack bar");
		ClickonElement(info.getBackButton());
	}

	@Then("Admin is navigated back to the home page")
	public void theAdminIsNavigatedBackToTheHomePage() {
		ClickonElement(user.getHome());
	}
		
////************************************************************** PET APPROVAL	
	
	
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
	

