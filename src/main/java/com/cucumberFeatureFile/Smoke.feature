
Feature: Booking Application Sanity Flow 

  Scenario: Launch application in emulator
    Given PropertyFile Loaded
    #And  Set key values
    And Configure driver
    And Api configuration
    And Open the application
    Then Successfully navigated to the login screen

  #Scenario: User signs up using email as customer
    #Given User clicks on the Sign Up button
    #When User enters their "SIGNUP_EMAIL" address
    #And User clicks on the Continue button
    #Then User receives an OTP in their email
    #When User enters the OTP received in the email
    #Then User should be signed up successfully
#
  #Scenario: User fills out their information after signing up
    #Given User has successfully signed up
    #When User is on the user info page
    #And User should see fields for first name, last name, gender, phone number, address line 1, address line 2, city/town, pincode, and country
    #And User enters their first name "SIGNUP_FIRSTNAME"
    #And User enters their last name "SIGNUP_LASTNAME"
    #And User selects their gender
    #And User enters their phone number "SIGNUP_PHONENUMBER"
    #And User enters address line 1 "SIGNUP_ADDRESSLINE"
    #And User enters address line 2 "SIGNUP_ADDRESSLINE"
    #And User enters their city/town "SIGNUP_CITYTOWN"
    #And User enters their pincode "SIGNUP_POSTCODE"
    #And User selects their country
    #And User clicks on the Continue button
    #And User verifies the snackbar after entering the user data
    #And User should be taken to the pet info page
#
  #Scenario: User fills out pet information after entering user info    
    #Given User navigates to the pet info page
    #When User should see fields for pet name, gender, size, breed, dietary issues, allergies, vet name, vet address, vet phone number, microchip details, contact person name, contact person's phone number, special instructions, feeding schedules, additional contacts, and behavioral information
    #And User enters the pet's name "PET_NAME"
    #And User selects the pet's gender
    #And User needs to select the birth of dog
    #And User selects the pet's size
    #And User selects the pet's breed
    #And User enters any dietary issues "PET_DIETARY_ISSUES"
    #And User enters any allergies "PET_ALLERGIES"
    #And User enters the vet's name "PET_VETNAME"
    #And User enters the vet's address "PET_VETADDRESS"
    #And User enters the vet's phone number "PET_VETPHONENUMBER"
    #And User enters the microchip number "PET_MICROCHIP"
    #And User enters the contact person's name "PET_CONTACT_PERSONNAME"
    #And User enters the contact person's phone number "PET_CONTACT_PERSONNUMBER"
    #And User enters any special instructions "PET_SPECIAL_INSTRUCTIONS"
    #And User enters the feeding schedule "PET_FEEDING_DETAILS"
    #And User enters any additional contacts "PET_ADDITIONAL_CONTACT"
    #And User provides behavioral information
    #And User clicks on the Save button    
    #And User verifies the snackbar after entering the pet data
    #And The pet information should be saved successfully
#
  #Scenario: User navigates to landing screen
    #Given User navigates to the landing page
#
  #Scenario: Clearing the application cache and opening the application
    #Given Admin clears the application cache
    #When Admin opens the application
    #Then the application launches successfully
    #And Admin is navigated to the login page (or home page if already logged in)
#
  #Scenario: Admin login using email as (predefined account)
    #Given Admin enters their predefined "PREDEFINED_ADMIN_EMAIL" address
    #When Admin clicks on the Continue button
    #And Admin enters the Predefined Otp "PREDEFINED_ADMIN_OTP"
    #Then Admin should be logged in successfully
#
  #Scenario: Approving a signed-up customer request in Admin portal
    #Given Admin clicks on the Users tab
    #When Admin clicks on the Pending Requests showall option
    #And searches for the signup customer name 
    #Then the matching customer list is displayed
    #When Admin clicks on the customer name 
    #And scrolls down to find the Accept button and clicks it
    #Then a confirmation popup is displayed then Admin clicks on the Confirm button in the popup
    #Then User request is successfully approved
    #And Admin is navigated back to the home page
