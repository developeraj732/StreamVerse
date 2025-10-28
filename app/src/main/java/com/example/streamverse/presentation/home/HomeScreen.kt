package com.example.streamverse.presentation.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.streamverse.data.model.response.WatchContent
import com.example.streamverse.presentation.home.components.ContentGrid
import com.example.streamverse.presentation.home.components.ErrorContent
import com.example.streamverse.presentation.home.components.HomeTopBar
import com.example.streamverse.presentation.home.components.ShimmerEffect
import com.example.streamverse.utils.ContentType
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    onNavigateToDetails: (String) -> Unit
) {
    val state by viewModel.state.collectAsState()
    val contentType by viewModel.contentType.collectAsState()

    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            HomeTopBar(selectedType = contentType, onTypeSelected = viewModel::setContentType)

            AnimatedContent(
                targetState = state,
                transitionSpec = { fadeIn() togetherWith fadeOut() }
            ) { currentState ->
                when (currentState) {
                    is HomeState.Loading -> {
                        ShimmerEffect()
                    }

                    is HomeState.Success -> {
                        val content: List<WatchContent> = when (contentType) {
                            ContentType.MOVIES -> currentState.movies
                            ContentType.TV_SHOWS -> currentState.tvShows
                        }

                        ContentGrid(
                            contents = content,
                            onItemClick = onNavigateToDetails
                        )
                    }

                    is HomeState.Error -> {
                        ErrorContent(
                            message = currentState.message,
                            onRetry = viewModel::loadContent
                        )
                    }
                }
            }
        }
    }
}