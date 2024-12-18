package Hooks;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.baseClass.Base;

import io.cucumber.java.en.*;

public class hooks extends Base{
	 
	    public void beforeScenario() throws FileNotFoundException, IOException {
		method1("First");
		 UpdateEmailProperty("SIGNUP_EMAIL");
			UpdateNameProperty("PET_NAME");
			UpdateNameProperty("CUSTOMER_FIRSTNAME");
			UpdateEmailProperty("CUSTOMER_EMAIL");
			UpdateNameProperty("SERVICE_NAME");
			UpdateNameProperty("ADDON_PRIVILAGE");
			UpdateNameProperty("ADDON_ASSIGNABLE");
			UpdateNameProperty("ADDON_SERVICE_NAME");
			UpdateNameProperty("ADMIN_STAFF_FIRST_NAME");
			UpdateEmailProperty("ADMIN_STAFF_EMAIL");
			UpdateNameProperty("ADMIN_ADMIN_FIRST_NAME");
			UpdateEmailProperty("ADMIN_ADMIN_EMAIL");
			UpdateNameProperty("ADMIN_TAG_CATEGORY_NAME");
			UpdateNameProperty("ADMIN_BREED_NAME");
			UpdateNameProperty("SLOT_NAME");
			System.out.println("working fine");
	    }
}
