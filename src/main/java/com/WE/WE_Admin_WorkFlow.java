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
	
	@FindBy (xpath ="//android.widget.SeekBar")
	private WebElement   Slot ;
	public WebElement getSlot() {
		return   Slot  ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Select\"]")
	private WebElement   Select ;
	public WebElement getSelect() {
		return   Select  ;
	}
	
	@FindBy (xpath ="//android.widget.ImageView[contains(@content-desc,\"start_date\")]")
	private WebElement   datefilter ;
	public WebElement getdatefilter() {
		return   datefilter  ;
	}
	
	@FindBy (xpath ="//android.widget.Button[@content-desc=\"Done\"]")
	private WebElement   DoneButton ;
	public WebElement getDoneButton() {
		return   DoneButton  ;
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
	
	@FindBy (xpath ="(//android.view.View[contains(@content-desc,'customer_name')]/android.widget.ImageView[@clickable='true'])[2]")
	private WebElement   RejectButton ;
	public WebElement getRejectButton() {
		return    RejectButton ;
	}
	
	@FindBy (xpath ="//android.widget.Button[2]")
	private WebElement   Reject ;
	public WebElement getReject() {
		return    Reject ;
	}
	
	public By getBookeddate() {
		System.out.println(Booking.Selected_Slot);
		return By.xpath("//android.widget.SeekBar[@content-desc=\"Thu May 22\"]");
	}
	
	public static By NoBookingYet = By.xpath(String.format("//android.view.View[contains(@content-desc, 'No bookings yet !!!')]"));

	public static By date123 = By.xpath(String.format("//android.widget.SeekBar[@content-desc=\"Thu May 22\"]"));

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
	
	public static By StaffLocator = By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty("ADMIN_STAFF_FIRST_NAME")));
	
	public static By ServiceLocator  = By.xpath(String.format("(//android.view.View[@content-desc=\"%s\"])[2]", getProperty("SERVICE_NAME")));

	public static By SecondStaffLocator = By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty("ADMIN_STAFF_2_FIRST_NAME")));

	@FindBy (xpath ="((//android.view.View[contains(@content-desc,\"staff_assigned\")])[1]/android.widget.ImageView)[last()]")
	private WebElement  CheckBoxAssigned  ;
	public WebElement getCheckBoxAssigned() {
		return   CheckBoxAssigned  ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Reassign Selected\"]")
	private WebElement  ReassignSelected  ;
	public WebElement getReassignSelected() {
		return   ReassignSelected  ;
	}
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"All Services\"]")
	private WebElement Service;
	public WebElement getService() {
		return Service;
	}

	public WebElement getBookedServiceLocator() {
		return driver.findElement(By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty("SERVICE_NAME"))));
	}

	@FindBy(xpath = "//android.view.View[@content-desc=\"Date & Slot\"]")
	private WebElement Date_Slot;
	public WebElement getDate_Slot() {
		return Date_Slot;
	}

	@FindBy(xpath = "//android.view.View[@content-desc=\"All Slots\"]")
	private WebElement Allslots;
	public WebElement getAllslots() {
		return Allslots;
	}
		
	@FindBy(xpath = "//android.widget.SeekBar[@content-desc=\"Wed Jun 25\"]")
	private WebElement pic;
	public WebElement getpic() {
		return pic;
	}
	
	public By getBookedSlotLocator() {
		System.out.println(Selected_Slot);
		return By.xpath("//android.widget.SeekBar[@content-desc='"+ Selected_Slot +"']");
	}

	@FindBy(xpath  = "//android.widget.ImageView")
	private static List<WebElement> ImageView;
	public static List<WebElement> getImageView() {
		return ImageView;
	}

	@FindBy(xpath = "//android.view.View[@content-desc=\"Select staff\"]")
	private WebElement StaffDropDown;
	public WebElement getStaffDropDown() {
		return StaffDropDown;
	}

	public WebElement getstafflocator() {
		return driver.findElement(By.xpath("//android.view.View[@content-desc='"+getProperty("ADMIN_STAFF_FIRST_NAME")+"']"));
	}
	
	public WebElement getstafflocator1() {
		return driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Lily\"]"));
	}

	@FindBy(className = "android.widget.ImageView")
	private static List<WebElement> ImageView_Unassigned;
	public static List<WebElement> getImageView_Unassigned() {
		return ImageView_Unassigned;
	}

	@FindBy(xpath = "//android.view.View[@content-desc=\"Assign Selected\"]")
	private WebElement Assign_Selected;
	public WebElement getAssign_Selected() {
		return Assign_Selected;
	}

	@FindBy(xpath = "//*[starts-with(@content-desc,'Tab 4 of 6')]")
	private WebElement User;
	public WebElement getUser() {
		return User;
	}

	@FindBy(xpath = "(//android.view.View[@content-desc=\"Show all\"])[1]")
	private WebElement PendingRequestShowall;
	public WebElement getPendingRequestShowall() {
		return PendingRequestShowall;
	}

	@FindBy(xpath = "(//*[starts-with(@content-desc,'pending_request')])[1]/android.widget.ImageView[1]")
	private WebElement FirstEyeICON_UserRequest;
	public WebElement getFirstEyeICON_UserRequest() {
		return FirstEyeICON_UserRequest;
	}

	@FindBy(xpath = "//android.view.View[@content-desc=\"Phone number \"]")
	private WebElement Phone_Number;
	public WebElement getPhone_Number() {
		return Phone_Number;
	}

	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"user_requestsAccept\"]")
	private WebElement Accept;
	public WebElement getAccept() {
		return Accept;
	}

	@FindBy(xpath = "(//android.widget.Button)[2]")
	private WebElement Confirm;
	public WebElement getConfirm() {
		return Confirm;
	}

	@FindBy(xpath = "//*[starts-with(@content-desc,'Tab 1 of 6')]")
	private WebElement home;
	public WebElement gethome() {
		return home;
	}

	@FindBy(xpath = "//android.widget.ScrollView")
	private WebElement scrollview;
	public WebElement getscrollview() {
		return scrollview;
	}
	
	public static String Imageview = "//android.widget.ImageView";
	
	@FindBy(xpath = "//android.widget.EditText")
	private WebElement EditText;
	public WebElement getEditText() {
		return EditText;
	}
	
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
	
//	@FindBy (xpath ="")
//	private WebElement    ;
//	public WebElement get() {
//		return     ;
	
}
