package com.frontend;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.WE.WE_Admin_Services;
import com.WE.WE_Admin_Services.AddOnType;
import com.WE.WE_Info;
import com.api.Api;
import com.baseClass.Base;
import com.baseClass.Base.API_BASE_URL;

public class Admin_Services extends Base {

	public static void slot_creation() throws Exception {
		WE_Admin_Services slot = new WE_Admin_Services(driver);
		WE_Info info = new WE_Info(driver);

		ClickonElement(slot.getservice_Tab());
		ClickonElement(slot.getSlot_Showall());
		Thread.sleep(3000);
		ClickonElement(slot.getfab());
		Thread.sleep(3000);
		ClickonElement(slot.getSlotName());
		Thread.sleep(3000);
		passInput(slot.getSlotName(), getProperty("SLOT_NAME"));
		driver.hideKeyboard();
		Thread.sleep(3000);
		ClickonElement(slot.getDescriptionTextBox());
		passInput(slot.getDescriptionTextBox(), getProperty("SLOT_DESCRIPTION"));
		driver.hideKeyboard();
		Thread.sleep(3000);
		ClickonElement(slot.getStartTime());
		Thread.sleep(3000);
		scrollUntilElementFound_DatePicker_Time(slot.getHours(), slot.HoursExpected);
		Thread.sleep(3000);
		scrollUntilElementFound_DatePicker_Time(slot.getMinutes(), slot.MinutesExpected);
		Thread.sleep(3000);
		scrollUntilElementFound_DatePicker_Time(slot.getSession(), slot.SessionExpected);
		Thread.sleep(3000);
		ClickonElement(slot.getSelect());
		ClickonElement(slot.getSave());
		if (isElementAvailable(slot.getOKbutton())) {
			ClickonElement(slot.getOKbutton());
		}
		ClickonElement(info.getBackButton());

	}

	public static void selectSlot(List<String> slotList) throws Exception {
		WE_Admin_Services Service = new WE_Admin_Services(driver);
		
		Collections.reverse(slotList);
		WebElement Firstslot = driver
				.findElement(By.xpath("//android.view.View[@content-desc='" + slotList.get(0) + "']"));
		ClickonElement(Firstslot);
		for (String slot : slotList) {
			boolean isSlotFound = false;
			while (!isSlotFound) {
				try {
					// Construct the dynamic XPath or locator for the slot
					WebElement slotElement = driver
							.findElement(By.xpath("//android.view.View[@content-desc='" + slot + "']"));
					// Click on the slot if found
					slotElement.click();
					isSlotFound = true;
					System.out.println("Slot clicked: " + slot);
				} catch (NoSuchElementException e) {
					// Slot not found, perform scroll action
					System.out.println("Slot not found, scrolling...");
					slowScroll();
//					halfscroll(Service.getscrollview());
				}
			}
		}
	}

	public static void ServiceCreation() throws Exception {
		WE_Admin_Services Service = new WE_Admin_Services(driver);
		WE_Info info = new WE_Info(driver);
		Api api = new Api(driver);

		ClickonElement(Service.getservice_Tab());
		ClickonElement(Service.getService_Showall());
		Thread.sleep(3000);
		ClickonElement(Service.getFab_Service());
		ClickonElement(Service.getService());
		ClickonElement(Service.getService_name());
		passInput(Service.getService_name(), getProperty("SERVICE_NAME"));
		driver.hideKeyboard();
		Thread.sleep(3000);
		ClickonElement(Service.getDescription_textbox());
		passInput(Service.getDescription_textbox(), getProperty("SERVICE_DESCRIPTION"));
		driver.hideKeyboard();
		Thread.sleep(3000);
		api.OverallSlotList();
		selectSlot(api.slotNames);
		Thread.sleep(5000);
		
		slowscrolluntilelementfound(Service.getFirstElement());
		ClickonElement(Service.getFirstElement());
		passInput(Service.getFirstElement(), getProperty("BASE_PRICE_AMOUNT"));
		driver.hideKeyboard();
		Thread.sleep(2000);
		slowscrolluntilelementfound(Service.getFourthElement());
		int BasePrice_size = Service.getBaseprice().size();
		System.out.println("size of Base list  : " + BasePrice_size);
		Thread.sleep(3000);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(3000);
			Service.getBaseprice().get(i).click();
			Thread.sleep(5000);
			passInput(Service.getBaseprice().get(i), getProperty("BASE_PRICE_AMOUNT"));
			driver.hideKeyboard();
			Thread.sleep(3000);
		}

		ClickonElement(Service.getMaximum_capacity());
		passInput(Service.getMaximum_capacity(), getProperty("MAX_CAPACITY_SLOT"));
		driver.hideKeyboard();

		ClickonElement(Service.getMaximum_capacity_Per_Staff());
		passInput(Service.getMaximum_capacity_Per_Staff(), getProperty("MAX_CAPACITY_STAFF"));
		driver.hideKeyboard();

		slowscrolluntilelementfound(Service.getMax_Advance_Booking_Limit());
		ClickonElement(Service.getMax_Advance_Booking_Limit());
		passInput(Service.getMax_Advance_Booking_Limit(), getProperty("MAX_ADVANCE_BOOKING_LIMIT"));
		driver.hideKeyboard();

