Feature: Healenium test

  Scenario Outline: testing the login module in order to self-heal locators
    Given that Mike was on the serenity demo page
    When attempts to log in with this info
      | user   | pass   |
      | <user> | <pass> |
    Then will try to heal in case of change and validate the <text> on screen
    Examples:
      | user  | pass     | text      |
      | admin | serenity | Dashboard |