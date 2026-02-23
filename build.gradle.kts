plugins {
    kotlin("jvm") version "1.9.22"
    java
}

group = "com.myproject"
version = "1.0.0"

repositories {
    mavenCentral()
}

/* === Read versions from gradle.properties === */

val cucumberVersion: String by project
val allureVersion: String by project
val seleniumVersion: String by project
val webdrivermanagerVersion: String by project
val junitPlatformVersion: String by project
val slf4jVersion: String by project
val logbackVersion: String by project
val junitJupiterVersion: String by project

dependencies {

    // Kotlin
    implementation(kotlin("stdlib"))

    // Selenium
    implementation("org.seleniumhq.selenium:selenium-java:$seleniumVersion")

    // WebDriverManager
    implementation("io.github.bonigarcia:webdrivermanager:$webdrivermanagerVersion")

    // Cucumber
    testImplementation("io.cucumber:cucumber-java:$cucumberVersion")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:$cucumberVersion")

    // Allure
    testImplementation("io.qameta.allure:allure-cucumber7-jvm:$allureVersion")

    // JUnit Platform Suite
    testImplementation("org.junit.platform:junit-platform-suite:$junitPlatformVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitJupiterVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitJupiterVersion}")


    // Logging
    testImplementation("org.slf4j:slf4j-api:$slf4jVersion")
    testImplementation("ch.qos.logback:logback-classic:$logbackVersion")
}

tasks.test {
    useJUnitPlatform()
}