Feature: Booking Application Sanity Flow 

 Scenario: Launch application in emulator
    Given PropertyFile Loaded
    And  Configure driver
    And  Api configuration
    And  Open the application
    Then Successfully navigated to the login screen
    
 Scenario: User signs up using email as customer
    Given the user clicks on the Sign Up button
    When  the user enters their "SIGNUP_EMAIL" address
    And the user clicks on the Continue button
    Then the user receives an OTP in their email
    When the user enters the OTP received in the email
    Then the user should be signed up successfully
    
 Scenario: User fills out their information after signing up
    Given the user has successfully signed up
    When the user is on the user info page
    And the user should see fields for first name, last name, gender, phone number, address line 1, address line 2, city/town, pincode, and country
    And the user enters their first name "SIGNUP_FIRSTNAME"
    And the user enters their last name "SIGNUP_LASTNAME"
    And the user selects their gender
    And the user enters their phone number "SIGNUP_PHONENUMBER"
    And the user enters address line 1 "SIGNUP_ADDRESSLINE"
    And the user enters address line 2 "SIGNUP_ADDRESSLINE"
    And the user enters their city/town "SIGNUP_CITYTOWN"
    And the user enters their pincode "SIGNUP_POSTCODE"
    And the user selects their country
    And the user clicks on the Continue button
    Then the user should be taken to the pet info page
  
 Scenario: User fills out pet information after entering user info    
    Given the user navigates to the pet info page
    When the user should see fields for pet name, gender, size, breed, dietary issues, allergies, vet name, vet address, vet phone number, microchip details, contact person name, contact person's phone number, special instructions, feeding schedules, additional contacts, and behavioral information
    And the user enters the pet's name "PET_NAME"
    And the user selects the pet's gender
    And  the use need to select the birth of dog
    And the user selects the pet's size
    And the user selects the pet's breed
    And the user enters any dietary issues "PET_DIETARY_ISSUES"
    And the user enters any allergies "PET_ALLERGIES"
    And the user enters the vet's name "PET_VETNAME"
    And the user enters the vet's address "PET_VETADDRESS"
    And the user enters the vet's phone number "PET_VETPHONENUMBER"
    And the user enters the microchip number "PET_MICROCHIP"
    And the user enters the contact person's name "PET_CONTACT_PERSONNAME"
    And the user enters the contact person's phone number "PET_CONTACT_PERSONNUMBER"
    And the user enters any special instructions "PET_SPECIAL_INSTRUCTIONS"
    And the user enters the feeding schedule "PET_FEEDING_DETAILS"
    And the user enters any additional contacts "PET_ADDITIONAL_CONTACT"
    And the user provides behavioral information
    And the user clicks on the Save button
    Then the pet information should be saved successfully
    
 Scenario:  User navigates to landing screen
    Given the user navigates to the landing page
    
 Scenario: Clearing the application cache and opening the application
  	Given the admin clears the application cache
  	When the admin opens the application
  	Then the application launches successfully
  	And the admin is navigated to the login page (or home page if already logged in)
    
 Scenario:  User login using email as admin (predefined account)
    Given the user enters their predefined "PREDEFINED_ADMIN_EMAIL" address
    When the user clicks on the Continue button
    And the user enters the Predefined Otp "PREDEFINED_ADMIN_OTP"
    Then the user should be logged in successfully
    
 Scenario: Approving a signed-up customer request in the admin portal
    Given  the admin clicks on the Users tab
    When clicks on the Pending Requests showall option
    And searches for the signup customer name 
    Then the matching customer list is displayed
    When the admin clicks on the customer name 
    And scrolls down to find the Accept button and click it
    Then a confirmation popup is displayed then the admin clicks on the Confirm button in the popup
    Then the customer request is successfully approved
    And the admin is navigated back to the home page
    
 Scenario: Adding a new admin through the admin portal
    Given the admin clicks on the Users tab
 		When the admin clicks on Admin's Show All
		Then the admin is navigated to the admin's list page
		When the admin clicks on the + button to add a new admin
		And the admin enters the first name "ADMIN_ADMIN_FIRST_NAME"
		And the admin enters the last name "ADMIN_ADMIN_LAST_NAME"
		And the admin enters the email "ADMIN_ADMIN_EMAIL"
		And the admin selects the gender
		And the admin enters the admin phone number "ADMIN_ADMIN_CONTACTNUMBER"
		And the admin enters the additional contact number "ADMIN_ADMIN_ADDITIONAL_CONTACT_NUMBER"
		And the admin enters the address line for admin 1
		And the admin enters the address line for admin 2
		And the admin selects the country
		And the admin enters the city or town "ADMIN_ADMIN_CITY"
		And the admin enters the post code "ADMIN_ADMIN_POSTCODE"
		And the admin clicks on the Save button
		Then the new admin details should be successfully saved
		When the admin clicks on the Back button
		And the admin taps the Home icon
		Then the admin is navigated back to the home page
    
    
 Scenario: Successfully create a tag category  
    Given the admin clicks on the Users tab
    And the admin click on Show All under tag categories  
    And the admin tap the plus button to create a new tag category  
    When the admin enter "ADMIN_TAG_CATEGORY_NAME" in the category name input field  
    And the admin select default from the tabs  
    And the admin set "ADMIN_TAG_MAXIMUM_ENTITY_LEVEL" as the maximum entity level  
    And the admin provide a "ADMIN_TAG_CATEGORY_DESCRIPTION" in the description field  
    And the admin enter "ADMIN_TAG_TAGS_NAME1" in the tag name field  
    And the admin provide "ADMIN_TAG_TAGS_DESCRIPTION1" in the tag description field  
    And the admin click on the tick button  
    And the admin click on the save button  
		Then the new Tag details should be successfully saved
  	When the admin clicks on the Back button
  	And the admin taps the Home icon
  	Then the admin is navigated back to the home page
     
 Scenario: Successfully create a slot  
    Given  the admin navigates to the Service tab  
    And the admin clicks on Show All under slots  
    And the admin taps the plus button to create a new slot  
    When the admin enters "SLOT_NAME" in the slot name input field  
    And the admin provides "SLOT_DESCRIPTION" in the slot description field  
    And sets Slot Starting Time as the starting time for the slot  
    And the admin clicks on the save button  
    Then the slot should be created successfully  
    When the admin clicks on the Back button
    And the admin taps the Home icon
    
 Scenario: Successfully create a service  
    Given  the admin navigates to the Service tab  
    And the admin taps on Show All under services  
    And the admin taps the plus button to create a new service  
    When the admin enters "Service Name" in the service name input field  
    And the admin provides "Description" in the service description field  
    And the admin fetches the overall slot list using the API  
    And the admin sets the "Base Price" for 1 to 4 pets  
    And the admin selects "Capacity Type" from the tab  
    And the admin sets the "Maximum Capacity" for the service  
    And the admin sets the "Maximum Capacity per Staff"  
    And the admin sets the "Maximum Advance Booking Limit"  
    And the admin provides "Service Validity From" and "Service Validity To" dates  
    And the admin taps the save button  
    Then the service should be created successfully  
    When the admin clicks on the Back button
    And the admin taps the Home icon
    
     Scenario: Adding a new staff through the admin portal
  	Given the admin clicks on the Users tab
  	When the admin clicks on Staff's Show All
  	Then the admin is navigated to the staff list page
 		When the admin clicks on the + button to add a new staff
  	And the admin enters the first name "ADMIN_STAFF_FIRST_NAME"
  	And the admin enters the last name "ADMIN_STAFF_LAST_NAME"
  	And the admin enters the email "ADMIN_STAFF_EMAIL"
  	And the admin selects the gender for Staff
  	And the admin enters the Contact number "ADMIN_STAFF_CONTACTNUMBER"
  	And the admin enters the additional contact number "ADMIN_STAFF_ADDITIONAL_CONTACT_NUMBER"
  	And the admin enters the address line for staff 1
  	And the admin enters the address line for staff 2
  	And the admin selects the country
  	And the admin enters the city or town "ADMIN_STAFF_CITY"
  	And the admin enters the post code "ADMIN_STAFF_POSTCODE"
  	And the admin clicks on the Skills dropdown and selects the staff's skill
  	When the admin clicks on the Save button
  	Then the new staff details should be successfully saved
  	When the admin clicks on the Back button
  	And the admin taps the Home icon
  	Then the admin is navigated back to the home page
  
  
  Scenario:  create a breed
   
    Given the admin navigates to the Settings tab 
    And the user opens the Manage Breed section
    When the user clicks on the Plus button to add a new breed
    And the user enters Breed Name in the breed name field
    And the admin taps the save button
    Then the user should see a confirmation message of Breed creation
    When the admin clicks on the Back button
  	And the admin taps the Home icon
  	Then the admin is navigated back to the home page
 
 Scenario:  create a new service pool
