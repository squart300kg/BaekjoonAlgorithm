fun main() {
  val digitSize = readln().toInt()
  val digit = readln()
  println(digit.toCharArray().map { it.digitToInt() }.sum())
}