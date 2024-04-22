fun main() {
    val (N, S) = readln().split(' ').map { it.toInt() }
    val sequences = readln().split(' ').map { if (it.toInt() >= S) { println(1); return } else it.toInt() }
    val accumeratedSequence = Array(N + 1) { 0 }
    var result = 100001

    for (index in 1 until N + 1) {
        accumeratedSequence[index] = sequences[index - 1] + accumeratedSequence[index - 1]
    }

    var start = 0
    var end = 1
    while (end <= N) {
        if (accumeratedSequence[end] - accumeratedSequence[start] >= S) {
            result = minOf(result, end - start)
            start++
        } else {
            end++
        }
    }

    println(if (result == 100001) 0 else result)
}