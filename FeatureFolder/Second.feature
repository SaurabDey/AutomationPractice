@F2
Feature: Negative Feature

@regression
   Scenario Outline: Negative Scenario 1
   	Given I have the site
    When I provide incorrect <user> and <pass>
    Then I should not get logged in

    Examples: 
      | user   | pass      |
      | saurab | demo123   |
      | admin  | saurab123 |
      | saurab | saurab123 |