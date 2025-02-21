fun main() {
  val wordCount = readln().toInt()
  var groupWordCount = 0

  for (outterIndex in 0 until wordCount) {
    val word = readln()
    val chars = mutableMapOf<Char, Int>()

    for (char in word) {
      chars[char] = chars.getOrDefault(char, 0) + 1
    }

    val multiChars = chars.filterValues { it >= 2 }
    if (chars.filterValues { it >= 2 }.isNotEmpty()) {
      outter@ for (outterIndex in 0 until multiChars.keys.size) {
        val char = multiChars.keys.toList()[outterIndex]
        val firstIndex = word.indexOfFirst { it == char }
        val lastIndex = word.indexOfLast { it == char }

        if (lastIndex - firstIndex >= 1) {
          inner@for (innerIndex in firstIndex until lastIndex) {
            if (word[innerIndex] != word[innerIndex + 1]) break@outter
          }
        }

        if (outterIndex == multiChars.keys.size - 1) {
          groupWordCount++
        }
      }
    } else {
      groupWordCount++
    }
  }
  println(groupWordCount)
}