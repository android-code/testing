class PrintTestRule : TestRule {

    private lateinit var base: Statement
    private lateinit var description: Description

    override fun apply(base: Statement, description: Description): Statement {
        this.base = base
        this.description = description
        return PrintTestStatement(base)
    }

    class PrintTestStatement(private val base: Statement) : Statement() {
        override fun evaluate() {
            println("Log before test action")
            base.evaluate()
            println("Log after testaction")
        }
    }
}