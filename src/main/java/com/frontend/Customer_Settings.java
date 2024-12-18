package com.frontend;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.WE.WE_Customer_Settings;
import com.baseClass.Base;

public  class Customer_Settings extends Base{

	
	public static String InvoiceNumber;
	public static String  currentMonth;
	
	public static  void MyBookings() throws InterruptedException { 
		WE_Customer_Settings mybookings = new WE_Customer_Settings(driver);
		ClickonElement(mybookings.getSettingsTab());
        ClickonElement(mybookings.getMyBookings());
        Thread.sleep(3000);
        
         By BookedDATE = By.xpath("//android.view.View[@content-desc='"+ Customer_Bookingflow.Booked_Date +"']");
         System.out.println(BookedDATE);
         By BookedSLOT = By.xpath("//android.view.View[@content-desc='"+ Customer_Bookingflow.Selected_Slot + "']");
         System.out.println(BookedSLOT);
         By BookedSERVICE = By.xpath("//android.view.View[@content-desc='"+ Customer_Bookingflow.Booked_service + "']");
         System.out.println(BookedSERVICE);
         By BookedPAYMENT = By.xpath("//android.view.View[@content-desc='"+ Customer_Bookingflow.BookingPaidAmount + "']");
         System.out.println(BookedPAYMENT);
         System.out.println(Customer_Bookingflow.Selected_Slot);
        
         
         
         if (isElementAvailable(BookedDATE) && isElementAvailable(BookedSLOT) && isElementAvailable(BookedSERVICE) && isElementAvailable(BookedPAYMENT)) {
        	    System.out.println("Booking successfully listed on My Bookings");
        	} else {
        	    System.out.println("Not listed");
        	}
         
//		if (isElementAvailable(BookedDATE)) {
//			System.out.println("Booking date available");
//		}else {
//			System.out.println("hgeye");
//		}
//		if (isElementAvailable(BookedSLOT)) {
//			System.out.println("Booking slot available");
//		}else {
//			System.out.println("hgeye");
//		}
//		if (isElementAvailable(BookedSERVICE)) {
//			System.out.println("Booking service available");
//		}else {
//			System.out.println("hgeye");
//		}
//		if (isElementAvailable(BookedPAYMENT)) {
//			System.out.println("Booking payment available");
//		}else {
//			System.out.println("hgeye");
//		}
		ClickonElement(mybookings.getBackButton());
		ClickonElement(mybookings.getHomeTab());
		
		
		
	}
	
	public static  void Invoices() throws InterruptedException {

		WE_Customer_Settings invoices = new WE_Customer_Settings(driver);
		ClickonElement(invoices.getSettingsTab());
        ClickonElement(invoices.getMyInvoices());
        Thread.sleep(8000);
        ClickonElement(invoices.getFirstInvoice());
        
        By BookedSERVICE = By.xpath("//android.view.View[@content-desc='"+ Customer_Bookingflow.Booked_service + "']");
//        By BookedPAYMENT = By.xpath("//android.view.View[@content-desc='"+ Customer_Bookingflow.BookingPaidAmount + "']");
        By BookedPAYMENT1 = By.xpath("//android.view.View[@content-desc='"+ Customer_Bookingflow.BookingPaidAmountwithdecimal + "']");

//        BookingPaidAmountwithdecimal
        Thread.sleep(2000);
        if (isElementAvailable(BookedSERVICE)&& isElementAvailable(BookedPAYMENT1)) {
    	    System.out.println("Booking successfully listed on My Invoices");
			String attribute = invoices.getFindoutInvoiceNumber().getAttribute("content-desc");
			System.out.println(attribute);
		 InvoiceNumber = attribute.replace(" #", "");  // Removes '#'
			System.out.println(InvoiceNumber);
    	    
    	} else {
    	    System.out.println("Not listed");
    	}
        ClickonElement(invoices.getBackButton());
        ClickonElement(invoices.getBackButton());
        ClickonElement(invoices.getHomeTab());
	}
	
	
	public static  void statement() throws Exception 	{
		WE_Customer_Settings statement = new WE_Customer_Settings(driver);
		ClickonElement(statement.getSettingsTab());
        ClickonElement(statement.getMyStatements());
		LocalDate currentDate = LocalDate.now();
         currentMonth = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        System.out.println("Current month: " + currentMonth);
		Thread.sleep(1000);
        By Current_Month = By.xpath("//android.view.View[@content-desc='"+ currentMonth + "']");
        Thread.sleep(3000);
		clickOnElementUsingBy(Current_Month);
		 Thread.sleep(3000);
		
		 Thread.sleep(5000);
		 System.out.println(InvoiceNumber);
	        By BookedPAYMENT1 = By.xpath("//android.view.View[@content-desc='"+ InvoiceNumber + "']");
	        System.out.println(BookedPAYMENT1);
		 halfscrollUntilElementFound12(statement.getscroll(),BookedPAYMENT1 );
		 if (isElementAvailable(BookedPAYMENT1)) {
	    	    System.out.println("Booking successfully listed on My statements");
				
	    	} else {
	    	    System.out.println("Not listed");
	    	}
		 
		 
	}
	
	
}
