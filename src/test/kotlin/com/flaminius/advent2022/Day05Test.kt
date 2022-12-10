package com.flaminius.advent2022

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

internal class Day05Test {

    val example = """
            [D]    
        [N] [C]    
        [Z] [M] [P]
         1   2   3 
        
        move 1 from 2 to 1
        move 3 from 1 to 3
        move 2 from 2 to 1
        move 1 from 1 to 2
    """.trimIndent()


    @Test
    @DisplayName("Day5 - Part 1: Example")
    fun solvePart1Example() {
        val input = example
        val result = Day05(input).solve1()
        println("Result: $result")
        assertEquals("CMZ", result)
    }
    @Test
    @DisplayName("Day5 - Part 1: Result")
    fun solvePart1Input() {
        val input: String = Resources.resourceAsText("src/main/resources/day5_input.txt")
        val result = Day05(input).solve1()
        println("Result: $result")
        assertEquals("SPFMVDTZT", result)
    }

        @Test
       @DisplayName("Day5 - Part 2: Example")
       fun solvePart2Example() {
           val input = example
           val result = Day05(input).solve2()
           println("Result: $result")
           assertEquals("MCD", result)
       }

       @Test
       @DisplayName("Day5 - Part 2: Result")
       fun solvePart2Input() {
           val input: String = Resources.resourceAsText("src/main/resources/day5_input.txt")
           val result = Day05(input).solve2()
           println("Result: $result")
           assertEquals("ZFSJBPRFP", result)
       }
}