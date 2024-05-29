package com.phyarsar.home

import com.phayarsar.domain.model.PrayerModel

interface HomeEvent {

    data object OnBack : HomeEvent
    data object OnSearch : HomeEvent
    data object OnNext : HomeEvent
    data class GoToDetails(val prayerModel: PrayerModel) : HomeEvent
}