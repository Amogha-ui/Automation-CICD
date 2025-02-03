@tag
Feature: Error validation
  Background:
  Given I am on ecommerce page

  @Regression
  Scenario Outline: Title of your scenario outline
    Given logged in with username <username> and password <passwrd>	
    Then "Incorrect email or password." is displayed

    Examples: 
      | username        | passwrd        | 
      | arhaa@gmail.com | Tinku@11911    |
