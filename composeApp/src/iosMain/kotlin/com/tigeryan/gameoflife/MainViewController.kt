package com.tigeryan.gameoflife

import androidx.compose.ui.window.ComposeUIViewController
import com.tigeryan.gameoflife.di.commonModules
import com.tigeryan.gameoflife.presentation.App
import com.tigeryan.gameoflife.presentation.features.root.RootComponent
import org.koin.core.context.startKoin

fun MainViewController(rootComponent: RootComponent) =
    ComposeUIViewController {
        App(rootComponent = rootComponent)
    }

fun doInitKoin() {
    startKoin {
        modules(commonModules)
    }
}