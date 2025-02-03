
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
    And  the user needs to select the birth of dog
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

  Scenario: User navigates to landing screen
    Given the user navigates to the landing page

  Scenario: Clearing the application cache and opening the application
    Given the admin clears the application cache
    When the admin opens the application
    Then the application launches successfully
    And the admin is navigated to the login page (or home page if already logged in)

  Scenario: User login using email as admin (predefined account)
    Given the user enters their predefined "PREDEFINED_ADMIN_EMAIL" address
    When the user clicks on the Continue button
    And the user enters the Predefined Otp "PREDEFINED_ADMIN_OTP"
    Then the user should be logged in successfully

  Scenario: Approving a signed-up customer request in the admin portal
    Given the admin clicks on the Users tab
    When the admin clicks on the Pending Requests showall option
    And searches for the signup customer name 
    Then the matching customer list is displayed
    When the admin clicks on the customer name 
    And scrolls down to find the Accept button and clicks it
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
    
      Scenario: Adding a new customer through the admin portal
    Given the admin clicks on the Users tab
    When the admin clicks on Customer's Show All
    Then the admin is navigated to the Customer's list page
    When the admin clicks on the + button to add a new Customer
    And the admin enters the Customer first name "ADMIN_CUSTOMER_FIRSTNAME"
    And the admin enters the Customer last name "ADMIN_CUSTOMER_LASTNAME"
    And the admin enters the email "ADMIN_CUSTOMER_EMAIL"
    And the admin selects the gender
    And the admin enters the customer phone number "ADMIN_CUSTOMER_PHONENUMBER"
    And the admin enters the address line for customer 1
    And the admin enters the address line for customer 2
    And the admin selects the country
    And the admin enters the city or town "ADMIN_CUSTOMER_CITYTOWN"
    And the admin enters the post code "ADMIN_CUSTOMER_POSTCODE"
    And the admin clicks on the Save button
    Then the new customer details should be successfully saved
    When the admin clicks on the Back button
    And the admin taps the Home icon
    Then the admin is navigated back to the home page
    
    
  Scenario: Successfully create a tag category  
    Given the admin clicks on the Users tab
    And the admin clicks on Show All under tag categories  
    And the admin taps the plus button to create a new tag category  
    When the admin enters "ADMIN_TAG_CATEGORY_NAME" in the category name input field  
    And the admin selects default from the tabs  
    And the admin sets "ADMIN_TAG_MAXIMUM_ENTITY_LEVEL" as the maximum entity level  
    And the admin provides a "ADMIN_TAG_CATEGORY_DESCRIPTION" in the description field  
    And the admin enters "ADMIN_TAG_TAGS_NAME1" in the tag name field  
    And the admin provides "ADMIN_TAG_TAGS_DESCRIPTION1" in the tag description field  
    And the admin clicks on the tick button  
    And the admin clicks on the save button  
    Then the new Tag details should be successfully saved
    When the admin clicks on the Back button
    And the admin taps the Home icon
    Then the admin is navigated back to the home page

  Scenario: Successfully create a slot  
    Given the admin navigates to the Service tab  
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
    Given the admin navigates to the Service tab  
    And the admin taps on Show All under services  
    And the admin taps the plus button to create a new service
    And the admin select the service while creating a service  
    When the admin enters "SERVICE_NAME" in the service name input field  
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
    
      Scenario: Successfully create a Privilege Addon  
    Given the admin navigates to the Service tab  
    And the admin taps on Show All under services  
    And the admin taps the plus button to create a new addon
    And the admin select the Addon while creating a addon  
    When the admin enters "ADDON_PRIVILAGE" in the addon name input field  
    And the admin provides "ADDON_PRIVILAGE_DESCRIPTION" in the addon description field
    And the admin select the addon type "PRIVILEGE"  
    And the admin fetches the overall slot list using the API  
    And the admin sets the "ADDON_PRIVILAGE_BASE_PRICE_AMOUNT" for 1 to 4 pets for addon
    And the admin selects Capacity Type from the tab for addon 
    And the admin sets the "ADDON_PRIVILAGE_MAX_CAPACITY_SLOT" for the addon maximum capacity per slot  
    And the admin sets the "ADDON_PRIVILAGE_MAX_CAPACITY_STAFF" for addon maximum capacity per staff
    And the admin provides "Service Validity From" and "Service Validity To" dates for privilege addon
    And the admin taps the save button  
    Then the service should be created successfully  
    When the admin clicks on the Back button
    And the admin taps the Home icon
    
          Scenario: Successfully create a Assignable Addon  
    Given the admin navigates to the Service tab  
    And the admin taps on Show All under services  
    And the admin taps the plus button to create a new addon
    And the admin select the Addon while creating a addon  
    When the admin enters "ADDON_ASSIGNABLE" in the addon name input field  
    And the admin provides "ADDON_ASSIGNABLE_DESCRIPTION" in the addon description field
    And the admin select the addon type "ASSIGNABLE"  
    And the admin fetches the overall slot list using the API  
    And the admin sets the "ADDON_ASSIGNABLE_BASE_PRICE_AMOUNT" for 1 to 4 pets for addon
    And the admin selects Capacity Type from the tab for addon 
    And the admin sets the "ADDON_ASSIGNABLE_MAX_CAPACITY_SLOT" for the addon maximum capacity per slot  
    And the admin sets the "ADDON_ASSIGNABLE_MAX_CAPACITY_STAFF" for addon maximum capacity per staff
    And the admin provides "Service Validity From" and "Service Validity To" dates for assignable addon
    And the admin taps the save button  
    Then the service should be created successfully  
    When the admin clicks on the Back button
    And the admin taps the Home icon
    
     Scenario: Successfully create a service  with addon
    Given the admin navigates to the Service tab  
    And the admin taps on Show All under services  
    And the admin taps the plus button to create a new service
    And the admin select the service while creating a service  
    When the admin enters "ADDON_SERVICE_NAME" in the service name input field  
    And the admin provides "ADDON_SERVICE_DESCRIPTION" in the service description field  
    And the admin fetches the overall slot list using the API  
    And the admin sets the "Base Price" for 1 to 4 pets 
    And the admin select the addon for this service
    And the admin selects "Capacity Type" from the tab  
    And the admin sets the "Maximum Capacity" for the service  
    And the admin sets the "Maximum Capacity per Staff"  
    And the admin sets the "Maximum Advance Booking Limit"  
    And the admin provides "Service Validity From" and "Service Validity To" dates  
    And the admin taps the save button  
    Then the service should be created successfully  
    When the admin clicks on the Back button
    And the admin taps the Home icon
    #
