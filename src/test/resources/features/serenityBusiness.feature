Feature: testing the serenity demo page

  Background:

    Given that Mike was on the serenity demo page
    When attempts to log in with this info
      | user  | pass     |
      | admin | serenity |

  Scenario: Mike wants to create an unit business

    When Mike creates a new unit business and setups a meeting

    Then Mike will be able see the meeting was successfully scheduled