// File path: src/test/kotlin/base/ConfigReader.kt
package base

import java.io.FileInputStream
import java.util.Properties

object ConfigReader {
    private val properties = Properties()

    init {
        // This block runs once when the object is first accessed
        try {
            // Load the properties file from the resources directory
            val inputStream = FileInputStream("src/test/resources/config.properties")
            properties.load(inputStream)
        } catch (e: Exception) {
            println("Error loading configuration file: ${e.message}")
            throw RuntimeException("Configuration file not found or failed to load.")
        }
    }

    // Public function to get a string value from the config
    fun getProperty(key: String): String {
        return properties.getProperty(key)
            ?: throw IllegalArgumentException("Configuration key '$key' not found.")
    }

    // Function to get the base URL
    fun getBaseUrl(): String {
        return getProperty("BASE_URL")
    }
}