#
  #Scenario: Adding a new admin through the admin portal
    #Given Admin clicks on the Users tab
    #When Admin clicks on Admin's Show All
    #Then Admin is navigated to Admin's list page
    #When Admin clicks on the + button to add a new admin
    #And Admin enters the first name "ADMIN_ADMIN_FIRST_NAME"
    #And Admin enters the last name "ADMIN_ADMIN_LAST_NAME"
    #And Admin enters the email "ADMIN_ADMIN_EMAIL"
    #And Admin selects the gender
    #And Admin enters the admin's phone number "ADMIN_ADMIN_CONTACTNUMBER"
    #And Admin enters the additional contact number "ADMIN_ADMIN_ADDITIONAL_CONTACT_NUMBER"
    #And Admin enters the address line for admin 1
    #And Admin enters the address line for admin 2
    #And Admin selects the country
    #And Admin enters the city or town "ADMIN_ADMIN_CITY"
    #And Admin enters the post code "ADMIN_ADMIN_POSTCODE"
    #And Admin clicks on the Save button
    #Then The new admin details should be successfully saved
    #When Admin clicks on the Back button
    #Then Admin is navigated back to the home page
    #
  #Scenario: Adding a new customer through the admin portal
    #Given Admin clicks on the Users tab
    #When Admin clicks on Customer's Show All
    #Then Admin is navigated to the Customer's list page
    #When Admin clicks on the + button to add a new Customer
    #And Admin enters the Customer first name "ADMIN_CUSTOMER_FIRSTNAME"
    #And Admin enters the Customer last name "ADMIN_CUSTOMER_LASTNAME"
    #And Admin enters the email "ADMIN_CUSTOMER_EMAIL"
    #And Admin selects the gender
    #And Admin enters the customer phone number "ADMIN_CUSTOMER_PHONENUMBER"
    #And Admin enters the address line for customer 1
    #And Admin enters the address line for customer 2
    #And Admin selects the country
    #And Admin enters the city or town "ADMIN_CUSTOMER_CITYTOWN"
    #And Admin enters the post code "ADMIN_CUSTOMER_POSTCODE"
    #And Admin clicks on the Save button
    #Then The new customer details should be successfully saved
    #When Admin clicks on the Back button
    #Then Admin is navigated back to the home page
    #
  #Scenario: Successfully create a tag category  
    #Given Admin clicks on the Users tab
    #And Admin clicks on Show All under tag categories 
    #Then Admin is navigated to the Tag's list page 
    #And Admin taps the plus button to create a new tag category  
    #When Admin enters "ADMIN_TAG_CATEGORY_NAME" in the category name input field  
    #And Admin selects default from the tabs  
    #And Admin sets "ADMIN_TAG_MAXIMUM_ENTITY_LEVEL" as the maximum entity level  
    #And Admin provides a "ADMIN_TAG_CATEGORY_DESCRIPTION" in the description field  
    #And Admin enters "ADMIN_TAG_TAGS_NAME1" in the tag name field  
    #And Admin provides "ADMIN_TAG_TAGS_DESCRIPTION1" in the tag description field  
    #And Admin clicks on the tick button  
    #And Admin clicks on the save button  
    #Then The new Tag details should be successfully saved
    #When Admin clicks on the Back button
    #Then Admin is navigated back to the home page
#
  #Scenario: Successfully create a slot  
    #Given Admin navigates to the Service tab  
    #And Admin clicks on Show All under slots  
    #Then Admin is navigated to the slot's list page 
    #And Admin taps the plus button to create a new slot  
    #When Admin enters "SLOT_NAME" in the slot name input field  
    #And Admin provides "SLOT_DESCRIPTION" in the slot description field  
    #And sets Slot Starting Time as the starting time for the slot  
    #And Admin clicks on the save button  
    #Then The slot should be created successfully  
    #When Admin clicks on the Back button
    #Then Admin is navigated back to the home page
