
Feature: E2E test scenario

Background:
Given Navigate to baseUrl

  @Regression
  Scenario Outline: Positive E2E test scenario
    Given login with username <name> and password <password>
    When product <product> added to cart and checkout
    Then  verify the details "***"

    Examples: 
      | name                |          password      | product  |
      |sambhajibhanuse333@gmail.com |  Sambhaji@0207 | Nikon D300 |
 
