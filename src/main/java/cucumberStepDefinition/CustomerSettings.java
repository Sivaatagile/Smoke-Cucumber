package cucumberStepDefinition;

import org.openqa.selenium.By;

import com.WE.WE_Customer_Settings;
import com.baseClass.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerSettings extends Base {
	Booking book = new Booking();
	
	
	
	@Given("Accounts given by the customer")
	public void accountsGivenByTheCustomer() throws InterruptedException {

		WE_Customer_Settings statement = new WE_Customer_Settings(driver);
		ClickonElement(statement.getSettingsTab());
		ClickonElement(statement.getAccounts());
		Thread.sleep(10000);
		By sales = By.xpath("//android.view.View[@content-desc=\"sales\"]/following-sibling::android.view.View[@content-desc='"+"- "+""+book.TotalAmountWithSymbol+"']");
		System.out.println("yyy  :   "+sales);
		By payment = By.xpath("//android.view.View[@content-desc=\"Payment\"]/following-sibling::android.view.View[@content-desc='"+book.TotalAmountWithSymbol+"']");
		System.out.println("jjj  :   "+payment);
		
		if (book.Stripe) {
			//android.view.View[@content-desc="Payment"]/following-sibling::android.view.View[@content-desc="£ 999.99"]
//			By sales = By.xpath("//android.view.View[@content-desc=\"Payment\"]/following-sibling::android.view.View[@content-desc="+"-"+"'"+Booking.TotalAmountWithSymbol+"']");
//			System.out.println(sales);
//			By payment = By.xpath("//android.view.View[@content-desc=\"Payment\"]/following-sibling::android.view.View[@content-desc='"+Booking.TotalAmountWithSymbol+"']");
//			System.out.println(payment);
			
			
			By sales1 = By.xpath("//android.view.View[@content-desc=\"sales\"]/following-sibling::android.view.View[@content-desc='"+"- "+""+book.TotalAmountWithSymbol+"']");
			System.out.println("jjj  :   "+sales);
			By payment1 = By.xpath("//android.view.View[@content-desc=\"Payment\"]/following-sibling::android.view.View[@content-desc='"+book.TotalAmountWithSymbol+"']");
			System.out.println("hhhhh  :   "+payment1);
			
			
			
			
			if (isElementAvailable(payment)&&isElementAvailable(sales)) {
				System.out.println("Completed sales and payment  ");
				
			}else {
				System.out.println("hhhhhhhhhh");
			}
				
			
			
		}else {
			
			By sales12 = By.xpath("//android.view.View[@content-desc=\"sales\"]/following-sibling::android.view.View[@content-desc='"+"- "+""+book.TotalAmountWithSymbol+"']");
			System.out.println(sales12);
			
			if (isElementAvailable(sales12)) {
				System.out.println("sales done");
				
			}
			
		
		
	}
	
	
	
	} 
	
	
}
	
	
	
	
	
	
	
