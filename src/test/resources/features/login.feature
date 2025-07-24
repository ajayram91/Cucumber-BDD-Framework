
@regression
Feature: Login to Crater

  Background:
    Given User navigates to Crater website

  @smoke
  Scenario: User logs in with valid username and password
    When I enter "ajay@primetechschool.com" in the email field
    And I enter "ptschool" in the password field
    And I click on the Login button
    Then I should see the Settings page
    And I log out of crater application


  Scenario: User should not be able to login with invalid username and password
      When I enter "invalidemail@gmail.com" in the email field
      And I enter "invalid" in the password field
      And I click on the Login button
      Then I should see an error message

  Scenario: User should not be able to login with valid username and invalid password
    When I enter "entityadmin@primetechschool.com" in the email field
    And I enter "invalid" in the password field
    And I click on the Login button
    Then I should see an error message


  Scenario: User should not be able to login with invalid username and valid password
    When I enter "entityadmin@primetechschool.com" in the email field
    And I enter "invalid" in the password field
    And I click on the Login button
    Then I should see an error message
