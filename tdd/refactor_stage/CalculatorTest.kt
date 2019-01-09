class CalculatorTest {

    @Test
    fun checkFibonacci() {
        assertEquals(BigInteger.valueOf(0), Calculator.fibonacci(0))
        assertEquals(BigInteger.valueOf(1), Calculator.fibonacci(1))
        assertEquals(BigInteger.valueOf(1), Calculator.fibonacci(2))
        assertEquals(BigInteger.valueOf(8), Calculator.fibonacci(6))
    }

    @Test(expected = java.lang.IllegalArgumentException::class)
    fun checkFibonacciExceptionForMaxNegativeArg() {
        fibonacci(-1)
    }

    @Test(expected = java.lang.IllegalArgumentException::class)
    fun checkFibonacciExceptionForMinNegativeArg() {
        fibonacci(Int.MIN_VALUE)
    }

    //add more test for proper max arg value
}