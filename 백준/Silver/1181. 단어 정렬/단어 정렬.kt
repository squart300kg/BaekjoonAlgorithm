fun main() {
    val input = readln().toInt()
    val words = mutableListOf<String>()

    for (index in 0 until input) {
        words.add(readln())
    }

    words.sortedWith(
        compareBy<String>({ it.length })
            .thenBy { it }
    ).toSet().forEach {
        println(it)
    }
}