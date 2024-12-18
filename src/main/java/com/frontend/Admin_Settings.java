package com.frontend;

import com.WE.WE_Admin_Settings;
import com.WE.WE_Admin_WorkFlow;
import com.baseClass.Base;

public class Admin_Settings extends Base{

	
	public static void CreateBreed() throws InterruptedException {
		WE_Admin_Settings settings = new WE_Admin_Settings(driver);
		WE_Admin_WorkFlow workflow = new WE_Admin_WorkFlow(driver);
		
		ClickonElement(workflow.getSettings_navigation_Bar());
		ClickonElement(settings.getManageBreeds());
		ClickonElement(settings.getFABBreed());
		ClickonElement(settings.getBreedName());
		passInputUsingActions(settings.getBreedName(), "Poodle 1");
		ClickonElement(settings.getSaveBreed());

	}
	
}
