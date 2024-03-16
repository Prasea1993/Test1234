Feature: User Registration

  Scenario Outline: Verify user registration with valid test data
    Given user launches the application
    And user click on signup or login link on homepage
    And user enters "<username>" and "<emailId>" and clicks on signup button
    And user enters "<title>" and "<password>" and "<day>" and "<month>" and "<year>"
    And user enters "<firstname>" and "<lastname>" and "<address1>" and "<address2>"
    And "<country>" and "<state>" and "<city>" and "<zipcode>" and "<mobilenumber>"
    And user click on  create account button
    Then user should be able to view the account creation confirmation

    Examples:
      | username | emailId | title | password | day | month | year | firstname | lastname | address1 | address2 | country | state | city | zipcode | mobilenumber |
      |   |  | Mr | Zetan123#$ | 10 | January | 1990 |  |  | Flat 105 | London | United States | Texas | Austin | 98501 | |
      |   |  | Mrs | Zetan123#$ | 15 | February | 1995 |  |  | Flat 105 | London | Israel | Texas | Austin | 98501 | |
      |   |  | Mr | Zetan123#$ | 31  | March | 1997 |  |  | Flat 105 | London | Canada | Texas | Austin | 98501 | |
