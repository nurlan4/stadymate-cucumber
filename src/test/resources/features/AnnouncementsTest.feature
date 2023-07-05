Feature: Find the right Announcement


  @test1
  Scenario: Make sure user can launch "Announcement" page

    Given user is on login page
    Then user provide valid credentials
    Then user navigates to announcements tab
    And  use check current URL with expected

    @test2
    Scenario:Make sure user can see announcement related chosen group
      Given user is on login page
      Then user provide valid credentials
      Then user navigates to announcements tab
      And user choose the group name on search dropdown
      And user can see chosen group on page

     @test3
     Scenario:Make sure user can see announcement related chosen group
       Given user is on login page
       Then user provide valid credentials
       Then user navigates to announcements tab
       And user choose the group name on search dropdown
       And user can see chosen group on page
       And user click on calendar from button and choose from date
       And user click on calendar from button and choose till date
       And user should see announcement related chosen group and date



