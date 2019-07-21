#Author: instructor@syntaxtechs.com
@skills
Feature: Skills
  Valiation for skills functionality

  Background: 
    Given I logged in into OrangeHrm
    And I click on Admin link
    And I click on Qualifications link
    And I click on Skills links

  @smoke @sprint6
  Scenario Outline: Add Skills
    When I click on Add
    And I provide "<Name>" and "<Description>" for that skill
    And I click Save button
    Then I see skill "<Name>" and "<Description>" is added

    Examples: 
      | Name     | Description          |
      | Java     | Programming language |
      | Selenium | Testing Tool         |
      | Cucumber | Testing Framework    |
      | Maven    | Build Tool           |
      | GIT      | Version Control Tool |