#
  #Scenario: Successfully create a service  
    #Given Admin navigates to the Service tab  
    #And Admin taps on Show All under services  
    #And Admin is navigated to the services's list page
    #And Admin taps the plus button to create a new service
    #And Admin select the service while creating a service  
    #When Admin enters "SERVICE_NAME" in the service name input field  
    #And Admin provides "Description" in the service description field  
    #And Admin fetches the overall slot list using the API  
    #And Admin sets the "Base Price" for 1 to 4 pets 
    #And Admin selects "Capacity Type" from the tab  
    #And Admin sets the "Maximum Capacity" for the service  
    #And Admin sets the "Maximum Capacity per Staff"  
    #And Admin sets the "Maximum Advance Booking Limit"  
    #And Admin provides "Service Validity From" and "Service Validity To" dates  
    #And Admin taps the save button 
    #Then The service should be created successfully  
    #When Admin clicks on the Back button
    #Then Admin is navigated back to the home page
    #
  #Scenario: Successfully create a Privilege Addon  
    #Given Admin navigates to the Service tab  
    #And Admin taps on Show All under services  
    #And Admin is navigated to the services's list page
    #And Admin taps the plus button to create a new addon
    #And Admin select the Addon while creating a addon  
    #When Admin enters "ADDON_PRIVILAGE" in the addon name input field  
    #And Admin provides "ADDON_PRIVILAGE_DESCRIPTION" in the addon description field
    #And Admin select the addon type "PRIVILEGE"  
    #And Admin fetches the overall slot list using the API  
    #And Admin sets the "ADDON_PRIVILAGE_BASE_PRICE_AMOUNT" for 1 to 4 pets for addon
    #And Admin selects Capacity Type from the tab for addon 
    #And Admin sets the "ADDON_PRIVILAGE_MAX_CAPACITY_SLOT" for the addon maximum capacity per slot  
    #And Admin sets the "ADDON_PRIVILAGE_MAX_CAPACITY_STAFF" for addon maximum capacity per staff
    #And Admin provides "Service Validity From" and "Service Validity To" dates for privilege addon
    #And Admin taps the save button  
    #Then The addon should be created successfully  
    #When Admin clicks on the Back button
    #Then Admin is navigated back to the home page
    #
  #Scenario: Successfully create a Assignable Addon  
    #Given Admin navigates to the Service tab  
    #And Admin taps on Show All under services
    #And Admin is navigated to the services's list page  
    #And Admin taps the plus button to create a new addon
    #And Admin select the Addon while creating a addon  
    #When Admin enters "ADDON_ASSIGNABLE" in the addon name input field  
    #And Admin provides "ADDON_ASSIGNABLE_DESCRIPTION" in the addon description field
    #And Admin select the addon type "ASSIGNABLE"  
    #And Admin fetches the overall slot list using the API  
    #And Admin sets the "ADDON_ASSIGNABLE_BASE_PRICE_AMOUNT" for 1 to 4 pets for addon
    #And Admin selects Capacity Type from the tab for addon 
    #And Admin sets the "ADDON_ASSIGNABLE_MAX_CAPACITY_SLOT" for the addon maximum capacity per slot  
    #And Admin sets the "ADDON_ASSIGNABLE_MAX_CAPACITY_STAFF" for addon maximum capacity per staff
    #And Admin provides "Service Validity From" and "Service Validity To" dates for assignable addon
    #And Admin taps the save button
    #Then The addon should be created successfully  
    #When Admin clicks on the Back button
    #Then Admin is navigated back to the home page
    #
  #Scenario: Successfully create a service  with addon
    #Given Admin navigates to the Service tab  
    #And Admin taps on Show All under services 
    #And Admin is navigated to the services's list page 
    #And Admin taps the plus button to create a new service
    #And Admin select the service while creating a service  
    #When Admin enters "ADDON_SERVICE_NAME" in the service name input field  
    #And Admin provides "ADDON_SERVICE_DESCRIPTION" in the service description field  
    #And Admin fetches the overall slot list using the API  
    #And Admin sets the "Base Price" for 1 to 4 pets 
    #And Admin select the addon for this service
    #And Admin selects "Capacity Type" from the tab  
    #And Admin sets the "Maximum Capacity" for the service  
    #And Admin sets the "Maximum Capacity per Staff"  
    #And Admin sets the "Maximum Advance Booking Limit"  
    #And Admin provides "Service Validity From" and "Service Validity To" dates  
    #And Admin taps the save button 
    #And Admin verifies the snackbar after creating the new service with addon  
    #Then The service should be created successfully  
    #When Admin clicks on the Back button
    #Then Admin is navigated back to the home page
    #
  #Scenario: Adding a new staff through the admin portal
    #Given Admin clicks on the Users tab
    #When Admin clicks on Staff's Show All
    #Then Admin is navigated to the staff list page
    #When Admin clicks on the + button to add a new staff
    #And Admin enters the first name "ADMIN_STAFF_FIRST_NAME"
    #And Admin enters the last name "ADMIN_STAFF_LAST_NAME"
    #And Admin enters the email "ADMIN_STAFF_EMAIL"
    #And Admin selects the gender for Staff
    #And Admin enters the Contact number "ADMIN_STAFF_CONTACTNUMBER"
    #And Admin enters the additional contact number "ADMIN_STAFF_ADDITIONAL_CONTACT_NUMBER"
    #And Admin enters the address line for staff 1
    #And Admin enters the address line for staff 2
    #And Admin selects the country
    #And Admin enters the city or town "ADMIN_STAFF_CITY"
    #And Admin enters the post code "ADMIN_STAFF_POSTCODE"
    #And Admin clicks on the Skills dropdown and selects the staff's skill
    #When Admin clicks on the Save button
    #Then the new staff details should be successfully saved
    #When Admin clicks on the Back button
    #Then Admin is navigated back to the home page
  #
      #Scenario: Adding a new  second staff through the admin portal
    #Given Admin clicks on the Users tab
    #When Admin clicks on Staff's Show All
    #Then Admin is navigated to the staff list page
    #When Admin clicks on the + button to add a new staff
    #And Admin enters the first name "ADMIN_STAFF_2_FIRST_NAME"
    #And Admin enters the last name "ADMIN_STAFF_2_LAST_NAME"
    #And Admin enters the email "ADMIN_STAFF_2_EMAIL"
    #And Admin selects the gender for Staff
    #And Admin enters the Contact number "ADMIN_STAFF_2_CONTACTNUMBER"
    #And Admin enters the additional contact number "ADMIN_STAFF_2_ADDITIONAL_CONTACT_NUMBER"
    #And Admin enters the address line for staff 1
    #And Admin enters the address line for staff 2
    #And Admin selects the country
    #And Admin enters the city or town "ADMIN_STAFF_2_CITY"
    #And Admin enters the post code "ADMIN_STAFF_2_POSTCODE"
    #And Admin clicks on the Skills dropdown and selects the staff's skill
    #When Admin clicks on the Save button
    #Then the new staff details should be successfully saved
    #When Admin clicks on the Back button
    #Then Admin is navigated back to the home page
    #
  #Scenario: create a breed
    #Given Admin navigates to the Settings tab 
    #And Admin opens the Manage Breed section
    #Then Admin is navigated to the Breed list page
    #When Admin clicks on the Plus button to add a new breed
    #And Admin enters Breed Name in the breed name field
    #And Admin taps the save button
    #Then the new breed details should be successfully saved
    #When Admin clicks on the Back button
    #Then Admin is navigated back to the home page
