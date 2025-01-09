package com.baseClass;

import java.io.*;
import java.lang.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.qameta.allure.Allure;

public class Base {
	public static String workspacePath = System.getProperty("user.dir");
	public static Properties properties;
	public static AndroidDriver driver;
	public static Boolean target;
	public static String OTPText;
	public static String outputAssignedDate;
	public static String InvoiceNumber;
	public static String currentMonth;
	public static String StatementCreatedDate;
	public static boolean range;

//	----------------------------------------------->  Application details

	public static void Application() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options(); // Create options object
		String getEmulatorArch = getEmulatorArch("Pixel_6_Pro"); // Get emulator architecture
		String Apk = workspacePath + "\\Apk\\app-" + getEmulatorArch + "-release.apk"; // APK path
//		String Apk =getProperty("APK_PATH");
		options.setAutomationName(getProperty("AUTOMATION_NAME")); // Set automation name
		options.setPlatformName(getProperty("PLATFORM_NAME")); // Set platform name
		options.setPlatformVersion(getProperty("PLATFORM_VERSION")); // Set platform version
		options.setDeviceName(getProperty("DEVICE_NAME")); // Set device name
		options.setApp(Apk); // Set the path to the downloaded APK file
		options.setCapability("autoGrantPermissions", "true"); // Set capability
		options.setCapability("chromedriverExecutable",
				"C:\\Users\\ACS\\eclipse-workspace\\sanity_booking_app\\dri\\chromedriver.exe");
		options.setCapability("newCommandTimeout", 100000);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options); // Initialize driver

	}

	public static void OpenApplicationWithoutReset() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options(); // Create options object
		options.setAutomationName("UiAutomator2"); // Set automation name
		options.setPlatformName("Android"); // Set platform name
		options.setPlatformVersion("13.0"); // Set platform version
		options.setDeviceName("Pixel 6 Pro API 33"); // Set device name
		options.setCapability("appPackage", getProperty("APP_PACKAGE")); // Set app package
		options.setCapability("appActivity", getProperty("APP_ACTIVITY")); // Set app activity
		options.setNoReset(true); // Set no reset
		options.setFullReset(false); // Set full reset
		options.setCapability("chromedriverExecutable",
				"C:\\Users\\ACS\\eclipse-workspace\\sanity_booking_app\\dri\\chromedriver.exe");
		options.setCapability("newCommandTimeout", 100000);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options); // Initialize driver
	}

	public static void OpenApplication() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options(); // Create options object
		options.setAutomationName("UiAutomator2"); // Set automation name
		options.setPlatformName("Android"); // Set platform name
		options.setPlatformVersion("13.0"); // Set platform version
		options.setDeviceName("Pixel 6 Pro API 33"); // Set device name
		options.setCapability("autoGrantPermissions", "true");
		options.setCapability("appPackage", getProperty("APP_PACKAGE")); // Set app package
		options.setCapability("appActivity", getProperty("APP_ACTIVITY")); // Set app activity
//		options.setNoReset(true); // Set no reset
//		options.setFullReset(false); // Set full reset
		options.setCapability("newCommandTimeout", 100000);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options); // Initialize driver
	}

	public static void appli() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options(); // Create options object
		options.setAutomationName("UiAutomator2"); // Set automation name
		options.setPlatformName("Android"); // Set platform name
