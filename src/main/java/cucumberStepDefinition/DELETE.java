package cucumberStepDefinition;

import org.openqa.selenium.By;

import com.WE.WE_Admin_User;
import com.baseClass.Base;

import io.cucumber.java.en.Then;

public class DELETE extends Base{
	WE_Admin_User user = new WE_Admin_User(driver);
	
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
}
