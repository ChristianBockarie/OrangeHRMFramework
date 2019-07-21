#Author: instructor@syntaxtechs.com
@users
Feature: Users
  Valiation for users functionality

  Background: 
    Given I logged in into OrangeHrm
    And I click on Admin link
    And I click on User Management link
    And I click on Users link

  @regression @sprint4
  Scenario: Add Users labels verification
    When I click on Add Users
    Then I see Add Users Labels displayed
      | Employee Name      |
      | Username           |
      | ESS Role           |
      | Supervisor Role    |
      | Admin Role         |
      | Status             |
      | Password           |
      | Confirmed Password |