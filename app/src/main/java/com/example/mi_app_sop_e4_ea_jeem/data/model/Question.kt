package com.example.mi_app_sop_e4_ea_jeem.data.model

data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)
