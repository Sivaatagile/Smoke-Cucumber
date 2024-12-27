package cucumberStepDefinition;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.WE.WE_Customer_BookingFlow;
import com.WE.WE_Customer_Settings;
import com.api.Api;
import com.baseClass.Base;
import com.frontend.Customer_Bookingflow;

import io.cucumber.java.en.*;

public class Booking extends Base {
	public static String BookingPaidAmount;
	public static String BookingPaymentTime;
	public static String Selected_Slot;
	public static String Booked_Date;
	public static String Booked_service;
	public static String BookingPaidAmountwithdecimal;
	public static LocalDate BookingDate;
	public static int randomValue;
	public static LocalDate startDate;
	public static LocalDate endDate;
	public static LocalDate minAdvanceBookingDate;
	public static LocalDate maxBookingDate;
	public static int BookingYear;
	public static String BookingMonthProperCase;

	WE_Customer_BookingFlow booking = new WE_Customer_BookingFlow(driver);
	WE_Customer_Settings mybookings = new WE_Customer_Settings(driver);
	Api api = new Api(driver);
	Random random = new Random();

	@Given("User selects a service")
	public void userSelectsAService() throws InterruptedException {
		waitForElement(booking.getassorted());
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
	}

	@When("User fetches the slot list for the selected service using the API")
	public void userFetchesTheSlotListForTheSelectedServiceUsingTheAPI() throws Exception {
		Api.ServiceSlotTimeCount();
		int SlotCount = api.timeSlotsCount;
		System.out.println("slot  :  " + SlotCount);
		randomValue = random.nextInt(SlotCount);
		System.out.println("Random value: " + randomValue);
		Thread.sleep(4000);
	}

	@When("User selects a random slot from the slot list, scrolling the slot picker if necessary")
	public void userSelectsARandomSlotFromTheSlotListScrollingTheSlotPickerIfNecessary() throws Exception {
		Thread.sleep(4000);
		for (int i = 1; i < randomValue; i++) {
			scroll(booking.getseekbar());
			System.out.println(i);
			Thread.sleep(500); // waits for 500ms
		}
		Thread.sleep(2500);
		Selected_Slot = booking.getseekbar().getAttribute("content-desc");
		System.out.println(Selected_Slot);
	}

	@When("User determines the From Date and To Date for the service based on constraints")
	public void userDeterminesTheFromDateAndToDateForTheServiceBasedOnConstraints() {
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
	}

	@When("User calculates the date range and picks a random date")
	public void userCalculatesTheDateRangeAndPicksARandomDate() throws InterruptedException {
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
		BookingYear = BookingDate.getYear();
		BookingMonthProperCase = BookingMonth.substring(0, 1) + BookingMonth.substring(1).toLowerCase();
		Thread.sleep(3000);
	}

	@When("User navigates to the random date's month using the right arrow")
	public void userNavigatesToTheRandomDateSMonthUsingTheRightArrow() throws InterruptedException {
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
	}

	@When("User selects the random date and User taps the Request Booking button")
	public void userSelectsTheRandomDateAnduserTapsTheRequestBookingButton() throws InterruptedException {
		Thread.sleep(4000);
		List<WebElement> calendarElements = driver.findElements(By.xpath(
				"//android.view.View[@content-desc=\"booking_page_calenderWidget\"]/android.view.View/android.view.View/android.view.View/android.view.View"));
		int size = calendarElements.size();
		if (size > 7) {
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
			String formattedDateStr = BookingDate.format(formatter1);
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
	}

	@Then("User should successfully navigate to the Confirm Booking Details page")
	public void userShouldSuccessfullyNavigateToTheConfirmBookingDetailsPage() {
		System.out.println("Wait for the element");
	}

	@Then("User verifies the service name, date, and slot")
	public void userVerifiesTheServiceNameDateAndSlot() throws InterruptedException {
		Thread.sleep(2000);
		Booked_service = booking.getserviceName().getAttribute("content-desc");
		System.out.println("ssssss    :  " + Booked_service);
	}

	@Then("User taps the Proceed button")
	public void userTapsTheProceedButton() {
		ClickonElement(booking.getproceed());
	}

	@Then("User navigates to the Review Booking page")
	public void userNavigatesToTheReviewBookingPage() throws InterruptedException {
		waitForElement(booking.getReviewBooking());
		System.out.println("review booking page");
	}

	@Then("User reviews the total amount and remaining credit amount")
	public void userReviewsTheTotalAmountAndRemainingCreditAmount() throws InterruptedException {
		String totalAmountText = booking.getTotal_Amount().getAttribute("content-desc");
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
			// Run the appropriate Stripe payment function based on totalAmount value
			if (totalAmount == 0.00) {
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
		} else {
			System.out.println("Total amount is less than or equal to remaining credit. No payment required.");
		}
		System.out.println("Check the total amount and remaining credit amount  ");
	}

	@Then("User taps the checkbox and User taps the Confirm and Pay button")
	public void userTapsTheCheckboxAnduserTapsTheConfirmAndPayButton() {
		System.out.println("gvecgevc");
	}

	@Then("User initiates the payment process")
	public void userInitiatesThePaymentProcess() {
		System.out.println("this is for stripe or not ");
	}

	@Then("User navigates to the Booking Request Successful page")
	public void userNavigatesToTheBookingRequestSuccessfulPage() {
		System.out.println("successful page");
	}

	@Then("User saves the booking details")
	public void userSavesTheBookingDetails() throws InterruptedException {
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

	@Then("User taps the My Bookings button")
	public void userTapsTheMyBookingsButton() {
		ClickonElement(mybookings.getSettingsTab());
		ClickonElement(mybookings.getMyBookings());
	}

	@Then("User navigates to the My Bookings page")
	public void userNavigatesToTheMyBookingsPage() {
		System.out.println("my bookins page ");
	}

	@Then("User verifies that the booking is listed on the My Bookings page")
	public void userVerifiesThatTheBookingIsListedOnTheMyBookingsPage() throws InterruptedException {
		Thread.sleep(3000);
		By BookedDATE = By.xpath("//android.view.View[@content-desc='" + Booking.Booked_Date + "']");
		System.out.println(BookedDATE);
		By BookedSLOT = By.xpath("//android.view.View[@content-desc='" + Booking.Selected_Slot + "']");
		System.out.println(BookedSLOT);
		By BookedSERVICE = By.xpath("//android.view.View[@content-desc='" + Booking.Booked_service + "']");
		System.out.println(BookedSERVICE);
		By BookedPAYMENT = By.xpath("//android.view.View[@content-desc='" + Booking.BookingPaidAmount + "']");
		System.out.println(BookedPAYMENT);
		System.out.println(Booking.Selected_Slot);
		if (isElementAvailable(BookedDATE) && isElementAvailable(BookedSLOT) && isElementAvailable(BookedSERVICE)
				&& isElementAvailable(BookedPAYMENT)) {
			System.out.println("Booking successfully listed on My Bookings");
		} else {
			System.out.println("Not listed");
		}
		ClickonElement(mybookings.getBackButton());
		ClickonElement(mybookings.getHomeTab());
	}

	public static void Stripe_Payment1() throws InterruptedException {
		WE_Customer_BookingFlow booking = new WE_Customer_BookingFlow(driver);// Create Stripe object
		ClickonElement(booking.getEmail()); // Click on the Gmail input field
		passInput(booking.getEmail(), getProperty("StripeEmail")); // Enter the Gmail address
		driver.hideKeyboard();
		Thread.sleep(2000);
		ClickonElement(booking.getCompleteOrder());
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

}
