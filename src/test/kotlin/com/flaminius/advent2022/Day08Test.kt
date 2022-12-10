package com.flaminius.advent2022

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

internal class Day08Test {

    val example = """
        30373
        25512
        65332
        33549
        35390
    """.trimIndent()


    @Test
    @DisplayName("Day8 - Part 1: Example")
    fun solvePart1Example() {
        val input = example.split("\n")
        val result = Day08(input).solve1()
        println("Result: $result")
        assertEquals(21, result)
    }

    @Test
    @DisplayName("Day8 - Part 1: Result")
    fun solvePart1Input() {
        val input: List<String> = Resources.resourceAsListOfString("src/main/resources/day8_input.txt")
        val result = Day08(input).solve1()
        println("Result: $result")
        assertEquals(1796, result)
    }

    @Test
    @DisplayName("Day8 - Part 2: Example")
    fun solvePart2Example() {
        val input = example.split("\n")
        val result = Day08(input).solve2()
        println("Result: $result")
        assertEquals(8, result)
    }

    @Test
    @DisplayName("Day8 - Part 2: Result")
    fun solvePart2Input() {
        val input: List<String> = Resources.resourceAsListOfString("src/main/resources/day8_input.txt")
        val result = Day08(input).solve2()
        println("Result: $result")
        assertEquals(288_120, result)
    }
}