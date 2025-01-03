package com.frontend;

import java.util.Random;

import com.WE.WE_Info;
import com.baseClass.Base;

import io.qameta.allure.Allure;

public class Info extends Base {
	static Random random = new Random();

	public static void User_Data() throws InterruptedException {
		WE_Info UserInfo = new WE_Info(driver);

		ClickonElement(UserInfo.getFirstName());
		passInput(UserInfo.getFirstName(), getProperty("SIGNUP_FIRSTNAME"));
		driver.hideKeyboard();
		ClickonElement(UserInfo.getLastName());
		passInput(UserInfo.getLastName(), getProperty("SIGNUP_LASTNAME"));
		driver.hideKeyboard();
		ClickonElement(UserInfo.getCustomerMale());
		ClickonElement(UserInfo.getCustomerFemale());
		ClickonElement(UserInfo.getPhoneNumber());
		passInput(UserInfo.getPhoneNumber(), getProperty("SIGNUP_PHONENUMBER"));
		driver.hideKeyboard();
		ClickonElement(UserInfo.getAddressLine1());
		passInput(UserInfo.getAddressLine1(), getProperty("SIGNUP_ADDRESSLINE1"));
		driver.hideKeyboard();
		ClickonElement(UserInfo.getAddressLine2());
		passInput(UserInfo.getAddressLine2(), getProperty("SIGNUP_ADDRESSLINE2"));
		driver.hideKeyboard();
		ClickonElement(UserInfo.getCityTown());
		passInput(UserInfo.getCityTown(), getProperty("SIGNUP_CITYTOWN"));
		driver.hideKeyboard();
		ClickonElement(UserInfo.getPostCode());
		passInput(UserInfo.getPostCode(), getProperty("SIGNUP_POSTCODE"));
		driver.hideKeyboard();
		scrollDown();
		ClickonElement(UserInfo.getCountryTab());
		ClickonElement(UserInfo.getCountryTab());
		ClickonElement(UserInfo.getContinue());
	}

	public static void Pet_Data() throws Exception {

		WE_Info PetInfo = new WE_Info(driver);

		ClickonElement(PetInfo.getPet_Name());
		passInput(PetInfo.getPet_Name(), getProperty("PET_NAME"));
		ClickonElement(PetInfo.getDate_Of_Birth());
		scrollupRandomly(PetInfo.getDate_Format().get(2));
		scrolldownRandomly(PetInfo.getDate_Format().get(0));
		scrolldownRandomly(PetInfo.getDate_Format().get(1));
		ClickonElement(PetInfo.getSelect());
		ClickonElement(PetInfo.getPetMale());
		ClickonElement(PetInfo.getPetFemale());
		ClickonElement(PetInfo.getSize());
		waitForElement(PetInfo.getBottomSheetSize());
		int PETsize = PetInfo.getPetSizeList().size();
		System.out.println("size of service  : " + PETsize);
		if (PETsize > 0) {
			int randomIndex = random.nextInt(PETsize - 1);
			System.out.println(randomIndex);
			ClickonElement(PetInfo.getPetSizeList().get(randomIndex));
			System.out.println("ggggggg");
		} else {
			System.out.println("Not enough elements to select a random one.");
		}
		ClickonElement(PetInfo.getBreed());
		waitForElement(PetInfo.getBottomresetbutton());
		int BREEDsize = PetInfo.getBreedlist().size();
		System.out.println("size of service  : " + BREEDsize);
		if (BREEDsize > 0) {
			int randomIndex = random.nextInt(BREEDsize - 1);
			System.out.println(randomIndex);
			ClickonElement(PetInfo.getBreedlist().get(randomIndex));
		} else {
			System.out.println("Not enough elements to select a random one.");
		}
		if (isElementAvailable(PetInfo.getAdminNotes())) {
			ClickonElement(PetInfo.getAdminNotes());
			passInput(PetInfo.getAdminNotes(), getProperty("ADMIN_NOTES"));
			driver.hideKeyboard();
		}

		ClickonElement(PetInfo.getDietary());
		passInput(PetInfo.getDietary(), getProperty("PET_DIETARY_ISSUES"));
		driver.hideKeyboard();

		ClickonElement(PetInfo.getAllergies());
		passInput(PetInfo.getAllergies(), getProperty("PET_ALLERGIES"));
		driver.hideKeyboard();

		ClickonElement(PetInfo.getVet_Name());
		passInput(PetInfo.getVet_Name(), getProperty("PET_VETNAME"));
		driver.hideKeyboard();

		ClickonElement(PetInfo.getVet_Address());
		passInput(PetInfo.getVet_Address(), getProperty("PET_VETADDRESS"));
		driver.hideKeyboard();

		ClickonElement(PetInfo.getVet_PhoneNumber());
		passInput(PetInfo.getVet_PhoneNumber(), getProperty("PET_VETPHONENUMBER"));
		driver.hideKeyboard();

		ClickonElement(PetInfo.getMicrochip());
		passInput(PetInfo.getMicrochip(), getProperty("PET_MICROCHIP"));
		driver.hideKeyboard();

		ClickonElement(PetInfo.getPerson_Name());
		passInput(PetInfo.getPerson_Name(), getProperty("PET_CONTACT_PERSONNAME"));
		driver.hideKeyboard();

		ClickonElement(PetInfo.getPerson_Number());
		passInput(PetInfo.getPerson_Number(), getProperty("PET_CONTACT_PERSONNUMBER"));
		driver.hideKeyboard();

		ClickonElement(PetInfo.getSpecial_Instruction());
		passInput(PetInfo.getSpecial_Instruction(), getProperty("PET_SPECIAL_INSTRUCTIONS"));
		driver.hideKeyboard();

		ClickonElement(PetInfo.getFeeding_Schedules());
		passInput(PetInfo.getFeeding_Schedules(), getProperty("PET_FEEDING_DETAILS"));
		driver.hideKeyboard();

//		ClickonElement(PetInfo.getAdditional_Contacts());
//		passInput(PetInfo.getAdditional_Contacts(), getProperty("PET_ADDITIONAL_CONTACT"));
//		driver.hideKeyboard();

		// Tap on behavioral information checkboxes
		ClickonElement(PetInfo.getBehavioral_Information1());
		ClickonElement(PetInfo.getBehavioral_Information2());
		ClickonElement(PetInfo.getBehavioral_Information3());
		// Save the pet data
		ClickonElement(PetInfo.getSave());
	}

}
