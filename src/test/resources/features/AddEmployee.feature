#Author: avanchristian-trials65.orangehrmlive.com
@sprint  @AddEmployee
Feature: Add Employee

  Background: 
    Given I logged in into OrangeHrm
    And I click on PIM link
    And I click on Add employee link

  @smoke @addEmployee
  Scenario Outline: Adding Employee
    When I provide Employee details "<fName>", "<mName>", "<lName>", "<location>" 
		And I click on save button
		Then I see employee "<fName>", "<lName>" is displayed
		
    Examples: 
      | fName | mName | lName | location     |
      | Adnan | A     | Smith | West Office  |
      | Admi  | M     | Beck  | HQ           |
      | Smile | Y     | Cheff | North Office |

  @regression @temp
  Scenario Outline: Add Employee and Create Login Details
    When I provide employee details from "EmployeeDetails"
   	And I click on create login details
    And I provide all mandatory fields "<userName>", "<passWord>", "<confirmPassword>", "<adminRole>" 
    And I click on save button
   	Then I see employee "<fName>", "<lName>" is displayed
    
    Examples: 
      | userName | passWord    | confirmPassword | adminRole    |
      | Admin1   | Tester1234! | Tester1234!     | Global Admin |

  @regression
  Scenario: Add Employee Labels Verification
    Then I see following labels
      | First Name  |
      | Middle Name |
      | Last Name   |
      | Employee Id |
      | Location    |
