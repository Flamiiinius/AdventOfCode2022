package com.flaminius.advent2022

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

internal class Day01Test {
    val example = """
        1000
        2000
        3000
        
        4000
        
        5000
        6000
        
        7000
        8000
        9000
        
        10000
    """.trimIndent()

    @Test
    @DisplayName("Day1 - Part 1: Example")
    fun solvePart1Example() {
        val input = example
        val result = Day01(input).solve1()
        println("Result: $result")
        assertEquals(24_000, result)
    }

    @Test
    @DisplayName("Day1 - Part 1: Result")
    fun solvePart1Input() {
        val input: String = Resources.resourceAsText("src/main/resources/day1_input.txt")
        val result = Day01(input).solve1()
        println("Result: $result")
        assertEquals(74_394, result)
    }

    @Test
    @DisplayName("Day1 - Part 2: Example")
    fun solvePart2Example() {
        val input = example
        val result = Day01(input).solve2()
        println("Result: $result")
        assertEquals(45_000, result)
    }

    @Test
    @DisplayName("Day1 - Part 2: Result")
    fun solvePart2Input() {
        val input: String = Resources.resourceAsText("src/main/resources/day1_input.txt")
        val result = Day01(input).solve2()
        println("Result: $result")
        assertEquals(212_836, result)
    }
}