package com.frontend;

import java.io.IOException;
import java.net.MalformedURLException;

import com.WE.WE_Admin_User;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Info;
import com.api.Api;
import com.baseClass.Base;
import com.baseClass.Base.API_BASE_URL;

import io.qameta.allure.Allure;

public class Admin_User extends Base {

	public static void Create_Admin() throws InterruptedException {
		WE_Admin_User user = new WE_Admin_User(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		WE_Info info = new WE_Info(driver);

		ClickonElement(workflow.getUsers_navigation_Bar());
		ClickonElement(user.getShowall_AllAdmin());
		ClickonElement(user.getFAB());

		ClickonElement(user.getFirstName());
		passInput(user.getFirstName(), getProperty("ADMIN_ADMIN_FIRST_NAME"));
		driver.hideKeyboard();
		ClickonElement(user.getLastName());
		passInput(user.getLastName(), getProperty("ADMIN_ADMIN_LAST_NAME"));
		driver.hideKeyboard();
		ClickonElement(user.getEmail());
		passInput(user.getEmail(), getProperty("ADMIN_ADMIN_EMAIL"));
		driver.hideKeyboard();
		ClickonElement(user.getFemale());
		ClickonElement(user.getMale());
		ClickonElement(user.getPhoneNumber());
		passInput(user.getPhoneNumber(), getProperty("ADMIN_ADMIN_CONTACTNUMBER"));
		driver.hideKeyboard();
		ClickonElement(user.getAdditionalContactNumber());
		passInput(user.getAdditionalContactNumber(), getProperty("ADMIN_ADMIN_ADDITIONAL_CONTACT_NUMBER"));
		driver.hideKeyboard();
		ClickonElement(user.getAddressLine1());
		passInput(user.getAddressLine1(), getProperty("ADMIN_ADMIN_ADDRESSLINE_1"));
		driver.hideKeyboard();
		ClickonElement(user.getAddressLine2());
		passInput(user.getAddressLine2(), getProperty("ADMIN_ADMIN_ADDRESSLINE_2"));
		driver.hideKeyboard();
		ClickonElement(user.getCity());
		passInput(user.getCity(), getProperty("ADMIN_ADMIN_CITY"));
		driver.hideKeyboard();
		ClickonElement(user.getCountry());
		ClickonElement(user.getCountryName());
		ClickonElement(user.getPostCode());
		passInput(user.getPostCode(), getProperty("ADMIN_ADMIN_POSTCODE"));
		driver.hideKeyboard();
		ClickonElement(user.getSave());
		ClickonElement(info.getBackButton());

	}

	
	public static void Create_Customer() throws InterruptedException {
		WE_Admin_User user = new WE_Admin_User(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		WE_Info info = new WE_Info(driver);

		ClickonElement(workflow.getUsers_navigation_Bar());
		ClickonElement(user.getShowall_AllCustomers());
		ClickonElement(user.getFAB());
		ClickonElement(user.getFirstname());
		passInput(user.getFirstname(), getProperty("ADMIN_CUSTOMER_FIRSTNAME"));
		driver.hideKeyboard();
		ClickonElement(user.getLastname());
		passInput(user.getLastname(), getProperty("ADMIN_CUSTOMER_LASTNAME"));
		driver.hideKeyboard();
		ClickonElement(user.getEmail());
		passInput(user.getEmail(), getProperty("ADMIN_CUSTOMER_EMAIL"));
		driver.hideKeyboard();
		Thread.sleep(1000);
		ClickonElement(user.getFemale());
		ClickonElement(user.getMale());
		Thread.sleep(1000);
		ClickonElement(user.getPhonenumber());
		passInput(user.getPhonenumber(), getProperty("ADMIN_CUSTOMER_PHONENUMBER"));
		driver.hideKeyboard();
		ClickonElement(user.getAddressLine1());
		passInput(user.getAddressLine1(), getProperty("ADMIN_CUSTOMER_ADDRESSLINE_1"));
		driver.hideKeyboard();
		ClickonElement(user.getAddressLine2());
		passInput(user.getAddressLine2(), getProperty("ADMIN_CUSTOMER_ADDRESSLINE_2"));
		driver.hideKeyboard();
		ClickonElement(user.getCity());
		passInput(user.getCity(), getProperty("ADMIN_CUSTOMER_CITYTOWN"));
		driver.hideKeyboard();
		ClickonElement(user.getPostCode());
		passInput(user.getPostCode(), getProperty("ADMIN_CUSTOMER_POSTCODE"));
		driver.hideKeyboard();
		scrollDown();
		ClickonElement(user.getCountry());
		ClickonElement(user.getCountryName());
		ClickonElement(user.getSave());
		waitForElement(user.getAllCustomers());
		ClickonElement(info.getBackButton());
	}
	
	public static void CreateTag() throws Exception {
		WE_Admin_User user = new WE_Admin_User(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		WE_Info info = new WE_Info(driver);

		ClickonElement(workflow.getUsers_navigation_Bar());
		waitForElement(user.getShowall_AllCustomers());
		Thread.sleep(2000);
		halfscrollUntilElementFound12(user.getTagscrollview(), user.getTagCategoriesShowall());
		ClickonElement(user.getTagCategoriesShowall());
		ClickonElement(user.getFAB());
		ClickonElement(user.getCategoryName());
		passInput(user.getCategoryName(), getProperty("ADMIN_TAG_CATEGORY_NAME"));
		driver.hideKeyboard();
		ClickonElement(user.getMaximumEntityLevel());
		passInput(user.getMaximumEntityLevel(), getProperty("ADMIN_TAG_MAXIMUM_ENTITY_LEVEL"));
		driver.hideKeyboard();
		ClickonElement(user.getDecsription());
		passInput(user.getDecsription(), getProperty("ADMIN_TAG_CATEGORY_DESCRIPTION"));
		driver.hideKeyboard();
		Thread.sleep(2000);
		ClickonElement(user.getTagName());
		passInput(user.getTagName(), getProperty("ADMIN_TAG_TAGS_NAME1"));
		driver.hideKeyboard();
		Thread.sleep(2000);
		ClickonElement(user.getTagDescription());
		passInput(user.getTagDescription(), getProperty("ADMIN_TAG_TAGS_DESCRIPTION1"));
		driver.hideKeyboard();
		Thread.sleep(2000);
		ClickonElement(user.getTickButton());
		ClickonElement(user.getSave());
		ClickonElement(info.getBackButton());

	}

	public static void Create_Staff() throws Exception {

		WE_Admin_User user = new WE_Admin_User(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		WE_Info info = new WE_Info(driver);

		ClickonElement(workflow.getUsers_navigation_Bar());
		ClickonElement(user.getShowall_AllStaff());
		ClickonElement(user.getFAB());
		ClickonElement(user.getFirstName());
		passInput(user.getFirstName(), getProperty("ADMIN_STAFF_FIRST_NAME"));
		driver.hideKeyboard();
		ClickonElement(user.getLastName());
		passInput(user.getLastName(), getProperty("ADMIN_STAFF_LAST_NAME"));
		driver.hideKeyboard();
		ClickonElement(user.getEmail());
		passInput(user.getEmail(), getProperty("ADMIN_STAFF_EMAIL"));
		driver.hideKeyboard();
		ClickonElement(user.getFemale());
		ClickonElement(user.getMale());
		ClickonElement(user.getContactNumber());
		passInput(user.getContactNumber(), getProperty("ADMIN_STAFF_CONTACTNUMBER"));
		driver.hideKeyboard();
		ClickonElement(user.getAdditionalContactNumber());
		passInput(user.getAdditionalContactNumber(), getProperty("ADMIN_STAFF_ADDITIONAL_CONTACT_NUMBER"));
		driver.hideKeyboard();
		ClickonElement(user.getAddressLine1());
		passInput(user.getAddressLine1(), getProperty("ADMIN_STAFF_ADDRESSLINE_1"));
		driver.hideKeyboard();
		ClickonElement(user.getAddressLine2());
		passInput(user.getAddressLine2(), getProperty("ADMIN_STAFF_ADDRESSLINE_2"));
		driver.hideKeyboard();
		ClickonElement(user.getCity());
		passInput(user.getCity(), getProperty("ADMIN_STAFF_CITY"));
		driver.hideKeyboard();
		ClickonElement(user.getCountry());
		ClickonElement(user.getCountryName());
		ClickonElement(user.getPostCode());
		passInput(user.getPostCode(), getProperty("ADMIN_STAFF_POSTCODE"));
		driver.hideKeyboard();
		Thread.sleep(2000);
		ClickonElement(user.getSkillsset());
		if (isElementAvailable(user.ServiceSkill)) {
			clickOnElementUsingBy(user.ServiceSkill);
		} else {
			halfscrollUntilElementFound12(user.getscroll(), user.ServiceSkill);
			clickOnElementUsingBy(user.ServiceSkill);
		}
		ClickonElement(user.getselect());
		ClickonElement(user.getSave());
		ClickonElement(info.getBackButton());
	}
	
	public static void Create_Second_Staff() throws Exception {

		WE_Admin_User user = new WE_Admin_User(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		WE_Info info = new WE_Info(driver);

		ClickonElement(workflow.getUsers_navigation_Bar());
		ClickonElement(user.getShowall_AllStaff());
		ClickonElement(user.getFAB());

		ClickonElement(user.getFirstName());
		passInput(user.getFirstName(), getProperty("ADMIN_STAFF_2_FIRST_NAME"));
		driver.hideKeyboard();

		ClickonElement(user.getLastName());
		passInput(user.getLastName(), getProperty("ADMIN_STAFF_2_LAST_NAME"));
		driver.hideKeyboard();

		ClickonElement(user.getEmail());
		passInput(user.getEmail(), getProperty("ADMIN_STAFF_2_EMAIL"));
		driver.hideKeyboard();

		ClickonElement(user.getFemale());
		ClickonElement(user.getMale());

		ClickonElement(user.getContactNumber());
		passInput(user.getContactNumber(), getProperty("ADMIN_STAFF_2_CONTACTNUMBER"));
		driver.hideKeyboard();

		ClickonElement(user.getAdditionalContactNumber());
		passInput(user.getAdditionalContactNumber(), getProperty("ADMIN_STAFF_2_ADDITIONAL_CONTACT_NUMBER"));
		driver.hideKeyboard();

		ClickonElement(user.getAddressLine1());
		passInput(user.getAddressLine1(), getProperty("ADMIN_STAFF_ADDRESSLINE_1"));
		driver.hideKeyboard();

		ClickonElement(user.getAddressLine2());
		passInput(user.getAddressLine2(), getProperty("ADMIN_STAFF_ADDRESSLINE_2"));
		driver.hideKeyboard();

		ClickonElement(user.getCity());
		passInput(user.getCity(), getProperty("ADMIN_STAFF_2_CITY"));
		driver.hideKeyboard();

		ClickonElement(user.getCountry());
		ClickonElement(user.getCountryName());

		ClickonElement(user.getPostCode());
		passInput(user.getPostCode(), getProperty("ADMIN_STAFF_2_POSTCODE"));
		driver.hideKeyboard();
		Thread.sleep(2000);
		ClickonElement(user.getSkillsset());
		if (isElementAvailable(user.ServiceSkill)) {
			clickOnElementUsingBy(user.ServiceSkill);
		} else {
			halfscrollUntilElementFound12(user.getscroll(), user.ServiceSkill);
			clickOnElementUsingBy(user.ServiceSkill);
		}
		ClickonElement(user.getselect());
		ClickonElement(user.getSave());

		ClickonElement(info.getBackButton());
	}
	
	public static  void second_pet() throws Exception {
		WE_Admin_User user = new WE_Admin_User(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		WE_Info info = new WE_Info(driver);

		ClickonElement(workflow.getUsers_navigation_Bar());
		waitForElement(user.getShowall_AllCustomers());
		Thread.sleep(2000);
		ClickonElement(user.getShowall_AllCustomers());
		ClickonElement(user.getSearchBox());
		Thread.sleep(3000);
		passInput(user.getSearchBox(), getProperty("SIGNUP_EMAIL"));
		driver.hideKeyboard();
		Thread.sleep(4000);
		if (isElementAvailable(user.getuser())) {
			System.out.println("User Found ");
			Thread.sleep(1000);
			ClickonElement(user.getuser());
			ClickonElement(user.getview());
			ClickonElement(user.getMyPet());
			ClickonElement(user.getFAB());
			Info.Pet_Data();
		    ClickonElement(info.getBackButton());
			ClickonElement(info.getBackButton());
		} else if (isElementAvailable(user.trySearchingagain)) {
			System.out.println("User not found");
			throw new Error("User not found");
		}
	}

	public static void approveUserUsingSearch() throws Exception {
		WE_Admin_User user = new WE_Admin_User(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		WE_Info info = new WE_Info(driver);

		ClickonElement(workflow.getUsers_navigation_Bar());
		ClickonElement(user.getShowall_PendingRequest());
		Thread.sleep(4000);
		ClickonElement(user.getSearchBox());
		Thread.sleep(3000);
		passInput(user.getSearchBox(), getProperty("SIGNUP_FIRSTNAME"));
		driver.hideKeyboard();
		Thread.sleep(4000);
		if (isElementAvailable(user.UserLocator1)) {
			System.out.println("user found");
		} else {
			System.out.println("user not found");
			throw new Error("User not found");
		}
		Thread.sleep(2000);
		clickOnElementUsingBy(user.EyeIcon1);
		Thread.sleep(2000);
		boolean isElementFound = false;
		Thread.sleep(1000);
		while (!isElementFound) {
			try {
				Thread.sleep(1000);
				if (isScrollViewAvailable()) {
					Thread.sleep(3000);
					scroll(user.getscroll());
					Thread.sleep(2000);
					ClickonElementwithoutWAIT(user.getAccept());
					isElementFound = true;
				}
			} catch (Exception e) {
				System.out.println("Accept element not found, scrolling again...");
			}
		}
		ClickonElement(user.getConfirm());
		ClickonElement(info.getBackButton());
	}

	public static void approvePetUsingSearch() throws InterruptedException, Error {
		WE_Admin_User user = new WE_Admin_User(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		WE_Info info = new WE_Info(driver);

		ClickonElement(workflow.getUsers_navigation_Bar());
		ClickonElement(user.getShowall_PendingRequest());
		Thread.sleep(4000);
		ClickonElement(user.getSearchBox());
		Thread.sleep(3000);
		passInput(user.getSearchBox(), getProperty("PET_NAME"));
		driver.hideKeyboard();
		Thread.sleep(4000);
		if (isElementAvailable(user.PetLocator1)) {
			System.out.println("Pet found");
		} else {
			System.out.println("Pet not found");
			throw new Error("Pet not found");
		}
		clickOnElementUsingBy(user.PetEyeIcon1);
		waitForElement(user.getgender());
		boolean isElementFound = false;
		while (!isElementFound) {
			try {
				if (isScrollViewAvailable()) {
					Thread.sleep(3000);
					scrolling();
					Allure.step("Scroll the Customer Info");
					Thread.sleep(2000);
					ClickonElementwithoutWAIT(user.getAccept());
					isElementFound = true;
				}
			} catch (Exception e) {
				System.out.println("Accept element not found, scrolling again...");
			}
		}
		ClickonElement(user.getConfirm());
        ClickonElement(info.getBackButton());
	}
	
	
	public static void main(String[] args) throws Exception {
		PropertyFile("First");
		Latest_StagingAPK_download(getProperty("STAGING"));
		Application();
		ChooseApi(API_BASE_URL.Staging);
		Api.signInAdmin(getProperty("PREDEFINED_ADMIN_EMAIL"));
		Api.verifyOtp(getProperty("PREDEFINED_ADMIN_OTP"));
		Login_Details.login_Admin();
		Create_Admin();
		Create_Customer();
		Create_Staff();
		CreateTag();
		second_pet();
		
	}
	
}
