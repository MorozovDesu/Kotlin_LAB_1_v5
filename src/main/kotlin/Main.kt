// Даны целые числа a1, a2, a3 .... an.
// Выяснить есть ли среди них повторяющиеся числа и найти среднее арифметическое без учета повторов


fun main() {
    var inputValid = false
    var numbers: List<Int> = listOf()

    while (!inputValid) {
        try {
            println("Введите целые числа через пробел:")
            val input = readLine() ?: throw IllegalArgumentException("Ошибка ввода")

            numbers = input.split(" ").map { it.toInt() }

            if (numbers.all { it.toString().matches(Regex("^-?\\d+$")) }) {
                inputValid = true
            } else {
                println("Ошибка ввода. Пожалуйста, введите только целые числа через пробел.")
            }
        } catch (e: NumberFormatException) {
            println("Ошибка ввода. Пожалуйста, введите только целые числа через пробел.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    val distinctNumbers = numbers.distinct()
    val average = distinctNumbers.sum().toDouble() / distinctNumbers.size

    if (numbers.size != distinctNumbers.size) {
        println("Есть повторяющиеся числа")
    } else {
        println("Повторяющихся чисел нет")
    }

    println("Среднее арифметическое без учета повторов: $average")
}