		ClickonElement(Service.getFrom_DateDetails());
		waitForElement(Service.getFrom());
		String From_Month = Service.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + From_Month);
		String From_Date = Service.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + From_Date);
		String From_Year = Service.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + From_Year);
		Thread.sleep(4000);
		ClickonElement(Service.getSelect1());

		Thread.sleep(2000);
		ClickonElement(Service.getTo_DateDetails());
		waitForElement(Service.getTo());
		scrollUntilElementFound12(Service.getMonth(), Service.ToMonthExpected);
		String To_Month = Service.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + To_Month);
		scrollUntilElementFound12(Service.getDate(), Service.ToDateExpected);
		String To_Date = Service.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + To_Date);
		scrollUntilElementFound12(Service.getYear(), Service.ToYearExpected);
		String To_Year = Service.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + To_Year);
		Thread.sleep(2000);
		ClickonElement(Service.getSelect1());
		Thread.sleep(2000);
		ClickonElement(Service.getService_Save());
		ClickonElement(info.getBackButton());

	}

	public static void AddonCreation(AddOnType addOnType , String AddonName) throws Exception {
		WE_Info info = new WE_Info(driver);
		WE_Admin_Services Addon = new WE_Admin_Services(driver);
		Api api = new Api(driver);
		ClickonElement(Addon.getservice_Tab());
		ClickonElement(Addon.getService_Showall());
		Thread.sleep(3000);
		ClickonElement(Addon.getFab_Service());
		ClickonElement(Addon.getAddon());
		ClickonElement(Addon.getAddon_name());
		passInput(Addon.getAddon_name(), AddonName);
		driver.hideKeyboard();

		ClickonElement(Addon.getAddon_Description_textbox());
		passInput(Addon.getAddon_Description_textbox(), getProperty("ADDON_DESCRIPTION"));
		driver.hideKeyboard();

		Addon.toggleAddOn(addOnType);

		Thread.sleep(3000);
		api.OverallSlotList();
		selectSlot(api.slotNames);
		Thread.sleep(5000);
		
		slowscrolluntilelementfound(Addon.getFirstElement());
		ClickonElement(Addon.getFirstElement());
		passInput(Addon.getFirstElement(), getProperty("ADDON_BASE_PRICE_AMOUNT"));
        driver.hideKeyboard();

        slowscrolluntilelementfound(Addon.getFourthElement());
		int BasePrice_size = Addon.getBaseprice().size();
		System.out.println("size of Base list  : " + BasePrice_size);
		Thread.sleep(3000);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(3000);
			Addon.getBaseprice().get(i).click();
			Thread.sleep(5000);
			passInput(Addon.getBaseprice().get(i), getProperty("ADDON_BASE_PRICE_AMOUNT"));
			driver.hideKeyboard();
			Thread.sleep(3000);
		}
		
		waitForElement(Addon.getcapacityType());
		ClickonElement(Addon.getFixed());

		ClickonElement(Addon.getAddon_Maximum_capacity());
		ClearonElement(Addon.getAddon_Maximum_capacity());
		passInput(Addon.getAddon_Maximum_capacity(), getProperty("ADDON_MAX_CAPACITY_SLOT"));
		driver.hideKeyboard();

		ClickonElement(Addon.getAddon_Maximum_capacity_Per_Staff());
		passInput(Addon.getAddon_Maximum_capacity_Per_Staff(), getProperty("ADDON_MAX_CAPACITY_STAFF"));
		driver.hideKeyboard();

		halfscrollUntilElementFound12(Addon.getscrollview(), Addon.getFrom_To_DateDetails());

		ClickonElement(Addon.getFrom_DateDetails());
		waitForElement(Addon.getFrom());
		String From_Month = Addon.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + From_Month);
		String From_Date = Addon.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + From_Date);
		String From_Year = Addon.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + From_Year);
		Thread.sleep(4000);
		ClickonElement(Addon.getSelect1());

		Thread.sleep(2000);
		ClickonElement(Addon.getTo_DateDetails());
		waitForElement(Addon.getTo());
		scrollUntilElementFound12(Addon.getMonth(), Addon.ToMonthExpected);
		String To_Month = Addon.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + To_Month);
		scrollUntilElementFound12(Addon.getDate(), Addon.ToDateExpected);
		String To_Date = Addon.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + To_Date);
		scrollUntilElementFound12(Addon.getYear(), Addon.ToYearExpected);
		String To_Year = Addon.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + To_Year);
		Thread.sleep(2000);
		ClickonElement(Addon.getSelect1());
		Thread.sleep(2000);
		ClickonElement(Addon.getService_Save());
		ClickonElement(info.getBackButton());

	}
	public static void main(String[] args) throws Exception {
		method1("First");
		Latest_StagingAPK_download(getProperty("STAGING"));
		Application();
		ChooseApi(API_BASE_URL.Staging);
		Api.signInAdmin(getProperty("PREDEFINED_ADMIN_EMAIL"));
		Api.verifyOtp(getProperty("PREDEFINED_ADMIN_OTP"));
		Api.OverallSlotList();
		Login_Details.login_Admin();
//		slot_creation();
		ServiceCreation();
		AddonCreation(AddOnType.ASSIGNABLE,getProperty("ADDON_ASSIGNABLE") );
		AddonCreation(AddOnType.PRIVILEGE,getProperty("ADDON_PRIVILAGE") );

		
	
	}
	


}
