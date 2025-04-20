Feature: Add product to cart

  Scenario: Add first product to cart
    Given user is logged in with username "standard_user" and password "secret_sauce"
    When user adds the first product to the cart
    Then the cart icon should show 1 item