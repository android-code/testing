class Calculator {

    companion object {
        tailrec fun fibonacci(n: Int, a: BigInteger = BigInteger.ZERO, b: BigInteger = BigInteger.ONE): BigInteger {
            return if (n == 0)
                a
            else
                fibonacci(n-1, b, a+b)
        }
    }
}
