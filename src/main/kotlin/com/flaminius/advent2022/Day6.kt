package com.flaminius.advent2022

fun main() {
    val input: String = Resources.resourceAsText("src/main/resources/day6_input.txt")
    println("result 1: ${Day06(input).solve1()}")
    println("result 2: ${Day06(input).solve2()}")
}


fun String.allUnique(): Boolean = all(hashSetOf<Char>()::add)

fun findUniqueIndex(input: String, distinct: Int): Int {
    // can be optimized
    for (i in 0..input.length) {
        if (input.substring(i, i + distinct).allUnique()) {
            return i + distinct
        }
    }
    return -1
}

class Day06(private val input: String) {

    fun solve1() = findUniqueIndex(input, 4)
    fun solve2() = findUniqueIndex(input, 14)
}