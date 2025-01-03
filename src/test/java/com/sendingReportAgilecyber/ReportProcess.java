package com.sendingReportAgilecyber;

import java.awt.AWTException;
import java.io.IOException;

import com.baseClass.Base;

public class ReportProcess {

	public static void sendReport() throws InterruptedException, AWTException, IOException {

//		 try {
//			 
//			 String folderPath = System.getProperty("user.dir");
//			 System.out.println(folderPath);
//	            Runtime.getRuntime().exec("explorer.exe " + folderPath);
//	            Robot robot = new Robot();
//
//	            Thread.sleep(2000);
//
//	            robot.keyPress(KeyEvent.VK_F5);
//	            robot.keyRelease(KeyEvent.VK_F5);
//System.out.println("good ");
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//		 
//		 
//		 
//		 
//		  String projectPath = System.getProperty("user.dir") + "/target/cucumber-reports123/index.html";
//	        System.out.println("HTML file path: " + projectPath);
//
//	        // Open the HTML file
//	        try {
//	            File htmlFile = new File(projectPath);
//	            if (htmlFile.exists() && htmlFile.isFile()) {
//	                // Open the HTML file using the default application
//	                Desktop.getDesktop().open(htmlFile);
//	                System.out.println("HTML file opened successfully.");
//	            } else {
//	                System.out.println("HTML file does not exist: " + projectPath);
//	            }
//	        } catch (IOException e) {
//	            System.out.println("An error occurred while opening the HTML file: " + e.getMessage());
//	        }

		Thread.sleep(40000);

		String reportPath = System.getProperty("user.dir") + "/target/cucumber-reports123/index.html"; // Update with
																										// your report
																										// path
		Base.sendEmailWithReport("developer@agilecyber.com", "Cucumber Test Report",
				"Please find the attached test report:\r\n" + "Total Number of scenarios : 24\r\n" + "Passed : 24\r\n"
						+ "Failed : 00\r\n" + "Details : Listed 24 scenarios are working fine\r\n"
//	                + "When creating a service, an issue occurs with the base price field. Specifically, the No.of.Pets field is labeled as No.of.<Pets>, causing the element to not be identified correctly, which triggers an error.\r\n"
//	                + "\r\n"
//	                + "Error 2 and 3:\r\n"
//	                + "Semantic labels that were already declared are not being displayed, leading to further errors."
				,

				reportPath);
	}

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		sendReport();
	}

}
