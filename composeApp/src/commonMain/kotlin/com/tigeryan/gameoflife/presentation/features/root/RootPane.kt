package com.tigeryan.gameoflife.presentation.features.root

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.arkivanov.decompose.router.stack.ChildStack

@Composable
internal fun RootPane(
    component: RootComponent,
    modifier: Modifier = Modifier,
) {
    val childStack by component.childStack.subscribeAsState()

    RootPane(
        childStack = childStack,
        modifier = modifier,
    )
}

@Composable
private fun RootPane(
    childStack: ChildStack<*, RootComponent.Child>,
    modifier: Modifier = Modifier,
) {
    Children(
        stack = childStack,
        animation = stackAnimation(fade()),
        modifier = modifier
    ) {

    }
}