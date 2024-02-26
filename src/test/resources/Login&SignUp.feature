Feature: Login and SignUp Scenarios for Demoblaze.

  Background: Homepage Nav.
    Given I Navigate to the homepage
    Then I am in the Homepage

#   If this Scenario Fails, add proper credentials matching an non-existing user for sign-up Process
  Scenario: Sign-Up to DemoBlaze with Accurate Info and Verifying Login Works.
    And I SignUp to DemoBlaze using the username "StanleyTest38" and password "C0mpl3j0"
    Then I expect a successful signUp
    Then I login to DemoBlaze using the username "StanleyTest38" and password "C0mpl3j0"
    And I Verify Im Logged In
    Then I logOut from Demoblaze

  Scenario: Sign-Up to DemoBlaze with Already Existing Info.
    And I SignUp to DemoBlaze using the username "StanleyTest15" and password "C0mpl3j0"
    Then I expect that the SignUp Failed

  Scenario: Sign-up with The Username on Null
    And I SignUp to DemoBlaze using the username "" and password "C0mpl3j0"
    Then I expect that the SignUp Failed

  Scenario: Sign-up with the password on null
    Then I SignUp to DemoBlaze using the username "StanleyTest31" and password ""
    And I expect that the SignUp Failed

  Scenario: Sending null value in username and password
    Then I login to DemoBlaze using the username "" and password ""
    And I expect that the Login failed

  Scenario: Sending a value in username and null in password
    Then I login to DemoBlaze using the username "StanleyTest31" and password ""
    And I expect that the Login failed

  Scenario: Sending null in username and value in password
    Then I login to DemoBlaze using the username "" and password "C0mpl3j0"
    And I expect that the Login failed

  Scenario: Sending max length characters in both inputs, username and password
    Then I login to DemoBlaze using the username "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum" and password "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum"
    And I expect that the Login failed

  Scenario: Succesfull login into DemoBlaze
    Then I login to DemoBlaze using the username "StanleyTest31" and password "C0mpl3j0"
    And I Verify Im Logged In