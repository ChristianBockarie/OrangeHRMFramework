#Author: instructor@syntaxtechs.com
  @qualification
Feature: OrangeHRM Qualification
     
     Descriptions: The purpose of this feature is to verify Qualification
     functionlity works as expected.

  @smoke @sprint6
  Scenario: Verify add qulification feature
    Given I logged in into OrangeHrm
    And I click on Admin link
    And I click qualifications link
    And I click on languages link
    Then I click on add button indicated with plus sign
    And I enter a language "English" 
    And I click on save button to save the language
    Then I verify that the language "English" is successfully added