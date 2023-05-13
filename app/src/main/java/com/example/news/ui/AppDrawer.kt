package com.example.news.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.news.R
import com.example.news.theme.NewsTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDrawer(
    currentRoute: String,
    navigateToHome: () -> Unit,
    navigateToIntrests: () -> Unit,
    closeDrawer: () -> Unit,
    modifier: Modifier = Modifier
) {
    ModalDrawerSheet(modifier) {
        NewsLogo(
            modifier = Modifier.padding(horizontal = 28.dp, vertical = 24.dp)
        )
        NavigationDrawerItem(
            label = { Text(stringResource(id = R.string.home_title)) },
            selected = currentRoute == NewsDestinations.HOME_ROUTE,
            onClick = { navigateToHome();closeDrawer()},
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
    }
}

@Composable
fun NewsLogo(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Icon(
            painter = painterResource(id = R.drawable.ic_jetnews_logo),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.width(8.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_jetnews_logo),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}