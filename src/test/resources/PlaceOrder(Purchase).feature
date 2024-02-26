Feature: Demo blaze: In this feature file will be contained all of the primary actions available on the page.

  Background: Homepage Nav.
    Given I Navigate to the homepage
    Then I am in the Homepage

  Scenario Outline: I Complete a purchase with accurate information
    And I Verify Im Logged In
    And I Add a product to the Cart
    Then I Navigate to the Cart
    And I complete order using the following information: <Name>, <Country>, <City>, <CreditCard>, <Month> ,<Year>
    And I Expect the order to be correct
    Examples:
      | Name           | Country              | City            | CreditCard         | Month | Year   |
      | "Stanley Test" | "Dominican republic" | "Santo Domingo" | "4010401040104010" | "01 " | "2020" |

  Scenario Outline: I Complete a purchase with inaccurate information
    And I Verify Im Logged In
    And I Add a product to the Cart
    Then I Navigate to the Cart
    And I complete order using the following information: <Name>, <Country>, <City>, <CreditCard>, <Month> ,<Year>
    Then I expect that the purchase is incorrect
    Examples:
      | Name           | Country              | City            | CreditCard | Month | Year   |
      | "Stanley Test" | "Dominican republic" | "Santo Domingo" | ""         | "01 " | "2020" |


