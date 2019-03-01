@F1
Feature: Login Feature

  Background: 
    Given I have the site

@smoke
@regression
  Scenario: Positive Scenario
    When I provide admin and demo123
    Then I should get logged in
