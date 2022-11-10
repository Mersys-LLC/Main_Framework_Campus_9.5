Feature:Discounts Feature

  @SmokeTestD
  Scenario Outline: Add Discounts Positive
    Given User add Discount "<Description>" , "<Integration Code>" , "<Priority>"
    Then Success message should displayed

    Examples:
      | Description | Integration Code | Priority |
      | NilNilK     | 3535             | 1        |


  @SmokeTestD
  Scenario: Add Discount Negative
    When User add same Discount name
      | NilNilK      | 3535           | 1         |

    Then Exist message should displayed

  @SmokeTestD
  Scenario Outline: Edit Discounts
    And User edit Discount Data  "<ExistingDescription>" , "<ExistingIntegCode>" and change it to "<newDescription>" , "<newIntegCode>"
    Then Success message should displayed
    Examples:
      | ExistingDescription | ExistingIntegCode | newDescription | newIntegCode |
      | NilNilK             | 3535              |NilData4        | 356          |

  @SmokeTestD
  Scenario Outline: Delete Discounts Positive
    Given User delete Discount "<updatedDes>"
    Then Success message should displayed
    Examples:
      | updatedDes |
      | NilData4   |


  @SmokeTestD
  Scenario Outline: Delete Discounts Negative
    When User search deleted "<updatedDes>" in search input data
    Then There is no data should displayed
    Examples:
      | updatedDes |
      | NilData4   |
