package com.example.news.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun AppDrawer(
    currentRoute: String,
    navigateToHome: () -> Unit,
    navigateToIntrests: () -> Unit,
    closeDrawer: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(Modifier.background(Color.Red).fillMaxSize()) {
        
    }
    
}