package com.phayarsar.mobile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phayarsar.domain.PrayerRepository
import com.phayarsar.localization.LocalizationRepository
import com.phayarsar.localization.model.LocalizationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import kotlinx.coroutines.flow.map

@HiltViewModel
class MainViewModel @Inject constructor(
    localizationRepository: LocalizationRepository,
    prayerRepository: PrayerRepository
) : ViewModel() {

    val localizationFlow: StateFlow<LocalizationModel> =
        localizationRepository.localizationFlow.stateIn(
            scope = viewModelScope,
            initialValue = LocalizationModel(),
            started = SharingStarted.WhileSubscribed(5_000)
        )

    // collect get stated status
    val screenStateFlow = prayerRepository
        .getStartedFlow
        .map { isGetStarted -> if (isGetStarted) ScreenState.Home else ScreenState.Welcome }
        .stateIn(
            scope = viewModelScope,
            initialValue = ScreenState.Welcome,
            started = SharingStarted.WhileSubscribed(5_000)
        )
}

enum class ScreenState {
    Home,
    Welcome
}