Feature: Login feature

  Background: Back
    Given Opening site "https://practicetestautomation.com/practice-test-login"

  Scenario: User tries to log in
    When User entered correct email
    And User entered correct password
    And User clicked submit button
    Then Home page is displayed