package com.WE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.Base;

import io.appium.java_client.android.AndroidDriver;

public class WE_Info extends Base{

	public WE_Info(AndroidDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver1, this);
	}
	
	
	// --------------------------------------------------------------------------------  USER DATA	
	
//    WebElement for the First name input field during sign up
@FindBy(xpath = "//*[starts-with(@hint,'First')]")
   private WebElement FirstName;
   public WebElement getFirstName() {
       return FirstName;
   }

//    WebElement for the last name input field during sign up
   @FindBy(xpath = "//*[starts-with(@hint,'Last')]")
   private WebElement LastName;
   public WebElement getLastName() {
       return LastName;
   }

	@FindBy (xpath ="//*[starts-with(@hint,'Email')]")
	private WebElement Email;
	public WebElement getEmail() {
		return Email;
	}
   
   
//    WebElement for the "Male" option in gender selection
   @FindBy(xpath = "//android.view.View[@content-desc=\"Male\"]")
   private WebElement CustomerMale;
   public WebElement getCustomerMale() {
       return CustomerMale;
   }

//    WebElement for the "Female" option in gender selection
   @FindBy(xpath = "//android.view.View[@content-desc=\"Female\"]")
   private WebElement CustomerFemale;
   public WebElement getCustomerFemale() {
       return CustomerFemale;
   }

//    WebElement for the phone number input field during sign up
   @FindBy(xpath = "//*[starts-with(@content-desc,'Phone number')]/following-sibling::android.widget.EditText[1]")
   private WebElement PhoneNumber;
   public WebElement getPhoneNumber() {
       return PhoneNumber;
   }

//    WebElement for the first address line input field during sign up
   @FindBy(xpath = "//*[starts-with(@hint,'Address line 1')]")
   private WebElement AddressLine1;
   public WebElement getAddressLine1() {
       return AddressLine1;
   }

//    WebElement for the second address line input field during sign up
   @FindBy(xpath = "//*[starts-with(@hint,'Address line 2')]")
   private WebElement AddressLine2;
   public WebElement getAddressLine2() {
       return AddressLine2;
   }

//    WebElement for the city/town input field during sign up
   @FindBy(xpath = "//*[starts-with(@hint,'City')]")
   private WebElement CityTown;
   public WebElement getCityTown() {
       return CityTown;
   }

//    WebElement for the postal code input field during sign up
   @FindBy(xpath = "//*[starts-with(@hint,'Post')]")
   private WebElement PostCode;
   public WebElement getPostCode() {
       return PostCode;
   }
   
   @FindBy (xpath ="//*[starts-with(@hint,'Country')]")
	private WebElement Country;
	public WebElement getCountry() {
		return Country;
	}

//    WebElement for the country selection tab
   @FindBy(xpath = "//android.view.View[@content-desc=\"United Kingdom\"]")
   private WebElement CountryTab;
   public WebElement getCountryTab() {
       return CountryTab;
   }

//    WebElement for the "Save" button in profile settings
   @FindBy(xpath ="//android.view.View[@content-desc=\"Continue\"]")
   private WebElement Continue;
   public WebElement getContinue() {
       return Continue;
   }

//---------------------------------------------------------------------------------- PET DATA 	

//	 Pet Information Section
	@FindBy(xpath = "//*[starts-with(@hint,'Name')]")
	private WebElement Pet_Name;
	public WebElement getPet_Name() {
	    return Pet_Name;
	}

//	 Date of Birth Section
	@FindBy(xpath = "//*[starts-with(@hint,'Date of')]")
	private WebElement Date_Of_Birth;
	public WebElement getDate_Of_Birth() {
	    return Date_Of_Birth;
	}

//	 Date Format Options
	@FindBy(xpath = "//android.widget.SeekBar")
	private List<WebElement> Date_Format;
	public List<WebElement> getDate_Format() {
	    return Date_Format;
	}

//	 Select Button for Popup Menu
	@FindBy(xpath = "//android.widget.Button[@content-desc='popupselect']")
	private WebElement Select;
	public WebElement getSelect() {
	    return Select;
	}
	
//	Pet Size Options
	@FindBy(xpath = "//*[starts-with(@hint,'Size')]")
	private WebElement Size;
	public WebElement getSize() {
		return Size;
	}
		