#
  #Scenario: create a new service pool
    #Given Admin navigates to the Settings tab 
    #When Admin navigates to Manage Service Pools
    #Then Admin is navigated to the service pools list page
    #And Admin clicks on the Plus button to add a new pool
    #And Admin enters Pool Name 
    #And Admin enters Pool Remarks 
    #And Admin enters Pool Capacity 
    #And Admin clicks on the Save button
    #Then the new service pool details should be successfully saved
    #When Admin clicks on the Back button
    #And Admin taps the Home icon
    #Then Admin is navigated back to the home page
  #
  #Scenario: Define a pricing rule for premium based on a single date.
    #Given the admin navigates to the Settings tab 
    #When the admin navigates to Pricing Rule 
    #Then the admin is navigated to the pricing rule list page 
    #And the admin clicks on the FAB button to add a new pricing rule  
    #And the admin enters Pricing Rule Name as Single Date Premium  
    #And the admin enters Pricing Rule Description as Rule for premium pricing on a single date  
    #And the admin enters Pricing Rule Priority 
    #And the admin choose the single date for premium rule
    #And the admin unselect all the tags in pricingrule
    #And the admin enters Pricing Rule type as premium
    #And the admin enters the pricing offset value
    #And the admin clicks on the Save button  
    #Then the new pricing rule details should be successfully saved
    #When the admin clicks on the Back button
    #And the admin taps the Home icon
    #Then the admin is navigated back to the home page
    #
  #Scenario: Define a pricing rule for discount based on a single date.
    #Given the admin navigates to the Settings tab 
    #When the admin navigates to Pricing Rule  
    #Then the admin is navigated to the pricing rule list page
    #And the admin clicks on the FAB button to add a new pricing rule  
    #And the admin enters Pricing Rule Name as Single Date discount  
    #And the admin enters Pricing Rule Description as Rule for discount pricing on a single date  
    #And the admin enters Pricing Rule Priority 
    #And the admin choose the single date for discount rule
    #And the admin unselect all the tags in pricingrule 
    #And the admin enters Pricing Rule type as discount
    #And the admin enters the pricing offset value
    #And the admin clicks on the Save button
    #Then the new pricing rule details should be successfully saved
    #When the admin clicks on the Back button
    #And the admin taps the Home icon
    #Then the admin is navigated back to the home page
    #
  #Scenario: Define a pricing rule for Not Available  based on a single date.
    #Given the admin navigates to the Settings tab 
    #When the admin navigates to Pricing Rule  
    #Then the admin is navigated to the pricing rule list page
    #And the admin clicks on the FAB button to add a new pricing rule  
    #And the admin enters Pricing Rule Name as Single Date not available  
    #And the admin enters Pricing Rule Description as Rule for not available pricing on a single date  
    #And the admin choose the single date for not available rule
    #And the admin unselect all the tags in pricingrule
    #And the admin enters Pricing Rule type as Not available
    #And the admin clicks on the Save button
