package com.myproject.base

import java.util.*

object ConfigReader {

    private val properties = Properties()

    init {
        val inputStream = this::class.java.classLoader.getResourceAsStream("config.properties")
            ?: throw RuntimeException("config.properties not found in resources folder")

        properties.load(inputStream)
    }

    fun getProperty(key: String): String {
        return properties.getProperty(key)
            ?: throw RuntimeException("Property '$key' not found in config.properties")
    }

    fun getLong(key: String): Long {
        return getProperty(key).toLong()
    }

    fun getBaseUrl(): String {
        return getProperty("BASE_URL")
    }
}
