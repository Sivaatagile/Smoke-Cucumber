package cucumberStepDefinition;

import com.WE.WE_Admin_User;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Info;
import com.baseClass.Base;
import com.frontend.Info;

import io.cucumber.java.en.Then;

public class AdminAddSecondPet extends Base{

	
//	public static  void secondpetad() throws Exception {
//
//		WE_Admin_User user = new WE_Admin_User(driver);
//		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
//		ClickonElement(workflow.getUsers_navigation_Bar());
//
//		waitForElement(user.getShowall_AllCustomers());
//		Thread.sleep(2000);
//		ClickonElement(user.getShowall_AllCustomers());
//		ClickonElement(user.getSearchBox());
//		Thread.sleep(3000);
//		passInput(user.getSearchBox(), getProperty("SIGNUP_EMAIL"));
//		driver.hideKeyboard();
//		Thread.sleep(4000);
//		if (isElementAvailable(user.getuser())) {
//			System.out.println("User Found ");
//			Thread.sleep(1000);
//			ClickonElement(user.getuser());
//			ClickonElement(user.getview());
//			ClickonElement(user.getMyPet());
//			
//			ClickonElement(user.getFAB());
//			Info.Pet_Data();
//			
//			
//			
//			
//		} else if (isElementAvailable(user.trySearchingagain)) {
//			System.out.println("User not found");
//			throw new Error("User not found");
//		}
//		
//	}
	
	WE_Admin_User user = new WE_Admin_User(driver);
	WE_Info PetInfo = new WE_Info(driver);

	
	@Then("the admin searches for the customer in the search box and selects the customer")
	public void theAdminSearchesForTheCustomerInTheSearchBoxAndSelectsTheCustomer() throws InterruptedException {
		ClickonElement(user.getSearchBox());
		Thread.sleep(3000);
		passInput(user.getSearchBox(), getProperty("SIGNUP_EMAIL"));
		driver.hideKeyboard();	
		Thread.sleep(4000);
		if (isElementAvailable(user.getuser())) {
			System.out.println("User Found ");
			Thread.sleep(1000);
			ClickonElement(user.getuser());		
		} else if (isElementAvailable(user.trySearchingagain)) {
			System.out.println("User not found");
			throw new Error("User not found");
		}

	}
	@Then("the admin clicks the view button for the selected customer")
	public void theAdminClicksTheViewButtonForTheSelectedCustomer() {

		ClickonElement(user.getview());

	}
	@Then("the admin Clicks the My pets")
	public void theAdminClicksTheMyPets() {

		ClickonElement(user.getMyPet());

	}
	@Then("the admin taps the plus button to create a second pet")
	public void theAdminTapsThePlusButtonToCreateASecondPet() {
		ClickonElement(user.getFAB());


	}
	@Then("the admin enter the admin notes {string}")
	public void theAdminEnterTheAdminNotes(String AdminNotes) throws InterruptedException {
		if (isElementAvailable(PetInfo.getAdminNotes())) {
			ClickonElement(PetInfo.getAdminNotes());
			passInput(PetInfo.getAdminNotes(), getProperty(AdminNotes));
			driver.hideKeyboard();
		}

	}
	
	
	
		
		
	}
	
	

