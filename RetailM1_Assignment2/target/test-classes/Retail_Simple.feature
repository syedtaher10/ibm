@Assignment02_Syed
Feature: Retail_M1 Registration

  @Scenario1
  Scenario: To verify whether application allows the user to get registered  by entering valid credentials in required fields
    Given Launch retailm1 website
    When Account icon is displayed
    Then click on Account icon
    Then click on LoginRegister link
    Then click on Register button
    When Registration form is displayed
    Then Fill up the Form
      | FirstName | manzoor           |
      | LastName  | mehadi            |
      | Email     | manzoor@gmail.com |
      | Telephone |        9876543210 |
      | Address1  | yeshwanthapur     |
      | Address2  | bangalore         |
      | City      | bangalore         |
      | PostCode  |            560022 |
      | Country   | India             |
      | State     | Karnataka         |
      | Pass      | manzoor1          |
      | ConfPass  | manzoor1          |
    And click on no in Subscribe
    And click on agree policy
    And Click on the Continue Button
    When verify Success message "Congratulations! Your new account has been successfully created!"
    Then close browser

  @Scenario2
  Scenario: To verify whether application allows user to get logged in by entering valid credentials in required field
    Given Launch retailm1 website
    Then click on Account icon
    And Login Retail Portal
    And click on Login link
    When Verify Header "My Account"
    Then close browser