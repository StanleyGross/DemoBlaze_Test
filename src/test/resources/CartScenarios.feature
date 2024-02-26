Feature: Cart Related Scenarios

Background: Login
  Given I Navigate to the homepage
  Then I am in the Homepage
  Then I login to DemoBlaze using the username "StanleyTest31" and password "C0mpl3j0"
  And I Verify Im Logged In


  Scenario: Add Products to Cart And Check total Pricing.
    And I Verify Im Logged In
    And I Add a product to the Cart
    Then I Navigate to the homepage
    Then I navigate to the next product page(pagination)
    And I Add a product to the Cart
    Then I Navigate to the Cart
    And I Check Total price Against Added products

  Scenario: Add Products to Cart, Delete items from cart and Check total pricing
    And I Verify Im Logged In
    And I Add a product to the Cart
    Then I Navigate to the homepage
    Then I navigate to the next product page(pagination)
    And I Add a product to the Cart
    Then I Navigate to the Cart
    And I delete 1 item(s) from cart
    And I Check Total price Against Added products