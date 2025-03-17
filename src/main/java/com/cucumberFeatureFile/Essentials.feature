  Scenario: Launch application in emulator
    Given PropertyFile Loaded
    And  Set key values
    And Configure driver
    And Api configuration
    And Open the application
    Then Successfully navigated to the login screen
  
  Scenario: User signs up using email as customer
    Given User clicks on the Sign Up button
    When User enters their "SIGNUP_EMAIL" address
    And User clicks on the Continue button
    Then User receives an OTP in their email
    When User enters the OTP received in the email
    Then User should be signed up successfully

  Scenario: User fills out their information after signing up
    Given User has successfully signed up
    When User is on the user info page
    And User should see fields for first name, last name, gender, phone number, address line 1, address line 2, city/town, pincode, and country
    And User enters their first name "SIGNUP_FIRSTNAME"
    And User enters their last name "SIGNUP_LASTNAME"
    And User selects their gender
    And User enters their phone number "SIGNUP_PHONENUMBER"
    And User enters address line 1 "SIGNUP_ADDRESSLINE"
    And User enters address line 2 "SIGNUP_ADDRESSLINE"
    And User enters their city/town "SIGNUP_CITYTOWN"
    And User enters their pincode "SIGNUP_POSTCODE"
    And User selects their country
    And User clicks on the Continue button
    And User verifies the snackbar after entering the user data
    And User should be taken to the pet info page

  Scenario: User fills out pet information after entering user info    
    Given User navigates to the pet info page
    When User should see fields for pet name, gender, size, breed, dietary issues, allergies, vet name, vet address, vet phone number, microchip details, contact person name, contact person's phone number, special instructions, feeding schedules, additional contacts, and behavioral information
    And User enters the pet's name "PET_NAME"
    And User selects the pet's gender
    And User needs to select the birth of dog
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
    And User verifies the snackbar after entering the pet data
    And The pet information should be saved successfully

  Scenario: User navigates to landing screen
    Given User navigates to the landing page

  Scenario: Clearing the application cache and opening the application
    Given Admin clears the application cache
    When Admin opens the application
    Then the application launches successfully
    And Admin is navigated to the login page (or home page if already logged in)

  Scenario: Admin login using email as (predefined account)
    Given Admin enters their predefined "PREDEFINED_ADMIN_EMAIL" address
    When Admin clicks on the Continue button
    And Admin enters the Predefined Otp "PREDEFINED_ADMIN_OTP"
    Then Admin should be logged in successfully

  Scenario: Approving a signed-up customer request in Admin portal
    Given Admin clicks on the Users tab
    When Admin clicks on the Pending Requests showall option
    And searches for the signup customer name 
    Then the matching customer list is displayed
    When Admin clicks on the customer name 
    And scrolls down to find the Accept button and clicks it
    Then a confirmation popup is displayed then Admin clicks on the Confirm button in the popup
    Then User request is successfully approved
    And Admin is navigated back to the home page

  Scenario: Adding a new admin through the admin portal
    Given Admin clicks on the Users tab
    When Admin clicks on Admin's Show All
    Then Admin is navigated to Admin's list page
    When Admin clicks on the + button to add a new admin
    And Admin enters the first name "ADMIN_ADMIN_FIRST_NAME"
    And Admin enters the last name "ADMIN_ADMIN_LAST_NAME"
    And Admin enters the email "ADMIN_ADMIN_EMAIL"
    And Admin selects the gender
    And Admin enters the admin's phone number "ADMIN_ADMIN_CONTACTNUMBER"
    And Admin enters the additional contact number "ADMIN_ADMIN_ADDITIONAL_CONTACT_NUMBER"
    And Admin enters the address line for admin 1
    And Admin enters the address line for admin 2
    And Admin selects the country
    And Admin enters the city or town "ADMIN_ADMIN_CITY"
    And Admin enters the post code "ADMIN_ADMIN_POSTCODE"
    And Admin clicks on the Save button
    Then The new admin details should be successfully saved
    When Admin clicks on the Back button
    Then Admin is navigated back to the home page
    
  Scenario: Adding a new customer through the admin portal
    Given Admin clicks on the Users tab
    When Admin clicks on Customer's Show All
    Then Admin is navigated to the Customer's list page
    When Admin clicks on the + button to add a new Customer
    And Admin enters the Customer first name "ADMIN_CUSTOMER_FIRSTNAME"
    And Admin enters the Customer last name "ADMIN_CUSTOMER_LASTNAME"
    And Admin enters the email "ADMIN_CUSTOMER_EMAIL"
    And Admin selects the gender
    And Admin enters the customer phone number "ADMIN_CUSTOMER_PHONENUMBER"
    And Admin enters the address line for customer 1
    And Admin enters the address line for customer 2
    And Admin selects the country
    And Admin enters the city or town "ADMIN_CUSTOMER_CITYTOWN"
    And Admin enters the post code "ADMIN_CUSTOMER_POSTCODE"
    And Admin clicks on the Save button
    Then The new customer details should be successfully saved
    When Admin clicks on the Back button
    Then Admin is navigated back to the home page
    
  Scenario: Successfully create a tag category  
    Given Admin clicks on the Users tab
    And Admin clicks on Show All under tag categories 
    Then Admin is navigated to the Tag's list page 
    And Admin taps the plus button to create a new tag category  
    When Admin enters "ADMIN_TAG_CATEGORY_NAME" in the category name input field  
    And Admin selects default from the tabs  
    And Admin sets "ADMIN_TAG_MAXIMUM_ENTITY_LEVEL" as the maximum entity level  
    And Admin provides a "ADMIN_TAG_CATEGORY_DESCRIPTION" in the description field  
    And Admin enters "ADMIN_TAG_TAGS_NAME1" in the tag name field  
    And Admin provides "ADMIN_TAG_TAGS_DESCRIPTION1" in the tag description field  
    And Admin clicks on the tick button  
    And Admin clicks on the save button  
    Then The new Tag details should be successfully saved
    When Admin clicks on the Back button
    Then Admin is navigated back to the home page

  Scenario: Successfully create a slot  
    Given Admin navigates to the Service tab  
    And Admin clicks on Show All under slots  
    Then Admin is navigated to the slot's list page 
    And Admin taps the plus button to create a new slot  
    When Admin enters "SLOT_NAME" in the slot name input field  
    And Admin provides "SLOT_DESCRIPTION" in the slot description field  
    And sets Slot Starting Time as the starting time for the slot  
    And Admin clicks on the save button  
    Then The slot should be created successfully  
    When Admin clicks on the Back button
    Then Admin is navigated back to the home page

  Scenario: Successfully create a service  
    Given Admin navigates to the Service tab  
    And Admin taps on Show All under services  
    And Admin is navigated to the services's list page
    And Admin taps the plus button to create a new service
    And Admin select the service while creating a service  
    When Admin enters "SERVICE_NAME" in the service name input field  
    And Admin provides "Description" in the service description field  
    And Admin fetches the overall slot list using the API  
    And Admin sets the "Base Price" for 1 to 4 pets 
    And Admin selects "Capacity Type" from the tab  
    And Admin sets the "Maximum Capacity" for the service  
    And Admin sets the "Maximum Capacity per Staff"  
    And Admin sets the "Maximum Advance Booking Limit"  
    And Admin provides "Service Validity From" and "Service Validity To" dates  
    And Admin taps the save button 
    Then The service should be created successfully  
    When Admin clicks on the Back button
    Then Admin is navigated back to the home page
    
  Scenario: Successfully create a Privilege Addon  
    Given Admin navigates to the Service tab  
    And Admin taps on Show All under services  
    And Admin is navigated to the services's list page
    And Admin taps the plus button to create a new addon
    And Admin select the Addon while creating a addon  
    When Admin enters "ADDON_PRIVILAGE" in the addon name input field  
    And Admin provides "ADDON_PRIVILAGE_DESCRIPTION" in the addon description field
    And Admin select the addon type "PRIVILEGE"  
    And Admin fetches the overall slot list using the API  
    And Admin sets the "ADDON_PRIVILAGE_BASE_PRICE_AMOUNT" for 1 to 4 pets for addon
    And Admin selects Capacity Type from the tab for addon 
    And Admin sets the "ADDON_PRIVILAGE_MAX_CAPACITY_SLOT" for the addon maximum capacity per slot  
    And Admin sets the "ADDON_PRIVILAGE_MAX_CAPACITY_STAFF" for addon maximum capacity per staff
    And Admin provides "Service Validity From" and "Service Validity To" dates for privilege addon
    And Admin taps the save button  
    Then The addon should be created successfully  
    When Admin clicks on the Back button
    Then Admin is navigated back to the home page
    
  Scenario: Successfully create a Assignable Addon  
    Given Admin navigates to the Service tab  
    And Admin taps on Show All under services
    And Admin is navigated to the services's list page  
    And Admin taps the plus button to create a new addon
    And Admin select the Addon while creating a addon  
    When Admin enters "ADDON_ASSIGNABLE" in the addon name input field  
    And Admin provides "ADDON_ASSIGNABLE_DESCRIPTION" in the addon description field
    And Admin select the addon type "ASSIGNABLE"  
    And Admin fetches the overall slot list using the API  
    And Admin sets the "ADDON_ASSIGNABLE_BASE_PRICE_AMOUNT" for 1 to 4 pets for addon
    And Admin selects Capacity Type from the tab for addon 
    And Admin sets the "ADDON_ASSIGNABLE_MAX_CAPACITY_SLOT" for the addon maximum capacity per slot  
    And Admin sets the "ADDON_ASSIGNABLE_MAX_CAPACITY_STAFF" for addon maximum capacity per staff
    And Admin provides "Service Validity From" and "Service Validity To" dates for assignable addon
    And Admin taps the save button
    Then The addon should be created successfully  
    When Admin clicks on the Back button
    Then Admin is navigated back to the home page
    
  Scenario: Successfully create a service  with addon
    Given Admin navigates to the Service tab  
    And Admin taps on Show All under services 
    And Admin is navigated to the services's list page 
    And Admin taps the plus button to create a new service
    And Admin select the service while creating a service  
    When Admin enters "ADDON_SERVICE_NAME" in the service name input field  
    And Admin provides "ADDON_SERVICE_DESCRIPTION" in the service description field  
    And Admin fetches the overall slot list using the API  
    And Admin sets the "Base Price" for 1 to 4 pets 
    And Admin select the addon for this service
    And Admin selects "Capacity Type" from the tab  
    And Admin sets the "Maximum Capacity" for the service  
    And Admin sets the "Maximum Capacity per Staff"  
    And Admin sets the "Maximum Advance Booking Limit"  
    And Admin provides "Service Validity From" and "Service Validity To" dates  
    And Admin taps the save button 
    And Admin verifies the snackbar after creating the new service with addon  
    Then The service should be created successfully  
    When Admin clicks on the Back button
    Then Admin is navigated back to the home page
    
  Scenario: Adding a new staff through the admin portal
    Given Admin clicks on the Users tab
    When Admin clicks on Staff's Show All
    Then Admin is navigated to the staff list page
    When Admin clicks on the + button to add a new staff
    And Admin enters the first name "ADMIN_STAFF_FIRST_NAME"
    And Admin enters the last name "ADMIN_STAFF_LAST_NAME"
    And Admin enters the email "ADMIN_STAFF_EMAIL"
    And Admin selects the gender for Staff
    And Admin enters the Contact number "ADMIN_STAFF_CONTACTNUMBER"
    And Admin enters the additional contact number "ADMIN_STAFF_ADDITIONAL_CONTACT_NUMBER"
    And Admin enters the address line for staff 1
    And Admin enters the address line for staff 2
    And Admin selects the country
    And Admin enters the city or town "ADMIN_STAFF_CITY"
    And Admin enters the post code "ADMIN_STAFF_POSTCODE"
    And Admin clicks on the Skills dropdown and selects the staff's skill
    When Admin clicks on the Save button
    Then the new staff details should be successfully saved
    When Admin clicks on the Back button
    Then Admin is navigated back to the home page
  
      Scenario: Adding a new  second staff through the admin portal
    Given Admin clicks on the Users tab
    When Admin clicks on Staff's Show All
    Then Admin is navigated to the staff list page
    When Admin clicks on the + button to add a new staff
    And Admin enters the first name "ADMIN_STAFF_2_FIRST_NAME"
    And Admin enters the last name "ADMIN_STAFF_2_LAST_NAME"
    And Admin enters the email "ADMIN_STAFF_2_EMAIL"
    And Admin selects the gender for Staff
    And Admin enters the Contact number "ADMIN_STAFF_2_CONTACTNUMBER"
    And Admin enters the additional contact number "ADMIN_STAFF_2_ADDITIONAL_CONTACT_NUMBER"
    And Admin enters the address line for staff 1
    And Admin enters the address line for staff 2
    And Admin selects the country
    And Admin enters the city or town "ADMIN_STAFF_2_CITY"
    And Admin enters the post code "ADMIN_STAFF_2_POSTCODE"
    And Admin clicks on the Skills dropdown and selects the staff's skill
    When Admin clicks on the Save button
    Then the new staff details should be successfully saved
    When Admin clicks on the Back button
    Then Admin is navigated back to the home page
    
  Scenario: create a breed
    Given Admin navigates to the Settings tab 
    And Admin opens the Manage Breed section
    Then Admin is navigated to the Breed list page
    When Admin clicks on the Plus button to add a new breed
    And Admin enters Breed Name in the breed name field
    And Admin taps the save button
    Then the new breed details should be successfully saved
    When Admin clicks on the Back button
    Then Admin is navigated back to the home page

  Scenario: create a new service pool
    Given Admin navigates to the Settings tab 
    When Admin navigates to Manage Service Pools
    Then Admin is navigated to the service pools list page
    And Admin clicks on the Plus button to add a new pool
    And Admin enters Pool Name 
    And Admin enters Pool Remarks 
    And Admin enters Pool Capacity 
    And Admin clicks on the Save button
    Then the new service pool details should be successfully saved
    When Admin clicks on the Back button
    And Admin taps the Home icon
    Then Admin is navigated back to the home page
  
  Scenario: Define a pricing rule for premium based on a single date.
    Given the admin navigates to the Settings tab 
    When the admin navigates to Pricing Rule 
    Then the admin is navigated to the pricing rule list page 
    And the admin clicks on the FAB button to add a new pricing rule  
    And the admin enters Pricing Rule Name as Single Date Premium  
    And the admin enters Pricing Rule Description as Rule for premium pricing on a single date  
    And the admin enters Pricing Rule Priority 
    And the admin choose the single date for premium rule
    And the admin unselect all the tags in pricingrule
    And the admin enters Pricing Rule type as premium
    And the admin enters the pricing offset value
    And the admin clicks on the Save button  
    Then the new pricing rule details should be successfully saved
    When the admin clicks on the Back button
    And the admin taps the Home icon
    Then the admin is navigated back to the home page
    
  Scenario: Define a pricing rule for discount based on a single date.
    Given the admin navigates to the Settings tab 
    When the admin navigates to Pricing Rule  
    Then the admin is navigated to the pricing rule list page
    And the admin clicks on the FAB button to add a new pricing rule  
    And the admin enters Pricing Rule Name as Single Date discount  
    And the admin enters Pricing Rule Description as Rule for discount pricing on a single date  
    And the admin enters Pricing Rule Priority 
    And the admin choose the single date for discount rule
    And the admin unselect all the tags in pricingrule 
    And the admin enters Pricing Rule type as discount
    And the admin enters the pricing offset value
    And the admin clicks on the Save button
    Then the new pricing rule details should be successfully saved
    When the admin clicks on the Back button
    And the admin taps the Home icon
    Then the admin is navigated back to the home page
    
  Scenario: Define a pricing rule for Not Available  based on a single date.
    Given the admin navigates to the Settings tab 
    When the admin navigates to Pricing Rule  
    Then the admin is navigated to the pricing rule list page
    And the admin clicks on the FAB button to add a new pricing rule  
    And the admin enters Pricing Rule Name as Single Date not available  
    And the admin enters Pricing Rule Description as Rule for not available pricing on a single date  
    And the admin choose the single date for not available rule
    And the admin unselect all the tags in pricingrule
    And the admin enters Pricing Rule type as Not available
    And the admin clicks on the Save button
		Then the new pricing rule details should be successfully saved
    When the admin clicks on the Back button
    And the admin taps the Home icon
    Then the admin is navigated back to the home page
  
  Scenario: Successfully logout Admin 
    Given Admin navigates to the Settings tab  
    And the admin clicks on the logout button  
    Then the admin should be logged out successfully  