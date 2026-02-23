package com.myproject.hooks

import io.cucumber.java.After
import io.cucumber.java.Scenario
import io.qameta.allure.Allure

class AllureHooks {

    @After
    fun afterScenario(scenario: Scenario) {
        Allure.addAttachment(
            "Scenario Log",
            "text/plain",
            "Scenario: ${scenario.name} | Status: ${scenario.status}"
                .byteInputStream(),
            ".txt"
        )
    }
}