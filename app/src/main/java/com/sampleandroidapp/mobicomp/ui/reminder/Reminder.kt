package com.sampleandroidapp.mobicomp.ui.reminder

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.google.accompanist.insets.systemBarsPadding

@Composable
fun Reminder(
    onBackPress: () -> Unit
) {
    Text(text = "Here is Reminder screen, main screen. To be developed later")

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
        ) {
            TopAppBar {
                IconButton( onClick = onBackPress ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,  // Default to Filled
                        contentDescription = null
                    )
                }
                Text(text = "Reminder",
                    textAlign = TextAlign.Center)
            }
        }
    }
}
