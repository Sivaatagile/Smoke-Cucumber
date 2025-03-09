package com.WE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.Base;

import io.appium.java_client.android.AndroidDriver;

public class WE_Admin_User extends  Base{

	public WE_Admin_User(AndroidDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver1, this);
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"All Administrators\"]/following-sibling::android.widget.Button[1]")
	private WebElement    Showall_AllAdmin;
	public WebElement getShowall_AllAdmin() {
		return   Showall_AllAdmin  ;
	}
	
	@FindBy (xpath ="//*[starts-with(@content-desc,'Phone Number')]/following-sibling::android.widget.EditText[1]")
	private WebElement   PhoneNumber ;
	public WebElement getPhoneNumber() {
		return   PhoneNumber  ;
	}
	
	@FindBy (xpath ="//*[starts-with(@content-desc,'Phone number')]/following-sibling::android.widget.EditText[1]")
	private WebElement   Phonenumber ;
	public WebElement getPhonenumber() {
		return   Phonenumber  ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Save\"]")
	private WebElement    Save;
	public WebElement getSave() {
		return  Save   ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Country\"]/android.view.View/android.view.View/android.view.View")
	private WebElement   CountryName ;
	public WebElement getCountryName() {
		return   CountryName  ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"All Customers\"]")
	private WebElement  AllCustomers;
	public WebElement getAllCustomers() {
		return AllCustomers;
	}

	@FindBy (xpath ="(//android.widget.Button)[2]")
	private WebElement  FAB  ;
	public WebElement getFAB() {
		return   FAB  ;
	}
	
	@FindBy (xpath ="//*[starts-with(@hint,'First Name')]")
	private WebElement  FirstName  ;
	public WebElement getFirstName() {
		return     FirstName;
	}
	
	@FindBy (xpath ="//*[starts-with(@hint,'First name')]")
	private WebElement  Firstname  ;
	public WebElement getFirstname() {
		return     Firstname;
	}
	
	@FindBy (xpath ="//*[starts-with(@hint,'Last Name')]")
	private WebElement  LastName  ;
	public WebElement getLastName() {
		return    LastName ;
	}
	
	@FindBy (xpath ="//*[starts-with(@hint,'Last name')]")
	private WebElement  Lastname  ;
	public WebElement getLastname() {
		return    Lastname ;
	}
	
	@FindBy (xpath ="//*[starts-with(@hint,'Email')]")
	private WebElement  Email  ;
	public WebElement getEmail() {
		return    Email ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Female\"]")
	private WebElement   Female ;
	public WebElement getFemale() {
		return    Female ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Male\"]")
	private WebElement    Male;
	public WebElement getMale() {
		return    Male ;
	}
	
	@FindBy (xpath ="//*[starts-with(@content-desc,'Additional Contact Number')]/following-sibling::android.widget.EditText[1]")
	private WebElement   AdditionalContactNumber ;
	public WebElement getAdditionalContactNumber() {
		return     AdditionalContactNumber;
	}
	
	@FindBy (xpath ="//*[starts-with(@hint,'Address line 1')]")
	private WebElement  AddressLine1  ;
	public WebElement getAddressLine1() {
		return    AddressLine1 ;
	}
	
	@FindBy (xpath ="//*[starts-with(@hint,'Address line 2')]")
	private WebElement   AddressLine2 ;
	public WebElement getAddressLine2() {
		return    AddressLine2 ;
	}
	
	@FindBy (xpath ="//*[starts-with(@hint,'City')]")
	private WebElement   City ;
	public WebElement getCity() {
		return   City  ;
	}
	
	@FindBy (xpath ="//*[starts-with(@hint,'Country')]")
	private WebElement   Country ;
	public WebElement getCountry() {
		return    Country ;
	}
	
	@FindBy (xpath ="//*[starts-with(@hint,'Postcode')]")
	private WebElement   PostCode ;
	public WebElement getPostCode() {
		return     PostCode;
	}
	