//		options.setPlatformVersion("13.0"); // Set platform version
		options.setDeviceName("Pixel 6 Pro API 33"); // Set device name
		options.setCapability("appPackage", getProperty("APP_PACKAGE")); // Set app package
		options.setCapability("appActivity", getProperty("APP_ACTIVITY")); // Set app activity
		options.setCapability("autoGrantPermissions", "true"); // Set capability
		options.setCapability("chromedriverExecutable",
				"C:\\Users\\ACS\\eclipse-workspace\\Smoke-Cucumber\\ChromeDriver\\chromedriver.exe");
		options.setCapability("newCommandTimeout", 100000);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options); // Initialize driver
	}

	public static void clearCache() {
		try {
			UiAutomator2Options options = new UiAutomator2Options();
			String packageName = "com.petcaretechnologies.app";
			String command = "adb shell pm clear " + packageName;
			Process process = Runtime.getRuntime().exec(command);
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			process.waitFor();
			System.out.println("Cache cleared for package: " + packageName);
			options.setCapability("autoGrantPermissions", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clearAppCache(String packageName) throws IOException, InterruptedException {
		// Command to clear app cache using adb
		String clearCacheCommand = "adb shell pm clear " + packageName;
		Process process = Runtime.getRuntime().exec(clearCacheCommand);
		process.waitFor();
		System.out.println("Cache cleared for package: " + packageName);
	}

	public static String getProperty(String key) {
		return properties.getProperty(key); // Retrieve property value by key
	}

	public static void method1(String fileName) throws IOException {
		properties = new Properties();
		// Load the properties from the file passed as argument
		FileInputStream fis = new FileInputStream("src/test/java/" + fileName + ".properties");
		properties.load(fis);
		properties.list(System.out);
		System.out.println("property file loded");
	}

	public static void passInput(WebElement element, String input) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOf(element)); // Wait until the element is visible
		element.sendKeys(input);
	}

	public static void ClickonElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120)); // 10 seconds wait time
		wait.until(ExpectedConditions.elementToBeClickable(element)); // Wait until the element is clickable
		element.click();
	}

	public static void ClickonElementwithoutWAIT(WebElement element) throws InterruptedException {
		Thread.sleep(3000);
		element.click();
	}

	public static void clickOnElementUsingBy(By by) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120)); // 120 seconds wait time
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by)); // Wait until the element is
																						// clickable
		element.click();
		Thread.sleep(4000);
	}

	public static void waitForElement(WebElement element) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120)); // 120 seconds wait time
		wait.until(ExpectedConditions.elementToBeClickable(element)); // Wait until the element is clickable
		System.out.println("Find out");
	}

	public static boolean isElementAvailable(By by) throws InterruptedException {
		try {
			Thread.sleep(4000); // Pause for 3 seconds before attempting to find the element
			WebElement findElement = driver.findElement(by); // Try to find the element
			return findElement.isDisplayed(); // If found, return true
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false; // If not found, return false
		}
	}

	public static boolean isScrollViewAvailable() {
		try {
			driver.findElement(By.className("android.widget.ScrollView")); // Try to find ScrollView element
			return true; // ScrollView is found
		} catch (NoSuchElementException e) {
			return false; // ScrollView is not found
		}
	}

	public static boolean isElementAvailable(WebElement element) throws InterruptedException {
		try {
			Thread.sleep(4000); // Pause for 4 seconds before checking the element
			return element.isDisplayed(); // Check if the element is displayed
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false; // If the element is not found, return false
		}
	}

	public static boolean isElementPresent(String xpath) {
		try {
			driver.findElement(By.xpath(xpath));
			return true; // Element is found
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false; // Element is not found
		}
	}

	public static void passInputUsingActions(WebElement element, String input) throws InterruptedException {
		// 120 seconds wait time
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(element)); // Wait until the element is visible
		Actions actions = new Actions(driver);
		actions.sendKeys(element, input).perform();
	}

