package Hooks;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.baseClass.Base;
import com.google.i18n.phonenumbers.AsYouTypeFormatter;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.*;

public class hooks extends Base{
	 
//	 @AfterAll // Executes after all tests are completed
//	    public static void sendReport() throws InterruptedException, AWTException, IOException {
//		 
////		 try {
////			 
////			 String folderPath = System.getProperty("user.dir");
////			 System.out.println(folderPath);
////	            Runtime.getRuntime().exec("explorer.exe " + folderPath);
////	            Robot robot = new Robot();
////
////	            Thread.sleep(2000);
////
////	            robot.keyPress(KeyEvent.VK_F5);
////	            robot.keyRelease(KeyEvent.VK_F5);
////System.out.println("good ");
////	        } catch (InterruptedException e) {
////	            e.printStackTrace();
////	        }
////		 
////		 
////		 
////		 
////		  String projectPath = System.getProperty("user.dir") + "/target/cucumber-reports123/index.html";
////	        System.out.println("HTML file path: " + projectPath);
////
////	        // Open the HTML file
////	        try {
////	            File htmlFile = new File(projectPath);
////	            if (htmlFile.exists() && htmlFile.isFile()) {
////	                // Open the HTML file using the default application
////	                Desktop.getDesktop().open(htmlFile);
////	                System.out.println("HTML file opened successfully.");
////	            } else {
////	                System.out.println("HTML file does not exist: " + projectPath);
////	            }
////	        } catch (IOException e) {
////	            System.out.println("An error occurred while opening the HTML file: " + e.getMessage());
////	        }
//		 
//		 Thread.sleep(40000);
//		 
//	        String reportPath = System.getProperty("user.dir")+"/target/cucumber-reports123/index.html"; // Update with your report path
//	        Base.sendEmailWithReport(
//	                "sivagopaljen@gmail.com",
//	                "Cucumber Test Report",
//	                "Please find the attached test report.",
//	                reportPath
//	        );
//	    }
}
