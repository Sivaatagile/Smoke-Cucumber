package cucumberStepDefinition;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.WE.WE_Admin_Services;
import com.WE.WE_Info;
import com.api.Api;
import com.baseClass.Base;

import io.cucumber.java.en.*;

public class AdminCreateService extends Base {

	WE_Admin_Services Service = new WE_Admin_Services(driver);
	WE_Info info = new WE_Info(driver);
	Api api = new Api(driver);

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
					// Construct the dynamic XPath or locator for the slot
					WebElement slotElement = driver
							.findElement(By.xpath("//android.view.View[@content-desc='" + slot + "']"));
					// Click on the slot if found
					slotElement.click();
					isSlotFound = true;
					System.out.println("Slot clicked: " + slot);
				} catch (NoSuchElementException e) {
					// Slot not found, perform scroll action
					System.out.println("Slot not found, scrolling...");
					halfscroll(Service.getscrollview());
				}
			}
		}
	}

	@Given("the admin taps on Show All under services")
	public void theAdminTapsOnShowAllUnderServices() throws InterruptedException {
		ClickonElement(Service.getService_Showall());
		Thread.sleep(3000);
	}

	@Given("the admin taps the plus button to create a new service")
	public void theAdminTapsThePlusButtonToCreateANewService() {
		ClickonElement(Service.getFab_Service());
		ClickonElement(Service.getService());
	}

	@When("the admin enters {string} in the service name input field")
	public void theAdminEntersInTheServiceNameInputField(String string) {
		ClickonElement(Service.getService_name());
		passInput(Service.getService_name(), getProperty("SERVICE_NAME"));
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
		halfscrollUntilElementFound12(Service.getscrollview(), Service.getFirstElement());
		ClickonElement(Service.getFirstElement());
		passInput(Service.getFirstElement(), getProperty("BASE_PRICE_AMOUNT"));
		driver.hideKeyboard();
		Thread.sleep(2000);
		halfscrollUntilElementFound12(Service.getscrollview(), Service.getFourthElement());
		int BasePrice_size = Service.getBaseprice().size();
		System.out.println("size of Base list  : " + BasePrice_size);
		Thread.sleep(3000);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(3000);
			Service.getBaseprice().get(i).click();
			Thread.sleep(5000);
			passInput(Service.getBaseprice().get(i), getProperty("BASE_PRICE_AMOUNT"));
			driver.hideKeyboard();
			Thread.sleep(3000);
		}
	}

	@When("the admin selects {string} from the tab")
	public void theAdminSelectsFromTheTab(String string) {
		ClickonElement(Service.getMaximum_capacity());
		passInput(Service.getMaximum_capacity(), getProperty("MAX_CAPACITY_SLOT"));
		driver.hideKeyboard();
	}

	@When("the admin sets the {string} for the service")
	public void theAdminSetsTheForTheService(String string) {
		ClickonElement(Service.getMaximum_capacity_Per_Staff());
		passInput(Service.getMaximum_capacity_Per_Staff(), getProperty("MAX_CAPACITY_STAFF"));
		driver.hideKeyboard();
	}

	@When("the admin sets the {string}")
	public void theAdminSetsThe(String string) throws Exception {
		halfscrollUntilElementFound12(Service.getscrollview(), Service.getMax_Advance_Booking_Limit());
		ClickonElement(Service.getMax_Advance_Booking_Limit());
		passInput(Service.getMax_Advance_Booking_Limit(), getProperty("MAX_ADVANCE_BOOKING_LIMIT"));
		driver.hideKeyboard();
	}

	@When("the admin provides {string} and {string} dates")
	public void theAdminProvidesAndDates(String string, String string2) throws Exception {
		ClickonElement(Service.getFrom_DateDetails());
		waitForElement(Service.getFrom());
		String From_Month = Service.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + From_Month);
		String From_Date = Service.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + From_Date);
		String From_Year = Service.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + From_Year);
		Thread.sleep(4000);
		ClickonElement(Service.getSelect1());
		Thread.sleep(2000);
		ClickonElement(Service.getTo_DateDetails());
		waitForElement(Service.getTo());
		scrollUntilElementFound12(Service.getMonth(), Service.ToMonthExpected);
		String To_Month = Service.getMonth().getAttribute("Content-desc");
		System.out.println("Month  : " + To_Month);
		scrollUntilElementFound12(Service.getDate(), Service.ToDateExpected);
		String To_Date = Service.getDate().getAttribute("Content-desc");
		System.out.println("Date  : " + To_Date);
		scrollUntilElementFound12(Service.getYear(), Service.ToYearExpected);
		String To_Year = Service.getYear().getAttribute("Content-desc");
		System.out.println("Year  : " + To_Year);
		Thread.sleep(2000);
		ClickonElement(Service.getSelect1());
		Thread.sleep(2000);
	}

	@When("the admin taps the save button")
	public void theAdminTapsTheSaveButton() throws InterruptedException {
		Thread.sleep(2000);
		ClickonElement(Service.getService_Save());
	}

	@Then("the service should be created successfully")
	public void theServiceShouldBeCreatedSuccessfully() {
		System.out.println("Check the snack bar ");
	}

}
