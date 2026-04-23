package com.example.mi_app_sop_e4_ea_jeem.ui.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mi_app_sop_e4_ea_jeem.R

class CalculadoraActivity : AppCompatActivity() {

    private lateinit var etNum1: EditText
    private lateinit var etNum2: EditText
    private lateinit var rbSuma: RadioButton
    private lateinit var rbResta: RadioButton
    private lateinit var rbMultiplicacion: RadioButton
    private lateinit var rbDivision: RadioButton
    private lateinit var btnCalcular: Button
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        etNum1 = findViewById(R.id.etNum1)
        etNum2 = findViewById(R.id.etNum2)
        rbSuma = findViewById(R.id.rbSuma)
        rbResta = findViewById(R.id.rbResta)
        rbMultiplicacion = findViewById(R.id.rbMultiplicacion)
        rbDivision = findViewById(R.id.rbDivision)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)

        btnCalcular.setOnClickListener {
            calcular()
        }
    }

    private fun calcular() {
        val num1Str = etNum1.text.toString()
        val num2Str = etNum2.text.toString()

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, getString(R.string.error_empty_fields), Toast.LENGTH_SHORT).show()
            return
        }

        val num1 = num1Str.toDouble()
        val num2 = num2Str.toDouble()
        var resultado = 0.0

        if (rbSuma.isChecked) {
            resultado = num1 + num2
        } else if (rbResta.isChecked) {
            resultado = num1 - num2
        } else if (rbMultiplicacion.isChecked) {
            resultado = num1 * num2
        } else if (rbDivision.isChecked) {
            if (num2 == 0.0) {
                Toast.makeText(this, getString(R.string.error_div_zero), Toast.LENGTH_SHORT).show()
                return
            }
            resultado = num1 / num2
        }

        val resultadoFormateado = if (resultado % 1 == 0.0) {
            resultado.toInt().toString()
        } else {
            resultado.toString()
        }

        tvResultado.text = "${getString(R.string.result_text)} $resultadoFormateado"
    }
}
