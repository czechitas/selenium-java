Feature: Shop Products

  Background:
    Given user is on the shop page


  Scenario: User can see products with name and price
    Then there are 4 products
    And each product has name
    And each product has price


  Scenario Outline: User can search products by name: <search>
    When he searches by "<search>"
    Then there are <number> products
    And each product name contains "<search>"

  Examples:
    | search  | number |
    | Vintage | 3      |
    | Retro   | 4      |