#
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
  
Scenario: create a breed
    Given the admin navigates to the Settings tab 
    And the admin opens the Manage Breed section
    When the admin clicks on the Plus button to add a new breed
    And the admin enters Breed Name in the breed name field
    And the admin taps the save button
    Then the admin should see a confirmation message of Breed creation
    When the admin clicks on the Back button
    And the admin taps the Home icon
    Then the admin is navigated back to the home page

Scenario: create a new service pool
    Given the admin navigates to the Settings tab 
    When the admin navigates to Manage Service Pools
    And the admin clicks on the Plus button to add a new pool
    And the admin enters Pool Name 
    And the admin enters Pool Remarks 
    And the admin enters Pool Capacity 
    And the admin clicks on the Save button
    Then the admin should see a confirmation message of Pool creation
    When the admin clicks on the Back button
    And the admin taps the Home icon
    Then the admin is navigated back to the home page
  
Scenario: Define a pricing rule for premium based on a single date.
    Given the admin navigates to the Settings tab 
    When the admin navigates to Pricing Rule  
    And the admin clicks on the FAB button to add a new pricing rule  
    And the admin enters Pricing Rule Name as Single Date Premium  
    And the admin enters Pricing Rule Description as Rule for premium pricing on a single date  
    And the admin enters Pricing Rule Priority 
    And the admin enters Pricing Rule type as premium
    And the admin enters the pricing offset value
    And the admin clicks on the Save button  
    Then the admin should see a confirmation message of Pricing Rule creation
    When the admin clicks on the Back button
    And the admin taps the Home icon
    Then the admin is navigated back to the home page
    
    Scenario: Define a pricing rule for discount based on a single date.
    Given the admin navigates to the Settings tab 
    When the admin navigates to Pricing Rule  
    And the admin clicks on the FAB button to add a new pricing rule  
    And the admin enters Pricing Rule Name as Single Date discount  
    And the admin enters Pricing Rule Description as Rule for discount pricing on a single date  
    And the admin enters Pricing Rule Priority 
    And the admin enters Pricing Rule type as discount
    And the admin enters the pricing offset value
    And the admin clicks on the Save button  
    Then the admin should see a confirmation message of Pricing Rule creation
    When the admin clicks on the Back button
    And the admin taps the Home icon
    Then the admin is navigated back to the home page
    
        Scenario: Define a pricing rule for Not Available  based on a single date.
    Given the admin navigates to the Settings tab 
    When the admin navigates to Pricing Rule  
    And the admin clicks on the FAB button to add a new pricing rule  
    And the admin enters Pricing Rule Name as Single Date not available  
    And the admin enters Pricing Rule Description as Rule for not available pricing on a single date  
    And the admin choose the single date for not available rule
    And the admin enters Pricing Rule type as Not available
    And the admin clicks on the Save button  
    Then the admin should see a confirmation message of Pricing Rule creation
    When the admin clicks on the Back button
    And the admin taps the Home icon
    Then the admin is navigated back to the home page
  
