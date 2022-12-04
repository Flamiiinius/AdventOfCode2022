package com.flaminius.advent2022

fun main() {
    val input: List<String> = Resources.resourceAsListOfString("src/main/resources/day4_input.txt")
    println("result 1: ${Day04(input).solve1()}")
    println("result 2: ${Day04(input).solve2()}")
}

class EWork(input: String) {
    private var start: Int
    private var end: Int 

    init {
        val values = input.split("-")
        start = values[0].toInt()
        end = values[1].toInt()
    }

    fun contains(other: EWork) =
        (other.start <= start && end <= other.end)

    fun overlaps(other: EWork) = other.start in start..end
}

fun List<EWork>.advContains() = this[0].contains(this[1]) || this[1].contains(this[0])
fun List<EWork>.advOverlaps() = this[0].overlaps(this[1]) || this[1].overlaps(this[0])
fun Boolean.toInt() = if (this) 1 else 0

class Day04(private val input: List<String>) {

    private fun getEworks(str: String) = str.split(",").map { EWork(it) }

    fun solve1() = input.sumOf { line -> getEworks(line).advContains().toInt() }

    fun solve2() = input.sumOf { line -> getEworks(line).advOverlaps().toInt() }
}