package com.myproject.plugin

import io.cucumber.plugin.ConcurrentEventListener
import io.cucumber.plugin.event.EventPublisher
import io.cucumber.plugin.event.TestStepFinished
import io.qameta.allure.Allure
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import com.myproject.base.DriverManager

class screenshotplugin : ConcurrentEventListener {

    override fun setEventPublisher(publisher: EventPublisher) {

        publisher.registerHandlerFor(TestStepFinished::class.java) {

            val driver = try {
                DriverManager.getDriver()
            } catch (e: Exception) {
                null
            }

            if (driver != null) {

                val screenshot =
                    (driver as TakesScreenshot)
                        .getScreenshotAs(OutputType.BYTES)

                Allure.getLifecycle().addAttachment(
                    "Screenshot",
                    "image/png",
                    "png",
                    screenshot.inputStream()
                )
            }
        }
    }
}