//	---------------------------------->       Tag
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"All Customers\"]/following-sibling::android.widget.Button")
	private WebElement  Showall_AllCustomers  ;
	public WebElement getShowall_AllCustomers() {
		return  Showall_AllCustomers   ;
	}
	
	@FindBy (xpath ="//android.widget.ScrollView")
	private WebElement   Tagscrollview ;
	public WebElement getTagscrollview() {
		return   Tagscrollview  ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Tag Categories\"]/following-sibling::android.widget.Button")
	private WebElement   TagCategoriesShowall ;
	public WebElement getTagCategoriesShowall() {
		return    TagCategoriesShowall ;
	}
	
	public static By  searchingCategoryName= By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty("ADMIN_TAG_CATEGORY_NAME")));

	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Tag Categories\"]")
	private WebElement   TagCategories ;
	public WebElement getTagCategories() {
		return    TagCategories ;
	}
	
	@FindBy (xpath ="//*[starts-with(@hint,'Category Name')]")
	private WebElement CategoryName   ;
	public WebElement getCategoryName() {
		return    CategoryName ;
	}
	
	@FindBy (xpath ="//*[starts-with(@content-desc,'Maximum Entity Level')]/following-sibling::android.widget.EditText[1]")
	private WebElement   MaximumEntityLevel ;
	public WebElement getMaximumEntityLevel() {
		return   MaximumEntityLevel  ;
	}
	
	@FindBy (xpath ="//*[starts-with(@content-desc,'Description')]/following-sibling::android.widget.EditText[1]")
	private WebElement   Decsription ;
	public WebElement getDecsription() {
		return    Decsription ;
	}
	
	@FindBy (xpath ="//*[starts-with(@hint,'Name')]")
	private WebElement   TagName ;
	public WebElement getTagName() {
		return    TagName ;
	}
	
	@FindBy (xpath ="//*[starts-with(@hint,'Description')]")
	private WebElement   TagDescription ;
	public WebElement getTagDescription() {
		return   TagDescription  ;
	}
	
	@FindBy (xpath ="(//android.widget.ImageView)[1]")
	private WebElement   TickButton ;
	public WebElement getTickButton() {
		return   TickButton  ;
	}
	
//	------------------------------------------------->  STAFF
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"All Staff\"]/following-sibling::android.widget.Button[1]")
	private WebElement    Showall_AllStaff;
	public WebElement getShowall_AllStaff() {
		return   Showall_AllStaff  ;
	}
	
	public static By StaffNameAfterSearch = By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty("ADMIN_STAFF_FIRST_NAME")));
	public static By CustomerNameAfterSearch = By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty("ADMIN_CUSTOMER_FIRSTNAME")));
	public static By AdminNameAfterSearch = By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty("ADMIN_ADMIN_FIRST_NAME")));

	//android.view.View[contains(@content-desc,"Edit")]
	
	@FindBy (xpath ="//android.view.View[contains(@content-desc,\"Edit\")]")
	private WebElement   Edit ;
	public WebElement getEdit() {
		return   Edit  ;
	}
	
	@FindBy (xpath ="//android.view.View[contains(@content-desc,\"Delete\")]")
	private WebElement   Delete ;
	public WebElement getDelete() {
		return   Delete  ;
	}
	@FindBy (xpath ="//android.widget.Button[contains(@content-desc,\"Confirm\")]")
	private WebElement   Confirm1;
	public WebElement getConfirm1() {
		return   Confirm1  ;
	}
	
	
	@FindBy (xpath ="//*[starts-with(@content-desc,'Contact Number')]/following-sibling::android.widget.EditText[1]")
	private WebElement   ContactNumber ;
	public WebElement getContactNumber() {
		return   ContactNumber  ;
	}
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Select\"]")
	private WebElement select;
	public WebElement getselect() {
		return select;
	}
	
	@FindBy(xpath = "//*[starts-with(@content-desc,'Skills')]/following-sibling::android.view.View[1]")
	private WebElement Skillsset;
	public WebElement getSkillsset() {
		return Skillsset;
	}
	
	public static By ServiceSkill = By.xpath(String.format("//android.widget.CheckBox[contains(@content-desc, '"+getProperty("SERVICE_NAME")+"')]"));

	
