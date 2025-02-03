
@tag
Feature: Submit order of the product
Background:
Given I am on ecommerce page

  @tag1
  Scenario: Positive test of submitting the order 
    Given logged in with username <username> and password <passwrd>	
    When I add <productName> to cart 
    And checkout <productName> and submit the order
    Then "Thankyou for the order." message is displayed on confirmation page
    

  

    Examples: 
      | username        | passwrd        | productName  |
      | arhaa@gmail.com | Tinku@1911     |QWERTY        |
      
