Feature: Add Item Functionality with Scenario Outline

  @regression
  Scenario Outline: User successfully adds a new item
    Given User is logged in sucessfully
    When User clicks on the Add Item button
    And User enters the item name as "<name>"
    And User enters the item description as "<description>"
    And User enters the item price "<price>"
    And User clicks on the Save Item button
    Then Item should be listed in the items table

    Examples:
      | name     | description   | price |
      | Apple    | Fresh fruit   | 0.99  |
      | Banana   | Yellow fruit  | 1.25  |
      | Juice    | Cold drink    | 2.49  |