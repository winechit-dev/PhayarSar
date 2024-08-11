package com.phayarsar.domain.model

import java.util.Locale

data class LanguageModel (
    val languageName:String,
    val languageNotation:String,
    val image:Int,
    val isChecked : Boolean,
    val locale: Locale
)