//	 Pet Size Options
	@FindBy(xpath = "//android.view.View[@content-desc='Small (0-7kg)']")
	private WebElement Size1;
	public WebElement getSize1() {
	    return Size1;
	}

	@FindBy(xpath = "//android.view.View[@content-desc='Medium (7 - 18Kg)']")
	private WebElement Size2;
	public WebElement getSize2() {
	    return Size2;
	}

	@FindBy(xpath = "//android.view.View[@content-desc='Large (18 to 45Kg)']")
	private WebElement Size3;
	public WebElement getSize3() {
	    return Size3;
	}

	@FindBy(xpath = "//android.view.View[@content-desc='Giant (45+Kg)']")
	private WebElement Size4;
	public WebElement getSize4() {
	    return Size4;
	}

//	 Dismiss Button for Popup
	@FindBy(xpath = "//android.view.View[@content-desc='Dismiss']")
	private WebElement Dismiss;
	public WebElement getDismiss() {
	    return Dismiss;
	}

//	 Breed Information
	@FindBy(xpath = "//*[starts-with(@hint,'Breed')]")
	private WebElement Breed;
	public WebElement getBreed() {
	    return Breed;
	}
	
	@FindBy(xpath = "//android.widget.ScrollView/android.view.View")
	private List<WebElement> Breedlist;
	public List<WebElement> getBreedlist() {
	    return Breedlist;
	}

//	 Bottom Reset Button
	@FindBy(xpath = "//android.widget.Button[@content-desc='bottom_sheet_menuReset']")
	private WebElement Bottomresetbutton;
	public WebElement getBottomresetbutton() {
	    return Bottomresetbutton;
	}

//	 Gender Selection
	@FindBy(xpath = "//android.view.View[@content-desc='Male']")
	private WebElement PetMale;
	public WebElement getPetMale() {
	    return PetMale;
	}

	@FindBy(xpath = "//android.view.View[@content-desc='Female']")
	private WebElement PetFemale;
	public WebElement getPetFemale() {
	    return PetFemale;
	}

//	 Size Selection for Bottom Sheet
	@FindBy(xpath = "//android.view.View[@content-desc='Size']")
	private WebElement BottomSheetSize;
	public WebElement getBottomSheetSize() {
	    return BottomSheetSize;
	}

//	 List of Pet Sizes in Bottom Sheet
	@FindBy(xpath = "//android.view.View[@content-desc='Size']/android.view.View/android.view.View")
	private List<WebElement> PetSizeList;
	public List<WebElement> getPetSizeList() {
	    return PetSizeList;
	}

	public static By AddCustomer = By.xpath("//android.view.View[@content-desc=\"Add Customer\"]");

	public static By AddInfoPage = By.xpath("//android.view.View[@content-desc=\"Add your info\"]");

	public static By AddPetSignup = By.xpath("//android.view.View[@content-desc=\"Add Pet\"]");
	
	public static By AddpetCustomer = By.xpath("//android.view.View[@content-desc=\"Add Pet\"]");

	@FindBy (xpath ="//android.view.View[@content-desc=\"Add your info\"]")
	private WebElement   AddInfoPageElement ;
	public WebElement getAddInfoPageElement() {
		return    AddInfoPageElement ;
	}
	
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Add Pet\"]")
	private WebElement   AddPetInfoPageElement ;
	public WebElement getAddPetInfoPageElement() {
		return    AddPetInfoPageElement ;
	}
