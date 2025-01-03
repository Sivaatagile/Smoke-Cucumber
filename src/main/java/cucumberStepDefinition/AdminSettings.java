package cucumberStepDefinition;

import org.openqa.selenium.By;

import com.WE.WE_Admin_Settings;
import com.WE.WE_Admin_WorkFlow;
import com.baseClass.Base;
import com.frontend.Customer_Settings;

import io.cucumber.java.en.Given;

public class AdminSettings extends Base {

	@Given("admin statement")
	public void adminStatement() throws Exception {

		WE_Admin_Settings settings = new WE_Admin_Settings(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		ClickonElement(workflow.getSettings_navigation_Bar());
		ClickonElement(settings.getstatements());
		waitForElement(settings.getYearStatement());
		Thread.sleep(2000);
		ClickonElement(settings.getsearch());
		Thread.sleep(2000);
		passInput(settings.getsearch(), getProperty("SIGNUP_FIRSTNAME"));
		clickOnElementUsingBy(settings.SignupFirstname);

		Thread.sleep(5000);
		System.out.println(Booking.InvoiceNumber);
		By BookedPAYMENT1 = By.xpath("//android.view.View[@content-desc='#" + Booking.InvoiceNumber + "']");
		System.out.println(BookedPAYMENT1);
		halfscrollUntilElementFound12(settings.getscroll(), BookedPAYMENT1);
		if (isElementAvailable(BookedPAYMENT1)) {
			Thread.sleep(4000);
			System.out.println("hhh : " + Booking.StatementCreatedDate);
			Thread.sleep(3000);
			By statementcreateddatelocator = By
					.xpath("//android.view.View[@content-desc='" + Booking.StatementCreatedDate + "']");

			// android.view.View[@content-desc="Jan 01 2025"]
			if (isElementAvailable(statementcreateddatelocator)) {

				System.out.println("date showed");
				System.out.println("Bookings is listed on admins statement page ");
			}
		} else {
			System.out.println("Not listed");
		}

		Thread.sleep(1000);
		ClickonElement(settings.getgetback());
		Thread.sleep(2000);
		ClickonElement(settings.getgetback());
		ClickonElement(settings.gethometab());

	}

}
