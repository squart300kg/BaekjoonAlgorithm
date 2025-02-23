fun main() {
    val input = readln()
    var start = 0
    var count = 0

    while (start <= input.length - 1) {
        when {
            start + 2 <= input.length - 1 && "dz=" == input[start].toString() + input[start + 1] + input[start + 2] -> {
                start += 3
                count++
            }

            start + 1 <= input.length - 1 && (
                            "c=" == input[start].toString() + input[start + 1] ||
                            "c-" == input[start].toString() + input[start + 1] ||
                            "d-" == input[start].toString() + input[start + 1] ||
                            "lj" == input[start].toString() + input[start + 1] ||
                            "nj" == input[start].toString() + input[start + 1] ||
                            "s=" == input[start].toString() + input[start + 1] ||
                            "z=" == input[start].toString() + input[start + 1]) -> {
                start += 2
                count++
            }

//            else -> {
            start <= input.length - 1 && input[start].isLetter() -> {
                start += 1
                count++
            }
        }
    }
    println(count)
}