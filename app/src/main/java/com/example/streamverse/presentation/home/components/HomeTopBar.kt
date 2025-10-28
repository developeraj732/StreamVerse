package com.example.streamverse.presentation.home.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.streamverse.utils.ContentType

@Composable
fun HomeTopBar(
    selectedType: ContentType,
    onTypeSelected: (ContentType) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 28.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        ContentType.values().forEach { type ->
            val isSelected = selectedType == type

            val containerColor by animateColorAsState(
                targetValue = if (isSelected)
                    MaterialTheme.colorScheme.primary
                else
                    MaterialTheme.colorScheme.surfaceVariant
            )

            val contentColor by animateColorAsState(
                targetValue = if (isSelected)
                    MaterialTheme.colorScheme.onPrimary
                else
                    MaterialTheme.colorScheme.onSurfaceVariant
            )

            Button(
                onClick = { onTypeSelected(type) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = containerColor,
                    contentColor = contentColor
                ),
                modifier = Modifier.weight(1f),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = if (isSelected) 4.dp else 1.dp
                )
            ) {
                Text(
                    text = type.name.replace("_", " "),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}