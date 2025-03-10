package cucumberStepDefinition;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import com.api.Error;
import com.baseClass.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerBookingFlowPricingRule extends Base {
	WE_Customer_BookingFlow booking = new WE_Customer_BookingFlow(driver);
	Api api = new Api(driver);
	WE_Customer_Settings mybookings = new WE_Customer_Settings(driver);
	Random random = new Random();

	public static List<String> TotalSlots;
	public static String SelectedSlot;
	public static String DiscountDATE;
	public static String PremiumDATE;
	public static String NotaAvailableDATE;
	public static LocalDate ModifiedDate;

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

////	*************************     DISCOUNT PRICINGRULE DATE
	
	@Given("the user is on the Customer Home Page")
	public void theUserIsOnTheCustomerHomePage() throws InterruptedException {
		waitForElement(booking.getassorted());
		Thread.sleep(3000);
		ClickonElement(mybookings.getSettingsTab());
		Thread.sleep(1000);
		ClickonElement(mybookings.getHomeTab());
		Thread.sleep(3000);
		waitForElement(booking.getassorted());
		System.out.println("nice");

	}

	@When("the user sees the Pricing Rule Type as {string}")
	public void theUserSeesThePricingRuleTypeAs(String PricingRuletype) {
		if (PricingRuletype.equalsIgnoreCase("PREMIUM")) {
			premium = true;
			discount = false;
			notavailable = false;
			System.out.println("ttttttttttttttt");
		} else if (PricingRuletype.equalsIgnoreCase("DISCOUNT")) {
			discount = true;
			premium = false;
			notavailable = false;
			System.out.println("uuuuuuuuuuuuuu");
		}else if (PricingRuletype.equalsIgnoreCase("NOT AVAILABLE")) {
			discount = false;
			premium = false;
			notavailable = true;
			System.out.println("uuuuuuuuuuuuuu");
		}
		else {
			System.out.println("Invalid type: " + PricingRuletype);
			discount = false;
			premium = false;
		}

	}

	@When("the user selects the desired Service as {string}")
	public void theUserSelectsTheDesiredServiceAs(String ServiceName) throws InterruptedException {
		if (isElementAvailable(booking.getServiceShowAll())) {
			ClickonElement(booking.getServiceShowAll());
			ClickonElement(booking.getSearchServices());
			Thread.sleep(1000);
			passInput(booking.getSearchServices(), getProperty(ServiceName));
			driver.hideKeyboard();
			ClickonElement(booking.getSelectService());
		} else if (isElementAvailable(booking.ServiceViewable)) {
			Thread.sleep(1000);
			clickOnElementUsingBy(booking.ServiceViewable);
		} else {
			System.out.println("Service is not available");
		}
	}

	@When("the user fetches available time slots from the API for discount")
	public void theUserFetchesAvailableTimeSlotsFromTheAPIForDiscount() {
		
		
//		api.OverallSlotList();
//		TotalSlots = api.slotNames;
//		SelectedSlot = SelectOneRandomlyFromList(TotalSlots);
	}

	@When("the user chooses an available Time Slot")
	public void theUserChoosesAnAvailableTimeSlot() throws Exception {
		Api.ServiceSlotTimeCount(getProperty("SERVICE_NAME"));
		int SlotCount = api.timeSlotsCount;
		System.out.println("slot  :  " + SlotCount);
		randomValue = random.nextInt(SlotCount);
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
		
//		By xpath = By.xpath(String.format("//android.widget.SeekBar[contains(@content-desc,\"%s\")]", SelectedSlot));
//		scrollUntilElementFound(booking.getseekbar(), xpath);
	}

	@When("the user gathering the pricingrule discount date from propertyfile")
	public void theUserGatheringThePricingruleDiscountDateFromPropertyfile() {
		DiscountDATE = MergePricingruleDate(getProperty("TO_Month_Discount_PricingRule"),
				getProperty("TO_Date_Discount_PricingRule"), getProperty("TO_Year_Discount_PricingRule"));
	}

	@When("the user opens the Calendar and navigates to the correct Month")
	public void theUserOpensTheCalendarAndNavigatesToTheCorrectMonth() throws InterruptedException {
		if (discount) {
			ModifiedDate = printDate(DiscountDATE);
		} else if (premium) {
			ModifiedDate = printDate(PremiumDATE);
		}else if (notavailable) {
			ModifiedDate = printDate(NotaAvailableDATE);
		} else {

		}
		String BookingMonth = getMonthName(ModifiedDate);
		int BookingYear = ModifiedDate.getYear();
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
	}

	@When("the user selects a Date that falls under the Pricing Rule")
	public void theUserSelectsADateThatFallsUnderThePricingRule() throws InterruptedException {
		Thread.sleep(4000);
		List<WebElement> calendarElements = driver.findElements(By.xpath(
				"//android.view.View[@content-desc=\"booking_page_calenderWidget\"]/android.view.View/android.view.View/android.view.View/android.view.View"));
		int size = calendarElements.size();
		if (size > 7) {
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
			String formattedDateStr = ModifiedDate.format(formatter1);
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

	}

	@When("the user taps Request Booking")
	public void theUserTapsRequestBooking() {
		ClickonElement(booking.getRequestBooking());

	}

	@Then("the user navigates to the Confirm Booking Details page")
	public void theUserNavigatesToTheConfirmBookingDetailsPage() throws Error, InterruptedException {

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
	}

	@When("the user taps Proceed")
	public void theUserTapsProceed() throws InterruptedException {

		ClickonElement(booking.getproceed());
		Thread.sleep(5000);
		waitForElement(booking.getReviewBooking());
		System.out.println("review booking page");
	}

	@Then("the user verifies the Pricing Rule Details on the Review Booking page")
	public void theUserVerifiesThePricingRuleDetailsOnTheReviewBookingPage() throws InterruptedException {

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
	}

	@When("the user completes the Payment Process or uses the Remaining Credit Balance if applicable")
	public void theUserCompletesThePaymentProcessOrUsesTheRemainingCreditBalanceIfApplicable()
			throws InterruptedException {
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

	}

	@Then("the user taps New Booking to start a new booking process")
	public void theUserTapsNewBookingToStartANewBookingProcess() {
		ClickonElement(booking.getSucessfullpage_Newbooking());
		System.out.println("Check the total amount and remaining credit amount  ");

	}
	
	
////*************************     PREMIUM PRICINGRULE DATE

	@When("the user fetches available time slots from the API for premium")
	public void theUserFetchesAvailableTimeSlotsFromTheAPIForPremium() throws Exception {
		
			Api.ServiceSlotTimeCount(getProperty("SERVICE_NAME"));
			int SlotCount = api.timeSlotsCount;
			System.out.println("slot  :  " + SlotCount);
			randomValue = random.nextInt(SlotCount);
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
	}
	
	@When("the user gathering the pricingrule premium date from propertyfile")
	public void theUserGatheringThePricingrulePremiumDateFromPropertyfile() {
		PremiumDATE = MergePricingruleDate(getProperty("TO_Month_Premium_PricingRule"),getProperty("TO_Date_Premium_PricingRule"),getProperty("TO_Year_Premium_PricingRule"));

	}

	
	@When("the user fetches available time slots from the API for Not Available")
	public void theUserFetchesAvailableTimeSlotsFromTheAPIForNotAvailable() throws Exception {
		
			Api.ServiceSlotTimeCount(getProperty("SERVICE_NAME"));
			int SlotCount = api.timeSlotsCount;
			System.out.println("slot  :  " + SlotCount);
			randomValue = random.nextInt(SlotCount);
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
	}
	
	@When("the user gathering the pricingrule Not available date from propertyfile")
	public void theUserGatheringThePricingruleNotAvailableDateFromPropertyfile() {
		NotaAvailableDATE =  MergePricingruleDate(getProperty("TO_Month_PricingRule_NotAvailable"),getProperty("TO_Date_PricingRule_NotAvailable"),getProperty("TO_Year_PricingRule_NotAvailable"));

	}

}
