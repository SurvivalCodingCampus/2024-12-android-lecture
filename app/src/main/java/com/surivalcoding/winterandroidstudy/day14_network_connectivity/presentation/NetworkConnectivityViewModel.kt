package com.surivalcoding.winterandroidstudy.day14_network_connectivity.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suwonsmartapp.domain.network_monitor.NetworkMonitor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class NetworkConnectivityViewModel(
    private val networkMonitor: NetworkMonitor,
) : ViewModel() {

    private val _state = MutableStateFlow(NetworkConnectivityState.Lost)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            networkMonitor.isOnline
                .map {
                    if (it) {
                        NetworkConnectivityState.Available
                    } else {
                        NetworkConnectivityState.Lost
                    }
                }.collect { networkState ->
                    _state.value = networkState
                }
        }
    }
}