Feature: Booking feature

  Scenario: Verify is able to book hotel
    Given user open website
    When user enter going to destination "New York"
    And user enter travel dates
    And user provides travelers and room
    And user click search button
    Then verify user is on Hotel listing page
    When user sort by star rating
    Then print prices over $ 500



