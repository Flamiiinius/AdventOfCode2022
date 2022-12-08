package com.flaminius.advent2022

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

internal class Day07Test {

    val example = """
        ${'$'} cd /
        ${'$'} ls
        dir a
        14848514 b.txt
        8504156 c.dat
        dir d
        ${'$'} cd a
        ${'$'} ls
        dir e
        29116 f
        2557 g
        62596 h.lst
        ${'$'} cd e
        ${'$'} ls
        584 i
        ${'$'} cd ..
        ${'$'} cd ..
        ${'$'} cd d
        ${'$'} ls
        4060174 j
        8033020 d.log
        5626152 d.ext
        7214296 k
    """.trimIndent()


    @Test
    @DisplayName("Day7 - Part 1: Example")
    fun solvePart1Example() {
        val input = example.split("\n")
        val result = Day07(input).solve1()
        println("Result: $result")
        assertEquals(95437, result)

    }

    @Test
    @DisplayName("Day7 - Part 1: Result")
    fun solvePart1Input() {
        val input: List<String> = Resources.resourceAsListOfString("src/main/resources/day7_input.txt")
        val result = Day07(input).solve1()
        println("Result: $result")
        assertEquals(1_477_771, result)
    }

    @Test
    @DisplayName("Day7 - Part 2: Example")
    fun solvePart2Example() {
        val input = example.split("\n")
        val result = Day07(input).solve2()
        println("Result: $result")
        assertEquals(24_933_642, result)
    }

    @Test
    @DisplayName("Day7 - Part 2: Result")
    fun solvePart2Input() {
        val input: List<String> = Resources.resourceAsListOfString("src/main/resources/day7_input.txt")
        val result = Day07(input).solve2()
        println("Result: $result")
        assertEquals(3_579_501, result)
    }
}