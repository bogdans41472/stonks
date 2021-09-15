package com.boghydan.hackernews.ui

import com.boghydan.hackernews.util.DataState

interface DataStateListener {
    fun onDataStateChanged(data: DataState<*>?)
}