//	
//	@FindBy (xpath ="//android.view.View[@content-desc=\"Add your info\"]")
//	private WebElement   AddInfoPage ;
//	public WebElement getAddInfoPage() {
//		return    AddInfoPage ;
//	}
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Admin Notes \"]/following-sibling::android.widget.EditText[1]")
	private WebElement AdminNotes;
	public WebElement getAdminNotes() {
	    return AdminNotes;
	}
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Dietary issues If any \"]/following-sibling::android.widget.EditText[1]")
	private WebElement Dietary;
	public WebElement getDietary() {
	    return Dietary;
	}
	

	@FindBy(xpath = "//android.view.View[@content-desc=\"Allergies If any \"]/following-sibling::android.widget.EditText[1]")
	private WebElement Allergies;
	public WebElement getAllergies() {
	    return Allergies;
	}
	
	
	@FindBy(xpath = "//*[starts-with(@hint,'Vet Name')]")
	private WebElement Vet_Name;
	public WebElement getVet_Name() {
	    return Vet_Name;
	}
	
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Vet Address * \"]/following-sibling::android.widget.EditText[1]")
	private WebElement Vet_Address;
	public WebElement getVet_Address() {
	    return Vet_Address;
	}
	
	
	@FindBy(xpath ="//*[starts-with(@content-desc,'Vet Phone Number')]/following-sibling::android.widget.EditText[1]")
	private WebElement Vet_PhoneNumber;
	public WebElement getVet_PhoneNumber() {
	    return Vet_PhoneNumber;
	}
	
	
	@FindBy(xpath = "//*[starts-with(@hint,'Microchip')]")
	private WebElement Microchip;
	public WebElement getMicrochip() {
	    return Microchip;
	}
	
	@FindBy(xpath = "//*[starts-with(@hint,'Contact Person')]")
	private WebElement Person_Name;
	public WebElement getPerson_Name() {
	    return Person_Name;
	}
	
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Contact Person's Phone Number \"]/following-sibling::android.widget.EditText[1]")
	private WebElement Person_Number;
	public WebElement getPerson_Number() {
	    return Person_Number;
	}
	

	@FindBy(xpath = "//android.view.View[@content-desc=\"Special Instructions \"]/following-sibling::android.widget.EditText[1]")
	private WebElement Special_Instruction;
	public WebElement getSpecial_Instruction() {
	    return Special_Instruction;
	}
	
	
	@FindBy(xpath = "//*[starts-with(@content-desc,'Feeding')]/following-sibling::android.widget.EditText[1]")
	private WebElement Feeding_Schedules;
	public WebElement getFeeding_Schedules() {
	    return Feeding_Schedules;
	}
	

	@FindBy(xpath = "//android.view.View[@content-desc=\"Additional Contacts \"]/following-sibling::android.widget.EditText[1]")
	private WebElement Additional_Contacts;
	public WebElement getAdditional_Contacts() {
	    return Additional_Contacts;
	}
	
	
//	 WebElement for Behavioral Information: Spayed/Neutered
	@FindBy(xpath = "//android.view.View[@content-desc=\"Spayed/Neutered\"]")
	private WebElement Behavioral_Information1;
	public WebElement getBehavioral_Information1() {
	    return Behavioral_Information1;
	}

//	 WebElement for Behavioral Information: Human friendly
	@FindBy(xpath = "//android.view.View[@content-desc=\"Human friendly\"]")
	private WebElement Behavioral_Information2;
	public WebElement getBehavioral_Information2() {
	    return Behavioral_Information2;
	}

//	 WebElement for Behavioral Information: Vaccinated
	@FindBy(xpath = "//android.view.View[@content-desc=\"Vaccinated\"]")
	private WebElement Behavioral_Information3;
	public WebElement getBehavioral_Information3() {
	    return Behavioral_Information3;
	}

//	 WebElement for Save button
	@FindBy(xpath = "//android.view.View[@content-desc=\"Save\"]")
	private WebElement Save;
	public WebElement getSave() {
	    return Save;
	}
	
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Close App\"]")
	private WebElement closeApp;
	public WebElement getcloseApp() {
	    return closeApp;
	}
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Profile\"]")
	private WebElement ProfileWord;
	public WebElement getProfileWord() {
	    return ProfileWord;
	}
	@FindBy(xpath = "(//android.widget.Button)[1]")
	private WebElement BackButton;
	public WebElement getBackButton() {
	    return BackButton;
	}
	
	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Record Updated Successfully\"]")
	private WebElement SnackbarAfterAddinfo;
	public WebElement getSnackbarAfterAddinfo() {
	    return SnackbarAfterAddinfo;
	}
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Record Created Successfully\"]")
	private WebElement SnackbarAfterPetinfo;
	public WebElement getSnackbarAfterPetinfo() {
	    return SnackbarAfterPetinfo;
	}
	

	
}
