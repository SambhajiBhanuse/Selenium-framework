
Feature: Login with invalid credential

  @tag2
  Scenario Outline: Invalid credential test
    Given Navigate to baseUrl
    When with username <name> and password <password>
    Then verify the url of current page

    Examples: 
      | name                         | password | 
      | sambhajibhanuse33@gmail.com |     Sambhaji@207 | 
     

      
