package com.exampl.projetofinal2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EntrandoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_entrando)

        Handler(Looper.getMainLooper()).postDelayed({
            var intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
            finish()
        }, 1000)
    }
}