//	----------------------------------------------------------------------------->    SCROLL -------------------------------------------------------------------

	public static void scrollDown() {
		String scrollableList = "new UiScrollable(new UiSelector().scrollable(true).instance(0))";
		String scrollToEnd = ".scrollToEnd(1)";
		driver.findElement(AppiumBy.androidUIAutomator(scrollableList + scrollToEnd));
	}

	public static void scrolling() {
		String scrollableList = "new UiScrollable(new UiSelector().scrollable(true).instance(0))"; // Scrollable list
		int scrollOffset = 100; // Set the scroll offset value (adjust as needed)
		String scrollByOffset = ".scrollForward(" + scrollOffset + ")"; // Scroll by offset
		driver.findElement(AppiumBy.androidUIAutomator(scrollableList + scrollByOffset)); // Find element and scroll
	}

	public static void scrollUntilElementFound12(WebElement scrollElement, By targetBy) throws Exception {
		while (true) {
			try {

				WebElement targetElement = driver.findElement(targetBy);
				if (targetElement.isDisplayed()) {
					target = true;
					System.out.println("Target element found");
					break; // Exit the loop if the target element is found and displayed
				}
			} catch (NoSuchElementException e) {
				target = false;
				System.out.println("Target element not found, scrolling...");
				scrollDatePicker(scrollElement); // Call the scroll() method to scroll the screen
			}
		}
	}

	public static void scrollDatePicker(WebElement element) throws Exception {
		try {
			Thread.sleep(500);
			Dimension elementSize = element.getSize();
			Point elementLocation = element.getLocation();
			int centerX = elementLocation.x + (elementSize.width / 2);
			int startPoint = elementLocation.y + (int) (elementSize.height * 0.55); // Start point at 80% of the element's height
			int endPoint = elementLocation.y + (int) (elementSize.height * 0.45); // End point at 20% of the element's height
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Thread.sleep(500);
			Sequence sequence = new Sequence(finger, 1);
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), centerX,
					startPoint));
			sequence.addAction(finger.createPointerDown(0));
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), centerX,
					endPoint));
			sequence.addAction(finger.createPointerUp(0));
			driver.perform(Arrays.asList(sequence));
		} catch (Exception e) {
			throw e;
		}
	}

	public static void scrollUntilElementFound_DatePicker_Time(WebElement scrollElement, By targetBy) throws Exception {
		boolean targetFound = false;
		while (!targetFound) {
			try {
				Thread.sleep(500);
				WebElement targetElement = driver.findElement(targetBy);
				if (targetElement.isDisplayed()) {
					targetFound = true;
					System.out.println("Target element found");
				}
			} catch (NoSuchElementException e) {
				System.out.println("Target element not found, scrolling...");
				Thread.sleep(500);
				scrollDatePicker(scrollElement); // Scroll if target not found
			}
		}
	}

	public static void swipeWithinElementUntilTargetVisible(WebElement scrollableElement, By targetElementLocator) {
		boolean isTargetElementFound = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions actions = new Actions(driver); // Initialize Actions class
		while (!isTargetElementFound) {
			try {
				// Try to locate the target element and check if it's visible
				WebElement targetElement = wait
						.until(ExpectedConditions.visibilityOfElementLocated(targetElementLocator));
				isTargetElementFound = targetElement.isDisplayed();
				System.out.println("Target element found: " + targetElement.getText());
			} catch (Exception e) {
				// If target element is not visible, perform a swipe within the container
				System.out.println("Swiping within container... target element not found yet.");
				int centerX = scrollableElement.getLocation().getX() + (scrollableElement.getSize().getWidth() / 2);
				int startY = scrollableElement.getLocation().getY() + (scrollableElement.getSize().getHeight() * 3 / 4); 
				int endY = scrollableElement.getLocation().getY() + (scrollableElement.getSize().getHeight() / 4); 
				actions.moveToElement(scrollableElement, centerX, startY).clickAndHold().moveByOffset(0, 300)
						.release().perform();
			}
		}
	}

	public static void halfscroll(WebElement element) throws Exception {
		try {
			Dimension elementSize = element.getSize();
			Point elementLocation = element.getLocation();
			int centerX = elementLocation.x + (elementSize.width / 2);
			int startPoint = elementLocation.y + (int) (elementSize.height * 0.75); // Start point at 80% of the element's height
			int endPoint = elementLocation.y + (int) (elementSize.height * 0.25); // End point at 20% of the element's height
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence sequence = new Sequence(finger, 1);
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), centerX,
					startPoint));
			sequence.addAction(finger.createPointerDown(0));
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), centerX,
					endPoint));
			sequence.addAction(finger.createPointerUp(0));
			driver.perform(Arrays.asList(sequence));
		} catch (Exception e) {
			throw e;
		}
	}

	public static void slowScroll() throws Exception {
		try {
			// Get the screen dimensions
			Dimension screenSize = driver.manage().window().getSize();
			int screenWidth = screenSize.width;
			int screenHeight = screenSize.height;
			int centerX = screenWidth / 2; // Horizontal center of the screen
			int startPoint = (int) (screenHeight * 0.8); // Start at 80% of the screen height
			int endPoint = (int) (screenHeight * 0.2); // End at 20% of the screen height
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence sequence = new Sequence(finger, 1);
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), centerX,
					startPoint));
			sequence.addAction(finger.createPointerDown(0));
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(),
					centerX, endPoint)); // Slow scroll with 1-second duration
			sequence.addAction(finger.createPointerUp(0));
			driver.perform(Arrays.asList(sequence));
		} catch (Exception e) {
			throw e;
		}
	}

	public static void halfscrollUntilElementFound12(WebElement scrollElement, WebElement targetElement)
			throws Exception {
		while (true) {
			try {
				if (targetElement.isDisplayed()) {
					target = true;
					System.out.println("Target element found");
					break; // Exit the loop if the target element is found and displayed
				}
			} catch (NoSuchElementException e) {
				target = false;
				System.out.println("Target element not found, scrolling...");
				halfscroll(scrollElement); // Call the scroll() method to scroll the screen
			}
		}
	}

	public static void halfscrollUntilElementFound12(WebElement scrollElement, By targetBy) throws Exception {
		while (true) {
			try {

				WebElement targetElement = driver.findElement(targetBy);
				if (targetElement.isDisplayed()) {
					target = true;
					System.out.println("Target element found");
					break; // Exit the loop if the target element is found and displayed
				}
			} catch (NoSuchElementException e) {
				target = false;
				System.out.println("Target element not found, scrolling...");
				halfscroll(scrollElement); // Call the scroll() method to scroll the screen
			}
		}
	}

	public static void scrollupRandomly(WebElement scrollElement) throws Exception {
		Random random = new Random();
		int scrollAttempts = random.nextInt(2) + 1; // Random number between 1 and 2
		for (int i = 0; i < scrollAttempts; i++) {
			System.out.println("Scrolling up... Attempt: " + (i + 1));
			scrollUp(scrollElement); // Call the scrollUp method to perform the scroll up action
			Thread.sleep(1000); // Add a delay after each scroll up attempt
		}
		System.out.println("Random scroll attempts completed.");
	}

	public static void scrollUp(WebElement element) throws Exception {
		try {
			Dimension elementSize = element.getSize();
			Point elementLocation = element.getLocation();
			int centerX = elementLocation.x + (elementSize.width / 2);
			int startPoint = elementLocation.y + (int) (elementSize.height * 0.20); // Start point at 20% of the element's height
			int endPoint = elementLocation.y + (int) (elementSize.height * 0.80); // End point at 80% of the element's height
			Thread.sleep(1000); // Add a delay before performing the scroll gesture
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence sequence = new Sequence(finger, 1);
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(250), PointerInput.Origin.viewport(), centerX,
					startPoint));
			sequence.addAction(finger.createPointerDown(0));
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(250), PointerInput.Origin.viewport(), centerX,
					endPoint));
			sequence.addAction(finger.createPointerUp(0));
			driver.perform(Arrays.asList(sequence)); // Perform the scroll up gesture
		} catch (Exception e) {
			throw e;
		}
	}

	public static void scrolldownRandomly(WebElement scrollElement) throws Exception {
		Random random = new Random();
		int scrollAttempts = random.nextInt(4) + 1; // Random number between 1 and 4
		for (int i = 0; i < scrollAttempts; i++) {
			System.out.println("Scrolling... Attempt: " + (i + 1));
			scroll(scrollElement); // Call the scroll method to perform the scroll action
			Thread.sleep(1000); // Add a delay after each scroll attempt
		}
		System.out.println("Random scroll attempts completed.");
	}

	public static void scroll(WebElement element) throws Exception {
		try {
			Dimension elementSize = element.getSize();
			Point elementLocation = element.getLocation();
			int centerX = elementLocation.x + (elementSize.width / 2);
			int startPoint = elementLocation.y + (int) (elementSize.height * 0.80); // Start point at 80% of the element's height
			int endPoint = elementLocation.y + (int) (elementSize.height * 0.20); // End point at 20% of the element's height
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence sequence = new Sequence(finger, 1);
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), centerX,
					startPoint));
			sequence.addAction(finger.createPointerDown(0));
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), centerX,
					endPoint));
			sequence.addAction(finger.createPointerUp(0));
			driver.perform(Arrays.asList(sequence)); // Perform the scroll gesture
		} catch (Exception e) {
			throw e;
		}
	}

	public static void scrollUntilElementFound(WebElement scrollElement, By targetBy) throws Exception {
		while (true) {
			try {
				WebElement targetElement = driver.findElement(targetBy); // Finds the target element.
				if (targetElement.isDisplayed()) {
					target = true;
					System.out.println("Target element found");
					Allure.step("Element Found");
					break; // Exits the loop once target element is found.
				}
			} catch (NoSuchElementException e) {
				target = false;
				System.out.println("Target element not found, scrolling...");
				Allure.step("Element not found... Continue Scrolling.");
				Thread.sleep(1000); // Adds delay between scrolls.
				scroll(scrollElement); // Scrolls the element to search for target.
			}
		}
	}

	public static void scrollUntil(WebElement scrollElement, By targetBy) throws Exception {
		while (true) {
			try {
				WebElement targetElement = driver.findElement(targetBy); // Finds the target element.
				if (targetElement.isDisplayed()) {
					target = true;
					System.out.println("Target element found");
					Allure.step("Element Found");
					break; // Exits the loop once target element is found.
				}
			} catch (NoSuchElementException e) {
				target = false;
				System.out.println("Target element not found, scrolling...");
				Allure.step("Element not found... Continue Scrolling.");
				Thread.sleep(500); // Adds delay between scrolls.
				scroll999(scrollElement); // Scrolls the element to search for target.
			}
		}
	}

	public static void scroll999(WebElement element) throws Exception {
		try {
			Dimension elementSize = element.getSize();
			Point elementLocation = element.getLocation();
			int centerX = elementLocation.x + (elementSize.width / 2);
			int startPoint = elementLocation.y + (int) (elementSize.height * 0.85); // Start point closer to bottom
			int endPoint = elementLocation.y + (int) (elementSize.height * 0.30); // End point closer to top

			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence sequence = new Sequence(finger, 1);
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(1), PointerInput.Origin.viewport(), centerX,
					startPoint));
			sequence.addAction(finger.createPointerDown(0));
			sequence.addAction(
					finger.createPointerMove(Duration.ofMillis(50), PointerInput.Origin.viewport(), centerX, endPoint)); // Faster
			sequence.addAction(finger.createPointerUp(0));
			driver.perform(Arrays.asList(sequence)); // Perform the scroll gesture
		} catch (Exception e) {
			throw new Exception("Error while scrolling: " + e.getMessage(), e);
		}
	}

	public static void scrollToExactValue(WebElement picker, String targetValue) {
		while (true) {
			String currentValue = picker.getText(); // Get the current value
			if (currentValue.equals(targetValue)) { // Check if it's the target value
				break;
			}
			((JavascriptExecutor) driver).executeScript("mobile: selectPickerWheelValue",
					Map.of("element", ((RemoteWebElement) picker).getId(), "order", "next", "offset", 0.1 // Adjust scrolling speed
					));
		}
	}

	public static void scrollEachElement(WebElement element) throws Exception {
		try {
			// Get the screen size for mobile (Android or iOS)
			org.openqa.selenium.Dimension screenSize = driver.manage().window().getSize(); // Works for mobile devices
			int screenHeight = screenSize.height;
			int screenWidth = screenSize.width;
			int scrollDistance = screenHeight / 4;
			org.openqa.selenium.Dimension elementSize = element.getSize();
			org.openqa.selenium.Point elementLocation = element.getLocation();
			int centerX = elementLocation.x + (elementSize.width / 2);
			int startPoint = elementLocation.y + (int) (elementSize.height * 0.80); // Start near the bottom (80% of the
			int endPoint = startPoint - scrollDistance; // End the scroll after 1/4th of the screen height
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence sequence = new Sequence(finger, 1);
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), centerX,
					startPoint));
			sequence.addAction(finger.createPointerDown(0));
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), centerX,
					endPoint));
			sequence.addAction(finger.createPointerUp(0));
			driver.perform(Arrays.asList(sequence));
		} catch (Exception e) {
			throw e;
		}
	}

	public static String getAdbPath() {
		String adbPath;
		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			adbPath = System.getProperty("user.home") + "\\AppData\\Local\\Android\\Sdk\\platform-tools\\adb.exe"; // Path
		} else if (System.getProperty("os.name").toLowerCase().contains("linux")) {
			adbPath = System.getProperty("user.home") + "/Android/Sdk/platform-tools/adb"; // Path for Linux
		} else {
			adbPath = System.getProperty("user.home") + "/Library/Android/sdk/platform-tools/adb"; // Path for macOS
		}
		return adbPath; // Return adb path
	}

	/*
	 * Retrieves the architecture type of the given Android emulator. Runs an ADB
	 * command to get the architecture and returns "arm64-v8a","armeabi-v7a", "x86",
	 * or "x86_64". Defaults to "x86_64" if the architecture can't be determined.
	 */
	public static String getEmulatorArch(String emulatorName) {
		System.out.printf("Getting architecture for emulator %s%n", emulatorName); // Print emulator name
		String adbPath = getAdbPath(); // Get adb path
		String[] command = new String[] { adbPath, "shell", "uname", "-m" }; // Command to get architecture
		String line = "";
		try {
			Process process = new ProcessBuilder(command).start(); // Start process
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream())); // Read process
			line = reader.readLine(); // Read first line
			process.waitFor(); // Wait for process to finish
		} catch (IOException | InterruptedException e) {
			e.printStackTrace(); // Print stack trace
			System.out.printf("Error getting architecture for emulator %s: %s%n", emulatorName, e.getMessage()); // Print
		}
		if (line == null) {
			System.out.printf("Error getting architecture for emulator %s: %s%n", emulatorName, "line is null"); // Print
			line = "x86_64"; // Default to x86_64
		}
		if (line.contains("arm64-v8a")) {
			return "arm64-v8a"; // Return arm64-v8a
		} else if (line.contains("armeabi-v7a")) {
			return "armeabi-v7a"; // Return armeabi-v7a
		} else if (line.contains("x86")) {
			return "x86"; // Return x86
		} else if (line.contains("x86_64")) {
			return "x86_64"; // Return x86_64
		} else {
			return "Unknown"; // Return unknown
		}
	}

