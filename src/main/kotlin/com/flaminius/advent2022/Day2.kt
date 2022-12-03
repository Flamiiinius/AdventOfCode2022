package com.flaminius.advent2022

fun main() {
    val input: List<String> = Resources.resourceAsListOfString("src/main/resources/day2_input.txt")
    println("result 1: ${Day02(input).solve1()}")
    println("result 2: ${Day02(input).solve2()}")
}


class Day02(private val input: List<String>) {
    private val calculateFinalResult = mapOf(
        "A X" to 1 + 3, // Rock(them) vs Rock(me) = 1(Rock) + 3(Draw)
        "B X" to 1 + 0, // Paper(them) vs Rock(me) = 1(Rock) +0(Lose)
        "C X" to 1 + 6, // Scissors(them) vs Rock(me) = 1(Rock) + 6(Win)

        "A Y" to 2 + 6, // Rock(them) vs Paper(me) = 2(Paper) + 6(Win)
        "B Y" to 2 + 3, // Paper(them) vs Paper(me) = 2(Paper) +3(Draw)
        "C Y" to 2 + 0, // Scissors(them) vs Paper(me) = 2(Paper) + 0(Lose)

        "A Z" to 3 + 0, // Rock(them) vs Scissors(me) = 3(Scissors) + 0(Lose)
        "B Z" to 3 + 6, // Paper(them) vs Scissors(me) = 3(Scissors) + 6(Win)
        "C Z" to 3 + 3 // Scissors(them) vs Scissors(me) = 3(Scissors) + 3(Draw)
    )

    private val getExpectedPlay = mapOf(
        "A X" to "A Z", // Rock(them) -> I need to Lose -> Play Scissors
        "A Y" to "A X", // Rock(them) -> I need to Draw -> Play Rock
        "A Z" to "A Y", // Rock(them) -> I need to Win -> Play Paper

        "B X" to "B X", // Paper(them) -> I need to Lose -> Play Rock
        "B Y" to "B Y", // Paper(them) -> I need to Draw -> Play Paper
        "B Z" to "B Z", // Paper(them) -> I need to Win -> Play Scissors

        "C X" to "C Y", // Scissors(them) -> I need to Lose -> Play Paper
        "C Y" to "C Z", // Scissors(them) -> I need to Draw -> Play Scissors
        "C Z" to "C X" // Scissors(them) -> I need to Win -> Play Rock
    )

    fun solve1() = input.sumOf { line -> calculateFinalResult[line]!! }

    fun solve2() = input.sumOf { line -> calculateFinalResult[getExpectedPlay[line]!!]!! }
}