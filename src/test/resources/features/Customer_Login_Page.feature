Feature: Test Customer Sign In
  As a customer,
  I want to sign in into the Magento platform.

  Scenario : Test Login with Valid credentials
    Given I am on Customer Login page
    When  I enter an Email 'greghouse_testdummy@gmail.com'
    And   I enter the Password 'greghouse@123'
    And   I click on Sign In
    Then  I am successfully signed in my account
    And   I am redirected to My Account page


  Scenario: Test Login with Incorrect password
    Given I am on Customer Login page
    When  I enter an Email 'greghouse_testdummy@gmail.com'
    And   I enter the Password 'IncorrectPass'
    And   I click on Sign In
    Then  I should see an error message 'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.'


  Scenario: Test Login with empty email
    Given I am on Customer Login page
    When  I enter an Email ''
    And   I enter the Password 'greghouse@123'
    And   I click on Sign In
    Then  I should see an error message below Email 'This is a required field.'.


  Scenario: Test Login with empty password
    Given I am on Customer Login page
    When  I enter an Email 'greghouse_testdummy@gmail.com'
    And   I enter the Password ''
    And   I click on Sign In
     Then  I should see an error message below Password 'This is a required field.'.


  Scenario: Test 'Create An Account' through Customer Login Page
    Given I am on Customer Login page
    When  I click on Create An Account
    Then  I should be redirected to Create New Customer Account page


