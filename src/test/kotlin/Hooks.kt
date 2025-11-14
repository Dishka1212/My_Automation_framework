// File path: src/test/kotlin/hooks/Hooks.kt
package hooks

import io.cucumber.java.After
import io.cucumber.java.Before
import base.DriverManager // Import the DriverManager we created earlier

class Hooks {

    @Before
    fun setup() {
        val browser = ConfigReader.getProperty("BROWSER") // <-- READ FROM CONFIG

        DriverManager.initDriver(browser)
    }

    @After
    fun teardown() {

        DriverManager.quitDriver()

    }
}
}