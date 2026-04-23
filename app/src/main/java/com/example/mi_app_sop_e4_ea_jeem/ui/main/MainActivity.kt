package com.example.mi_app_sop_e4_ea_jeem.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mi_app_sop_e4_ea_jeem.R
import com.example.mi_app_sop_e4_ea_jeem.ui.color.ColorActivity
import com.example.mi_app_sop_e4_ea_jeem.ui.quiz.QuizActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGoToQuiz: Button = findViewById(R.id.btnGoToQuiz)
        val btnGoToColors: Button = findViewById(R.id.btnGoToColors)
        val btnGoToCalculadora: Button = findViewById(R.id.btnGoToCalculadora)

        btnGoToQuiz.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }

        btnGoToColors.setOnClickListener {
            val intent = Intent(this, ColorActivity::class.java)
            startActivity(intent)
        }

        btnGoToCalculadora.setOnClickListener {
            val intent = Intent(this, com.example.mi_app_sop_e4_ea_jeem.ui.calculadora.CalculadoraActivity::class.java)
            startActivity(intent)
        }
    }
}
