import java.lang.StringBuilder

fun main() {
    val (tableSize, sumCount) = readln().split(' ').run { get(0).toInt() to get(1).toInt() }
    val accumeratedTable = Array(tableSize + 1) { Array(tableSize + 1) { 0 } }
    val sb = StringBuilder()

    for (outterIndex in 1 .. tableSize) {

        val tableRow = readln().split(' ').map { it.toInt() }
        for (innerIndex in 1 .. tableSize) {
            accumeratedTable[outterIndex][innerIndex] = tableRow[innerIndex - 1] + (accumeratedTable[outterIndex][innerIndex - 1] + accumeratedTable[outterIndex - 1][innerIndex]) - accumeratedTable[outterIndex - 1][innerIndex - 1]
        }
    }

    for (index in 0 until sumCount) {
        val (x1, y1, x2, y2) = readln()
            .split(' ')
            .map { it.toInt() }

        sb.append("${accumeratedTable[x2][y2] - accumeratedTable[x2][y1 - 1] - accumeratedTable[x1 - 1][y2] + accumeratedTable[x1 - 1][y1 - 1]}\n")
    }
    println(sb)
}