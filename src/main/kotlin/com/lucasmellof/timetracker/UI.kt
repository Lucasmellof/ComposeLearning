package com.lucasmellof.timetracker

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/* 
 * @author Lucasmellof, Lucas de Mello Freitas created on 30/03/2022
 */
@Composable
fun UI(
    time: String,
    onStart: () -> Unit,
    onPause: () -> Unit,
    onReset: () -> Unit,
    onCopy: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painterResource("icon.svg"),
            contentDescription = "Stopwatch",
            modifier = Modifier.width(200.dp).height(200.dp)
        )

        Text(
            text = time,
            style = MaterialTheme.typography.h1,
            fontSize = 50.sp,
            color = Color.White,
            modifier = Modifier.padding(top = 16.dp)
        )
        Spacer(Modifier.height(16.dp))
        Row {
            IconButton(onStart, modifier = Modifier.size(48.dp).background(Color.DarkGray, shape = CircleShape)) {
                Icon(
                    painterResource("start.svg"),
                    contentDescription = "Start",
                    tint = Color.Unspecified
                )
            }
            Spacer(Modifier.width(16.dp))
            IconButton(onPause, modifier = Modifier.size(48.dp).background(Color.DarkGray, shape = CircleShape)) {
                Icon(
                    painterResource("pause.svg"),
                    contentDescription = "Pause",
                    tint = Color.Unspecified
                )
            }
            Spacer(Modifier.width(16.dp))
            IconButton(onReset, modifier = Modifier.size(48.dp).background(Color.DarkGray, shape = CircleShape)) {
                Icon(
                    painterResource("reset.svg"),
                    contentDescription = "Reset",
                    tint = Color.Unspecified
                )
            }
            Spacer(Modifier.width(16.dp))
            IconButton(onCopy, modifier = Modifier.size(48.dp).background(Color.DarkGray, shape = CircleShape)) {
                Icon(
                    painterResource("copy.svg"),
                    contentDescription = "Copy",
                    tint = Color.Unspecified
                )
            }
        }
    }
}