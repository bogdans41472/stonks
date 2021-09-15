package com.boghydan.hackernews.util

class Event<T>(
    private val content: T
) {
    var hasBeenHandled = false
    private set // Allows external read, but not setting


    /**
     * Returns content and prevents its re-use.
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * Returns content, even it has been handled.
     */
    fun peekContent(): T = content

    override fun toString(): String {
        return "Event(content=$content,hasBeenHandled=$hasBeenHandled)"
    }

    companion object {
        fun messageEvent(message: String?): Event<String>?{
            message?.let{
                return Event(message)
            }
            return null
        }

        fun<T> dataEvent(data: T?): Event<T>? {
            data?.let {
                return Event(data)
            }
            return null
        }
    }
}
