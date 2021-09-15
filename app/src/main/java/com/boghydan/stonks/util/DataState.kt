package com.boghydan.stonks.util

import androidx.annotation.NonNull

data class DataState<T>(
    var message: Event<String>? = null,
    var loading: Boolean = false,
    var data: Event<T>? = null
) {
    companion object {
        fun <T> error(@NonNull message: String)
                : DataState<T> {
            return DataState(
                message= Event(message),
                loading= false,
                data= null
            )
        }

        fun <T> loading(showLoad: Boolean)
        : DataState<T> {
            return DataState(
                message= null,
                loading= showLoad,
                data= null
            )
        }

        fun <T> data(@NonNull message: String,
                     @NonNull data: Event<T>)
        : DataState<T> {
            return DataState(
                message = Event.messageEvent(message),
                loading= false,
                data= data
            )
        }
    }

    override fun toString(): String {
        return "DataState(message=$message,loading=${loading},data=${data})"
    }
}