Feature: Login page feature
  Scenario: Login page title
    Given user is on login page
    When user gets title of the page
    Then page title should be "Saral"

  Scenario: Login with phone number credentials
    Given user is on login page
    When  user enters phone number "6786780011"
    And user clicks on otp
    And user enters otp "010203"
    And user clicks on login
    Then user gets the title of the page
    And Page title should be "Saral"

  Scenario: Login with Email credentials
    Given user is on login pages
    When  user enters Email id "meenakshi001admin@gmail.com"
    And user enters Password "Test@123"
    And user clicks on otp
    And user enters otp "010203"
    And user clicks on login
    Then user gets the title of the Homepage
    And HomePage title should be "Saral"