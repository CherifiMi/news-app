package com.example.news.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ListAlt
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.news.R
import com.example.news.ui.NewsDestinations


@Composable
fun AppNavRail(
    currentRoute: String,
    navigateToHome: () -> Unit,
    navigateToIntrests: () -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationRail(
        header = {
            Icon(
                painterResource(R.drawable.ic_jetnews_logo),
                null,
                Modifier.padding(vertical = 12.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        },
        modifier = modifier
    ) {
        Spacer(Modifier.weight(1f))
        NavigationRailItem(
            selected = currentRoute == NewsDestinations.HOME_ROUTE,
            onClick = navigateToHome,
            icon = { Icon(Icons.Filled.Home, stringResource(R.string.home_title)) },
            label = { Text(stringResource(R.string.home_title))},
            alwaysShowLabel = false
        )
        NavigationRailItem(
            selected = currentRoute == NewsDestinations.INTERESTS_ROUTE,
            onClick = navigateToIntrests,
            icon = { Icon(Icons.Filled.ListAlt, stringResource(R.string.interests_title)) },
            label = { Text(stringResource(R.string.interests_title))},
            alwaysShowLabel = false
        )
        Spacer(Modifier.weight(1f))
    }
}