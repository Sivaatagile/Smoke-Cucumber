# Automation Testing Scripts for Mobile Application

This document explains how the automation testing scripts work, developed using Java, Selenium, Cucumber, TestNG, and Appium. The tests are executed in Eclipse IDE, with reports generated using Cucumber and Gherkin feature files.

## Key Components

- **Java**: For writing automation scripts.
- **Selenium**: For browser automation.
- **Cucumber**: For behavior-driven testing using Gherkin syntax.
- **TestNG**: For running tests.
- **Appium**: For mobile application testing.

## Prerequisites

** 1. Install Appium Server**
Install the latest Appium server globally via command line (cmd).

** 2. Install Eclipse IDE**
Download and install Eclipse IDE for Java development.

** 3. Import Project from GitHub**
Clone the project repository from GitHub and import it into Eclipse.

** 4. Install Android Studio**
Install Android Studio and configure an emulator. Ensure emulator details are specified in the `.properties` file within the project.

** 5. Install Appium Inspector**
Install Appium Inspector to inspect mobile elements for Appium tests.

## Script Setup and Execution

### APK Installation
If you are testing in an environment other than Staging or Automation Staging, follow these steps:

1. Get the **v8a APK**.
2. Manually drag and drop the APK into the emulator to complete installation.

**Step 1: Set API URL**

Navigate to `StepDefinition → Prerequests.java`.

Set the API URL in the `.properties` file using the `propertyfileLoaded()` function.

**Step 2: Handling APK Versions**

For **Staging** or **Automation Staging APK**:

- Put the build in GitHub Actions for staging environments.
- In the `Prerequests.java` file, open the application using `openApplication()` and specify the environment.

For **Already Installed APK**:

Use these commands:

```java
Latest_stagingapk_download();  
Application();  

Uncomment Openapplicationwithoutreset(); if necessary
```

** Step 3: Set Key Values**

After running the above steps, run the script to **Set Key Values**. This will modify values based on specific keys, handling duplicate values as mentioned in the scripts.

**Step 4: Dry Run Verification**

In the Cucumber Runner file, ensure the `dryRun` property is set to `true`.

Verify the feature file to ensure everything is correctly configured.

** Step 5: Feature File Management**

Study the feature file and identify the reusable steps.

To reuse a step, copy and paste the relevant lines into the feature file as per the requirement.

** Step 6: Running Tests and Reporting**

After running the scripts, refresh the project files and run the `reportprocess.java` file located at:

```bash
src/test/sendingreportagilecyber/reportprocess.java
```
**Step 7: Create a New Feature File**


To run an individual feature:

1. **Create a new .feature file**.
2. **Copy the required feature lines** from the original feature file.
3. **Paste them into the new file**.
4. Update the **Cucumber Runner file** with the new feature file location.

**Step 8: Set Up Dry Run**


To verify the feature file setup before executing:

1. Set `dryRun = true` in the Cucumber Runner file.
2. **Verify** that everything is correct.

**Step 9: Execute Tests**


Once verified, follow these steps to run the tests:

1. Set `dryRun = false` in the Cucumber Runner file.
2. Run the **Cucumber Runner file** using **TestNG**:

```bash
   src/test/com/cucumberrunner/Runnercucumber.java
```
3. Ensure that the dryRun flag is set appropriately based on whether you are testing or verifying the configuration.


## Features

- **Feature Files**: Contain test scenarios written in **Gherkin syntax** (Given-When-Then).
- **Step Definitions**: Maps each Gherkin step to a method in the `StepDefinition` class. The actual automation test logic is written in these methods.
- **Reporting**: Generates detailed reports with the status of each test scenario, including passed, failed, and skipped tests.

## Prerequisites

Before setting up and running the tests, ensure the following prerequisites are installed:

1. **Eclipse IDE** (with the necessary plugins like Cucumber and Appium).
2. **Maven**: Used for dependency management.
3. **Appium Server**: To run and manage mobile automation tests.
4. **Java**: Java Development Kit (JDK) should be installed.

## Setup and Configuration

**1. Clone the Repository**:

 ```bash
    git clone https://github.com/your-repo-url
 ```

**2. Install Dependencies**:

    Make sure that you have all the required dependencies by running:

 ```bash
    mvn clean install
 ```

**3. Configure Appium**:

    - Install Appium on your machine.
    - Make sure Appium is running before starting the tests.
    - Set up the emulator or real device as per your test requirements.

**4. Update API URLs**:  
   - Ensure the correct API URL is configured in the `Prerequests.java` file for API tests.

## Running the Tests

1. Open the project in **Eclipse**.
2. Run the tests using the Maven commands or directly from Eclipse:

   **Run Cucumber Tests**:
    - Right-click on the feature file or the test class in Eclipse and select **Run As > Cucumber Feature** or **JUnit Test**.

   **Run Maven Command**:
    - Use the following command to run the tests via Maven:

  ```bash
    mvn test
  ```
3. After running the tests, **Cucumber** will generate a detailed report showing the execution status of each test scenario (Passed, Failed, Skipped).

## Error Handling and Debugging

**Common Issues:**

1. **APK Not Installing**:  
    - Ensure that the correct APK version is being dragged into the emulator.
    - Verify the emulator configuration in the `.properties` file.
   
2. **API URL Misconfiguration**:  
    - Ensure the correct API URL is specified in the `Prerequests.java` file.

**Debugging:**

- Use **Appium Inspector** to inspect mobile elements if the test fails due to element identification issues.
- Check **Eclipse console logs** for detailed error messages and stack traces.

## Maintenance and Updates

** Adding New Tests:**
- To add new tests, create new **Gherkin feature files** and map them to the corresponding **Step Definition** methods.

** Updating Dependencies:**
- If dependencies or frameworks (e.g., **Selenium**, **Appium**) need updating, modify the `pom.xml` (if using **Maven**) or the equivalent dependency management configuration.

## Version Control

** Repository Information:**
- All automation testing scripts are maintained in **GitHub**. Ensure you have access to clone and push changes to the repository.

** Branching Strategy:**
- Follow the existing branching strategy for creating new feature branches, bug fixes, and updates.

## Reporting

Cucumber generates a detailed report after test execution that can be found in the `target/cucumber-reports/` directory. The report includes test results, such as:

- **Passed Tests**
- **Failed Tests**
- **Skipped Tests**

You can view these reports in your browser after the tests have been executed.

## Conclusion

This document provides comprehensive steps for setting up, running, and maintaining automation testing scripts. Ensure all prerequisites are properly installed and configured before executing the tests. In case of issues, refer to the **Error Handling** and **Debugging** sections above for troubleshooting.

For any further assistance, feel free to reach out to the team.

