fun main() {
    fun part1(input: List<String>): Int {
        val position = Position(0, 0)

        for (s in input) {
            val (command, value) = s.split(" ")

            val amount = value.toInt()
            when (command) {
                "forward" -> position.x += amount
                "down" -> position.y += amount
                "up" -> position.y -= amount
            }
        }

        return position.final
    }

    fun part2(input: List<String>): Int {
        val position = Position(0, 0)
        var aim = 0

        for (s in input) {
            val (command, value) = s.split(" ")
            val amount = value.toInt()

            when (command) {
                "forward" -> {
                    position.x += amount
                    position.y += aim * amount
                }
                "down" -> aim += amount
                "up" -> aim -= amount
            }
        }

        return position.final
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

data class Position(var x: Int, var y: Int) {
    val final: Int
        get() = x * y
}
