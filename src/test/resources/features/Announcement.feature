@announcementTest
Feature: create announcements and choose group

  Background:
    Given user go to codewise.studymate.us
    Then user enters valid "email" and valid "password"



  Scenario:User should be able create announcements and choose group
    Given user on Home page
    Then user clicks on Announcements
    And user located on Announcements page
    When user clicks on Add an Announcement button
    And user enters name of Announcement
    Then user clicks on Group
    Then user should see the Для всех option instead For all
    Then user clicks on Add button
