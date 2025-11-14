package hooks

import io.cucumber.java.After
import io.cucumber.java.Scenario
import io.qameta.allure.Allure
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import com.myproject.base.DriverManager


class AllureHooks {

    @After
    fun afterScenario(scenario: Scenario) {

        val driver = DriverManager.getDriver()

        if (scenario.isFailed) {
            attachScreenshot(driver)
            attachPageSource(driver)
        }

        attachLog("Scenario finished: ${scenario.name}")
    }

    private fun attachScreenshot(driver: org.openqa.selenium.WebDriver) {
        try {
            val screenshotBytes = (driver as TakesScreenshot)
                .getScreenshotAs(OutputType.BYTES)

            Allure.addAttachment(
                "Screenshot",
                "image/png",
                screenshotBytes.inputStream(),
                ".png"
            )
        } catch (e: Exception) {
            Allure.addAttachment(
                "Screenshot Error",
                "text/plain",
                e.message?.byteInputStream(),
                ".txt"
            )
        }
    }

    private fun attachPageSource(driver: org.openqa.selenium.WebDriver) {
        try {
            Allure.addAttachment(
                "Page Source",
                "text/html",
                driver.pageSource.byteInputStream(),
                ".html"
            )
        } catch (e: Exception) {
            Allure.addAttachment(
                "Page Source Error",
                "text/plain",
                e.message?.byteInputStream(),
                ".txt"
            )
        }
    }

    private fun attachLog(message: String) {
        Allure.addAttachment(
            "Log",
            "text/plain",
            message.byteInputStream(),
            ".txt"
        )
    }
}