//	------------------------------------------------->  USER APPROVAL
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Pending Requests\"]/following-sibling::android.widget.Button")
	private WebElement  Showall_PendingRequest  ;
	public WebElement getShowall_PendingRequest() {
		return    Showall_PendingRequest ;
	}
	
	@FindBy (xpath ="//*[starts-with(@hint,'Search')]")
	private WebElement   SearchBox ;
	public WebElement getSearchBox() {
		return   SearchBox  ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"User Requests\"]")
	private WebElement   User_Requests_Text ;
	public WebElement getUser_Requests_Text() {
		return  User_Requests_Text   ;
	}
	
	public static By UserLocator1 = By.xpath("//*[starts-with(@content-desc,'pending')]/android.view.View[@content-desc='"+ getProperty("SIGNUP_FIRSTNAME") + "']");
	
	public static By EyeIcon1 = By.xpath("//*[starts-with(@content-desc,'pending')]/android.view.View[@content-desc='"+ getProperty("SIGNUP_FIRSTNAME") + "']/following-sibling::android.widget.ImageView[1]");

	@FindBy (xpath ="//*[starts-with(@content-desc,'pending')]")
	private List<WebElement>  UserPending    ;
	public  List<WebElement> getUserPending() {
		return   UserPending  ;
	}
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Phone number \"]")
	private WebElement ProfilePhone_Number;
	public WebElement getProfilePhone_Number() {
		return ProfilePhone_Number;
	}
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Accept\"]")
	private WebElement Accept;
	public WebElement getAccept() {
		return Accept;
	}
	
	@FindBy(xpath = "(//android.widget.Button)[2]")
	private WebElement Confirm;
	public WebElement getConfirm() {
		return Confirm;
	}
	
	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Tab 1 of 6\"]")
	private WebElement Home;
	public WebElement getHome() {
		return Home;
	}
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"All Administrators\"]")
	private WebElement AllAdministrations;
	public WebElement getAllAdministrations() {
		return AllAdministrations;
	}
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"All Staff\"]")
	private WebElement AllStaff;
	public WebElement getAllStaff() {
		return AllStaff;
	}
	
//	---------------------------------------------------------------------------------->  PET Approval
	
	public static By PetLocator1 = By.xpath("//*[starts-with(@content-desc,'unapproved_beneficiary')]/android.view.View[@content-desc='"+ getProperty("PET_NAME") + "']");
	
	public static By PetEyeIcon1 = By.xpath("//*[starts-with(@content-desc,'unapproved_beneficiary')]/android.view.View[@content-desc='"+ getProperty("PET_NAME") + "']/following-sibling::android.widget.ImageView[2]");

	@FindBy (xpath ="//*[starts-with(@content-desc,'Gender')]")
	private WebElement   gender ;
	public WebElement getgender() {
		return   gender  ;
	}
	
	@FindBy(xpath = "//android.widget.ScrollView")
	private WebElement scroll;
	public WebElement getscroll() {
		return scroll;
	}
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Record Created Successfully\"]")
	private WebElement SnackbarCreatedstaff;
	public WebElement getSnackbarCreatedstaff() {
		return SnackbarCreatedstaff;
	}
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Record Created Successfully\"]")
	private WebElement SnackbarCreatedAdmin;
	public WebElement getSnackbarCreatedAdmin() {
		return SnackbarCreatedAdmin;
	}
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Record Created Successfully\"]")
	private WebElement SnackbarCreatedTag;
	public WebElement getSnackbarCreatedTag() {
		return SnackbarCreatedTag;
	}
	
	@FindBy(xpath = "//android.view.View[contains(@content-desc,\"user\")]")
	private WebElement user;
	public WebElement getuser() {
		return user;
	}
	
	@FindBy(xpath = "//android.view.View[contains(@content-desc,\"View\")]")
	private WebElement view;
	public WebElement getview() {
		return view;
	}
	
	@FindBy(xpath = "//android.view.View[contains(@content-desc,\"My Pet\")]")
	private WebElement MyPet;
	public WebElement getMyPet() {
		return MyPet;
	}
	
	public static By trySearchingagain = By.xpath("//android.view.View[@content-desc=\"Try searching again using a different spelling or keyword.\"]");
	
}
