#Author: avanchristian-trials65.orangehrmlive.com
@sprint3 @login
Feature: Login

  Background: 
    Given I see OrangeHrm logo

  @smoke 
  Scenario: Valid login
    When I enter valid username and password
    And I click login button
    Then I succesfully logged in

  @regression
  Scenario: Invalid login
    When I enter invalid username and password
    And I click login button
    Then I see error message is displayed

  @regression
  Scenario: Error message Validation
    When I enter invalid username and password I see errorMessage
      | UserName | Password | ErrorMessage        |
      | Admin1   | Test     | Invalid Credentials |
      | Admin2   | Test1    | Invalid Credentials |
      | Admin3   | Test2    | Invalid Credentials |
