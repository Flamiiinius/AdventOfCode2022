package com.flaminius.advent2022

fun main() {
    val input: String = Resources.resourceAsText("src/main/resources/day4_input.txt")
    println("result 1: ${Day05(input).solve1()}")
    println("result 2: ${Day05(input).solve2()}")
}


// TODO full refactor

data class Instruction(val quantity: Int, val source: Int, val target: Int) {
    companion object {
        fun of(line: String) =
            Regex("[0-9]+").findAll(line)
                .map(MatchResult::value)
                .map(String::toInt)
                .toList()
                .let { Instruction(it[0], it[1] -1, it[2] -1) }

    }
}

class CargoStack {
    var stacks = mutableListOf<Char>()
    fun addAll(list: List<Char>) {
        stacks.addAll(list)
    }

    fun add(char: Char) {
        stacks.add(char)
    }

    fun take9000(int: Int): List<Char> {
        val temp = stacks
        val moving = temp.takeLast(int).reversed()
        stacks = stacks.dropLast(int).toMutableList()
        return moving
    }

    fun take9001(int: Int): List<Char> {
        val temp = stacks
        val moving = temp.takeLast(int)
        stacks = stacks.dropLast(int).toMutableList()
        return moving
    }
}

class Parser(input: String) {

    private val parts = input.split("\n\n")

    private val stacks = parts[0].split("\n")
        .subList(0, parts[0].split("\n").size)

    private val stacksSize = Regex("[0-9]+")
        .findAll(stacks.last())
        .map(MatchResult::value)
        .count()


    private var cargoStacks: List<CargoStack> = List(stacksSize) { CargoStack() }

    private val instructions: List<Instruction> = parts[1].split("\n").map { Instruction.of(it) }

    init {
        stacks.dropLast(1).reversed()
            .map { it.mapIndexed { idx: Int, char: Char -> if (char.isLetter()) cargoStacks[idx / 4].add(char) } }
    }

    fun execute9000(): Parser {
        for (ins in instructions) {
            cargoStacks[ins.target].addAll(cargoStacks[ins.source].take9000(ins.quantity))
        }
        return this
    }

    fun execute9001(): Parser {
        for (ins in instructions) {
            cargoStacks[ins.target].addAll(cargoStacks[ins.source].take9001(ins.quantity))
        }
        return this
    }

    fun getTop(): String {
        val result = mutableListOf<Char>()
        for (stack in cargoStacks) {
            result.addAll(stack.take9000(1))
        }
        return result.joinToString("")
    }
}


class Day05(private val input: String) {

    fun solve1() = Parser(input).execute9000().getTop()

    fun solve2() = Parser(input).execute9001().getTop()
}