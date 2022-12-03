package com.flaminius.advent2022

fun main() {
    val input: String = Resources.resourceAsText("src/main/resources/day1_input.txt")
    println("result 1: ${Day01(input).solve1()}")
    println("result 2: ${Day01(input).solve2()}")
}


class Day01(private val input: String) {
    private val delimiter = "\n\n"

    private fun getOrderedMap() = input.split(delimiter) // creating a list with 1 entree per elf
        .map { it.lines().sumOf(String::toInt) } // counting each elf calories
        .sortedDescending() // sorting - more calories on top

    fun solve1() = getOrderedMap().first()

    fun solve2() = getOrderedMap().take(3).sum() // take the 1st 3 results and sum them
}