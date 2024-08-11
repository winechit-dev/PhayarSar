package com.phayarsar.data.datasource

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.phayarsar.data.responsemodel.LanguageResponse
import com.phayarsar.data.responsemodel.PrayerResponseModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.IOException
import java.util.Locale
import javax.inject.Inject
import kotlinx.coroutines.flow.map

class LocalDataSourceImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val preferences: DataStore<Preferences>,
) : LocalDataSource {

    companion object {
        private const val KEY_LOCALE = "locale"
    }

    override val localeFlow: Flow<Locale>
        get() = preferences.data
            .map { it[stringPreferencesKey(KEY_LOCALE)] }
            .map { Locale(it ?: "en") }


    override val getPrayerList: Flow<List<PrayerResponseModel>>
        get() = flow {

            lateinit var jsonString: String
            lateinit var bufferedReader: BufferedReader

            try {
                bufferedReader = context.assets.open("prayer.json").bufferedReader()

                jsonString = bufferedReader.use { it.readText() }

            } catch (e: IOException) {
                e.printStackTrace()
            }
            emit(Json.decodeFromString(jsonString))
        }

    override val getOtherPrayerList: Flow<List<PrayerResponseModel>>
        get() = flow {

            lateinit var jsonString: String
            lateinit var bufferedReader: BufferedReader

            try {
                bufferedReader = context.assets.open("otherPrayer.json").bufferedReader()

                jsonString = bufferedReader.use { it.readText() }

            } catch (e: IOException) {
                e.printStackTrace()
            }
            emit(Json.decodeFromString(jsonString))
        }

    override val localization: Flow<Map<String, LanguageResponse>>
        get() = flow {

            lateinit var jsonString: String
            lateinit var bufferedReader: BufferedReader

            try {
                bufferedReader = context.assets.open("language.json").bufferedReader()

                jsonString = bufferedReader.use { it.readText() }

            } catch (e: IOException) {
                e.printStackTrace()
            }
            val localizationMap: Map<String, LanguageResponse> = Json.decodeFromString(jsonString)
            emit(localizationMap)
        }

    override suspend fun changeLocale(locale: Locale) {
        stringPreferencesKey(KEY_LOCALE).let { key ->
            preferences.edit {
                it[key] = locale.language
            }
        }
    }
}