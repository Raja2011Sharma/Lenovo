Feature: Login page feature
  Scenario: Login page title
    Given user is on login page
    When user gets title of the page
    Then page title should be""

  Scenario: Login with phone number credentials
    Given user is on login page
    When  user enters phone number""
    And user clicks on otp
    And user enters otp ""
    And user clicks on login
    Then user gets the title of the page
    And Page title should be ""

  Scenario: Login with Email credentials
    Given user is on login pages
    When  user enters Email id ""
    And user enters Password ""
    And user clicks on otpbutton
    And user enters otps ""
    And user clicks on loginbutton
    Then user gets the title of the Homepage
    And HomePage title should be ""