//	 Downloads a file from the specified URL and saves it to the given destination path.
//	 Reads the file in chunks and writes it to the output file.
	public static void downloadFile(String url, String destinationPath) throws IOException, InterruptedException {
		URL apkUrl = new URL(url); // Create URL object
		try (InputStream in = apkUrl.openStream(); FileOutputStream out = new FileOutputStream(destinationPath)) {
			byte[] buffer = new byte[4096]; // Buffer for reading
			int bytesRead;
			while ((bytesRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead); // Write buffer to file
			}
		}
	}

//	 Downloads the latest staging APK based on the emulator's architecture.
//	 Waits for 10 seconds, determines the emulator's architecture, sets the appropriate APK URL,and downloads the APK to a specified destination path. Deletes any existing file at that path before downloading.
	public static void Latest_StagingAPK_download(String URL) throws InterruptedException {
		Thread.sleep(10000); // Sleep for 10 seconds
		String apkUrl = URL + "/app-armeabi-v7a-release.apk"; // Default
		String getEmulatorArch = getEmulatorArch("Pixel_6_Pro_API_31"); // Get emulator architecture
		switch (getEmulatorArch) {
		case "armeabi-v7a":
			apkUrl = URL + "/app-armeabi-v7a-release.apk"; // URL
			System.out.println("Downloading APK for armeabi-v7a architecture"); // Print message
			break;
		case "x86":
			apkUrl = URL + "/app-x86_64-release.apk"; // URL
			System.out.println("Downloading APK for x86 architecture"); // Print message
			break;
		case "x86_64":
			apkUrl = URL + "/app-x86_64-release.apk"; // URL
			System.out.println("Downloading APK for x86_64 architecture"); // Print message
			break;
		case "arm64-v8a":
			apkUrl = URL + "/app-arm64-v8a-release.apk"; // URL
			System.out.println("Downloading APK for arm64-v8a architecture"); // Print message
			break;
		default:
			System.out.println("Unknown architecture"); // Print message
			break;
		}
		String destinationPath = workspacePath + "\\Apk\\app-" + getEmulatorArch + "-release.apk"; // Destination path
		File file = new File(destinationPath); // Create file object
		if (file.exists()) {
			file.delete(); // Delete existing file
		}
		try {
			downloadFile(apkUrl, destinationPath); // Download file
			System.out.println("APK downloaded successfully."); // Print message
		} catch (IOException e) {
			System.err.println("Error downloading APK: " + e.getMessage()); // Print error
		}
	}

