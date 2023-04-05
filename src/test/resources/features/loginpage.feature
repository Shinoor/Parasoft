Feature: Login Functionality for ParaBank Application

  As a user of ParaBank website
  I want to be able to log in with my account
  So that I can access my account -related features and open  a new account

  Background:
    Given I am on the ParaBank login page

    Scenario:  Successful login with valid credentials
      Given  I have entered a valid username and password
      When I click on the login button
      Then  I should be logged in successfully

    Scenario Outline: Login with invalid or empty credentials
      Given  I have entered invalid "<username>" and "<password">
      When I click on the login button
      Then I should see an error message indicating "<error_message>"

      Examples:
        | username        | password        | error_message
        | InvalidName.com | InvalidPassword | An internal error has occurred and has been logged.
        | abcd-bbbg       | validPassword   | An internal error has occurred and has been logged.
        | validName       | abgtfre         | An internal error has occurred and has been logged.

    Scenario: Navigate to the forgotten password page
      When  I click on the "forgot login info" link
      Then  I should be redirected to the Customer lookup page

