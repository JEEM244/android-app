package com.example.mi_app_sop_e4_ea_jeem.ui.color

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.mi_app_sop_e4_ea_jeem.R

class ColorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)

        val mainLayout: LinearLayout = findViewById(R.id.colorMainLayout)
        val rgColors: RadioGroup = findViewById(R.id.rgColors)

        rgColors.setOnCheckedChangeListener { _, checkedId ->
            val colorRes = when (checkedId) {
                R.id.rbRojo -> R.color.red
                R.id.rbAzul -> R.color.blue
                R.id.rbVerde -> R.color.green
                R.id.rbAmarillo -> R.color.yellow
                R.id.rbNegro -> R.color.black
                R.id.rbBlanco -> R.color.white
                R.id.rbMorado -> R.color.purple
                R.id.rbCyan -> R.color.cyan
                R.id.rbMagenta -> R.color.magenta
                R.id.rbGris -> R.color.gray
                else -> R.color.white
            }
            mainLayout.setBackgroundColor(ContextCompat.getColor(this, colorRes))
        }
    }
}
