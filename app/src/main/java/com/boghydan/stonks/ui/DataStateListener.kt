package com.boghydan.stonks.ui

import com.boghydan.stonks.util.DataState

interface DataStateListener {
    fun onDataStateChanged(data: DataState<*>?)
}