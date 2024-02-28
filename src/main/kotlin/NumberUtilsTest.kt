import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class NumberUtilsTest {
    
    @Test
    fun testInputNumbers() {
        val input = "1 2 3 4 5"
        System.setIn(input.byteInputStream())
        assertEquals(listOf(1, 2, 3, 4, 5), inputNumbers())
    }

    @Test
    fun testFindDistinctNumbers() {
        val numbers = listOf(1, 2, 3, 4, 5, 2, 3)
        assertEquals(listOf(1, 2, 3, 4, 5), findDistinctNumbers(numbers))
    }

    @Test
    fun testCalculateAverage() {
        val numbers = listOf(1, 2, 3, 4, 5)
        assertEquals(3.0, calculateAverage(numbers))
    }

    @Test
    fun testCheckForDuplicates_NoDuplicates() {
        val originalNumbers = listOf(1, 2, 3, 4, 5)
        val distinctNumbers = listOf(6, 7, 8, 9, 10)
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
        checkForDuplicates(originalNumbers, distinctNumbers)
        val output = outputStream.toString().trim()
        assertEquals("Повторяющихся чисел нет", output)
    }

    @Test
    fun testCheckForDuplicates_WithDuplicates() {
        val originalNumbers = listOf(1, 2, 3, 4, 5, 2, 3)
        val distinctNumbers = listOf(1, 2, 3, 4, 5)
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
        checkForDuplicates(originalNumbers, distinctNumbers)
        val output = outputStream.toString().trim()
        assertEquals("Есть повторяющиеся числа", output)
    }

    @Test
    fun testDisplayResult() {
        val average = 3.0
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
        displayResult(average)
        val output = outputStream.toString().trim()
        assertEquals("Среднее арифметическое без учета повторов: 3.0", output)
    }

}
