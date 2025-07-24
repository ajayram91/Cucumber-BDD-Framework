Feature: Add Item Functionality

  @regression @5.1 @items
  Scenario: User Sucessfully adds a new item
    Given User is logged in sucessfully
    When User clicks on the Add Item button
    And User enters the item name as "baseball"
    And User enters the item description as "description"
    And User enters the item price ".99"
    And User clicks on the Save Item button
    Then Item should be listed in the items table
    And I should view the item added in the Database
