package com.example.streamverse.presentation.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.streamverse.data.model.response.WatchContent

@Composable
fun DetailHeader(content: WatchContent) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    // Responsive poster height
    val posterHeight = when {
        screenWidth < 600 -> 400.dp
        screenWidth < 840 -> 500.dp
        else -> 600.dp
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(posterHeight),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            shape = MaterialTheme.shapes.large
        ) {
            Box {
                AsyncImage(
                    model = content.posterUrl,
                    contentDescription = content.title,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )

                // Gradient overlay for better text readability
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(posterHeight)
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black.copy(0.3f)
                                ),
                                startY = posterHeight.value * 2
                            )
                        )
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = content.title,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = content.releaseDate ?: "Release Year Not Available",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}