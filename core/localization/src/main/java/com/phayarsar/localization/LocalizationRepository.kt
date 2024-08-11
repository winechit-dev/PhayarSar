package com.phayarsar.localization

import com.phayarsar.localization.model.LocalizationModel
import java.util.Locale
import kotlinx.coroutines.flow.Flow

interface LocalizationRepository {
    val localizationFlow: Flow<LocalizationModel>
    suspend fun changeLocale(locale: Locale)
}