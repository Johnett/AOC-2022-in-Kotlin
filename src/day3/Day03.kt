package day3

import readInput

fun main() {
    fun Char.getPriorityValue(): Int = when (this) {
        in 'a'..'z' -> (this - 'a') + 1
        in 'A'..'Z' -> (this - 'A') + 27
        else -> error("Item not found")
    }

    fun part1(input: List<String>): Int = input.map { content ->
        val (firstCompartment, secondCompartment) = content.chunked(content.length / 2) { item -> item.toSet() }
        firstCompartment.intersect(secondCompartment).first()
    }.sumOf { commonItem ->
        commonItem.getPriorityValue()
    }

    fun part2(input: List<String>): Int =
        input.chunked(3).map { items ->
            val (itemOne, itemTwo, itemThree) = items.map { item -> item.toSet() }
            itemOne.intersect(itemTwo).intersect(itemThree).first()
        }.sumOf { commonItem ->
            commonItem.getPriorityValue()
        }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day3/Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("day3/Day03")
    println(part1(input))
    println(part2(input))
}
