package com.phayarsar.data.responsemodel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PrayerResponseModel(
    @SerialName("id") val id: String,
    @SerialName("label") val label: String
)
