  Scenario: Launch application in emulator
    Given PropertyFile Loaded
    And  Configure driver
    And  Api configuration
    And  Open the application
    Then Successfully navigated to the login screen
    
     Scenario: User login using email as admin (predefined account)
    Given the user enters their predefined "PREDEFINED_ADMIN_EMAIL" address
    When the user clicks on the Continue button
    And the user enters the Predefined Otp "PREDEFINED_ADMIN_OTP"
    Then the user should be logged in successfully
    
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
    Then the admin is navigated back to the home page
    
  Scenario: Successfully create a tag category  
    Given the admin clicks on the Users tab
    And the admin clicks on Show All under tag categories 
    Then the admin is navigated to the Tag's list page 
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
    Then the admin is navigated back to the home page

  Scenario: Successfully create a slot  
    Given the admin navigates to the Service tab  
    And the admin clicks on Show All under slots  
    Then the admin is navigated to the slot's list page 
    And the admin taps the plus button to create a new slot  
    When the admin enters "SLOT_NAME" in the slot name input field  
    And the admin provides "SLOT_DESCRIPTION" in the slot description field  
    And sets Slot Starting Time as the starting time for the slot  
    And the admin clicks on the save button  
    Then the slot should be created successfully  
    When the admin clicks on the Back button
    Then the admin is navigated back to the home page

  Scenario: Successfully create a service  
    Given the admin navigates to the Service tab  
    And the admin taps on Show All under services  
    And the admin is navigated to the services's list page
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
    Then the admin is navigated back to the home page
    
  Scenario: Successfully create a Privilege Addon  
    Given the admin navigates to the Service tab  
    And the admin taps on Show All under services  
    And the admin is navigated to the services's list page
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
    Then the addon should be created successfully  
    When the admin clicks on the Back button
    Then the admin is navigated back to the home page
    
  Scenario: Successfully create a Assignable Addon  
    Given the admin navigates to the Service tab  
    And the admin taps on Show All under services
    And the admin is navigated to the services's list page  
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
    Then the addon should be created successfully  
    When the admin clicks on the Back button
    Then the admin is navigated back to the home page
    
  Scenario: Successfully create a service  with addon
    Given the admin navigates to the Service tab  
    And the admin taps on Show All under services 
    And the admin is navigated to the services's list page 
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
    And the admin verifies the snackbar after creating the new service with addon  
    Then the service should be created successfully  
    When the admin clicks on the Back button
    Then the admin is navigated back to the home page
    
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
    Then the admin is navigated back to the home page
  
      Scenario: Adding a new  second staff through the admin portal
    Given the admin clicks on the Users tab
    When the admin clicks on Staff's Show All
    Then the admin is navigated to the staff list page
    When the admin clicks on the + button to add a new staff
    And the admin enters the first name "ADMIN_STAFF_2_FIRST_NAME"
    And the admin enters the last name "ADMIN_STAFF_2_LAST_NAME"
    And the admin enters the email "ADMIN_STAFF_2_EMAIL"
    And the admin selects the gender for Staff
    And the admin enters the Contact number "ADMIN_STAFF_2_CONTACTNUMBER"
    And the admin enters the additional contact number "ADMIN_STAFF_2_ADDITIONAL_CONTACT_NUMBER"
    And the admin enters the address line for staff 1
    And the admin enters the address line for staff 2
    And the admin selects the country
    And the admin enters the city or town "ADMIN_STAFF_2_CITY"
    And the admin enters the post code "ADMIN_STAFF_2_POSTCODE"
    And the admin clicks on the Skills dropdown and selects the staff's skill
    When the admin clicks on the Save button
    Then the new staff details should be successfully saved
    When the admin clicks on the Back button
    Then the admin is navigated back to the home page
    
  Scenario: create a breed
    Given the admin navigates to the Settings tab 
    And the admin opens the Manage Breed section
    Then the admin is navigated to the Breed list page
    When the admin clicks on the Plus button to add a new breed
    And the admin enters Breed Name in the breed name field
    And the admin taps the save button
    Then the new breed details should be successfully saved
    When the admin clicks on the Back button
    Then the admin is navigated back to the home page

  Scenario: create a new service pool
    Given the admin navigates to the Settings tab 
    When the admin navigates to Manage Service Pools
    Then the admin is navigated to the service pools list page
    And the admin clicks on the Plus button to add a new pool
    And the admin enters Pool Name 
    And the admin enters Pool Remarks 
    And the admin enters Pool Capacity 
    And the admin clicks on the Save button
    Then the new service pool details should be successfully saved
    When the admin clicks on the Back button
    And the admin taps the Home icon
    Then the admin is navigated back to the home page
  
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
    Given the admin navigates to the Settings tab  
    And the admin clicks on the logout button  
    Then the admin should be logged out successfully  