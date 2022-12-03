package com.flaminius.advent2022

fun main() {
    val input: List<String> = Resources.resourceAsListOfString("src/main/resources/day3_input.txt")
    println("result 1: ${Day03(input).solve1()}")
    println("result 2: ${Day03(input).solve2()}")
}

// add new fun to Char
// map char into challenge value
fun Char.getAdvValue(): Int {
    return if (this.isLowerCase()) {
        this - 'a' + 1
    } else {
        this - 'A' + 27
    }
}

class Day03(private val input: List<String>) {

    fun solve1() = input.sumOf { line ->
        val mid = line.length / 2 // center of rucksacks
        val right = line.substring(0, mid) // right compartment
        val left = line.substring(mid) // left compartment
        val common = right.toCharArray().intersect(left.toCharArray().asIterable()) // find common items
        common.sumOf(Char::getAdvValue) // sum all values in both halves
    }

    fun solve2() = input.chunked(3) {
        val (str1, str2, str3) = it // destruct it as 3 strs

        // extra steps - make next line smaller
        val s1 = str1.toCharArray()
        val s2 = str2.toCharArray().asIterable()
        val s3 = str3.toCharArray().asIterable()

        // intersect 3 strs
        val badge = s1.intersect(s2).intersect(s3)

        // Make as only 1 element, and return it
        badge.single()
    }.sumOf(Char::getAdvValue)
}