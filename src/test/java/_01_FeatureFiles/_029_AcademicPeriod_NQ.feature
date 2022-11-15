Feature: Academic Period functionality

  @SmokeTest @Run
  Scenario Outline: Add Academic Period Positive
    Given User add Academic Period "<name>", "<startDate>", "<endDate>"
    Then User should see successfully added message

    Examples:
    |   name   | startDate  |  endDate |
    | season1  | 12/01/2022 |01/01/2023|


  @SmokeTest @Run
  Scenario Outline: Add Academic Period Negative1
    Given User add same Academic Period name "<sameName>", "<sameStartDate>", "<sameEndDate>"
    Then User should see date range conflicts message

    Examples:
      | sameName |sameStartDate|sameEndDate|
      | season1  |12/01/2022   |01/01/2023 |

  @SmokeTest @Run
  Scenario Outline: Add Academic Period Negative2
    Given User add same Academic Period name "<sameName>", different date range "<differentStartDate>", "<differentEndDate>"
    Then User should see already exists message

    Examples:
      |sameName  | differentStartDate  |  differentEndDate |
      | season1  | 02/01/2023          | 03/01/2023        |



  @SmokeTest @Run
  Scenario Outline: Add Academic Period Negative3
    Given User add different Academic Period name "<differentName>", "<sameStartDate>", "<sameEndDate>"
    Then User should see date range conflicts message

    Examples:
      | differentName |sameStartDate|sameEndDate|
      | season2       |12/01/2022   |01/01/2023 |



  @SmokeTest @Run
  Scenario Outline: Edit Academic Period
    Given User edit Academic Period name "<newName>", date range "<newStartDate>", "<newEndDate>"
    Then User should see successfully updated messages

    Examples:
    |newName|newStartDate|newEndDate|
    |season3|03/01/2023  |04/01/2023|




  @SmokeTest @Run
  Scenario: Delete Academic Period Positive
    Given User delete Academic Period
    Then User should see successfully deleted messages






























