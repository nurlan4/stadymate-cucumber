@StudentFilter
Feature:  should be able to filter students list by groups or study format

  Background:
    Given user go to codewise.studymate.us
    Then user enters valid “email” and valid “password”



  Scenario:
    Given user on Home page
    Then user clicks on Students
    And user located on Students page
    Given user is on students tab
    When user clicks on filter button
    And user sees a search parameters window popup
    Then user clicks on study format button
    Then user clicks on group button
    Then user clicks on apply button
