package com.phayarsar.data.datasource

import android.content.Context
import com.phayarsar.data.responsemodel.PrayerResponseModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.IOException
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : LocalDataSource {

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
}