#		Then the new pricing rule details should be successfully saved
    #When the admin clicks on the Back button
    #And the admin taps the Home icon
    #Then the admin is navigated back to the home page
  #
  #Scenario: Successfully logout Admin 
    #Given Admin navigates to the Settings tab  
    #And the admin clicks on the logout button  
    #Then the admin should be logged out successfully  
    
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
    
  Scenario: Manage Credit Limit  --> Update Customer Credit Limit
    Given Admin navigates to the Settings tab  
    When the admin taps on Manage Credit Limit
    And the admin clicks on the search button on manage credit limit
    And the admin enters the customer name for updating the credit limit
    And the admin enters the credit limit amount then the credit limit should be automatically saved
    And Admin clicks on the Back button
    And the admin should see a snackbar with the message 
    

  Scenario: Admin views statements for a customer booking  
    Given Admin navigates to the Settings tab  
    When the admin taps on Statements  
    And the admin taps on the search button in Admin Statements  
    And the admin enters the customer name in the search box  
    And the admin finds the customer label and taps on the customer label  
    Then the invoice number should be listed 
    And the admin get back to the statements page 
    And the admin get back to the settings page 
    
  Scenario: Admin searches for an invoice in customer bookings  
    Given Admin navigates to the Settings tab  
    When the admin taps on Invoices 
    And the admin enters the invoice number in the search box of Admin Invoices  
    Then the admin finds and verifies the invoice number  
    And Admin clicks on the Back button
        
   Scenario:  Admin checks the Accounts entry for the booking for a customer
    Given Admin navigates to the Settings tab  
    When the admin taps on Accounts
    And  the admin filter the customer in that dropdown as "SIGNUP_FIRSTNAME" and "SIGNUP_LASTNAME"
    And Verify the sales or payment detais are listed their
    And Admin clicks on the Back button
    
   Scenario: Admin adds an Adhoc amount to a customer
    Given Admin navigates to the Settings tab  
    And the admin selects the accounts 
    When the admin taps the plus icon in that account
    And the admin taps the search button in account
    And the admin enters the customer name
    And the admin finds the customer and select it
    And the admin select the type as sold
    And the admin taps on the Adhoc amount
    And the admin enters the amount in Adhoc "Adhoc_amount"
    And the admin taps on the remarks field in Adhoc 
    And the admin enters the remark details in Adhoc
    Then the admin taps on the submit button in adhoc 
    And Admin clicks on the Back button
    
       Scenario:  Admin checks the Accounts entry for adhoc for a customer
    Given Admin navigates to the Settings tab  
    When the admin taps on Accounts
    And  the admin filter the customer in that dropdown as "SIGNUP_FIRSTNAME" and "SIGNUP_LASTNAME"
    And the admin check the adhoc type
    And Admin clicks on the Back button
    
  Scenario: Approving a booking
    Given the admin navigates to Home tab
    When the admin navigates to the Pending tab
    And the admin selects the booking's service from the Service dropdown, opens the Date & Slot dropdown, and selects the booked date and slot
    And the admin applies the toggle button
    Then the booking should move to the Unassigned tab

  Scenario: Assigning a booking
    Given the admin navigates to the Unassigned tab
    And the admin selects the specific booking
    And the admin assigns the booking to a staff member
    Then the booking should be assigned successfully
    
  Scenario: Admin created a pet for an existing customer
    Given Admin clicks on the Users tab
    When Admin clicks on Customer's Show All
    Then Admin is navigated to the Customer's list page
    And the admin searches for the customer in the search box and selects the customer
    And the admin clicks the view button for the selected customer
    And the admin Clicks the My pets
    And the admin taps the plus button to create a second pet 
    And User enters the pet's name "SECOND_PET_NAME"
    And User selects the pet's gender
    And  User needs to select the birth of dog
    And User selects the pet's breed
    And User selects the pet's size
    And the admin enter the admin notes "SECOND_ADMIN_NOTES"
    And User enters any dietary issues "SECOND_PET_DIETARY_ISSUES"
    And User enters any allergies "SECOND_PET_ALLERGIES"
    And User enters the vet's name "SECOND_PET_VETNAME"
    And User enters the vet's address "SECOND_PET_VETADDRESS"
    And User enters the vet's phone number "SECOND_PET_VETPHONENUMBER"
    And User enters the microchip number "SECOND_PET_MICROCHIP"
    And User enters the contact person's name "SECOND_PET_CONTACT_PERSONNAME"
    And User enters the contact person's phone number "SECOND_PET_CONTACT_PERSONNUMBER"
    And User enters any special instructions "SECOND_PET_SPECIAL_INSTRUCTIONS"
    And User enters the feeding schedule "SECOND_PET_FEEDING_DETAILS"
    And User enters any additional contacts "SECOND_PET_ADDITIONAL_CONTACT"
    And User provides behavioral information
    And User clicks on the Save button
    When Admin clicks on the Back button
    When Admin clicks on the Back button
    And Admin taps the Home icon
       
  Scenario: Successfully logout Admin 
    Given Admin navigates to the Settings tab  
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
     And the user taps the My Bookings button
    Then the user navigates to the My Bookings page
    And the user verifies that the booking is listed on the My Bookings page
    
 
  Scenario: Customer adds a new pet  
    Given the customer taps on the profile icon  
    When the customer taps on My Pets 
    And the customer presses the FAB button to add pet info  
    And User enters the pet's name "PET_NAME"
    And User selects the pet's gender
    And  User needs to select the birth of dog
    And User selects the pet's size
    And User selects the pet's breed
    And User enters any dietary issues "PET_DIETARY_ISSUES"
    And User enters any allergies "PET_ALLERGIES"
    And User enters the vet's name "PET_VETNAME"
    And User enters the vet's address "PET_VETADDRESS"
    And User enters the vet's phone number "PET_VETPHONENUMBER"
    And User enters the microchip number "PET_MICROCHIP"
    And User enters the contact person's name "PET_CONTACT_PERSONNAME"
    And User enters the contact person's phone number "PET_CONTACT_PERSONNUMBER"
    And User enters any special instructions "PET_SPECIAL_INSTRUCTIONS"
    And User enters the feeding schedule "PET_FEEDING_DETAILS"
    And User enters any additional contacts "PET_ADDITIONAL_CONTACT"
    And User provides behavioral information
    And User clicks on the Save button 
    And the customer goes back from profile to the home page
  
  Scenario: Successfully logout customer
    Given the customer navigates to the Settings tab  
    And the customer clicks on the logout button
    
  Scenario: User login using email as admin (predefined account)
    Given the user enters their predefined "PREDEFINED_ADMIN_EMAIL" address
    When the user clicks on the Continue button
    And the user enters the Predefined Otp "PREDEFINED_ADMIN_OTP"
    Then the user should be logged in successfully
   
  Scenario: Admin reviews and approves a pending pet request  
    Given Admin clicks on the Users tab
    When Admin clicks on the Pending Requests showall option
    And the admin searches for the pet in the search box under pending requests  
    And the admin taps on the eye icon in the pet label  
    Then the admin scrolls down and accepts the pet  
    And the admin confirms the pet approval  
    And Admin clicks on the Back button
    
      Scenario: Admin adds an Adhoc amount to a customer
    Given Admin navigates to the Settings tab  
    And the admin selects the accounts 
    When the admin taps the plus icon in that account
    And the admin taps the search button in account
    And the admin enters the customer name
    And the admin finds the customer and select it
    And the admin select the type as collected
    And the admin taps on the Adhoc amount
    And the admin enters the amount in Adhoc "Adhoc_collected"
    And the admin taps on the remarks field in Adhoc 
    And the admin enters the remark details in Adhoc
    Then the admin taps on the submit button in adhoc 
    And Admin clicks on the Back button
    
           Scenario:  Admin checks the Accounts entry for adhoc for a customer
    Given Admin navigates to the Settings tab  
    When the admin taps on Accounts
    And  the admin filter the customer in that dropdown as "SIGNUP_FIRSTNAME" and "SIGNUP_LASTNAME"
    And the admin check the adhoc type
    And Admin clicks on the Back button
    
  Scenario: Successfully logout Admin 
    Given Admin navigates to the Settings tab  
    And the admin clicks on the logout button  
    Then the admin should be logged out successfully 
    
      Scenario: Customer login using email (already created by admin)
    Given the customer enters their "SIGNUP_EMAIL" address
    When the customer clicks on the Continue button
    And the customer enters the Otp 
    Then the customer should be logged in successfully
    
      Scenario: Create a booking for Three pet on a randomly selected date
    Given  the user selects the Third pet
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
     And the user taps the My Bookings button
    Then the user navigates to the My Bookings page
    And the user verifies that the booking is listed on the My Bookings page
    
    Scenario: Booking a service using assorted date selection
     Given the user selects a service
     When the user taps the assorted tab
    When the user fetches the slot list for the selected service using the API
    And the user selects a random slot from the slot list, scrolling the slot picker in assorted tab if necessary
    And the user determines the From Date and To Date for the service based on constraints
    And the user calculates the date range and picks a random date
		And the user scroll the date picker and selects the date
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
#
#Scenario: Booking a Service with a Discount Pricing Rule
#Given the user is on the Customer Home Page
#When the user sees the Pricing Rule Type as "DISCOUNT"
#And the user selects the desired Service as "SERVICE_NAME"
#And the user fetches available time slots from the API for discount
#And the user chooses an available Time Slot
#And the user gathering the pricingrule discount date from propertyfile
#And the user opens the Calendar and navigates to the correct Month
#And the user selects a Date that falls under the Pricing Rule
#And the user taps Request Booking
#Then the user navigates to the Confirm Booking Details page
#When the user taps Proceed
#Then the user navigates to the Review Booking page
#And the user verifies the Pricing Rule Details on the Review Booking page
#When the user completes the Payment Process or uses the Remaining Credit Balance if applicable
#Then the user taps New Booking to start a new booking process
    #
  #Scenario: Booking a Service with a Premium Pricing Rule
