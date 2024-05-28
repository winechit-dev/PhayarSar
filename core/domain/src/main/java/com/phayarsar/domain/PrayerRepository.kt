package com.phayarsar.domain

import com.phayarsar.domain.model.PrayerModel
import kotlinx.coroutines.flow.Flow

interface PrayerRepository {

    val getPrayerList: Flow<List<PrayerModel>>

    val getOtherPrayerList: Flow<List<PrayerModel>>

}