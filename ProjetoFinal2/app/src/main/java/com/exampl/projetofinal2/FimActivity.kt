package com.exampl.projetofinal2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.exampl.projetofinal2.databinding.ActivityFimBinding
import com.exampl.projetofinal2.databinding.ActivityFotoBinding

class FimActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFimBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFimBinding.inflate(layoutInflater)
        setContentView(binding.main)

        binding.buttonFim.setOnClickListener {
            // Certifique-se de usar a classe correta da próxima Activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}