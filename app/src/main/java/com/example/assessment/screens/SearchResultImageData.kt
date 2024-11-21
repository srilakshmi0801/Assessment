package com.example.assessment.screens

import com.example.assessment.data.models.Media

data class SearchResultImageData(
    val media : Media,
    val title: String,
    val description: String,
    val author: String,
    val publishedDate: String
)
