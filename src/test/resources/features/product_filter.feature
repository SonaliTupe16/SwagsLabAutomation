Feature: Product filtering

  Scenario: Filter products from low to high price
    Given user logs in to filter products with username "standard_user" and password "secret_sauce"
    When user sorts the products by "Price (low to high)"
    Then the product list should be displayed in ascending order