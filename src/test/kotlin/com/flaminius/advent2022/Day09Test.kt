package com.flaminius.advent2022

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

internal class Day09Test {

    val example = """
        R 4
        U 4
        L 3
        D 1
        R 4
        D 1
        L 5
        R 2
    """.trimIndent()

    val bigExample = """
        R 5
        U 8
        L 8
        D 3
        R 17
        D 10
        L 25
        U 20
    """.trimIndent()


    @Test
    @DisplayName("Day9 - Part 1: Example")
    fun solvePart1Example() {
        val input = example.split("\n")
        val result = Day09(input).solve1()
        println("Result: $result")
        assertEquals(13, result)
    }

    @Test
    @DisplayName("Day9 - Part 1: Result")
    fun solvePart1Input() {
        val input: List<String> = Resources.resourceAsListOfString("src/main/resources/day9_input.txt")
        val result = Day09(input).solve1()
        println("Result: $result")
        assertEquals(6081, result)
    }

    @Test
    @DisplayName("Day9 - Part 2: Example")
    fun solvePart2Example() {
        val input = bigExample.split("\n")
        val result = Day09(input).solve2()
        println("Result: $result")
        assertEquals(36, result)
    }

    @Test
    @DisplayName("Day8 - Part 2: Result")
    fun solvePart2Input() {
        val input: List<String> = Resources.resourceAsListOfString("src/main/resources/day9_input.txt")
        val result = Day09(input).solve2()
        println("Result: $result")
        assertEquals(2487, result)
    }
}