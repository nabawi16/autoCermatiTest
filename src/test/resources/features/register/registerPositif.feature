@register_positif
Feature: Register

  Scenario: user create account successfull
    Given user alredy in web Cermati
    And user alredy on register page
    When user input new account with required field only
    And user click button register
    Then user successful register