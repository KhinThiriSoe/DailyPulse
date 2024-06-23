package com.khin.dailypulse

actual class Platform {
    actual val osName: String
        get() = "Web"
    actual val osVersion: String
        get() = "Web"
    actual val deviceModel: String
        get() = "Web"
    actual val density: Int
        get() = 0

    actual fun logSystemInfo() {
        println("osName: $osName, osVersion: $osVersion, deviceModel: $deviceModel, density: $density")
    }
}