#Given the user is on the Customer Home Page
#When the user sees the Pricing Rule Type as "PREMIUM"
#And the user selects the desired Service as "SERVICE_NAME"
#And the user fetches available time slots from the API for premium
#And the user chooses an available Time Slot
#And the user gathering the pricingrule premium date from propertyfile
#And the user opens the Calendar and navigates to the correct Month
#And the user selects a Date that falls under the Pricing Rule
#And the user taps Request Booking
#Then the user navigates to the Confirm Booking Details page
#When the user taps Proceed
#Then the user navigates to the Review Booking page
#And the user verifies the Pricing Rule Details on the Review Booking page
#When the user completes the Payment Process or uses the Remaining Credit Balance if applicable
#Then the user taps New Booking to start a new booking process  
    #
      #Scenario: Booking a Service with a Not Available Pricing Rule
#Given the user is on the Customer Home Page
#When the user sees the Pricing Rule Type as "NOT AVAILABLE"
#And the user selects the desired Service as "SERVICE_NAME"
#And the user fetches available time slots from the API for Not Available
#And the user chooses an available Time Slot
#And the user gathering the pricingrule Not available date from propertyfile
#And the user opens the Calendar and navigates to the correct Month
#And the user selects a Date that falls under the Pricing Rule
#And the user taps Request Booking
#Then the user navigates to the Confirm Booking Details page
#When the user taps Proceed
#Then the user navigates to the Review Booking page
#And the user verifies the Pricing Rule Details on the Review Booking page
#When the user completes the Payment Process or uses the Remaining Credit Balance if applicable
#Then the user taps New Booking to start a new booking process 
    #
      Scenario: Create a booking for service with addon
      Given the user is on the Customer Home Page
    When the user selects a "ADDON_SERVICE_NAME" for booking
    And the user select the addon mentioned in the service "Addon"
    And the user select the random slot mentioned in the service at "ADDON_SERVICE_NAME"
    And the user selects a random slot for addon from the slot list, scrolling the slot picker if necessary
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
    


 Scenario: Successfully logout customer
    Given the customer navigates to the Settings tab  
    And the customer clicks on the logout button
    
  #Scenario: Staff login using email (already created by admin)
    #Given the staff enters their "ADMIN_STAFF_EMAIL" address
    #When the staff clicks on the Continue button
    #And the staff enters the Otp 
    #Then the staff should be logged in successfully
    #
  #Scenario: Staff Start the booking service for a booked date
    #Given Staff selects the booked date  
    #When Staff selects the booking and taps Start
    #Then Verify the checkbox is checked while starting the booking  
    #And Capture the snackbar message  
