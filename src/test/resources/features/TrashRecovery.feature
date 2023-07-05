@Recovery @regression
Feature: Item does recovery
  As a user I would like to be able to recover items from trash page
  Background:
    Given User on Annoucements page

  Scenario: Successful restoring an Item
    Given User clicks on trash pages
    And User should be redirected to trash page
    And User clicks on recover button on some item
    Then Verify that the item was recovered on some other page