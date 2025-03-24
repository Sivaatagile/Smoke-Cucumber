Feature: Booking Application Sanity Flow 

  Scenario: Launch application in emulator
    Given PropertyFile Loaded
    #And  Set key values
    And Configure driver
    And Api configuration
    And Open the application
    Then Successfully navigated to the login screen
    
 Scenario: Customer login using email (already created by admin)
    Given the customer enters their "SIGNUP_EMAIL" address
    When the customer clicks on the Continue button
    And the customer enters the Otp 
    Then the customer should be logged in successfully
    
    Scenario: Create a booking for one pet on a multiple date
    Given the user selects a service
    When the user fetches the slot list for the selected service using the API
    And the user selects a random slot from the slot list, scrolling the slot picker if necessary
    And the user determines the From Date and To Date for the service based on constraints and the user calculates the date range and picks Multiple dates
    Then the user should successfully navigate to the Confirm Booking Details page
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
    
    
    Scenario: Create a booking for multiple pet on a multiple date
    Given the user selects the second pet
    And the user selects a service
    When the user fetches the slot list for the selected service using the API
    And the user selects a random slot from the slot list, scrolling the slot picker if necessary
    And the user determines the From Date and To Date for the service based on constraints and the user calculates the date range and picks Multiple dates
    Then the user should successfully navigate to the Confirm Booking Details page
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
    
    