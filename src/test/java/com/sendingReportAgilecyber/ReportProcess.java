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
		Base.sendEmailWithReport("developer@agilecyber.com", "Cucumber Test Report for Staging Environment",
				
				"Please find the attached test report : \r\n" + "Date of Report Generation : " + currentDate +"\r\n"+ "Total Number of scenarios : 44\r\n" + "Passed : 50\r\n"
						+ "Failed : 03\r\n" + "Details : Listed 47 scenarios are working fine\r\n"
						+"03 failed scenarios has created a ticket and mentioned in uat sheet."
				,
				reportPath);
	}

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		sendReport();
	}

}
