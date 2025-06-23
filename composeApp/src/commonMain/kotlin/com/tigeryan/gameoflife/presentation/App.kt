package com.tigeryan.gameoflife.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tigeryan.gameoflife.presentation.features.root.RootComponent
import com.tigeryan.gameoflife.presentation.features.root.RootPage
import com.tigeryan.gameoflife.presentation.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
internal fun App(rootComponent: RootComponent) {
    AppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize(),
        ) {
            RootPage(component = rootComponent, modifier = Modifier.fillMaxSize())
        }
    }
}