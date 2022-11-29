Feature:Document Types

  @SmokeTest1
  Scenario Outline: Add Document Type
    Given User add Document Types "<name>"
    Then Successfully Created message should be displayed

    Examples:
      | name    |
      | ATechno |

  @SmokeTest1
  Scenario Outline: Add same data Document Types
    Given User create same Document Types "<name>"
    Then Already Exist message should display

    Examples:
      | name    |
      | ATechno |


  @SmokeTest1
  Scenario Outline: Edit Document Types
    When User search same "<name>" in search input edit with "<newName>"
    Then Successfully updated message should be displayed

    Examples:
      | name    | newName |
      | ATechno | BTechno |

  @SmokeTest1
  Scenario Outline: Delete Document Types
    When User search newName "<newName>" in  the search input and Delete it
    Then Successfully Deleted message should be displayed
    Examples:
      | newName |
      | BTechno |

  @SmokeTest1
  Scenario Outline: Delete Document Types Negative
    When User search deleted "<newName>" in the search input
    Then There is no data message should be displayed

    Examples:
      | newName |
      | BTechno |
