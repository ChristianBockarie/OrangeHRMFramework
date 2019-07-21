#Author: avanchristianbock.33sl@gmail.com
@jobtitle
Feature: Job Title
  Validation for Job title functionality

  Background: 
    Given I logged in into to OrangeHrm

  @db @regression
  Scenario Outline: Job Title Validation
    And I click on Admin
    And I click on job link
    And I click on jobtitle
    When I get all job titles from UI
    And I execute "<sqlQuery>" from Database 
    Then I see results from UI and Database are matched

    Examples: 
      | Query                                         |
      | SELECT JOB_TITLE FROM JOBS ORDER BY JOB TITLE |
