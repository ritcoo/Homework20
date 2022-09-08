Feature: Add to Cart

  Scenario Outline: Login to Site and Add an Item To Cart
    Given user navigates to the Login page
    And user enters <username> and <password>
    And clicks the Login CTA
    When the user selects an item and adds it to the Cart
    Then the user verifies that the item is added to the card
      Examples:
        | username        | password     |
        | standard_user   | secret_sauce |


