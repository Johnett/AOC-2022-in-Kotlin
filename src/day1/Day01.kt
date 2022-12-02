package day1

import readInput

fun main() {

    fun getCalorieList(calories: List<String>):MutableList<Int> {
        var totalCalories = 0
        val calorieSum: MutableList<Int> = mutableListOf()
        calories.forEach { calorie ->
            if (calorie.isNotBlank()) {
                totalCalories += calorie.toInt()
            } else {
                if (totalCalories != 0) calorieSum.add(totalCalories)
                totalCalories = 0
            }
        }
        if (totalCalories != 0) calorieSum.add(totalCalories)
        calorieSum.sort()
        return calorieSum
    }

    fun part1(input: List<String>): Int {
        return getCalorieList(input).last()
    }

    fun part2(input: List<String>): Int {
        return getCalorieList(input).takeLast(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day1/Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("day1/Day01")
    println(part1(input))
    println(part2(input))
}
