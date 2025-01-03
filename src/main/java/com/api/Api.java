package com.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.Base;

import io.appium.java_client.android.AndroidDriver;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class Api extends Base {

//	       https://paw-845-staging-automation-testing.petcaretechnologies.com/api/
//	      https://staging.petcaretechnologies.com/api/
//	private static final String BASE_URL = "https://paw-845-staging-automation-testing.petcaretechnologies.com/api/";
	private static final String BASE_URL = "https://staging.petcaretechnologies.com/api/";

	public static String token;
	public static String verifiedAccessToken;
	public static String VerifiedRefreshToken;
	public static int timeSlotsCount;
	public static String Max_allowed_date_for_booking;
	public static String available_date_from;
	public static String available_date_to;
	public static String advance_booking_requirement;
	public static String maximum_allowed_date_for_booking;
	public static int days;
	public static int DAYminAdvanceBooking;
	public static int DAYmaxAdvanceBooking;
	public static int TotalSlotCount;
	public static List<String> slotNames;
	public static List<Integer> priorityList;
	public static int priorityNumber;
	public static List<String> tagIds;
	public static List<String> tagNames;
	public static int  TotalTagCount;
	

	public Api(AndroidDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver1, this);
	}

	public static String signInAdmin(String username) {

		// Create a JSON object for the request body
		JSONObject requestBody = new JSONObject();
		requestBody.put("email", username);
//        requestBody.put("password", password);
		Response response = RestAssured.given().header("Content-Type", "application/json")
				.header("X-API-Version", "100").header("User-Agent", "PostmanRuntime").body(requestBody.toString())
				.post(BASE_URL + "/user/auth/mail-sign-in");
		token = response.jsonPath().getString("token");
		System.out.println("Admin Sign-in Token: " + token);
		return token;

	}

	public static String verifyOtp(String otp) {

		JSONObject requestBody = new JSONObject();
		requestBody.put("otp", otp);
		requestBody.put("token", token);
		requestBody.put("device_id", "e07061c9-acf1-432f-ad82-c065190f1201");
		requestBody.put("device_uuid", "e07061c9-acf1-432f-ad82-c065190f1201");
		requestBody.put("device_type", "web");
		Response response = RestAssured.given().header("Content-Type", "application/json")
				.header("X-API-Version", "100").header("User-Agent", "PostmanRuntime")
				.header("Authorization", "Bearer " + token).body(requestBody.toString())
				.post(BASE_URL + "/user/auth/token");
		System.out.println("response :  " + response);
		verifiedAccessToken = response.jsonPath().getString("access_token");
		System.out.println("OTP Verified Token 1 : " + verifiedAccessToken);
		VerifiedRefreshToken = response.jsonPath().getString("refresh_token");
		System.out.println("OTP Verified Token 2 : " + VerifiedRefreshToken);
		return VerifiedRefreshToken;

	}

	public static String refreshAdminToken(String Refresh) throws InterruptedException {

		JSONObject requestBody = new JSONObject();
		requestBody.put("token", Refresh);
		requestBody.put("device_id", "e07061c9-acf1-432f-ad82-c065190f1201");
		requestBody.put("device_uuid", "e07061c9-acf1-432f-ad82-c065190f1201");
		requestBody.put("device_type", "web");
		Response response = RestAssured.given().header("Content-Type", "application/json")
				.header("X-API-Version", "100").header("User-Agent", "PostmanRuntime")
				.header("Authorization", "Bearer " + VerifiedRefreshToken).body(requestBody.toString())
				.post(BASE_URL + "/user/auth/refresh_token");
		System.out.println("response :  " + response.asPrettyString());
		Thread.sleep(5000);
		String VerifiedRefreshToken1 = response.jsonPath().getString("refresh_token");
		System.out.println("New Refresh Token: " + VerifiedRefreshToken1);
		return verifiedAccessToken;

	}

	public static void ServiceSlotTimeCount() throws InterruptedException {
		Thread.sleep(15000);
		Response response = RestAssured.given().header("Content-Type", "application/json")
				.header("X-API-Version", "100").header("User-Agent", "PostmanRuntime")
				.header("Authorization", "Bearer " + VerifiedRefreshToken).get(BASE_URL + "service/list/service"); // replace
																													// with
																													// your
																													// actual
																													// endpoint
		if (response.statusCode() == 200) {
			JSONObject responseObject = new JSONObject(response.asString());
			JSONArray servicesArray = responseObject.getJSONArray("data");
			String targetServiceName = getProperty("SERVICE_NAME"); // replace with the desired service name
			boolean serviceFound = false;
			for (int i = 0; i < servicesArray.length(); i++) {
				JSONObject service = servicesArray.getJSONObject(i);
				String serviceName = service.getString("name");
				if (serviceName.equals(targetServiceName)) {
					timeSlotsCount = service.getInt("time_slots_id_count");
					Max_allowed_date_for_booking = service.getString("maximum_allowed_date_for_booking");
					available_date_from = service.getString("available_date_from");
					available_date_to = service.getString("available_date_to");
					advance_booking_requirement = service.getString("advance_booking_requirement");
					maximum_allowed_date_for_booking = service.getString("maximum_allowed_date_for_booking");
					JSONObject jsonObject = new JSONObject(Max_allowed_date_for_booking);
					days = jsonObject.getInt("day");
					System.out.println("Extracted Day: " + days);
					System.out.println("Service: " + serviceName + " | Time Slots Count: " + timeSlotsCount);
					System.out.println("Service: " + serviceName + " | Max_allowed_date_for_booking: "
							+ Max_allowed_date_for_booking);
					System.out.println("Service: " + serviceName + " | available_date_from: " + available_date_from);
					System.out.println("Service: " + serviceName + " | available_date_from: " + available_date_to);
					System.out.println(advance_booking_requirement);
					System.out.println(maximum_allowed_date_for_booking);
					JSONObject jsonObject1 = new JSONObject(advance_booking_requirement);
					try {
						if (jsonObject1.has("day") && !jsonObject1.isNull("day")) {
							DAYminAdvanceBooking = jsonObject1.getInt("day"); // Extract the integer value
						} else {
							DAYminAdvanceBooking = 0;
						}
					} catch (JSONException e) {
						System.out.println("Error extracting 'day'. Setting to default value 0.");
						DAYminAdvanceBooking = 0; // Set default value
					}
					JSONObject jsonObject2 = new JSONObject(maximum_allowed_date_for_booking);
					DAYmaxAdvanceBooking = jsonObject2.getInt("day");
					System.out.println("Extracted Day: " + DAYmaxAdvanceBooking);
					serviceFound = true;
					break; // Exit the loop once the service is found
				}
			}
			if (!serviceFound) {
				System.out.println("Service with name '" + targetServiceName + "' not found.");
			}
		} else {
			System.out.println("Failed to get the response. Status code: " + response.statusCode());
			System.out.println("Response: " + response.asString());
		}

	}

	public static void OverallSlotList() {
		Response response = RestAssured.given().header("X-API-Version", "100").header("User-Agent", "PostmanRuntime")
				.header("Content-Type", "application/json") // Add any necessary headers here
				.header("Authorization", "Bearer " + VerifiedRefreshToken) // Replace with your actual token variable
				.get(BASE_URL + "service/list/time_slots"); // Replace with your actual API endpoint
		System.out.println("Response Status Code: " + response.getStatusCode());
		String responseBody = response.getBody().asString();
		JSONObject jsonResponse = new JSONObject(responseBody);
		TotalSlotCount = jsonResponse.getInt("recordsTotal");
		System.out.println("Records Total: " + TotalSlotCount);
		JSONArray dataArray = jsonResponse.getJSONArray("data");
		slotNames = new ArrayList<>();
		for (int i = 0; i < dataArray.length(); i++) {
			JSONObject slot = dataArray.getJSONObject(i);
			String slotName = slot.getString("name");
			slotNames.add(slotName); // Add the slot name to the list
		}
		System.out.println("Slot Names: " + slotNames);
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	public static  void Priority() {

		
		   // Define the Base URL

        // Verified token variable (replace with actual token)

        // Send GET request using RestAssured
        Response response = RestAssured
                .given()
                .header("X-API-Version", "100")
                .header("User-Agent", "PostmanRuntime")
                .header("Content-Type", "application/json") // Add any necessary headers here
                .header("Authorization", "Bearer " + VerifiedRefreshToken) // Replace with your actual token variable
                .get(BASE_URL + "service/availability-pricing-rule/list"); // Replace with your actual API endpoint

        // Print the status code to verify the request was successful
        System.out.println("Response Status Code: " + response.getStatusCode());

        // Convert the response body to a String
        String responseBody = response.getBody().asString();

        // Parse the response body as a JSONObject
        JSONObject jsonResponse = new JSONObject(responseBody);

        // Extract the 'data' array
        JSONArray dataArray = jsonResponse.getJSONArray("data");

        // Initialize separate lists for names and priorities
        List<String> nameList = new ArrayList<>();
        priorityList = new ArrayList<>();

        // Loop through the array and extract names and priorities
        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject dataObject = dataArray.getJSONObject(i);
            String name = dataObject.getString("name");
            int priority = dataObject.getInt("priority");

            // Add values to respective lists
            nameList.add(name);
            priorityList.add(priority);
        }

        // Print the lists
        System.out.println("Names: " + nameList);
        System.out.println("Priorities: " + priorityList);
    
	}
	
	
	public static  void eliminatefrom100() {

		
		  List<Integer> rangeList = new ArrayList<>();
	        for (int i = 0; i <= 100; i++) {
	            rangeList.add(i);
	        }

	        // Remove all occurrences of priority numbers from the range list
	        for (Integer priority : priorityList) {
	            rangeList.remove(priority);
	        }
	        
	        System.out.println("gggg  :  "+ rangeList);
	        
	        
	        
	        
	        if (!rangeList.isEmpty()) {
	        	priorityNumber = Collections.min(rangeList);
	            System.out.println("Smallest number in range: " + priorityNumber);
	        } else {
	            System.out.println("Range list is empty.");
	        }
	}

	
	public static void OverallTagList() {
	    // Set the base URI for RestAssured

	    // Make the API request and capture the response
	    Response response = RestAssured
	            .given()
	            .header("X-API-Version", "100")
	            .header("User-Agent", "PostmanRuntime")
	            .header("Content-Type", "application/json")  // Add any necessary headers here
	            .header("Authorization", "Bearer " + VerifiedRefreshToken)  // Replace with your actual token variable
	            .get(BASE_URL + "user/list/add_tag_category");  // Replace with your actual API endpoint

	    // Print the status code to verify the request was successful
	    System.out.println("Response Status Code: " + response.getStatusCode());

	    // Convert the response body to a String
	    String responseBody = response.getBody().asString();

	    // Parse the response body as a JSONObject
	    JSONObject jsonResponse = new JSONObject(responseBody);

	    // Extract 'recordsTotal'
	    int TotalTagCount = jsonResponse.getInt("recordsTotal");
	    System.out.println("Records Total: " + TotalTagCount);

	    // Extract the 'data' array
	    JSONArray dataArray = jsonResponse.getJSONArray("data");

	    // Initialize a list to store formatted tag and subdata names
	    List<String> formattedOutput = new ArrayList<>();

	    // Loop through the array and format the output
	    for (int i = 0; i < dataArray.length(); i++) {
	        JSONObject tag = dataArray.getJSONObject(i);
	        String tagName = tag.getString("category_name");

	        // Check if the tag has 'subdata' and it's not empty
	        if (tag.has("subdata") && tag.getJSONArray("subdata").length() > 0) {
	            JSONArray subdataArray = tag.getJSONArray("subdata");

	            // Loop through each item in 'subdata'
	            for (int j = 0; j < subdataArray.length(); j++) {
	                JSONObject subdataItem = subdataArray.getJSONObject(j);
	                String subName = subdataItem.getString("name");  // Extract the sub-name

	                // Add the formatted tag and sub-name to the list
	                formattedOutput.add(tagName + " , " + subName);
	            }
	        } else {
	            // If there is no subdata for this tag
	            formattedOutput.add(tagName + " , No subdata available");
	        }
	    }

	    // Print the formatted output
	    for (String line : formattedOutput) {
	        System.out.println(line);
	    }
	    
	    
	    System.out.println(formattedOutput);
	}
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		method1("First");
		signInAdmin(getProperty("PREDEFINED_ADMIN_EMAIL"));
		verifyOtp(getProperty("PREDEFINED_ADMIN_OTP"));
		OverallTagList();
//		refreshAdminToken(VerifiedRefreshToken);
//		Priority();
//		eliminatefrom100();
		
	}

}
