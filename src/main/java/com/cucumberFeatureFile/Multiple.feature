Feature: Booking Application Sanity Flow 

  Scenario: Launch application in emulator
    Given PropertyFile Loaded
    And  Configure driver
    And  Api configuration
    And  Open the application
    Then Successfully navigated to the login screen
    
      #Scenario: User login using email as admin (predefined account)
    #Given the user enters their predefined "PREDEFINED_CUSTOMER_EMAIL" address
    #When the user clicks on the Continue button
    #And the user enters the Predefined Otp "PREDEFINED_CUSTOMER_OTP"
    #Then the user should be logged in successfully
    
    #Scenario: Create a booking for one pet on a multiple date
    #Given the user selects a service
    #When the user fetches the slot list for the selected service using the API
    #And the user selects a random slot from the slot list, scrolling the slot picker if necessary
    #And the user determines the From Date and To Date for the service based on constraints and the user calculates the date range and picks Multiple dates
    #Then the user should successfully navigate to the Confirm Booking Details page
    #And the user verifies the service name, date, and slot
    #And the user taps the Proceed button
    #Then the user navigates to the Review Booking page
    #And the user reviews the total amount and remaining credit amount
    #And the user taps the checkbox and taps the Confirm and Pay button
    #Then the user initiates the payment process
    #Then the user navigates to the Booking Request Successful page
    #And the user saves the booking details
    #And the user taps the My Bookings button
    #Then the user navigates to the My Bookings page
    #And the user verifies that the booking is listed on the My Bookings page
    
    
    
    
    
    
    