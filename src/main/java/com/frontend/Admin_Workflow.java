package com.frontend;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.WE.WE_ADMIN_BOOKING;
import com.WE.WE_Admin_Settings;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Customer_BookingFlow;
import com.api.Api;
import com.baseClass.Base;

import cucumberStepDefinition.Booking;

public class Admin_Workflow extends Base {



	public static void Assigned() throws Exception {
		WE_Admin_Settings settings = new WE_Admin_Settings(driver);

		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver); // Create Admin_approval object
		ClickonElement(settings.gethometab());
		Thread.sleep(8000);
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
//		scrollToExactValue(workflow.getDate(),"Wed Jun 25");
//		By by = workflow.getBookedDateLocator();
//		System.out.println("yvcyswc   " + by);
//
//		scrollUntil(workflow.getDate(), workflow.getBookedDateLocator()); // Scroll to find booked date
//		By by1 = workflow.getBookedSlotLocator();
//		System.out.println("yvcyswc   " + by1);
		Thread.sleep(8000);
		System.out.println(workflow.getBookedSlotLocator());
		scrollUntilElementFound(workflow.getSlot(), workflow.getBookedSlotLocator()); // Scroll to find booked slot

		Thread.sleep(5000);
		ClickonElement(workflow.getSelect()); // Click on select button

		ClickonElement(workflow.getdatefilter());
        SimpleDateFormat inputFormat = new SimpleDateFormat("MMM dd, yyyy");

		   SimpleDateFormat outputFormat = new SimpleDateFormat("MMM yyyy");
		   Thread.sleep(5000);
	        // Convert the date
	        Date date = inputFormat.parse(Booking.Booked_Date);
	        String formattedDate = outputFormat.format(date);

	        // Print the result
	        System.out.println("Converted Date: " + formattedDate);
//	        
	        Thread.sleep(5000);
//	        String targetMonthYear = "Jul 2025"; // The required month and year
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

