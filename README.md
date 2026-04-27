# Selenium Automation Framework

A robust end-to-end test automation framework built with **Java**, **Selenium WebDriver**, **TestNG**, and **Maven**, following the **Page Object Model (POM)** design pattern.

## 🔧 Tech Stack
- Java 25
- Selenium WebDriver 4.18.1
- TestNG 7.9.0
- Maven 3.9.15
- WebDriverManager 5.7.0
- ExtentReports 5.1.1

## 🏗️ Framework Architecture

selenium-automation-framework/
├── src/test/java/com/saucedemo/
│   ├── BaseTest.java          # Browser setup & teardown
│   ├── ExtentReportManager.java # HTML report configuration
│   ├── pages/
│   │   ├── LoginPage.java     # Login page elements & actions
│   │   ├── InventoryPage.java # Products page elements & actions
│   │   ├── CartPage.java      # Cart page elements & actions
│   │   └── CheckoutPage.java  # Checkout page elements & actions
│   └── tests/
│       ├── LoginTest.java         # Login test scenarios
│       └── CartAndCheckoutTest.java # Cart & checkout test scenarios
├── testng.xml    # Test suite configuration
└── pom.xml       # Maven dependencies

## ✅ Test Coverage

### Login Tests
| Test | Description |
|------|-------------|
| validLoginTest | Verifies successful login with valid credentials |
| invalidLoginTest | Verifies error message with invalid credentials |
| emptyCredentialsTest | Verifies error message with empty fields |

### Cart & Checkout Tests
| Test | Description |
|------|-------------|
| addItemToCartTest | Verifies item is added to cart with correct badge count |
| completeCheckoutTest | Verifies full end-to-end purchase flow |

## 📊 Test Reports
After running, an HTML report is generated at `reports/TestReport.html` using ExtentReports with dark theme, timestamps, and pass/fail status for each test.

## 🚀 How to Run

### Prerequisites
- Java JDK installed
- Maven installed
- Chrome browser installed

### Run all tests
```bash
mvn clean test
```

### Run specific test class
```bash
mvn clean test -Dtest=LoginTest
```

## 🎯 Key Concepts Implemented
- **Page Object Model (POM)** — Each page has its own class with elements and actions
- **PageFactory** — Clean element initialization using @FindBy annotations
- **WebDriverManager** — Automatic ChromeDriver management
- **TestNG Annotations** — @BeforeMethod, @AfterMethod, @BeforeSuite, @AfterSuite
- **Extent Reports** — Professional HTML test reporting
- **Inheritance** — LoginTest and CartAndCheckoutTest extend BaseTest
- **Singleton Pattern** — Used in ExtentReportManager