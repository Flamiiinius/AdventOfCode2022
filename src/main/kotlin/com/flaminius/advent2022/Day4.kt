package com.flaminius.advent2022

fun main() {
    val input: List<String> = Resources.resourceAsListOfString("src/main/resources/day4_input.txt")
    println("result 1: ${Day04(input).solve1()}")
    println("result 2: ${Day04(input).solve2()}")
}

class EWork(input: String) {
    private val range: List<Int> = input.split("-").map(String::toInt)

    fun contains(other: EWork) =
        (other.range[0] <= range[0] && range[1] <= other.range[1])

    fun overlaps(other: EWork) = other.range[0] in range[0]..range[1]
}

fun List<EWork>.advContains() = this[0].contains(this[1]) || this[1].contains(this[0])
fun List<EWork>.advOverlaps() = this[0].overlaps(this[1]) || this[1].overlaps(this[0])

class Day04(private val input: List<String>) {
    private fun getEWork(str: String) = str.split(",").map { EWork(it) }

    fun solve1() = input.count { line -> getEWork(line).advContains() }

    fun solve2() = input.count { line -> getEWork(line).advOverlaps() }
}