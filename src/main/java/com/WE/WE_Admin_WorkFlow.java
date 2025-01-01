package com.WE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.Base;
import com.frontend.Customer_Bookingflow;

import cucumberStepDefinition.Booking;
import io.appium.java_client.android.AndroidDriver;

public class WE_Admin_WorkFlow extends Base{

	
	public WE_Admin_WorkFlow(AndroidDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver1, this);
	}
	


//---------------------------------------------------------------------->       WORKFLOW  TITLE
	@FindBy (xpath ="//android.view.View[@content-desc=\"Workflow\"]")
	private WebElement   TextWORKFLOW;
	public WebElement getTextWORKFLOW() {
		return TextWORKFLOW;
	}


	@FindBy (xpath ="(//android.widget.ImageView)[1]")
	private WebElement  Title_Plus_Icon  ;
	public WebElement getTitle_Plus_Icon() {
		return  Title_Plus_Icon   ;
	}
	
	@FindBy (xpath ="(//android.widget.ImageView)[2]")
	private WebElement   Notification_Icon ;
	public WebElement getNotification_Icon() {
		return   Notification_Icon  ;
	}


	@FindBy (xpath ="(//android.widget.Button)[1]")
	private WebElement  Profile_Icon  ;
	public WebElement getProfile_Icon() {
		return    Profile_Icon ;
	}
	
	@FindBy (xpath ="//*[starts-with(@content-desc,'Pending')]")
	private WebElement   Pending_Tab ;
	public WebElement getPending_Tab() {
		return    Pending_Tab ;
	}
	
	@FindBy (xpath ="//*[starts-with(@content-desc,'Unassigned')]")
	private WebElement   Unassigned_Tab ;
	public WebElement getUnassigned_Tab() {
		return    Unassigned_Tab ;
	}
	
	@FindBy (xpath ="//*[starts-with(@content-desc,'Assigned')]")
	private WebElement   Assigned_Tab ;
	public WebElement getAssigned_Tab() {
		return    Assigned_Tab ;
	}
	
	@FindBy (xpath ="//*[starts-with(@content-desc,'Rejected')]")
	private WebElement   Rejected_Tab ;
	public WebElement getRejected_Tab() {
		return  Rejected_Tab  ;
	}
	
	@FindBy (xpath ="//android.widget.ImageView[@content-desc=\"Tab 1 of 6\"]")
	private WebElement  HOME_navigation_Bar   ;
	public WebElement getHOME_navigation_Bar() {
		return   HOME_navigation_Bar  ;
	}
	
	@FindBy (xpath ="//android.widget.ImageView[@content-desc=\"Tab 2 of 6\"]")
	private WebElement  DashBoard_navigation_Bar  ;
	public WebElement getDashBoard_navigation_Bar() {
		return    DashBoard_navigation_Bar ;
	}
	
	@FindBy (xpath ="//android.widget.ImageView[@content-desc=\"Tab 3 of 6\"]")
	private WebElement   AllBookings_navigation_Bar ;
	public WebElement getAllBookings_navigation_Bar() {
		return   AllBookings_navigation_Bar  ;
	}
	
	@FindBy (xpath ="//android.widget.ImageView[@content-desc=\"Tab 4 of 6\"]")
	private WebElement  Users_navigation_Bar  ;
	public WebElement getUsers_navigation_Bar() {
		return   Users_navigation_Bar  ;
	}
	
	@FindBy (xpath ="//android.widget.ImageView[@content-desc=\"Tab 5 of 6\"]")
	private WebElement  Services_navigation_Bar  ;
	public WebElement getServices_navigation_Bar() {
		return   Services_navigation_Bar  ;
	}
	
	@FindBy (xpath ="//android.widget.ImageView[@content-desc=\"Tab 6 of 6\"]")
	private WebElement  Settings_navigation_Bar  ;
	public WebElement getSettings_navigation_Bar() {
		return   Settings_navigation_Bar  ;
	}
	
	
