package com.phyarsar.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phayarsar.domain.PrayerRepository
import com.phayarsar.domain.model.PrayerModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    prayerRepository: PrayerRepository
) : ViewModel() {

    var uiState = combine(
        prayerRepository.getPrayerList,
        prayerRepository.getOtherPrayerList
    ) { prayerList, otherPrayerList ->
        HomeUiState(
            prayerList = prayerList,
            otherPrayerList = otherPrayerList
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = HomeUiState()
    )


}

data class HomeUiState(
    val prayerList: List<PrayerModel> = emptyList(),
    val otherPrayerList: List<PrayerModel> = emptyList()
)