package com.frontend;

import com.WE.WE_Admin_User;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Customer_BookingFlow;
import com.WE.WE_Customer_Details;
import com.WE.WE_Customer_Settings;
import com.WE.WE_Info;
import com.baseClass.Base;

public class Customer_Home extends Base {

	
	public static  void Customer_Add_pet() throws Exception {
		WE_Customer_BookingFlow booking = new WE_Customer_BookingFlow(driver);
		WE_Customer_Details CustomerDetails = new WE_Customer_Details(driver);
    	WE_Customer_Settings settings = new WE_Customer_Settings(driver);
		WE_Admin_User user = new WE_Admin_User(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		WE_Info info = new WE_Info(driver);

		waitForElement(booking.getassorted());
		ClickonElement(CustomerDetails.getCustomerProfile());
		ClickonElement(CustomerDetails.getMyPet());
		ClickonElement(CustomerDetails.getFAB());
		Info.Pet_Data();
		Thread.sleep(1000);
		ClickonElement(settings.getBackButton());
		Thread.sleep(2000);
		ClickonElement(settings.getHomeTab());
	}
	
	
	
	
	
}
