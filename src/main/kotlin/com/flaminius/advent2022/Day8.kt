package com.flaminius.advent2022

fun main() {
    val input: List<String> = Resources.resourceAsListOfString("src/main/resources/day8_input.txt")
    println("Result 1: ${Day08(input).solve1()}")
    println("Result 2: ${Day08(input).solve2()}")
}

data class Tree(val area: Forest, val h: Int, val i: Int, val j: Int)

// TODO instead of checking all 4 sides in 4 diff functions do 1 abs function 2x


fun Tree.isSeenFromLeft(): Boolean {
    var maxHeighInLine = 0
    for (k in 0 until j) {
        if (maxHeighInLine < area.matrix[i][k].h) maxHeighInLine = area.matrix[i][k].h
    }
    return maxHeighInLine < h
}

fun Tree.isSeenFromRight(): Boolean {
    var maxHeighInLine = 0
    for (k in j + 1 until area.width) {
        if (maxHeighInLine < area.matrix[i][k].h) maxHeighInLine = area.matrix[i][k].h
    }
    return maxHeighInLine < h
}

fun Tree.isSeenFromTop(): Boolean {
    var maxHeighInLine = 0
    for (k in 0 until i) {
        if (maxHeighInLine < area.matrix[k][j].h) maxHeighInLine = area.matrix[k][j].h
    }
    return maxHeighInLine < h
}

fun Tree.isSeenFromBottom(): Boolean {
    var maxHeighInLine = 0
    for (k in i + 1 until area.length) {
        if (maxHeighInLine < area.matrix[k][j].h) maxHeighInLine = area.matrix[k][j].h
    }
    return maxHeighInLine < h
}

fun Tree.scenicScoreTop(): Int {
    if (i == 0) return 0
    var r = 1
    while ((i - r > 0) && (h > area.matrix[i - r][j].h)) {
        r++
    }
    return r
}

fun Tree.scenicScoreBot(): Int {
    if (i == area.length - 1) return 0
    var r = 1
    while ((i + r < area.length - 1) && (h > area.matrix[i + r][j].h)) {
        r++
    }
    return r
}

fun Tree.scenicScoreLeft(): Int {
    if (j == 0) return 0
    var r = 1
    while ((j - r > 0) && (h > area.matrix[i][j - r].h)) {
        r++
    }
    return r
}

fun Tree.scenicScoreRight(): Int {
    if (j == area.width - 1) return 0
    var r = 1
    while ((j + r < area.width - 1) && (h > area.matrix[i][j + r].h)) {
        r++
    }
    return r
}

fun Tree.scenicScore() = this.scenicScoreTop() * this.scenicScoreBot() * this.scenicScoreLeft() * this.scenicScoreRight()


fun Tree.isVisible(): Boolean {
    // is in the corners
    if (i == 0 || i == area.length - 1) return true
    if (j == 0 || j == area.width - 1) return true

    // check 4 sides until smaller or edge
    if (this.isSeenFromTop()) return true
    if (this.isSeenFromBottom()) return true
    if (this.isSeenFromLeft()) return true
    if (this.isSeenFromRight()) return true

    return false
}

data class Forest(val input: List<String>) {
    val length = input.size
    val width = input[0].length
    val matrix: MutableList<MutableList<Tree>> = mutableListOf()

    init {
        for (i in 0 until length) {
            matrix.add(mutableListOf())
            for (j in 0 until width) {
                matrix[i].add(Tree(this, input[i][j] - '0', i, j))
            }
        }
    }

    fun getVisibleTrees(): List<Tree> {
        val l = mutableListOf<Tree>()
        for (i in 0 until length) {
            for (j in 0 until width) {
                if (matrix[i][j].isVisible()) l.add(matrix[i][j])
            }
        }
        return l
    }

    fun getAllTrees(): List<Tree> {
        val l = mutableListOf<Tree>()
        for (i in 0 until length) {
            for (j in 0 until width) {
                l.add(matrix[i][j])
            }
        }
        return l
    }
}


class Day08(val input: List<String>) {
    private val forestMatrix = Forest(input)
    fun solve1() = forestMatrix.getVisibleTrees().count()

    fun solve2() = forestMatrix.getAllTrees().maxOf(Tree::scenicScore)

}