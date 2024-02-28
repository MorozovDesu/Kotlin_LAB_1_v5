// Даны целые числа a1, a2, a3 .... an.
// Выяснить есть ли среди них повторяющиеся числа и найти среднее арифметическое без учета повторов

fun main() {
    val numbers = inputNumbers()
    val distinctNumbers = findDistinctNumbers(numbers)
    val average = calculateAverage(distinctNumbers)

    checkForDuplicates(numbers, distinctNumbers)
    displayResult(average)
}
// Функция для ввода списка целых чисел с проверкой на корректность ввода
fun inputNumbers(): List<Int> {
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
    return numbers
}

// Функция для поиска уникальных чисел в списке
fun findDistinctNumbers(numbers: List<Int>): List<Int> {
    return numbers.distinct()
}

// Функция для вычисления среднего арифметического уникальных чисел
fun calculateAverage(numbers: List<Int>): Double {
    return numbers.sum().toDouble() / numbers.size
}

// Функция для проверки наличия повторяющихся чисел и вывода результата
fun checkForDuplicates(originalNumbers: List<Int>, distinctNumbers: List<Int>) {
    if (originalNumbers.size != distinctNumbers.size) {
        println("Есть повторяющиеся числа")
    } else {
        println("Повторяющихся чисел нет")
    }
}

// Функция для отображения результата вычисления среднего арифметического
fun displayResult(average: Double) {
    println("Среднее арифметическое без учета повторов: $average")
}
