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
		By sales = By.xpath("//android.view.View[@content-desc=\"sales\"]/following-sibling::android.view.View[@content-desc='"+"- "+""+book.TotalAmountWithSymbol+"']");
		System.out.println("yyy  :   "+sales);
		By payment = By.xpath("//android.view.View[@content-desc=\"Payment\"]/following-sibling::android.view.View[@content-desc='"+book.TotalAmountWithSymbol+"']");
		System.out.println("jjj  :   "+payment);
		System.out.println(book.Stripe);
		System.out.println(book.Crezco);

		System.out.println(book.ACCOUNTBALANCE);

		System.out.println(book.PAYLATER);

		if (book.Stripe) {
			By sales1 = By.xpath("//android.view.View[@content-desc=\"sales\"]/following-sibling::android.view.View[@content-desc='"+"- "+""+book.TotalAmountWithSymbol+"']");
			System.out.println("jjj  :   "+sales);
			By payment1 = By.xpath("//android.view.View[@content-desc=\"Payment\"]/following-sibling::android.view.View[@content-desc='"+book.TotalAmountWithSymbol+"']");
			System.out.println("hhhhh  :   "+payment1);
			
			if (isElementAvailable(payment)&&isElementAvailable(sales)) {
				System.out.println("Completed sales and payment  ");
				
			}else {
				System.out.println("hhhhhhhhhh");
			}
				
		}else if (book.Crezco) {
			By sales1 = By.xpath("//android.view.View[@content-desc=\"sales\"]/following-sibling::android.view.View[@content-desc='"+"- "+""+book.TotalAmountWithSymbol+"']");
			System.out.println("jjj  :   "+sales);
			By payment1 = By.xpath("//android.view.View[@content-desc=\"Payment\"]/following-sibling::android.view.View[@content-desc='"+book.TotalAmountWithSymbol+"']");
			System.out.println("hhhhh  :   "+payment1);
			
			if (isElementAvailable(payment)&&isElementAvailable(sales)) {
				System.out.println("Completed sales and payment  ");
				
			}else {
				System.out.println("hhhhhhhhhh");
			}
		} 
		else if (book.ACCOUNTBALANCE){
			
			By sales12 = By.xpath("//android.view.View[@content-desc=\"sales\"]/following-sibling::android.view.View[@content-desc='"+"- "+""+book.TotalAmountWithSymbol+"']");
			System.out.println(sales12);
			if (isElementAvailable(sales12)) {
				System.out.println("sales done");
			}
		}
			else if (book.PAYLATER){
				
				By sales123 = By.xpath("//android.view.View[@content-desc=\"sales\"]/following-sibling::android.view.View[@content-desc='"+"- "+""+book.TotalAmountWithSymbol+"']");
				System.out.println(sales123);
				if (isElementAvailable(sales123)) {
					System.out.println("sales done");
				}}
		}
	
	
}
	
	
	
	
	
	
	
