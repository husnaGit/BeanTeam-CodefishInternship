@regression
Feature: Testing the login positive and negative functionalities

  Scenario: Validating the successful login for OpenMRS

    Given User navigates to the OpenMrs website
    When User provides credentials and location '<location>'
    Then User validates title 'Home' and 'https://demo.openmrs.org/openmrs/referenceapplication/home.page'

  Scenario Outline:  Validating the negative login for OpenMrs

    Given User navigates to the OpenMrs website
    When User provides credentials '<username>','<password>' and location '<location>'
    Then User validates the error message 'Invalid username/password. Please try again.'

    Examples:
      | username | password | location          |
      |          |          | Inpatient Ward    |
      |          |          | Isolation Ward    |
      |          |          | Laboratory        |
      |          |          | Outpatient Clinic |
      |          |          | Pharmacy          |