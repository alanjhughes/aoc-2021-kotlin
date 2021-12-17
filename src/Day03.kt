
val input = readInput("Day03")
val bitIndices = input[0].indices

fun String.invertBinary() = this.map { if (it == '0') '1' else '0' }.joinToString("")
fun List<String>.countBitsInColumn(index: Int) = this.groupingBy { it[index] }.eachCount()

fun List<String>.filterColumns(filterBy: (zeroes: Int, ones: Int) -> Char): String {
    var columns = this
    for (column in indices) {
        val charFrequencyByColumn = columns.countBitsInColumn(column)
        val zeroes = charFrequencyByColumn['0'] ?: 0
        val ones = charFrequencyByColumn['1'] ?: 0
        columns = columns.filter { it[column] == filterBy(zeroes, ones) }
        if (columns.size == 1) break
    }
    return columns.single()
}

fun main() {
    fun part1(input: List<String>): Int {
        val gamma = buildString {
            for (i in bitIndices) {
                val column = input.countBitsInColumn(i)
                    .maxByOrNull { it.value }?.key ?: error("Invalid value")
                append(column)
            }
        }
        val epsilon = gamma.invertBinary()
        return gamma.toInt(2) * epsilon.toInt(2)
    }

    fun part2(input: List<String>): Int {
        val oxygenRating = input.filterColumns { zeroes, ones ->
            if (zeroes > ones) '0' else '1'
        }

        val co2Rating = input.filterColumns { zeroes, ones ->
            if (zeroes > ones) '1' else '0'
        }

        return oxygenRating.toInt(2) * co2Rating.toInt(2)
    }

    println(part1(input))
    println(part2(input))
}


