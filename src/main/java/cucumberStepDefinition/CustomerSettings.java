package cucumberStepDefinition;

import org.openqa.selenium.By;

import com.WE.WE_Customer_Settings;
import com.baseClass.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerSettings extends Base {
	Booking book = new Booking();
	WE_Customer_Settings statement = new WE_Customer_Settings(driver);
	
	
	@Given("Accounts given by the customer")
	public void accountsGivenByTheCustomer() throws InterruptedException {		
		ClickonElement(statement.getSettingsTab());
	} 

	@When("the customer clicks on Accounts")
	public void theCustomerClicksOnAccounts() {
		ClickonElement(statement.getAccounts());
	}
	
	@When("Verify the sales or payment detais are listed their")
	public void verifyTheSalesOrPaymentDetaisAreListedTheir() throws InterruptedException {
		Thread.sleep(10000);
		By sales = By.xpath("//android.view.View[@content-desc=\"Sales\"]/following-sibling::android.view.View[@content-desc='"+"- "+""+book.TotalAmountWithSymbol+"']");
		System.out.println("yyy  :   "+sales);
		By payment = By.xpath("//android.view.View[@content-desc=\"Payment\"]/following-sibling::android.view.View[@content-desc='"+book.TotalAmountWithSymbol+"']");
		System.out.println("jjj  :   "+payment);
		System.out.println(book.Stripe);
		System.out.println(book.Crezco);
		System.out.println(book.ACCOUNTBALANCE);
		System.out.println(book.PAYLATER);
		System.out.println(book.sale);

		
		if (book.TotalAmountWithSymbol.equals("£ 0.00")) {
			By sales1 = By.xpath(
					"//android.view.View[@content-desc=\"Sales\"]/following-sibling::android.view.View[@content-desc='"
							+ book.TotalAmountWithSymbol + "']");
			if (isElementAvailable(sales1)) {
				System.out.println("sales done11111111111111");
			}
		}
		
		else if (book.PartialPayment) {
			By sales1 = By.xpath(
					"//android.view.View[@content-desc=\"Sales\"]/following-sibling::android.view.View[@content-desc='"
							+ "- " + "" + book.TotalAmountWithSymbol + "']");
			System.out.println("jjj  :   " + sales1);
			By payment1 = By.xpath(
					"//android.view.View[@content-desc=\"Payment\"]/following-sibling::android.view.View[@content-desc='"
							+ "£ " + book.partialAmount + "']");
			System.out.println("hhhhh  :   " + payment1);

			if (isElementAvailable(payment1) && isElementAvailable(sales1)) {
				System.out.println("Completed sales and payment 222222222 ");

			} else {
				System.out.println("hhhhhhhhhh2222222222222");
			}
		}
		
		else if (book.Stripe || book.Crezco) {
			By sales1 = By.xpath(
					"//android.view.View[@content-desc=\"Sales\"]/following-sibling::android.view.View[@content-desc='"
							+ "- " + "" + book.TotalAmountWithSymbol + "']");
			System.out.println("jjj  :   " + sales1);
			By payment1 = By.xpath(
					"//android.view.View[@content-desc=\"Payment\"]/following-sibling::android.view.View[@content-desc='"
							+ book.TotalAmountWithSymbol + "']");
			System.out.println("hhhhh  :   " + payment1);

			if (isElementAvailable(payment1) && isElementAvailable(sales1)) {
				System.out.println("Completed sales and payment ugfyegfyegfe ");

			} else {
				System.out.println("ehcgedfcecvtect");
			}

		}

	   else if (book.ACCOUNTBALANCE || book.PAYLATER) {

			By sales12 = By.xpath(
					"//android.view.View[@content-desc=\"Sales\"]/following-sibling::android.view.View[@content-desc='"
							+ "- " + "" + book.TotalAmountWithSymbol + "']");
			System.out.println(sales12);
			if (isElementAvailable(sales12)) {
				System.out.println("sales done33333333333333");
			}
		} 
	}
	
	@When("the admin check the adhoc type")
	public void theAdminCheckTheAdhocType() throws InterruptedException {
		String for_adhocPayment = for_adhocPayment(getProperty("Adhoc_amount"));
		
		if (Sold) {
	    	By sales1 = By.xpath(
					"//android.view.View[@content-desc=\"Ad-hoc\"]/following-sibling::android.view.View[@content-desc='" + "- " + "£ " + for_adhocPayment + "']");	
		System.out.println(sales1);
		Thread.sleep(2000);
		if (isElementAvailable(sales1)) {
			System.out.println("SOLD DONE");
		}
		else if (Collected) {
		    	By sales12 = By.xpath(
						"//android.view.View[@content-desc=\"Ad-hoc\"]/following-sibling::android.view.View[@content-desc='" + "£ " + for_adhocPayment + "']");	
			System.out.println(sales12);
			Thread.sleep(2000);
			if (isElementAvailable(sales12)) {
				System.out.println("collected DONE");
			}
		
		
	    }else {
			System.out.println("hhhhh");
		}
		
	
	
	
	    }}}
	

	
	
	
	
	
	
	
