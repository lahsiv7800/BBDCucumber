Feature: Implementation of DemoOnlineShop

  Scenario: Navigate through DemoOnlineShop
    Given User navigates through product categories
    When User adds laptops into the shopping cart
    And User deletes laptop from the cart
    And Click on place order
    Then User fills web form and clicks on purchase
    And User asserts purchase amount and clicks Ok.
