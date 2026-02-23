package runner

import org.junit.platform.suite.api.*

import io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME
import io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.myproject")
@ConfigurationParameter(
    key = PLUGIN_PROPERTY_NAME,
    value = "pretty, io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm, com.myproject.plugin.screenshotplugin"
)
class RunnerTest