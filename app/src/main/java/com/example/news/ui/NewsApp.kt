package com.example.news.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.news.data.AppContainer
import com.example.news.theme.NewsTheme


@Composable
fun NewsApp(
    appContainer: AppContainer,
    widthSizeClass: WindowWidthSizeClass
) {
    NewsTheme() {
        Surface() {
            Column(Modifier.fillMaxSize().background(Color.Blue)) {
                Text(text = "hillo")
            }
        }
    }
}