//	----------------------------------------------------------------------->   Signup Email Credintials
	public static String getOtpFromSource() {
		String host = "imap.gmail.com"; // Email server host
		String mailStoreType = "imap"; // Email protocol
		String username = "testmobileacs@gmail.com"; // Email username
		String password = "tdrckyprwbzwinlg"; // Email password
		try {
			Properties properties = new Properties(); // Properties for email session
			properties.put("mail.store.protocol", "imaps");
			properties.put("mail.imaps.host", host);
			properties.put("mail.imaps.port", "993");
			properties.put("mail.imaps.ssl.enable", "true");
			properties.put("mail.imaps.auth", "true");
			Session emailSession = Session.getInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
			System.out.println("Connecting to email store...");
			Store store = emailSession.getStore("imaps"); // Connect to email store
			store.connect(host, username, password); // Connect to the email server
			System.out.println("Connected to email store.");
			Allure.step("Successfully connected to the Email");
			Thread.sleep(5000);
			Folder emailFolder = store.getFolder("INBOX"); // Open the INBOX folder
			emailFolder.open(Folder.READ_ONLY); // Open the folder in read-only mode
			Allure.step("Read all the messages in 'INBOX' folder");
			Message[] messages = emailFolder.getMessages(); // Get all messages in the folder
			System.out.println(messages); // Print the messages array
			Thread.sleep(2000);
			Arrays.sort(messages, (m1, m2) -> {
				try {
					return m2.getReceivedDate().compareTo(m1.getReceivedDate());
				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}
			});
			for (Message message : messages) {
				String subject = message.getSubject(); // Get the subject of the message
				if (subject != null && subject.contains("OTP Verification")) { // Check if the subject contains "OTP
					String htmlContent = getTextFromMessage(message); // Extract the HTML content from the message
					Document doc = Jsoup.parse(htmlContent); // Parse the HTML content
					System.out.println(htmlContent);
					Elements pElements = doc
							.select("body > table > tbody > tr > td > table > tbody > tr > td > p:nth-of-type(3)");
					if (!pElements.isEmpty()) {
						Element pElement = pElements.first(); // Get the first <p> element
						OTPText = pElement.text(); // Extract the text inside the <p> element
						System.out.println("Text inside <p>gmzdmm</p>: " + OTPText); // Print the OTP text
						Allure.step("Grap the OTP from email"); // Log the step in Allure
						return OTPText; // Return the OTP text
					} else {
						System.out.println("Element not found."); // Print message if the element is not found
					}
				}
			}
			emailFolder.close(false); // Close the folder
			store.close(); // Close the store
		} catch (Exception e) {
			e.printStackTrace(); // Print the stack trace if an exception occurs
		}
		return null; // Return null if OTP is not found
	}

	private static String getTextFromMessage(Message message) throws MessagingException, IOException {
		String result = "";
		if (message.isMimeType("text/plain")) {
			result = message.getContent().toString(); // Get plain text content
		} else if (message.isMimeType("multipart/*")) {
			MimeMultipart mimeMultipart = (MimeMultipart) message.getContent(); // Get multipart content
			result = getTextFromMimeMultipart(mimeMultipart); // Extract text from multipart
		} else {
			result = message.getContent().toString(); // Get other types of content
		}
		return result; // Return the extracted text
	}

	private static String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws MessagingException, IOException {
		StringBuilder result = new StringBuilder();
		int count = mimeMultipart.getCount(); // Get the number of parts in the multipart
		for (int i = count; i > 0; i--) { // Iterate over the parts in reverse order
			BodyPart bodyPart = mimeMultipart.getBodyPart(i); // Get the current body part
			if (bodyPart.isMimeType("text/plain")) {
				result.append(bodyPart.getContent()); // Append plain text content
			} else if (bodyPart.isMimeType("text/html")) {
				String html = (String) bodyPart.getContent(); // Get HTML content
				result.append(org.jsoup.Jsoup.parse(html).text()); // Parse and append text content
			} else if (bodyPart.getContent() instanceof MimeMultipart) {
				result.append(getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent())); // Recursively extract
			}
		}
		return result.toString(); // Return the extracted text
	}

