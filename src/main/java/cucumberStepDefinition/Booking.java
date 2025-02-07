package cucumberStepDefinition;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
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
	public static String StatementCreatedDate;
	
	public static String TotalAmountWithSymbol;

	public static String InvoiceNumber;
	public static String currentMonth;
	public static Boolean Stripe;
	public static Boolean Crezco;
	
	
	
	public static List<String> OverallFilteredDates;

	WE_Customer_BookingFlow booking = new WE_Customer_BookingFlow(driver);
	WE_Customer_Settings mybookings = new WE_Customer_Settings(driver);
	WE_Customer_Settings invoices = new WE_Customer_Settings(driver);
	WE_Customer_Settings statement = new WE_Customer_Settings(driver);

	Api api = new Api(driver);
	Random random = new Random();

	
	  public static List<LocalDate> getFilteredDates(List<LocalDate> inputDates, String monthYear) {
	        String[] parts = monthYear.split(" "); // Split into ["July", "2025"]
	        int year = Integer.parseInt(parts[1]); // Convert "2025" to 2025
	        int month = Month.valueOf(parts[0].toUpperCase()).getValue(); // Convert "July" to 7

	        List<LocalDate> filteredDates = new ArrayList<>();
	        for (LocalDate date : inputDates) {
	            if (date.getMonthValue() == month && date.getYear() == year) {
	                filteredDates.add(date);
	            }
	        }
	        return filteredDates;
	    }
	
	
	
	@Given("the user selects a service")
	public void theUserSelectsAService() throws InterruptedException {
		waitForElement(booking.getassorted());
		Thread.sleep(3000);
		ClickonElement(mybookings.getSettingsTab());
		Thread.sleep(1000);
		ClickonElement(mybookings.getHomeTab());
		Thread.sleep(3000);
		waitForElement(booking.getassorted());
		System.out.println("nice");
		if (isElementAvailable(booking.getServiceShowAll())) {
			Thread.sleep(1000);
			Thread.sleep(3000);
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

	@When("the user fetches the slot list for the selected service using the API")
	public void theUserFetchesTheSlotListForTheSelectedServiceUsingTheAPI() throws InterruptedException {
		Api.ServiceSlotTimeCount();
		int SlotCount = api.timeSlotsCount;
		System.out.println("slot  :  " + SlotCount);
		randomValue = random.nextInt(SlotCount);
		System.out.println("Random value: " + randomValue);
		Thread.sleep(4000);
	}

	@When("the user selects a random slot from the slot list, scrolling the slot picker if necessary")
	public void theUserSelectsARandomSlotFromTheSlotListScrollingTheSlotPickerIfNecessary() throws Exception {
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

	@When("the user determines the From Date and To Date for the service based on constraints")
	public void theUserDeterminesTheFromDateAndToDateForTheServiceBasedOnConstraints() {
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

	@When("the user calculates the date range and picks a random date")
	public void theUserCalculatesTheDateRangeAndPicksARandomDate() throws InterruptedException {
		String minMonthName = getMonthName(minAdvanceBookingDate);
		String maxMonthName = getMonthName(maxBookingDate);
		System.out.println("Month of minimum advance booking date: " + minMonthName);
		System.out.println("Month of maximum booking date: " + maxMonthName);
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	     String minimumDate = minAdvanceBookingDate.format(formatter);
	     String maximumDate = maxBookingDate.format(formatter);

		
        api.getserviceID(getProperty("SERVICE_NAME"));
        api.getslotID(Selected_Slot);
        api.getcustomerID(getProperty("SIGNUP_EMAIL"));
//        api.NotAvailableDates(api.serviceId, api.slotId, api.CustomerId, minimumDate,maximumDate );
//        List<LocalDate> remainingDates = api.getRemainingDates(api.notAvailableDates, minAdvanceBookingDate, maxBookingDate);
//        Collections.shuffle(remainingDates);
//        BookingDate = remainingDates.get(0);
        
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

	@When("the user navigates to the random date's month using the right arrow")
	public void theUserNavigatesToTheRandomDateSMonthUsingTheRightArrow() throws InterruptedException {
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

	@When("the user selects the random date and taps the Request Booking button")
	public void theUserSelectsTheRandomDateAndTapsTheRequestBookingButton() throws InterruptedException {
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

	@Then("the user should successfully navigate to the Confirm Booking Details page")
	public void theUserShouldSuccessfullyNavigateToTheConfirmBookingDetailsPage() {
		System.out.println("Wait for the element");
	}

	@Then("the user verifies the service name, date, and slot")
	public void theUserVerifiesTheServiceNameDateAndSlot() throws InterruptedException {
		Thread.sleep(2000);
		Booked_service = booking.getserviceName().getAttribute("content-desc");
		System.out.println("ssssss    :  " + Booked_service);
	}

	@Then("the user taps the Proceed button")
	public void theUserTapsTheProceedButton() {
		ClickonElement(booking.getproceed());
	}

	@Then("the user navigates to the Review Booking page")
	public void theUserNavigatesToTheReviewBookingPage() throws InterruptedException {
		Thread.sleep(5000);
		waitForElement(booking.getReviewBooking());
		System.out.println("review booking page");
	}

	@Then("the user reviews the total amount and remaining credit amount")
	public void theUserReviewsTheTotalAmountAndRemainingCreditAmount() throws InterruptedException {
		Thread.sleep(2000);

		String totalAmountText = booking.getTotal_Amount().getAttribute("content-desc");
		TotalAmountWithSymbol=totalAmountText;
		System.out.println("kkk    :--------------------------------         "+TotalAmountWithSymbol);
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
				Stripe =true;
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
				
				Stripe =true;
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
		}
			else {
			Stripe =false;
			ClickonElement(booking.getCheckBox());
			
			ClickonElement(booking.getConfirmANDPay());
			System.out.println("Total amount is less than or equal to remaining credit. No payment required.");
		}
		System.out.println("Check the total amount and remaining credit amount  ");
	}

	@Then("the user taps the checkbox and taps the Confirm and Pay button")
	public void theUserTapsTheCheckboxAndTapsTheConfirmAndPayButton() {
		System.out.println("gvecgevc");
	}

	@Then("the user initiates the payment process")
	public void theUserInitiatesThePaymentProcess() {
		System.out.println("this is for stripe or not ");
	}

	@Then("the user navigates to the Booking Request Successful page")
	public void theUserNavigatesToTheBookingRequestSuccessfulPage() {
		System.out.println("successful page");
	}

	@Then("the user saves the booking details")
	public void theUserSavesTheBookingDetails() throws InterruptedException {
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

	@Then("the user taps the My Bookings button")
	public void theUserTapsTheMyBookingsButton() {
		ClickonElement(mybookings.getSettingsTab());
		ClickonElement(mybookings.getMyBookings());
	}

	@Then("the user navigates to the My Bookings page")
	public void theUserNavigatesToTheMyBookingsPage() {
		System.out.println("my bookins page ");
	}

	@Then("the user verifies that the booking is listed on the My Bookings page")
	public void theUserVerifiesThatTheBookingIsListedOnTheMyBookingsPage() throws InterruptedException {
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

	public static void Crezco_Payment() throws InterruptedException {
		WE_Customer_BookingFlow booking = new WE_Customer_BookingFlow(driver);// Create Stripe object
		ClickonElement(booking.getCrezcoContinue());
		Thread.sleep(2000);
		ClickonElement(booking.getCrezcoSandbox());
		Thread.sleep(2000);
		ClickonElement(booking.getCrezcoSubmit());

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

	@Then("User invoices")
	public void userInvoices() throws InterruptedException {
		WE_Customer_Settings invoices = new WE_Customer_Settings(driver);
		ClickonElement(invoices.getSettingsTab());
		ClickonElement(invoices.getMyInvoices());
		Thread.sleep(8000);
		ClickonElement(invoices.getFirstInvoice());
		Thread.sleep(6000);
		By BookedSERVICE = By.xpath("//android.view.View[@content-desc='" + Booking.Booked_service + "']");
		System.out.println(BookedSERVICE);
//        By BookedPAYMENT = By.xpath("//android.view.View[@content-desc='"+ Customer_Bookingflow.BookingPaidAmount + "']");
		By BookedPAYMENT1 = By
				.xpath("//android.view.View[@content-desc='" + Booking.BookingPaidAmountwithdecimal + "']");
		System.out.println(BookedPAYMENT1);

//        BookingPaidAmountwithdecimal
		Thread.sleep(4000);
		if (isElementAvailable(BookedSERVICE) && isElementAvailable(BookedPAYMENT1)) {
			System.out.println("Booking successfully listed on My Invoices");
			String attribute = invoices.getFindoutInvoiceNumber().getAttribute("content-desc");
			System.out.println(attribute);
			InvoiceNumber = attribute.replace(" #", ""); // Removes '#'
			System.out.println(InvoiceNumber);

		} else {
			System.out.println("Not listed");
		}
		ClickonElement(invoices.getBackButton());
		ClickonElement(invoices.getBackButton());
		ClickonElement(invoices.getHomeTab());

	}

	@Then("User Statements")
	public void userStatements() throws Exception {

		WE_Customer_Settings statement = new WE_Customer_Settings(driver);
		ClickonElement(statement.getSettingsTab());
		ClickonElement(statement.getMyStatements());
		LocalDate currentDate = LocalDate.now();
		currentMonth = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		System.out.println("Current month: " + currentMonth);
		Thread.sleep(1000);
		By Current_Month = By.xpath("//android.view.View[@content-desc='" + currentMonth + "']");
		Thread.sleep(3000);
		clickOnElementUsingBy(Current_Month);
		Thread.sleep(3000);

		Thread.sleep(5000);
		System.out.println(InvoiceNumber);
		By BookedPAYMENT1 = By.xpath("//android.view.View[@content-desc='" + InvoiceNumber + "']");
		System.out.println(BookedPAYMENT1);
		halfscrollUntilElementFound12(statement.getscroll(), BookedPAYMENT1);
		if (isElementAvailable(BookedPAYMENT1)) {
			System.out.println("Booking successfully listed on My statements");
			Thread.sleep(3000);
			String AttributeStatementCreatedDate = "//android.view.View[@content-desc='" + InvoiceNumber
					+ "']/preceding-sibling::android.view.View[1]";
			StatementCreatedDate = getContentDesc(AttributeStatementCreatedDate);
			System.out.println("hhhdhd   :    " + StatementCreatedDate);

		} else {
			System.out.println("Not listed");
		}
		Thread.sleep(1000);
		ClickonElement(statement.getBackButton());
		Thread.sleep(2000);
		ClickonElement(statement.getBackButton());
		ClickonElement(statement.getHomeTab());

	}

	@When("the customer clicks on Invoice")
	public void theCustomerClicksOnInvoice() {
		ClickonElement(invoices.getMyInvoices());
	}

	@When("the customer selects the first invoice")
	public void theCustomerSelectsTheFirstInvoice() throws InterruptedException {
		Thread.sleep(8000);
		ClickonElement(invoices.getFirstInvoice());

	}

	@Then("the customer checks the service locator and booking date locator")
	public void theCustomerChecksTheServiceLocatorAndBookingDateLocator() throws InterruptedException {
		Thread.sleep(6000);
		By BookedSERVICE = By.xpath("//android.view.View[@content-desc='" + Booking.Booked_service + "']");
		System.out.println(BookedSERVICE);
//	        By BookedPAYMENT = By.xpath("//android.view.View[@content-desc='"+ Customer_Bookingflow.BookingPaidAmount + "']");
		By BookedPAYMENT1 = By
				.xpath("//android.view.View[@content-desc='" + Booking.BookingPaidAmountwithdecimal + "']");
		System.out.println(BookedPAYMENT1);

//	        BookingPaidAmountwithdecimal
		Thread.sleep(4000);
		if (isElementAvailable(BookedSERVICE) && isElementAvailable(BookedPAYMENT1)) {
			System.out.println("Booking successfully listed on My Invoices");
			String attribute = invoices.getFindoutInvoiceNumber().getAttribute("content-desc");
			System.out.println(attribute);
			InvoiceNumber = attribute.replace(" #", ""); // Removes '#'
			System.out.println(InvoiceNumber);

		} else {
			System.out.println("Not listed");
		}

	}

	@Then("the customer goes back to the home page")
	public void theCustomerGoesBackToTheHomePage() throws InterruptedException {
		Thread.sleep(1000);
		ClickonElement(invoices.getBackButton());
		Thread.sleep(2000);
		ClickonElement(invoices.getBackButton());
		ClickonElement(invoices.getHomeTab());
	}

	@When("the customer clicks on Statements")
	public void theCustomerClicksOnStatements() {
		ClickonElement(statement.getMyStatements());
	}

	@When("the customer selects the current month")
	public void theCustomerSelectsTheCurrentMonth() throws InterruptedException {
		LocalDate currentDate = LocalDate.now();
		currentMonth = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		System.out.println("Current month: " + currentMonth);
		Thread.sleep(1000);
		By Current_Month = By.xpath("//android.view.View[@content-desc='" + currentMonth + "']");
		Thread.sleep(3000);
		clickOnElementUsingBy(Current_Month);

	}

	@Then("the customer checks if the saved invoice number is listed")
	public void theCustomerChecksIfTheSavedInvoiceNumberIsListed() throws Exception {
		Thread.sleep(3000);

		Thread.sleep(5000);
		System.out.println(InvoiceNumber);
		By BookedPAYMENT1 = By.xpath("//android.view.View[@content-desc='" + InvoiceNumber + "']");
		System.out.println(BookedPAYMENT1);
		halfscrollUntilElementFound12(statement.getscroll(), BookedPAYMENT1);
		if (isElementAvailable(BookedPAYMENT1)) {
			System.out.println("Booking successfully listed on My statements");
			Thread.sleep(3000);
			String AttributeStatementCreatedDate = "//android.view.View[@content-desc='" + InvoiceNumber
					+ "']/preceding-sibling::android.view.View[1]";
			StatementCreatedDate = getContentDesc(AttributeStatementCreatedDate);
			System.out.println("hhhdhd   :    " + StatementCreatedDate);

		} else {
			System.out.println("Not listed");
		}

	}
	
	@Then("the customer goes back from accounts to the home page")
	public void theCustomerGoesBackFromAccountsToTheHomePage() throws InterruptedException {
		Thread.sleep(1000);
		ClickonElement(invoices.getBackButton());
		Thread.sleep(2000);
		ClickonElement(invoices.getHomeTab());
	}
	
	
//	  ------------------------------------------------->   MULTIPLE DATES
	
	
		
	

	@When("the user determines the From Date and To Date for the service based on constraints and the user calculates the date range and picks Multiple dates")
	public void theUserDeterminesTheFromDateAndToDateForTheServiceBasedOnConstraintsAndTheUserCalculatesTheDateRangeAndPicksMultipleDates() throws InterruptedException {
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

		
        api.getserviceID(getProperty("SERVICE_NAME"));
        api.getslotID(Selected_Slot);
        api.getcustomerID(getProperty("SIGNUP_EMAIL"));
        api.NotAvailableDates(api.serviceId, api.slotId, api.CustomerId, minimumDate,maximumDate );
        List<LocalDate> remainingDates = api.getRemainingDates(api.notAvailableDates, minAdvanceBookingDate, maxBookingDate);
        Collections.shuffle(remainingDates);
        BookingDate = remainingDates.get(0);
        
//		BookingDate = getRandomDate(minAdvanceBookingDate, maxBookingDate);
//		System.out.println(
//				"Random date between " + minAdvanceBookingDate + " and " + maxBookingDate + ": " + BookingDate);
//		long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
//		System.out.println("Number of days between the two dates: " + daysBetween);
		String BookingMonth = getMonthName(BookingDate);
		BookingYear = BookingDate.getYear();
		BookingMonthProperCase = BookingMonth.substring(0, 1) + BookingMonth.substring(1).toLowerCase();
		Thread.sleep(3000);
		
		String monthyear = BookingMonthProperCase+" "+BookingYear;
		System.out.println("eggdgd   : "+monthyear);
		
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
			System.out.println("fdrrdrdrdrdr    " + formattedDateStr);
			// Check if the date portion starts with "0" and remove it if so
			if (formattedDateStr.charAt(formattedDateStr.indexOf(",") + 6) == '0') {
				formattedDateStr = formattedDateStr.replaceFirst(" 0", " ");
			}
			System.out.println("Formatted Date: " + formattedDateStr);
//			remainingDates
			List<LocalDate> filteredDates = getFilteredDates(remainingDates, monthyear);
			
			System.out.println("--------------------->    "+filteredDates);
			
			
			 DateTimeFormatter formatter111 = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
		        OverallFilteredDates = new ArrayList<>();

		        for (LocalDate date : filteredDates) {
		            String formattedDateStr111 = date.format(formatter111);

		            // Check if the day portion starts with "0" and remove it
		            if (formattedDateStr111.charAt(formattedDateStr111.indexOf(",") + 6) == '0') {
		                formattedDateStr111 = formattedDateStr111.replaceFirst(" 0", " ");
		            }

		            OverallFilteredDates.add(formattedDateStr111);
		        }

		        // Print formatted date list
		        System.out.println("--->   "+OverallFilteredDates);
			
			
			
			
			
			
			
			
			
			
			
			
			Thread.sleep(5000);
			for (String date : OverallFilteredDates) {
			    String dateXpath = "//android.view.View[@content-desc='" + date.toString() + "']";
			    System.out.println("ffffff   "+dateXpath);
			    List<WebElement> dateElements = driver.findElements(By.xpath(dateXpath));
			    
			    if (!dateElements.isEmpty()) {  // Check if element exists
			        dateElements.get(0).click(); // Click first matching element
			    } else {
			        System.out.println("Date not found: " + date);
			    }
			}
			
			
			
			
			
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
	
	
	
	
	
	
//	--------------------------------------------------->   TWO PETS
	
	
	
	@Given("the user selects the second pet")
	public void theUserSelectsTheSecondPet() throws InterruptedException {
	   
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
	}
	
	
	@Given("Accounts")
	public void accounts() throws InterruptedException {
		WE_Customer_Settings statement = new WE_Customer_Settings(driver);
		ClickonElement(statement.getSettingsTab());
		ClickonElement(statement.getAccounts());
		Thread.sleep(10000);
		if (Booking.Stripe) {
			//android.view.View[@content-desc="Payment"]/following-sibling::android.view.View[@content-desc="£ 999.99"]
//			By sales = By.xpath("//android.view.View[@content-desc=\"Payment\"]/following-sibling::android.view.View[@content-desc="+"-"+"'"+Booking.TotalAmountWithSymbol+"']");
//			System.out.println(sales);
//			By payment = By.xpath("//android.view.View[@content-desc=\"Payment\"]/following-sibling::android.view.View[@content-desc='"+Booking.TotalAmountWithSymbol+"']");
//			System.out.println(payment);
			
			
			By sales = By.xpath("//android.view.View[@content-desc=\"sales\"]/following-sibling::android.view.View[@content-desc=\"- £ 999.99\"]");
			System.out.println(sales);
			By payment = By.xpath("//android.view.View[@content-desc=\"Payment\"]/following-sibling::android.view.View[@content-desc=\"£ 999.99\"]");
			System.out.println(payment);
			
			
			
			
			if (isElementAvailable(payment)&&isElementAvailable(sales)) {
				System.out.println("Completed sales and payment  ");
				
			}else {
				System.out.println("hhhhhhhhhh");
			}
				
			
			
		}else {
			
			By sales = By.xpath("//android.view.View[@content-desc=\"sales\"]/following-sibling::android.view.View[@content-desc=\"- £ 999.99\"]");
			System.out.println(sales);
			
			if (isElementAvailable(sales)) {
				System.out.println("sales done");
				
			}
			
		}
		
		
	}
		

//			WE_Customer_Settings statement = new WE_Customer_Settings(driver);
//			ClickonElement(statement.getSettingsTab());
//			ClickonElement(statement.getAccounts());
//			Thread.sleep(10000);
//			if (Booking.Stripe) {
//				
//				By sales = By.xpath("//android.view.View[@content-desc=\"sales\"]/following-sibling::android.view.View[@content-desc="+"-"+"'"+Booking.TotalAmountWithSymbol+"']");
//				System.out.println(sales);
//				By payment = By.xpath("//android.view.View[@content-desc=\"Payment\"]/following-sibling::android.view.View[@content-desc='"+Booking.TotalAmountWithSymbol+"']");
//				System.out.println(payment);
//				
//				if (isElementAvailable(sales)&& isElementAvailable(payment)) {
//					System.out.println("Card payment Bookings replicated customer accounts successfully"); 
//				}else {
//					System.out.println("null 1 ");
//				}
//			}else {
//				By sales = By.xpath("//android.view.View[@content-desc=\"sales\"]/following-sibling::android.view.View[@content-desc="+"-"+"'"+Booking.TotalAmountWithSymbol+"']");
//				System.out.println(sales);
////				WebElement findElement = driver.findElement(statement.sales);
//				if (isElementAvailable(sales)) {
//					System.out.println("remaining credit payment replicated successfully");
//				}
//			}
//	
//	}
}
