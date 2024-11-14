Feature: Test Account Creation
  As a new customer,
  I want to create a new account on the platform.

  Scenario: Successfully create an account with valid details
    Given I am on Create New Customer Account page
    When  I enter a valid First Name ''
    And   I enter a valid Last Name ''
    And   I enter a valid Email ''
    And   I enter a valid Password ''
    And   I confirm a valid Password ''
    And   I click on Create An Account icon
    Then  I should be able to successfully create an account and redirected to My Account page
    And   I should see a message 'Thank you for registering with Main Website Store.'


  Scenario: Failed to create an account with existing Email
    Given I am on Create New Customer Account page
    When  I enter a valid First Name 'Jack'
    And   I enter a valid Last Name 'Harper'
    And   I enter a valid Email 'greghouse_testdummy@gmail.com'
    And   I enter a valid Password 'JackHar123@'
    And   I confirm a valid Password 'JackHar123@'
    And   I click on Create An Account icon
    Then  I should be not be able to create an account
    And   I should see an existing email error message 'There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.'


  Scenario Outline: Failed to create an account with missing required fields
    Given I am on Create New Customer Account page
    When  I enter a valid First Name '<First Name>'
    And   I enter a valid Last Name '<Last Name>'
    And   I enter a valid Email '<Email>'
    And   I enter a valid Password '<Password>'
    And   I confirm a valid Password '<Confirm Password>'
    And   I click on Create An Account icon
    Then  I should be not be able to create an account
    And   I should see a missing field error message 'This is a required field.' under '<Missing Field>'

    Examples:
      | First Name | Last Name | Email                          | Password       | Confirm Password | Missing Field    |
      | null       | Harper    | jackharper_testdummy@gmail.com | jackharper123@ | jackharper123@   | First Name       |
      | Jack       | null      | jackharper_testdummy@gmail.com | jackharper123@ | jackharper123@   | Last Name        |
      | Jack       | Harper    | null                           | jackharper123@ | jackharper123@   | Email            |
      | Jack       | Harper    | jackharper_testdummy@gmail.com | null           | jackharper123@   | Password         |
      | Jack       | Harper    | jackharper_testdummy@gmail.com | jackharper123@ | null             | Confirm Password |


  Scenario: Fail to create an account with a password mismatch
    Given I am on Create New Customer Account page
    When  I enter a valid First Name 'Jack'
    And   I enter a valid Last Name 'Harper'
    And   I enter a valid Email 'jackharper_testdummy@gmail.com'
    And   I enter a valid Password 'jachar123@'
    And   I confirm a valid Password 'asdlkj123@'
    And   I click on Create An Account icon
    Then  I should be not be able to create an account
    And   I should see a mismatch password error message 'Please enter the same value again.'


  Scenario: Fail to create an account when password length is less than 8
    Given I am on Create New Customer Account page
    When  I enter a valid First Name 'Jack'
    And   I enter a valid Last Name 'Harper'
    And   I enter a valid Email 'jackharper_testdummy@gmail.com'
    And   I enter a valid Password 'che12@'
    And   I confirm a valid Password 'che12@'
    And   I click on Create An Account icon
    Then  I should be not be able to create an account
    And   I should see a password length error message 'Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.'


  Scenario Outline: Fail to create an account when password does not satisfy combination condition
    Given I am on Create New Customer Account page
    When  I enter a valid First Name 'Jack'
    And   I enter a valid Last Name 'Harper'
    And   I enter a valid Email 'jackharper_temmy@gmail.com'
    And   I enter a valid Password '<pass>'
    And   I confirm a valid Password '<pass>'
    And   I click on Create An Account icon
    Then  I should be not be able to create an account
    And   I should see a unsatisfy password condition error message 'Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.'

    Examples:
      | pass     |
      | SSSSDDDD |
      | ssssdddd |
      | 12345678 |
      | @@@@#### |
