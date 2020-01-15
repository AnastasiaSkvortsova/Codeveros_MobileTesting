Feature: Account Registration

      As a user of Codeveros web app
      I want to create login credentials
      In order to access my online account

Scenario Outline: Register button stays inactive  with invalid fields error
      Given a web browser is at the Codeveros registration page
      When user enters "<firstName>" as a First Name
      And user enters "<lastName>" as a Second Name
      And user enters "<userName>" as a Username
      And user enters "<email>" as a Email Address
      And user enters "<password>" as a Password
      And user enters "<confirmPassword>" as a Confirm Password
      Then the Register button stays inactive
      Examples:
            |firstName    |lastName     |userName     |email               |password      |confirmPassword|
            |             |             |             |                    |              |               |
            |             |myLastName   |myUserName   |myEmail@gmal.com    |myP           |myP            |
            |myFirstName  |             |myUserName   |myEmail@gmal.com    |myP           |myP            |
            |myFirstName  |myLastName   |             |myEmail@gmal.com    |myP           |myP            |
            |myFirstName  |myLastName   |myUserName   |                    |myP           |myP            |
            |myFirstName  |myLastName   |myUserName   |myEmail@gmal.com    |              |myP            |
            |myFirstName  |myLastName   |myUserName   |myEmail@gmal.com    |myP           |               |
            |myFirstName  |myLastName   |myUserName   |myEmail             |myP           |myP            |
            |myFirstName  |myLastName   |myUserName   |myEmail@gmai.       |myP           |myP            |
            |myFirstName  |myLastName   |myUserName   |myEmailgmail.com    |myP           |myP            |
            |myFirstName  |myLastName   |myUserName   |myEmail@gmailcom    |myP           |myP            |
            |myFirstName  |myLastName   |myUserName   |myEmail@gmail..com  |myP           |myP            |
            |myFirstName  |myLastName   |myUserName   |myEmail@.com        |myP           |myP            |
            |myFirstName  |myLastName   |myUserName   |myEmail@gmal.com    |myP1          |myP            |

Scenario: Successful Registration
      Given a web browser is at the Codeveros registration page
      When user enters "myFirstName" as a First Name
      And user enters "myLastName" as a Second Name
      And user enters unique Username
      And user enters "myUniqueEmail@gmal.com" as a Email Address
      And user enters "myP" as a Password
      And user enters "myP" as a Confirm Password
      And user click Register button
      Then Codeveros welcome page is shown
