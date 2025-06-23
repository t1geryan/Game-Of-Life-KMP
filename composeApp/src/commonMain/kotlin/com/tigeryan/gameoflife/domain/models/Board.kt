package com.tigeryan.gameoflife.domain.models

import androidx.compose.runtime.Immutable

typealias CellPredicate = (neighborsCount: Int) -> Boolean

@Immutable
class Board(
    val width: Int,
    val height: Int,
    private val aliveCells: Set<Cell>,
    private val checkBecomeAlive: CellPredicate = defaultBecomeAlivePredicate,
    private val checkStayAlive: CellPredicate = defaultStayAlivePredicate
) {
    val isAlive: Boolean
        get() = aliveCells.isNotEmpty()

    fun getCellAlive(cell: Cell): Boolean = aliveCells.any { it.x == cell.x && it.y == cell.y }

    fun crateNextGeneration(): Board {
        val newAliveCells = mutableSetOf<Cell>()
        for (row in 0..<width) {
            for (column in 0..<height) {
                val cell = Cell(row, column)
                val neighborsCount = cell.getNeighbors(width, height).count { it in aliveCells }
                val isAlive = aliveCells.any { it.x == row && it.y == column }
                if (isAlive && checkStayAlive(neighborsCount) || checkBecomeAlive(neighborsCount)) {
                    newAliveCells.add(cell)
                }
            }
        }

        return Board(width, height, newAliveCells, checkBecomeAlive, checkStayAlive)
    }

    override fun toString(): String = buildString {
        for (row in 0..width) {
            for (column in 0..height) {
                val isAlive = getCellAlive(Cell(row, column))
                append(if (isAlive) '*' else 'o')
            }
            append('\n')
        }
        append('\n')
    }

    companion object {
        private const val DEFAULT_NEIGHBORS_TO_BECOME_ALIVE = 3
        private const val DEFAULT_MAX_NEIGHBORS_TO_STAY_ALIVE = 3
        private const val DEFAULT_MIN_NEIGHBORS_TO_STAY_ALIVE = 2

        private val defaultBecomeAlivePredicate: CellPredicate
            get() = { it == DEFAULT_NEIGHBORS_TO_BECOME_ALIVE }

        private val defaultStayAlivePredicate: CellPredicate
            get() = { it in DEFAULT_MIN_NEIGHBORS_TO_STAY_ALIVE..DEFAULT_MAX_NEIGHBORS_TO_STAY_ALIVE }
    }
}
