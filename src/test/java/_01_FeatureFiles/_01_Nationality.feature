Feature:Nationality Feature

  @SmokeTest
  Scenario Outline: Add Nationality Positive
    Given User add nation "<name>"
    Then Success message should be displayed

    Examples:
      | name |
      | Tr15 |
      | UK23 |

  @SmokeTest @Regression
  Scenario: Add Nationality Negative
    When User add same nation name
      | Tr15 |
      | UK23 |

    Then Exist message should be displayed

  @SmokeTest @Rerun
  Scenario: Edit Nationality
    Given User edit Nation Name
      | Tr15 | UK23 |
    Then Success message should be displayed

  @SmokeTest @Rerun
  Scenario Outline: Delete Nationality Positive
    Given User delete nation "<name>"
    Then Success message should be displayed
    Examples:
      | name |
      | UKY1 |
      | RUY2 |

  @SmokeTest @Regression
  Scenario Outline: Delete Nationality Negative
    When User search deleted "<name>" in search input
    Then There is no data should be displayed
    Examples:
      | name |
      | UKY1 |
      | RUY2 |






