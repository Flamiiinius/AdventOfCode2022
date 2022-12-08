package com.flaminius.advent2022

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

internal class Day06Test {

    val example = """
        mjqjpqmgbljsphdztnvjfqwrcgsmlb
        bvwbjplbgvbhsrlpgdmjqwftvncz
        nppdvjthqldpwncqszvftbrmjlhg
        nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg
        zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw
    """.trimIndent()


    @Test
    @DisplayName("Day6 - Part 1: Example")
    fun solvePart1Example() {
        val expectedResults = listOf(7, 5, 6, 10, 11)
        example.split("\n").mapIndexed { idx: Int, s: String ->
            val result = Day06(s).solve1()
            println("Result $idx: $result")
            assertEquals(expectedResults[idx], result)
        }
    }

    @Test
    @DisplayName("Day6 - Part 1: Result")
    fun solvePart1Input() {
        val input: String = Resources.resourceAsText("src/main/resources/day6_input.txt")
        val result = Day06(input).solve1()
        println("Result: $result")
        assertEquals(1356, result)
    }

    @Test
    @DisplayName("Day6 - Part 2: Example")
    fun solvePart2Example() {
        val expectedResults = listOf(19, 23, 23, 29, 26)
        example.split("\n").mapIndexed { idx: Int, s: String ->
            val result = Day06(s).solve2()
            println("Result $idx: $result")
            assertEquals(expectedResults[idx], result)
        }
    }

    @Test
    @DisplayName("Day6 - Part 2: Result")
    fun solvePart2Input() {
        val input: String = Resources.resourceAsText("src/main/resources/day6_input.txt")
        val result = Day06(input).solve2()
        println("Result: $result")
        assertEquals(2564, result)
    }
}