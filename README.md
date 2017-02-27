*********************
All about Framework*
*********************

The framework which I built to automate sample application Computer Databaseis an hybrid framework.

***********
Features
***********

1. For most of the tests, we are using dynamic test data instead of static test data. Some of the random data generator methods are present in FrameworkUtilities class.
2. We will also provide test suite summary in the log file.
3. Each test is autonomic.
4. We can run our tests in parallel by setting up changes in testng.xml
5. Our web driver instance is thread-safe. Hence there would be no issues when we run tests in parallel.
6. We are using Page Object Model in selenium which is very easy to maintain the element changes.
7.This framework can be easily integrated with Jenkins for CI.
8. Tests and page classes are readable. Hence it provides more understandability and maintainability.
9. Tests are easily maintainable using testng.xml file


***************
Tests Coverage
***************
1. Launch application
2. Create new computer
3. Edit existing computer data
4. Delete existing computer data
5. Data validations
6. Search Functionality
7. Page Navigation.

*************************
Important Bugs Noticed
***********************

1. Application error displayed when maximum length given to computer name field while creation.
2. No validation for uniqueness of computer record.


**********************
How to trigger Tests
*********************

1. Install Java
2. Setup Maven
3. Download the project and go to home directory where you have pom.xml file
4. Open command prompt and go to the home directory where you have pom.xml file
5. If you want to run your tests against chrome, please download chrome driver from selenium portal and keep in the below path
D:\\selenium_drivers\\chrome\\chromedriver.exe
6. Give the below command to run the tests
mvn failsafe:integration-test
7. If we need to run only particular tests using testNG, then please update the testng.xml with reuqired tests only.
