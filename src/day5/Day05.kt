package day5

import readInput

fun main() {

    fun rearrangeCrates(isCrateMover9001: Boolean, values: List<String>): String {
        val crateValues = values.takeWhile { createValue ->
            createValue.contains("[")
        }.map {
            it.replace("[", "")
                .replace("]", "")
                .replace("    ", " ")
                .split(" ")
        }
        val instructions = values.dropWhile {value->
            !value.contains("from")
        }.map {rawInstruction->
            rawInstruction.replace("move", "")
                .replace("from", "")
                .replace("to", "")
                .replace("  ", " ")
                .trim()
                .split(" ").map { instruction ->
                    instruction.toInt()
                }
        }

        val crateStacks: MutableMap<Int, List<String>> = mutableMapOf()
        crateValues.forEach { createValue ->
            createValue.forEachIndexed { index, crate ->
                if (crate.isEmpty()) return@forEachIndexed
                crateStacks[index + 1] = (crateStacks[index + 1] ?: listOf()) + crate
            }
        }

        instructions.forEach { instruction ->
            val (move, from, to) = instruction
            if (!isCrateMover9001) crateStacks[to] =
                crateStacks[from]!!.take(move).reversed() + crateStacks[to]!! else crateStacks[to] =
                crateStacks[from]!!.take(move) + crateStacks[to]!!
            crateStacks[from] = crateStacks[from]!!.drop(move)
        }

        return crateStacks.toSortedMap().map {crateStack->
            crateStack.value.first()
        }.joinToString("")
    }


    fun part1(input: List<String>): String {
        return rearrangeCrates(false, input)
    }

    fun part2(input: List<String>): String {
        return rearrangeCrates(true, input)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day5/Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = readInput("day5/Day05")
    println(part1(input))
    println(part2(input))
}
