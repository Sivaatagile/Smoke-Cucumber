package com.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.WE.WE_Admin_WorkFlow;
import com.baseClass.Base;

public class Admin_Workflow extends Base{

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
		dateFormatForWorkflow(Customer_Bookingflow.Booked_Date);
		ClickonElement(workflow.getDate_Slot()); // Click on date filter
		scrollUntilElementFound(workflow.getDate(), workflow.getBookedDateLocator()); // Scroll to find booked date
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
	
	
	public static void Pending_to_UnAssigned() throws Exception {
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver); // Create Admin_approval object
		Assigned(); // Call Assigned method
		ClickonElement(workflow.getAddon_Toggle()); // Click on Add-on toggle button
		Thread.sleep(2000); // Wait for 2 seconds
		ClickonElement(workflow.getAddon_Toggle()); // Click on Add-on toggle button again
		ClickonElement(workflow.getBookingTime_Toggle()); // Click on BookingTime toggle button
	    Thread.sleep(5000);
	    if (isElementAvailable(workflow.NoBookingYet)) {
			System.out.println("No booking is listed on pending. Navigate to unassigned tab and check");
		}else {
			ClickonElement(workflow.getTickButton());
		}
	    
		
	}
	
	public static void UnAssigned_to_Assigned() throws Exception {
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		ClickonElement(workflow.getUnassigned_Tab()); // Click on Unassigned tab
		Assigned(); // Call Assigned method
		ClickonElement(workflow.getStaffDropDown()); // Click on Staff filter
		waitForElement(workflow.getscrollview());
		Staff_for_assigned(); // Call Staff_for_assigned method
		Thread.sleep(5000); // Wait for 2 seconds
		WebElement elements = driver.findElement(By.xpath("//android.view.View[contains(@content-desc, 'unassigned_customer_name')]/android.widget.ImageView[3]"));
		elements.click();
		// List oda size-a eduthutu iterate pannaum
	
//		ClickAllListElements(workflow.getImageviewCheckbox());
//		ClickonElement(workflow.getPartially_Assigned_Toggle());
		Thread.sleep(1500);
		ClickonElement(workflow.getAssign_Selected()); // Click on Assign Selected button
		
	}
	
}
