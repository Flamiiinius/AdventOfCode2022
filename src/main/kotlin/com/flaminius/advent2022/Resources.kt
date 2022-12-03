package com.flaminius.advent2022

import java.io.File

object Resources {

    // windows likes to add '/r' at end of line :/
    fun resourceAsText(fileName: String): String = File(fileName).readText().replace("\r", "")

    fun resourceAsListOfString(fileName: String): List<String> =
        File(fileName).readLines().map { it.replace("\r", "") }
}