//------------------------------------------------------------------------------------->    PENDING	TAB
	

	@FindBy (xpath ="//android.view.View[@content-desc=\"Service\"]")
	private WebElement   Service_Dropdown ;
	public WebElement getService_Dropdown() {
		return    Service_Dropdown ;
	}
	
	@FindBy (xpath ="//android.view.View[contains(@content-desc, 'Automate 1')]")
	private WebElement Service_Pending;
	public WebElement getService_Pending() {
		return Service_Pending;
	}
	
	@FindBy (xpath ="(//android.view.View[matches(@content-desc, '\\\\d{2}/\\\\d{2}/\\\\d{4}')])[1]")
	private WebElement Available_Date;
	public WebElement getAvailable_Date() {
		return Available_Date;
	}
	
	public static By DateExpected = By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty("DATE")));
	public static By SlotExpected = By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty("SLOT")));
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Date & Slot\"]")
	private WebElement   DateSlotDropDown ;
	public WebElement getDateSlotDropDown() {
		return   DateSlotDropDown  ;
	}
	
	@FindBy (xpath ="(//android.widget.SeekBar)[1]")
	private WebElement   Date ;
	public WebElement getDate() {
		return   Date  ;
	}
	
	@FindBy (xpath ="(//android.widget.SeekBar)[2]")
	private WebElement   Slot ;
	public WebElement getSlot() {
		return   Slot  ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Select\"]")
	private WebElement   Select ;
	public WebElement getSelect() {
		return   Select  ;
	}

	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Add-on\"]")
	private WebElement  Addon_Text  ;
	public WebElement getAddon_Text() {
		return     Addon_Text;
	}
	
	@FindBy (xpath ="(//android.widget.Switch)[1]")
	private WebElement   Addon_Toggle ;
	public WebElement getAddon_Toggle() {
		return    Addon_Toggle ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Booking time\"]")
	private WebElement   BookingTime_Text ;
	public WebElement getBookingTime_Text() {
		return   BookingTime_Text  ;
	}
	
	@FindBy (xpath ="(//android.widget.Switch)[2]")
	private WebElement   BookingTime_Toggle ;
	public WebElement getBookingTime_Toggle() {
		return    BookingTime_Toggle ;
	}
	
	@FindBy (xpath ="(//android.view.View[contains(@content-desc, 'customer_name')]/android.widget.ImageView[1])/following-sibling::android.widget.ImageView[2]")
	private WebElement   Approve ;
	public WebElement getApprove() {
		return    Approve ;
	}
	
	@FindBy (xpath ="(//android.view.View[contains(@content-desc,'customer_name')]/android.widget.ImageView[@clickable='true'])[1]")
	private WebElement   TickButton ;
	public WebElement getTickButton() {
		return    TickButton ;
	}
	
	
	public static By NoBookingYet = By.xpath(String.format("//android.view.View[contains(@content-desc, 'No bookings yet !!!')]"));

	
//------------------------------------------------------------------------>   UNASSIGNED TAB 
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Select staff\"]")
	private WebElement  Select_Staff_Dropdown  ;
	public WebElement getSelect_Staff_Dropdown() {
		return   Select_Staff_Dropdown  ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Assign Selected\"]")
	private WebElement   Assign_Selected_Button ;
	public WebElement getAssign_Selected_Button() {
		return    Assign_Selected_Button ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Partially assigned\"]")
	private WebElement  Partially_Assigned_Text   ;
	public WebElement getPartially_Assigned_Text() {
		return    Partially_Assigned_Text ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Partially assigned\"]/following-sibling::android.widget.Switch")
	private WebElement  Partially_Assigned_Toggle  ;
	public WebElement getPartially_Assigned_Toggle() {
		return   Partially_Assigned_Toggle  ;
	}
	
