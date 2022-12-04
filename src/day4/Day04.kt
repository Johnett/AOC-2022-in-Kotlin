package day4

import readInput

fun main() {
    fun getSectionRangePair(assignments: String): Pair<IntRange, IntRange> {
        fun getRange(values: Pair<Int, Int>): IntRange = values.first..values.second

        val sectionRanges = assignments.split(",").map { sections ->
            sections.split("-").let { section ->
                Pair(section.first().toInt(), section.last().toInt())
            }
        }
        return Pair(getRange(sectionRanges.first()), getRange(sectionRanges.last()))
    }

    fun assignmentContains(pair: Pair<IntRange, IntRange>): Boolean =
        (pair.first.first <= pair.second.first && pair.first.last >= pair.second.last) || (pair.second.first <= pair.first.first && pair.second.last >= pair.first.last)

    fun assignmentOverlaps(pair: Pair<IntRange, IntRange>): Boolean =
        pair.first.first in pair.second || (pair.first.last in pair.second && pair.second.first in pair.first) || pair.second.last in pair.first

    fun part1(input: List<String>): Int {
        var pairCount = 0
        input.forEach { assignments ->
            if (assignmentContains(getSectionRangePair(assignments))) pairCount++
        }
        return pairCount
    }

    fun part2(input: List<String>): Int {
        var pairCount = 0
        input.forEach { assignments ->
            if (assignmentOverlaps(getSectionRangePair(assignments))) pairCount++
        }
        return pairCount
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day4/Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("day4/Day04")
    println(part1(input))
    println(part2(input))
}
