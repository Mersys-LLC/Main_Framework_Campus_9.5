Feature:Fields Feature

  @SmokeTest @Regression
  Scenario Outline: Add Fields Positive
    Given User add field "<name>" and "<code>"
    Then Success message need to be displayed

    Examples:
      | name         | code   |
      | JoseFieldOne | 123451 |

  @SmokeTest @Regression
  Scenario: Add Fields Negative
    When User add same field name
      | JoseFieldOne | 123451 |
    Then Exist message need to be displayed


  @SmokeTest @Regression
  Scenario Outline: Edit Fields
    And User edit field "<existingFieldName>" and change it to "<newFieldName>"
    Then Success message need to be displayed
    Examples:
      | existingFieldName | newFieldName     |
      | JoseFieldOne      | JoseUpdatedField |


  @SmokeTest @Regression
  Scenario Outline: Delete Fields Positive
    Given User delete field "<name>"
    Then Success message need to be displayed
    Examples:
      | name             |
      | JoseUpdatedField |

  @SmokeTest @Regression
  Scenario Outline: Delete Fields Negative
    When user search deleted "<name>" in search input
    Then There is no data need to be displayed
    Examples:
      | name             |
      | JoseUpdatedField |