import java.lang.StringBuilder

fun main() {
    val (tableSize, sumCount) = readln().split(' ').run { get(0).toInt() to get(1).toInt() }
    val accumeratedTable = Array(tableSize) { Array(tableSize) { 0 } }
    val sb = StringBuilder()

    for (outterIndex in 0 until tableSize) {
        val tableRow = readln().split(' ').map { it.toInt() }
        for (innerIndex in 0 until tableSize) {
            if (outterIndex == 0 && innerIndex == 0) {
                accumeratedTable[0][0] = tableRow[0]
            } else if (outterIndex == 0) {
                accumeratedTable[outterIndex][innerIndex] = accumeratedTable[outterIndex][innerIndex - 1] + tableRow[innerIndex]
            } else if (innerIndex == 0) {
                accumeratedTable[outterIndex][innerIndex] = accumeratedTable[outterIndex - 1][innerIndex] + tableRow[innerIndex]
            } else {
                accumeratedTable[outterIndex][innerIndex] = accumeratedTable[outterIndex - 1][innerIndex] + accumeratedTable[outterIndex][innerIndex - 1] - accumeratedTable[outterIndex - 1][innerIndex - 1] + tableRow[innerIndex]
            }
        }
    }

    for (index in 0 until sumCount) {
        val (x1, y1, x2, y2) = readln()
            .split(' ')
            .map { it.toInt() - 1 }
            .run { listOf(get(0), get(1), get(2), get(3)) }

        if (x1 == 0 && y1 == 0) {
            sb.append("${accumeratedTable[x2][y2]}\n")
        } else if (x1 == 0) {
            sb.append("${accumeratedTable[x2][y2] - accumeratedTable[x2][y1 - 1]}\n")
        } else if (y1 == 0) {
            sb.append("${accumeratedTable[x2][y2] - accumeratedTable[x1 - 1][y2]}\n")
        } else {
            sb.append("${accumeratedTable[x2][y2] - accumeratedTable[x2][y1 - 1] - accumeratedTable[x1 - 1][y2] + accumeratedTable[x1 - 1][y1 - 1]}\n")
        }
    }
    println(sb)
}