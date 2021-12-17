fun main() {
    fun part1(input: List<Int>): Int {
        return reduceValues(input)
    }

    fun part2(input: List<Int>): Int {
        val result = input.windowed(3)
            .map { it.sum() }
        return reduceValues(result)
    }

    val testInput = readInput("Day01_test").map { it.toInt() }
    check(part1(testInput) == 7)

    val input = readInput("Day01").map { it.toInt() }
    println(part1(input))
    println(part2(input))
}

fun reduceValues(input: List<Int>): Int {
    return input.windowed(2).count { (a, b) -> b > a }
}

