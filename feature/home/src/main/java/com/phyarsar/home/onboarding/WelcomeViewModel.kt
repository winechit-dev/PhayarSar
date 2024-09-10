package com.phyarsar.home.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phayarsar.domain.PrayerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val prayerRepository: PrayerRepository
) : ViewModel() {

    fun getStartedStatus(isStarted: Boolean) {
        // return get started status from repository

        viewModelScope.launch(Dispatchers.IO) {
            prayerRepository.getStarted(isStarted)
        }
    }

}