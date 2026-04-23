package com.example.mi_app_sop_e4_ea_jeem.ui.quiz

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.mi_app_sop_e4_ea_jeem.R
import com.example.mi_app_sop_e4_ea_jeem.data.model.Question

class QuizActivity : AppCompatActivity() {

    private val questions = listOf(
        Question("¿Qué significa CPU?", listOf("Central Process Unit", "Central Processing Unit", "Computer Personal Unit", "Control Process Unit"), 1),
        Question("¿Cuál es el lenguaje oficial para Android?", listOf("Java", "Swift", "Kotlin", "Python"), 2),
        Question("¿Qué componente se usa para la UI?", listOf("Activity", "Service", "Provider", "Receiver"), 0),
        Question("¿Qué archivo define la configuración de la app?", listOf("Strings.xml", "MainActivity.kt", "AndroidManifest.xml", "Build.gradle"), 2),
        Question("¿Qué es Gradle?", listOf("Un lenguaje", "Sistema de compilación", "Un emulador", "Un servidor"), 1),
        Question("¿Quién desarrolló Android?", listOf("Apple", "Microsoft", "Google", "Oracle"), 2),
        Question("¿Qué es un Intent?", listOf("Una base de datos", "Mensaje de comunicación", "Un bucle", "Un tipo de variable"), 1),
        Question("¿Cuál es el IDE oficial?", listOf("Eclipse", "VS Code", "Android Studio", "Xcode"), 2),
        Question("¿Qué extensión tienen los layouts?", listOf(".kt", ".java", ".xml", ".json"), 2),
        Question("¿Qué es un RadioGroup?", listOf("Contenedor de botones", "Un tipo de lista", "Un visor de fotos", "Un reproductor"), 0),
        Question("¿Para qué sirve findViewById?", listOf("Borrar vistas", "Enlazar vistas al código", "Cambiar de pantalla", "Cerrar la app"), 1),
        Question("¿Qué es una Activity?", listOf("Un servicio", "Una pantalla de la app", "Un objeto", "Una función"), 1)
    )

    private var currentQuestionIndex = 0
    private var correctAnswers = 0
    private var incorrectAnswersList = mutableListOf<String>()

    private lateinit var tvQuestionCount: TextView
    private lateinit var tvQuestionText: TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var rbOption1: RadioButton
    private lateinit var rbOption2: RadioButton
    private lateinit var rbOption3: RadioButton
    private lateinit var rbOption4: RadioButton
    private lateinit var btnNext: Button
    private lateinit var layoutResult: LinearLayout
    private lateinit var tvCorrectCount: TextView
    private lateinit var tvIncorrectCount: TextView
    private lateinit var tvIncorrectList: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        initViews()
        displayQuestion()

        btnNext.setOnClickListener {
            handleNextButtonClick()
        }
    }

    private fun initViews() {
        tvQuestionCount = findViewById(R.id.tvQuestionCount)
        tvQuestionText = findViewById(R.id.tvQuestionText)
        radioGroup = findViewById(R.id.radioGroup)
        rbOption1 = findViewById(R.id.rbOption1)
        rbOption2 = findViewById(R.id.rbOption2)
        rbOption3 = findViewById(R.id.rbOption3)
        rbOption4 = findViewById(R.id.rbOption4)
        btnNext = findViewById(R.id.btnNext)
        layoutResult = findViewById(R.id.layoutResult)
        tvCorrectCount = findViewById(R.id.tvCorrectCount)
        tvIncorrectCount = findViewById(R.id.tvIncorrectCount)
        tvIncorrectList = findViewById(R.id.tvIncorrectList)
    }

    private fun handleNextButtonClick() {
        val selectedId = radioGroup.checkedRadioButtonId
        if (selectedId == -1) {
            Toast.makeText(this, getString(R.string.msg_select_option), Toast.LENGTH_SHORT).show()
            return
        }

        val selectedIndex = when (selectedId) {
            R.id.rbOption1 -> 0
            R.id.rbOption2 -> 1
            R.id.rbOption3 -> 2
            R.id.rbOption4 -> 3
            else -> -1
        }

        if (selectedIndex == questions[currentQuestionIndex].correctAnswerIndex) {
            correctAnswers++
        } else {
            incorrectAnswersList.add(questions[currentQuestionIndex].text)
        }

        currentQuestionIndex++

        if (currentQuestionIndex < questions.size) {
            displayQuestion()
        } else {
            showResults()
        }
    }

    private fun displayQuestion() {
        val q = questions[currentQuestionIndex]
        tvQuestionCount.text = getString(R.string.question_count, currentQuestionIndex + 1, questions.size)
        tvQuestionText.text = q.text
        rbOption1.text = q.options[0]
        rbOption2.text = q.options[1]
        rbOption3.text = q.options[2]
        rbOption4.text = q.options[3]
        radioGroup.clearCheck()
    }

    private fun showResults() {
        tvQuestionCount.visibility = View.GONE
        tvQuestionText.visibility = View.GONE
        radioGroup.visibility = View.GONE
        btnNext.visibility = View.GONE

        layoutResult.visibility = View.VISIBLE
        tvCorrectCount.text = getString(R.string.results_correct, correctAnswers)
        tvIncorrectCount.text = getString(R.string.results_incorrect, questions.size - correctAnswers)
        
        val incorrectText = if (incorrectAnswersList.isEmpty()) {
            getString(R.string.perfect_score)
        } else {
            val header = getString(R.string.incorrect_list_header)
            "$header\n" + incorrectAnswersList.joinToString("\n• ", prefix = "• ")
        }
        tvIncorrectList.text = incorrectText
    }
}