Scenario: Successfully logout Admin 
    Given the admin navigates to the Settings tab  
    And the admin clicks on the logout button  
    Then the admin should be logged out successfully  
    
Scenario: Customer login using email (already created by admin)
    Given the customer enters their "SIGNUP_EMAIL" address
    When the customer clicks on the Continue button
    And the customer enters the Otp 
    Then the customer should be logged in successfully

    
Scenario: Create a booking for one pet on a randomly selected date
    Given the user selects a service
    When the user fetches the slot list for the selected service using the API
    And the user selects a random slot from the slot list, scrolling the slot picker if necessary
    And the user determines the From Date and To Date for the service based on constraints
    And the user calculates the date range and picks a random date
    And the user navigates to the random date's month using the right arrow
    And the user selects the random date and taps the Request Booking button
    Then the user should successfully navigate to the Confirm Booking Details page
    And the user verifies the service name, date, and slot
    And the user taps the Proceed button
    Then the user navigates to the Review Booking page
    And the user reviews the total amount and remaining credit amount
    And the user taps the checkbox and taps the Confirm and Pay button
    Then the user initiates the payment process
    Then the user navigates to the Booking Request Successful page
    And the user saves the booking details
    And the user taps the My Bookings button
    Then the user navigates to the My Bookings page
    And the user verifies that the booking is listed on the My Bookings page

Scenario: Verify Customer Invoice Details
    Given the customer navigates to the Settings tab
    When the customer clicks on Invoice
    And the customer selects the first invoice
    Then the customer checks the service locator and booking date locator 
    And the customer goes back to the home page
    
Scenario: Verify Customer Statement Details
    Given the customer navigates to the Settings tab
    When the customer clicks on Statements
    And the customer selects the current month
    Then the customer checks if the saved invoice number is listed
And the customer goes back to the home page
    
    Scenario: Verify the accounts 
     Given the customer navigates to the Settings tab
    When the customer clicks on Accounts
    And Verify the sales or payment detais are listed their
        And the customer goes back from accounts to the home page
    
    
Scenario: Successfully logout customer
    Given the customer navigates to the Settings tab  
    And the customer clicks on the logout button  

    
Scenario: User login using email as admin (predefined account)
    Given the user enters their predefined "PREDEFINED_ADMIN_EMAIL" address
    When the user clicks on the Continue button
    And the user enters the Predefined Otp "PREDEFINED_ADMIN_OTP"
    Then the user should be logged in successfully
    
Scenario: Admin that do update remaining credit 
    Given Remaining credit 
    
    Scenario:   adhoc 
    Given       Adoc
    

    
    
Scenario: admin statement covered 
Given admin statement 

Scenario: Admin Invoices Covered 
Given Admin invoices

    
Scenario: Approving a booking
    Given the admin navigates to the Pending tab
    When the admin selects the booking's service from the Service dropdown, opens the Date & Slot dropdown, and selects the booked date and slot
    And the admin applies the toggle button
    Then the booking should move to the Unassigned tab

Scenario: Assigning a booking
    Given the admin navigates to the Unassigned tab
    When the admin selects the booking's service from the Service dropdown, opens the Date & Slot dropdown, and selects the booked date and slot
    And the admin selects the specific booking
    And the admin assigns the booking to a staff member
    Then the booking should be assigned successfully
    
