package com.frontend;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.WE.WE_Customer_Settings;
import com.baseClass.Base;

import cucumberStepDefinition.Booking;

public class Customer_Settings extends Base {


	public static void MyBookings() throws InterruptedException {
		WE_Customer_Settings mybookings = new WE_Customer_Settings(driver);
		
		ClickonElement(mybookings.getSettingsTab());
		ClickonElement(mybookings.getMyBookings());
		Thread.sleep(3000);
		By BookedDATE = By.xpath("//android.view.View[@content-desc='" + Customer_Bookingflow.Booked_Date + "']");
		System.out.println(BookedDATE);
		By BookedSLOT = By.xpath("//android.view.View[@content-desc='" + Customer_Bookingflow.Selected_Slot + "']");
		System.out.println(BookedSLOT);
		By BookedSERVICE = By.xpath("//android.view.View[@content-desc='" + Customer_Bookingflow.Booked_service + "']");
		System.out.println(BookedSERVICE);
		By BookedPAYMENT = By
				.xpath("//android.view.View[@content-desc='" + Customer_Bookingflow.BookingPaidAmount + "']");
		System.out.println(BookedPAYMENT);
		System.out.println(Customer_Bookingflow.Selected_Slot);
		if (isElementAvailable(BookedDATE) && isElementAvailable(BookedSLOT) && isElementAvailable(BookedSERVICE)
				&& isElementAvailable(BookedPAYMENT)) {
			System.out.println("Booking successfully listed on My Bookings");
		} else {
			System.out.println("Not listed");
		}
		ClickonElement(mybookings.getBackButton());
		ClickonElement(mybookings.getHomeTab());
	}

	public static void Invoices() throws InterruptedException {
		WE_Customer_Settings invoices = new WE_Customer_Settings(driver);
		
		ClickonElement(invoices.getSettingsTab());
		ClickonElement(invoices.getMyInvoices());
		Thread.sleep(8000);
		ClickonElement(invoices.getFirstInvoice());
		Thread.sleep(8000);
		By BookedSERVICE = By.xpath("//android.view.View[@content-desc='" + Customer_Bookingflow.Booked_service + "']");
		System.out.println(BookedSERVICE);
		By BookedPAYMENT1 = By.xpath(
				"//android.view.View[@content-desc='" + Customer_Bookingflow.BookingPaidAmountwithdecimal + "']");
		System.out.println(BookedPAYMENT1);
		Thread.sleep(5000);
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
		Thread.sleep(3000);
		ClickonElement(invoices.getBackButton());
		ClickonElement(invoices.getHomeTab());
	}

	public static void statement() throws Exception {
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
		ClickonElement(statement.getBackButton());
		Thread.sleep(1000);
		ClickonElement(statement.getBackButton());
	}
	
	public static  void Accounts() throws InterruptedException {
		WE_Customer_Settings statement = new WE_Customer_Settings(driver);
		
		ClickonElement(statement.getSettingsTab());
		ClickonElement(statement.getAccounts());
		Thread.sleep(10000);
		By sales = By.xpath("//android.view.View[@content-desc=\"sales\"]/following-sibling::android.view.View[@content-desc='"+"- "+""+TotalAmountWithSymbol+"']");
		System.out.println("yyy  :   "+sales);
		By payment = By.xpath("//android.view.View[@content-desc=\"Payment\"]/following-sibling::android.view.View[@content-desc='"+TotalAmountWithSymbol+"']");
		System.out.println("jjj  :   "+payment);
		if (Stripe) {
			By sales1 = By.xpath("//android.view.View[@content-desc=\"sales\"]/following-sibling::android.view.View[@content-desc='"+"- "+""+TotalAmountWithSymbol+"']");
			System.out.println("jjj  :   "+sales);
			By payment1 = By.xpath("//android.view.View[@content-desc=\"Payment\"]/following-sibling::android.view.View[@content-desc='"+TotalAmountWithSymbol+"']");
			System.out.println("hhhhh  :   "+payment1);
			if (isElementAvailable(payment)&&isElementAvailable(sales)) {
				System.out.println("Completed sales and payment  ");
			}else {
				System.out.println("hhhhhhhhhh");
			}
		}else {
			By sales12 = By.xpath("//android.view.View[@content-desc=\"sales\"]/following-sibling::android.view.View[@content-desc='"+"- "+""+TotalAmountWithSymbol+"']");
			System.out.println(sales12);
			if (isElementAvailable(sales12)) {
				System.out.println("sales done");
			}
		}
		ClickonElement(statement.getBackButton());
		ClickonElement(statement.getHomeTab());
	}
	
}
