package com.example.runner // Adjust package name as necessary

import io.cucumber.junit.platform.engine.Cucumber
import io.cucumber.junit.platform.engine.CucumberOptions
import org.junit.platform.suite.api.ConfigurationParameter

// This annotation tells JUnit 5 to use the Cucumber engine to run tests
@Cucumber
@CucumberOptions(
    // Defines where the .feature files are located
    features = ["src/test/resources/features"],

    // Defines where the Kotlin code (Step Definitions and Hooks) are located
    glue = ["com.example.stepdefs", "com.example.hooks"],

    // Defines the format for reports
    plugin = ["pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"]
)
class TestRunner