# 💻 ASTROJINI UI & API Test Automation

Automated end-to-end test suite for the **Astrojini.com** astrology web platform by **Abhishek Dhole**.
This framework validates user flows such as **Login**, **Logout**, **Edit Profile**, and **Rashifal Check**, using Selenium, TestNG, POM, RestAssured.

The framework includes **HTML reporting**, **screenshot capturing**, and planned **CI/CD integration with GitHub Actions**.

---

## 🧰 Tech Stack

| Tool / Library | Purpose |
| -------------- | -------- |
| ![Java](https://img.shields.io/badge/Java-17%2B-orange?logo=java&logoColor=white) | Programming Language |
| ![Selenium](https://img.shields.io/badge/Selenium-WebDriver-green?logo=selenium&logoColor=white) | Browser Automation |
| ![RestAssured](https://img.shields.io/badge/RestAssured-API%20Testing-blue) | API Testing |
| ![TestNG](https://img.shields.io/badge/TestNG-Framework-brightgreen) | Test Runner & Assertions |
| ![Maven](https://img.shields.io/badge/Maven-Build%20%26%20Dependency-red?logo=apache-maven&logoColor=white) | Build & Dependency Management |
| ![WebDriverManager](https://img.shields.io/badge/WebDriverManager-Driver%20Setup-lightgrey) | Auto Driver Setup |
| ![GitHub Actions](https://img.shields.io/badge/GitHub-Actions-blue?logo=githubactions&logoColor=white) | CI/CD Integration |
| ![POM](https://img.shields.io/badge/Design-Page%20Object%20Model-purple) | Clean Code Structure |
| ![ExtentReports](https://img.shields.io/badge/Reports-ExtentReports-orange) | HTML Reporting |


---

## 📂 Project Structure

```
astrojini-automation/
├── src
│   ├── main/java
│   │   ├── pages/                 # Page Object classes
│   │   ├── utils/                 # DriverManager, Helper, ConfigReader
│   │   └── base/                  # BaseTest classes
│   └── test/java
│       ├── ui/                   # Selenium test cases
│       ├── resource              # properties file
│       └── screenshots           # Cucumber step defs                     
├── testng.xml                    # TestNG suite file
├── pom.xml                       # Maven config
└── README.md                     # Project info
```

---

## 🧪 Test Coverage

| Test Case Description               | Tags            | Result   |
| ----------------------------------- | ---------       | -------  |
| Login with valid credentials        | @Login          | ✅ Pass |
| Login with invalid credentials      | @Login          | ✅ Pass |
| Register with valid & invalid       | @Registration   | ✅ Pass |
| Edit Profile                        | @EditProfile    | ✅ Pass |
| Rashifal check for all zodiac signs | @Rashifal       | ✅ Pass |
| API: Get daily rashifal JSON        | @API            | ✅ Pass |

---

## 💡 Framework Highlights

### 📌 Singleton WebDriver Manager

Ensures a single driver instance is shared and reused using thread-safe Singleton pattern.

### 📦 Page Object Model

Each UI page interaction is modeled as a class. Improves readability, reusability, and maintainability.

### 🧠 Utilities & Helpers

Smart waits, element clickers, screenshot capture, and reusable logic are abstracted inside `Helper.java`.

### 🖼️ Screenshot on Failure

Screenshots are captured on every test failure and embedded into the final HTML report.

### ⚙️ CI Integration (Planned)

CI runs will be triggered on every push to `main` branch via GitHub Actions with headless browser testing.

---

## ▶️ Running the Tests

### ✅ Locally

```bash
git clone https://github.com/Dholeabhishek/Astrojini.git
```
```bash
cd Astrojini
```
```bash
mvn clean test
```

### ✅ CI via GitHub Actions

* Headless Chrome execution
* Report + screenshot artifacts saved in CI run

---

## 👨‍💻 Author

**Abhishek Dhole** – QA Automation Engineer  

[![Gmail](https://img.shields.io/badge/Email-dholeabhishek9%40gmail.com-red?logo=gmail&logoColor=white)](mailto:dholeabhishek9@gmail.com)

[![GitHub](https://img.shields.io/badge/GitHub-Dholeabhishek-black?logo=github)](https://github.com/Dholeabhishek)

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Abhishek%20Dhole-blue?logo=linkedin)](https://www.linkedin.com/in/abhishek-dhole-723001129/) 

---

