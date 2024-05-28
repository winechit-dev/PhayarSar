package com.phayarsar.data.repository

import com.phayarsar.data.datasource.LocalDataSource
import com.phayarsar.data.mapper.toPrayerModelList
import com.phayarsar.domain.PrayerRepository
import com.phayarsar.domain.model.PrayerModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PrayerRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : PrayerRepository {

    override val getPrayerList: Flow<List<PrayerModel>>
        get() = localDataSource.getPrayerList.map {
            it.toPrayerModelList()
        }

    override val getOtherPrayerList: Flow<List<PrayerModel>>
        get() = localDataSource.getOtherPrayerList.map {
            it.toPrayerModelList()
        }
}