Feature: Testing DB_JDBC Nationality Feature

  @DBrun
  Scenario: Nations testing with JDBC
    Given Navigate to nationalities feature
    Then  Send the query the database "select * from nation" and control match