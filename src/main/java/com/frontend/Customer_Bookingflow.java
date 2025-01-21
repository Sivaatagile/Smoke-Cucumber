package com.frontend;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.WE.WE_Customer_BookingFlow;
import com.WE.WE_Customer_Settings;
import com.api.Api;
import com.api.Error;
import com.baseClass.Base;

import cucumberStepDefinition.Booking;

public class Customer_Bookingflow extends Base {
	public static String TotalAmountWithSymbol ;

	public static String BookingPaidAmount;
	public static String BookingPaymentTime;
	public static String Selected_Slot;
	public static String Booked_Date;
	public static String Booked_service;
	public static String BookingPaidAmountwithdecimal;
	public static LocalDate BookingDate;

	public static void booking() throws Exception {
		WE_Customer_BookingFlow booking = new WE_Customer_BookingFlow(driver);
		Api api = new Api(driver);
		Random random = new Random();
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
		Selected_Slot = booking.getseekbar().getAttribute("content-desc");
		System.out.println(Selected_Slot);
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
		BookingDate = getRandomDate(minAdvanceBookingDate, maxBookingDate);
		System.out.println(
				"Random date between " + minAdvanceBookingDate + " and " + maxBookingDate + ": " + BookingDate);
		long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
		System.out.println("Number of days between the two dates: " + daysBetween);
		String BookingMonth = getMonthName(BookingDate);
		int BookingYear = BookingDate.getYear();
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
			String formattedDateStr = BookingDate.format(formatter1);
			// Check if the date portion starts with "0" and remove it if so
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
			Booked_Date = parsedDate.format(outputFormat);
			System.out.println(Booked_Date);
			String day = Booked_Date.split(" ")[2].replace(",", "");
			System.out.println("Day: " + day);
		} else {
			System.out.println("There are less than 8 elements, cannot proceed.");
		}
		ClickonElement(booking.getRequestBooking());
		Thread.sleep(2000);
		Booked_service = booking.getserviceName().getAttribute("content-desc");
		System.out.println("ssssss    :  " + Booked_service);
		ClickonElement(booking.getproceed());
		ClickonElement(booking.getCheckBox());
		ClickonElement(booking.getConfirmANDPay());

	}

	public static void BookingSuccessfullPage() throws InterruptedException {
		WE_Customer_BookingFlow booking = new WE_Customer_BookingFlow(driver);
		waitForElement(booking.getSuccessfullpageNavigation());
		Thread.sleep(1000);
		BookingPaidAmount = booking.getSucessfullpage_Amount().getAttribute("content-desc");
		System.out.println(BookingPaidAmount);
		String amountStr = BookingPaidAmount.replace("£", "").trim();
		// Convert the string to a double and format to two decimal places
		double amount = Double.parseDouble(amountStr);
		BookingPaidAmountwithdecimal = String.format("%.2f", amount);
		System.out.println("Formatted Amount: " + BookingPaidAmountwithdecimal);
		BookingPaymentTime = booking.getSucessfullpage_PaymentTime().getAttribute("content-desc");
		System.out.println(BookingPaymentTime);
		ClickonElement(booking.getSucessfullpage_Newbooking());

	}

	public static void screenshot(String ScreenshotName) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// Generate a timestamp to create a unique filename
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			// Define destination file path with the timestamp
			String destPath = "C:\\Users\\ACS\\eclipse-workspace\\Zzz_Booking\\Screenshot\\Android\\" + ScreenshotName
					+ "_" + timestamp + ".png";
			// Copy the file to the destination
			Files.copy(srcFile.toPath(), Paths.get(destPath));
			System.out.println("Screenshot saved to: " + destPath);
			System.out.println("Screenshot completed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void SingleDateBooking(LocalDate ttttt) throws Exception {
		WE_Customer_BookingFlow booking = new WE_Customer_BookingFlow(driver);
		Api api = new Api(driver);
		Random random = new Random();
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
		Selected_Slot = booking.getseekbar().getAttribute("content-desc");
		System.out.println(Selected_Slot);
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
		
		
		
		CheckTheDateWithinRange(minAdvanceBookingDate, maxBookingDate, ttttt );
		
		if (range) {
			System.out.println(
					"Random date between " + minAdvanceBookingDate + " and " + maxBookingDate + ": " + ttttt);
			String BookingMonth = getMonthName(ttttt);
			int BookingYear = ttttt.getYear();
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
		}else {
			System.out.println("Note in range ");
		}
		
		

		Thread.sleep(4000);
		List<WebElement> calendarElements = driver.findElements(By.xpath(
				"//android.view.View[@content-desc=\"booking_page_calenderWidget\"]/android.view.View/android.view.View/android.view.View/android.view.View"));
		int size = calendarElements.size();
		if (size > 7) {
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
			String formattedDateStr = ttttt.format(formatter1);
			// Check if the date portion starts with "0" and remove it if so
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
			Booked_Date = parsedDate.format(outputFormat);
			System.out.println(Booked_Date);
			String day = Booked_Date.split(" ")[2].replace(",", "");
			System.out.println("Day: " + day);
		} else {
			System.out.println("There are less than 8 elements, cannot proceed.");
		}
		ClickonElement(booking.getRequestBooking());
		Thread.sleep(2000);
		Booked_service = booking.getserviceName().getAttribute("content-desc");
		System.out.println("ssssss    :  " + Booked_service);
		ClickonElement(booking.getproceed());
		ClickonElement(booking.getCheckBox());
		ClickonElement(booking.getConfirmANDPay());

	}
	
	
	
	
	
	
	public static  void TwoPetBooking() throws Exception {

		WE_Customer_BookingFlow booking = new WE_Customer_BookingFlow(driver);
		Api api = new Api(driver);
		Random random = new Random();
		Thread.sleep(10000);
		 waitForElement(booking.getassorted());
		 Thread.sleep(1000);
		if (booking.getpetcount().size() == 3) {
            System.out.println("Two pets");
            ClickonElement(booking.getpetcount().get(0));
         
        } else if (booking.getpetcount().size() == 1) {
          System.out.println("one pet");
        } else {
            System.out.println("null.");
        }
		
		
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
		Selected_Slot = booking.getseekbar().getAttribute("content-desc");
		System.out.println(Selected_Slot);
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
		BookingDate = getRandomDate(minAdvanceBookingDate, maxBookingDate);
		System.out.println(
				"Random date between " + minAdvanceBookingDate + " and " + maxBookingDate + ": " + BookingDate);
		long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
		System.out.println("Number of days between the two dates: " + daysBetween);
		String BookingMonth = getMonthName(BookingDate);
		int BookingYear = BookingDate.getYear();
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
			String formattedDateStr = BookingDate.format(formatter1);
			// Check if the date portion starts with "0" and remove it if so
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
			Booked_Date = parsedDate.format(outputFormat);
			System.out.println(Booked_Date);
			String day = Booked_Date.split(" ")[2].replace(",", "");
			System.out.println("Day: " + day);
		} else {
			System.out.println("There are less than 8 elements, cannot proceed.");
		}
		ClickonElement(booking.getRequestBooking());
		Thread.sleep(2000);
		Booked_service = booking.getserviceName().getAttribute("content-desc");
		System.out.println("ssssss    :  " + Booked_service);
		ClickonElement(booking.getproceed());
		ClickonElement(booking.getCheckBox());
		ClickonElement(booking.getConfirmANDPay());
		
	}
	
	
	
	public static  void Accounts() throws InterruptedException {

		WE_Customer_Settings statement = new WE_Customer_Settings(driver);
		ClickonElement(statement.getSettingsTab());
		ClickonElement(statement.getAccounts());
		Thread.sleep(10000);
		if (Booking.Stripe) {
			
//			By sales = By.xpath("//android.view.View[@content-desc=\"Payment\"]/following-sibling::android.view.View[@content-desc="+"-"+"'"+Booking.TotalAmountWithSymbol+"']");
//			System.out.println(sales);
//			By payment = By.xpath("//android.view.View[@content-desc=\"Payment\"]/following-sibling::android.view.View[@content-desc='"+Booking.TotalAmountWithSymbol+"']");
//			System.out.println(payment);
		}
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	

}
