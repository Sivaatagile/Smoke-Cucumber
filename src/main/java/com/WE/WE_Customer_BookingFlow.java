package com.WE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.Base;

import io.appium.java_client.android.AndroidDriver;

public class WE_Customer_BookingFlow extends Base{
	public WE_Customer_BookingFlow(AndroidDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver1, this);
	}
	
	@FindBy (xpath ="//android.widget.ImageView[@content-desc=\"Show all\"]")
	private WebElement   ServiceShowAll ;
	public WebElement getServiceShowAll() {
		return    ServiceShowAll ;
	}
	
	@FindBy (xpath ="//android.widget.Button/following-sibling::android.view.View[1]")
	private WebElement   help ;
	public WebElement gethelp() {
		return    help ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"booking_page_label\"]/android.view.View")
	private List<WebElement> petcount   ;
	public List<WebElement> getpetcount() {
		return   petcount  ;
	}
	
	public static By ServiceBooking = By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty("SERVICE_FOR_BOOKING")));

	@FindBy (xpath ="//android.widget.ScrollView")
	private WebElement  ScrollView  ;
	public WebElement getScrollView() {
		return   ScrollView  ;
	}
	
	@FindBy (xpath ="//*[starts-with(@hint,'Search')]")
	private WebElement   SearchServices ;
	public WebElement getSearchServices() {
		return    SearchServices ;
	}
	
	private WebElement SelectService;
	public WebElement getSelectService() {
	    String dynamicXPath = String.format("//android.view.View[@content-desc='%s']", getProperty("SERVICE_NAME"));
	    SelectService = driver.findElement(By.xpath(dynamicXPath));
	    return SelectService;
	}

	@FindBy (xpath ="//android.widget.SeekBar")
	private WebElement   seekbar ;
	public   WebElement getseekbar() {
		return    seekbar ;
	}
	
	@FindBy (xpath ="//android.widget.SeekBar[1]")
	private WebElement   DatePicker ;
	public   WebElement getDatePicker() {
		return    DatePicker ;
	}
	
	@FindBy (xpath ="//android.widget.SeekBar[2]")
	private WebElement   SlotPicker ;
	public   WebElement getSlotPicker() {
		return    SlotPicker ;
	}
	
	

	@FindBy (xpath ="//android.view.View[@content-desc=\"Request Booking\"]")
	private WebElement  RequestBooking  ;
	public WebElement getRequestBooking() {
		return    RequestBooking ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Available\"]/following-sibling::android.view.View/android.view.View")
	private WebElement   serviceName ;
	public WebElement getserviceName() {
		return   serviceName  ;
	}

	@FindBy (xpath ="//android.widget.Button[@content-desc=\"Proceed\"]")
	private WebElement   proceed ;
	public WebElement getproceed() {
		return   proceed  ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Total\"]//following-sibling::android.view.View[1]")
	private WebElement   Totalamount ;
	public WebElement getTotalamount() {
		return   Totalamount  ;
	}
		
	@FindBy (xpath ="//android.widget.CheckBox")
	private WebElement  CheckBox  ;
	public WebElement getCheckBox() {
		return  CheckBox   ;
	}
	
	@FindBy (xpath ="(//android.widget.CheckBox)[2]")
	private WebElement  CheckBox2  ;
	public WebElement getCheckBox2() {
		return  CheckBox2   ;
	}
	
	@FindBy (xpath ="//android.widget.ImageView[@content-desc=\"Card\"]	")
	private WebElement  card  ;
	public WebElement getcard() {
		return  card   ;
	}
	
	@FindBy (xpath ="//android.view.View[contains(@content-desc,\"No payment methods are currently available. Please contact support.\")]")
	private WebElement  Nopayment  ;
	public WebElement getNopayment() {
		return  Nopayment   ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Use Account Balance\"]")
	private WebElement  UseAccountBalance  ;
	public WebElement getUseAccountBalance() {
		return  UseAccountBalance   ;
	}
	@FindBy (xpath ="//android.view.View[contains(@content-desc,\"Available Balance : £ \")]")
	private WebElement  UseAccountAvailableBalance  ;
	public WebElement getUseAccountAvailableBalance() {
		return  UseAccountAvailableBalance   ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Proceed to Payment\"]")
	private WebElement  proceedtopayment  ;
	public WebElement getproceedtopayment() {
		return  proceedtopayment   ;
	}
	
	@FindBy (xpath ="//android.widget.ImageView[contains(@content-desc,\"Pay Later\")]")
	private WebElement  paylater  ;
	public WebElement getpaylater() {
		return  paylater   ;
	}
	
	@FindBy (xpath ="//*[starts-with(@content-desc,'Confirm and Pay')]")
	private WebElement  ConfirmANDPay  ;
	public WebElement getConfirmANDPay() {
		return   ConfirmANDPay  ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Booking Request Successful!\"]")
	private WebElement  SuccessfullpageNavigation  ;
	public WebElement getSuccessfullpageNavigation() {
		return   SuccessfullpageNavigation  ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Amount\"]/parent::android.view.View[1]/following-sibling::android.view.View[1]/android.view.View[1]")
	private WebElement  Sucessfullpage_Amount  ;
	public WebElement getSucessfullpage_Amount() {
		return   Sucessfullpage_Amount  ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Payment Time\"]/parent::android.view.View[1]/following-sibling::android.view.View[1]/android.view.View[1]")
	private WebElement  Sucessfullpage_PaymentTime ;
	public WebElement getSucessfullpage_PaymentTime() {
		return   Sucessfullpage_PaymentTime  ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"New Booking\"]")
	private WebElement  Sucessfullpage_Newbooking ;
	public WebElement getSucessfullpage_Newbooking() {
		return   Sucessfullpage_Newbooking  ;
	}
		
	public static By slotnameindividual = By.xpath(String.format("//android.widget.SeekBar[contains(@content-desc,\"%s\")]", getProperty("Individual_slot")));

	public static By ServiceViewable = By.xpath(String.format("//android.view.View[contains(@content-desc,\"%s\")]", getProperty("SERVICE_NAME")));
	
	public static By AddonServiceViewable = By.xpath(String.format("//android.view.View[contains(@content-desc,\"%s\")]", getProperty("ADDON_SERVICE_NAME")));
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Assorted\"]")
	private WebElement  assorted ;
	public WebElement getassorted() {
		return   assorted  ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Total\"]/following-sibling::android.view.View[1]")
	private WebElement   Total_Amount ;
	public WebElement getTotal_Amount() {
		return    Total_Amount ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Remaining Credit\"]/following-sibling::android.view.View[1]")
	private WebElement   Remaining_Credit ;
	public WebElement getRemaining_Credit() {
		return    Remaining_Credit ;
	}
	
	@FindBy (xpath ="//android.widget.TextView[@text=\"Back\"]")
	private WebElement   StripeBack ;
	public WebElement getStripeBack() {
		return  StripeBack   ;
	}
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement Email;
	public WebElement getEmail() {
	    return Email;
	}
	
	@FindBy(xpath="//div[@class='SubmitButton-IconContainer']")
	private WebElement CompleteOrder;
	public WebElement getCompleteOrder() {
	    return CompleteOrder;
	}
	
	@FindBy(xpath="//input[@id='cardNumber']")
	private WebElement CardNumber;
	public WebElement getCardNumber() {
	    return CardNumber;
	}
	
	@FindBy(xpath="//input[@id='cardExpiry']")
	private WebElement CardExpiry;
	public WebElement getCardExpiry() {
	    return CardExpiry;
	}

	@FindBy(xpath="//input[@id='cardCvc']")
	private WebElement CVV;
	public WebElement getCVV() {
	    return CVV;
	}

	@FindBy(xpath="//input[@id='billingName']")
	private WebElement BillingName;
	public WebElement getBillingName() {
	    return BillingName;
	}

	@FindBy(xpath="//android.view.View[@content-desc=\"Review booking\"]")
	private WebElement ReviewBooking;
	public WebElement getReviewBooking() {
	    return ReviewBooking;
	}
	
	@FindBy(xpath="//android.widget.TextView[contains(@text,\"Crezco\")]")
	private WebElement CrezcoPayment;
	public WebElement getCrezcoPayment() {
	    return CrezcoPayment;
	}
	
	@FindBy(xpath="//android.widget.ImageView[contains(@content-desc, \"Bank Transfer\")]")
	private WebElement BankTransfer;
	public WebElement getBankTransfer() {
	    return BankTransfer;
	}
	
	@FindBy(xpath="//android.widget.Button[@text=\"Continue\"]")
	private WebElement CrezcoContinue;
	public WebElement getCrezcoContinue() {
	    return CrezcoContinue;
	}
	
	@FindBy(xpath="//android.view.View[@text=\"Crezco Sandbox - GB\"]")
	private WebElement CrezcoSandbox;
	public WebElement getCrezcoSandbox() {
	    return CrezcoSandbox;
	}
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"submit\"]")
	private WebElement CrezcoSubmit;
	public WebElement getCrezcoSubmit() {
	    return CrezcoSubmit;
	}
	
	@FindBy(xpath="//android.view.View[@content-desc=\"Confirm booking details\"]")
	private WebElement ConfirmBookingDetails;
	public WebElement getConfirmBookingDetails() {
	    return ConfirmBookingDetails;
	}
	
	public static By PremiumPricingRuleName = By.xpath(String.format("//android.view.View[contains(@content-desc,\"%s\")]", getProperty("Pricingrulename_Onetime_premium")));

	public static By DiscountPricingRuleName = By.xpath(String.format("//android.view.View[contains(@content-desc,\"%s\")]", getProperty("Pricingrulename_Onetime_discount")));
	
	@FindBy(xpath="//android.view.View[@content-desc=\"Add-Ons\"]")
	private WebElement Addons;
	public WebElement getAddons() {
	    return Addons;
	}

	
	public static By PrivilegeAddon = By.xpath(String.format("//android.view.View[contains(@content-desc,\"%s\")]", getProperty("ADDON_PRIVILAGE")));

	public static By AssignableAddon = By.xpath(String.format("//android.view.View[contains(@content-desc,\"%s\")]", getProperty("ADDON_ASSIGNABLE")));

	private WebElement SelectAddonService;
	public WebElement getSelectAddonService() {
	    String dynamicXPath = String.format("//android.view.View[@content-desc='%s']", getProperty("ADDON_SERVICE_NAME"));
	    SelectService = driver.findElement(By.xpath(dynamicXPath));
	    return SelectService;
	}
}