#
      Scenario: User login using email as admin (predefined account)
    Given the user enters their predefined "PREDEFINED_ADMIN_EMAIL" address
    When the user clicks on the Continue button
    And the user enters the Predefined Otp "PREDEFINED_ADMIN_OTP"
    Then the user should be logged in successfully
    
    Scenario: Edit Staff
    Given Admin clicks on the Users tab
    When Admin clicks on Staff's Show All
    Then Admin is navigated to the staff list page
    And Admin searches for the staff name in the search box as "ADMIN_STAFF_FIRST_NAME"
    And Admin selects the edit option for the staff member
    When Admin erases the existing First Name as "First name" and enter the new First name as "EDIT_ADMIN_STAFF_FIRST_NAME"
    When Admin erases the existing Last Name as "Last name" and enter the new Last name as "EDIT_ADMIN_STAFF_LAST_NAME"
    When Admin erases the existing email as "Email" and enter the new email as "EDIT_ADMIN_STAFF_EMAIL"
    When Admin erases the existing contact number for staff
    And Admin enters a new contact number as "EDIT_ADMIN_STAFF_CONTACTNUMBER"
    And  Admin erases the Addressline for staff 1 and enter the new address
    When Admin erases the existing city as "city" and enter the new city name as "EDIT_ADMIN_STAFF_CITY"
    When Admin erases the existing postcode as "post code" and enter the new post code as "EDIT_ADMIN_STAFF_POSTCODE"
    And Admin clicks on the save button 
    When Admin clicks on the Back button
    Then the admin is navigated back to the home page
        
    
    Scenario: Edit Customer
   Given Admin clicks on the Users tab
    When Admin clicks on Customer's Show All
    Then Admin is navigated to the Customer's list page    
    And Admin searches for the Customer name in the search box as "ADMIN_CUSTOMER_FIRSTNAME"
    And Admin selects the edit option for the customer  
    When Admin erases the existing First Name as "First name" and enter the Customer's new First name as "EDIT_ADMIN_CUSTOMER_FIRSTNAME"
    When Admin erases the existing Last Name as "Last name" and enter the Customer's new Last name as "EDIT_ADMIN_CUSTOMER_LASTNAME"
    When Admin erases the existing email as "Email" and enter the new email as "EDIT_ADMIN_CUSTOMER_EMAIL"
    When Admin erases the existing contact number for customer
    And Admin enters a new contact number for customer as "EDIT_ADMIN_CUSTOMER_PHONENUMBER"
    And  Admin erases the Addressline for Customer 1 and enter the new address
    When Admin erases the existing city as "city" and enter the new city name as "EDIT_ADMIN_CUSTOMER_CITYTOWN"
    When Admin erases the existing postcode as "post code" and enter the new post code as "EDIT_ADMIN_CUSTOMER_POSTCODE"
    And Admin clicks on the save button 
    When Admin clicks on the Back button 
    Then the admin is navigated back to the home page
    

    
   Scenario: Edit Admin
    Given Admin clicks on the Users tab
    When Admin clicks on Admin's Show All
    Then Admin is navigated to Admin's list page  
    And Admin searches for the Admin name in the search box as "ADMIN_ADMIN_FIRST_NAME"
    And Admin selects the edit option for the Admin  
    When Admin erases the existing First Name as "First name" and enter the new First name as "EDIT_ADMIN_ADMIN_FIRST_NAME"
    When Admin erases the existing Last Name as "Last name" and enter the new Last name as "EDIT_ADMIN_ADMIN_LAST_NAME"
    When Admin erases the existing email as "Email" and enter the new email as "EDIT_ADMIN_ADMIN_EMAIL"
    When Admin erases the existing contact number for Admin
    And Admin enters a new contact number for Admin as "EDIT_ADMIN_ADMIN_CONTACTNUMBER"
    And  Admin erases the Addressline for Admin 1 and enter the new address
    When Admin erases the existing city as "city" and enter the new city name as "EDIT_ADMIN_ADMIN_CITY"
    When Admin erases the existing postcode as "post code" and enter the new post code as "EDIT_ADMIN_ADMIN_POSTCODE"
    And Admin clicks on the save button 
    When Admin clicks on the Back button
    Then the admin is navigated back to the home page
    
      Scenario: 	Edit Tag 
    Given Admin clicks on the Users tab
    And Admin clicks on Show All under tag categories 
    Then Admin is navigated to the Tag's list page 
    And the admin pick the category name from the list  
    And Admin selects the edit option for the Tag 
    When Admin erases the existing CategoryName as "First name" and enter the new Category Name as "EDIT_ADMIN_TAG_CATEGORY_NAME" 
    When Admin erases the existing maximum entity level as "First name" and enter the new maximum entity level as "EDIT_ADMIN_TAG_MAXIMUM_ENTITY_LEVEL" 
    And the admin erases the description of the tag 
    And the admin enter the new description for editting the tag
    And Admin clicks on the save button  
    Then The new Tag details should be successfully saved
    When Admin clicks on the Back button
    Then the admin is navigated back to the home page
    
    Scenario:     Edit Service
     Given Admin navigates to the Service tab  
    And Admin taps on Show All under services 
    And Admin is navigated to the services's list page 
    And Admin searches for the service name in the search box as "SERVICE_NAME" and tap the service
    And the admin select the edit in title bar
    When Admin erases the existing Service Name as "First name" and enter the new Service name as "EDIT_SERVICE_NAME"
    When Admin erases the existing Service Description as "First name" and enter the new Service Descriprion as "EDIT_SERVICE_DESCRIPTION"
    When Admin erases the existing Service Base price as "First name" and enter the new Service base price as "EDIT_BASE_PRICE_AMOUNT"
    When Admin erases the existing Service maximum capacity as "First name" and enter the new Service maximum capacity as "EDIT_MAX_CAPACITY_SLOT"
    When Admin erases the existing Service maximum capacity per staff as "First name" and enter the new Service maximum capacity per staff as "EDIT_MAX_CAPACITY_STAFF"
    When Admin erases the existing Service maximum advance booking limit as "First name" and enter the new Service maximum advance booking limit as "EDIT_MAX_ADVANCE_BOOKING_LIMIT"
    And Admin clicks on the save button 
    When Admin clicks on the Back button
    Then Admin is navigated back to the home page
    
        Scenario:     Edit Addon
     Given Admin navigates to the Service tab  
    And Admin taps on Show All under services 
    And Admin is navigated to the services's list page 
    And Admin searches for the Addon name in the search box as "ADDON_PRIVILAGE" and tap the service
    And the admin select the edit in title bar
    When Admin erases the existing Addon Name as "First name" and enter the new Addon name as "EDIT_ADDON_PRIVILAGE"
    When Admin erases the existing Addon Description as "First name" and enter the new Addon Descriprion as "EDIT_ADDON_PRIVILAGE_DESCRIPTION"
    When Admin erases the existing Addon Base price as "First name" and enter the new Addon base price as "EDIT_ADDON_PRIVILAGE_BASE_PRICE_AMOUNT"
    When Admin erases the existing Addon maximum capacity as "First name" and enter the new Addon maximum capacity as "EDIT_ADDON_PRIVILAGE_MAX_CAPACITY_SLOT"
    When Admin erases the existing Addon maximum capacity per staff as "First name" and enter the new Addon maximum capacity per staff as "EDIT_ADDON_PRIVILAGE_MAX_CAPACITY_STAFF"
    And Admin clicks on the save button 
    When Admin clicks on the Back button
    Then the admin is navigated back to the home page
    
    Scenario:      Edit Slot
    Given Admin navigates to the Service tab  
    And Admin clicks on Show All under slots  
    Then Admin is navigated to the slot's list page 
        And Admin searches for the slot name in the search box as "SLOT_NAME" and tap the slot
    And the admin select the edit in title bar
    When Admin erases the existing slot Name as "First name" and enter the new slot name as "EDIT_SLOT_NAME"
    When Admin erases the existing slot Description as "First name" and enter the new slot Descriprion as "EDIT_SLOT_DESCRIPTION"
    When Admin change the start time of the slot
    And Admin clicks on the save button 
        Then Admin is navigated to the slot's list page 
    When Admin clicks on the Back button
    Then the admin is navigated back to the home page
    
        Scenario: Delete Staff
    Given Admin clicks on the Users tab
    When Admin clicks on Staff's Show All
    Then Admin is navigated to the staff list page
    And Admin searches for the staff name in the search box as "EDIT_ADMIN_STAFF_FIRST_NAME"
    And Admin chooses to delete and confirms the action
    Then Admin is navigated to the staff list page
    When Admin clicks on the Back button
    Then the admin is navigated back to the home page
    
     Scenario: Delete Customer
   Given Admin clicks on the Users tab
    When Admin clicks on Customer's Show All
    Then Admin is navigated to the Customer's list page    
    And Admin searches for the Customer name in the search box as "EDIT_ADMIN_CUSTOMER_FIRSTNAME"
    And Admin chooses to delete and confirms the action
    Then Admin is navigated to the Customer's list page 
    When Admin clicks on the Back button
    Then the admin is navigated back to the home page
    
      Scenario: 	Delete Tag 
    Given Admin clicks on the Users tab
    And Admin clicks on Show All under tag categories 
    Then Admin is navigated to the Tag's list page 
    And the admin pick the category name from the list as "EDIT_ADMIN_TAG_CATEGORY_NAME" 
    And Admin chooses to delete and confirms the action
    Then Admin is navigated to the Tag's list page 
    When Admin clicks on the Back button
    Then the admin is navigated back to the home page
    
        Scenario:     Delete Service
     Given Admin navigates to the Service tab  
    And Admin taps on Show All under services 
    And Admin is navigated to the services's list page 
    And Admin searches for the service name in the search box as "EDIT_SERVICE_NAME"
    And Admin wait for the service filter as "EDIT_SERVICE_NAME"
    And Admin tap the delete icon of the service as "EDIT_SERVICE_NAME" and confirms the action
    And Admin is navigated to the services's list page
    When Admin clicks on the Back button
    Then the admin is navigated back to the home page
       
         Scenario:     Delete Addon
    Given Admin navigates to the Service tab  
    And Admin taps on Show All under services 
    And Admin is navigated to the services's list page 
    And Admin searches for the Addon name in the search box as "EDIT_ADDON_PRIVILAGE" 
    And Admin wait for the addon filter as "EDIT_ADDON_PRIVILAGE"
    And Admin tap the delete icon of the addon as "EDIT_ADDON_PRIVILAGE" and confirms the action
    And Admin is navigated to the services's list page
    When Admin clicks on the Back button
    Then the admin is navigated back to the home page
    
    Scenario:    Delete Slot
    Given Admin navigates to the Service tab  
    And Admin clicks on Show All under slots  
    Then Admin is navigated to the slot's list page 
    And Admin searches for the slot name in the search box as "EDIT_SLOT_NAME" 
    And Admin wait for the slot filter as "EDIT_SLOT_NAME"
    And Admin tap the delete icon of the slot as "EDIT_SLOT_NAME" and confirms the action
    Then Admin is navigated to the slot's list page 
    When Admin clicks on the Back button
    Then the admin is navigated back to the home page
        
        
        
        
    