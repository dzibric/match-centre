package com.incrowd.matchcentre.ui.stats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.incrowd.matchcentre.data.Result
import com.incrowd.matchcentre.data.match.models.stats.StatsData
import com.incrowd.matchcentre.data.successful
import com.incrowd.matchcentre.domain.match.IMatchInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatsViewModel @Inject constructor(
    private val matchInteractor: IMatchInteractor
) : ViewModel() {

    private val _statsData = MutableLiveData<StatsData>()
    val statsData: LiveData<StatsData> = _statsData

    fun getStatsData(id: Long) = viewModelScope.launch {
        val result = matchInteractor.getMatchStats(id)
        if (result.successful) {
            _statsData.postValue((result as Result.Success).data)
        }
    }
}