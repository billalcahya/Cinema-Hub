package com.dicoding.cinemahub

import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var etForgotUsername: EditText
    private lateinit var btnResetPassword: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty_forgot_password)

        etForgotUsername = findViewById(R.id.et_forgot_username)
        btnResetPassword = findViewById(R.id.btn_reset_password)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.setStatusBarColor(resources.getColor(android.R.color.white))
            window.decorView.systemUiVisibility = WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
        }

        btnResetPassword.setOnClickListener {
            val username = etForgotUsername.text.toString()

            if (username.isNotEmpty()) {
                Toast.makeText(this, "Password reset link sent to $username", Toast.LENGTH_SHORT).show()

                finish()
            } else {
                Toast.makeText(this, "Please enter a username", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
