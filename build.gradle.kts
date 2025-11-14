plugins {
    // Apply the Kotlin JVM plugin for standard JVM projects
    kotlin("jvm") version "1.9.22" // Use the latest stable Kotlin version
}

group = "com.example.automation"
version = "1.0-SNAPSHOT"

repositories {
    // Where Gradle looks for dependencies
    mavenCentral()
}

// Configuration for running tests
tasks.test {
    useJUnitPlatform()
}

dependencies {
    // --- Kotlin Core ---
    // Standard Kotlin Library
    implementation(kotlin("stdlib-jdk8"))

    // --- Selenium (Browser Automation) ---
    // Main Selenium Java library
    implementation("org.seleniumhq.selenium:selenium-java:4.15.0")

    // Automatically manages browser drivers (no manual download needed)
    implementation("io.github.bonigarcia:webdrivermanager:5.5.3")

    // --- Cucumber (BDD Layer) ---
    // Main Cucumber dependency for JVM (Kotlin integration)
    testImplementation("io.cucumber:cucumber-java:7.14.0")

    // JUnit 5 support for running Cucumber tests
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.14.0")

    // --- Test Runner & Assertions ---
    // Core JUnit 5 dependencies
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.1")

    // TestNG for running tests (optional, but a common choice)
    testImplementation("org.testng:testng:7.8.0")

    // --- Logging ---
    // Simple Logging Facade for Java (recommended for clean logging)
    implementation("org.slf4j:slf4j-simple:2.0.9")
}