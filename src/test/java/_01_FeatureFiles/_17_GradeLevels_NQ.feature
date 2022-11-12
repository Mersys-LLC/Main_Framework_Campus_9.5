Feature: Grade Levels functionality


  @SmokeTest
  Scenario Outline: Add Grade Levels positive
    Given Navigate to Grade Levels page
    When User creates new name "<gradeLevelsName>" "<shortName>" "<order>"
    Then User should see successful message

    Examples:
      |gradeLevelsName|shortName|order|
      |nigar          |qiyasova |  1  |


  @SmokeTest
  Scenario Outline: Add Grade Levels negative
   Given Navigate to Grade Levels page
    When User creates same name "<sameGradeLevelsName>" "<sameShortName>" "<sameOrder>"
    Then User should see unsuccessful message

    Examples:
      |sameGradeLevelsName|sameShortName|sameOrder|
      |nigar              |qiyasova     |  1      |



  @SmokeTest
  Scenario Outline: Edit Grade Levels
    Given Navigate to Grade Levels page
    When User scroll to find name and click Edit enter "<newName>" and click Save button
    Then User should see successfully updated message

    Examples:
    |newName|
    |melisa |



  @SmokeTest
  Scenario: Delete Grade Levels positive
   Given Navigate to Grade Levels page
    When User click Delete button
    Then User should see successfully deleted message



    @SmokeTest
    Scenario Outline: UnSuccessfully Delete Grade Levels positive
     Given Navigate to Grade Levels page
      When User click Grade Level name which is used by another document and click delete button and see this "<message>"
      Then User should delete unsuccessfully

      Examples:
      |message|
      |You can not delete this grade level. There is course with this grade level.|




