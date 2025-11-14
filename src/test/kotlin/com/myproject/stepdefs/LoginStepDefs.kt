package com.myproject.stepdefs

import com.myproject.pageobject.LoginPage
import io.cucumber.java.en.Given
import io.cucumber.java.en.When
import io.cucumber.java.en.Then
import org.junit.jupiter.api.Assertions.assertTrue

class LoginStepDefs {

    private val loginPage = LoginPage()

    @Given("the user is on the login page")
    fun goToLogin() {
        loginPage.navigateToLoginPage()
    }

    @When("the user logs in with username {string} and password {string}")
    fun doLogin(username: String, password: String) {
        loginPage.enterUsername(username)
        loginPage.enterPassword(password)
        loginPage.clickLogin()
    }

    @Then("the user should see the products page")
    fun verifyPage() {
        assertTrue(loginPage.isOnProductsPage())
    }
}
