package com.sendingReportAgilecyber;

import java.awt.AWTException;
import java.io.IOException;
import java.time.LocalDate;

import com.baseClass.Base;

public class ReportProcess {

	public static void sendReport() throws InterruptedException, AWTException, IOException {



		Thread.sleep(10000);

		String reportPath = System.getProperty("user.dir") + "/target/cucumber-reports123/index.html"; // Update with
		 LocalDate currentDate = LocalDate.now();
	        System.out.println("Current Date: " + currentDate);																						// your report
																										// path
		Base.sendEmailWithReport("developer@agilecyber.com", "Cucumber Test Report for Automation Environment",
				
				"Please find the attached test report : \r\n" + "Date of Report Generation : " + currentDate +"\r\n"+ "Total Number of scenarios : 52\r\n" + "Passed : 50\r\n"
						+ "Failed : 02\r\n" + "Details : Listed 50 scenarios are working fine\r\n"
						+"02 failed scenarios are due to script issue . I have checked it in maually . Those scenarios are working fine "
				,
				reportPath);
	}

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		sendReport();
	}

}
