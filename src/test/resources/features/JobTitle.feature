#Author: avanchristianbock.33sl@gmail.com
@jobtitle
Feature: Job Title
  Validation for Job title functionality

  Background: 
    Given I logged in into OrangeHrm
    And I click on Admin
    And I click on job
    And I click on jobtitle

 @smoke @sprint5
  Scenario Outline: Add Job
    When I click on addJobTitle
    And I enter job "<Title>", "<Description>" and job "<Specification>"
    And I click Save button
    Then I see job "<Title>", "<Description>" and job "<Specification>" is added

    Examples: 
      | Title                           | Description    | Specification                                    |
      | President                       | President      | /src/test/resources/testdata/JobDescription.docx |
      | Administration Vice President   | Vice President | /src/test/resources/testdata/JobDescription.docx |
      | Administration Assistant        | Assistant      | /src/test/resources/testdata/JobDescription.docx |
      | Finance Manager                 | Manager        | /src/test/resources/testdata/JobDescription.docx |
      | Accountant                      | Accountant     | /src/test/resources/testdata/JobDescription.docx |
      | Accounting Manager              | Manager        | /src/test/resources/testdata/JobDescription.docx |
      | Public Accountant               | Accountant     | /src/test/resources/testdata/JobDescription.docx |
      | Sales Manager                   | Manager        | /src/test/resources/testdata/JobDescription.docx |
      | Sales Representative            | Representative | /src/test/resources/testdata/JobDescription.docx |
      | Purchasing Manager              | Manager        | /src/test/resources/testdata/JobDescription.docx |
      | Purchasing Clerk                | Clerk          | /src/test/resources/testdata/JobDescription.docx |
      | Stock Manager                   | Manager        | /src/test/resources/testdata/JobDescription.docx |
      | Stock Clerk                     | Clerk          | /src/test/resources/testdata/JobDescription.docx |
      | Shipping Clerk                  | Clerk          | /src/test/resources/testdata/JobDescription.docx |
      | Programmer                      | Java Developer | /src/test/resources/testdata/JobDescription.docx |
      | Marketing Manager               | Manager        | /src/test/resources/testdata/JobDescription.docx |
      | Marketing Representative        | Representative | /src/test/resources/testdata/JobDescription.docx |
      | Human Resources Representative  | Representative | /src/test/resources/testdata/JobDescription.docx |
      | Public Relations Representative | Representative | /src/test/resources/testdata/JobDescription.docx |

  @db @regression
  Scenario Outline: Job Title Validation
    When I get all job titles from UI
    And I execute "<sqlQuery>" from Database
    Then Job titles are matched

    Examples: 
      | Query                                         |
      | SELECT JOB_TITLE FROM JOBS ORDER BY JOB TITLE |
