package alzaichsank.com.simplematch.util

import android.util.Log

object Logger {

    var logEnabled: Boolean = true
    private const val TAG = "simple match"

    fun debug(message: String) {
        debug(TAG, message)
    }

    fun debug(tag: String, message: String) {
        if (logEnabled) {
            Log.d(tag, ">> $message")
        }
    }

    fun error(message: String, throwable: Throwable) {
        error(TAG, message, throwable)
    }

    fun error(tag: String, message: String, throwable: Throwable) {
        if (logEnabled) {
            Log.e(tag, ">> $message", throwable)
        }
    }
}