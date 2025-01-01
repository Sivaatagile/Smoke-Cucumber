package cucumberStepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.WE.WE_Admin_WorkFlow;
import com.baseClass.Base;
import com.frontend.Customer_Bookingflow;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminWorkflow extends Base{
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver); // Create Admin_approval object

	
	public static void Assigned() throws Exception {
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver); // Create Admin_approval object
		ClickonElement(workflow.getService()); // Click on service filter
		boolean isElementFound = false; // Initialize flag for element found
		while (!isElementFound) { // Loop until element is found
			try {
				workflow.getBookedServiceLocator(); // Attempt to get booked service locator
				if (workflow.getBookedServiceLocator() != null) { // Check if booked service locator is found
					ClickonElement(workflow.getBookedServiceLocator()); // Click on booked service
					isElementFound = true; // Set flag to true
				}
			} catch (Exception e) {
				slowScroll(); // Scroll down if element not found
			}
		}
		dateFormatForWorkflow(Booking.Booked_Date);
		ClickonElement(workflow.getDate_Slot()); // Click on date filter
//		scrollToExactValue(workflow.getDate(),"Wed Jun 25");
		scrollUntil(workflow.getDate(), workflow.getBookedDateLocator()); // Scroll to find booked date
		scrollUntilElementFound(workflow.getSlot(), workflow.getBookedSlotLocator()); // Scroll to find booked slot
		
		Thread.sleep(5000);
		ClickonElement(workflow.getSelect()); // Click on select button

	}
	
	
	
	public static void Staff_for_assigned() throws Exception {
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver); // Create Admin_approval object
		boolean isElementFound = false; // Initialize flag for element found
		while (!isElementFound) { // Loop until element is found
			try {
				workflow.getstafflocator(); // Attempt to get staff locator
				if (workflow.getstafflocator() != null) { // Check if staff locator is found
					ClickonElement(workflow.getstafflocator()); // Click on staff locator
					isElementFound = true; // Set flag to true
				}
			} catch (Exception e) {
				scrollEachElement(workflow.getscrollview()); // Scroll down if element not found
			}
		}
	}
	
	
	
	@Given("the user navigates to the Pending tab")
	public void theUserNavigatesToThePendingTab() {
	    ClickonElement(workflow.getPending_Tab());	
	    System.out.println("kkkk");
	}
	
	@When("the user selects the booking's service from the Service dropdown, opens the Date & Slot dropdown, and selects the booked date and slot")
	public void theUserSelectsTheBookingSServiceFromTheServiceDropdownOpensTheDateSlotDropdownAndSelectsTheBookedDateAndSlot() throws Exception {
	    System.out.println("ppppp");

		Assigned();	
	}
	
	@When("the user applies the toggle button")
	public void theUserAppliesTheToggleButton() throws InterruptedException {
		ClickonElement(workflow.getAddon_Toggle()); // Click on Add-on toggle button
		Thread.sleep(2000); // Wait for 2 seconds
		ClickonElement(workflow.getAddon_Toggle()); // Click on Add-on toggle button again
		ClickonElement(workflow.getBookingTime_Toggle()); // Click on BookingTime toggle button
	    
	
	}
	
	@Then("the booking should move to the Unassigned tab")
	public void theBookingShouldMoveToTheUnassignedTab() throws InterruptedException {
	  
		Thread.sleep(5000);
	    if (isElementAvailable(workflow.NoBookingYet)) {
			System.out.println("No booking is listed on pending. Navigate to unassigned tab and check");
		}else {
			ClickonElement(workflow.getTickButton());
		}
		
	}
	
	@Given("the user navigates to the Unassigned tab")
	public void theUserNavigatesToTheUnassignedTab() {
		ClickonElement(workflow.getUnassigned_Tab()); // Click on Unassigned tab
	}
	
	@When("the user selects the specific booking")
	public void theUserSelectsTheSpecificBooking() throws Exception {
		ClickonElement(workflow.getStaffDropDown()); // Click on Staff filter
		waitForElement(workflow.getscrollview());
		Staff_for_assigned(); // Call Staff_for_assigned method
		
	}
	
	@When("the user assigns the booking to a staff member")
	public void theUserAssignsTheBookingToAStaffMember() throws InterruptedException {
		Thread.sleep(5000); // Wait for 2 seconds
		WebElement elements = driver.findElement(By.xpath("//android.view.View[contains(@content-desc, 'unassigned_customer_name')]/android.widget.ImageView[3]"));
		elements.click();
		// List oda size-a eduthutu iterate pannaum
	
//		ClickAllListElements(workflow.getImageviewCheckbox());
//		ClickonElement(workflow.getPartially_Assigned_Toggle());
		Thread.sleep(1500);
		ClickonElement(workflow.getAssign_Selected()); // Click on Assign Selected button
		
	}
	
	@Then("the booking should be assigned successfully")
	public void theBookingShouldBeAssignedSuccessfully() {
	    System.out.println("completed successfully ");
		
	}

	
	
	
	
	
	
	
}
