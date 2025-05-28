package com.tigeryan.gameoflife.domain.models

import androidx.compose.runtime.Immutable

@Immutable
data class Cell(
    val x: Int,
    val y: Int,
) {
    fun getNeighbors(width: Int, height: Int): List<Cell> =
        neighborOffsets.map { (dx, dy) ->
            val nx = (x + dx + width) % width
            val ny = (y + dy + height) % height
            Cell(nx, ny)
        }

    companion object {
        private val neighborOffsets = setOf(
            -1 to -1, 0 to -1, 1 to -1,
            -1 to 0, 1 to 0,
            -1 to 1, 0 to 1, 1 to 1,
        )
    }
}
