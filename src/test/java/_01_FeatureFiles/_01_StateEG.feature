Feature: State Feature

  @evisa4
  Scenario Outline: Add State Positive
    Given User add state "<name>"
    Then User should see a success message

   Examples:
      | name     |
      | Eldorado |

  @evisa4
  Scenario: Add State Negative
    When User add same state name
      | Eldorado |
    Then User should see an exist message

  @evisa4
  Scenario Outline: Edit State
    Given User edit State "<name>" "<updatedName>"
    Then User should see a success message
   Examples:
     |name         |updatedName|
     |  Eldorado   | Durres    |


  @evisa4
  Scenario Outline: Delete State Positive
    Given User delete state "<name>"
    Then User should see a success message
    Examples:
            |name       |
            | Durres    |


  @evisa4
  Scenario Outline: Delete State Negative
    When User search  "<name>" in  input
    Then User should see there is no data to be displayed message
    Examples:
    |name     |
    | Durres  |

