package com.khin.dailypulse

import android.util.Log

actual class Platform {
    actual val osName: String = "Android"
    actual val osVersion: String = android.os.Build.VERSION.RELEASE
    actual val deviceModel: String = android.os.Build.MODEL
    actual val density: Int = 0

    actual fun logSystemInfo() {
        Log.d("Daily Pulse","OS: $osName $osVersion, Device: $deviceModel, Density: $density")
    }
}