		// Check if the required month-year is visible
		WebElement monthElement = driver.findElement(monthYearLocator);
		if (monthElement.isDisplayed()) {
			System.out.println("1");
//	                    System.out.println(targetMonthYear + " found!");
			break; // Exit the loop once the target is found
		}
		
	}

	catch (NoSuchElementException e) {
		
		
		  if (size == 3) {
				ClickonElement(elements.get(0));
				System.out.println("144g");

				while (true) {
					try {
						WebElement monthElement1 = driver.findElement(monthYearLocator);
						if (monthElement1.isDisplayed()) {
							System.out.println("144gdvdvdv");

//							                    System.out.println(targetMonthYear + " found!");
							break; // Exit the loop once the target is found
						}
					} catch (NoSuchElementException e1) {
						 List<WebElement> elements11 = driver.findElements(By.xpath("//android.widget.Button"));
						 int size1 = elements11.size();
						ClickonElement(elements11.get(1));
						System.out.println("144gdvdvhfhfhfhdv");

					}
				}
			break;}
		  else if (size==4) {
				while (true) {
					try {
						WebElement monthElement2 = driver.findElement(monthYearLocator);
						if (monthElement2.isDisplayed()) {
							System.out.println("144gdvdvhfhfhfhdvhhhhhhhhhhhhhh");

//							                    System.out.println(targetMonthYear + " found!");
							break; // Exit the loop once the target is found
						}
					} catch (NoSuchElementException e2) {
						System.out.println("144gdvdvhfhfhfhdvhhhhhhhhhhhhhhfffffffffffff");

						ClickonElement(elements.get(1));
					}
			}
			
				break;}
		
		
		
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
		} else {
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
		WebElement elements = driver.findElement(By.xpath(
				"//android.view.View[contains(@content-desc, 'unassigned_customer_name')]/android.widget.ImageView[3]"));
		elements.click();
		Thread.sleep(1500);
		ClickonElement(workflow.getAssign_Selected()); // Click on Assign Selected button
        Thread.sleep(5000);
	}
	
	public static  void Assigned_TO_Reassigned() throws Exception {

		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver); // Create Admin_approval object
		ClickonElement(workflow.getAssigned_Tab()); // Click on Unassigned tab
		Assigned(); 
		if (isElementAvailable(workflow.StaffLocator)&& isElementAvailable(workflow.ServiceLocator)) {
			ClickonElement(workflow.getCheckBoxAssigned());
			ClickonElement(workflow.getReassignSelected());
			if (isElementAvailable(workflow.SecondStaffLocator)) {
				clickOnElementUsingBy(workflow.SecondStaffLocator);
			}else {
                slowscrolluntilelementfound(workflow.SecondStaffLocator);
				clickOnElementUsingBy(workflow.SecondStaffLocator);
			}
		}
		
	}

	public static void Booking_For_Customer_As_Admin() throws Exception {

		WE_ADMIN_BOOKING home = new WE_ADMIN_BOOKING(driver);
		WE_Customer_BookingFlow booking = new WE_Customer_BookingFlow(driver);
		Api api = new Api(driver);
		Random random = new Random();

		ClickonElement(home.getPlus());
		Thread.sleep(6000);
		scrollUntilElementFound(home.getscrollview(), home.Customer_Locator);
		clickOnElementUsingBy(home.Customer_Locator);
		Thread.sleep(7000);
		if (isElementAvailable(booking.getServiceShowAll())) {
			ClickonElement(booking.getServiceShowAll());
			ClickonElement(booking.getSearchServices());
			Thread.sleep(1000);
			passInput(booking.getSearchServices(), getProperty("SERVICE_NAME"));
			driver.hideKeyboard();
			ClickonElement(booking.getSelectService());
		} else if (isElementAvailable(booking.ServiceViewable)) {
			Thread.sleep(2000);
			clickOnElementUsingBy(booking.ServiceViewable);
		} else {
			System.out.println("Service is not available");
		}

		int SlotCount = api.timeSlotsCount;
		System.out.println("slot  :  " + SlotCount);
		int randomValue = random.nextInt(SlotCount);
		System.out.println("Random value: " + randomValue);
		Thread.sleep(4000);
		for (int i = 1; i < randomValue; i++) {
			scroll(booking.getseekbar());
			System.out.println(i);
			Thread.sleep(500); // waits for 500ms
		}
		Thread.sleep(2500);
		Selected_Slot_as_ADMIN = booking.getseekbar().getAttribute("content-desc");
		System.out.println(Selected_Slot_as_ADMIN);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate startDate = LocalDate.parse(api.available_date_from, formatter);
		LocalDate endDate = LocalDate.parse(api.available_date_to, formatter);
		long daysBetweenSpecificDates = ChronoUnit.DAYS.between(startDate, endDate);
		System.out.println("Number of days between " + startDate + " and " + endDate + ": " + daysBetweenSpecificDates);
		LocalDate currentDate = LocalDate.now();
		long daysFromCurrentToEndDate = ChronoUnit.DAYS.between(currentDate, endDate);
		System.out.println("Number of days from the current date (" + currentDate + ") to the end date (" + endDate
				+ "): " + daysFromCurrentToEndDate);
		LocalDate minAdvanceBookingDate = getMinAdvanceBookingDate(currentDate, api.DAYminAdvanceBooking);
		LocalDate maxBookingDate = getMaxBookingDate(currentDate, endDate, api.DAYminAdvanceBooking,
				api.DAYmaxAdvanceBooking);
		System.out.println("Minimum Advance Booking Date: " + minAdvanceBookingDate);
		System.out.println("Booking can be made up to: " + maxBookingDate);
		String minMonthName = getMonthName(minAdvanceBookingDate);
		String maxMonthName = getMonthName(maxBookingDate);
		System.out.println("Month of minimum advance booking date: " + minMonthName);
		System.out.println("Month of maximum booking date: " + maxMonthName);
		BookingDate_as_ADMIN = getRandomDate(minAdvanceBookingDate, maxBookingDate);
		System.out.println("Random date between " + minAdvanceBookingDate + " and " + maxBookingDate + ": "
				+ BookingDate_as_ADMIN);
		long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
		System.out.println("Number of days between the two dates: " + daysBetween);
		String BookingMonth = getMonthName(BookingDate_as_ADMIN);
		int BookingYear = BookingDate_as_ADMIN.getYear();
		String BookingMonthProperCase = BookingMonth.substring(0, 1) + BookingMonth.substring(1).toLowerCase();
		Thread.sleep(3000);
		String dynamicLocator = "//android.view.View[@content-desc='" + BookingMonthProperCase + " " + BookingYear
				+ "']";
		System.out.println("gfyft     " + dynamicLocator);
		Thread.sleep(3000);
		String fallbackLocatorFirstTime = "//android.view.View[@content-desc='booking_page_calenderWidget']/android.view.View[2]";
		String fallbackLocatorSubsequentTimes = "//android.view.View[@content-desc='booking_page_calenderWidget']/android.view.View[3]";
		boolean isFirstTime = true;
		boolean isElementFound = false;
		while (!isElementFound) {
			try {
				WebElement element = driver.findElement(By.xpath(dynamicLocator));
				element.click();
				isElementFound = true;
				System.out.println("Dynamic element found and clicked.");
			} catch (NoSuchElementException e) {
				String fallbackLocator;
				if (isFirstTime) {
					fallbackLocator = fallbackLocatorFirstTime;
					isFirstTime = false; // Mark first time as done
				} else {
					fallbackLocator = fallbackLocatorSubsequentTimes;
				}
				try {
					WebElement fallbackElement = driver.findElement(By.xpath(fallbackLocator));
					fallbackElement.click();
					System.out.println("Fallback element clicked (" + fallbackLocator + "), retrying...");
				} catch (NoSuchElementException fallbackException) {
					System.out.println("Fallback element not found, stopping.");
					break;
				}
			}
		}
		Thread.sleep(4000);
		List<WebElement> calendarElements = driver.findElements(By.xpath(
				"//android.view.View[@content-desc=\"booking_page_calenderWidget\"]/android.view.View/android.view.View/android.view.View/android.view.View"));
		int size = calendarElements.size();
		if (size > 7) {
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
			String formattedDateStr = BookingDate_as_ADMIN.format(formatter1);
			if (formattedDateStr.charAt(formattedDateStr.indexOf(",") + 6) == '0') {
				formattedDateStr = formattedDateStr.replaceFirst(" 0", " ");
			}
			System.out.println("Formatted Date: " + formattedDateStr);
			Thread.sleep(5000);
			WebElement findElement = driver
					.findElement(By.xpath("//android.view.View[@content-desc='" + formattedDateStr + "']"));
			findElement.click();
			Thread.sleep(1000);
			String Booked_Date123 = findElement.getAttribute("content-desc");
			System.out.println(Booked_Date123);
			DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
			DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("MMM dd, yyyy");
			LocalDate parsedDate = LocalDate.parse(Booked_Date123, inputFormat);
			Booked_Date_as_ADMIN = parsedDate.format(outputFormat);
			System.out.println(Booked_Date_as_ADMIN);
			String day = Booked_Date_as_ADMIN.split(" ")[2].replace(",", "");
			System.out.println("Day: " + day);
		} else {
			System.out.println("There are less than 8 elements, cannot proceed.");
		}
		ClickonElement(home.getCheckAvailability());
		Thread.sleep(2000);
		Booked_Date_as_ADMIN = booking.getserviceName().getAttribute("content-desc");
		System.out.println("ssssss    :  " + Booked_Date_as_ADMIN);
		ClickonElement(booking.getproceed());
		Thread.sleep(2000);
		ClickonElement(booking.getCheckBox());
		ClickonElement(booking.getConfirmANDPay());
		Thread.sleep(2000);
		if (isElementAvailable(home.alert_message)) {
			ClickonElement(home.getYesButton());
		}
		Thread.sleep(4000);
		ClickonElement(home.getDone());
	}

}
