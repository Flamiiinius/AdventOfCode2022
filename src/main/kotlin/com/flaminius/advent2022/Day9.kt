package com.flaminius.advent2022

import java.security.InvalidKeyException

fun main() {
    val input: List<String> = Resources.resourceAsListOfString("src/main/resources/day9_input.txt")
    println("result 1: ${Day09(input).solve1()}")
    println("result 2: ${Day09(input).solve2()}")
}

enum class Direction {
    UP, RIGHT, LEFT, DOWN
}

fun String.toDirection(): Direction {
    return when (this) {
        "R" -> Direction.RIGHT
        "U" -> Direction.UP
        "L" -> Direction.LEFT
        "D" -> Direction.DOWN
        else -> throw InvalidKeyException("Unexpected Direction: $this")
    }
}

data class Coordinates(var x: Int, var y: Int)

fun Coordinates.shouldMove(other: Coordinates) = (this.x - other.x) !in -1..1 || (this.y - other.y) !in -1..1

fun Coordinates.moveCloseTo(other: Coordinates) {
    this.x += x.getCloser(other.x)
    this.y += y.getCloser(other.y)
}

fun Int.getCloser(target: Int): Int {
    val diff = target - this
    return if (diff % 2 == 0) diff / 2 else {
        if (diff > 0) 1 else (-1)
    }
}

class Day09(val input: List<String>) {
    private val headMoves = input
    private var head = Coordinates(0, 0)

    // part 1 this can be a listOf1 or a single element and adjust moveNextKnot
    private var knotsPos: MutableList<Coordinates> = mutableListOf(
        Coordinates(0, 0), Coordinates(0, 0), Coordinates(0, 0),
        Coordinates(0, 0), Coordinates(0, 0), Coordinates(0, 0),
        Coordinates(0, 0), Coordinates(0, 0), Coordinates(0, 0),
    )

    // part 1 this can be a listOf1 or a single element and adjust moveNextKnot
    private val knotsUniquePath: List<MutableSet<Coordinates>> = listOf(
        mutableSetOf(), mutableSetOf(), mutableSetOf(),
        mutableSetOf(), mutableSetOf(), mutableSetOf(),
        mutableSetOf(), mutableSetOf(), mutableSetOf()
    )

    init {
        // add starting position
        for (i in knotsPos.indices) {
            knotsUniquePath[i].add(knotsPos[i])
        }
        // execute input
        headMoves.map {
            //R 4 -> direction = R  moves = 4
            val i = it.split(" ")
            moveHead(i[0].toDirection(), i[1].toInt())
        }
    }

    fun solve1() = knotsUniquePath[0].count()
    fun solve2() = knotsUniquePath[8].count()


    private fun moveHead(dir: Direction, moves: Int) {
        for (i in 0 until moves) {
            head = when (dir) {
                Direction.UP -> Coordinates(head.x - 1, head.y)
                Direction.DOWN -> Coordinates(head.x + 1, head.y)
                Direction.LEFT -> Coordinates(head.x, head.y - 1)
                Direction.RIGHT -> Coordinates(head.x, head.y + 1)
            }
            moveNextKnot(head, 0)
        }
    }

    private fun moveNextKnot(previousKnot: Coordinates, currentKnotIdx: Int) {
        val currentKnot: Coordinates = knotsPos[currentKnotIdx]
        if (currentKnot.shouldMove(previousKnot)) {
            currentKnot.moveCloseTo(previousKnot)
            knotsPos[currentKnotIdx] = currentKnot.copy()
            knotsUniquePath[currentKnotIdx].add(currentKnot.copy())
            if (currentKnotIdx != knotsPos.size - 1) moveNextKnot(currentKnot, currentKnotIdx + 1)
        }
    }
}