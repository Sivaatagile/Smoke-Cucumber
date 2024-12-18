package com.WE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.Base;

import io.appium.java_client.android.AndroidDriver;

public class WE_Admin_Services extends Base{
	public WE_Admin_Services(AndroidDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver1, this);
	}
	
//	------------------------->   SLOT    -----------------------------------------------------------------------------------------------------------------------------
	@FindBy (xpath ="//android.widget.ImageView[@content-desc=\"Tab 5 of 6\"]")
	private WebElement   service_Tab ;
	public WebElement getservice_Tab() {
		return     service_Tab;
	}
	
	@FindBy (xpath ="(//*[starts-with(@content-desc,'Show all')])[2]")
	private WebElement   Slot_Showall ;
	public WebElement getSlot_Showall() {
		return   Slot_Showall  ;
	}
	
	@FindBy (xpath ="(//android.widget.Button)[2]")
	private WebElement  fab   ;
	public WebElement getfab() {
		return    fab ;
	}
	
	@FindBy (xpath ="//*[starts-with(@hint,'Name')]")
	private WebElement   SlotName ;
	public WebElement getSlotName() {
		return    SlotName ;
	}
	
	@FindBy (xpath ="//*[starts-with(@content-desc,'Description')]/following-sibling::android.widget.EditText")
	private WebElement   DescriptionTextBox ;
	public WebElement getDescriptionTextBox() {
		return    DescriptionTextBox ;
	}
	
	@FindBy (xpath ="//*[starts-with(@hint,'Start')]")
	private WebElement  StartTime  ;
	public WebElement getStartTime() {
		return    StartTime ;
	}
	
	@FindBy (xpath ="//android.widget.SeekBar[1]")
	private WebElement  Hours  ;
	public WebElement getHours() {
		return    Hours ;
	}
	
	@FindBy (xpath ="//android.widget.SeekBar[2]")
	private WebElement   Minutes ;
	public WebElement getMinutes() {
		return  Minutes  ;
	}
	
	@FindBy (xpath ="//android.widget.SeekBar[3]")
	private WebElement  Session  ;
	public WebElement getSession() {
		return   Session  ;
	}
	
	public static By HoursExpected = By.xpath(String.format("//android.widget.SeekBar[@content-desc=\"%s\"]", getProperty("HOUR")));
	
	public static By MinutesExpected = By.xpath(String.format("//android.widget.SeekBar[@content-desc=\"%s\"]", getProperty("MINUTE")));
	
	public static By SessionExpected = By.xpath(String.format("//android.widget.SeekBar[@content-desc=\"%s\"]", getProperty("SESSION")));
	

	@FindBy (xpath ="//android.view.View[@content-desc=\"Select\"]")
	private WebElement    Select;
	public WebElement getSelect() {
		return   Select  ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Save\"]")
	private WebElement  Save  ;
	public WebElement getSave() {
		return    Save ;
	}
	
	
