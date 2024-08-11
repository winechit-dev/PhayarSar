package com.phayarsar.data.repository

import android.content.Context
import com.phayarsar.data.datasource.LocalDataSource
import com.phayarsar.data.mapper.toPrayerModelList
import com.phayarsar.domain.PrayerRepository
import com.phayarsar.domain.model.PrayerModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import kotlinx.coroutines.flow.flow

class PrayerRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource, @ApplicationContext private val context: Context
) : PrayerRepository {
    override val getStartedFlow: Flow<Boolean>
        get() = flow { emit(false) }


    override val getPrayerList: Flow<List<PrayerModel>>
        get() = localDataSource.getPrayerList.map {
            it.toPrayerModelList()
        }

    override val getOtherPrayerList: Flow<List<PrayerModel>>
        get() = localDataSource.getOtherPrayerList.map {
            it.toPrayerModelList()
        }

    override suspend fun getStarted() {
        //localDataSource.getStarted()
    }
}