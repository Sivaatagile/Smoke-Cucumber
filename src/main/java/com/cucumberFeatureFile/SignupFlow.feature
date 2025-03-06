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
    And the user verifies the snackbar after entering the user data
    And the user should be taken to the pet info page

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
    And the user verifies the snackbar after entering the pet data
    And the pet information should be saved successfully

  Scenario: User navigates to landing screen
    Given the user navigates to the landing page
    
   Scenario: Clearing the application cache and opening the application
    Given the admin clears the application cache
    When the admin opens the application
    Then the application launches successfully
    And the admin is navigated to the login page (or home page if already logged in)