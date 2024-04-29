fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val sequences = readln().split(' ').map { it.toInt() }
    var result = 0

    val accumeratedSequences = Array(n + 1) { 0 }
    for (index in 1 until n + 1) {
        accumeratedSequences[index] = sequences[index - 1] + accumeratedSequences[index - 1]
    }

    var start = 0
    var end = 1

    while (end < n + 1) {
        if (accumeratedSequences[end] - accumeratedSequences[start] < m) {
            end++
        } else if (accumeratedSequences[end] - accumeratedSequences[start] == m) {
            result++
            end++
        } else {
            start++
        }
    }

    println(result)
}