package com.myproject.pageobject

import com.myproject.base.ConfigReader
import com.myproject.base.DriverManager
import org.openqa.selenium.By

class LoginPage {

    private val driver = DriverManager.getDriver()

    fun navigateToLoginPage() {
        driver.get(ConfigReader.getBaseUrl())
    }

    fun enterUsername(username: String) {
        driver.findElement(By.id("user-name")).sendKeys(username)
    }

    fun enterPassword(password: String) {
        driver.findElement(By.id("password")).sendKeys(password)
    }

    fun clickLogin() {
        driver.findElement(By.id("login-button")).click()
    }

    fun isOnProductsPage(): Boolean {
        return driver.currentUrl.contains("inventory")
    }
}