//	--------------------------------------------->    FOR   BOOKING
	public static LocalDate getMinAdvanceBookingDate(LocalDate currentDate, int minAdvanceBooking) {
		return currentDate.plusDays(minAdvanceBooking);
	}

	public static LocalDate getMaxBookingDate(LocalDate currentDate, LocalDate endDate, int minAdvanceBooking,
			int maxAdvanceBooking) {
		LocalDate minAdvanceBookingDate = currentDate.plusDays(minAdvanceBooking);
		LocalDate maxAdvanceBookingDate = minAdvanceBookingDate.plusDays(maxAdvanceBooking);
		System.out.println("Current Date: " + currentDate);
		System.out.println("End Date: " + endDate);
		System.out.println("Minimum Advance Booking Date: " + minAdvanceBookingDate);
		System.out.println("Maximum Advance Booking Date: " + maxAdvanceBookingDate);
		if (maxAdvanceBookingDate.isAfter(endDate)) {
			return endDate;
		} else {
			return maxAdvanceBookingDate;
		}
	}

	public static String getMonthName(LocalDate date) {
		Month month = date.getMonth();
		return date.getMonth().name(); // Returns the month name in uppercase (e.g., JANUARY)
	}

	public static LocalDate getRandomDate(LocalDate startDate, LocalDate endDate) {
		long startEpochDay = startDate.toEpochDay();
		long endEpochDay = endDate.toEpochDay();
		long randomEpochDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay + 1);
		return LocalDate.ofEpochDay(randomEpochDay);
	}

	public static void UpdateEmailProperty(String KeyValue) throws FileNotFoundException, IOException {
		String filePath = workspacePath + getProperty("file_path");
		File file = new File(filePath);
		List<String> fileLines = new ArrayList<>();
		String updatedValue = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.startsWith(KeyValue + "=")) {
					String baseEmail = line.substring(line.indexOf('=') + 1);
					String prefix = baseEmail.substring(0, baseEmail.indexOf('+') + 1);
					String domain = baseEmail.substring(baseEmail.indexOf('@'));
					int randomNumber = (int) (Math.random() * 10000);
					updatedValue = prefix + randomNumber + domain;
					line = KeyValue + "=" + updatedValue;
				}
				fileLines.add(line);
			}
		}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			for (String fileLine : fileLines) {
				writer.write(fileLine);
				writer.newLine();
			}
		}
		if (updatedValue != null) {
			System.out.println("Updated " + KeyValue + ": " + updatedValue);
		} else {
			System.out.println("Key not found: " + KeyValue);
		}
	}

	public static void waitForElementViewable(By element) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120)); // 120 seconds wait time
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)); // Wait until the element is clickable
		System.out.println("Find out"); // Debug message
	}

	public static void UpdateNameProperty(String KeyValue) throws FileNotFoundException, IOException {
		String filePath = workspacePath + getProperty("file_path");
		File file = new File(filePath);
		List<String> fileLines = new ArrayList<>();
		String updatedValue = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.startsWith(KeyValue + "=")) {
					String originalValue = line.substring(line.indexOf('=') + 1);
					char randomChar = (char) ('A' + new Random().nextInt(26)); // Random letter from A to Z
					updatedValue = originalValue + randomChar;
					line = KeyValue + "=" + updatedValue;
				}
				fileLines.add(line);
			}
		}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			for (String fileLine : fileLines) {
				writer.write(fileLine);
				writer.newLine();
			}
		}
		if (updatedValue != null) {
			System.out.println("Updated " + KeyValue + ": " + updatedValue);
		} else {
			System.out.println("Key not found: " + KeyValue);
		}
	}

	public static void sendEmailWithReport(String toEmail, String subject, String body, String reportPath) {
		final String fromEmail = "testmobileacs@gmail.com"; // Change with your email
		final String password = "tdrckyprwbzwinlg"; // Change with your email password
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // For Gmail
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			message.setSubject(subject);
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(body);
			MimeBodyPart attachmentPart = new MimeBodyPart();
			attachmentPart.attachFile(new File(reportPath));
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(attachmentPart);
			message.setContent(multipart);
			Transport.send(message);
			System.out.println("Email sent successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dateFormatForWorkflow(String inputDate) throws ParseException {

		SimpleDateFormat inputFormat = new SimpleDateFormat("MMM dd, yyyy");
		Date date = inputFormat.parse(inputDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		SimpleDateFormat outputFormat = new SimpleDateFormat("EEE MMM d");
		outputAssignedDate = outputFormat.format(calendar.getTime());
		System.out.println("Converted Date: " + outputAssignedDate);

	}

	public static String getContentDesc(String Content) {
		try {
			WebElement element = driver.findElement(By.xpath(Content));
			return element.getAttribute("content-desc");
		} catch (Exception e) {
			System.out.println("Error locating element or fetching content-desc: " + e.getMessage());
			return null;
		}
	}

	public static String ConvertInttoString(int number) {
		String str = String.valueOf(number);
		System.out.println("Converted String: " + str);
		return str;
	}
	
	public static  void CheckTheDateWithinRange(LocalDate fromDateString, LocalDate toDateString, LocalDate givenDate ) {

		
//		   String fromDateString = "2025-01-01";
//	        String toDateString = "2025-12-31";
//	        String givenDateString = "2025-06-18";

	        // Parse the dates
//	        LocalDate fromDate = LocalDate.parse(fromDateString);
//	        System.out.println(fromDate);
//	        LocalDate toDate = LocalDate.parse(toDateString);
//	        System.out.println(toDate);

	         

	        // Check if the given date is within the range
	        if ((givenDate.isEqual(fromDateString) || givenDate.isAfter(fromDateString)) &&
	            (givenDate.isEqual(toDateString) || givenDate.isBefore(toDateString))) {
	        	range = true;
	            System.out.println("The given date is within the range.");
	        } else {
	        	range = true;

	            System.out.println("The given date is NOT within the range.");
	        }
	}
	
	
	   public static void deleteAllEmails() {
	        String host = "imap.gmail.com"; // Email server host
	        String username = "testmobileacs@gmail.com"; // Email username
	        String password = "tdrckyprwbzwinlg"; // Email password

	        try {
	            // Set up email session properties
	            Properties properties = new Properties();
	            properties.put("mail.store.protocol", "imaps");
	            properties.put("mail.imaps.host", host);
	            properties.put("mail.imaps.port", "993");
	            properties.put("mail.imaps.ssl.enable", "true");
	            properties.put("mail.imaps.auth", "true");

	            // Authenticate and create email session
	            Session emailSession = Session.getInstance(properties, new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });

	            // Connect to the email store
	            Store store = emailSession.getStore("imaps");
	            store.connect(host, username, password);

	            // Open the inbox folder
	            Folder emailFolder = store.getFolder("INBOX");
	            emailFolder.open(Folder.READ_WRITE); // Open in read-write mode to delete emails

	            // Fetch all messages
	            Message[] messages = emailFolder.getMessages();
	            System.out.println("Total messages in INBOX: " + messages.length);

	            // Delete each message
	            for (Message message : messages) {
	                message.setFlag(Flags.Flag.DELETED, true); // Mark message for deletion
	                System.out.println("Deleted email with subject: " + message.getSubject());
	            }

	            // Close the folder and expunge deleted messages
	            emailFolder.close(true); // 'true' to expunge deleted messages
	            store.close();
	            System.out.println("All emails deleted successfully!");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	

}
