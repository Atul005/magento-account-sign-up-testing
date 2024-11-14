Feature: Test the Sign up flow.
  As a customer,
  I am to test Sign up and Sign In flow of the Magento platform.

  Scenario: Create a new account
    Given I am on Home Page
    When  I click on Create an Account link
    Then  I am redirected to Create New User Account page

  Scenario: Sign In in existing account
    Given I am on Home Page
    When  I click on SignIn link
    Then  I am redirected to Customer Login page