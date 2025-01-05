package com.dicoding.cinemahub

import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var etCreateUsername: EditText
    private lateinit var etCreatePassword: EditText
    private lateinit var btnCreateAccount: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty_create_account)

        etCreateUsername = findViewById(R.id.et_create_username)
        etCreatePassword = findViewById(R.id.et_create_password)
        btnCreateAccount = findViewById(R.id.btn_create_account)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.setStatusBarColor(resources.getColor(android.R.color.white))
            window.decorView.systemUiVisibility = WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
        }

        btnCreateAccount.setOnClickListener {
            val username = etCreateUsername.text.toString()
            val password = etCreatePassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show()

                finish()
            } else {
                Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
