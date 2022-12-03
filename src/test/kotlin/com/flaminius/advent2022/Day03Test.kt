package com.flaminius.advent2022

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

internal class Day03Test {

    val example = """
        vJrwpWtwJgWrhcsFMMfFFhFp
        jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
        PmmdzqPrVvPwwTWBwg
        wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
        ttgJtRGJQctTZtZT
        CrZsJsPPZsGzwwsLwLmpwMDw
    """.trimIndent()


    @Test
    @DisplayName("Day3 - Part 1: Example")
    fun solvePart1Example() {
        val input = example.split("\n")
        val result = Day03(input).solve1()
        println("Result: $result")
        assertEquals(157, result)
    }

    @Test
    @DisplayName("Day3 - Part 1: Result")
    fun solvePart1Input() {
        val input: List<String> = Resources.resourceAsListOfString("src/main/resources/day3_input.txt")
        val result = Day03(input).solve1()
        println("Result: $result")
        assertEquals(8_123, result)
    }

    @Test
    @DisplayName("Day3 - Part 2: Example")
    fun solvePart2Example() {
        val input = example.split("\n")
        val result = Day03(input).solve2()
        println("Result: $result")
        assertEquals(70, result)
    }

    @Test
    @DisplayName("Day3 - Part 2: Result")
    fun solvePart2Input() {
        val input: List<String> = Resources.resourceAsListOfString("src/main/resources/day3_input.txt")
        val result = Day03(input).solve2()
        println("Result: $result")
        assertEquals(2_620, result)
    }
}