Feature: ApachePOI Nationality Feature

  @Apache
  Scenario: Create Nationality from Excel
    When User create new nationality with ApachePOI
  @Apache
  Scenario: Edit Nationality from Excel
    When User edit nationality with ApachePOI
  @Apache
  Scenario: Delete Nationality from Excel
    Then User delete nationality with ApachePOI