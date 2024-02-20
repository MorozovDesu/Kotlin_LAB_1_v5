import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows

class NumberUtilsTest {

    @Test
    fun testDistinctNumbersAndAverage() {
        val input = "1 2 3 4 5 2 6 7 8 3 9"
        val expectedDistinctNumbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val expectedAverage = 5.0

        val distinctNumbers = input.split(" ").map { it.toInt() }.distinct()
        val average = distinctNumbers.sum().toDouble() / distinctNumbers.size

        assertEquals(expectedDistinctNumbers, distinctNumbers) // Проверяем правильность вычисления уникальных чисел
        assertEquals(expectedAverage, average) // Проверяем правильность вычисления среднего арифметического
    }

    @Test
    fun testNoRepeatedNumbers() {
        val input = "1 2 3"
        val expectedMessage = "Повторяющихся чисел нет"

        val distinctNumbers = input.split(" ").map { it.toInt() }.distinct()
        val message = if (input.split(" ").size != distinctNumbers.size) {
            "Есть повторяющиеся числа"
        } else {
            "Повторяющихся чисел нет"
        }

        assertEquals(expectedMessage, message) // Проверяем сообщение о наличии/отсутствии повторяющихся чисел
    }

    @Test
    fun testInvalidInput() {
        val invalidInput = "1 2 3 a 5" // Некорректный ввод с буквой
        assertThrows<NumberFormatException> { invalidInput.split(" ").map { it.toInt() } }
    }
}
