Feature:Fields Feature

  @SmokeTest @Dede
  Scenario Outline: Add Fields Positive
    Given User add field "<name>" and "<code>"
    Then Success message should be displayed

    Examples:
      | name         | code   |
      | JoseFieldOne | 123451 |

  @SmokeTest @Dede
  Scenario: Add Fields Negative
    When User add same field name
      | JoseFieldOne | 123451 |
    Then Exist message should be displayed


  @SmokeTest @Dede
  Scenario Outline: Edit Fields
    And User edit field "<existingFieldName>" and change it to "<newFieldName>"
    Then Success message should be displayed
    Examples:
      | existingFieldName | newFieldName |
      | JoseFieldOne | JoseUpdatedField |


  @SmokeTest @Dede
  Scenario Outline: Delete Fields Positive
    Given User delete field "<name>"
    Then Success message should be displayed
    Examples:
      | name         |
      | JoseUpdatedField |

    @SmokeTest @Dede
      Scenario Outline: Delete Fields Negative
      When user search deleted "<name>" in search input
      Then There is no data should be displayed
      Examples:
        | name         |
        | JoseUpdatedField |