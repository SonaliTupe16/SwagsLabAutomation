Feature: Checkout process

  Scenario: Complete a purchase
    Given user logs in for checkout with username "standard_user" and password "secret_sauce"
    When user adds a product to cart
    And proceeds to checkout and fills info
    Then order should be placed successfully