package com.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.Base;

import io.appium.java_client.android.AndroidDriver;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class Api extends Base {

//	private static final String BASE_URL = "https://staging.petcaretechnologies.com/api/";

	public static String token;
	public static String verifiedAccessToken;
	public static String VerifiedRefreshToken;
	public static String Max_allowed_date_for_booking;
	public static String available_date_from;
	public static String available_date_to;
	public static String advance_booking_requirement;
	public static String maximum_allowed_date_for_booking;
	public static int timeSlotsCount;
	public static int days;
	public static int DAYminAdvanceBooking;
	public static int DAYmaxAdvanceBooking;
	public static int TotalSlotCount;
	public static int priorityNumber;
	public static int TotalTagCount;
	public static List<String> slotNames;
	public static List<Integer> priorityList;
	public static List<String> tagIds;
	public static List<String> tagNames;
	public static List<String> BreedNames;
	public static List<String> ServiceNames;
	public static List<String> SlotNames;
	public static List<String> AddonsNames;
	public static List<String> TagNames;
	public static List<String> PricingRuleNames;
	public static List<String> PoolingNames;
	
	public static Integer serviceId;
	public static Integer slotId;
	public static Integer CustomerId;
	
	public static String UniqueBreed;
	public static String UniqueService;
	public static String UniqueSlot;
	public static String UniqueAddons;
	public static String UniqueTag;
	public static String Uniquepricingrulename;
	public static String Uniquepoolingname;



	
	public static List<String> notAvailableDates;

	public Api(AndroidDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver1, this);
	}

	public static String signInAdmin(String username) {

		JSONObject requestBody = new JSONObject();
		requestBody.put("email", username);
		Response response = RestAssured.given().header("Content-Type", "application/json")
				.header("X-API-Version", "100").header("User-Agent", "PostmanRuntime").body(requestBody.toString())
				.post(BASE_URL + "user/auth/mail-sign-in");
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
				.header("Authorization", "Bearer " + VerifiedRefreshToken).get(BASE_URL + "service/list/service"); 
		if (response.statusCode() == 200) {
			JSONObject responseObject = new JSONObject(response.asString());
			JSONArray servicesArray = responseObject.getJSONArray("data");
			String targetServiceName = getProperty("SERVICE_NAME"); 
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

	public static void Priority() {
		Response response = RestAssured.given().header("X-API-Version", "100").header("User-Agent", "PostmanRuntime")
				.header("Content-Type", "application/json") // Add any necessary headers here
				.header("Authorization", "Bearer " + VerifiedRefreshToken) // Replace with your actual token variable
				.get(BASE_URL + "service/availability-pricing-rule/list"); // Replace with your actual API endpoint
		System.out.println("Response Status Code: " + response.getStatusCode());
		String responseBody = response.getBody().asString();
		JSONObject jsonResponse = new JSONObject(responseBody);
		JSONArray dataArray = jsonResponse.getJSONArray("data");
		List<String> nameList = new ArrayList<>();
		priorityList = new ArrayList<>();
		for (int i = 0; i < dataArray.length(); i++) {
			JSONObject dataObject = dataArray.getJSONObject(i);
			String name = dataObject.getString("name");
			int priority = dataObject.getInt("priority");
			nameList.add(name);
			priorityList.add(priority);
		}
		System.out.println("Names: " + nameList);
		System.out.println("Priorities: " + priorityList);
	}

	public static void eliminatefrom100() {
		List<Integer> rangeList = new ArrayList<>();
		for (int i = 0; i <= 100; i++) {
			rangeList.add(i);
		}
		for (Integer priority : priorityList) {
			rangeList.remove(priority);
		}
		System.out.println("gggg  :  " + rangeList);
		if (!rangeList.isEmpty()) {
			priorityNumber = Collections.min(rangeList);
			System.out.println("Smallest number in range: " + priorityNumber);
		} else {
			System.out.println("Range list is empty.");
		}
	}

	public static void OverallTagList() {
		Response response = RestAssured.given().header("X-API-Version", "100").header("User-Agent", "PostmanRuntime")
				.header("Content-Type", "application/json") // Add any necessary headers here
				.header("Authorization", "Bearer " + VerifiedRefreshToken) // Replace with your actual token variable
				.get(BASE_URL + "user/list/add_tag_category"); // Replace with your actual API endpoint
		System.out.println("Response Status Code: " + response.getStatusCode());
		String responseBody = response.getBody().asString();
		JSONObject jsonResponse = new JSONObject(responseBody);
		int TotalTagCount = jsonResponse.getInt("recordsTotal");
		System.out.println("Records Total: " + TotalTagCount);
		JSONArray dataArray = jsonResponse.getJSONArray("data");
		List<String> formattedOutput = new ArrayList<>();
		for (int i = 0; i < dataArray.length(); i++) {
			JSONObject tag = dataArray.getJSONObject(i);
			String tagName = tag.getString("category_name");
			if (tag.has("subdata") && tag.getJSONArray("subdata").length() > 0) {
				JSONArray subdataArray = tag.getJSONArray("subdata");
				for (int j = 0; j < subdataArray.length(); j++) {
					JSONObject subdataItem = subdataArray.getJSONObject(j);
					String subName = subdataItem.getString("name"); // Extract the sub-name
					formattedOutput.add(tagName + " , " + subName);
				}
			} else {
				formattedOutput.add(tagName + " , No subdata available");
			}
		}
		for (String line : formattedOutput) {
			System.out.println(line);
		}
		System.out.println(formattedOutput);
	}
	
	private static Integer getServiceIdByName(JSONArray servicesArray, String serviceName) {
        for (int i = 0; i < servicesArray.length(); i++) {
            JSONObject service = servicesArray.getJSONObject(i);
            if (serviceName.equals(service.getString("name"))) {
                return service.getInt("id");
            }
        }
        return null; // Return null if service name is not found
    }
	
	private static Integer getSlotIdByName(JSONArray slotsArray, String slotName) {
        for (int i = 0; i < slotsArray.length(); i++) {
            JSONObject service = slotsArray.getJSONObject(i);
            if (slotName.equals(service.getString("name"))) {
                return service.getInt("id");
            }
        }
        return null; // Return null if service name is not found
    }
	
	private static Integer getCustomerIdByemail(JSONArray customerArray, String CustomerEmail) {
        for (int i = 0; i < customerArray.length(); i++) {
            JSONObject service = customerArray.getJSONObject(i);
            if (CustomerEmail.equals(service.getString("email"))) {
                return service.getInt("id");
            }
        }
        return null; // Return null if service name is not found
    }
	
	public static  void getserviceID(String serviceName) {
		Response response = RestAssured.given().header("X-API-Version", "100").header("User-Agent", "PostmanRuntime")
				.header("Content-Type", "application/json") // Add any necessary headers here
				.header("Authorization", "Bearer " + VerifiedRefreshToken) // Replace with your actual token variable
				.get(BASE_URL + "service/list/service");
		String responseBody = response.getBody().asString();
		
		 JSONObject responseObject = new JSONObject(responseBody);
	        JSONArray servicesArray = responseObject.getJSONArray("data");

	        // Extract the ID based on the service name
	         serviceId = getServiceIdByName(servicesArray, serviceName);

	        if (serviceId != null) {
	            System.out.println("The ID for the service \"" + serviceName + "\" is: " + serviceId);
	        } else {
	            System.out.println("Service name \"" + serviceName + "\" not found in the response.");
	        }

	}
	
	
	
	public static  void getslotID(String slotName) {
		Response response = RestAssured.given().header("X-API-Version", "100").header("User-Agent", "PostmanRuntime")
				.header("Content-Type", "application/json") // Add any necessary headers here
				.header("Authorization", "Bearer " + VerifiedRefreshToken) // Replace with your actual token variable
				.get(BASE_URL + "service/list/time_slots");
		String responseBody = response.getBody().asString();
		
		 JSONObject responseObject = new JSONObject(responseBody);
	        JSONArray servicesArray = responseObject.getJSONArray("data");

	        // Extract the ID based on the service name
	        slotId = getSlotIdByName(servicesArray, slotName);

	        if (slotId != null) {
	            System.out.println("The ID for the service \"" + slotName + "\" is: " + slotId);
	        } else {
	            System.out.println("Service name \"" + slotName + "\" not found in the response.");
	        }

	}

	
	
	
	public static  void getcustomerID(String CustomerEmail) {
		Response response = RestAssured.given().header("X-API-Version", "100").header("User-Agent", "PostmanRuntime")
				.header("Content-Type", "application/json") // Add any necessary headers here
				.header("Authorization", "Bearer " + VerifiedRefreshToken) // Replace with your actual token variable
				.get(BASE_URL + "user/list/user_management");
		String responseBody = response.getBody().asString();
		
		 JSONObject responseObject = new JSONObject(responseBody);
	        JSONArray servicesArray = responseObject.getJSONArray("data");

	        // Extract the ID based on the service name
	        CustomerId = getCustomerIdByemail(servicesArray, CustomerEmail);

	        if (CustomerId != null) {
	            System.out.println("The ID for the service \"" + CustomerEmail + "\" is: " + CustomerId);
	        } else {
	            System.out.println("Service name \"" + CustomerEmail + "\" not found in the response.");
	        }

	}
	
	
	
	public static  void NotAvailableDates(int serviceID , int slotID , int customerID , String Startdate , String EndDate) {

		JSONObject requestBody = new JSONObject();
		requestBody.put("service_id",serviceID );
		requestBody.put("slot_id", slotID);
		requestBody.put("start_date", Startdate);
		requestBody.put("end_date", EndDate);
		requestBody.put("customer_id", customerID);
		

	        // Send the POST request
	        Response response = RestAssured.given()
	                .contentType(ContentType.JSON)
	                .header("X-API-Version", "100").header("User-Agent", "PostmanRuntime")
					.header("Authorization", "Bearer " + VerifiedRefreshToken).body(requestBody.toString())
	                .get(BASE_URL + "booking/not-available-dates"); // Replace "/your-endpoint" with the specific API route

	        // Check if the response is successful
	        if (response.statusCode() == 200) {
	            System.out.println("Request successful!");

	            // Parse the response and extract `not_available_dates`
	             notAvailableDates = response.jsonPath().getList("not_available_dates");

	            // Print the dates
	            System.out.println("Not Available Dates:");
	            for (String date : notAvailableDates) {
	                System.out.println(date);
	            }
	        } else {
	            System.out.println("Request failed with status code: " + response.statusCode());
	            System.out.println("Response: " + response.body().asString());
	        }
	        
	        System.out.println(" list : ------------------------>       "+ notAvailableDates);
	    }
		
	
	
	public static  void BreedList() {
	
	       Response response = RestAssured.given()
	                .header("X-API-Version", "100")
	                .header("User-Agent", "PostmanRuntime")
	                .header("Content-Type", "application/json")
	                .header("Authorization", "Bearer " + VerifiedRefreshToken)
	                .get(BASE_URL + "user/list/beneficiary_subtype");

	        System.out.println("Response Status Code: " + response.getStatusCode());

	        String responseBody = response.getBody().asString();
	        JSONObject jsonResponse = new JSONObject(responseBody);
	        int TotalTagCount = jsonResponse.getInt("recordsTotal");
	        System.out.println("Records Total: " + TotalTagCount);

	        JSONArray dataArray = jsonResponse.getJSONArray("data");
	        BreedNames = new ArrayList<>();

	        for (int i = 0; i < dataArray.length(); i++) {
	            JSONObject tag = dataArray.getJSONObject(i);
	            BreedNames.add(tag.getString("name")); // tagName add panniruken
	        }

	        // Print the list
	        System.out.println("Tag Names List: " + BreedNames);
	}
	
	
	public static  void ServiceList() {
		
	       Response response = RestAssured.given()
	                .header("X-API-Version", "100")
	                .header("User-Agent", "PostmanRuntime")
	                .header("Content-Type", "application/json")
	                .header("Authorization", "Bearer " + VerifiedRefreshToken)
	                .get(BASE_URL + "service/list/service");

	        System.out.println("Response Status Code: " + response.getStatusCode());

	        String responseBody = response.getBody().asString();
	        JSONObject jsonResponse = new JSONObject(responseBody);
	        int TotalTagCount = jsonResponse.getInt("recordsTotal");
	        System.out.println("Records Total: " + TotalTagCount);

	        JSONArray dataArray = jsonResponse.getJSONArray("data");
	        ServiceNames = new ArrayList<>();

	        for (int i = 0; i < dataArray.length(); i++) {
	            JSONObject tag = dataArray.getJSONObject(i);
	            ServiceNames.add(tag.getString("name")); // tagName add panniruken
	        }

	        // Print the list
	        System.out.println("Tag Names List: " + ServiceNames);
	}
	
	public static  void SlotList() {
		
	       Response response = RestAssured.given()
	                .header("X-API-Version", "100")
	                .header("User-Agent", "PostmanRuntime")
	                .header("Content-Type", "application/json")
	                .header("Authorization", "Bearer " + VerifiedRefreshToken)
	                .get(BASE_URL + "service/list/time_slots");

	        System.out.println("Response Status Code: " + response.getStatusCode());

	        String responseBody = response.getBody().asString();
	        JSONObject jsonResponse = new JSONObject(responseBody);
	        int TotalTagCount = jsonResponse.getInt("recordsTotal");
	        System.out.println("Records Total: " + TotalTagCount);

	        JSONArray dataArray = jsonResponse.getJSONArray("data");
	        SlotNames = new ArrayList<>();

	        for (int i = 0; i < dataArray.length(); i++) {
	            JSONObject tag = dataArray.getJSONObject(i);
	            SlotNames.add(tag.getString("name")); // tagName add panniruken
	        }

	        // Print the list
	        System.out.println("Tag Names List: " + SlotNames);
	}
	
	public static  void AddonList() {
		
	       Response response = RestAssured.given()
	                .header("X-API-Version", "100")
	                .header("User-Agent", "PostmanRuntime")
	                .header("Content-Type", "application/json")
	                .header("Authorization", "Bearer " + VerifiedRefreshToken)
	                .get(BASE_URL + "/service/list/add_ons");

	        System.out.println("Response Status Code: " + response.getStatusCode());

	        String responseBody = response.getBody().asString();
	        JSONObject jsonResponse = new JSONObject(responseBody);
	        int TotalTagCount = jsonResponse.getInt("recordsTotal");
	        System.out.println("Records Total: " + TotalTagCount);

	        JSONArray dataArray = jsonResponse.getJSONArray("data");
	        AddonsNames = new ArrayList<>();

	        for (int i = 0; i < dataArray.length(); i++) {
	            JSONObject tag = dataArray.getJSONObject(i);
	            AddonsNames.add(tag.getString("name")); // tagName add panniruken
	        }

	        // Print the list
	        System.out.println("Tag Names List: " + AddonsNames);
	}
	
	public static  void TagList() {
		
	       Response response = RestAssured.given()
	                .header("X-API-Version", "100")
	                .header("User-Agent", "PostmanRuntime")
	                .header("Content-Type", "application/json")
	                .header("Authorization", "Bearer " + VerifiedRefreshToken)
	                .get(BASE_URL + "/user/list/add_tag_category");

	        System.out.println("Response Status Code: " + response.getStatusCode());

	        String responseBody = response.getBody().asString();
	        JSONObject jsonResponse = new JSONObject(responseBody);
	        int TotalTagCount = jsonResponse.getInt("recordsTotal");
	        System.out.println("Records Total: " + TotalTagCount);

	        JSONArray dataArray = jsonResponse.getJSONArray("data");
	        TagNames = new ArrayList<>();

	        for (int i = 0; i < dataArray.length(); i++) {
	            JSONObject tag = dataArray.getJSONObject(i);
	            TagNames.add(tag.getString("category_name")); // tagName add panniruken
	        }

	        // Print the list
	        System.out.println("Tag Names List: " + TagNames);
	}
	
	public static  void PricingRuleList() {
		
	       Response response = RestAssured.given()
	                .header("X-API-Version", "100")
	                .header("User-Agent", "PostmanRuntime")
	                .header("Content-Type", "application/json")
	                .header("Authorization", "Bearer " + VerifiedRefreshToken)
	                .get(BASE_URL + "/service/availability-pricing-rule/list");

	        System.out.println("Response Status Code: " + response.getStatusCode());

	        String responseBody = response.getBody().asString();
	        JSONObject jsonResponse = new JSONObject(responseBody);
	        int TotalTagCount = jsonResponse.getInt("recordsTotal");
	        System.out.println("Records Total: " + TotalTagCount);

	        JSONArray dataArray = jsonResponse.getJSONArray("data");
	        PricingRuleNames = new ArrayList<>();

	        for (int i = 0; i < dataArray.length(); i++) {
	            JSONObject tag = dataArray.getJSONObject(i);
	            PricingRuleNames.add(tag.getString("name")); // tagName add panniruken
	        }

	        // Print the list
	        System.out.println("Tag Names List: " + PricingRuleNames);
	}
	
	public static  void PoolingList() {
		
	       Response response = RestAssured.given()
	                .header("X-API-Version", "100")
	                .header("User-Agent", "PostmanRuntime")
	                .header("Content-Type", "application/json")
	                .header("Authorization", "Bearer " + VerifiedRefreshToken)
	                .get(BASE_URL + "service/service-pools/list");

	        System.out.println("Response Status Code: " + response.getStatusCode());

	        String responseBody = response.getBody().asString();
	        JSONObject jsonResponse = new JSONObject(responseBody);
	        int TotalTagCount = jsonResponse.getInt("recordsTotal");
	        System.out.println("Records Total: " + TotalTagCount);

	        JSONArray dataArray = jsonResponse.getJSONArray("data");
	        PoolingNames = new ArrayList<>();

	        for (int i = 0; i < dataArray.length(); i++) {
	            JSONObject tag = dataArray.getJSONObject(i);
	            PoolingNames.add(tag.getString("name")); // tagName add panniruken
	        }

	        // Print the list
	        System.out.println("Tag Names List: " + PoolingNames);
	}
	
	public static  void Compare( String Key,String UniqueBreed, List<String> Api_list ,String TextDocumentPath) throws IOException {
		 String filePath = workspacePath + getProperty("file_path"); // Path to the .properties file
		    String textFilePath = workspacePath + "/" +TextDocumentPath;
		    File file = new File(filePath);
		    List<String> fileLines = new ArrayList<>();
		    String updatedValue = null;
        List<String> list2 = new ArrayList<>();
   
        try (BufferedReader br = new BufferedReader(new FileReader(textFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                list2.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Find missing breeds from list2 that are NOT in list1
        List<String> missingBreeds = new ArrayList<>();
        for (String breed : list2) {
            if (!Api_list.contains(breed)) {
                missingBreeds.add(breed);
            }
        }

        // Pick one random missing breed if available
        if (!missingBreeds.isEmpty()) {
            Random random = new Random();
            UniqueBreed = missingBreeds.get(random.nextInt(missingBreeds.size())); // Pick random breed
            System.out.println("Selected missing breed: " + UniqueBreed);
        } else {
            System.out.println("No missing breeds found. All breeds in list2 exist in list1.");
        }
        
   	    boolean isUpdated = false;
	    
	    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            if (line.startsWith(Key + "=")) {
	                line = Key + "=" + UniqueBreed;
	                isUpdated = true;
	            }
	            fileLines.add(line);
	        }
	    }
	    
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
	        for (String fileLine : fileLines) {
	            writer.write(fileLine);
	            writer.newLine();
	        }
	    }
	    
	    if (isUpdated) {
	        System.out.println("Updated " + Key + ": " + UniqueBreed);
	    } else {
	        System.out.println("Key not found: " + Key);
	    }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
        
        
        
    public static List<String> filterDates(List<String> dateList, LocalDate fromDate, LocalDate toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Adjust format if needed

        return dateList.stream()
                .map(date -> LocalDate.parse(date, formatter)) // Convert String to LocalDate
                .filter(date -> date.isBefore(fromDate) || date.isAfter(toDate)) // Filter dates
                .map(date -> date.format(formatter)) // Convert LocalDate back to String
                .collect(Collectors.toList());
    }
        
    
    public static List<LocalDate> getRemainingDates(List<String> dateList, LocalDate fromDate, LocalDate toDate) {
    	   // Convert dateList from String to LocalDate
        List<LocalDate> bookedDates = dateList.stream()
                .map(LocalDate::parse) // Convert String to LocalDate
                .collect(Collectors.toList());

        // Generate full range of dates from fromDate to toDate
        List<LocalDate> fullDateRange = Stream.iterate(fromDate, date -> date.plusDays(1))
                .limit(toDate.toEpochDay() - fromDate.toEpochDay() + 1)
                .collect(Collectors.toList());

        // Remove booked dates from the full range
        fullDateRange.removeAll(bookedDates);

        return fullDateRange;
    }
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		method1("First");
		signInAdmin(getProperty("PREDEFINED_ADMIN_EMAIL"));
		verifyOtp(getProperty("PREDEFINED_ADMIN_OTP"));
//		OverallTagList();
		
		
		BreedList();
		Compare("BREED_Name",UniqueBreed, BreedNames, getProperty("BREED"));
		ServiceList();
		Compare("SERVICE_NAME", UniqueService, ServiceNames, getProperty("SERVICE"));
		SlotList();
		Compare("SLOT_NAME", UniqueSlot, SlotNames, getProperty("SLOTS"));
		AddonList();
		Compare("ADDON_PRIVILAGE", UniqueAddons, AddonsNames, getProperty("ADDON"));
		Compare("ADDON_ASSIGNABLE", UniqueAddons, AddonsNames, getProperty("ADDON"));
		TagList();
		Compare("ADMIN_TAG_CATEGORY_NAME", UniqueTag, TagNames, getProperty("TAGS"));
		PricingRuleList();
		Compare("Pricingrulename_Onetime_premium", Uniquepricingrulename, PricingRuleNames, getProperty("PREMIUM_PRICINGRULE_NAME"));
		Compare("Pricingrulename_Onetime_discount", Uniquepricingrulename, PricingRuleNames, getProperty("DISCOUNT_PRICINGRULE_NAME"));
		Compare("Pricingrulename_Onetime_notavailable", Uniquepricingrulename, PricingRuleNames, getProperty("NOTAVAILABLE_PRICINGRULE_NAME"));
        PoolingList();
        Compare("POOL_NAME", Uniquepoolingname, PoolingNames, getProperty("POOL"));

		
		

//		getserviceID("Customized Dog Life Journals");
//		getslotID("EvengdJLWZGOB");
//		getcustomerID("testmobileacs+2402@gmail.com");
//		NotAvailableDates(serviceId, slotId, CustomerId, "2025-01-01", "2025-03-31");
//
//		method1("First");
//		System.out.println(UniqueBreed);
//		refreshAdminToken(VerifiedRefreshToken);
//		Priority();
//		eliminatefrom100();
//System.out.println(serviceId);
//
//		  List<String> dateList = List.of("2024-02-15", "2024-03-20"); // Already booked dates
//
//	        LocalDate fromDate = LocalDate.of(2024, 2, 1);
//	        LocalDate toDate = LocalDate.of(2024, 4, 1);
//
//	        List<LocalDate> remainingDates = getRemainingDates(dateList, fromDate, toDate);
//	System.out.println(remainingDates);
	
	}

}
