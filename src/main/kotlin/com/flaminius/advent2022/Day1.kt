package com.flaminius.advent2022


const val fileName = "src/main/resources/day1_input.txt"

fun main() {
    val input: String = Resources.resourceAsText(fileName)
    println("result 1: ${Day01(input).getPart1Solution()}")
    println("result 1: ${Day01(input).getPart2Solution()}")
}


class Day01(private val input: String) {
    private val delimiter = "\n\n"

    private fun getOrderedMap() = input.split(delimiter) // creating a list with 1 entree per elf
        .map { it.lines().sumOf(String::toInt) } // counting each elf calories
        .sortedDescending() // sorting - more calories on top

    fun getPart1Solution() = getOrderedMap().first()

    fun getPart2Solution() = getOrderedMap().take(3).sum() // take the 1st 3 results and sum them
}