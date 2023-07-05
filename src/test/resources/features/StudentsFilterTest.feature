@StudentFilter @regression
Feature:  should be able to filter students list by groups or study format

  Background:
    Given user go to codewise.studymate.us1
    Then user enters valid “email” and valid “password”1



  Scenario:
    Given user on Home page1
    Then user clicks on Students
    And user located on Students page
    Given user is on students tab
    When user clicks on filter button
    And user sees a search parameters window popup
    Then user clicks on study format button
    Then user clicks on group button
    Then user clicks on apply button
