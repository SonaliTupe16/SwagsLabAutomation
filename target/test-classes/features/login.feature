Feature: Login functionality

  Scenario Outline: 
    Verify homepage loads after successful login
    Given user is on the login page
    When user enters username "<username>" and password "<password>"
    And clicks on the login button
    Then homepage should be displayed

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |