package com.phayarsar.domain.model

import java.util.Locale

data class LanguageModel (
    val language:String,
    val title:String,
    val body:String,
    val image:Int,
    val isSelected : Boolean,
    val locale: Locale
)
