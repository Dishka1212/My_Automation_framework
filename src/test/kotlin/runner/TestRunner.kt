package com.myproject.runner

import org.junit.platform.suite.api.Suite
import org.junit.platform.suite.api.IncludeEngines
import org.junit.platform.suite.api.SelectClasspathResource
import org.junit.platform.suite.api.ConfigurationParameter
import io.cucumber.junit.platform.engine.Constants
import io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(
    key = Constants.GLUE_PROPERTY_NAME,
    value = "com.myproject.stepdefs,com.myproject.hooks"
)
@ConfigurationParameter(
    key = PLUGIN_PROPERTY_NAME,
    value = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
)
@ConfigurationParameter(
    key = Constants.PLUGIN_PROPERTY_NAME,
    value = "pretty, html:build/reports/cucumber.html"
)
class TestRunner
