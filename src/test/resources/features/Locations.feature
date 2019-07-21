#Author: instructor@syntaxtechs.com
@locations
Feature: Locations
  Valiation for locations functionality

  Background: 
    Given I logged in into OrangeHrm
    And I click on Admin link
    And I click on Organization link
    And I click on Locations links

  @smoke @sprint5
  Scenario Outline: Add new locations (mandatory fields)
    When I click on Add Locations
    And I add "<Name>", "<Country>", "<City>" and "<Zip>"
    And I click Save button
    Then I see location "<Name>", "<Country>", "<City>" and "<Zip>" is added

    Examples: 
      | Name     | Country   | City      | Zip   |
      | Syntax   | Pakistan  | Islamabad | 12345 |
      | Java     | Bahamas   | Nassau    | 12346 |
      | Selenium | Australia | Sydney    | 54321 |

  @regression @sprint4
  Scenario: Add new locations labels verification
    When I click on Add Locations
    Then I see Location Labels displayed
      | Name            |
      | Country         |
      | Time Zone       |
      | State/Province  |
      | City            |
      | Zip/Postal Code |
      | Phone           |
      | Fax             |
      | Address         |
      | Notes           |
