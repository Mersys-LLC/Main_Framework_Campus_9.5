Feature:Fields Feature

  @SmokeTest2
  Scenario Outline: Add Fields Positive
    Given User add field "<name>" and "<code>"
    Then Success message should be displayed

    Examples:
      | name         | code   |
      | JoseFieldOne | 123451 |

  @SmokeTest2
  Scenario: Add Fields Negative
    When User add same field name
      | JoseFieldOne | 123451 |
    Then Exist message should be displayed


  @SmokeTest2
  Scenario Outline: Edit Fields
    And User edit field "<existingFieldName>" and change it to "<newFieldName>"
    Then Success message should be displayed
    Examples:
      | existingFieldName | newFieldName |
      | JoseFieldOne | JoseUpdatedField |


  @SmokeTest2
  Scenario Outline: Delete Fields Positive
    Given User delete field "<name>"
    Then Success message should be displayed
    Examples:
      | name         |
      | JoseUpdatedField |

    @SmokeTest2
      Scenario Outline: Delete Fields Negative
      When user search deleted "<name>" in search input
      Then There is no data should be displayed
      Examples:
        | name         |
        | JoseUpdatedField |