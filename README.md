# MultibankGroup-Test
Automation Testing for Trade.Multibank.io
This repository contains a Selenium WebDriver + TestNG automation framework for testing the Trade.Multibank.io platform. The framework includes page objects, data-driven tests, and reusable utilities for web UI automation.


🏗️ Project Structure
src
├─ main
│ └─ java
│ └─ pages # Page Object Model (POM) classes
│ ├─ SignupPage.java
│ └─ LoginPage.java
├─ test
│ └─ java
│ └─ tests # Test classes
│ ├─ ValidSignupTest.java
│ ├─ InvalidSignupTest.java
│ └─ LoginTest.java
└─ utils
└─ ExcelReader.java # Utility for reading test data from Excel
└─ base
└─ BaseTest.java # WebDriver setup & teardown

Prerequisites
Java 11 or higher 
Maven 
Chrome Browser 
ChromeDriver (managed automatically with WebDriverManager) 
TestNG plugin for IntelliJ or other IDE

Test Data
Test data is maintained in Excel sheets (TestData.xlsx) for signup and login tests.
SignupData: Email, Password, Certify checkbox, Valid/Invalid 
LoginData: Email, Password, Valid/Invalid
The framework uses a data-driven approach, reading test data from Excel using the ExcelReader utility.

 How to Run Tests
Clone the repository:
git clone <your-repo-url> cd <your-repo-folder>
Open the project in IntelliJ IDEA or preferred IDE.
Run tests using TestNG:
From IDE: Right-click on test class → Run 
From Maven:
mvn clean test

 Features
Page Object Model (POM) for clean separation of page elements and actions 
Data-driven tests with Excel input for flexible test scenarios 
Tests included:
Valid Signup 
Invalid Signup 
Login (valid & invalid) 
Reusable BaseTest class for WebDriver setup & teardown 
Assertions for Next button enable/disable, login success/failure, and page navigation

Notes
Ensure the Excel sheets are updated with correct test data before running the tests. 
Update XPath locators in page objects if the web application changes. 
The framework is designed for Chrome, but can be extended to other browsers.

📂 Future Improvements
Add few more test cases
Add reporting with ExtentReports or Allure 
Add screenshot capture on test failure 
Implement cross-browser testing 
