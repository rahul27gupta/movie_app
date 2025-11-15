package com.movieapp.base.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(
    title: String,
    showBackButton: Boolean = false,
    onBackClick: (() -> Unit)? = null
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        if (showBackButton && onBackClick != null) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onBackClick() },
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
        Text(
            text = title,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .weight(1f)
                .padding(start = if (showBackButton) 8.dp else 0.dp, top = 16.dp, bottom = 16.dp)
        )
    }
}