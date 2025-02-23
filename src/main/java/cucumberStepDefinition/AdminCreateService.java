package cucumberStepDefinition;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.WE.WE_Admin_Services;
import com.WE.WE_Info;
import com.WE.WE_Snackbar;
import com.api.Api;
import com.baseClass.Base;

import io.cucumber.java.en.*;

public class AdminCreateService extends Base {

	WE_Admin_Services Service = new WE_Admin_Services(driver);
	WE_Info info = new WE_Info(driver);
	Api api = new Api(driver);
	WE_Snackbar snack = new WE_Snackbar(driver);

    public static void selectSlot(List<String> slotList) throws Exception {
		WE_Admin_Services Service = new WE_Admin_Services(driver);
		Collections.reverse(slotList);
		WebElement Firstslot = driver
				.findElement(By.xpath("//android.view.View[@content-desc='" + slotList.get(0) + "']"));
		ClickonElement(Firstslot);
		for (String slot : slotList) {
			boolean isSlotFound = false;
			while (!isSlotFound) {
				try {
					WebElement slotElement = driver
							.findElement(By.xpath("//android.view.View[@content-desc='" + slot + "']"));
					slotElement.click();
					isSlotFound = true;
					System.out.println("Slot clicked: " + slot);
				} catch (NoSuchElementException e) {
					System.out.println("Slot not found, scrolling...");
                    slowScroll();
				}
			}
		}
	}

	@Given("the admin taps on Show All under services")
	public void theAdminTapsOnShowAllUnderServices() throws InterruptedException {
		ClickonElement(Service.getService_Showall());
	}

	@Given("the admin is navigated to the services's list page")
	public void theAdminIsNavigatedToTheServicesSListPage() throws InterruptedException {
	   waitForElement(Service.getAllServices());
	}
	
	@Given("the admin taps the plus button to create a new service")
	public void theAdminTapsThePlusButtonToCreateANewService() {
		ClickonElement(Service.getFab_Service());	
	}
	
	@Given("the admin select the service while creating a service")
	public void theAdminSelectTheServiceWhileCreatingAService() {
		ClickonElement(Service.getService());
	}

	@When("the admin enters {string} in the service name input field")
	public void theAdminEntersInTheServiceNameInputField(String string) {
		ClickonElement(Service.getService_name());
		passInput(Service.getService_name(), getProperty(string));
		driver.hideKeyboard();
	}

	@When("the admin provides {string} in the service description field")
	public void theAdminProvidesInTheServiceDescriptionField(String string) {
		ClickonElement(Service.getDescription_textbox());
		passInput(Service.getDescription_textbox(), getProperty("SERVICE_DESCRIPTION"));
		driver.hideKeyboard();
	}

	@When("the admin fetches the overall slot list using the API")
	public void theAdminFetchesTheOverallSlotListUsingTheAPI() throws Exception {
		Api.OverallSlotList();
		selectSlot(api.slotNames);
	}

