package cucumberStepDefinition;

import com.WE.WE_Admin_User;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Info;
import com.baseClass.Base;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class AdminPetApproval extends Base{
	WE_Admin_User user = new WE_Admin_User(driver);
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
	WE_Info info = new WE_Info(driver);
	
	@When("the admin searches for the pet in the search box under pending requests")
	public void theAdminSearchesForThePetInTheSearchBoxUnderPendingRequests() throws InterruptedException {
		Thread.sleep(4000);
		ClickonElement(user.getSearchBox());
		Thread.sleep(3000);
		passInput(user.getSearchBox(), getProperty("PET_NAME"));
		driver.hideKeyboard();
	}
	
	@When("the admin taps on the eye icon in the pet label")
	public void theAdminTapsOnTheEyeIconInThePetLabel() throws InterruptedException, Error {
		Thread.sleep(4000);
		if (isElementAvailable(user.PetLocator1)) {
			System.out.println("Pet found");
		} else {
			System.out.println("Pet not found");
			throw new Error("Pet not found");
		}
		clickOnElementUsingBy(user.PetEyeIcon1);
	}

	@Then("the admin scrolls down and accepts the pet")
	public void theAdminScrollsDownAndAcceptsThePet() throws InterruptedException {
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
	}
	
	@Then("the admin confirms the pet approval")
	public void theAdminConfirmsThePetApproval() throws InterruptedException {
		ClickonElement(user.getConfirm());	
		Thread.sleep(6000);
	}
		
}
