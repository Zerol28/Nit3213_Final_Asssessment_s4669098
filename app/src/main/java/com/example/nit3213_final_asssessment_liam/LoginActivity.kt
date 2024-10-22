package com.example.nit3213_final_asssessment_liam

import android.content.Intent // Import Intent class for starting new activities
import android.os.Bundle // Import Bundle class for activity state
import android.widget.Button // Import Button class for UI buttons
import android.widget.EditText // Import EditText class for user input fields
import android.widget.Toast // Import Toast class for displaying messages
import androidx.appcompat.app.AppCompatActivity // Import AppCompatActivity for compatibility with older Android versions
import okhttp3.* // OkHttp library for network requests
import okhttp3.MediaType.Companion.toMediaType // Extension function to create media type
import okhttp3.RequestBody.Companion.toRequestBody // Extension function to create request body
import org.json.JSONObject // Import JSONObject class for JSON manipulation
import java.io.IOException // Import IOException class for handling input/output exceptions


class LoginActivity : AppCompatActivity() {

    // Declare UI elements for login screen
    private lateinit var liUsername: EditText
    private lateinit var liPassword: EditText
    private lateinit var btnLogin: Button

    // Create OkHttpClient instance for making network requests
    private val client = OkHttpClient()

    // onCreate is called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content view to the login layout (activity_login.xml)
        setContentView(R.layout.activity_login)

        // Find and initialize EditText for username and password from layout
        liUsername = findViewById(R.id.LI_Username)
        liPassword = findViewById(R.id.LI_Password)

        // Find and initialize Login Button from layout
        btnLogin = findViewById(R.id.btn_Login)

        // Set up click listener for Login Button
        btnLogin.setOnClickListener {
            // Retrieve the entered username and password from the EditText fields
            val username = liUsername.text.toString()
            val password = liPassword.text.toString()

            // Check if both fields are filled, otherwise show a Toast message
            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Call login function if fields are not empty
                login(username, password)
            } else {
                // Show error message if username or password is empty
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Function to handle login functionality and make a network request
    private fun login(username: String, password: String) {
        // Define API endpoint for authentication
        val url = "https://nit3213-api-h2b3-latest.onrender.com/footscray/auth"

        // Create a JSON object with the username and password
        val jsonObject = JSONObject().apply {
            put("username", username)
            put("password", password)
        }

        // Convert the JSON object to a request body with the correct media type
        val requestBody = jsonObject.toString().toRequestBody("application/json".toMediaType())

        // Create a POST request to the authentication endpoint
        val request = Request.Builder()
            .url(url) // Set the URL
            .post(requestBody) // Attach the JSON request body
            .build()

        // Execute the network request asynchronously
        client.newCall(request).enqueue(object : Callback {
            // If the network request fails (e.g., due to connectivity issues)
            override fun onFailure(call: Call, e: IOException) {
                // Show an error message to the user on the UI thread
                runOnUiThread {
                    Toast.makeText(this@LoginActivity, "Network Error", Toast.LENGTH_SHORT).show()
                }
            }

            // If the network request is successful
            override fun onResponse(call: Call, response: Response) {
                // Run on UI thread to update UI components (Toast, Intent)
                runOnUiThread {
                    if (response.isSuccessful) {
                        // If login is successful, start MainActivity
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent) // Start new activity
                        finish() // Finish current activity so it can't be returned to
                    } else {
                        // Show a message if login credentials are invalid
                        Toast.makeText(this@LoginActivity, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    // A mock function to verify users locally (for testing)
    fun Verifyusers(liUsername: String, liPassword: String): Boolean {
        // Check if username matches a hardcoded value
        if (liUsername != "Liam") {
            return false
        }
        // Check if password matches a hardcoded value
        if (liPassword != "s4669098") {
            return false
        }
        // Return true if both username and password are correct
        return true
    }
}
