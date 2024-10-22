package com.example.nit3213_final_asssessment_liam

import org.junit.Assert.* // Import assertions for testing
import org.junit.Before // Import annotation for setup method
import org.junit.Test // Import annotation for test methods

class LoginActivityTest {

    lateinit var loginUsers: LoginActivity // Declare a variable for LoginActivity

    @Before // Method to set up before each test
    fun setUp() {
        loginUsers = LoginActivity() // Initialize the LoginActivity instance
    }

    @Test // Test case for empty username
    fun emptyUsernameWillReturnFalse() {
        val result = loginUsers.Verifyusers("", "s4669098") // Call Verifyusers with an empty username
        assertFalse(result) // Assert that the result is false
    }

    @Test // Test case for empty password
    fun emptyPasswordWillReturnFalse() {
        val result = loginUsers.Verifyusers("Liam", "") // Call Verifyusers with an empty password
        assertFalse(result) // Assert that the result is false
    }

    @Test // Test case for invalid username
    fun invalidUsernameWillReturnFalse() {
        val result = loginUsers.Verifyusers("InvalidUser", "s4669098") // Call Verifyusers with an invalid username
        assertFalse(result) // Assert that the result is false
    }

    @Test // Test case for valid inputs
    fun validInputsWillReturnTrue() {
        val result = loginUsers.Verifyusers("Liam", "s4669098") // Call Verifyusers with valid credentials
        assertTrue(result) // Assert that the result is true
    }
}
