package com.phyarsar.home

import androidx.lifecycle.viewModelScope
import com.phayarsar.domain.PrayerRepository
import com.phayarsar.domain.model.PrayerModel
import com.phayarsar.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val prayerRepository: PrayerRepository
) : BaseViewModel<HomeEvent>() {

    /*var uiState = combine(
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
    )*/

    private var _uiState = MutableStateFlow(HomeUiState(
        prayerList = PreviewData.previewPrayerList,
        otherPrayerList = PreviewData.previewOtherPrayerList
    ))
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
       /* getPrayerList()
        getOtherPrayerList()*/
    }

    private fun getPrayerList() {
        viewModelScope.launch(Dispatchers.IO) {
            prayerRepository.getPrayerList.collectLatest { prayerList ->
                _uiState.update {
                    it.copy(prayerList = prayerList)
                }
            }
        }
    }

    private fun getOtherPrayerList() {
        viewModelScope.launch(Dispatchers.IO) {
            prayerRepository.getOtherPrayerList.collectLatest { otherPrayerList ->
                _uiState.update {
                    it.copy(otherPrayerList = otherPrayerList)
                }
            }
        }
    }

    fun homeEvent(event: HomeEvent) {
        viewModelScope.launch(Dispatchers.IO) {
            emitEvent(event)
        }
    }

}

data class HomeUiState(
    val prayerList: List<PrayerModel> = emptyList(),
    val otherPrayerList: List<PrayerModel> = emptyList()
)