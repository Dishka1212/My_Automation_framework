package com.myproject.base

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import java.time.Duration

object DriverManager {

    private val threadLocalDriver = ThreadLocal<WebDriver>()

    fun getDriver(): WebDriver {
        return threadLocalDriver.get()
            ?: throw IllegalStateException("Driver is not initialized! Call initDriver() first.")
    }

    fun initDriver() {

        val browser = ConfigReader.getProperty("BROWSER").lowercase() ?: "chrome"
        val headless = ConfigReader.getProperty("HEADLESS").toBoolean() ?: false
        val timeout = ConfigReader.getProperty("TIMEOUT_SECONDS").toLongOrNull() ?: 10

        val driverInstance: WebDriver = when (browser) {

            "chrome" -> {
                WebDriverManager.chromedriver().setup()
                val options = ChromeOptions()
                if (headless) {
                    options.addArguments("--headless=new")
                }
                ChromeDriver(options)
            }

            "firefox" -> {
                WebDriverManager.firefoxdriver().setup()
                val options = FirefoxOptions()
                if (headless) {
                    options.addArguments("-headless")
                }
                FirefoxDriver(options)
            }

            else -> throw IllegalArgumentException("Unsupported browser: $browser")
        }

        driverInstance.manage()
            .timeouts()
            .implicitlyWait(Duration.ofSeconds(timeout))

        driverInstance.manage().window().maximize()

        threadLocalDriver.set(driverInstance)
    }

    fun quitDriver() {
        getDriver().quit()
        threadLocalDriver.remove()
    }
}

