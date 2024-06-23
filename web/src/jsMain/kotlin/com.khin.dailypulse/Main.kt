package com.khin.dailypulse

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.CanvasBasedWindow
import com.khin.dailypulse.di.initKoin
import com.khin.dailypulse.ui.App

val koin = initKoin()

@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    CanvasBasedWindow("DailyPulse") {

        Surface(modifier = Modifier.fillMaxSize()) {
            App(koin)
        }
    }
}