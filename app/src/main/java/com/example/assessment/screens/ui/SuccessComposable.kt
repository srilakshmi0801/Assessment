package com.example.assessment.screens.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.assessment.data.models.Image
import com.example.assessment.screens.UIState

@Composable
fun SuccessComposable(
    success: UIState.Success,
    imageDetails: (Image) -> Unit
){
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {

        items(success.response.items) {
            AsyncImage(
                model = it.media.m,
                contentDescription = null,
                alignment = Alignment.Center,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.padding(16.dp)
                    .clickable {
                      imageDetails(it)
                    }
            )
        }
    }
}