Given the admin navigates to the Settings tab 
  When the user navigates to Manage Service Pools
  And the user clicks on the Plus button to add a new pool
  And the user enters Pool Name 
  And the user enters Pool Remarks 
  And the user enters Pool Capacity 
  And the user clicks on the Save button
  Then the user should see a confirmation message Pool creation
  When the admin clicks on the Back button
  	And the admin taps the Home icon
  	Then the admin is navigated back to the home page
  
  Scenario:  create a pricing rule  
  Given the admin navigates to the Settings tab 
    When the user navigates to Pricing Rule  
    And the user clicks on the FAB button to add a new pricing rule  
    And the user enters Pricing Rule Name as Single Date Premium  
    And the user enters Pricing Rule Description as Rule for premium pricing on a single date  
    And the user enters Pricing Rule Priority 
    And the user enters Pricing Rule type
    And the user enters the pricing off set value
    And the user clicks on the Save button  
    Then the user should see a confirmation message Pricing Rule creation
     When the admin clicks on the Back button
  	And the admin taps the Home icon
  	Then the admin is navigated back to the home page
  
 Scenario: Successfully logout Admin 
    Given the admin navigates to the Settings tab  
    And the admin clicks on the logout button  
    Then the admin should be logged out successfully  
    
    Scenario:  Customer login using email (already created by admin)
    Given the user enters their  "SIGNUP_EMAIL" address
    When the user clicks on the Continue button
    And the user enters the Otp 
    Then the user should be logged in successfully
    
 Scenario: Create a Booking
    Given User selects a service
    When User fetches the slot list for the selected service using the API
    And User selects a random slot from the slot list, scrolling the slot picker if necessary
    And User determines the From Date and To Date for the service based on constraints
    And User calculates the date range and picks a random date
    And User navigates to the random date's month using the right arrow
    And User selects the random date and User taps the Request Booking button
    Then User should successfully navigate to the Confirm Booking Details page
    And User verifies the service name, date, and slot
    And User taps the Proceed button
    Then User navigates to the Review Booking page
    And User reviews the total amount and remaining credit amount
    And User taps the checkbox and User taps the Confirm and Pay button
    Then User initiates the payment process
    Then User navigates to the Booking Request Successful page
    And User saves the booking details
    And User taps the My Bookings button
    Then User navigates to the My Bookings page
    And User verifies that the booking is listed on the My Bookings page

  Scenario: Verify Customer Invoice Details
    Given the customer navigates to the Settings tab
    When the user clicks on Invoice
    And the user selects the first invoice
    Then the user checks the service locator and booking date locator 
    And the user goes back to the home page
    
  Scenario: Verify Customer Statement Details
    Given the customer navigates to the Settings tab
    When the user clicks on Statements
    And the user selects the current month
    Then the user checks if the saved invoice number is listed
    And the user goes back to the home page
    
    
     Scenario: Successfully logout customer
    Given the customer navigates to the Settings tab  
    And the customer clicks on the logout button  
    Then the customer should be logged out successfully 
    
 Scenario:  User login using email as admin (predefined account)
    Given the user enters their predefined "PREDEFINED_ADMIN_EMAIL" address
    When the user clicks on the Continue button
    And the user enters the Predefined Otp "PREDEFINED_ADMIN_OTP"
    Then the user should be logged in successfully
    
     #Scenario: admin statement covered 
    #Given admin statement 
    
  Scenario: Approving a booking
    Given the user navigates to the Pending tab
    When the user selects the booking's service from the Service dropdown, opens the Date & Slot dropdown, and selects the booked date and slot
    And the user applies the toggle button
    Then the booking should move to the Unassigned tab

  Scenario: Assigning a booking
    Given the user navigates to the Unassigned tab
    When the user selects the booking's service from the Service dropdown, opens the Date & Slot dropdown, and selects the booked date and slot
    And the user selects the specific booking
    And the user assigns the booking to a staff member
    Then the booking should be assigned successfully
    
     Scenario: Successfully logout Admin 
    Given the admin navigates to the Settings tab  
    And the admin clicks on the logout button  
    Then the admin should be logged out successfully  
   
    Scenario:  Staff login using email (already created by admin)
    Given the user enters their  "ADMIN_STAFF_EMAIL" address
    When the user clicks on the Continue button
    And the user enters the Otp 
    Then the user should be logged in successfully
    
    