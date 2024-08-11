package com.phayarsar.data.datasource

import com.phayarsar.data.responsemodel.LanguageResponse
import com.phayarsar.data.responsemodel.PrayerResponseModel
import java.util.Locale
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    val localeFlow: Flow<Locale>
    val getPrayerList : Flow<List<PrayerResponseModel>>

    val getOtherPrayerList : Flow<List<PrayerResponseModel>>

    val localization:Flow<Map<String,LanguageResponse>>

    suspend fun changeLocale(locale: Locale)
}