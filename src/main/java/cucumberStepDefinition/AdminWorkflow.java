package cucumberStepDefinition;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	static WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
	static WE_Admin_Settings settings = new WE_Admin_Settings(driver);
	
	public static void Assigned() throws Exception {
		ClickonElement(settings.gethometab());
		Thread.sleep(10000);
		ClickonElement(workflow.getService());
		boolean isElementFound = false;
		while (!isElementFound) {
			try {
				workflow.getBookedServiceLocator();
				if (workflow.getBookedServiceLocator() != null) {
					ClickonElement(workflow.getBookedServiceLocator());
					Thread.sleep(2000);
					isElementFound = true;
				}
			} catch (Exception e) {
				slowScroll();
			}
		}
		ClickonElement(workflow.getAllslots());
		Thread.sleep(8000);
		System.out.println(workflow.getBookedSlotLocator());
		scrollUntilElementFound(workflow.getSlot(), workflow.getBookedSlotLocator());
		Thread.sleep(5000);
		ClickonElement(workflow.getSelect());
		ClickonElement(workflow.getdatefilter());
		SimpleDateFormat inputFormat = new SimpleDateFormat("MMM dd, yyyy");
		SimpleDateFormat outputFormat = new SimpleDateFormat("MMM yyyy");
		Thread.sleep(5000);
		Date date = inputFormat.parse(Booking.Booked_Date);
		String formattedDate = outputFormat.format(date);
		System.out.println("Converted Date: " + formattedDate);
		Thread.sleep(5000);
		By monthYearLocator = By.xpath("//android.view.View[@content-desc='" + formattedDate + "']");
		System.out.println(monthYearLocator);
		By nextButtonLocator = By.xpath("(//android.widget.Button)[2]"); // Locator for the button to click
		System.out.println(nextButtonLocator);
		List<WebElement> elements = driver.findElements(By.xpath("//android.widget.Button"));
		int size = elements.size();
		System.out.println(size);
		Thread.sleep(5000);
		while (true) {
			try {
				Thread.sleep(5000);
				WebElement monthElement = driver.findElement(monthYearLocator);
				if (monthElement.isDisplayed()) {
					System.out.println("Step 1");
					break;
				}
			}
			catch (NoSuchElementException e) {
				if (size == 3) {
					ClickonElement(elements.get(0));
					System.out.println("Step 2");
					while (true) {
						try {
							WebElement monthElement1 = driver.findElement(monthYearLocator);
							if (monthElement1.isDisplayed()) {
								System.out.println("Step 3");
								break; 
							}
						} catch (NoSuchElementException e1) {
							List<WebElement> elements11 = driver.findElements(By.xpath("//android.widget.Button"));
							int size1 = elements11.size();
							ClickonElement(elements11.get(1));
							System.out.println("Step 4");
						}
					}
					break;
				} 
				else if (size == 4) {
					while (true) {
						try {
							WebElement monthElement2 = driver.findElement(monthYearLocator);
							if (monthElement2.isDisplayed()) {
								System.out.println("Step 5");
								break; 
							}
						} catch (NoSuchElementException e2) {
							System.out.println("Step 6");
							ClickonElement(elements.get(1));
						}
					}
					break;
				}
			}
		}
		Thread.sleep(5000);
		WebElement findElement = driver
				.findElement(By.xpath("//android.view.View[@content-desc='" + Booking.daydatemonth + "']"));
		findElement.click();
		ClickonElement(workflow.getDoneButton());
	}
	        
	public static void Staff_for_assigned() throws Exception {
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver); 
		boolean isElementFound = false; 
		while (!isElementFound) { 
			try {
				workflow.getstafflocator(); 
				if (workflow.getstafflocator() != null) { 
					ClickonElement(workflow.getstafflocator()); 
					isElementFound = true; 
				}
			} 
			catch (Exception e) {
				scrollEachElement(workflow.getscrollview()); 
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
		System.out.println("pending tab");
	}

	@When("the admin selects the booking's service from the Service dropdown, opens the Date & Slot dropdown, and selects the booked date and slot")
	public void theAdminSelectsTheBookingSServiceFromTheServiceDropdownOpensTheDateSlotDropdownAndSelectsTheBookedDateAndSlot() throws Exception {
		System.out.println("wait for assigned");
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
	
	@Then("the booking should move to the Rejected tab")
	public void theBookingShouldMoveToTheRejectedTab() throws InterruptedException {
		Thread.sleep(5000);
		if (isElementAvailable(workflow.NoBookingYet)) {
			System.out.println("No booking is listed on pending. Navigate to unassigned tab and check");
		} else {
			ClickonElement(workflow.getRejectButton());
			Thread.sleep(2000);
			ClickonElement(workflow.getReject());
			Thread.sleep(7500);
		}
	}

	@Given("the admin navigates to the Unassigned tab")
	public void theAdminNavigatesToTheUnassignedTab() {
		ClickonElement(workflow.getUnassigned_Tab()); 
	}

	@When("the admin selects the specific booking")
	public void theAdminSelectsTheSpecificBooking() throws Exception {
		ClickonElement(workflow.getStaffDropDown()); 
		Thread.sleep(2000);
		Staff_for_assigned(); 
	}

	@When("the admin assigns the booking to a staff member")
	public void theAdminAssignsTheBookingToAStaffMember() throws InterruptedException {
		Thread.sleep(5000); 
		WebElement elements = driver.findElement(By.xpath(
				"//android.view.View[contains(@content-desc, 'unassigned_customer_name')]/android.widget.ImageView[3]"));
		elements.click();
		Thread.sleep(1500);
		ClickonElement(workflow.getAssign_Selected()); // Click on Assign Selected button
	}

	@Then("the booking should be assigned successfully")
	public void theBookingShouldBeAssignedSuccessfully() throws InterruptedException {
		Thread.sleep(6000);
		System.out.println("completed successfully ");
	}

}
