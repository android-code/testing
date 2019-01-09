class CalculatorTest {

    @Test
    fun checkFibonacci() {
        assertEquals(0, Calculator.fibonacci(0))
        assertEquals(1, Calculator.fibonacci(1))
        assertEquals(8, Calculator.fibonacci(6))
    }
}