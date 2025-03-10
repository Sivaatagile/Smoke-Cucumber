package cucumberStepDefinition;

import com.WE.WE_Admin_User;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Info;
import com.WE.WE_Snackbar;
import com.baseClass.Base;

import io.cucumber.java.en.*;

public class AdminCreateTag extends Base {
	WE_Admin_User user = new WE_Admin_User(driver);
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
	WE_Info info = new WE_Info(driver);
	WE_Snackbar snack = new WE_Snackbar(driver);

	@Given("Admin clicks on Show All under tag categories")
	public void theAdminClicksOnShowAllUnderTagCategories() throws Exception {
		Thread.sleep(5000);
		halfscrollUntilElementFound12(user.getTagscrollview(), user.getTagCategoriesShowall());
		Thread.sleep(1000);
		ClickonElement(user.getTagCategoriesShowall());
	}

	@Then("Admin is navigated to the Tag's list page")
	public void theAdminIsNavigatedToTheTagSListPage() throws InterruptedException {
	   waitForElement(user.getTagCategories());
	}
	
	@Given("Admin taps the plus button to create a new tag category")
	public void theAdminTapsThePlusButtonToCreateANewTagCategory() {
		ClickonElement(user.getFAB());
	}

	@When("Admin enters {string} in the category name input field")
	public void theAdminEntersInTheCategoryNameInputField(String TagCategoryName) {
		ClickonElement(user.getCategoryName());
		passInput(user.getCategoryName(), getProperty(TagCategoryName));
		driver.hideKeyboard();
	}

	@When("Admin selects default from the tabs")
	public void theAdminSelectsDefaultFromTheTabs() {
		System.out.println("Default the user tab is selected");
	}

	@When("Admin sets {string} as the maximum entity level")
	public void theAdminSetsAsTheMaximumEntityLevel(String MaximumEntityLevel) {
		ClickonElement(user.getMaximumEntityLevel());
		passInput(user.getMaximumEntityLevel(), getProperty(MaximumEntityLevel));
		driver.hideKeyboard();
	}

	@When("Admin provides a {string} in the description field")
	public void theAdminProvidesAInTheDescriptionField(String CategoryDescription) throws InterruptedException {
		ClickonElement(user.getDecsription());
		passInput(user.getDecsription(), getProperty(CategoryDescription));
		driver.hideKeyboard();
	}

	@When("Admin enters {string} in the tag name field")
	public void theAdminEntersInTheTagNameField(String TagName) throws InterruptedException {
		ClickonElement(user.getTagName());
		passInput(user.getTagName(), getProperty(TagName));
		driver.hideKeyboard();
	}

	@When("Admin provides {string} in the tag description field")
	public void theAdminProvidesInTheTagDescriptionField(String TagDescription) throws InterruptedException {
		ClickonElement(user.getTagDescription());
		passInput(user.getTagDescription(), getProperty(TagDescription));
		driver.hideKeyboard();
	}

	@When("Admin clicks on the tick button")
	public void theAdminClicksOnTheTickButton() {
		ClickonElement(user.getTickButton());
	}

	@When("Admin click on the save button")
	public void theAdminClickOnTheSaveButton() throws InterruptedException {
		ClickonElement(user.getSave());
		System.out.println("Check the snack bar ");
	}

	@Then("The new Tag details should be successfully saved")
	public void theNewTagDetailsShouldBeSuccessfullySaved() throws InterruptedException {
		waitForElement(user.getTagCategories());
	}

}
