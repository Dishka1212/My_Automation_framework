package com.myproject.hooks

import io.cucumber.java.Before
import io.cucumber.java.After
import com.myproject.base.DriverManager

class DriverHooks {

    @Before
    fun setup() {
        DriverManager.initDriver()
    }

    @After
    fun teardown() {
        DriverManager.quitDriver()
    }
}
