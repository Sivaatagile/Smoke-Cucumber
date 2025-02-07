package cucumberStepDefinition;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.WE.WE_Staff_Workflow;
import com.baseClass.Base;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Staff extends Base{
	WE_Staff_Workflow workflow = new WE_Staff_Workflow(driver);

	
	
	public static boolean isDateWithinRange(Date serviceDate, Date startDate, Date endDate) {
	    return !serviceDate.before(startDate) && !serviceDate.after(endDate);
	}
	
	public static void ServiceAvailableDate() throws Exception {
		WE_Staff_Workflow workflow = new WE_Staff_Workflow(driver);

	    
	    SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM dd, yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
	    
        Date date = inputFormat.parse(Booking.Booked_Date);

        String outputDate = outputFormat.format(date);
	    
	    
	    
	    String serviceAvailableDate = getProperty("SERVICE_AVAILABLE_DATE");
	    
	    DateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
	    Date serviceDate = dateFormat.parse(outputDate);
	    
	    DateFormat dayFormat = new SimpleDateFormat("d");
	    String serviceDay = dayFormat.format(serviceDate);
	    
	    WebElement dateRangeElement = workflow.getDateRangeElement();
	    String currentRange = dateRangeElement.getAttribute("content-desc");
	    String[] dateParts = currentRange.split(" - ");
	    Date startDate = dateFormat.parse(dateParts[0]);
	    Date endDate = dateFormat.parse(dateParts[1]);

	    while (!isDateWithinRange(serviceDate, startDate, endDate)) {
	        if (serviceDate.after(endDate)) {
	            ClickonElement(workflow.getNext_DateRange());
	        } else if (serviceDate.before(startDate)) {
	            ClickonElement(workflow.getPrevious_DateRange());
	        }
	        dateRangeElement = workflow.getDateRangeElement();
	        currentRange = dateRangeElement.getAttribute("content-desc");
	        dateParts = currentRange.split(" - ");
	        startDate = dateFormat.parse(dateParts[0]);
	        endDate = dateFormat.parse(dateParts[1]);
	    }
	    
	    System.out.println("Service Available Date is within the range: " + currentRange);

	    List<WebElement> dateElements = workflow.getDateElements();
	    for (WebElement element : dateElements) {
	        String contentDesc = element.getAttribute("content-desc");
	        
	        // Extract day from contentDesc, e.g., "Thursday, June 5, 2025" -> "5"
	        String[] descParts = contentDesc.split(" ");
	        String elementDay = descParts[2].replace(",", ""); // Assuming day is the 3rd part (e.g., "5")
	        
	        if (elementDay.equals(serviceDay)) {
	            element.click();
	            System.out.println("Clicked on date: " + contentDesc);
	            break;
	        }
	    }
	}

	
	
	@Given("Staff selects the booked date")
	public void staffSelectsTheBookedDate() throws Exception {

		ClickonElement(workflow.getPending());
		System.out.println("dndjcjc   "+Booking.Booked_Date);
		ServiceAvailableDate();
	}
	@When("Staff selects the booking and taps Start")
	public void staffSelectsTheBookingAndTapsStart() {
		ClickonElement(workflow.getStartAll());


	}
	@Then("Verify the checkbox is checked while starting the booking")
	public void verifyTheCheckboxIsCheckedWhileStartingTheBooking() {

		ClickonElement(workflow.getCheckBox1());
		ClickonElement(workflow.getCheckBox2());
		ClickonElement(workflow.getyes());
	}
	@Then("Capture the snackbar message")
	public void captureTheSnackbarMessage() throws InterruptedException {

		By errorMessageLocator = By.xpath("//android.view.View[@content-desc=\"You can't complete future bookings.\"]");

		// Wait for 1 second
		Thread.sleep(1000);

		// Check if the locator is displayed
		if (driver.findElements(errorMessageLocator).size() > 0) {
		    System.out.println("Good");
		} else {
		    System.out.println("Bad");
		}
	}
	
	
	
	
	
		
	@Given("the staff start the task")
	public void theStaffStartTheTask() throws Exception {
		
		
		
		
	}

}
