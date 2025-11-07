# 🚀 Vaadin + Spring + Gradle Minimal Template

A clean, modern starting point for building **Vaadin Flow** applications with **Spring Boot** and **Gradle**. Designed to help developers bootstrap production-ready apps quickly and confidently.

---

## ✨ Features

* 🧱 **Gradle Wrapper** — works seamlessly on macOS, Linux, and Windows
* 📦 **Version Catalog** — centralized dependency management
* ☕ **Java 25** — latest LTS with enhanced performance and language features
* 💎 **Vaadin 25** — Flow-based UI framework for modern web apps
* 🌿 **Spring Boot 4** — production-ready application foundation
* 🧪 **JUnit Jupiter + Playwright** — modern test setup for UI and backend
* 📊 **JaCoCo Coverage Reports** — with configurable thresholds
* 🎯 **Spotless Formatting** — consistent code style across contributors
* 🤖 **GitHub Actions CI/CD** — automated PR validation and checks

> This template contains **no business logic**, just a project structure with an example view and a minimal Playwright test.

---

## ⚙️ Usage

### Build and Test

~~~bash
./gradlew build      # Compile + test + package
./gradlew test       # Run all tests
./gradlew check      # Run format check + tests + coverage
~~~

### Run and Package

~~~bash
./gradlew bootRun         # Run in development mode
./gradlew bootJar         # Build production JAR
./gradlew bootBuildImage  # Build Docker image
~~~

---

## 🧹 Formatting & Quality

~~~bash
./gradlew spotlessCheck   # Verify code formatting
./gradlew spotlessApply   # Automatically fix formatting
~~~

Coverage reports are generated automatically after running tests. Failing the coverage threshold will cause build failure.

---

## 🧠 Notes

* `bootRun` → runs in **development** mode (hot reload, dev resources)
* `bootJar` / `bootBuildImage` → build in **production** mode (optimized resources)
* Designed for easy integration into CI/CD pipelines (GitHub Actions included)

---

## 🧩 Project Structure

~~~
/
├── .github/workflows        # GitHub Actions workflows
├── gradle/                  # Wrapper & Version Catalog
├── src/
│   ├── main/java/...        # Java source code
│   ├── main/resources/...   # Resources (e.g. properties)
│   └── test/java/...        # JUnit + Playwright tests
├── build.gradle.kts         # Project build script
├── settings.gradle.kts      # Project settings
├── gradle.properties        # Project key=value properties (override with `-Pkey=value`)
└── README.md                # This file 😄
~~~

---

## 🚦 Quick Start

1. Clone this repository
2. Run `./gradlew bootRun`
3. Open [http://localhost:8080](http://localhost:8080)

---

## 🧩 Tech Stack

| Component     | Version | Description           |
|---------------|---------|-----------------------|
| Java          | 25      | Language & runtime    |
| Vaadin        | 25      | UI framework          |
| Spring Boot   | 4       | Application framework |
| Gradle        | 9       | Build tool            |
| JUnit Jupiter | 6       | Testing framework     |
| Playwright    | latest  | UI testing            |
| Spotless      | latest  | Code formatting       |
| JaCoCo        | latest  | Coverage analysis     |

---

## 🤝 Contributing

Contributions, improvements, and feedback are welcome! Open a PR or an issue — let’s make this template even better for the Vaadin community.

---

## 🧾 License

This template is distributed under the **Apache License 2.0**.
