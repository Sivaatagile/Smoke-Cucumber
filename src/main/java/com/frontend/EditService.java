package com.frontend;

import com.WE.WE_Admin_Services;
import com.WE.WE_Info;
import com.baseClass.Base;

public class EditService extends Base{
	
public static  void EditSlot() throws InterruptedException {

	WE_Admin_Services slot = new WE_Admin_Services(driver);
	WE_Info info = new WE_Info(driver);

	ClickonElement(slot.getservice_Tab());
	ClickonElement(slot.getSlot_Showall());
	
	ClickonElement(slot.getSearchBox());
	passInput(slot.getSearchBox(), getProperty("SLOT_NAME"));
	driver.hideKeyboard();
	
	clickOnElementUsingBy(slot.ExpectedSlot);
	ClickonElement(slot.getSlotEditICON());
	Thread.sleep(3000);
	ClickonElement(slot.getDescriptionTextBox());
	ClearonElement(slot.getDescriptionTextBox());
	passInput(slot.getDescriptionTextBox(), "Edited description");
	driver.hideKeyboard();
	
	ClickonElement(slot.getSave());
	if (isElementAvailable(slot.getOKbutton())) {
		ClickonElement(slot.getOKbutton());
	}
	ClickonElement(info.getBackButton());
	
}
	
	
}
