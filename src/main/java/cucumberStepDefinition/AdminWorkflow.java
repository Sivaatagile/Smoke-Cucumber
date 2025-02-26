package cucumberStepDefinition;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.WE.WE_Admin_Settings;
import com.WE.WE_Admin_WorkFlow;
import com.baseClass.Base;
import com.frontend.Customer_Bookingflow;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminWorkflow extends Base {
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver); // Create Admin_approval object
	static WE_Admin_Settings settings = new WE_Admin_Settings(driver);
	public static void Assigned() throws Exception {
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver); // Create Admin_approval object
		ClickonElement(settings.gethometab());
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
//		dateFormatForWorkflow(Booking.Booked_Date);
		ClickonElement(workflow.getAllslots()); // Click on date filter
////		scrollToExactValue(workflow.getDate(),"Wed Jun 25");
////		By by = workflow.getBookedDateLocator();
////		System.out.println("yvcyswc   " + by);
////
////		scrollUntil(workflow.getDate(), workflow.getBookedDateLocator()); // Scroll to find booked date
////		By by1 = workflow.getBookedSlotLocator();
////		System.out.println("yvcyswc   " + by1);
		Thread.sleep(8000);
		scrollUntilElementFound(workflow.getSlot(), workflow.getBookedSlotLocator()); // Scroll to find booked slot

		Thread.sleep(5000);
		ClickonElement(workflow.getSelect()); // Click on select button

		ClickonElement(workflow.getdatefilter());
        SimpleDateFormat inputFormat = new SimpleDateFormat("MMM dd, yyyy");

		   SimpleDateFormat outputFormat = new SimpleDateFormat("MMM yyyy");

	        // Convert the date
	        Date date = inputFormat.parse(Booking.Booked_Date);
	        String formattedDate = outputFormat.format(date);

	        // Print the result
	        System.out.println("Converted Date: " + formattedDate);
//	        
	        
	        String targetMonthYear = "Jul 2025"; // The required month and year
	        By monthYearLocator = By.xpath("//android.view.View[@content-desc='" + formattedDate + "']");
	        By nextButtonLocator = By.xpath("(//android.widget.Button)[2]"); // Locator for the button to click

	        while (true) {
	            try {
	                // Check if the required month-year is visible
	                WebElement monthElement = driver.findElement(monthYearLocator);
	                if (monthElement.isDisplayed()) {
	                    System.out.println(targetMonthYear + " found!");
	                    break; // Exit the loop once the target is found
	                }
	            } catch (NoSuchElementException e) {
	                // If the target is not found, click the next button
	               clickOnElementUsingBy(nextButtonLocator) ;
	            }
	        }
	        
	        Thread.sleep(5000);
			WebElement findElement = driver
					.findElement(By.xpath("//android.view.View[@content-desc='" + Booking.daydatemonth + "']"));
			findElement.click();
			
			ClickonElement(workflow.getDoneButton());
			
			
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

	@Given("the admin navigates to Home tab")
	public void theAdminNavigatesToHomeTab() {
		ClickonElement(settings.gethometab());
	}
	
	@When("the admin navigates to the Pending tab")
	public void theAdminNavigatesToThePendingTab() {
		ClickonElement(workflow.getPending_Tab());
		System.out.println("kkkk");
	}

	
	@When("the admin selects the booking's service from the Service dropdown, opens the Date & Slot dropdown, and selects the booked date and slot")
	public void theAdminSelectsTheBookingSServiceFromTheServiceDropdownOpensTheDateSlotDropdownAndSelectsTheBookedDateAndSlot() throws Exception {
		System.out.println("ppppp");
		Assigned();
	}

	@When("the admin applies the toggle button")
	public void theAdminAppliesTheToggleButton() throws InterruptedException {
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
		} else {
			ClickonElement(workflow.getTickButton());
		}

	}

	@Given("the admin navigates to the Unassigned tab")
	public void theAdminNavigatesToTheUnassignedTab() {
		ClickonElement(workflow.getUnassigned_Tab()); // Click on Unassigned tab
	}

	@When("the admin selects the specific booking")
	public void theAdminSelectsTheSpecificBooking() throws Exception {
		ClickonElement(workflow.getStaffDropDown()); // Click on Staff filter
		Thread.sleep(2000);
//		waitForElement(workflow.getscrollview());
		Staff_for_assigned(); // Call Staff_for_assigned method

	}

	@When("the admin assigns the booking to a staff member")
	public void theAdminAssignsTheBookingToAStaffMember() throws InterruptedException {
		Thread.sleep(5000); // Wait for 2 seconds
		WebElement elements = driver.findElement(By.xpath(
				"//android.view.View[contains(@content-desc, 'unassigned_customer_name')]/android.widget.ImageView[3]"));
		elements.click();
//		ClickAllListElements(workflow.getImageviewCheckbox());
//		ClickonElement(workflow.getPartially_Assigned_Toggle());
		Thread.sleep(1500);
		ClickonElement(workflow.getAssign_Selected()); // Click on Assign Selected button

	}

	@Then("the booking should be assigned successfully")
	public void theBookingShouldBeAssignedSuccessfully() throws InterruptedException {
		Thread.sleep(6000);
		System.out.println("completed successfully ");

	}

}
