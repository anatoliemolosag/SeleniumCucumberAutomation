Feature: Login functionality

  Scenario: Login error
    Given user navigates to 'https://otc.coinflip.tech/login'
    When user inputs invalid credentials
    Then user receives an error message 'Unable to find email and password'

