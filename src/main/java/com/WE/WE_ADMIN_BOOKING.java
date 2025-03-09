package com.WE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.Base;

import io.appium.java_client.android.AndroidDriver;

public class WE_ADMIN_BOOKING extends Base{

	public WE_ADMIN_BOOKING(AndroidDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver1, this);
	}

	@FindBy(xpath = "(//android.widget.ImageView)[1]")
	private WebElement Plus;
	public WebElement getPlus() {
		return Plus;
	}

	@FindBy(xpath = "//android.widget.ScrollView/android.view.View[2]/android.view.View/android.view.View")
	private List<WebElement> parentXPath;
	public List<WebElement> getParentXPath() {
		return parentXPath;
	}

	public String Addons = "//android.view.View[@content-desc=\"Add-Ons\"]";
	
	public static By Customer_Locator = By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty("AdminBooking_CustomerName")));

	@FindBy(xpath = "//android.widget.ImageView/android.view.View")
	private WebElement scrollview;
	public WebElement getscrollview() {
		return scrollview;
	}

	@FindBy(xpath = "//android.widget.ScrollView/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View")
	private WebElement Addons_ServicePath;
	public WebElement getAddons_ServicePath() {
		return Addons_ServicePath;
	}

	public final String Addon_Path = "//android.widget.ScrollView/android.view.View[4]/android.view.View/android.view.View";

	@FindBy(xpath = "(//android.widget.Button)[1]")
	private WebElement YesButton;
	public WebElement getYesButton() {
		return YesButton;
	}

	public static By alert_message = By.xpath("//android.view.View[@content-desc=\"Do you want to proceed with the booking despite the insufficient credits?\"]");

	@FindBy(xpath = Addon_Path)
	private List<WebElement> ADD_ON;
	public List<WebElement> getADD_ON() {
		return ADD_ON;
	}

	@FindBy(xpath = "//android.widget.SeekBar")
	private WebElement SLOT_SCROLLING_WIDGET;
	public WebElement getSLOT_SCROLLING_WIDGET() {
		return SLOT_SCROLLING_WIDGET;
	}

	public String[] Slot_Xpaths = { "//android.widget.SeekBar[@content-desc=\"Lunch Time\"]",
			"//android.widget.SeekBar[@content-desc=\"Evening\"]",
			"//android.widget.SeekBar[@content-desc=\"Afternoon\"]" };

	@FindBy(xpath = "//android.view.View[@content-desc=\"Thursday, August 29, 2024\"]")
	private WebElement date;
	public WebElement getdate() {
		return date;
	}

	@FindBy(xpath = "//android.view.View[@content-desc=\"Request Booking\"]")
	private WebElement Request_Booking;
	public WebElement getRequest_Booking() {
		return Request_Booking;
	}

	@FindBy(xpath = "//android.view.View[@content-desc=\"Book\"]")
	private WebElement Book;
	public WebElement getBook() {
		return Book;
	}

	@FindBy(xpath = "//android.widget.CheckBox")
	private WebElement Checkbox;
	public WebElement getCheckbox() {
		return Checkbox;
	}

	@FindBy(xpath = "//*[starts-with(@content-desc,'Confirm')]")
	private WebElement Confirm;
	public WebElement getConfirm() {
		return Confirm;
	}

	@FindBy(xpath = "(//android.widget.Button)[1]")
	private WebElement Yes;
	public WebElement getYes() {
		return Yes;
	}

	@FindBy(xpath = "//android.view.View[@content-desc=\"Done\"]")
	private WebElement Done;
	public WebElement getDone() {
		return Done;
	}

	@FindBy(xpath = "//android.view.View[@content-desc=\"Check Availability\"]")
	private WebElement CheckAvailability;
	public WebElement getCheckAvailability() {
		return CheckAvailability;
	}

}
