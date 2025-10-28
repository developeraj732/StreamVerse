package com.example.streamverse.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.streamverse.data.model.response.WatchContent

@Composable
fun ContentGrid(
    contents: List<WatchContent>,
    onItemClick: (String) -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    // Responsive columns: 2 for phones, 3 for tablets, 4+ for larger screens
    val columns = when {
        screenWidth < 600 -> 2
        screenWidth < 840 -> 3
        else -> 4
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(contents) { content ->
            WatchContentCard(
                content = content,
                onClick = { onItemClick(content.id) }
            )
        }
    }
}