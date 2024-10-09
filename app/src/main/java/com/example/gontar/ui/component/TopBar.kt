package com.example.gontar.ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarScreen(
    title: @Composable () -> Unit,
    navigationIcon: @Composable (() -> Unit)? = null,
    content: @Composable (Modifier) -> Unit // Add a content parameter
) {
    Scaffold(
        topBar = {
            if (navigationIcon != null) {
                TopAppBar(
                    title = title,
                    navigationIcon = navigationIcon,
                )
            }
        }
    ) { innerPadding ->
        // Provide innerPadding to the content area
        content(Modifier.padding(innerPadding)) // Use the content parameter
    }
}
