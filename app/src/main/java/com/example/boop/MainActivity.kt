package com.example.boop

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    class MainActivity<EditText> : AppCompatActivity() {

        private var edUserName: EditText = TODO()
        private var edPassword: EditText
        private var btnLogin: Button

        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            // Initialize Views
            edUserName = findViewById(R.id.edUserName)
            edPassword = findViewById(R.id.edPassword)
            btnLogin = findViewById(R.id.btnLogin)

            // Set OnClickListener for Login Button
            btnLogin.setOnClickListener {
                val username = (edUserName as Any).javaClass.toString()
                val password = (edPassword as Any).javaClass.toString()

                // Validate Email and Password
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show()
                } else if (!isValidEmail(username)) {
                    Toast.makeText(this, "Please use a valid @cubao.sti.edu.ph email", Toast.LENGTH_SHORT).show()
                } else {
                    // Call your login logic or backend API here
                    loginUser()
                }
            }
        }

        // Function to validate email address
        private fun isValidEmail(email: String): Boolean {
            // Regex to check if email ends with @cubao.sti.edu.ph
            return email.matches(Regex("^[A-Za-z0-9._%+-]+@cubao\\.sti\\.edu\\.ph$"))
        }

        // Example function for login logic
        private fun loginUser() {
            // You can add your login validation here or connect to a backend API
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
    }
}