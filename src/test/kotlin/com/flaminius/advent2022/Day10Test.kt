package com.flaminius.advent2022

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

internal class Day10Test {

    val example = """
        addx 15
        addx -11
        addx 6
        addx -3
        addx 5
        addx -1
        addx -8
        addx 13
        addx 4
        noop
        addx -1
        addx 5
        addx -1
        addx 5
        addx -1
        addx 5
        addx -1
        addx 5
        addx -1
        addx -35
        addx 1
        addx 24
        addx -19
        addx 1
        addx 16
        addx -11
        noop
        noop
        addx 21
        addx -15
        noop
        noop
        addx -3
        addx 9
        addx 1
        addx -3
        addx 8
        addx 1
        addx 5
        noop
        noop
        noop
        noop
        noop
        addx -36
        noop
        addx 1
        addx 7
        noop
        noop
        noop
        addx 2
        addx 6
        noop
        noop
        noop
        noop
        noop
        addx 1
        noop
        noop
        addx 7
        addx 1
        noop
        addx -13
        addx 13
        addx 7
        noop
        addx 1
        addx -33
        noop
        noop
        noop
        addx 2
        noop
        noop
        noop
        addx 8
        noop
        addx -1
        addx 2
        addx 1
        noop
        addx 17
        addx -9
        addx 1
        addx 1
        addx -3
        addx 11
        noop
        noop
        addx 1
        noop
        addx 1
        noop
        noop
        addx -13
        addx -19
        addx 1
        addx 3
        addx 26
        addx -30
        addx 12
        addx -1
        addx 3
        addx 1
        noop
        noop
        noop
        addx -9
        addx 18
        addx 1
        addx 2
        noop
        noop
        addx 9
        noop
        noop
        noop
        addx -1
        addx 2
        addx -37
        addx 1
        addx 3
        noop
        addx 15
        addx -21
        addx 22
        addx -6
        addx 1
        noop
        addx 2
        addx 1
        noop
        addx -10
        noop
        noop
        addx 20
        addx 1
        addx 2
        addx 2
        addx -6
        addx -11
        noop
        noop
        noop
    """.trimIndent()
    val exampleSolPart2 = """
    ##..##..##..##..##..##..##..##..##..##..
    ###...###...###...###...###...###...###.
    ####....####....####....####....####....
    #####.....#####.....#####.....#####.....
    ######......######......######......####
    #######.......#######.......#######.....
    """.trimIndent()

    val solutionPart2 = """
        ####.###...##..###..#....####.####.#..#.
        ...#.#..#.#..#.#..#.#....#.......#.#..#.
        ..#..#..#.#..#.#..#.#....###....#..#..#.
        .#...###..####.###..#....#.....#...#..#.
        #....#.#..#..#.#.#..#....#....#....#..#.
        ####.#..#.#..#.#..#.####.#....####..##..
    """.trimIndent()

    @Test
    @DisplayName("Day10 - Part 1: Example")
    fun solvePart1Example() {
        val input = example.split("\n")
        val result = Day10(input).solve1()
        println("Result: $result")
        assertEquals(13_140, result)
    }

    @Test
    @DisplayName("Day10 - Part 1: Result")
    fun solvePart1Input() {
        val input: List<String> = Resources.resourceAsListOfString("src/main/resources/day10_input.txt")
        val result = Day10(input).solve1()
        println("Result: $result")
        assertEquals(14_220, result)
    }


    @Test
    @DisplayName("Day10 - Part 2: Example")
    fun solvePart2Example() {
        val input = example.split("\n")
        val result = Day10(input).solve2()
        println("Result:\n$result")
        assertEquals(exampleSolPart2, result)
    }

    @Test
    @DisplayName("Day10 - Part 2: Result")
    fun solvePart2Input() {
        val input: List<String> = Resources.resourceAsListOfString("src/main/resources/day10_input.txt")
        val result = Day10(input).solve2()
        println("Result:\n$result")
        assertEquals(solutionPart2, result)
    }
}