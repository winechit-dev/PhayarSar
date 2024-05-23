package com.phyarsar.home


data class LanguageDummyModel (
    val languageName:String,
    val languageNotation:String,
    val image:Int,
    val isChecked : Boolean
)

val languageList = listOf(
    LanguageDummyModel(
        languageName = "English",
        languageNotation = "(English)",
        image = R.drawable.ic_uk_flag,
        isChecked = false
    ),
    LanguageDummyModel(
        languageName = "Myanmar",
        languageNotation = "(မြန်မာစာ)",
        image = R.drawable.ic_myanmar_flag,
        isChecked = true
    )
)