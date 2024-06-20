package com.khin.dailypulse

actual class Platform {
    actual val osName: String
        get() = System.getProperty("os.name") ?: "Desktop"
    actual val osVersion: String
        get() = System.getProperty("os.version") ?: "1.0"
    actual val deviceModel: String
        get() = "Desktop"
    actual val density: Int
        get() = 0

    actual fun logSystemInfo() {
        println("OS: $osName $osVersion, Device: $deviceModel, Density: $density")
    }
}