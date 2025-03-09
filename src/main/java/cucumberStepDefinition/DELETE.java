package cucumberStepDefinition;

import org.openqa.selenium.By;

import com.WE.WE_Admin_Services;
import com.WE.WE_Admin_User;
import com.baseClass.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DELETE extends Base{
	WE_Admin_User user = new WE_Admin_User(driver);
	WE_Admin_Services Service = new WE_Admin_Services(driver);

	
////******************************************************* DELETE STAFF
	
	@Then("Admin chooses to delete and confirms the action")
	public void adminChoosesToDeleteAndConfirmsTheAction() {
		ClickonElement(user.getDelete());
		ClickonElement(user.getConfirm1());
	}
	
	@Then("the admin pick the category name from the list as {string}")
	public void theAdminPickTheCategoryNameFromTheListAs(String string) throws InterruptedException, Exception {
	    
		 By  searchingCategoryName= By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty(string)));
		if (!isElementAvailable(searchingCategoryName)) {
			slowscrolluntilelementfound(searchingCategoryName);
			clickOnElementUsingBy(searchingCategoryName);
		}else {
			clickOnElementUsingBy(searchingCategoryName);
		}
		
	}
	
	
//// ****************************************************** DELETE SERVICE	

	@Given("Admin wait for the service filter as {string}")
	public void adminWaitForTheServiceFilterAs(String string) throws InterruptedException {
		 By  Servicename= By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty(string)));
         waitForElementViewable(Servicename);
	}
	
	@Given("Admin tap the delete icon of the service as {string} and confirms the action")
	public void adminTapTheDeleteIconOfTheServiceAsAndConfirmsTheAction(String string) throws InterruptedException {
		 By  Servicename= By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]/following-sibling::android.widget.ImageView[1]", getProperty(string)));
         clickOnElementUsingBy(Servicename);
         ClickonElement(Service.getConfirm1());
		
	}
	
	@Given("Admin searches for the service name in the search box as {string}")
	public void adminSearchesForTheServiceNameInTheSearchBoxAs(String string) throws InterruptedException {
		Thread.sleep(1500);
		ClickonElement(Service.getSearchBox());
		passInput(Service.getSearchBox(), getProperty(string));
	}
////****************************************************DELETE ADDON
  
	@Given("Admin wait for the addon filter as {string}")
	public void adminWaitForTheAddonFilterAs(String string) throws InterruptedException {
		By  Servicename= By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty(string)));
        waitForElementViewable(Servicename);
		
	}
	@Given("Admin tap the delete icon of the addon as {string} and confirms the action")
	public void adminTapTheDeleteIconOfTheAddonAsAndConfirmsTheAction(String string) throws InterruptedException {
		By  Servicename= By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]/following-sibling::android.widget.ImageView[1]", getProperty(string)));
        clickOnElementUsingBy(Servicename);
        ClickonElement(Service.getConfirm1());
		
	}
	
	@Given("Admin searches for the Addon name in the search box as {string}")
	public void adminSearchesForTheAddonNameInTheSearchBoxAs(String string) throws InterruptedException {
		Thread.sleep(1500);
		ClickonElement(Service.getSearchBox());
		passInput(Service.getSearchBox(), getProperty(string));
	}
	
//// *************************************************** DELETE SLOT
 
	@Then("Admin wait for the slot filter as {string}")
	public void adminWaitForTheSlotFilterAs(String string) throws InterruptedException {
		 By  Slotname= By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty(string)));
         waitForElementViewable(Slotname);
	}
	@Then("Admin tap the delete icon of the slot as {string} and confirms the action")
	public void adminTapTheDeleteIconOfTheSlotAsAndConfirmsTheAction(String string) throws InterruptedException {
		 By  slotname= By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]/preceding-sibling::android.widget.ImageView[1]", getProperty(string)));
         clickOnElementUsingBy(slotname);
         ClickonElement(Service.getDelete());
		
	}
	@Then("Admin searches for the slot name in the search box as {string}")
	public void adminSearchesForTheSlotNameInTheSearchBoxAs(String string) throws InterruptedException {
		Thread.sleep(1500);

		ClickonElement(Service.getSearchBox());

		passInput(Service.getSearchBox(), getProperty(string));
		
	}
}