Scenario: Admin created a pet for an existing customer
 Given the admin clicks on the Users tab
    When the admin clicks on Customer's Show All
    Then the admin is navigated to the Customer's list page
    And the admin searches for the customer in the search box and selects the customer
    And the admin clicks the view button for the selected customer
    And the admin Clicks the My pets
    And the admin taps the plus button to create a second pet 
    And the user enters the pet's name "SECOND_PET_NAME"
    And the user selects the pet's gender
    And  the user needs to select the birth of dog
    And the user selects the pet's breed
    And the user selects the pet's size
    And the admin enter the admin notes "SECOND_ADMIN_NOTES"
    And the user enters any dietary issues "SECOND_PET_DIETARY_ISSUES"
    And the user enters any allergies "SECOND_PET_ALLERGIES"
    And the user enters the vet's name "SECOND_PET_VETNAME"
    And the user enters the vet's address "SECOND_PET_VETADDRESS"
    And the user enters the vet's phone number "SECOND_PET_VETPHONENUMBER"
    And the user enters the microchip number "SECOND_PET_MICROCHIP"
    And the user enters the contact person's name "SECOND_PET_CONTACT_PERSONNAME"
    And the user enters the contact person's phone number "SECOND_PET_CONTACT_PERSONNUMBER"
    And the user enters any special instructions "SECOND_PET_SPECIAL_INSTRUCTIONS"
    And the user enters the feeding schedule "SECOND_PET_FEEDING_DETAILS"
    And the user enters any additional contacts "SECOND_PET_ADDITIONAL_CONTACT"
    And the user provides behavioral information
    And the user clicks on the Save button
    When the admin clicks on the Back button
    When the admin clicks on the Back button
    And the admin taps the Home icon
    
    
      #Scenario: Successfully create a service  
    #Given the admin navigates to the Service tab  
    #And the admin taps on Show All under services  
    #And the admin taps the plus button to create a new addon  
    #When the admin enters "Service Name" in the service name input field  
    #And the admin provides "Description" in the service description field  
    #And the admin fetches the overall slot list using the API  
    #And the admin sets the "Base Price" for 1 to 4 pets  
    #And the admin selects "Capacity Type" from the tab  
    #And the admin sets the "Maximum Capacity" for the service  
    #And the admin sets the "Maximum Capacity per Staff"  
    #And the admin sets the "Maximum Advance Booking Limit"  
    #And the admin provides "Service Validity From" and "Service Validity To" dates  
    #And the admin taps the save button  
    #Then the service should be created successfully  
    #When the admin clicks on the Back button
    #And the admin taps the Home icon
    
    
Scenario: Successfully logout Admin 
    Given the admin navigates to the Settings tab  
    And the admin clicks on the logout button  
    Then the admin should be logged out successfully  
    
    Scenario: Customer login using email (already created by admin)
    Given the customer enters their "SIGNUP_EMAIL" address
    When the customer clicks on the Continue button
    And the customer enters the Otp 
    Then the customer should be logged in successfully
    
Scenario: Create a booking for Two pet on a randomly selected date
   Given  the user selects the second pet
    When the user selects a service
    And  the user fetches the slot list for the selected service using the API
    And the user selects a random slot from the slot list, scrolling the slot picker if necessary
    And the user determines the From Date and To Date for the service based on constraints
    And the user calculates the date range and picks a random date
    And the user navigates to the random date's month using the right arrow
    And the user selects the random date and taps the Request Booking button
    Then the user should successfully navigate to the Confirm Booking Details page
    And the user verifies the service name, date, and slot
    And the user taps the Proceed button
    Then the user navigates to the Review Booking page
    And the user reviews the total amount and remaining credit amount
    And the user taps the checkbox and taps the Confirm and Pay button
    Then the user initiates the payment process
    Then the user navigates to the Booking Request Successful page
    And the user saves the booking details
    
    Scenario:  Accounts 
      Given the customer navigates to the Settings tab
    When the customer clicks on Accounts
    And Verify the sales or payment detais are listed their
 And the customer goes back from accounts to the home page
 
 #Scenario:  Customer Second Pet
#Given  Customer Second Pet
    
Scenario: Successfully logout customer
    Given the customer navigates to the Settings tab  
    And the customer clicks on the logout button
    
    #Scenario: User login using email as admin (predefined account)
    #Given the user enters their predefined "PREDEFINED_ADMIN_EMAIL" address
    #When the user clicks on the Continue button
    #And the user enters the Predefined Otp "PREDEFINED_ADMIN_OTP"
    #Then the user should be logged in successfully
   #
   #Scenario: approve pet
   #Given approve pet

Scenario: Staff login using email (already created by admin)
    Given the staff enters their "ADMIN_STAFF_EMAIL" address
    When the staff clicks on the Continue button
    And the staff enters the Otp 
    Then the staff should be logged in successfully