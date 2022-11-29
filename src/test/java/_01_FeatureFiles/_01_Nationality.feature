Feature:Nationality Feature

  @SmokeTest
  Scenario Outline: Add Nationality Positive
    Given User add nation "<name>"
    Then Success message should be displayed

    Examples:
      | name |
      | Tr15 |

  @SmokeTest @Regression
  Scenario: Add Nationality Negative
    When User add same nation name
      | Tr15 |
    Then Exist message should be displayed

  @SmokeTest @Rerun
  Scenario Outline: Edit Nationality
    Given User edit Nation "<name>" to new Nation "<name2>"
    Then Success message should be displayed
    Examples:
      | name | name2 |
      | Tr15 | UKY1  |

  @SmokeTest @Rerun
  Scenario Outline: Delete Nationality Positive
    Given User delete nation "<name>"
    Then Success message should be displayed
    Examples:
      | name |
      | UKY1 |

  @SmokeTest @Regression
  Scenario Outline: Delete Nationality Negative
    When User search deleted "<name>" in search input
    Then There is no data should be displayed
    Examples:
      | name |
      | UKY1 |






