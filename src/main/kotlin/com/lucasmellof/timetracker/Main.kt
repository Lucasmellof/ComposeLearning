package com.lucasmellof.timetracker

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberTrayState

@Composable
@Preview
fun App(stopWatch: StopWatch) {
    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize().background(Color(0xFF212121)),
            contentAlignment = Alignment.Center
        ) {

            UI(
                time = stopWatch.formattedTime,
                onStart = { stopWatch.start() },
                onPause = { stopWatch.pause() },
                onReset = { stopWatch.reset() },
                onCopy = { stopWatch.copy() }
            )
        }
    }
}

fun main() = application {
    val stopWatch = remember { StopWatch() }
    var isVisible by remember { mutableStateOf(true) }
    Window(
        onCloseRequest = { isVisible = false },
        visible = isVisible,
        title = "TimeTracker",
        icon = painterResource("icon.svg"),
        alwaysOnTop = true
    ) {
        App(stopWatch)
    }
    if(!isVisible) {
        val trayState = rememberTrayState()
        Tray(
            state = trayState,
            icon = painterResource("icon.svg"),
            tooltip = "TimeTracker",
            onAction = {
                isVisible = true
            },
            menu = {
                Item("Copy", onClick = { stopWatch.copy() })
                Separator()
                Item("Time: ${stopWatch.formattedTime}", onClick = {})
                Item("Pause/Play", onClick = {
                    if(stopWatch.isRunning) {
                        stopWatch.pause()
                    } else {
                        stopWatch.start()
                    }
                })
                Separator()
                Item("Exit", onClick = ::exitApplication)
            }
        )
    }
}