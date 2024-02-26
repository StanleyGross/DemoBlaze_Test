Feature: Demo blaze: In this feature file will be contained all of the primary actions available on the page.

  Background: Login
    Given I Navigate to the homepage
    Then I am in the Homepage
    Then I login to DemoBlaze using the username "StanleyTest31" and password "C0mpl3j0"
    And I Verify Im Logged In

  Scenario: Add Products to Cart from a Single page.
    And I Verify Im Logged In
    And I Add a product to the Cart
    Then I Navigate to the Cart

  Scenario: Add Products to Cart from more than a page(pagination)
    And I Verify Im Logged In
    And I Add a product to the Cart
    Then I Navigate to the homepage
    Then I navigate to the next product page(pagination)
    And I Add a product to the Cart

  Scenario:  Navigate to the product store page and add multiple products from the first page to the cart.
    And I Verify Im Logged In
    And I Add multiple products from the "first" product page.

  Scenario:  Navigate to the product store page and add multiple products from the first page to the cart.
    And I Verify Im Logged In
    Then I navigate to the next product page(pagination)
    And I Add multiple products from the "Second" product page.
