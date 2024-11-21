package com.example.assessment.screens.ui

import android.text.Html
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.assessment.R
import com.example.assessment.screens.SearchResultImageData

@Composable
fun ImageDetailsComposable(
    searchResultImageData: SearchResultImageData
) {

    Column(modifier = Modifier.fillMaxSize()) {

        AsyncImage(
            model = searchResultImageData.media.m,
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)
        )
        Row(
            modifier= Modifier.fillMaxWidth()
        ) {
            Text(
                text = searchResultImageData.title,
                style = MaterialTheme.typography.titleMedium
            )
        }

        Row(
            modifier= Modifier.fillMaxWidth()
        ) {

            Text(
                text = Html.fromHtml(searchResultImageData.description, Html.FROM_HTML_MODE_LEGACY).toString(),
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Row(
            modifier= Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.author),
                modifier = Modifier.weight(0.5f))
            Text(text = searchResultImageData.author,
                modifier = Modifier.weight(0.5f))
        }
        Row(
            modifier= Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.published_date),
                modifier = Modifier.weight(0.5f))
            Text(text = searchResultImageData.publishedDate,
                modifier = Modifier.weight(0.5f))
        }
    }
}