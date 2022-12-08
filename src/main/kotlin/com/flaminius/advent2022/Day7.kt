package com.flaminius.advent2022

fun main() {
    val input: List<String> = Resources.resourceAsListOfString("src/main/resources/day7_input.txt")
    println("result 1: ${Day07(input).solve1()}")
    println("result 2: ${Day07(input).solve2()}")
}

data class File(val name: String, val size: Long)

class Directory(val parent: Directory?) {
    val directories: MutableMap<String, Directory> = mutableMapOf()
    val files: MutableList<File> = mutableListOf()
    val size: Long get() = directories.values.sumOf { it.size } + files.sumOf { it.size }

    fun move(dir: String): Directory =
        directories.getOrPut(dir) { Directory( this) }


    fun find(predicate: (Directory) -> Boolean): List<Directory> =
        directories.values.filter(predicate) + directories.values.flatMap { it.find(predicate) }

}


fun buildFileSystem(input: List<String>): Directory {
    val fileSystem = Directory(null)
    var currentDir: Directory = fileSystem
    for (l in input) {
        when {
            l == "$ cd /" -> currentDir = fileSystem
            l == "$ ls" -> {}
            l == "$ cd .." -> {
                currentDir = currentDir.parent!!
            }

            l.startsWith("dir") -> { // dir d
                val name = l.substring(4)
                currentDir.directories.getOrPut(name) { Directory(currentDir) }
            }

            l.startsWith("$ cd") -> { // $ cd d
                val name = l.substring(5)
                currentDir = currentDir.move(name)
            }

            else -> {
                // 14848514 b.txt
                val info = l.split(" ")
                // 1st part is the size, 2nd is the name
                currentDir.files.add(File(info[1], info[0].toLong()))
            }
        }
    }
    return fileSystem
}

class Day07(val input: List<String>) {
    private val root = buildFileSystem(input)
    private val TOTAL_SPACE: Long = 70_000_000
    private val UPDATE_SIZE: Long = 30_000_000
    private val freeSpace: Long = TOTAL_SPACE - root.size
    private val spaceNeeded: Long = UPDATE_SIZE - freeSpace

    fun solve1() = root.find { it.size <= 100_000 }
        .sumOf { it.size }

    fun solve2() = root.find { it.size >= spaceNeeded }
        .minByOrNull { it.size }!!
        .size
}