package com.example.sem08

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etContrasena = findViewById<EditText>(R.id.etContrasena)

        btnLogin.setOnClickListener {
            val nombre = etNombre.text.toString()
            val password = etContrasena.text.toString()

            if (nombre.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("nombre", nombre)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Completa ambos campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
