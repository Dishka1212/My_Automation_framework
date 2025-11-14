// File path: src/test/kotlin/base/DriverManager.kt
package base

import org.openqa.selenium.WebDriver
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit

object DriverManager {

    // ThreadLocal is used to make sure each running test thread gets its own WebDriver instance
    private val threadLocalDriver: ThreadLocal<WebDriver> = ThreadLocal()

    // Easy way to get the current thread's driver instance
    val driver: WebDriver
        get() = threadLocalDriver.get()

    fun initDriver(browserName: String = "chrome") {
        // ... WebDriverManager setup logic remains the same

        val driver = ChromeDriver()

        // Read timeout value from ConfigReader
        val timeout = ConfigReader.getProperty("TIMEOUT_SECONDS").toLong() // <-- READ FROM CONFIG

        // Set implicit wait using the configured value
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS) // <-- USING CONFIG VALUE
        driver.manage().window().maximize()

        threadLocalDriver.set(driver)
    }

    fun quitDriver() {
        driver.quit()
        threadLocalDriver.remove()
    }
}