# heroku-automation
# Author - Ankit Kothiyal
The utility automates the below Test Cases using mentioned Tech Stack.
A robust, scalable Selenium + TestNG framework designed to automate and validate functionalities on [Heroku Test Site](https://the-internet.herokuapp.com/), with cloud execution support via **LambdaTest**.

---

## Thought Process & Design Decisions

### Modular Architecture
- Built on **Page Object Model (POM)** to separate page actions from test logic
- Promotes **reusability, maintainability, scalability**

### Cloud-Ready
- Integrated with **LambdaTest's Selenium Grid**
- Run tests cross-browser/platform without infrastructure setup
- Test credentials are injected using **secure environment variables**4

###  Real-world Features
- **Parallel test execution** via `testng.xml`
- **Retry failed test cases** using TestNG's `IRetryAnalyzer`
- **Interactive HTML reports** via ExtentReports
- **No hardcoded credentials** — all sensitive data is managed via `config.properties` or ENV variables
- Clean structure with `utils`, `pages`, `tests`, and config separation

---

## 🌐 Cloud Execution (LambdaTest)

### 🔐 Secure Credentials
Environment variables required(Below is for Windows):
set LT_USERNAME=your_lambdatest_username
set LT_ACCESS_KEY=your_lambdatest_access_key

## Tech Stack
| Layer            | Tool / Library         |
|------------------|------------------------|
| Language         | Java 11+               |
| Test Framework   | TestNG                 |
| Automation Tool  | Selenium WebDriver 4   |
| Build Tool       | Maven                  |
| Cloud Grid       | LambdaTest             |
| Dependency Mgmt  | WebDriverManager       |
| Retry Logic      | Custom Retry Analyzer  |

## Test Cases
### 1. Login Page
- Valid credentials (assert success) - Read creds from config
- Invalid credentials (assert error)

### 2. JavaScript Alerts
- Handle JS Alert, Confirm, and Prompt

## Cloud Execution
Tests run on **LambdaTest**

| Test | LambdaTest ID |
|------|---------------|
| Login - Valid | `8GVU8-XOOEM-9GPI0-VCBVN` |
| Login - Invalid | `TLXKH-VQBXW-HHSDJ-RHNA4` |
| JS Alert | `X5FNE-RQK9V-TUOOQ-JVUPR` |
| JS Confirm | `SMZTU-B6HHG-FJYM3-SMTR2` |
| JS Prompt | `YOYJW-W5XC2-KLHLI-1ODLM` |

## How to Run
### Locally
Execute testng.xml  / mvn clean test

### Run on LambdaTest
Set Environment Variables LT_USERNAME and LT_ACCESS_KEY
Execute testng.xml  / mvn clean test


### Reports
| Type | Location |
|------|---------------|
TestNG Reports|	test-output/index.html

