package com.suwonsmartapp.di

import com.suwonsmartapp.data.network_monitor.DefaultNetworkMonitor
import com.suwonsmartapp.domain.network_monitor.NetworkMonitor
import org.koin.dsl.module

val dataModule = module {
    single<NetworkMonitor> {
        DefaultNetworkMonitor(get())
    }
}