Feature: verify the element in the trash page are being deleted after 7 days of delete date
  @trashDelete
  Scenario: user verifies the elements are deleted after 7 days of the delete date
    Given user is in studyMate login page
    Given user provides valid a username
    And user provides valid password
    When user clicks on login button
    Then verify the user is on the main page
    When user clicks on the trash link
    Then verify the user in on the trash page
    And verify the items will be deleted text is displayed
    Then user locates the number of elements, provides it to the elements input and clicks enter
    Then user verifies if the elements had been deleted