	@When("the admin sets the {string} for {int} to {int} pets")
	public void theAdminSetsTheForToPets(String string, Integer int1, Integer int2) throws Exception {
		slowscrolluntilelementfound(Service.getFirstElement());
		ClickonElement(Service.getFirstElement());
		passInput(Service.getFirstElement(), getProperty("BASE_PRICE_AMOUNT"));
		driver.hideKeyboard();
		Thread.sleep(1000);
		slowscrolluntilelementfound(Service.getFourthElement());
		int BasePrice_size = Service.getBaseprice().size();
		System.out.println("size of Base list  : " + BasePrice_size);
		Thread.sleep(1000);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(500);
			Service.getBaseprice().get(i).click();
			Thread.sleep(500);
			passInput(Service.getBaseprice().get(i), getProperty("BASE_PRICE_AMOUNT"));
			driver.hideKeyboard();
			Thread.sleep(500);
		}
	}

	@When("the admin selects {string} from the tab")
	public void theAdminSelectsFromTheTab(String string) throws Exception {
		if (isElementAvailable(Service.getMaximum_capacity())) {
			ClickonElement(Service.getMaximum_capacity());
			passInput(Service.getMaximum_capacity(), getProperty("MAX_CAPACITY_SLOT"));
			driver.hideKeyboard();
		}else {
			slowScroll();
			ClickonElement(Service.getMaximum_capacity());
			passInput(Service.getMaximum_capacity(), getProperty("MAX_CAPACITY_SLOT"));
			driver.hideKeyboard();	
		}	
	}

	@When("the admin sets the {string} for the service")
	public void theAdminSetsTheForTheService(String string) {
		ClickonElement(Service.getMaximum_capacity_Per_Staff());
		passInput(Service.getMaximum_capacity_Per_Staff(), getProperty("MAX_CAPACITY_STAFF"));
		driver.hideKeyboard();
	}

	@When("the admin sets the {string}")
	public void theAdminSetsThe(String string) throws Exception {
		slowscrolluntilelementfound(Service.getMax_Advance_Booking_Limit());
		ClickonElement(Service.getMax_Advance_Booking_Limit());
		passInput(Service.getMax_Advance_Booking_Limit(), getProperty("MAX_ADVANCE_BOOKING_LIMIT"));
		driver.hideKeyboard();
	}

	@When("the admin provides {string} and {string} dates")
	public void theAdminProvidesAndDates(String string, String string2) throws Exception {
		slowscrolluntilelementfound(Service.getfrom());
		ClickonElement(Service.getFrom_DateDetails());
		waitForElement(Service.getFrom());
		String From_Month = Service.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + From_Month);
		String From_Date = Service.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + From_Date);
		String From_Year = Service.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + From_Year);
		Thread.sleep(1000);
		ClickonElement(Service.getSelect1());
		Thread.sleep(1000);
		slowscrolluntilelementfound(Service.getto());
		ClickonElement(Service.getTo_DateDetails());
		waitForElement(Service.getTo());
		scrollUntilElementFound_DatePicker_Time1(Service.getMonth(), Service.ToMonthExpected);
		String To_Month = Service.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + To_Month);
		scrollUntilElementFound_DatePicker_Time1(Service.getDate(), Service.ToDateExpected);
		String To_Date = Service.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + To_Date);
		scrollUntilElementFound_DatePicker_Time1(Service.getYear(), Service.ToYearExpected);
		String To_Year = Service.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + To_Year);
		Thread.sleep(1000);
		ClickonElement(Service.getSelect1());
		Thread.sleep(500);
	}

	@When("the admin taps the save button")
	public void theAdminTapsTheSaveButton() throws InterruptedException {
		Thread.sleep(500);
		ClickonElement(Service.getService_Save());
	}

	@When("the admin verifies the snackbar after creating the new service")
	public void theAdminVerifiesTheSnackbarAfterCreatingTheNewService() throws InterruptedException {
		waitForElement(snack.getRecordCreatedSuccessfully());
	}
	
	@When("the admin verifies the snackbar after creating the new service with addon")
	public void theAdminVerifiesTheSnackbarAfterCreatingTheNewServiceWithAddon() throws InterruptedException {
		waitForElement(snack.getRecordCreatedSuccessfully());
	}
	
	@Then("the service should be created successfully")
	public void theServiceShouldBeCreatedSuccessfully() throws InterruptedException {
		   waitForElement(Service.getAllServices());
	}
	
	@Then("the addon should be created successfully")
	public void theAddonShouldBeCreatedSuccessfully() throws InterruptedException {
		   waitForElement(Service.getAllServices());
	}

	@When("the admin select the addon for this service")
	public void theAdminSelectTheAddonForThisService() throws Exception {
	   ClickonElement(Service.getAddons());
		Thread.sleep(1000);
        scrollUntilElementFound(Service.getscrollview(), Service.getprivilege);
		clickOnElementUsingBy(Service.getprivilege);
		ClickonElement(Service.getSelect());
		Thread.sleep(1000);
		ClickonElement(Service.getAddons1());
		Thread.sleep(1000);
        scrollUntilElementFound(Service.getscrollview(), Service.getAssignableAddon);
		clickOnElementUsingBy(Service.getAssignableAddon);
		ClickonElement(Service.getSelect());
	}
	
}
