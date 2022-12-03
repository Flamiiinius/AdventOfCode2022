package com.flaminius.advent2022

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

internal class Day02Test {

    val example = """
        A Y
        B X
        C Z
    """.trimIndent()

    @Test
    @DisplayName("Day2 - Part 1: Example")
    fun solvePart1Example() {
        val input = example.split("\n")
        val result = Day02(input).solve1()
        println("Result: $result")
        assertEquals(15, result)
    }

    @Test
    @DisplayName("Day2 - Part 1: Result")
    fun solvePart1Input() {
        val input: List<String> = Resources.resourceAsListOfString("src/main/resources/day2_input.txt")
        val result = Day02(input).solve1()
        println("Result: $result")
        assertEquals(10_310, result)
    }

    @Test
    @DisplayName("Day2 - Part 2: Example")
    fun solvePart2Example() {
        val input = example.split("\n")
        val result = Day02(input).solve2()
        println("Result: $result")
        assertEquals(12, result)
    }

    @Test
    @DisplayName("Day2 - Part 2: Result")
    fun solvePart2Input() {
        val input: List<String> = Resources.resourceAsListOfString("src/main/resources/day2_input.txt")
        val result = Day02(input).solve2()
        println("Result: $result")
        assertEquals(14_859, result)
    }
}