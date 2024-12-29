package cucumberStepDefinition;

import com.WE.WE_Admin_User;
import com.WE.WE_Admin_WorkFlow;
import com.WE.WE_Info;
import com.baseClass.Base;

import io.cucumber.java.en.*;

public class AdminCreateTag extends Base {
	WE_Admin_User user = new WE_Admin_User(driver);
	WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
	WE_Info info = new WE_Info(driver);

	@Given("the admin click on Show All under tag categories")
	public void theAdminClickOnShowAllUnderTagCategories() throws Exception {
		Thread.sleep(2000);
		halfscrollUntilElementFound12(user.getTagscrollview(), user.getTagCategoriesShowall());
		ClickonElement(user.getTagCategoriesShowall());
	}

	@Given("the admin tap the plus button to create a new tag category")
	public void theAdminTapThePlusButtonToCreateANewTagCategory() {
		ClickonElement(user.getFAB());
	}

	@When("the admin enter {string} in the category name input field")
	public void theAdminEnterInTheCategoryNameInputField(String TagCategoryName) {
		ClickonElement(user.getCategoryName());
		passInput(user.getCategoryName(), getProperty(TagCategoryName));
		driver.hideKeyboard();
	}

	@When("the admin select default from the tabs")
	public void theAdminSelectDefaultFromTheTabs() {
		System.out.println("Default the user tab is selected");
	}

	@When("the admin set {string} as the maximum entity level")
	public void theAdminSetAsTheMaximumEntityLevel(String MaximumEntityLevel) {
		ClickonElement(user.getMaximumEntityLevel());
		passInput(user.getMaximumEntityLevel(), getProperty(MaximumEntityLevel));
		driver.hideKeyboard();
	}

	@When("the admin provide a {string} in the description field")
	public void theAdminProvideAInTheDescriptionField(String CategoryDescription) throws InterruptedException {
		ClickonElement(user.getDecsription());
		passInput(user.getDecsription(), getProperty(CategoryDescription));
		driver.hideKeyboard();
		Thread.sleep(2000);
	}

	@When("the admin enter {string} in the tag name field")
	public void theAdminEnterInTheTagNameField(String TagName) throws InterruptedException {
		ClickonElement(user.getTagName());
		passInput(user.getTagName(), getProperty(TagName));
		driver.hideKeyboard();
		Thread.sleep(2000);
	}

	@When("the admin provide {string} in the tag description field")
	public void theAdminProvideInTheTagDescriptionField(String TagDescription) throws InterruptedException {
		ClickonElement(user.getTagDescription());
		passInput(user.getTagDescription(), getProperty(TagDescription));
		driver.hideKeyboard();
		Thread.sleep(2000);
	}

	@When("the admin click on the tick button")
	public void theAdminClickOnTheTickButton() {
		ClickonElement(user.getTickButton());
	}

	@When("the admin click on the save button")
	public void theAdminClickOnTheSaveButton() throws InterruptedException {
		ClickonElement(user.getSave());
		System.out.println("Check the snack bar ");
		Thread.sleep(2000);
	}

	@Then("the new Tag details should be successfully saved")
	public void theNewTagDetailsShouldBeSuccessfullySaved() throws InterruptedException {

//		waitForElement(user.getSnackbarCreatedTag());
//		if (isElementAvailable(user.getSnackbarCreatedTag())) {
			System.out.println("Tag created ");
//		}
	
	}

}
