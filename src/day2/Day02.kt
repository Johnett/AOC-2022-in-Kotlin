package day2

import readInput

fun main() {

    fun part1(input: List<String>): Int {
        var total = 0
        input.forEach { round ->
            val opponentChoice = round.first()
            val yourChoice = round.last()

            total += when (yourChoice) {
                'X' -> when (opponentChoice) {
                    'A' -> 3
                    'B' -> 0
                    else -> 6
                }.plus(1)

                'Y' -> when (opponentChoice) {
                    'A' -> 6
                    'B' -> 3
                    else -> 0
                }.plus(2)

                else -> when (opponentChoice) {
                    'A' -> 0
                    'B' -> 6
                    else -> 3
                }.plus(3)
            }
        }
        return total
    }

    fun part2(input: List<String>): Int {
        var total = 0
        input.forEach { round ->
            val opponentChoice = round.first()
            val yourChoice = round.last()

            total += when (yourChoice) {
                'X' -> when (opponentChoice) {
                    'A' -> 3
                    'B' -> 1
                    else -> 2
                }.plus(0)

                'Y' -> when (opponentChoice) {
                    'A' -> 1
                    'B' -> 2
                    else -> 3
                }.plus(3)

                else -> when (opponentChoice) {
                    'A' -> 2
                    'B' -> 3
                    else -> 1
                }.plus(6)
            }
        }
        return total
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day2/Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("day2/Day02")
    println(part1(input))
    println(part2(input))
}
