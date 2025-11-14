plugins {
    kotlin("jvm") version "1.9.23"
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

repositories {
    mavenCentral()
}

dependencies {

    // Cucumber
    testImplementation("io.cucumber:cucumber-java:7.14.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.14.0")
    testImplementation("io.cucumber:cucumber-core:7.14.0")

    // JUnit Platform Suite (Required for @Suite)
    testImplementation("org.junit.platform:junit-platform-suite:1.10.2")

// Allure for Cucumber + JUnit5
    testImplementation("io.qameta.allure:allure-java-commons:2.24.0")
    testImplementation("io.qameta.allure:allure-junit5:2.24.0")
    testImplementation("io.qameta.allure:allure-cucumber7-jvm:2.24.0")

    // Selenium
    testImplementation("org.seleniumhq.selenium:selenium-java:4.23.0")

    // WebDriverManager
    testImplementation("io.github.bonigarcia:webdrivermanager:5.9.2")

    // JUnit
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.2")

    // Kotlin test
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

allure {
    version.set("2.24.0")

    adapter {
        allureJavaVersion.set("2.24.0")

        frameworks {
            junit5 {
                // Allure adapter for JUnit5
                adapterVersion.set("2.24.0")
            }
            cucumberJvm {
                // Allure adapter for Cucumber JVM
                adapterVersion.set("2.24.0")
            }
        }
    }
}

