package com.phayarsar.data.mapper

import com.phayarsar.data.responsemodel.PrayerResponseModel
import com.phayarsar.domain.model.PrayerModel

fun PrayerResponseModel.toPrayerModel(): PrayerModel {
    return PrayerModel(
        id = id,
        label = label
    )
}

fun List<PrayerResponseModel>.toPrayerModelList(): List<PrayerModel> {
    return this.map {
        it.toPrayerModel()
    }
}