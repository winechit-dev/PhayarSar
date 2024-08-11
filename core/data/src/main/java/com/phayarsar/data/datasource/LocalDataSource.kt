package com.phayarsar.data.datasource

import com.phayarsar.data.responsemodel.LocalizationResponseModel
import com.phayarsar.data.responsemodel.PrayerResponseModel
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    val getPrayerList : Flow<List<PrayerResponseModel>>

    val getOtherPrayerList : Flow<List<PrayerResponseModel>>

    val localization:Flow<LocalizationResponseModel>

}