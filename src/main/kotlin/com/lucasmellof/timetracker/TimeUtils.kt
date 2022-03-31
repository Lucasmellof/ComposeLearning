package com.lucasmellof.timetracker

object TimeUtils {
    // Probably not the best readable function but fast
    fun formatMillisToString(millis: Long): String {
        var seconds = millis / 1000
        if (seconds < 60) {
            return seconds.toString() + "s"
        }
        var minutes = seconds / 60
        seconds %= 60
        if (minutes < 60) {
            return String.format("%dm %ds", minutes, seconds)
        }
        var hours = minutes / 60
        minutes %= 60
        if (hours < 24) {
            return String.format("%dh %dm %ds", hours, minutes, seconds)
        }
        var days = hours.toInt() / 24
        hours %= 24
        if (days < 7) {
            return String.format("%dd %dh %dm %ds", days, hours, minutes, seconds)
        }
        var weeks = days / 7
        days %= 7
        if (weeks < 4) {
            return String.format("%dw %dd %dh %dm %ds", weeks, days, hours, minutes, seconds)
        }
        var months = weeks / 4
        weeks %= 4
        if (months < 12) {
            return String.format("%dM %dw %dd %dh %dm %ds", months, weeks, days, hours, minutes, seconds)
        }
        val years = months / 12
        months %= 12
        return String.format("%dy %dM %dw %dd %dh %dm %ds", years, months, weeks, days, hours, minutes, seconds)
    }

    fun formatToExcel(millis: Long): String {
        var seconds = millis / 1000
        if (seconds < 60) {
            return "00:00:$seconds"
        }
        var minutes = seconds / 60
        seconds %= 60
        if (minutes < 60) {
            return "00:$minutes:$seconds"
        }
        val hours = minutes / 60
        minutes %= 60
        if (hours < 24) {
            return "$hours:$minutes:$seconds"
        }
        return "00:00:00"
    }
}