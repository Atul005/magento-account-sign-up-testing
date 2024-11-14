Feature: Test My Account Page
  As a customer, I want to sign in and sign out of my account


  Scenario: Test Sign out from My Account Page
    Given I am on Customer Login Page
    When  I enter a valid 'greghouse_testdummy@gmail.com' and 'greghouse@123'
    Then  I should be redirected to My Account Page
    When  I click on User Action Button menu
    And   I click on Sign Out option
    Then  I should be able to sign out of My Account