package com.phayarsar.data.repository

import android.content.Context
import com.phayarsar.data.datasource.LocalDataSource
import com.phayarsar.data.mapper.toLocalizationModel
import com.phayarsar.localization.LocalizationRepository
import com.phayarsar.localization.model.LocalizationModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalizationRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource, @ApplicationContext private val context: Context
) : LocalizationRepository {

    override val localizationFlow: Flow<LocalizationModel>
        get() = localDataSource.localization.map {
            it.toLocalizationModel()
        }
}