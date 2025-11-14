package com.myproject.base

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import io.github.bonigarcia.wdm.WebDriverManager
import java.time.Duration

object DriverManager {

    private val threadLocalDriver = ThreadLocal<WebDriver>()

    fun getDriver(): WebDriver {
        return threadLocalDriver.get()
            ?: throw IllegalStateException("Driver is not initialized! Call initDriver() first.")
    }

    fun initDriver() {
        // Setup browser
        WebDriverManager.chromedriver().setup()

        // Create driver instance
        val driverInstance = ChromeDriver()

        // Read timeout from config
        val timeout = ConfigReader.getProperty("TIMEOUT_SECONDS").toLong()

        // Add implicit wait
        driverInstance.manage()
            .timeouts()
            .implicitlyWait(Duration.ofSeconds(timeout))

        driverInstance.manage().window().maximize()

        // Store driver in ThreadLocal
        threadLocalDriver.set(driverInstance)
    }

    fun quitDriver() {
        getDriver().quit()
        threadLocalDriver.remove()
    }
}

