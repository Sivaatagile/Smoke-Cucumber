package com.WE;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.Base;

import io.appium.java_client.android.AndroidDriver;

public class WE_Staff_Workflow extends Base{

	public WE_Staff_Workflow(AndroidDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver1, this);
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"my_schedule_Pending\"]")
	private WebElement   Pending;
	public WebElement getPending() {
		return Pending;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Completed\"]")
	private WebElement   Completed;
	public WebElement getCompleted() {
		return Completed;
	}
	
	@FindBy (xpath ="(//android.view.View[@content-desc=\"Start All\"])[1]")
	private WebElement   StartAll;
	public WebElement getStartAll() {
		return StartAll;
	}
	
	@FindBy (xpath ="(//android.view.View[@content-desc=\"Complete All\"])[1]")
	private WebElement   CompleteAll;
	public WebElement getCompleteAll() {
		return CompleteAll;
	}
	
	@FindBy (xpath ="//android.widget.ScrollView/android.widget.ImageView[6]")
	private WebElement   Start;
	public WebElement getStart() {
		return Start;
	}
	
	@FindBy (xpath ="//android.widget.ScrollView/android.widget.ImageView[6]")
	private WebElement   complete;
	public WebElement getcomplete() {
		return complete;
	}
	
	@FindBy (xpath ="//android.view.View[contains(@content-desc, '/')]")
	private WebElement   DateRangeElement;
	public WebElement getDateRangeElement() {
		return DateRangeElement;
	}
	
	@FindBy (xpath ="//android.view.View[contains(@content-desc, ',')]")
	private List<WebElement>   DateElements;
	public List<WebElement> getDateElements() {
		return DateElements;
	}
	
	@FindBy (xpath ="//android.view.View[contains(@content-desc, '/')]/preceding-sibling::android.view.View[2]")
	private WebElement   Previous_DateRange;
	public WebElement getPrevious_DateRange() {
		return Previous_DateRange;
	}
	
	@FindBy (xpath ="//android.view.View[contains(@content-desc, '/')]/following-sibling::android.view.View[1]")
	private WebElement   Next_DateRange;
	public WebElement getNext_DateRange() {
		return Next_DateRange;
	}
	
	@FindBy (xpath ="//android.widget.CheckBox[1]")
	private WebElement   CheckBox1;
	public WebElement getCheckBox1() {
		return CheckBox1;
	}
	
	@FindBy (xpath ="//android.widget.CheckBox[2]")
	private WebElement   CheckBox2;
	public WebElement getCheckBox2() {
		return CheckBox2;
	}
	
	@FindBy (xpath ="//android.widget.Button[contains(@content-desc,'yes')]")
	private WebElement   yes;
	public WebElement getyes() {
		return yes;
	}
	
	
}
