Feature: Google Search

  Scenario: Search by typing
    Given I navigated to the Google
    When I type search item
    And I click on google search button
    Then I see search results are displayed
