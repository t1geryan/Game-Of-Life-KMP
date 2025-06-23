package com.tigeryan.gameoflife

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.defaultComponentContext
import com.tigeryan.gameoflife.presentation.App
import com.tigeryan.gameoflife.presentation.features.root.DefaultRootComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        // Always create the root component outside Compose on the main thread
        val root = DefaultRootComponent(
            componentContext = defaultComponentContext(),
        )
        setContent {
            App(rootComponent = root)
        }
    }
}
