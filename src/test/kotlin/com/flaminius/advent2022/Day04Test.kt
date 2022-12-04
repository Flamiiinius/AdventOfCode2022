package com.flaminius.advent2022

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

internal class Day04Test {

    val example = """
        2-4,6-8
        2-3,4-5
        5-7,7-9
        2-8,3-7
        6-6,4-6
        2-6,4-8
    """.trimIndent()


    @Test
    @DisplayName("Day4 - Part 1: Example")
    fun solvePart1Example() {
        val input = example.split("\n")
        val result = Day04(input).solve1()
        println("Result: $result")
        assertEquals(2, result)
    }

    @Test
    @DisplayName("Day4 - Part 1: Result")
    fun solvePart1Input() {
        val input: List<String> = Resources.resourceAsListOfString("src/main/resources/day4_input.txt")
        val result = Day04(input).solve1()
        println("Result: $result")
        assertEquals(582, result)
    }

    @Test
   @DisplayName("Day4 - Part 2: Example")
   fun solvePart2Example() {
       val input = example.split("\n")
       val result = Day04(input).solve2()
       println("Result: $result")
       assertEquals(4, result)
   }

   @Test
   @DisplayName("Day4 - Part 2: Result")
   fun solvePart2Input() {
       val input: List<String> = Resources.resourceAsListOfString("src/main/resources/day4_input.txt")
       val result = Day04(input).solve2()
       println("Result: $result")
       assertEquals(893, result)
   }
}