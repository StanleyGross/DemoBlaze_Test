# Define 2 of the most important test scenarios from each area below: (Regression Suite)
# Note: There's "possible" scenarios that were written here, but the capabilities of the provided demoBlaze page are currently not available for me to automate those scenarios.

## Sign Up
### Scenario 1: Incorrect format of new credentials
* Sign-Up to DemoBlaze with Already Existing Info.
* Sign-Up to demoblaze with incorrect info
* Sign-up with The Username on Null
* Sign-up with the password on null
### Scenario 2: Incorrect Storage of accurate credentials/Credentials not working after sign-up
*  Register with valid credentials and then attempt to log in with those same credentials.
* Register with valid credentials, log out, and then try to log in again with those same credentials.
## Log-in:
### Scenario 1: Incorrect Credentials in login.
* Sending null value in username and password
* Sending a value in username and null in password
* Sending null in username and value in password
* Sending max length characters in both inputs, username and password
* Sending correct username and wrong password
### Scenario 2: Incorrect login results(Credentials/Token not being applied to the page.)
* Attempt login with Correct credentials and assert that the user is logged in


## Product Store:
### Scenario 1: Ability to add products to cart
* Test Case 1: Select a product and add it to the cart.
* Test Case 2: Try adding a product to the cart that is out of stock.
* Test Case 3: Add a product to the cart and verify it appears with the correct quantity.
* Test Case 4: Add a product to the cart and check if the cart total updates accordingly.
* Test Case 5: Add a product to the cart and ensure it's reflected in the user's cart history.
### Scenario 2: Ability to add multiple products to page(From 1 or more indexes(Pagination))
#### Adding Products from First Page:
Test Case 1: Navigate to the product store page and add multiple products from the first page to the cart.
Test Case 2: Navigate to the last page of product listings and add multiple products to the cart.
Test Case 3: Navigate through multiple pages of product listings and add products from different pages to the cart.
Test Case 4: Navigate through the pagination controls (e.g., next page, previous page, page numbers) and add products from various pages to the cart.
Test Case 5: Attempt to add the maximum number of products allowed per page to the cart.

## Cart:
### Scenario 1: Accurate pricing on Cart total
* Test Case 1: Add multiple items to the cart and verify that the total price is accurate.
* Test Case 2: Add items with different prices to the cart and ensure the total reflects the correct sum.
* Test Case 3: Add items to the cart, remove some, and verify that the total updates accordingly.
* Test Case 4: Add items to the cart, change the quantity of some, and verify that the total adjusts correctly.
* Test Case 5: Add items to the cart, apply a discount code, and ensure the total reflects the discounted price.
### Scenario 2: Ability to remove items from cart and pricing adjusting properly
Test Case 1: Add multiple items to the cart, then remove one item from the cart.
Test Case 2: Add several items to the cart, then remove multiple items from the cart in one action.
Test Case 3: Add multiple items to the cart, then remove the last remaining item from the cart.
Test Case 4: Add multiple items to the cart, note the total price, then remove one or more items and verify that the total price adjusts accordingly.
Test Case 5: Add several items to the cart, remove some items, add more items, and remove additional items, then verify that the total price updates correctly after each action.


## Place Order(Purchase):
### Scenario 1: Incorrect billing info to complete purchase
* Test Case 1: Proceed to checkout with incomplete billing information.
* Test Case 2: Enter billing information with invalid format (e.g., wrong zip code format).
* Test Case 3: Attempt to complete the purchase with a billing address that doesn't match the payment method.
* Test Case 4: Leave mandatory fields like billing address or payment information blank during checkout.
* Test Case 5: Enter billing information for a region where the service doesn't support delivery and check if the purchase is blocked.
### Scenario 2: Incorrect purchase results with correct billing info.
Test Case 1: Proceed with the purchase using correct billing information, then check for any unexpected outcomes or errors.
Purchase Attempt with Expired Payment Method:
* Test Case 2: Attempt to complete the purchase using a payment method that has expired or is no longer valid.
Purchase Attempt with Insufficient Funds:
* Test Case 3: Try to complete the purchase with a payment method that has insufficient funds to cover the transaction.
Purchase Attempt with Server Error:
* Test Case 4: Proceed with the purchase using correct billing information, but simulate a server error during the transaction processing.
* Purchase Attempt with Invalid Product Quantity:
Test Case 5: Try to complete the purchase with an invalid quantity of products (e.g., negative quantity, zero quantity).

