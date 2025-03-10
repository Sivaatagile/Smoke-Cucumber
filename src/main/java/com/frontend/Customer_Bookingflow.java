package com.frontend;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.velocity.runtime.directive.Break;
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

	public static void Crezco_Payment() throws InterruptedException {
		WE_Customer_BookingFlow booking = new WE_Customer_BookingFlow(driver);// Create Stripe object
		ClickonElement(booking.getCrezcoContinue());
		Thread.sleep(2000);
		ClickonElement(booking.getCrezcoSandbox());
		Thread.sleep(2000);
		ClickonElement(booking.getCrezcoSubmit());

	}

	public static void Stripe_Payment() throws InterruptedException {
		WE_Customer_BookingFlow booking = new WE_Customer_BookingFlow(driver);// Create Stripe object
		ClickonElement(booking.getEmail()); // Click on the Gmail input field
		passInput(booking.getEmail(), getProperty("StripeEmail")); // Enter the Gmail address
		ClickonElement(booking.getCardNumber()); // Click on the card number input field
		passInput(booking.getCardNumber(), getProperty("StripeCard")); // Enter the card number
		ClickonElement(booking.getCardExpiry()); // Click on the card expiry input field
		passInput(booking.getCardExpiry(), getProperty("StripeCardExpiry")); // Enter the card expiry date
		ClickonElement(booking.getCVV()); // Click on the CVV input field
		passInput(booking.getCVV(), getProperty("StripeCVV")); // Enter the CVV code
		ClickonElement(booking.getBillingName()); // Click on the billing name input field
		passInput(booking.getBillingName(), getProperty("StripeName")); // Enter the billing name
		driver.hideKeyboard(); // Navigate back
		Thread.sleep(2000);
		ClickonElement(booking.getCompleteOrder()); // Click on the 'Pay' button
	}

	public static void Stripe_Payment1() throws InterruptedException {
		WE_Customer_BookingFlow booking = new WE_Customer_BookingFlow(driver);// Create Stripe object
		ClickonElement(booking.getEmail()); // Click on the Gmail input field
		passInput(booking.getEmail(), getProperty("StripeEmail")); // Enter the Gmail address
		driver.hideKeyboard();
		Thread.sleep(2000);
		ClickonElement(booking.getCompleteOrder());
	}

	public static void booking() throws Exception {
		WE_Customer_BookingFlow booking = new WE_Customer_BookingFlow(driver);
		Api api = new Api(driver);
		WE_Customer_Settings mybookings = new WE_Customer_Settings(driver);
		waitForElement(booking.getassorted());
		Thread.sleep(3000);
		ClickonElement(mybookings.getSettingsTab());
		Thread.sleep(1000);
		ClickonElement(mybookings.getHomeTab());
		Thread.sleep(3000);
		waitForElement(booking.getassorted());
		System.out.println("nice");
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
		startDate = LocalDate.parse(api.available_date_from, formatter);
		endDate = LocalDate.parse(api.available_date_to, formatter);
		long daysBetweenSpecificDates = ChronoUnit.DAYS.between(startDate, endDate);
		System.out.println("Number of days between " + startDate + " and " + endDate + ": " + daysBetweenSpecificDates);
		LocalDate currentDate = LocalDate.now();
		long daysFromCurrentToEndDate = ChronoUnit.DAYS.between(currentDate, endDate);
		System.out.println("Number of days from the current date (" + currentDate + ") to the end date (" + endDate
				+ "): " + daysFromCurrentToEndDate);
		minAdvanceBookingDate = getMinAdvanceBookingDate(currentDate, api.DAYminAdvanceBooking);
		maxBookingDate = getMaxBookingDate(currentDate, endDate, api.DAYminAdvanceBooking, api.DAYmaxAdvanceBooking);
		System.out.println("Minimum Advance Booking Date: " + minAdvanceBookingDate);
		System.out.println("Booking can be made up to: " + maxBookingDate);

		String minMonthName = getMonthName(minAdvanceBookingDate);
		String maxMonthName = getMonthName(maxBookingDate);
		System.out.println("Month of minimum advance booking date: " + minMonthName);
		System.out.println("Month of maximum booking date: " + maxMonthName);
		System.out.println("Month of minimum advance booking date: " + minMonthName);
		System.out.println("Month of maximum booking date: " + maxMonthName);
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String minimumDate = minAdvanceBookingDate.format(formatter1);
		String maximumDate = maxBookingDate.format(formatter1);
		api.getserviceID(getProperty("SERVICE_NAME"));
		api.getslotID(Selected_Slot);
		api.getcustomerID(getProperty("SIGNUP_EMAIL"));
		api.NotAvailableDates(api.serviceId, api.slotId, api.CustomerId, minimumDate, maximumDate);
		List<LocalDate> remainingDates = api.getRemainingDates(api.notAvailableDates, minAdvanceBookingDate,maxBookingDate);
		Collections.shuffle(remainingDates);
		BookingDate = remainingDates.get(0);

//		BookingDate = getRandomDate(minAdvanceBookingDate, maxBookingDate);
//		System.out.println(
//				"Random date between " + minAdvanceBookingDate + " and " + maxBookingDate + ": " + BookingDate);
//		long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
//		System.out.println("Number of days between the two dates: " + daysBetween);

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
			DateTimeFormatter formatter11 = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
			String formattedDateStr = BookingDate.format(formatter11);
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
		Thread.sleep(5000);
		waitForElement(booking.getReviewBooking());
		System.out.println("review booking page");
		Thread.sleep(2000);
		String totalAmountText = booking.getTotal_Amount().getAttribute("content-desc");
		TotalAmountWithSymbol = totalAmountText;
		System.out.println("kkk    :--------------------------------         " + TotalAmountWithSymbol);
		String remainingCreditText = booking.getRemaining_Credit().getAttribute("content-desc");
		System.out.println("Total Amount is: " + totalAmountText);
		System.out.println("Remaining Credit is: " + remainingCreditText);
		// Remove the currency symbol and parse the values to double
		double totalAmount = Double.parseDouble(totalAmountText.replace("£", "").trim());
		double remainingCredit = Double.parseDouble(remainingCreditText.replace("£", "").trim());
		// Compare the values
		if (totalAmount > remainingCredit) {
			System.out.println("Total amount is greater than remaining credit. Navigating to payment page...");
			// Click on checkbox and ConfirmANDPay to go to the next page
			ClickonElement(booking.getCheckBox());
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ACS\\eclipse-workspace\\Smoke-Cucumber\\ChromeDriver\\chromedriver.exe");
			ClickonElement(booking.getConfirmANDPay());
			Thread.sleep(10000);
			if (isElementAvailable(booking.getStripeBack())) {
				// Run the appropriate Stripe payment function based on totalAmount value
				if (totalAmount == 0.00) {
					Stripe = true;
					waitForElement(booking.getStripeBack());
					Set<String> hand = driver.getContextHandles(); // Get context handles
					System.out.println("Get Handles  : " + hand); // Print context handles
					String webcontext = new ArrayList<String>(hand).get(1); // Get web context
					System.out.println("WebView  : " + webcontext);
					Thread.sleep(2000);
					driver.context(webcontext);
					Thread.sleep(10000);
					Stripe_Payment1();
					String nativecontext = new ArrayList<String>(hand).get(0); // Get web context
					System.out.println("native  : " + nativecontext);
					driver.context(nativecontext);
				} else {
					Stripe = true;
					waitForElement(booking.getStripeBack());
					Set<String> hand = driver.getContextHandles(); // Get context handles
					System.out.println("Get Handles  : " + hand); // Print context handles
					String webcontext = new ArrayList<String>(hand).get(1); // Get web context
					System.out.println("WebView  : " + webcontext);
					Thread.sleep(2000);
					driver.context(webcontext);
					Thread.sleep(10000);
					Stripe_Payment();
					String nativecontext = new ArrayList<String>(hand).get(0); // Get web context
					System.out.println("native  : " + nativecontext);
					driver.context(nativecontext);
				}
			} else if (isElementAvailable(booking.getCrezcoPayment())) {
				Crezco = true;
				System.out.println("Crezco payment ");
				Set<String> hand = driver.getContextHandles(); // Get context handles
				System.out.println("Get Handles  : " + hand); // Print context handles
				String webcontext = new ArrayList<String>(hand).get(1); // Get web context
				System.out.println("WebView  : " + webcontext);
				Thread.sleep(2000);
				driver.context(webcontext);
				Thread.sleep(6000);
				Crezco_Payment();
			}
		} else {
			Stripe = false;
			Crezco = false;
			ClickonElement(booking.getCheckBox());
			ClickonElement(booking.getConfirmANDPay());
			System.out.println("Total amount is less than or equal to remaining credit. No payment required.");
		}
		System.out.println("Check the total amount and remaining credit amount  ");
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
		CheckTheDateWithinRange(minAdvanceBookingDate, maxBookingDate, ttttt);
		if (range) {
			System.out
					.println("Random date between " + minAdvanceBookingDate + " and " + maxBookingDate + ": " + ttttt);
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
		} else {
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

	public static void TwoPetBooking() throws Exception {
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
		startDate = LocalDate.parse(api.available_date_from, formatter);
		endDate = LocalDate.parse(api.available_date_to, formatter);
		long daysBetweenSpecificDates = ChronoUnit.DAYS.between(startDate, endDate);
		System.out.println("Number of days between " + startDate + " and " + endDate + ": " + daysBetweenSpecificDates);
		LocalDate currentDate = LocalDate.now();
		long daysFromCurrentToEndDate = ChronoUnit.DAYS.between(currentDate, endDate);
		System.out.println("Number of days from the current date (" + currentDate + ") to the end date (" + endDate
				+ "): " + daysFromCurrentToEndDate);
		minAdvanceBookingDate = getMinAdvanceBookingDate(currentDate, api.DAYminAdvanceBooking);
		maxBookingDate = getMaxBookingDate(currentDate, endDate, api.DAYminAdvanceBooking, api.DAYmaxAdvanceBooking);
		System.out.println("Minimum Advance Booking Date: " + minAdvanceBookingDate);
		System.out.println("Booking can be made up to: " + maxBookingDate);
		String minMonthName = getMonthName(minAdvanceBookingDate);
		String maxMonthName = getMonthName(maxBookingDate);
		System.out.println("Month of minimum advance booking date: " + minMonthName);
		System.out.println("Month of maximum booking date: " + maxMonthName);
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String minimumDate = minAdvanceBookingDate.format(formatter1);
		String maximumDate = maxBookingDate.format(formatter1);

//		BookingDate = getRandomDate(minAdvanceBookingDate, maxBookingDate);
//		System.out.println(
//				"Random date between " + minAdvanceBookingDate + " and " + maxBookingDate + ": " + BookingDate);
//		long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
//		System.out.println("Number of days between the two dates: " + daysBetween);

		api.getserviceID(getProperty("SERVICE_NAME"));
		api.getslotID(Selected_Slot);
		api.getcustomerID(getProperty("SIGNUP_EMAIL"));
		api.NotAvailableDates(api.serviceId, api.slotId, api.CustomerId, minimumDate, maximumDate);
		List<LocalDate> remainingDates = api.getRemainingDates(api.notAvailableDates, minAdvanceBookingDate,
				maxBookingDate);
		Collections.shuffle(remainingDates);
		BookingDate = remainingDates.get(0);

		String BookingMonth = getMonthName(BookingDate);
		BookingYear = BookingDate.getYear();
		BookingMonthProperCase = BookingMonth.substring(0, 1) + BookingMonth.substring(1).toLowerCase();
		Thread.sleep(3000);

		String monthyear = BookingMonthProperCase + " " + BookingYear;
		System.out.println("eggdgd   : " + monthyear);

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
			DateTimeFormatter formatter111 = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
			String formattedDateStr = BookingDate.format(formatter111);
			System.out.println("fdrrdrdrdrdr    " + formattedDateStr);
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
		Thread.sleep(5000);
		waitForElement(booking.getReviewBooking());
		System.out.println("review booking page");
		Thread.sleep(2000);
		String totalAmountText = booking.getTotal_Amount().getAttribute("content-desc");
		TotalAmountWithSymbol = totalAmountText;
		System.out.println("kkk    :--------------------------------         " + TotalAmountWithSymbol);
		String remainingCreditText = booking.getRemaining_Credit().getAttribute("content-desc");
		System.out.println("Total Amount is: " + totalAmountText);
		System.out.println("Remaining Credit is: " + remainingCreditText);
		// Remove the currency symbol and parse the values to double
		double totalAmount = Double.parseDouble(totalAmountText.replace("£", "").trim());
		double remainingCredit = Double.parseDouble(remainingCreditText.replace("£", "").trim());
		// Compare the values
		if (totalAmount > remainingCredit) {
			System.out.println("Total amount is greater than remaining credit. Navigating to payment page...");
			// Click on checkbox and ConfirmANDPay to go to the next page
			ClickonElement(booking.getCheckBox());
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ACS\\eclipse-workspace\\Smoke-Cucumber\\ChromeDriver\\chromedriver.exe");
			ClickonElement(booking.getConfirmANDPay());
			Thread.sleep(10000);
			if (isElementAvailable(booking.getStripeBack())) {
				// Run the appropriate Stripe payment function based on totalAmount value
				if (totalAmount == 0.00) {
					Stripe = true;
					waitForElement(booking.getStripeBack());
					Set<String> hand = driver.getContextHandles(); // Get context handles
					System.out.println("Get Handles  : " + hand); // Print context handles
					String webcontext = new ArrayList<String>(hand).get(1); // Get web context
					System.out.println("WebView  : " + webcontext);
					Thread.sleep(2000);
					driver.context(webcontext);
					Thread.sleep(10000);
					Stripe_Payment1();
					String nativecontext = new ArrayList<String>(hand).get(0); // Get web context
					System.out.println("native  : " + nativecontext);
					driver.context(nativecontext);
				} else {
					Stripe = true;
					waitForElement(booking.getStripeBack());
					Set<String> hand = driver.getContextHandles(); // Get context handles
					System.out.println("Get Handles  : " + hand); // Print context handles
					String webcontext = new ArrayList<String>(hand).get(1); // Get web context
					System.out.println("WebView  : " + webcontext);
					Thread.sleep(2000);
					driver.context(webcontext);
					Thread.sleep(10000);
			    	Stripe_Payment();
					String nativecontext = new ArrayList<String>(hand).get(0); // Get web context
					System.out.println("native  : " + nativecontext);
					driver.context(nativecontext);
				}
			} else if (isElementAvailable(booking.getCrezcoPayment())) {
				Crezco = true;
				System.out.println("Crezco payment ");
				Set<String> hand = driver.getContextHandles(); // Get context handles
				System.out.println("Get Handles  : " + hand); // Print context handles
				String webcontext = new ArrayList<String>(hand).get(1); // Get web context
				System.out.println("WebView  : " + webcontext);
				Thread.sleep(2000);
				driver.context(webcontext);
				Thread.sleep(6000);
				Crezco_Payment();
			}

		} else {
			Stripe = false;
			Crezco = false;
			ClickonElement(booking.getCheckBox());
			ClickonElement(booking.getConfirmANDPay());
			System.out.println("Total amount is less than or equal to remaining credit. No payment required.");
		}
		System.out.println("Check the total amount and remaining credit amount  ");
	}

	public static void BookingFlow(String PricingRuletype, String ServiceName, String dateStr, String IndividualSLot)
			throws Exception {
		WE_Customer_BookingFlow booking = new WE_Customer_BookingFlow(driver);
		Api api = new Api(driver);
		WE_Customer_Settings mybookings = new WE_Customer_Settings(driver);
		Random random = new Random();

		waitForElement(booking.getassorted());
		Thread.sleep(3000);
		ClickonElement(mybookings.getSettingsTab());
		Thread.sleep(1000);
		ClickonElement(mybookings.getHomeTab());
		Thread.sleep(3000);
		waitForElement(booking.getassorted());
		System.out.println("nice");
		if (PricingRuletype.equalsIgnoreCase("PREMIUM")) {
			premium = true;
			discount = false;
			System.out.println("ttttttttttttttt");
		} else if (PricingRuletype.equalsIgnoreCase("DISCOUNT")) {
			discount = true;
			premium = false;
			System.out.println("uuuuuuuuuuuuuu");
		} else {
			System.out.println("Invalid type: " + PricingRuletype);
			discount = false;
			premium = false;
		}
		if (isElementAvailable(booking.getServiceShowAll())) {
			ClickonElement(booking.getServiceShowAll());
			ClickonElement(booking.getSearchServices());
			Thread.sleep(1000);
			passInput(booking.getSearchServices(), ServiceName);
			driver.hideKeyboard();
			ClickonElement(booking.getSelectService());
		} else if (isElementAvailable(booking.ServiceViewable)) {
			Thread.sleep(1000);
			clickOnElementUsingBy(booking.ServiceViewable);
		} else {
			System.out.println("Service is not available");
		}
		By xpath = By.xpath(String.format("//android.widget.SeekBar[contains(@content-desc,\"%s\")]", IndividualSLot));
		scrollUntilElementFound(booking.getseekbar(), xpath);
		LocalDate printDate = printDate(dateStr);
		String BookingMonth = getMonthName(printDate);
		int BookingYear = printDate.getYear();
		String BookingMonthProperCase = BookingMonth.substring(0, 1) + BookingMonth.substring(1).toLowerCase();
		Thread.sleep(1500);
		String dynamicLocator = "//android.view.View[@content-desc='" + BookingMonthProperCase + " " + BookingYear
				+ "']";
		System.out.println("gfyft     " + dynamicLocator);
		Thread.sleep(1500);
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
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
			String formattedDateStr = printDate.format(formatter1);
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
		boolean elementAvailable = isElementAvailable(booking.getConfirmBookingDetails());
		System.out.println(elementAvailable);
		if (elementAvailable) {
			System.out.println("proceed with the bookings");
		} else if (!elementAvailable) {
			throw new Error("This is Not available date, So you can't proceed the bookings");

		}
		Booked_service = booking.getserviceName().getAttribute("content-desc");
		System.out.println("ssssss    :  " + Booked_service);
		ClickonElement(booking.getproceed());
		Thread.sleep(5000);
		waitForElement(booking.getReviewBooking());
		System.out.println("review booking page");
		Thread.sleep(2000);
		if (premium) {
			isElementAvailable(booking.PremiumPricingRuleName);
			System.out.println("Premium pricing applies successfully");
		} else if (discount) {
			isElementAvailable(booking.DiscountPricingRuleName);
			System.out.println("discount pricing applies successfully");
		} else {
			System.out.println("Normal booking ");
		}
		String totalAmountText = booking.getTotal_Amount().getAttribute("content-desc");
		TotalAmountWithSymbol = totalAmountText;
		System.out.println("kkk    :--------------------------------         " + TotalAmountWithSymbol);
		String remainingCreditText = booking.getRemaining_Credit().getAttribute("content-desc");
		System.out.println("Total Amount is: " + totalAmountText);
		System.out.println("Remaining Credit is: " + remainingCreditText);
		// Remove the currency symbol and parse the values to double
		double totalAmount = Double.parseDouble(totalAmountText.replace("£", "").trim());
		double remainingCredit = Double.parseDouble(remainingCreditText.replace("£", "").trim());
		// Compare the values
		if (totalAmount > remainingCredit) {
			System.out.println("Total amount is greater than remaining credit. Navigating to payment page...");
			// Click on checkbox and ConfirmANDPay to go to the next page
			ClickonElement(booking.getCheckBox());
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ACS\\eclipse-workspace\\Smoke-Cucumber\\ChromeDriver\\chromedriver.exe");
			ClickonElement(booking.getConfirmANDPay());
			Thread.sleep(10000);
	    	if (isElementAvailable(booking.getStripeBack())) {
				// Run the appropriate Stripe payment function based on totalAmount value
				if (totalAmount == 0.00) {
					Stripe = true;
					waitForElement(booking.getStripeBack());
					Set<String> hand = driver.getContextHandles(); // Get context handles
					System.out.println("Get Handles  : " + hand); // Print context handles
					String webcontext = new ArrayList<String>(hand).get(1); // Get web context
					System.out.println("WebView  : " + webcontext);
					Thread.sleep(2000);
					driver.context(webcontext);
					Thread.sleep(10000);
					Stripe_Payment1();
					String nativecontext = new ArrayList<String>(hand).get(0); // Get web context
					System.out.println("native  : " + nativecontext);
					driver.context(nativecontext);
				} else {
					Stripe = true;
					waitForElement(booking.getStripeBack());
					Set<String> hand = driver.getContextHandles(); // Get context handles
					System.out.println("Get Handles  : " + hand); // Print context handles
					String webcontext = new ArrayList<String>(hand).get(1); // Get web context
					System.out.println("WebView  : " + webcontext);
					Thread.sleep(2000);
					driver.context(webcontext);
					Thread.sleep(10000);
					Stripe_Payment();
					String nativecontext = new ArrayList<String>(hand).get(0); // Get web context
					System.out.println("native  : " + nativecontext);
					driver.context(nativecontext);
				}
			} else if (isElementAvailable(booking.getCrezcoPayment())) {
				Crezco = true;
				System.out.println("Crezco payment ");
				Set<String> hand = driver.getContextHandles(); // Get context handles
				System.out.println("Get Handles  : " + hand); // Print context handles
				String webcontext = new ArrayList<String>(hand).get(1); // Get web context
				System.out.println("WebView  : " + webcontext);
				Thread.sleep(2000);
				driver.context(webcontext);
				Thread.sleep(6000);
				Crezco_Payment();
			}
		} else {
			Stripe = false;
			Crezco = false;
			ClickonElement(booking.getCheckBox());
			ClickonElement(booking.getConfirmANDPay());
			System.out.println("Total amount is less than or equal to remaining credit. No payment required.");
		}
		ClickonElement(booking.getSucessfullpage_Newbooking());
		System.out.println("Check the total amount and remaining credit amount  ");
	}

	public static void Accounts() throws InterruptedException {
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
	
	
	public static  void BookingforAddonservice() throws Exception {

		WE_Customer_BookingFlow booking = new WE_Customer_BookingFlow(driver);
		Api api = new Api(driver);
		WE_Customer_Settings mybookings = new WE_Customer_Settings(driver);
		waitForElement(booking.getassorted());
		Thread.sleep(3000);
		ClickonElement(mybookings.getSettingsTab());
		Thread.sleep(1000);
		ClickonElement(mybookings.getHomeTab());
		Thread.sleep(3000);
		waitForElement(booking.getassorted());
		System.out.println("nice");
		Random random = new Random();

		if (isElementAvailable(booking.getServiceShowAll())) {
			ClickonElement(booking.getServiceShowAll());
			ClickonElement(booking.getSearchServices());
			Thread.sleep(1000);
			passInput(booking.getSearchServices(), getProperty("ADDON_SERVICE_NAME"));
			driver.hideKeyboard();
			ClickonElement(booking.getSelectAddonService());
		} else if (isElementAvailable(booking.AddonServiceViewable)) {
			Thread.sleep(2000);
			clickOnElementUsingBy(booking.AddonServiceViewable);
		} else {
			System.out.println("Service is not available");
		}
		Thread.sleep(2000);
		waitForElement(booking.getAddons());
		clickOnElementUsingBy(booking.PrivilegeAddon);
		clickOnElementUsingBy(booking.AssignableAddon);
		
		Thread.sleep(2000);
		api.ServiceSlotTimeCount(getProperty("ADDON_SERVICE_NAME"));
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
		
		slowScroll(booking.getScrollView());		

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		startDate = LocalDate.parse(api.available_date_from, formatter);
		endDate = LocalDate.parse(api.available_date_to, formatter);
		long daysBetweenSpecificDates = ChronoUnit.DAYS.between(startDate, endDate);
		System.out.println("Number of days between " + startDate + " and " + endDate + ": " + daysBetweenSpecificDates);
		LocalDate currentDate = LocalDate.now();
		long daysFromCurrentToEndDate = ChronoUnit.DAYS.between(currentDate, endDate);
		System.out.println("Number of days from the current date (" + currentDate + ") to the end date (" + endDate
				+ "): " + daysFromCurrentToEndDate);
		minAdvanceBookingDate = getMinAdvanceBookingDate(currentDate, api.DAYminAdvanceBooking);
		maxBookingDate = getMaxBookingDate(currentDate, endDate, api.DAYminAdvanceBooking, api.DAYmaxAdvanceBooking);
		System.out.println("Minimum Advance Booking Date: " + minAdvanceBookingDate);
		System.out.println("Booking can be made up to: " + maxBookingDate);

		String minMonthName = getMonthName(minAdvanceBookingDate);
		String maxMonthName = getMonthName(maxBookingDate);
		System.out.println("Month of minimum advance booking date: " + minMonthName);
		System.out.println("Month of maximum booking date: " + maxMonthName);
		System.out.println("Month of minimum advance booking date: " + minMonthName);
		System.out.println("Month of maximum booking date: " + maxMonthName);
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String minimumDate = minAdvanceBookingDate.format(formatter1);
		String maximumDate = maxBookingDate.format(formatter1);
		api.getserviceID(getProperty("ADDON_SERVICE_NAME"));
		api.getslotID(Selected_Slot);
		api.getcustomerID(getProperty("SIGNUP_EMAIL"));
		api.NotAvailableDates(api.serviceId, api.slotId, api.CustomerId, minimumDate, maximumDate);
		List<LocalDate> remainingDates = api.getRemainingDates(api.notAvailableDates, minAdvanceBookingDate,maxBookingDate);
		Collections.shuffle(remainingDates);
		BookingDate = remainingDates.get(0);

//		BookingDate = getRandomDate(minAdvanceBookingDate, maxBookingDate);
//		System.out.println(
//				"Random date between " + minAdvanceBookingDate + " and " + maxBookingDate + ": " + BookingDate);
//		long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
//		System.out.println("Number of days between the two dates: " + daysBetween);

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
			DateTimeFormatter formatter11 = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
			String formattedDateStr = BookingDate.format(formatter11);
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
		Thread.sleep(5000);
		waitForElement(booking.getReviewBooking());
		System.out.println("review booking page");
		Thread.sleep(2000);
if (isElementAvailable(booking.AddonServiceViewable)) {
	System.out.println("service is viewable");	
}else {
	System.out.println("service is not availble");
}

if (isElementAvailable(booking.PrivilegeAddon)) {
	System.out.println("privelege is viewable");	
}else {
	System.out.println("privelege is not availble");
}

if (isElementAvailable(booking.AssignableAddon)) {
	System.out.println("privelege is viewable");	
}else {
	System.out.println("privelege is not availble");
}
		
		Thread.sleep(2000);
		String totalAmountText = booking.getTotal_Amount().getAttribute("content-desc");
		TotalAmountWithSymbol = totalAmountText;
		System.out.println("kkk    :--------------------------------         " + TotalAmountWithSymbol);
		String remainingCreditText = booking.getRemaining_Credit().getAttribute("content-desc");
		System.out.println("Total Amount is: " + totalAmountText);
		System.out.println("Remaining Credit is: " + remainingCreditText);
		// Remove the currency symbol and parse the values to double
		double totalAmount = Double.parseDouble(totalAmountText.replace("£", "").trim());
		double remainingCredit = Double.parseDouble(remainingCreditText.replace("£", "").trim());
		// Compare the values
		if (totalAmount > remainingCredit) {
			System.out.println("Total amount is greater than remaining credit. Navigating to payment page...");
			// Click on checkbox and ConfirmANDPay to go to the next page
			ClickonElement(booking.getCheckBox());
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ACS\\eclipse-workspace\\Smoke-Cucumber\\ChromeDriver\\chromedriver.exe");
			ClickonElement(booking.getConfirmANDPay());
			Thread.sleep(10000);
			if (isElementAvailable(booking.getStripeBack())) {
				// Run the appropriate Stripe payment function based on totalAmount value
				if (totalAmount == 0.00) {
					Stripe = true;
					waitForElement(booking.getStripeBack());
					Set<String> hand = driver.getContextHandles(); // Get context handles
					System.out.println("Get Handles  : " + hand); // Print context handles
					String webcontext = new ArrayList<String>(hand).get(1); // Get web context
					System.out.println("WebView  : " + webcontext);
					Thread.sleep(2000);
					driver.context(webcontext);
					Thread.sleep(10000);
					Stripe_Payment1();
					String nativecontext = new ArrayList<String>(hand).get(0); // Get web context
					System.out.println("native  : " + nativecontext);
					driver.context(nativecontext);
				} else {
					Stripe = true;
					waitForElement(booking.getStripeBack());
					Set<String> hand = driver.getContextHandles(); // Get context handles
					System.out.println("Get Handles  : " + hand); // Print context handles
					String webcontext = new ArrayList<String>(hand).get(1); // Get web context
					System.out.println("WebView  : " + webcontext);
					Thread.sleep(2000);
					driver.context(webcontext);
					Thread.sleep(10000);
					Stripe_Payment();
					String nativecontext = new ArrayList<String>(hand).get(0); // Get web context
					System.out.println("native  : " + nativecontext);
					driver.context(nativecontext);
				}
			} else if (isElementAvailable(booking.getCrezcoPayment())) {
				Crezco = true;
				System.out.println("Crezco payment ");
				Set<String> hand = driver.getContextHandles(); // Get context handles
				System.out.println("Get Handles  : " + hand); // Print context handles
				String webcontext = new ArrayList<String>(hand).get(1); // Get web context
				System.out.println("WebView  : " + webcontext);
				Thread.sleep(2000);
				driver.context(webcontext);
				Thread.sleep(6000);
				Crezco_Payment();
			}
		} else {
			Stripe = false;
			Crezco = false;
			ClickonElement(booking.getCheckBox());
			ClickonElement(booking.getConfirmANDPay());
			System.out.println("Total amount is less than or equal to remaining credit. No payment required.");
		}
		System.out.println("Check the total amount and remaining credit amount  ");
	}

}
