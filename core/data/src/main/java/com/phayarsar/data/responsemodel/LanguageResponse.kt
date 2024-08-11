package com.phayarsar.data.responsemodel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LanguageResponse(
    @SerialName("En") val en: String = "",
    @SerialName("Mm") val mm: String = ""
)
