package com.flaminius.advent2022

fun main() {
    val input: List<String> = Resources.resourceAsListOfString("src/main/resources/day10_input.txt")
    println("result 1: ${Day10(input).solve1()}")
    println("result 2: \n${Day10(input).solve2()}")
}

class Day10(val input: List<String>) {
    private val cycles: MutableList<Int> = mutableListOf()
    private val crt: MutableList<Char> = mutableListOf()
    private var current = 1

    init {
        for (i in input.indices) {
            // part 1 was cycles.add(current) instead of finishCycle(current)
            if (input[i] == "noop") finishCycle(current)
            else {
                finishCycle(current)
                finishCycle(current)
                current += input[i].split(" ").last().toInt()
            }
        }
    }

    fun solve1() = cycles.strengthAt(20) +
            cycles.strengthAt(60) +
            cycles.strengthAt(100) +
            cycles.strengthAt(140) +
            cycles.strengthAt(180) +
            cycles.strengthAt(220)

    fun solve2() = crt.format()

    // 1st part
    private fun MutableList<Int>.strengthAt(idx: Int) = this[idx - 1] * idx


    // 2nd part
    private fun finishCycle(v: Int) {
        if (cycles.size % 40 in current - 1..current + 1) crt.add('#')
        else crt.add('.')
        cycles.add(v)
    }

    private fun MutableList<Char>.format(): String {
        var s = ""
        s += crt.subList(0, 40).joinToString("") + "\n"
        s += crt.subList(40, 80).joinToString("") + "\n"
        s += crt.subList(80, 120).joinToString("") + "\n"
        s += crt.subList(120, 160).joinToString("") + "\n"
        s += crt.subList(160, 200).joinToString("") + "\n"
        s += crt.subList(200, 240).joinToString("")
        return s
    }


}