//	------------------------------------------------------> SERVICE CREATION
	
	@FindBy (xpath ="(//*[starts-with(@content-desc,'Show all')])[1]")
	private WebElement   Service_Showall ;
	public WebElement getService_Showall() {
		return     Service_Showall;
	}
	
	@FindBy (xpath ="(//android.widget.Button)[2]")
	private WebElement  Fab_Service ;
	public WebElement getFab_Service() {
		return    Fab_Service ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Service\"]")
	private WebElement   Service ;
	public WebElement getService() {
		return    Service ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Add-on\"]")
	private WebElement   Addon ;
	public WebElement getAddon() {
		return   Addon  ;
	}
	
	@FindBy (xpath ="//*[starts-with(@hint,'Name')]")
	private WebElement  Service_name  ;
	public WebElement getService_name() {
		return   Service_name  ;
	}
	
	@FindBy (xpath ="//*[starts-with(@content-desc,'Description')]/following-sibling::android.widget.EditText")
	private WebElement   Description_textbox ;
	public WebElement getDescription_textbox() {
		return   Description_textbox  ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Morning\"]")
	private WebElement  Individual_slotName  ;
	public WebElement getIndividual_slotName() {
		return   Individual_slotName  ;
	}
	@FindBy (xpath ="//*[starts-with(@content-desc,'Time Slot')]/following-sibling::*[starts-with(@content-desc,'multiselect')]/android.view.View")
	private List<WebElement> Slot_list   ;
	public List<WebElement> getSlot_list() {
		return   Slot_list  ;
	}

	
	
	@FindBy (xpath ="//*[starts-with(@content-desc,'Base Price')]/following-sibling::*[starts-with(@content-desc,'pet_label_Price')]/following-sibling::android.widget.EditText")
	private List<WebElement>  Baseprice  ;
	public List<WebElement> getBaseprice() {
		return   Baseprice  ;
	}
	
	
	
	@FindBy (xpath ="(//*[starts-with(@content-desc,'Maximum capacity')]/following-sibling::android.widget.EditText)[1]")
	private WebElement  Maximum_capacity  ;
	public WebElement getMaximum_capacity() {
		return  Maximum_capacity   ;
	}
	
	@FindBy (xpath ="(//*[starts-with(@content-desc,'Maximum capacity per staff')]/following-sibling::android.widget.EditText)[1]")
	private WebElement  Maximum_capacity_Per_Staff   ;
	public WebElement getMaximum_capacity_Per_Staff() {
		return   Maximum_capacity_Per_Staff  ;
	}
	
	@FindBy (xpath ="//*[starts-with(@content-desc,'Maximum advance booking limit')]/following-sibling::android.widget.EditText")
	private WebElement  Max_Advance_Booking_Limit  ;
	public WebElement getMax_Advance_Booking_Limit() {
		return  Max_Advance_Booking_Limit   ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"From\"]")
	private WebElement   From ;
	public WebElement getFrom() {
		return   From  ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"To\"]")
	private WebElement   To ;
	public WebElement getTo() {
		return   To  ;
	}
	
	@FindBy (xpath ="(//android.widget.SeekBar)[1]")
	private WebElement  Month  ;
	public WebElement getMonth() {
		return    Month ;
	}
	
	@FindBy (xpath ="(//android.widget.SeekBar)[2]")
	private WebElement  Date  ;
	public WebElement getDate() {
		return    Date ;
	}
	
	@FindBy (xpath ="(//android.widget.SeekBar)[3]")
	private WebElement   Year ;
	public WebElement getYear() {
		return    Year ;
	}
	
	@FindBy (xpath ="//*[starts-with(@content-desc,'Availability')]/following-sibling::android.widget.Switch/following-sibling::android.view.View[1]")
	private WebElement  From_DateDetails  ;
	public WebElement getFrom_DateDetails() {
		return   From_DateDetails  ;
	}
	
	@FindBy (xpath ="//*[starts-with(@content-desc,'Availability')]/following-sibling::android.widget.Switch/following-sibling::android.view.View[3]")
	private WebElement   To_DateDetails ;
	public WebElement getTo_DateDetails() {
		return  To_DateDetails   ;
	}
	
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Save\"]")
	private WebElement  Service_Save  ;
	public WebElement getService_Save() {
		return   Service_Save  ;
	}
	
	@FindBy (xpath ="//android.widget.ScrollView")
	private WebElement   scrollview ;
	public WebElement getscrollview() {
		return    scrollview ;
	}
	
	@FindBy (xpath ="(//*[starts-with(@content-desc,'Base Price')]/following-sibling::*[starts-with(@content-desc,'pet_label_Price')]/following-sibling::android.widget.EditText[4])[1]")
	private WebElement  FourthElement  ;
	public WebElement getFourthElement() {
		return  FourthElement   ;
	}
	
	public static By ToMonthExpected = By.xpath(String.format("//android.widget.SeekBar[@content-desc=\"%s\"]", getProperty("TO_Month")));
	
	public static By ToDateExpected = By.xpath(String.format("//android.widget.SeekBar[@content-desc=\"%s\"]", getProperty("TO_Date")));
	
	public static By ToYearExpected = By.xpath(String.format("//android.widget.SeekBar[@content-desc=\"%s\"]", getProperty("TO_Year")));
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Select\"]")
	private WebElement   Select1 ;
	public WebElement getSelect1() {
		return   Select1  ;
	}
	
//	---------------------------------------> ADDON
	
	
	@FindBy (xpath ="//*[starts-with(@content-desc,'Assignable')]/following-sibling::android.view.View[1]")
	private static WebElement   Addon_Toggle ;
	public static  WebElement getAddon_Toggle() {
		return    Addon_Toggle ;
	}
	
	public static enum AddOnType {
	    ASSIGNABLE,
	    PRIVILEGE
	}
	
	 public static void toggleAddOn(AddOnType addOnType) {
	        switch (addOnType) {
	            case ASSIGNABLE:
	               
	                break;
	            case PRIVILEGE:
	            	ClickonElement(getAddon_Toggle());
	                break;
	            default:
	                throw new IllegalArgumentException("Invalid add-on type: " + addOnType);
	        } 
	 }
	 
	 @FindBy (xpath ="//*[starts-with(@hint,'Name')]")
	private WebElement  Addon_name  ;
	public WebElement getAddon_name() {
		return   Addon_name  ;
	}
	
	@FindBy (xpath ="//*[starts-with(@content-desc,'Description')]/following-sibling::android.widget.EditText")
	private WebElement   Addon_Description_textbox ;
	public WebElement getAddon_Description_textbox() {
		return   Addon_Description_textbox  ;
	}
	
	
	@FindBy (xpath ="(//*[starts-with(@content-desc,'Maximum capacity')]/following-sibling::android.widget.EditText)[1]")
	private WebElement  Addon_Maximum_capacity  ;
	public WebElement getAddon_Maximum_capacity() {
		return  Addon_Maximum_capacity   ;
	}
	
	@FindBy (xpath ="(//*[starts-with(@content-desc,'Maximum capacity per staff')]/following-sibling::android.widget.EditText)[1]")
	private WebElement  Addon_Maximum_capacity_Per_Staff   ;
	public WebElement getAddon_Maximum_capacity_Per_Staff() {
		return   Addon_Maximum_capacity_Per_Staff  ;
	}
	
	@FindBy (xpath ="//*[starts-with(@content-desc,'Maximum advance booking limit')]/following-sibling::android.widget.EditText")
	private WebElement  Addon_Max_Advance_Booking_Limit  ;
	public WebElement getAddon_Max_Advance_Booking_Limit() {
		return  Addon_Max_Advance_Booking_Limit   ;
	}
	
}
