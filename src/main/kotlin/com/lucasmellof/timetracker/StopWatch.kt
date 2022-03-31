package com.lucasmellof.timetracker

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.*
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection


/* 
 * @author Lucasmellof, Lucas de Mello Freitas created on 30/03/2022
 */
class StopWatch {
    var formattedTime by mutableStateOf("0s")

    private var coroutine = CoroutineScope(Dispatchers.Main)
    var isRunning = false
    private var time = 0L
    private var lastTime = 0L

    fun start() {
        if (isRunning) return
        coroutine.launch {
            lastTime = System.currentTimeMillis()
            isRunning = true
            while (isRunning) {
                delay(50L)
                time += System.currentTimeMillis() - lastTime
                lastTime = System.currentTimeMillis()
                formattedTime = TimeUtils.formatMillisToString(time)
            }
        }
    }

    fun pause() {
        isRunning = false
    }

    fun reset() {
        // At least on Windows, the clipboard has history, so we can recover the previous value
        copy()

        coroutine.cancel()
        coroutine = CoroutineScope(Dispatchers.Main)
        time = 0L
        lastTime = 0L
        formattedTime = "0s"
        isRunning = false
    }

    fun copy() {
        val selection = StringSelection(TimeUtils.formatToExcel(time))
        val clipboard = Toolkit.getDefaultToolkit().systemClipboard
        clipboard.setContents(selection, selection)
    }
}