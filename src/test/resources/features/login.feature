Feature: Login to Crater

  Scenario: User logs in with valid username and password

    Given User navigates to Crater website
    When I enter "ajay@primetechschool.com" in the email field
    And I enter "ptschool" in the password field
    And I click on the Login button
    Then I should see the Settings page