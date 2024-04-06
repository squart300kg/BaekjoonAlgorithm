import java.lang.StringBuilder

fun main() {
    val sumCount = readln().split(' ').run { get(1).toInt() }
    val numbers = readln().split(' ').map { it.toInt() }
    val accumeratedNumbers = mutableListOf<Int>()
    val sb = StringBuilder()

    for (index in numbers.indices) {
        if (index == 0) accumeratedNumbers.add(numbers[0])
        else {
            accumeratedNumbers.add(accumeratedNumbers[index - 1] + numbers[index])
        }
    }

    for (index in 0 until sumCount) {
        val range = readln().split(' ').run { listOf(get(0).toInt(), get(1).toInt()) }
        val start = range[0]
        val end = range[1]

        val result = if (start == 1) accumeratedNumbers[end - 1]
        else accumeratedNumbers[end - 1] - accumeratedNumbers[start - 2]

        sb.append("$result\n")
    }
    print(sb)
}