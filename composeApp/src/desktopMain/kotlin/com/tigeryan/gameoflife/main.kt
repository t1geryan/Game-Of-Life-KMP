package com.tigeryan.gameoflife

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.extensions.compose.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.tigeryan.gameoflife.di.commonModules
import com.tigeryan.gameoflife.presentation.App
import com.tigeryan.gameoflife.presentation.features.root.DefaultRootComponent
import com.tigeryan.gameoflife.utils.runOnUiThread
import org.koin.core.context.startKoin

fun main() {
    val lifecycle = LifecycleRegistry()

    val rootComponent = runOnUiThread {
        DefaultRootComponent(
            componentContext = DefaultComponentContext(lifecycle = lifecycle)
        )
    }

    startKoin {
        modules(commonModules)
    }

    application {
        val windowState = rememberWindowState()

        LifecycleController(lifecycle, windowState)

        Window(
            onCloseRequest = ::exitApplication,
            state = windowState,
            title = "Game of Life",
        ) {
            App(rootComponent = rootComponent)
        }
    }
}