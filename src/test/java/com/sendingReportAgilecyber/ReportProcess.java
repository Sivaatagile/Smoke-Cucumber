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
				
				"Please find the attached test report : \r\n" + "Date of Report Generation : " + currentDate +"\r\n"+ "Total Number of scenarios : 67\r\n" + "Passed : 63\r\n"
						+ "Failed : 04\r\n" + "Details : Listed 63 scenarios are working fine\r\n"
						+"Four scenarios failed due to emulator overload issues."
				,
				reportPath);
	}

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		sendReport();
	}

}