//---------------------------------------------------------------------->    ASSIGNED TAB
	
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Unassign\"]")
	private WebElement    Unassign_Button;
	public WebElement getUnassign_Button() {
		return    Unassign_Button ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Reassign Selected\"]")
	private WebElement   Reassign_Selected_Button ;
	public WebElement getReassign_Selected_Button() {
		return  Reassign_Selected_Button   ;
	}
	
	@FindBy (xpath ="//android.widget.ScrollView")
	private WebElement  scrollView  ;
	public WebElement getscrollView() {
		return    scrollView ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Partially assigned\"]/following-sibling::android.widget.Switch")
	private WebElement  PartiallyAssignedToggle  ;
	public WebElement getPartiallyAssignedToggle() {
		return  PartiallyAssignedToggle   ;
	}
//	
//	@FindBy (xpath ="")
//	private WebElement    ;
//	public WebElement get() {
//		return     ;
//	}
//	
//	@FindBy (xpath ="")
//	private WebElement    ;
//	public WebElement get() {
//		return     ;
//	}
//	
//	@FindBy (xpath ="")
//	private WebElement    ;
//	public WebElement get() {
//		return     ;
//	}
//	
//	@FindBy (xpath ="")
//	private WebElement    ;
//	public WebElement get() {
//		return     ;
//	}
//	
//	@FindBy (xpath ="")
//	private WebElement    ;
//	public WebElement get() {
//		return     ;
//	}
//	@FindBy (xpath ="")
//	private WebElement    ;
//	public WebElement get() {
//		return     ;
//	}
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Service\"]")
	private WebElement Service;
	// Getter method to access the "Service" WebElement
	public WebElement getService() {
		return Service;
	}

//	 Method to find the WebElement for a booked service using dynamic XPath
	public WebElement getBookedServiceLocator() {
		return driver.findElement(By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty("SERVICE_NAME"))));
	}

//	 WebElement for the "Date & Slot" view
	@FindBy(xpath = "//android.view.View[@content-desc=\"Date & Slot\"]")
	private WebElement Date_Slot;
	// Getter method to access the "Date & Slot" WebElement
	public WebElement getDate_Slot() {
		return Date_Slot;
	}

//	 Method to get the locator for a booked date using dynamic XPath
	public By getBookedDateLocator() {
		return By.xpath("//android.widget.SeekBar[contains(@content-desc,'"+outputAssignedDate+"')]");
	}
	
	@FindBy(xpath = "//android.widget.SeekBar[@content-desc=\"Wed Jun 25\"]")
	private WebElement pic;
	// Getter method to access the "Date & Slot" WebElement
	public WebElement getpic() {
		return pic;
	}
	
//	public By getBookedDateLocator() {
//		return By.xpath("");
//	}
	
	

//	 Method to get the locator for a booked slot using dynamic XPath
	public By getBookedSlotLocator() {
		return By.xpath("//android.widget.SeekBar[@content-desc='"+ Booking.Selected_Slot +"']");
	}


//	 List of WebElements for image views
	@FindBy(xpath  = "//android.widget.ImageView")
	private static List<WebElement> ImageView;
	// Static getter method to access the list of "ImageView" WebElements
	public static List<WebElement> getImageView() {
		return ImageView;
	}

//	 WebElement for the "Select staff" dropdown view
	@FindBy(xpath = "//android.view.View[@content-desc=\"Select staff\"]")
	private WebElement StaffDropDown;
	// Getter method to access the "Select staff" dropdown WebElement
	public WebElement getStaffDropDown() {
		return StaffDropDown;
	}

//	 Method to locate and return a specific staff element using dynamic XPath
	public WebElement getstafflocator() {
		return driver.findElement(By.xpath("//android.view.View[@content-desc='"+getProperty("ADMIN_STAFF_FIRST_NAME")+"']"));
	}
	
//	 Method to locate and return a specific staff element using dynamic XPath
	public WebElement getstafflocator1() {
		return driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Lily\"]"));
	}

