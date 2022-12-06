package day6

import readInput

fun main() {

    fun findSomMarker(dataStream: List<String>, charCount: Int): Int =
        dataStream.first().windowed(charCount).indexOfFirst { currentCharacters ->
            currentCharacters.toSet().size == charCount
        } + charCount

    fun part1(input: List<String>): Int {
        return findSomMarker(input, 4)
    }

    fun part2(input: List<String>): Int {
        return findSomMarker(input, 14)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day6/Day06_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 19)

    val input = readInput("day6/Day06")
    println(part1(input))
    println(part2(input))
}
