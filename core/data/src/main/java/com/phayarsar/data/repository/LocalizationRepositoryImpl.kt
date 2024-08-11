package com.phayarsar.data.repository

import com.phayarsar.data.datasource.LocalDataSource
import com.phayarsar.data.mapper.toLocalizationModel
import com.phayarsar.localization.LocalizationRepository
import com.phayarsar.localization.model.LocalizationModel
import java.util.Locale
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

class LocalizationRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : LocalizationRepository {

    override val localizationFlow: Flow<LocalizationModel>
        get() = combine(
            localDataSource.localization,
            localDataSource.localeFlow
        ) { localization, locale ->
            localization.toLocalizationModel(locale)
        }

    override suspend fun changeLocale(locale: Locale) {
        localDataSource.changeLocale(locale)
    }
}