//	 List of WebElements for unassigned image views
	@FindBy(className = "android.widget.ImageView")
	private static List<WebElement> ImageView_Unassigned;
	// Static getter method to access the list of "ImageView_Unassigned" WebElements
	public static List<WebElement> getImageView_Unassigned() {
		return ImageView_Unassigned;
	}

//	 WebElement for the "Assign Selected" button
	@FindBy(xpath = "//android.view.View[@content-desc=\"Assign Selected\"]")
	private WebElement Assign_Selected;
	// Getter method to access the "Assign Selected" WebElement
	public WebElement getAssign_Selected() {
		return Assign_Selected;
	}


//	 WebElement for the "User" tab, identified by the "Tab 3 of 6" content description
	@FindBy(xpath = "//*[starts-with(@content-desc,'Tab 4 of 6')]")
	private WebElement User;
	// Getter method to access the "User" tab WebElement
	public WebElement getUser() {
		return User;
	}

//	 WebElement for the "Show all" button in the pending request section
	@FindBy(xpath = "(//android.view.View[@content-desc=\"Show all\"])[1]")
	private WebElement PendingRequestShowall;
	// Getter method to access the "Show all" button WebElement
	public WebElement getPendingRequestShowall() {
		return PendingRequestShowall;
	}

	// WebElement for the first eye icon in the user request section
	@FindBy(xpath = "(//*[starts-with(@content-desc,'pending_request')])[1]/android.widget.ImageView[1]")
	private WebElement FirstEyeICON_UserRequest;

//	 Getter method to access the first eye icon WebElement
	public WebElement getFirstEyeICON_UserRequest() {
		return FirstEyeICON_UserRequest;
	}

//	 WebElement for the "Phone number" field
	@FindBy(xpath = "//android.view.View[@content-desc=\"Phone number \"]")
	private WebElement Phone_Number;
	// Getter method to access the "Phone number" WebElement
	public WebElement getPhone_Number() {
		return Phone_Number;
	}

//	 WebElement for the "Accept" button
	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"user_requestsAccept\"]")
	private WebElement Accept;
	// Getter method to access the "Accept" WebElement
	public WebElement getAccept() {
		return Accept;
	}

//	 WebElement for the "Confirm" button
	@FindBy(xpath = "(//android.widget.Button)[2]")
	private WebElement Confirm;
	// Getter method to access the "Confirm" WebElement
	public WebElement getConfirm() {
		return Confirm;
	}

//	 WebElement for the "Home" tab, identified by the "Tab 1 of 6" content description
	@FindBy(xpath = "//*[starts-with(@content-desc,'Tab 1 of 6')]")
	private WebElement home;
	// Getter method to access the "Home" tab WebElement
	public WebElement gethome() {
		return home;
	}

//	WebElement for the "scroll" view
	@FindBy(xpath = "//android.widget.ScrollView")
	private WebElement scrollview;
	// Getter method to access the "scroll" tab WebElement
	public WebElement getscrollview() {
		return scrollview;
	}
	
// Imageview for wait on the page	
	public static String Imageview = "//android.widget.ImageView";
//	Edit text
	@FindBy(xpath = "//android.widget.EditText")
	private WebElement EditText;
	public WebElement getEditText() {
		return EditText;
	}
	
//	For pet approval icon?
	@FindBy(xpath = "(//*[starts-with(@content-desc,'unapproved_beneficiaryemail')]/android.widget.ImageView)[3]")
	private WebElement PetApprove;
	public WebElement getPetApprove() {
		return PetApprove;
	}
	
	@FindBy(xpath = "//android.view.View[contains(@content-desc, 'unassigned_customer_name')]/android.widget.ImageView")
	private List<WebElement> ImageviewCheckbox ;
	public List<WebElement> getImageviewCheckbox() {
		return ImageviewCheckbox;
	}
	
}
