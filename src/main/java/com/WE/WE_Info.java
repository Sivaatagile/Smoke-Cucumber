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
	
@FindBy(xpath = "//*[starts-with(@hint,'First')]")
   private WebElement FirstName;
   public WebElement getFirstName() {
       return FirstName;
   }

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
   
   @FindBy(xpath = "//android.view.View[@content-desc=\"Male\"]")
   private WebElement CustomerMale;
   public WebElement getCustomerMale() {
       return CustomerMale;
   }

   @FindBy(xpath = "//android.view.View[@content-desc=\"Female\"]")
   private WebElement CustomerFemale;
   public WebElement getCustomerFemale() {
       return CustomerFemale;
   }

   @FindBy(xpath = "//*[starts-with(@content-desc,'Phone number')]/following-sibling::android.widget.EditText[1]")
   private WebElement PhoneNumber;
   public WebElement getPhoneNumber() {
       return PhoneNumber;
   }

   @FindBy(xpath = "//*[starts-with(@hint,'Address line 1')]")
   private WebElement AddressLine1;
   public WebElement getAddressLine1() {
       return AddressLine1;
   }

   @FindBy(xpath = "//*[starts-with(@hint,'Address line 2')]")
   private WebElement AddressLine2;
   public WebElement getAddressLine2() {
       return AddressLine2;
   }

   @FindBy(xpath = "//*[starts-with(@hint,'City')]")
   private WebElement CityTown;
   public WebElement getCityTown() {
       return CityTown;
   }

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

   @FindBy(xpath = "//android.view.View[@content-desc=\"United Kingdom\"]")
   private WebElement CountryTab;
   public WebElement getCountryTab() {
       return CountryTab;
   }

   @FindBy(xpath ="//android.view.View[@content-desc=\"Continue\"]")
   private WebElement Continue;
   public WebElement getContinue() {
       return Continue;
   }

//---------------------------------------------------------------------------------- PET DATA 	

	@FindBy(xpath = "//*[starts-with(@hint,'Name')]")
	private WebElement Pet_Name;
	public WebElement getPet_Name() {
	    return Pet_Name;
	}

	@FindBy(xpath = "//*[starts-with(@hint,'Date of')]")
	private WebElement Date_Of_Birth;
	public WebElement getDate_Of_Birth() {
	    return Date_Of_Birth;
	}

	@FindBy(xpath = "//android.widget.SeekBar")
	private List<WebElement> Date_Format;
	public List<WebElement> getDate_Format() {
	    return Date_Format;
	}

	@FindBy(xpath = "//android.widget.Button[@content-desc='popupselect']")
	private WebElement Select;
	public WebElement getSelect() {
	    return Select;
	}
	
	@FindBy(xpath = "//*[starts-with(@hint,'Size')]")
	private WebElement Size;
	public WebElement getSize() {
		return Size;
	}
		
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

	@FindBy(xpath = "//android.view.View[@content-desc='Dismiss']")
	private WebElement Dismiss;
	public WebElement getDismiss() {
	    return Dismiss;
	}

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

	@FindBy(xpath = "//android.widget.Button[@content-desc='bottom_sheet_menuReset']")
	private WebElement Bottomresetbutton;
	public WebElement getBottomresetbutton() {
	    return Bottomresetbutton;
	}

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

	@FindBy(xpath = "//android.view.View[@content-desc='Size']")
	private WebElement BottomSheetSize;
	public WebElement getBottomSheetSize() {
	    return BottomSheetSize;
	}

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
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Spayed/Neutered\"]")
	private WebElement Behavioral_Information1;
	public WebElement getBehavioral_Information1() {
	    return Behavioral_Information1;
	}

	@FindBy(xpath = "//android.view.View[@content-desc=\"Human friendly\"]")
	private WebElement Behavioral_Information2;
	public WebElement getBehavioral_Information2() {
	    return Behavioral_Information2;
	}

	@FindBy(xpath = "//android.view.View[@content-desc=\"Vaccinated\"]")
	private WebElement Behavioral_Information3;
	public WebElement getBehavioral_Information3() {
	    return Behavioral_Information3;
	}

	@FindBy(xpath = "//android.view.View[@content-desc=\"Save\"]")
	private WebElement Save;
	public WebElement getSave() {
	    return Save;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"All Customers\"]")
	private WebElement  AllCustomers;
	public WebElement getAllCustomers() {
		return AllCustomers;
	}
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Close App\"]")
	private static WebElement closeApp;
	public static WebElement getcloseApp() {
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
